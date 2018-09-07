package com.example.android.lynx.model;


import java.util.Objects;

public class Event {

    private String title;
    private String coefficient;
    private String time;
    private String place;
    private String preview;
    private String article;


    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", coefficient='" + coefficient + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", preview='" + preview + '\'' +
                ", article='" + article + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(coefficient, event.coefficient) &&
                Objects.equals(time, event.time) &&
                Objects.equals(place, event.place) &&
                Objects.equals(preview, event.preview) &&
                Objects.equals(article, event.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, coefficient, time, place, preview, article);
    }

    public Event(){}


    public String getTitle() {
        return title;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getPreview() {
        return preview;
    }

    public String getArticle() {
        return article;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
