package com.example.joinproject;

public class Review2 {
    private String title;
    private String content;
    private String imageUrl;
    private String writer;
    private String date;

    public Review2(){}

    Review2(String title, String content, String imageUrl, String writer, String date){
        this.title=title;
        this.content=content;
        this.imageUrl=imageUrl;
        this.writer=writer;
        this.date=date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String writer) {
        this.date = writer;
    }



}