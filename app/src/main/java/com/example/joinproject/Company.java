package com.example.joinproject;

public class Company {
    private int comp_num;
    private String comp_name;
    private String comp_boss;
    private String comp_email;
    private int comp_star;
    private String comp_image;
    private String comp_intro;
    private String comp_bossId;



    public Company(){}
    public String getComp_bossId() { return comp_bossId; }

    public void setComp_bossId(String comp_bossId) { this.comp_bossId = comp_bossId;  }

    public int getComp_num() {
        return comp_num;
    }

    public void setComp_num(int comp_num) {
        this.comp_num = comp_num;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getComp_boss() {
        return comp_boss;
    }

    public void setComp_boss(String comp_boss) {
        this.comp_boss = comp_boss;
    }

    public String getComp_email() {
        return comp_email;
    }

    public void setComp_email(String comp_email) {
        this.comp_email = comp_email;
    }

    public int getComp_star() {
        return comp_star;
    }

    public void setComp_star(int comp_star) {
        this.comp_star = comp_star;
    }

    public String getComp_image() {
        return comp_image;
    }

    public void setComp_image(String comp_image) {
        this.comp_image = comp_image;
    }

    public String getComp_intro() {
        return comp_intro;
    }

    public void setComp_intro(String comp_intro) {
        this.comp_intro = comp_intro;
    }
}