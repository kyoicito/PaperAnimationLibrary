package net.mokemoketa.paperlibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Kyoichi Ito on 16/09/03.
 */
public class PaperView{

    //コンストラクタ群
    public PaperView() {

    }

    //初期化
    private void init(Context context, AttributeSet attrs) {
        //set an animation listener

    }

    //アニメーション部
    public void finalAnimation(View view, int div){
        /*
        int viewcount = this.getChildCount();
        for(int i = 0; i < this.getChildCount(); i++) {
            View targetView = this.getChildAt(i);
            AnimationSet set = new AnimationSet(true);

            TranslateAnimation animation_translate = new TranslateAnimation(0,  this.getWidth() / (viewcount/2 - i), 0, 0);
            set.addAnimation(animation_translate);

            ScaleAnimation animation_scale = new ScaleAnimation(1, 0.01f, 1, 1);
            set.addAnimation(animation_scale);

            set.setDuration(2000);
            targetView.startAnimation(set);
        }
        */
        //キャッシュクリア
        view.setDrawingCacheEnabled(false);
        view.setDrawingCacheEnabled(true);
        //viewをbitmapにして分割
        Bitmap bitmap0 = Bitmap.createBitmap(view.getDrawingCache());
        int imageHeight = bitmap0.getHeight();
        int imageWidth = bitmap0.getWidth();
        if (imageWidth % (div * 2) != 0) {
            bitmap0 = Bitmap.createBitmap(bitmap0, 0, 0, imageWidth, imageHeight);
        }
        int rowSize = imageWidth / (div * 2);
        int totalImageNum = div * 2;
        Bitmap[] imageList = new Bitmap[totalImageNum];
        int x = 0;
        int y = 0;
        for(int i = 0; i < totalImageNum; i++){
            imageList[i] = Bitmap.createBitmap(bitmap0, x, y, rowSize, imageHeight);
            x += rowSize;
        }
        //bitmapからImageView
        for (int i = 0; i < totalImageNum; i++){

        }
        //ビュー非表示
        View parentView = (View)view.getParent();
        view = null;

        AnimationSet set = new AnimationSet(false);
        //TranslateAnimation animation_translate = new TranslateAnimation(0, width/2, 0, 0);
        Log.i("Var","CanvasSize is " + view.getMeasuredWidth());
        //set.addAnimation(animation_translate);

        ScaleAnimation animation_scale = new ScaleAnimation(1, 0, 1, 1);
        set.addAnimation(animation_scale);

        set.setDuration(2000);
        view.startAnimation(set);

    }


}

