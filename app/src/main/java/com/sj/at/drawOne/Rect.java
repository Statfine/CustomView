package com.sj.at.drawOne;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * 作者： Shaojia on 2015/8/24.
 * 邮箱： 309814872@qq.com
 *
 * 矩形
 * void drawRect (float left, float top, float right, float bottom, Paint paint)
 * void drawRect (RectF rect, Paint paint)
 * void drawRect (Rect r, Paint paint)
 *
 * 参数：
 * 第一个的写法是直接传入矩形的四个点，画出矩形
 * 第二、三个构造函数是根据传入RectF或者Rect矩形变量来指定所画的矩形的
 */
public class Rect extends View{

    Context m_Context;

    public Rect(Context context) {
        super(context);
        m_Context = context;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint=new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式
        paint.setStrokeWidth(15);//设置画笔宽度

        canvas.drawRect(10, 10, 100, 100, paint);//直接构造

        RectF rect = new RectF(120, 10, 210, 100);
        canvas.drawRect(rect, paint);//使用RectF构造

        //Rect rect2 =  new Rect(230, 10, 320, 100);
        //canvas.drawRect(rect2, paint);//使用Rect构造

    }
}
