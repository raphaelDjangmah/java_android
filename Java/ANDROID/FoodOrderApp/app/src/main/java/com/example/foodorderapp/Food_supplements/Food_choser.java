package com.example.foodorderapp.Food_supplements;

import android.content.Context;
import android.content.Intent;

import com.example.foodorderapp.FoodOrder.Order_mainDropdown;
import com.example.foodorderapp.Foods.Food_Banku;
import com.example.foodorderapp.Foods.Food_fufu;

public class Food_choser {

    static Context context;
    private static double[] prices;
    private static int[] images;
    public static String food_chosen;

    public static double[] getPrices() {
        return prices;
    }

    public static int[] getImages() {
        return images;
    }

    public Food_choser(Context context) {
        this.context = context;
    }

    public static Intent FoodChosed(String input){

        food_chosen = input;

        switch (input){

            case "Fufu":

                prices = new Food_fufu().getPrice();
                images = new Food_fufu().getImage();
                return  (new Intent(context.getApplicationContext(), Food_chosed_gallery.class));

            case "Banku":
                prices = new Food_Banku().getPrice();
                images = new Food_Banku().getImage();
                return (new Intent(context.getApplicationContext(),Food_chosed_gallery.class));

            default:
                return  (new Intent(context.getApplicationContext(), Order_mainDropdown.class));
        }

    }

}
