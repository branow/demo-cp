package com.brano.democp.repository;

import com.brano.democp.entity.FlashCard;
import com.brano.democp.entity.FormattedText;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FlashCardRepositoryTest {

    @Autowired
    private FlashCardRepository flashCardRepository;
    @Autowired
    private TestEntityManager manager;

    private long id;

    @BeforeEach
    void setUp() {
        FlashCard flashCard = FlashCard.builder().build();
        id = manager.persist(flashCard).getFlashCardId();
    }

    @Test
    public void whenFindById() {
        FlashCard flashCard = flashCardRepository.findById(id).get();
    }

}