package com.example.cardgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;


public class Cards {
    private Resources resources;
    Bitmap card;
     ArrayList<Bitmap> cardi = new ArrayList<>();

    public Cards(Resources resources , Bitmap card){
        this.card = card;
        this.resources = resources;
        cardi.add(card);
    }
    public Bitmap retCard(int i){
        return cardi.get(i);
    }
}
