package com.example.task.model;

public class SearchKey {

    private String keyWord;
    private String url;

    public SearchKey(String keyWord, String url) {
        this.keyWord = keyWord;
        this.url = url;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public String getUrl() {
        return url;
    }
}
