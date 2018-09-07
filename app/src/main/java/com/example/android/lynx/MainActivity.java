package com.example.android.lynx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.android.lynx.model.Category;
import com.example.android.lynx.model.Event;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpRequester reqester = HttpRequester.getInstance();
        final HashMap<Category, List<Event>> events = new HashMap<>();

        try {
            for (Category category : Category.values()) {
                events.put(category, reqester.getEventsList(category));
            }
        } catch (IOException | ExecutionException | InterruptedException e) {
            Log.e("Error", e.getMessage());
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        final TabHost tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabContentFactory tabFactory = new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(final String tag) {
                ListView layout = findViewById(R.id.list);

                ArrayAdapter<Event> adapter = new ArrayAdapter<>(getBaseContext(),
                        android.R.layout.simple_list_item_1, events.get(Category.valueOf(tag)));

                layout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getBaseContext(), com.example.android.lynx.ArticleActivity.class);
                        intent.putExtra("Event_url", events.get(Category.valueOf(tag)).get(position).getArticle());
                        startActivity(intent);
                    }
                });

                layout.setAdapter(adapter);
                return layout;
            }
        };

        TabHost.TabSpec tabSpec;
        for (Category category : events.keySet()) {

            tabSpec = tabHost.newTabSpec(category.name());
            tabSpec.setContent(tabFactory);
            tabSpec.setIndicator(category.name());
            tabHost.addTab(tabSpec);
        }

        tabHost.setCurrentTab(0);



    }
}
