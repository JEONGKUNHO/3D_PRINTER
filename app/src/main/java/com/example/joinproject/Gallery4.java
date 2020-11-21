package com.example.joinproject;

public class Gallery4 {
    private String title;
    private String image;
    private String content;
    private String author;
    private String date;
    private String company_name;


    public Gallery4(){}
    Gallery4(String title,String content, String image, String author, String date){
        this.title=title;
        this.content=content;
        this.image=image;
        this.author=author;
        this.date=date;
    }    public String getCompany_name() { return company_name; }

    public void setCompany_name(String company_name) { this.company_name = company_name; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
}
