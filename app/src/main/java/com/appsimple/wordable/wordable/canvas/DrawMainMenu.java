package com.appsimple.wordable.wordable.canvas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


import com.appsimple.wordable.wordable.MainActivity;


/**
 * Created by Rodrigo on 25/06/2017.
 */

public class DrawMainMenu extends MainActivity {






    public static Paint txtnewgame = new Paint();
    public static Rect txtnewgamebounds = new Rect();

    public static Paint txtshowgrid = new Paint();
    public static Rect txtshowgridbounds = new Rect();



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


        txtnewgame.setColor(colorchalk);
        txtnewgame.setStyle(Paint.Style.FILL);
        txtnewgame.setTypeface(font);
        txtnewgame.setTextSize(100);

        float w = txtnewgame.measureText("ENDLESS MODE")/2;


        txtnewgame.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("ENDLESS MODE", x, y ,txtnewgame);


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

        int y = gridY * 3;
        int x = gridX * 15;
        int left, top, right, bottom;


        txtshowgrid.setColor(MainActivity.colorchalk);
        txtshowgrid.setStyle(Paint.Style.FILL);
        txtshowgrid.setTypeface(MainActivity.font);
        txtshowgrid.setTextSize(100);

        float w = txtshowgrid.measureText("SHOW GRID")/2;


        txtshowgrid.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("SHOW GRID", x, y ,txtshowgrid);


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


}
