package com.aakib.listandrecyclerview.models;

public class ReceipeModel {

    int pic;//binaryform//pixel
    String text;

    public ReceipeModel(int pic, String text) {
        this.pic = pic;
        this.text = text;
    }

    //setter and getter
    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getPic() {
        return pic;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


}
