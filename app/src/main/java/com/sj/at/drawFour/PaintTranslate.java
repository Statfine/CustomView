package com.sj.at.drawFour;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * 作者： Shaojia on 2015/8/25.
 * 邮箱： 309814872@qq.com
 */
public class PaintTranslate extends View {


    public PaintTranslate(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paintOne = generatePaint(Color.RED,Paint.Style.STROKE,3);
        Paint paintTwo = generatePaint(Color.GREEN,Paint.Style.STROKE,3);
        Paint paintThree = generatePaint(Color.BLUE,Paint.Style.STROKE,3);

        //构造一个矩形
        Rect rect = new Rect(0,0,400,220);

        //在平移画布前用绿色画下边框
        canvas.drawRect(rect,paintOne);

        //平移画布后,再用红色边框重新画下这个矩形
        canvas.translate(100,100);
        canvas.drawRect(rect,paintTwo);

        canvas.translate(50,50);
        canvas.drawRect(rect,paintThree);

    }

    private Paint generatePaint(int color,Paint.Style style,int width)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }
}
