package com.example.foodorderapp.Foods;

import com.example.foodorderapp.Food_supplements.Food_type;
import com.example.foodorderapp.R;

public class Food_Banku  extends Food_type {

    int[] image = { R.mipmap.banku_1,R.mipmap.banku_2,R.mipmap.banku_3,
                    R.mipmap.banku_4,R.mipmap.banku_5,R.mipmap.banku_6,
                    R.mipmap.banku_7,R.mipmap.banku_8,R.mipmap.banku_9,
                    R.mipmap.banku_10
                  };
    double[] price = {12,23,11,9.5,17,14,7,6,5,9};

    public Food_Banku() {
        setImage(image);
        setPrice(price);
    }
}
