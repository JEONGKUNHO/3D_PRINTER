package com.example.joinproject;

public class Board {
    private String title;
    private String content;
    private String imageUrl;
    private String writer;

    public Board(){}

    Board(String title,String content, String imageUrl, String writer){
        this.title=title;
        this.content=content;
        this.imageUrl=imageUrl;
        this.writer=writer;
    }


    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }
    public String getTitle(){return  title;}
    public void setTitle(String s){this.title = title;}
    public String getContent(){return content;}
    public void setContent(String s){this.content = content;}
    public String getImageUrl(){return imageUrl;}
    public void setImageUrl(String s){this.imageUrl = imageUrl;}
}