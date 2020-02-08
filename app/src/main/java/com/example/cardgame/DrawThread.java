package com.example.cardgame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawThread extends Thread {

    SurfaceHolder surfaceHolder;
    private boolean running = true;
    private Paint backPaint;
    private Paint paint;
    private int x, y, r;
    private Bitmap card;
  //  Path path;
    Matrix matrix;

    public DrawThread(Context context, SurfaceHolder surfaceHolder, Resources resources){
        this.surfaceHolder = surfaceHolder;

        x = 0;
        y = 0;
        r = 110;

        backPaint = new Paint();
        backPaint.setStyle(Paint.Style.FILL);
        backPaint.setColor(Color.BLACK);
     //   path = new Path();
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        card = BitmapFactory.decodeResource(resources, R.drawable.card);
        matrix = new Matrix();





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
                    //canvas.drawCircle(x, y, r, paint);

                   // matrix.setRotate(90,x,y);
                   // path.transform(matrix);

                    matrix.setTranslate(x-210,y-130);

                    canvas.drawBitmap(card,matrix,paint);

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