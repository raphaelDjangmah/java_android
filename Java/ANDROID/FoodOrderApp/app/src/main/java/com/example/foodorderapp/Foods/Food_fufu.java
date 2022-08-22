package com.example.foodorderapp.Foods;

import com.example.foodorderapp.Food_supplements.Food_type;
import com.example.foodorderapp.R;

public class Food_fufu extends Food_type {

    private double price[] = {7.5,8,7.5,10,12,8,4,3.5,12};
    private int image[]     = { R.mipmap.fufu_1,R.mipmap.fufu_2,R.mipmap.fufu_3,
                                R.mipmap.intro,R.mipmap.fufu_with_tila,
                                R.mipmap.fufu_4,R.mipmap.fufu_5, R.mipmap.fufu_6,
                                R.mipmap.download
                               };

    public Food_fufu() {
        setImage(image);
        setPrice(price);
    }
}
