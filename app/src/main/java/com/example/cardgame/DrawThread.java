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
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

public class DrawThread extends Thread {

    SurfaceHolder surfaceHolder;
    private boolean running = true;
    private Paint backPaint;
    private Paint paint;
    private int x, y, r;
    private Bitmap card;
    private ImageView image;
    private Rect rect;
    int width;
    int height;
    float scaledWidth ;
    float scaledHeight;
    Bitmap cards[];

    Bitmap output;

    Matrix matrix;
    int count = 0;


    public DrawThread(Context context, SurfaceHolder surfaceHolder, Resources resources){
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
        card = BitmapFactory.decodeResource(resources, R.drawable.card);
        width = card.getWidth();
        height = card.getHeight();
        scaledWidth = width * .7f;
        scaledHeight = height * .7f;
        matrix = new Matrix();
        cards = new Bitmap[3];







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

                    matrix.setRectToRect(new RectF(0, 0, card.getWidth(), card.getHeight()),new RectF(0,0,canvas.getWidth()/6,canvas.getHeight()/3),Matrix.ScaleToFit.FILL);
                    output = Bitmap.createBitmap(card, 0, 0, card.getWidth() ,card.getHeight() , matrix, true);

                    for (int i = 0; i < 3; i++) {
                        cards[i] = output;
                    }
                    if (count == 1){
                        canvas.drawBitmap(cards[1] , canvas.getWidth()/2-((canvas.getWidth()/6)/2) , canvas.getHeight()-(canvas.getHeight()/3) , null);
                    }
                    if (count == 2){
                        canvas.drawBitmap(cards[1] , canvas.getWidth()/2+((canvas.getWidth()/20)) , canvas.getHeight()-(canvas.getHeight()/3) , null);
                        canvas.drawBitmap(cards[1] , canvas.getWidth()/2-((canvas.getWidth()/6)) , canvas.getHeight()-(canvas.getHeight()/3) , null);
                    }
                    if (count == 3){}

                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }








            }
        }
    }}