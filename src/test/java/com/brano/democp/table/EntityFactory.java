package com.brano.democp.table;

import com.brano.democp.entity.*;
import com.brano.democp.entity.auxilary.Access;

import java.util.Random;

public class EntityFactory {


    public static Image image() {
        Random random = new Random(identifier());
        int size = random.nextInt(0, 10_000);
        byte[] bytes = new byte[size];
        random.nextBytes(bytes);
        return Image.builder().image(bytes).build();
    }

    public static Audio audio() {
        Random random = new Random(identifier());
        int size = random.nextInt(0, 10_000);
        byte[] bytes = new byte[size];
        random.nextBytes(bytes);
        return Audio.builder().audio(bytes).build();
    }

    public static AccessType accessTypePublic() {
        return AccessType.builder().access(Access.PUBLIC).build();
    }


    public static AccessType accessTypePrivate() {
        return AccessType.builder().access(Access.PRIVATE).build();
    }

    public static VerificationToken verificationTokenWithUser() {
        int id = identifier();
        return VerificationToken.builder()
                .token("token" + id)
                .user(user())
                .build();
    }

    public static VerificationToken verificationToken() {
        int id = identifier();
        return VerificationToken.builder()
                .token("token" + id)
                .build();
    }

    public static User user() {
        int id = identifier();
        return User.builder()
                .userName("user" + id)
                .email("email" + id + "@gmail.com")
                .password("pas" + id)
                .description("description" + id)
                .build();
    }

    public static int identifier() {
        return (short) System.nanoTime();
    }
}
