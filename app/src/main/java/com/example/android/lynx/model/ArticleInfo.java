package com.example.android.lynx.model;

public class ArticleInfo {
    private String header;
    private String text;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ArticleInfo{" +
                "header='" + header + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
