package com.example.android.lynx;

import android.util.Log;
import com.example.android.lynx.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;

public class HttpRequester {
    private static final String LINK_TO_EVENTS = "http://mikonatoruri.win/list.php?category=";
    private static final String LINK_TO_ARTICLE = "http://mikonatoruri.win/post.php?article=";
    private static ObjectMapper mapper = new ObjectMapper();


    private static HttpRequester ourInstance = new HttpRequester();
    public static HttpRequester getInstance() {
        return ourInstance;
    }
    private HttpRequester() {
    }



    public List<Event> getEventsList(Category category) throws IOException, ExecutionException, InterruptedException {
        String jsonText = execute(LINK_TO_EVENTS + category.name().toLowerCase());
        EventsWrapper eventsWrapper = mapper.readValue(mapper.getFactory().createParser(jsonText), EventsWrapper.class);
        return eventsWrapper.getEvents();
    }

    private String execute(final String url) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> response = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
                return reader.readLine();
            }
        });

        return response.get();
    }

    public Article getArticle(String url) throws ExecutionException, InterruptedException, IOException {
        Log.d("Link to arc", LINK_TO_ARTICLE + url);
        String jsonText = execute(LINK_TO_ARTICLE + url);
        mapper.readValue(mapper.getFactory().createParser(jsonText), Article.class);

        return mapper.readValue(mapper.getFactory().createParser(jsonText), Article.class);
    }
}
