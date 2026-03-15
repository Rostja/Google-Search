package com.example.task;

import com.example.task.service.SearchService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TaskApplicationTests {

	@Test
	void testSearchResults() throws Exception {
		SearchService service = new SearchService();

		var results = service.search("kniha");

		assertNotNull(results);
		assertTrue(results.size() > 0);
	}

}
