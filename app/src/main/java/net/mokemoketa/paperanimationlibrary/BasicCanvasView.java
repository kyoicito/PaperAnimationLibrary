package net.mokemoketa.paperanimationlibrary;

/**
 * Created by Hello on 16/09/04.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class BasicCanvasView extends View {
    private Paint mPaint = new Paint();
    Rect rect = new Rect(100, 200, 300, 400);
    private boolean viewflg;

    public BasicCanvasView(Context context) {
        super(context);
    }
    public void showCanvas(boolean flg){
        viewflg = flg;
        invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.argb(125, 0, 0, 255));

        canvas.drawRect(rect, mPaint);
    }

}
