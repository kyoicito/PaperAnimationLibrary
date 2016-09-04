package net.mokemoketa.paperlibrary;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Kyoichi Ito on 16/09/03.
 */
public class PaperView extends LinearLayout{
    private Context context;
    //コンストラクタ群
    public PaperView(Context context) {
        super(context);
        this.context = context;
        //this.setGravity(Gravity.CENTER_HORIZONTAL);
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
        Log.i("Var","CanvasSize is " + view.getMeasuredWidth());
        //ImageViewをbitmapから生成、配置
        this.setGravity(Gravity.CENTER);
        ImageView[] imageviewList = new ImageView[totalImageNum];
        for (int i = 0; i < totalImageNum; i++){
            imageviewList[i] = new ImageView(context);
            imageviewList[i].setImageBitmap(imageList[i]);
            this.addView(imageviewList[i]);
            //元のViewと同じ位置に配置
        }
        //ビューを消す
        //ImageView imageView = (ImageView) view;
        //imageView.setImageBitmap(imageList[0]);
        view.setVisibility(View.INVISIBLE);
        //view = null;

        //アニメーション
        //ObjectAnimator[] oa_left1 = new ObjectAnimator[totalImageNum];
        //ObjectAnimator[] oa_left2 = new ObjectAnimator[totalImageNum];
        for(int i = 0; i < div; i++) {
            ObjectAnimator oa_left1 = ObjectAnimator.ofFloat(imageviewList[i], "scaleX", 0f);
            ObjectAnimator oa_left2 = ObjectAnimator.ofFloat(imageviewList[i], "translationX", 0, rowSize*(div-i-1+0.5f));
            oa_left1.setDuration(2000);
            oa_left2.setDuration(2000);
            oa_left1.start();
            oa_left2.start();
        }
        for(int i = 0; i < div; i++){
            ObjectAnimator oa_right1 = ObjectAnimator.ofFloat(imageviewList[totalImageNum - i - 1], "scaleX", 0f);
            ObjectAnimator oa_right2 = ObjectAnimator.ofFloat(imageviewList[totalImageNum - i - 1], "translationX", 0, -rowSize*(div-i-1+0.5f));
            oa_right1.setDuration(2000);
            oa_right2.setDuration(2000);
            oa_right1.start();
            oa_right2.start();
        }
        //右側用
        //AnimationSet set_right = new AnimationSet(false);
        //ScaleAnimation animation_scale_right = new ScaleAnimation(1, 0, 1, 1);
        //set_right.addAnimation(animation_scale_right);

        //set_right.setDuration(2000);

        //for(int i = div; i < totalImageNum; i++){
        //    imageviewList[i].startAnimation(set_right);
        //}

    }


}

