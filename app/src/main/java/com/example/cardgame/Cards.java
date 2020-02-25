package com.example.cardgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Cards {
    private Resources resources;
    Bitmap card;

    public Cards(Resources resources , Bitmap card){
        this.card = card;
        this.resources = resources;
    }
}
