package net.mokemoketa.paperanimationlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import net.mokemoketa.paperlibrary.PaperView;

public class MainActivity extends AppCompatActivity {
    public LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.mainframe);

        final ImageView imageview1 = (ImageView)findViewById(R.id.imageView);
        imageview1.setImageResource(R.drawable.hedgehog);

        final PaperView paperview1 = new PaperView(this);//
        linearLayout.addView(paperview1);

        imageview1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    paperview1.finalAnimation(v, 4, 2000);
                }
                return false;
            }
        });
    }
    //


}
