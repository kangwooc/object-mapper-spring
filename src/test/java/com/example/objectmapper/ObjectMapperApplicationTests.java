package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("--------------");

		// Text JSON -> Object
		var objectMapper = new ObjectMapper();
		// controller req json(text) -> object
		// response object -> json(text)
		var user = new User("steve", 10, "010-1111-2222");

		// Object -> Text JSON
		// object mapper getter 활용
		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);

		// text -> object
		// need default constructor
		var objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser);
	}

}
