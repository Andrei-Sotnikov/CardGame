package com.example.cardgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawThread extends Thread {
    private SurfaceHolder surfaceHolder;
   private boolean running = true;



    public DrawThread(Context context, SurfaceHolder holder) {
        this.surfaceHolder = surfaceHolder;


    }





    public void requestStop() {
        running = false;
    }



    @Override
    public void run() {

    }
}

