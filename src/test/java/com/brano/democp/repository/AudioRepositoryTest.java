package com.brano.democp.repository;

import com.brano.democp.entity.Audio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AudioRepositoryTest {

    @Autowired
    private AudioRepository repository;
    @Autowired
    private TestEntityManager manager;

    @BeforeEach
    void setUp() {
    }

    @Test
    void putTooLargeFile() {
//        byte[] bytes = new byte[1024 * 1024 * 4];
//        new Random().nextBytes(bytes);
//        Audio audio = Audio.builder().audio(bytes).build();
//        long id = repository.save(audio).getAudioId();
//        Audio audio2 = repository.findById(id).get();
//        System.out.println(audio2.getAudio().length);
//
//        Assertions.assertThrows(Exception.class, () -> repository.save(audio));
    }


    @AfterEach
    void tearDown() {
    }
}