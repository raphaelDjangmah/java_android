package com.example.foodorderapp.Food_supplements;

public class Food_type {

    double[] price;
    int[] images;

    public Food_type() {
        setImage(images);
        setPrice(price);

    }

    public void setPrice(double[] price){
        this.price = price;
    }

    public double[] getPrice() {
        return price;
    }

    public int[] getImage() {
        return images;
    }

    public void setImage(int[] images) {
        this.images = images;
    }
}
