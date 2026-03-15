package com.example.task.model;

public class SearchKey {

    private String title;
    private String url;

    public SearchKey(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getKeyWord() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
