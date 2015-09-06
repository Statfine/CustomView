package com.sj.at.drawOne;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * 作者： Shaojia on 2015/8/19.
 * 邮箱： 309814872@qq.com
 *
 * 画圆
 *void drawCircle (float cx, float cy, float radius, Paint paint)
 *
 * 参数：
 * float cx：圆心点X轴坐标
 * float cy：圆心点Y轴坐标
 * float radius：圆的半径
 */
public class CircleView extends View {

    Context m_context;

    public CircleView(Context context) {
        super(context);

        m_context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置画笔基本属性
        Paint paint=new Paint();
        paint.setAntiAlias(true);//抗锯齿功能
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式   Style.FILL/Style.FILL_AND_STROKE/Style.STROKE
        paint.setStrokeWidth(5);//设置画笔宽度
        //paint.setShadowLayer(10, 15, 15, Color.GREEN);//设置阴影

        //设置画布背景颜色
        canvas.drawRGB(255, 255,255);

        //画圆
        //float cx：圆心点X轴坐标;float cy：圆心点Y轴坐标;float radius：圆的半径
        canvas.drawCircle(100, 100, 50, paint);

        paint.setColor(Color.GRAY);
        canvas.drawCircle(200, 100, 20, paint);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(100, 200, 40, paint);
    }
}


