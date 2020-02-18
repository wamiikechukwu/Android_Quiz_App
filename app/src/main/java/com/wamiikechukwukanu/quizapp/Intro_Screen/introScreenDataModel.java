package com.wamiikechukwukanu.quizapp.Intro_Screen;

public class introScreenDataModel {
    String title, descrip;
    int screenImage;

    public introScreenDataModel(String title, String descrip, int screenImage) {
        this.title = title;
        this.descrip = descrip;
        this.screenImage = screenImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getScreenImage() {
        return screenImage;
    }

    public void setScreenImage(int screenImage) {
        this.screenImage = screenImage;
    }
}
