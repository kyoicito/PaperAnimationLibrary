package net.mokemoketa.paperlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Kyoichi Ito on 16/09/03.
 */
public class PaperView extends LinearLayout {

    //コンストラクタ群
    public PaperView(Context context) {
        this(context, null, 0);
    }

    public PaperView(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }

    public PaperView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        init(context, attrs);
    }


    //初期化
    private void init(Context context, AttributeSet attrs) {
        //set an animation listener
    }


    public void finalAnimation(Context context){
        AnimationSet set = new AnimationSet(true);

        TranslateAnimation animation_translate = new TranslateAnimation(0,0,this.getWidth()/2, 0);
        set.addAnimation(animation_translate);

        ScaleAnimation animation_scale = new ScaleAnimation(1, 0.01f, 1, 1);
        set.addAnimation(animation_scale);

        set.setDuration(2000);
        this.startAnimation(set);
    }

}

