package com.example.task.service;

import com.example.task.model.SearchKey;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    public List<SearchKey> search(String query) throws Exception {
        String url = "https://www.google.com/search?q=" + query + "&num=10";

        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .get();

        Elements results = document.select("div.g");

        List<SearchKey> list = new ArrayList<>();

        for (Element result : results) {
            Element title = result.selectFirst("h3");
            Element link = result.selectFirst("a");

            if (title != null && link != null) {
                list.add(new SearchKey(
                        title.text(),
                        link.attr("href")
                ));
            }
        }
        return list;
    }
}
