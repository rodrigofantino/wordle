package com.appsimple.wordable.wordable.canvas;

import android.graphics.Bitmap;

import com.appsimple.wordable.wordable.MainActivity;
import com.appsimple.wordable.wordable.R;

/**
 * Created by Rodrigo on 24/06/2017.
 */

public class BitmapsCreator extends ScaledFactor{








        public static Bitmap makeBackground(Bitmap background, MainActivity context, int screenwidth, int screenheight) {


            background = ScaledFactor.decodeSampledBitmapFromResource(context.getResources(),
                    R.drawable.backgroundimage, screenwidth, screenheight);

            background = ScaledFactor.scaleBitmap(background, screenwidth,
                    screenheight, true);

            return background;

        }


}
