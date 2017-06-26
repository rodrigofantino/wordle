package com.appsimple.wordable.wordable.canvas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.util.Log;

import com.appsimple.wordable.wordable.MainActivity;

/**
 * Created by Rodrigo on 25/06/2017.
 */

public class DrawEverything extends MainActivity {

    public static Paint txtnewgame = new Paint();
    public static Rect txtnewgamebounds = new Rect();

    public static Paint txtshowgrid = new Paint();
    public static Rect txtshowgridbounds = new Rect();

    public static Paint txtbackbutton = new Paint();
    public static Rect txtbackbuttonbounds = new Rect();

    public static boolean drawGridboolean = false;

                /*
                *****************************************************************
                *****************************************************************
                *********************** MENU PRINCIPAL **************************
                *****************************************************************
                *****************************************************************
                 */

    public static void loadMenuPrincipal(Canvas canvas) {



        drawMenuBackground(canvas);
        drawMenuTextNewGame(canvas);
        drawShowGridButton(canvas);
        if(drawGridboolean){
            drawGrid(canvas);
        }

    }

    private static void drawGrid(Canvas canvas) {

        Paint grid = new Paint();
        grid.setColor(Color.WHITE);
        float startx, starty, stopx, stopy;

        startx =  gridX;
        starty = gridY;
        stopx = screenwidth;
        stopy = screenheight;



        for (int i = 0; i < gridScaleX; i++)
        {
            canvas.drawLine(startx * i, 0, startx * i, stopy, grid);
        }

        for (int i = 0; i < gridSacleY; i++)
        {
            canvas.drawLine(0, starty * i, stopx, starty * i, grid);
        }




    }

    private static void drawMenuTextNewGame(Canvas canvas) {

        int y = gridY * 10;
        int x = gridX * 10;
        int left, top, right, bottom;


        txtnewgame.setColor(0xffffff00);
        txtnewgame.setStyle(Paint.Style.FILL);
        txtnewgame.setTypeface(Typeface.DEFAULT);
        txtnewgame.setTextSize(100);

        float w = txtnewgame.measureText("Endless Mode")/2;


        txtnewgame.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Endless Mode", x, y ,txtnewgame);


        // get text height
        Paint.FontMetrics fm = txtnewgame.getFontMetrics();
        float textHeight = fm.descent - fm.ascent;

        left = x - (int)(Math.round(w));
        top = y - (int)(Math.round(textHeight));
        right = x + (int)(Math.round(w));
        bottom = y ;


        txtnewgamebounds.set(left, top, right, bottom);

    }


    // GRID BUTTON

    private static void drawShowGridButton(Canvas canvas) {

        int y = gridY * 28;
        int x = gridX * 15;
        int left, top, right, bottom;


        txtshowgrid.setColor(0xffffff00);
        txtshowgrid.setStyle(Paint.Style.FILL);
        txtshowgrid.setTypeface(Typeface.DEFAULT);
        txtshowgrid.setTextSize(100);

        float w = txtshowgrid.measureText("Show Grid")/2;


        txtshowgrid.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Show Grid", x, y ,txtshowgrid);


        // get text height
        Paint.FontMetrics fm = txtshowgrid.getFontMetrics();
        float textHeight = fm.descent - fm.ascent;

        left = x - (int)(Math.round(w));
        top = y - (int)(Math.round(textHeight));
        right = x + (int)(Math.round(w));
        bottom = y ;


        txtshowgridbounds.set(left, top, right, bottom);

    }

    private static void drawMenuBackground(Canvas canvas) {
        canvas.drawBitmap(background, 0, 0, null);


    }


    /*
    *****************************************************************
    *****************************************************************
    ******************* MODO ENDLESS (gamemode 2) *******************
    *****************************************************************
    *****************************************************************
     */

    public static void loadEndlessMode(Canvas canvas) {

        drawMenuBackground(canvas);
        drawBackbutton(canvas);
        drawShowGridButton(canvas);
        // ACA TODAS LAC COSAS QUE DEBERIA CARGAR EN ESTE MODO

    }

    private static void drawBackbutton(Canvas canvas) {

        int y = gridY * 18;
        int x = gridX * 5;
        int left, top, right, bottom;


        txtbackbutton.setColor(0xffffff00);
        txtbackbutton.setStyle(Paint.Style.FILL);
        txtbackbutton.setTypeface(Typeface.DEFAULT);
        txtbackbutton.setTextSize(100);

        float w = txtbackbutton.measureText("Go back")/2;


        txtbackbutton.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Go back", x, y ,txtbackbutton);


        // get text height
        Paint.FontMetrics fm = txtbackbutton.getFontMetrics();
        float textHeight = fm.descent - fm.ascent;

        left = x - (int)(Math.round(w));
        top = y - (int)(Math.round(textHeight));
        right = x + (int)(Math.round(w));
        bottom = y ;


        txtbackbuttonbounds.set(left, top, right, bottom);
    }


}
