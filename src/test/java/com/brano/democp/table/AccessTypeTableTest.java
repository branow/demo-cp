package com.brano.democp.table;

import com.brano.democp.entity.AccessType;
import com.brano.democp.entity.auxilary.Access;
import com.brano.democp.repository.AccessTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;

import static com.brano.democp.table.EntityFactory.accessTypePrivate;

@SpringBootTest
public class AccessTypeTableTest extends TableTest<AccessType, Long>{

    @Autowired
    public AccessTypeTableTest(AccessTypeRepository repository) {
        super(repository, AccessType.class, AccessType::getAccessTypeId);
    }

    @Test
    void accessMustBeNotNull() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustBeNotNull(accessTypePrivate(), "access", Access.class);
    }

    @Test
    void accessMustBeUnique() {
        tableMustAcceptValue(accessTypePrivate());
        tableMustNotAcceptValue(accessTypePrivate());
    }

}
