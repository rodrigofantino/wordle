package com.appsimple.wordable.wordable.canvas;
import android.graphics.Bitmap;

/**
 * Created by Rodrigo on 24/06/2017.
 */

public class SizeAdmin {







        public Bitmap resizeBitmap(Bitmap image, int screenWidth, int screenHeight)
        {

            Bitmap resizeBitmap = null;
            try {
                int imageHeight = image.getHeight();


                if (imageHeight > screenHeight)
                    imageHeight = screenHeight;
                int imageWidth = (imageHeight * image.getWidth())
                        / image.getHeight();

                if (imageWidth > screenWidth) {
                    imageWidth = screenWidth;
                    imageHeight = (imageWidth * image.getHeight())
                            / image.getWidth();
                }

                if (imageHeight > screenHeight)
                    imageHeight = screenHeight;
                if (imageWidth > screenWidth)
                    imageWidth = screenWidth;


                resizeBitmap = Bitmap.createScaledBitmap(image, imageWidth,
                        imageHeight, true);
            } catch (OutOfMemoryError e) {

                e.printStackTrace();
            }catch(NullPointerException e)
            {
                e.printStackTrace();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return resizeBitmap;
        }

}


