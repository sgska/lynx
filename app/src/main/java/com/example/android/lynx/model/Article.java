package com.example.android.lynx.model;


import java.util.List;

public class Article {
    private String team1;
    private String team2;
    private String time;
    private String tournament;
    private String place;
    private List<ArticleInfo> article;
    private String prediction;


    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<ArticleInfo> getArticle() {
        return article;
    }

    public void setArticle(List<ArticleInfo> article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Article{" +
                "team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", time='" + time + '\'' +
                ", tournament='" + tournament + '\'' +
                ", place='" + place + '\'' +
                ", article=" + article +
                ", prediction='" + prediction + '\'' +
                '}';
    }
}
