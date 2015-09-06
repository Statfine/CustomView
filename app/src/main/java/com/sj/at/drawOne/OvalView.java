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
 * 椭圆
 *
 * 椭圆是根据矩形生成的，以矩形的长为椭圆的X轴，矩形的宽为椭圆的Y轴，建立的椭圆图形
 * void drawOval (RectF oval, Paint paint)
 *
 * 参数：
 * RectF oval：用来生成椭圆的矩形
 */
public class OvalView extends View {

    Context m_context;

    public OvalView(Context context) {
        super(context);
        m_context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度

        RectF rect = new RectF(100, 10, 300, 100);
        canvas.drawRect(rect, paint);//画矩形

        paint.setColor(Color.GREEN);//更改画笔颜色
        canvas.drawOval(rect, paint);//同一个矩形画椭圆
    }
}
