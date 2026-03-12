package com.example.task.controller;

import com.example.task.model.SearchKey;
import com.example.task.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public List<SearchKey> search(@RequestParam String q) throws Exception {
        return searchService.search(q);
    }

}
