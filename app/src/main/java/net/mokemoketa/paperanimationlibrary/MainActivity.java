package net.mokemoketa.paperanimationlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import net.mokemoketa.paperlibrary.PaperView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);


        PaperView test1 = new PaperView(this);
        test1.setOrientation(LinearLayout.HORIZONTAL);
        Button button1 = new Button(this);
        button1.setText("1");
        PaperView.LayoutParams test1params = new PaperView.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        button1.setLayoutParams(test1params);
        test1.addView(button1);
        setContentView(test1);
/*
        Button button2 = new Button(this);
        button2.setText("2");
        button2.setLayoutParams(new PaperView.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(button2);
        Button button3 = new Button(this);
        button3.setText("3");
        button3.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(button3);
        Button button4 = new Button(this);
        button4.setText("4");
        button4.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(button4);
*/
        test1.finalAnimation(this);
    }
    //

}
