package com.example.joinproject;

public class Board {
    private String title;
    private String content;
    private String imageUrl;
    private String writer;
    private String date;
    private String phone;
    private int complete;  //0이면 의뢰안된 상태 1이면 의뢰완료

    public Board(){}

    Board(String title,String content, String imageUrl, String writer, String date , String phone){
        this.title=title;
        this.content=content;
        this.imageUrl=imageUrl;
        this.writer=writer;
        this.date=date;
        this.phone=phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getComplete() { return complete; }

    public void setComplete(int complete) { this.complete = complete; }

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