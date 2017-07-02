package com.appsimple.wordable.wordable.canvas;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.appsimple.wordable.wordable.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Rodrigo on 02/07/2017.
 */

public class DrawEndlessMode extends MainActivity {

    public static Paint txtshowgrid = new Paint();
    public static Rect txtshowgridbounds = new Rect();
    public static boolean drawGridboolean = false;

    public static int espaciodeletras1x, espaciodeletras1y;
    public static int espaciodeletras2x, espaciodeletras2y;
    public static int espaciodeletras3x, espaciodeletras3y;
    public static int espaciodeletras4x, espaciodeletras4y;
    public static int espaciodeletras5x, espaciodeletras5y;
    public static int espaciodeletras6x, espaciodeletras6y;



    public static int letterrandomnumber, letra1random, letra2random, letra3random, letra4random, letra5random, letra6random;

    public static Paint txtbackbutton = new Paint();
    public static Rect txtbackbuttonbounds = new Rect();

    public static Paint txtbtnscramble = new Paint();
    public static Rect txtbtnscramblebounds = new Rect();

    public static Paint txtletter1 = new Paint();
    public static Rect txtletter1bounds = new Rect();

    public static Paint txtletter2 = new Paint();
    public static Rect txtletter2bounds = new Rect();

    public static Paint txtletter3 = new Paint();
    public static Rect txtletter3bounds = new Rect();

    public static Paint txtletter4 = new Paint();
    public static Rect txtletter4bounds = new Rect();

    public static Paint txtletter5 = new Paint();
    public static Rect txtletter5bounds = new Rect();

    public static Paint txtletter6 = new Paint();
    public static Rect txtletter6bounds = new Rect();


    /*
    *****************************************************************
    *****************************************************************
    ******************* MODO ENDLESS (gamemode 2) *******************
    *****************************************************************
    *****************************************************************
     */

    public static void loadEndlessMode(Canvas canvas) {

        palabra = "WORDLE";  // ACA DEBERIA BUScAR En UNA BASE DE DATOS UNA
        // /PALABRA DE 6 LETRAS DE FORMA ALEATORIA tampoco deberia ir aca porque, es una cosa que depende de MAIN ACTIVITY


        asignarUnEspacioParaCadaLetra();
        getLettersfromWord();
        drawEndlessBackground(canvas);
        drawBackbutton(canvas);
        drawShowGridButton(canvas);
        drawLetters(canvas);
        drawBtnScramble(canvas);




        // ACA TODAS LAC COSAS QUE DEBERIA CARGAR EN ESTE MODO

    }

    private static void asignarUnEspacioParaCadaLetra() {

        int y = gridY * 30;
        int xoffset = gridX * 2;
        espaciodeletras1y  = y;
        espaciodeletras2y  = y;
        espaciodeletras3y  = y;
        espaciodeletras4y  = y;
        espaciodeletras5y  = y;
        espaciodeletras6y  = y;


        espaciodeletras1x = gridX + xoffset +  2 * gridX * 1;
        espaciodeletras2x = gridX + xoffset +  2 * gridX * 2;
        espaciodeletras3x = gridX + xoffset +  2 * gridX * 3;
        espaciodeletras4x = gridX + xoffset +  2 * gridX * 4;
        espaciodeletras5x = gridX + xoffset +  2 * gridX * 5;
        espaciodeletras6x = gridX + xoffset +  2 * gridX * 6;


    }



