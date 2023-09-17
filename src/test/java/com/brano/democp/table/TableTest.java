package com.brano.democp.table;

import com.brano.democp.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TableTest<T, ID> {

    protected final JpaRepository<T, ID> repository;
    protected final List<ID> toDelete = new ArrayList<>();
    private final Function<T, ID> getID;
    private final Class<T> tClass;

    public TableTest(JpaRepository<T, ID> repository, Class<T> tClass, Function<T, ID> getID) {
        this.repository = repository;
        this.getID = getID;
        this.tClass = tClass;
    }

    @AfterEach
    void tearDown() {
        toDelete.stream().filter(repository::existsById)
                .forEach(repository::deleteById);
        toDelete.clear();
    }


    <S> void columnMustHaveDefaultValueEquals(T o, String fieldName, S value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getter = getter(fieldName);
        T oSaved = save(o);
        Object result = getter.invoke(oSaved);
        Assertions.assertEquals(value, result);
    }

    void columnMustHaveDefaultValue(T o, String fieldName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getter = getter(fieldName);
        T oSaved = save(o);
        Object result = getter.invoke(oSaved);
        Assertions.assertNotNull(result);
    }

    void columnMustBeLessThan(T o, String fieldName, int length) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        columnMustNotAcceptValue(o, fieldName, "a".repeat(length + 1));
    }

    <S> void columnMustBeNotNull(T o, String fieldName, Class<S> fieldType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String name = upperFirstLetter(fieldName);
        Method setter = setter(name, fieldType);
        setter.invoke(o, (S) null);
        tableMustNotAcceptValue(o);
    }

    <S> void columnMustNotAcceptValue(T o, String fieldName, S value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String name = upperFirstLetter(fieldName);
        Method setter = tClass.getMethod("set" + name, value.getClass());
        setter.invoke(o, value);
        tableMustNotAcceptValue(o);
    }

    <S> void columnMustAcceptValue(T o, String fieldName, S value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String name = upperFirstLetter(fieldName);
        Method setter = tClass.getMethod("set" + name, value.getClass());
        setter.invoke(o, value);
        tableMustAcceptValue(o);
    }


    <S> void columnMustBeUnique(T o1, T o2, String fieldName, Class<S> fieldType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String name = upperFirstLetter(fieldName);
        Method setter = setter(name, fieldType);
        Method getter = getter(name);
        setter.invoke(o1, getter.invoke(o2));
        tableMustAcceptValue(o1);
        tableMustNotAcceptValue(o2);
    }


    void tableMustAcceptValue(T o) {
        save(o);
    }

    void tableMustNotAcceptValue(T o) {
        Assertions.assertThrows(Exception.class, () -> save(o));
    }

    T save(T object) {
        T objectSaved = repository.save(object);
        toDelete.add(getID.apply(objectSaved));
        return objectSaved;
    }

    <S> Method setter(String fieldName, Class<S> fieldType) throws NoSuchMethodException {
        return tClass.getMethod("set" + upperFirstLetter(fieldName), fieldType);
    }

    Method getter(String fieldName) throws NoSuchMethodException {
        return tClass.getMethod("get" + upperFirstLetter(fieldName));
    }

    String upperFirstLetter(String str) {
        return str.toUpperCase().charAt(0) + str.substring(1);
    }

}
