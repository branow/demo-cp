package com.brano.democp.table;

import com.brano.democp.entity.User;
import com.brano.democp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static com.brano.democp.table.EntityFactory.user;

@SpringBootTest
public class UserTableTest extends TableTest<User, Long> {

    @Autowired
    public UserTableTest(UserRepository repository) {
        super(repository, User.class, User::getUserId);
    }

    @Test
    void tableMustAccept() {
        tableMustAcceptValue(user());
    }

    @ParameterizedTest
    @MethodSource("provideUserNameMustNotAcceptValue")
    <S> void userNameMustNotAcceptValue(String value) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustNotAcceptValue(user(), "userName", value);
    }

    @ParameterizedTest
    @MethodSource("provideEmailMustNotAcceptValue")
    <S> void emailMustNotAcceptValue(String value) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustNotAcceptValue(user(), "email", value);
    }

    @ParameterizedTest
    @MethodSource("provideEmailMustAcceptValue")
    <S> void emailMustAcceptValue(String value) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustAcceptValue(user(), "email", value);
    }

    @ParameterizedTest
    @MethodSource("provideColumnMustBeUnique")
    <S> void columnMustBeUnique(String fieldName, Class<S> fieldType) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustBeUnique(user(), user(), fieldName, fieldType);
    }

    @ParameterizedTest
    @MethodSource("provideColumnMustBeLessThan")
    void columnMustBeLessThan(String fieldName, int length) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        columnMustBeLessThan(user(), fieldName, length);
    }

    @ParameterizedTest
    @MethodSource("provideColumnMustBeNotNull")
    <S> void columnMustBeNotNull(String fieldName, Class<S> fieldType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        columnMustBeNotNull(user(), fieldName, fieldType);
    }


    private static Stream<Arguments> provideColumnMustBeUnique() {
        return Stream.of(
                Arguments.of("userName", String.class),
                Arguments.of("email", String.class)
        );
    }

    private static Stream<Arguments> provideColumnMustBeLessThan() {
        return Stream.of(
                Arguments.of("userName", 50),
                Arguments.of("email", 320),
                Arguments.of("password", 60),
                Arguments.of("description", 300)
        );
    }

    private static Stream<Arguments> provideColumnMustBeNotNull() {
        return Stream.of(
                Arguments.of("userName", String.class),
                Arguments.of("email", String.class),
                Arguments.of("password", String.class)
        );
    }


    private static Stream<Arguments> provideEmailMustAcceptValue() {
        return Stream.of(
                Arguments.of("email@example.com"),
                Arguments.of("firstname.lastname@example.com"),
                Arguments.of("email@subdomain.example.com"),
                Arguments.of("firstname+lastname@example.com"),
                Arguments.of("email@123.123.123.123"),
                Arguments.of("email@[123.123.123.123]"),
                Arguments.of("1234567890@example.com")
        );
    }


    private static Stream<Arguments> provideEmailMustNotAcceptValue() {
        return Stream.of(
                Arguments.of("plainaddress"),
                Arguments.of("#@%^%#$@#$@#.com"),
                Arguments.of("@example.com"),
                Arguments.of("Joe Smith <email@example.com>"),
                Arguments.of("email@example@example.com"),
                Arguments.of(".email@example.com"),
                Arguments.of("email.@example.com")
        );
    }

    private static Stream<Arguments> provideUserNameMustNotAcceptValue() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("   "),
                Arguments.of("\n"),
                Arguments.of("\t"),
                Arguments.of("  \n  \t ")
        );
    }

}
