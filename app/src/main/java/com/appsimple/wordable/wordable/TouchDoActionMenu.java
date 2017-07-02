package com.appsimple.wordable.wordable;


import android.util.Log;

import com.appsimple.wordable.wordable.canvas.DrawMainMenu;

/**
 * Created by Rodrigo on 24/06/2017.
 *
 * Esta clase se fija donde estoy tocando, despues poner en la clase de la app que tome este valor y se fije si hay algo ahi.
 */

class TouchDoActionMenu extends DrawMainMenu {


    public static void checkMenuTouch(float xTouch, float yTouch) {


        /*  ***************************************************
            ********************Check showgrid button**********
            ***************************************************
         */
        if (txtshowgridbounds.top < (int)(Math.round(yTouch)) &
                txtshowgridbounds.bottom > (int)(Math.round(yTouch)) &
                txtshowgridbounds.left < (int)(Math.round(xTouch)) &
                txtshowgridbounds.right > (int)(Math.round(xTouch)))  {

            Log.println(Log.VERBOSE,"", "*********** Draw grid ************");

            // DRAW GRID BUTTON !
            if(drawGridboolean) {
                drawGridboolean = false;
            }
            else{
                drawGridboolean = true;
            }


        }

          /*  ***************************************************
            ********************Check endless mode button*******
            ***************************************************
         */
        if (txtnewgamebounds.top < (int)(Math.round(yTouch)) &
                txtnewgamebounds.bottom > (int)(Math.round(yTouch)) &
                txtnewgamebounds.left < (int)(Math.round(xTouch)) &
                txtnewgamebounds.right > (int)(Math.round(xTouch))){


            MainActivity.gamestate = 2;


        }







    }







}

