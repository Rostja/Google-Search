package com.example.task;

import com.example.task.service.SearchService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskApplicationTests {

	@Test
	void testSearchResults() throws Exception {
		SearchService service = new SearchService();

		var results = service.search("kniha");

		assertNotNull(results);
		assertFalse(results.isEmpty());
		assertNotNull(results.get(0).getUrl());
	}

}
