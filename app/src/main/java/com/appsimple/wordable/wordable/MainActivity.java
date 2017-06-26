package com.appsimple.wordable.wordable;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.TextView;

import com.appsimple.wordable.wordable.canvas.BitmapsCreator;
import com.appsimple.wordable.wordable.canvas.DrawEverything;

public class MainActivity extends Activity implements OnTouchListener{

    CanvasView v;
     public static Bitmap background; // Todos los bitmaps

    int frameRateMod = 40;
    public static int gamestate = 1; // lo creo aca pero en realidad lo tiene que buscar

    public static int gridX, gridY, screenwidth, screenheight;
    public static int gridScaleX = 20;
    public static int gridSacleY = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        v = new CanvasView(this);
        v.setOnTouchListener(this);

        Log.println(Log.VERBOSE,"", "***********Paso por Oncreate************");

        WindowManager.LayoutParams layout = getWindow().getAttributes();
        getWindow().setAttributes(layout);
        setScreenSize();
        loadBitmaps();
        loadCanvas();


    }


    // ------------------------ TOUCH LISTENER---------------------------------


    public   float ontouchx, ontouchy;

    @Override
    public boolean onTouch(View v, MotionEvent event) {


        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                Log.println(Log.VERBOSE,"", "***********Paso por aqui************");


                ontouchx = event.getX();
                ontouchy = event.getY();
                checkTouch(ontouchx, ontouchy);



                break;

            case MotionEvent.ACTION_UP:

                break;

            case MotionEvent.ACTION_MOVE:

                break;

        }

        return true; // si se pone true sigue el cursor...

    }



    // ----------------------- GET SCREEN SIZE ---------------------------------



    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void setScreenSize() {



        WindowManager wm = (WindowManager)    this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenwidth = size.x;
        screenheight = size.y - getStatusBarHeight();

        gridX = screenwidth / gridScaleX;
        gridY = screenheight / gridSacleY;

    }


    // ------------------------------ LOAD BITMAPS ( ACA LLAMO A LOS BITMAPS UNA VEZ QUE SE SU TAMAÑO Y POS ) --------------

    private void loadBitmaps() {

        background = BitmapsCreator.makeBackground(background, this, screenwidth, screenheight);

    }


    //  ------------------------Mostrar el canvas en la pantalla ------------------------


    private void loadCanvas() {


        setContentView(v);



    }



    //    ------------------ ON DESTROY y ON PAUSE ------------------------

    @Override
    public void onDestroy() {


        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }




    // -------------------------- ACA VA LA ACTIVIDAD DEL CANVAS, Y DEL RUNNABLE ---------------

    public class CanvasView extends SurfaceView implements Runnable {




        SurfaceHolder ourHolder;
        Thread ourThread = null;
        boolean isRunning = true;

        public CanvasView(Context context) {
            super(context);

            ourHolder = getHolder();

            ourThread = new Thread(this);
            ourThread.start();
        }

        public void pause() {

            isRunning = false;
            while (true) {
                try {
                    ourThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            }
            ourThread = null;
        }

        public void resume() {

            isRunning = true;
            ourThread = new Thread(this);
            ourThread.start();
        }

        /***********************************************************************************
         ***********************************************************************************
         *********************** RENDER THE GRAPHICS ***************************************
         ***********************************************************************************
         ***********************************************************************************/

        @Override
        public void run() {

            while (isRunning) {

                try {
                    Thread.sleep(frameRateMod);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

                if (!ourHolder.getSurface().isValid())
                    continue;

                Canvas canvas = ourHolder.lockCanvas();



                drawEverithing(gamestate, canvas);


                ourHolder.unlockCanvasAndPost(canvas);
            }

        }

        /***********************************************************************************
         ***********************************************************************************
         *********************** DIBUJAR TODO   SEGEUN GAMESTATE !!!!!**********************
         ***********************************************************************************
         ***********************************************************************************/


        /*
                GAME STATE 1 = Menu Principal   // agregar un Boolean para una transicion, si es true
                hacer transicion, si es false no hacerla porque ya esta hecha?



         */

        public void drawEverithing(int gamestate, Canvas canvas) {


            if (gamestate == 1) {

                DrawEverything.loadMenuPrincipal(canvas);
            }


            if (gamestate == 2){

                DrawEverything.loadEndlessMode(canvas);
            }

        }


    }



    private void checkTouch(float xTouch, float yTouch) {

        if(gamestate == 1){

            TouchDoAction.checkMenuTouch(xTouch, yTouch);

        }

        if(gamestate == 2){

            TouchDoAction.checkEndlessTouch(xTouch, yTouch);

        }


    }

}