    private static void drawShowGridButton(Canvas canvas) {

        int y = gridY * 3;
        int x = gridX * 15;
        int left, top, right, bottom;


        txtshowgrid.setColor(colorchalk);
        txtshowgrid.setStyle(Paint.Style.FILL);
        txtshowgrid.setTypeface(font);
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

    private static void drawEndlessBackground(Canvas canvas) {
        canvas.drawBitmap(background, 0, 0, null);


    }

    private static void getLettersfromWord() {


        randomLetters();
    }


    protected static void randomLetters() {

        if (shouldscramble){
            scrambleLetteers();}

        letra1 = palabra.substring(0 , 1);
        letra2 = palabra.substring(1, 2);
        letra3 = palabra.substring(2, 3);
        letra4 = palabra.substring(3, 4);
        letra5 = palabra.substring(4, 5);
        letra6 = palabra.substring(5, 6);
    }

    private static void drawBtnScramble(Canvas canvas) {

        int y = gridY * 25;
        int x = gridX * 5;
        int left, top, right, bottom;


        txtbtnscramble.setColor(colorchalk);
        txtbtnscramble.setStyle(Paint.Style.FILL);
        txtbtnscramble.setTypeface(font);
        txtbtnscramble.setTextSize(gridY * 3/2);

        float w = txtbtnscramble.measureText("SCRAMBLE")/2;


        txtbtnscramble.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("SCRAMBLE", x, y ,txtbtnscramble);


        // get text height
        Paint.FontMetrics fm = txtbtnscramble.getFontMetrics();
        float textHeight = fm.descent - fm.ascent;

        left = x - (int)(Math.round(w));
        top = y - (int)(Math.round(textHeight));
        right = x + (int)(Math.round(w));
        bottom = y ;


        txtbtnscramblebounds.set(left, top, right, bottom);



    }


    private static void drawBackbutton(Canvas canvas) {

        int y = gridY * 18;
        int x = gridX * 5;
        int left, top, right, bottom;


        txtbackbutton.setColor(colorchalk);
        txtbackbutton.setStyle(Paint.Style.FILL);
        txtbackbutton.setTypeface(font);
        txtbackbutton.setTextSize(100);

        float w = txtbackbutton.measureText("GO BACK")/2;


        txtbackbutton.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("GO BACK", x, y ,txtbackbutton);


        // get text height
        Paint.FontMetrics fm = txtbackbutton.getFontMetrics();
        float textHeight = fm.descent - fm.ascent;

        left = x - (int)(Math.round(w));
        top = y - (int)(Math.round(textHeight));
        right = x + (int)(Math.round(w));
        bottom = y ;


        txtbackbuttonbounds.set(left, top, right, bottom);
    }


    private static void drawLetters(Canvas canvas) {

        getLettersPosition();
        drawEachLetter(canvas, txtletter1bounds, txtletter1, letra1x0, letra1y0, letra1, 1);
        drawEachLetter(canvas, txtletter2bounds, txtletter2, letra2x0, letra2y0, letra2, 2);
        drawEachLetter(canvas, txtletter3bounds, txtletter3, letra3x0, letra3y0, letra3, 3);
        drawEachLetter(canvas, txtletter4bounds, txtletter4, letra4x0, letra4y0, letra4, 4);
        drawEachLetter(canvas, txtletter5bounds, txtletter5, letra5x0, letra5y0, letra5, 5);
        drawEachLetter(canvas, txtletter6bounds, txtletter6, letra6x0, letra6y0, letra6, 6);






    }

    public static void scrambleLetteers() {

        Random rng = new Random(); // Ideally just create one instance globally
        List<Integer> generated = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++)
        {
            while(true)
            {
                Integer next = rng.nextInt(6) + 1;
                if (!generated.contains(next))
                {
                    // Done for this iteration
                    if (i +1 ==1){
                        letra1random = next;
                    }
                    if (i +1 ==2){
                        letra2random = next;
                    }
                    if (i +1 ==3){
                        letra3random = next;
                    }
                    if (i +1 ==4){
                        letra4random = next;
                    }
                    if (i +1 ==5){
                        letra5random = next;
                    }
                    if (i +1 ==6){
                        letra6random = next;
                    }

                    generated.add(next);
                    break;
                }
            }
        }
        shouldscramble = false;

    }

    private static void getLettersPosition() {

        letra1xf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionX(letra1random);
        letra1yf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionY(letra1random);
        letra2xf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionX(letra2random);
        letra2yf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionY(letra2random);
        letra3xf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionX(letra3random);
        letra3yf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionY(letra3random);
        letra4xf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionX(letra4random);
        letra4yf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionY(letra4random);
        letra5xf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionX(letra5random);
        letra5yf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionY(letra5random);
        letra6xf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionX(letra6random);
        letra6yf = (int) LettersFinalRandomPositionAsigner.getLetraAsignPositionY(letra6random);


    }


    private static void drawEachLetter(Canvas canvas, Rect bounds, Paint paint, int posx, int posy, String letter, int letternumber) {

        int left, top, right, bottom;

        paint.setColor(colorchalk);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(font);
        paint.setTextSize(gridY * 3);

        float w = paint.measureText(letter)/2;


        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(letter, posx, posy ,paint);


        // get text height
        Paint.FontMetrics fm = paint.getFontMetrics();
        float textHeight = fm.descent - fm.ascent;

        left = posx - (int)(Math.round(w));
        top = posy - (int)(Math.round(textHeight));
        right = posx + (int)(Math.round(w));
        bottom = posy ;


        bounds.set(left, top, right, bottom);

        if (letternumber == 1){
            txtletter1bounds = bounds;

        }
        if (letternumber == 2){
            txtletter2bounds = bounds;

        }
        if (letternumber == 3){
            txtletter3bounds = bounds;

        }
        if (letternumber == 4){
            txtletter4bounds = bounds;
        }
        if (letternumber == 5){
            txtletter5bounds = bounds;

        }
        if (letternumber == 6){
            txtletter6bounds = bounds;
        }


    }

}
