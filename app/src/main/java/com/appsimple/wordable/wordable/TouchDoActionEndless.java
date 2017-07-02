package com.appsimple.wordable.wordable;

import android.util.Log;

import com.appsimple.wordable.wordable.canvas.DrawEndlessMode;

/**
 * Created by Rodrigo on 02/07/2017.
 */

public class TouchDoActionEndless extends DrawEndlessMode {
    public static void checkEndlessTouch(float xTouch, float yTouch) {


        /*  ***************************************************
            ********************Check showgrid button**********
            ***************************************************
         */
        if (txtshowgridbounds.top < (int)(Math.round(yTouch)) &
                txtshowgridbounds.bottom > (int)(Math.round(yTouch)) &
                txtshowgridbounds.left < (int)(Math.round(xTouch)) &
                txtshowgridbounds.right > (int)(Math.round(xTouch))) {

            Log.println(Log.VERBOSE, "", "*********** Draw grid ************");

            // DRAW GRID BUTTON !
            if (drawGridboolean) {
                drawGridboolean = false;
            } else {
                drawGridboolean = true;
            }
        }
        if (txtbtnscramblebounds.top < (int)(Math.round(yTouch)) &
                txtbtnscramblebounds.bottom > (int)(Math.round(yTouch)) &
                txtbtnscramblebounds.left < (int)(Math.round(xTouch)) &
                txtbtnscramblebounds.right > (int)(Math.round(xTouch))){
            Log.println(Log.VERBOSE,"", "*********** SCRAMBLE IT ************");
            shouldscramble = true;

        }


          /*  ***************************************************
            ********************Check endless mode button*******
            ***************************************************
         */

        if (txtbackbuttonbounds.top < (int)(Math.round(yTouch)) &
                txtbackbuttonbounds.bottom > (int)(Math.round(yTouch)) &
                txtbackbuttonbounds.left < (int)(Math.round(xTouch)) &
                txtbackbuttonbounds.right > (int)(Math.round(xTouch))){

            Log.println(Log.VERBOSE,"", "*********** Go back ************");

            MainActivity.gamestate = 1;




        }









    }
}
