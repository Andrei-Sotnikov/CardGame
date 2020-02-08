package com.example.cardgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawThread extends Thread {

    SurfaceHolder surfaceHolder;
    private boolean running = true;
    private Paint backPaint;
    private Paint paint;
    private int x, y, r;

    public DrawThread(Context context, SurfaceHolder surfaceHolder){
        this.surfaceHolder = surfaceHolder;

        x = 0;
        y = 0;
        r = 110;

        backPaint = new Paint();
        backPaint.setStyle(Paint.Style.FILL);
        backPaint.setColor(Color.BLACK);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void stopRequest(){
        running = false;
    }

    @Override
    public void run() {

        while (running){
            Canvas canvas = surfaceHolder.lockCanvas();
            if(canvas != null){
                try{
                    canvas.drawPaint(backPaint);
                    canvas.drawCircle(x, y, r, paint);

                    Thread.sleep(1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }







                
            }
        }
    }




}