package com.appsimple.wordable.wordable.canvas;

import com.appsimple.wordable.wordable.MainActivity;


/**
 * Created by Rodrigo on 02/07/2017.
 */

public class LettersFinalRandomPositionAsigner extends DrawEndlessMode{


    public static  Object getLetraAsignPositionX(int numeroRandom){
        int xfinal = 0;
        int getLetraAsignPositionX;

        if (numeroRandom ==1) {

            xfinal = espaciodeletras1x;

        }

        if (numeroRandom ==2) {

            xfinal = espaciodeletras2x;

        }

        if (numeroRandom ==3) {

            xfinal = espaciodeletras3x;

        }

        if (numeroRandom ==4) {

            xfinal = espaciodeletras4x;

        }

        if (numeroRandom ==5) {

            xfinal = espaciodeletras5x;

        }

        if (numeroRandom ==6) {

            xfinal = espaciodeletras6x;

        }



        getLetraAsignPositionX = xfinal;

        return getLetraAsignPositionX;
    }




    public static  Object getLetraAsignPositionY(int numeroRandom){
        int yfinal = 0;
        int getLetraAsignPositionY;

        if (numeroRandom ==1) {

            yfinal = espaciodeletras1y;

        }

        if (numeroRandom ==2) {

            yfinal = espaciodeletras2y;

        }

        if (numeroRandom ==3) {

            yfinal = espaciodeletras3y;

        }

        if (numeroRandom ==4) {

            yfinal = espaciodeletras4y;

        }

        if (numeroRandom ==5) {

            yfinal = espaciodeletras5y;

        }

        if (numeroRandom ==6) {

            yfinal = espaciodeletras6y;

        }



        getLetraAsignPositionY = yfinal;

        return getLetraAsignPositionY;
    }


}

