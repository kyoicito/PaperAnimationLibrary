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
        //frameLayout = new FrameLayout(this);
        //setContentView(frameLayout);
        /*
        basicCanvasView = new BasicCanvasView(this);
        basicCanvasView.showCanvas(true);
        linearLayout.addView(basicCanvasView);
        PaperView test1 = new PaperView(this);
        test1.setOrientation(LinearLayout.HORIZONTAL);
        Button button1 = new Button(this);
        button1.setText("1");
        PaperView.LayoutParams test1params = new PaperView.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        button1.setLayoutParams(test1params);
        test1.addView(button1);

        Button button2 = new Button(this);
        button2.setText("2");
        PaperView.LayoutParams test2params = new PaperView.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        button2.setLayoutParams(test2params);
        test1.addView(button2);
        setContentView(test1);

        LinearLayout test1 = new LinearLayout(this);
        test1.setOrientation(LinearLayout.HORIZONTAL);
        Button button1 = new Button(this);
        button1.setText("1");
        LinearLayout.LayoutParams test1params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        button1.setLayoutParams(test1params);
        linearLayout.addView(test1);
        test1.addView(button1);
*/
        final ImageView imageview1 = (ImageView)findViewById(R.id.imageView);
        imageview1.setImageResource(R.drawable.hedgehog);

        final PaperView paperview1 = new PaperView(this);//
        linearLayout.addView(paperview1);

        //setContentView(imageview1);
        imageview1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //imageview1.setVisibility(View.INVISIBLE);
                    paperview1.finalAnimation(v,4);
                }
                return false;
            }
        });
    }
    //


}
