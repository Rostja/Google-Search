package com.example.task.service;

import com.example.task.model.SearchKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.json.*;


import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class SearchService {

    @Value("${serpapi.key}")
    private String apiKey;


    public List<SearchKey> search(String query) throws Exception {


        String url =
                "https://serpapi.com/search.json?q="
                        + URLEncoder.encode(query, StandardCharsets.UTF_8)
                        + "&api_key=" + apiKey;

        InputStream input = new URL(url).openStream();
        String json = new Scanner(input, "UTF-8").useDelimiter("\\A").next();

        JSONObject data = new JSONObject(json);

        List<SearchKey> list = new ArrayList<>();

        if (data.has("organic_results")) {

            JSONArray items = data.getJSONArray("organic_results");

            for (int i = 0; i < items.length(); i++) {

                JSONObject item = items.getJSONObject(i);

                list.add(new SearchKey(
                        item.getString("title"),
                        item.getString("link")
                ));
            }
        }

        return list;
    }
}
