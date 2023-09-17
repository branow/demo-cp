package com.brano.democp;

import com.brano.democp.entity.FlashCard;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoCpApplicationTests {


	@Test
	void contextLoads() {

		FlashCard flashCard = FlashCard.builder().build();

	}

}
