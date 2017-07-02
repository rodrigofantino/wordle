package com.appsimple.wordable.wordable.canvas;

import android.graphics.Canvas;

import com.appsimple.wordable.wordable.MainActivity;

/**
 * Created by Rodrigo on 02/07/2017.
 */

public class AnimationClass extends MainActivity {

    public static Object getSimpleAnimationX(int xinicial, int xfinal) {

        int simpleAnimationX;

        if (xinicial < xfinal){

            xinicial = xinicial + (xfinal - xinicial)/2;
        }

        if (xinicial > xfinal){

            xinicial = xinicial + (xinicial - xfinal)/2 ;
        }


         simpleAnimationX = xinicial;

        return simpleAnimationX;
    }

    public static Object getSimpleAnimationY(int yinicial, int yfinal) {

        int simpleAnimationY ;

        if (yinicial < yfinal){

           yinicial = yinicial + (yfinal - yinicial)/2;
        }

        if (yinicial > yfinal){

            yinicial = yinicial + (yinicial - yfinal)/2 ;
        }

        simpleAnimationY = yinicial;

        return simpleAnimationY;
    }


}
