package com.example.android.lynx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android.lynx.model.Article;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        HttpRequester reqester = HttpRequester.getInstance();

        Intent intent = getIntent();
        LinearLayout layout = findViewById(R.id.ArticleLayout);
        layout.removeAllViews();
        TextView textView = new TextView(this);
        try {

            Article article = reqester.getArticle(intent.getExtras().get("Event_url").toString());
            Log.d("Article", article.toString());

            textView.setText(article.toString());
            textView.setMovementMethod(new ScrollingMovementMethod());
        } catch (ExecutionException | InterruptedException | IOException e) {
            Log.e("Error", e.getMessage());
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        layout.addView(textView);
    }


}
