package com.brano.democp.table;

import com.brano.democp.entity.User;
import com.brano.democp.entity.VerificationToken;
import com.brano.democp.repository.UserRepository;
import com.brano.democp.repository.VerificationTokenRepository;
import com.brano.democp.service.VerificationTokenService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.brano.democp.table.EntityFactory.*;

@SpringBootTest
public class VerificationTokenTableTest extends TableTest<VerificationToken, Long> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VerificationTokenService verificationTokenService;

    private final List<Long> toDeleteUsers = new ArrayList<>();

    @Autowired
    public VerificationTokenTableTest(VerificationTokenRepository repository) {
        super(repository, VerificationToken.class, VerificationToken::getUserId);
    }

    @Override
    @AfterEach
    void tearDown() {
        super.tearDown();
        toDeleteUsers.stream().filter(userRepository::existsById)
                .forEach(userRepository::deleteById);
        toDeleteUsers.clear();
    }

    @Override
    VerificationToken save(VerificationToken verificationToken) {
        VerificationToken saved = super.save(verificationToken);
        toDeleteUsers.add(saved.getUserId());
        return saved;
    }

    @Test
    void userMustNotBeDeletedWithTokenDeleting() {
        VerificationToken saved = save(verificationTokenWithUser());
        repository.deleteById(saved.getUserId());
        toDelete.remove(saved.getUserId());
        Assertions.assertTrue(userRepository.existsById(saved.getUserId()));
        Assertions.assertFalse(repository.existsById(saved.getUserId()));
    }

    @Test
    void tokenMustBeDeletedWithUserDeleting() {
        VerificationToken saved = save(verificationTokenWithUser());
        userRepository.deleteById(saved.getUserId());
        toDeleteUsers.remove(saved.getUserId());
        Assertions.assertFalse(repository.existsById(saved.getUserId()));
        Assertions.assertFalse(userRepository.existsById(saved.getUserId()));
    }

    @Test
    void tableMustAcceptVerificationTokenWithUser() {
        tableMustAcceptValue(verificationTokenWithUser());
    }

    @Test
    void tableMustNotAcceptVerificationTokenWithoutUser() {
        tableMustNotAcceptValue(verificationToken());
    }

    @Test
    void expirationTimeMustHaveDefaultValue() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustHaveDefaultValue(verificationTokenWithUser(), "expirationTime");
    }

    @Test
    void tokenMustBeNotNull() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        columnMustBeNotNull(verificationTokenWithUser(), "token", String.class);
    }

    @Test
    void tokenMustBeLessThan36() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustBeLessThan(verificationTokenWithUser(), "token", 36);
    }

    @Test
    void tokenMustBeUnique() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        columnMustBeUnique(verificationTokenWithUser(), verificationTokenWithUser(), "token", String.class);
    }





//    @Test
//    void oneUserCanHaveTwoTokensCheck() {
//        User user = User.builder()
//                .userName("orest")
//                .email("orest@gmail.com")
//                .password("asdfafd")
//                .build();
//
//        VerificationToken token1 = VerificationToken.builder()
//                .token(UUID.randomUUID().toString())
//                .user(user)
//                .build();
//
//        VerificationToken token2 = VerificationToken.builder()
//                .token(UUID.randomUUID().toString())
//                .user(user)
//                .build();
//
//        long id1 = verificationTokenRepository.save(token1).getUser().getUserId();
//        userIdsToDelete.add(id1);
//        tokenIdsToDelete.add(id1);
//
//        try {
//            long id2 = verificationTokenRepository.save(token2).getUser().getUserId();
//            userIdsToDelete.add(id2);
//            tokenIdsToDelete.add(id2);
//            throw new IllegalStateException("Test was failed: second token was saved");
//        } catch (HibernateException e) {
//
//        }
//    }
}
