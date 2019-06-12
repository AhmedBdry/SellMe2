package com.example.sellme;

public class Cars  {

    private int img;
    private String itemNames ;

    public Cars(int img, String itemNames) {
        this.img = img;
        this.itemNames = itemNames;
    }

    public int getImg() {
        return img;
    }

    public String getItemNames() {
        return itemNames;
    }
}
