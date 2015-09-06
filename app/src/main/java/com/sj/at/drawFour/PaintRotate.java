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
 *
 * 旋转
 * void rotate(float degrees)
 * oid rotate (float degrees, float px, float py)
 * 第一个构造函数直接输入旋转的度数，正数是顺时针旋转，负数指逆时针旋转，它的旋转中心点是原点（0，0）
 * 第二个构造函数除了度数以外，还可以指定旋转的中心点坐标（px,py）
 *
 */
public class PaintRotate extends View{


    public PaintRotate(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.FILL, 5);
        Paint paint_red   = generatePaint(Color.RED, Paint.Style.STROKE, 5);

        Rect rect1 = new Rect(300,10,500,100);
        canvas.drawRect(rect1, paint_red); //画出原轮廓

        canvas.rotate(30);//顺时针旋转画布
        canvas.drawRect(rect1, paint_green);//画出旋转后的矩形

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
