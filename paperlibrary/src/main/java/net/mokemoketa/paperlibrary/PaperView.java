package net.mokemoketa.paperlibrary;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by @mokemoketa on 16/09/03.
 */
public class PaperView extends LinearLayout{
    private Context context;
    public PaperView(Context context) {
        super(context);
        this.context = context;
    }

    public void finalAnimation(View view, int div, int dur_time){

        view.setDrawingCacheEnabled(false);
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap0 = Bitmap.createBitmap(view.getDrawingCache());
        int imageHeight = bitmap0.getHeight();
        int imageWidth = bitmap0.getWidth();
        int totalImageNum = div * 2;
        if (imageWidth % totalImageNum != 0) {
            bitmap0 = Bitmap.createBitmap(bitmap0, 0, 0, imageWidth - (imageWidth % totalImageNum), imageHeight);
        }
        int rowSize = imageWidth / totalImageNum;
        Bitmap[] imageList = new Bitmap[totalImageNum];
        int x = 0;
        int y = 0;
        for(int i = 0; i < totalImageNum; i++){
            imageList[i] = Bitmap.createBitmap(bitmap0, x, y, rowSize, imageHeight);
            x += rowSize;
        }

        View parentView = (View)view.getParent();
        this.setGravity(Gravity.CENTER);
        ImageView[] imageviewList = new ImageView[totalImageNum];
        for (int i = 0; i < totalImageNum; i++){
            imageviewList[i] = new ImageView(context);
            imageviewList[i].setImageBitmap(imageList[i]);
            this.addView(imageviewList[i]);
        }
        view.setVisibility(View.INVISIBLE);

        for(int i = 0; i < div; i++) {
            ObjectAnimator oa_left1 = ObjectAnimator.ofFloat(imageviewList[i*2], "rotationY", 0f, 90f);
            ObjectAnimator oa_left2 = ObjectAnimator.ofFloat(imageviewList[i], "translationX", 0, rowSize*(div-i-1+0.5f));
            ObjectAnimator oa_right1 = ObjectAnimator.ofFloat(imageviewList[totalImageNum - 2*i-1], "rotationY", 0f, -90f);
            ObjectAnimator oa_right2 = ObjectAnimator.ofFloat(imageviewList[totalImageNum - i-1], "translationX", 0, -rowSize*(div-i-1+0.5f));
            oa_right1.setDuration(dur_time);
            oa_right2.setDuration(dur_time);
            oa_left1.setDuration(dur_time);
            oa_left2.setDuration(dur_time);
            oa_right1.start();
            oa_right2.start();
            oa_left1.start();
            oa_left2.start();
        }

    }
}