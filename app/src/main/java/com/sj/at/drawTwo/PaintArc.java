package com.sj.at.drawTwo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/**
 * 作者： Shaojia on 2015/8/24.
 * 邮箱： 309814872@qq.com
 *
 * 弧形
 *
 * void addArc (RectF oval, float startAngle, float sweepAngle)
 *
 * 参数：
 * RectF oval：弧是椭圆的一部分，这个参数就是生成椭圆所对应的矩形；
 * float startAngle：开始的角度，X轴正方向为0度
 * float sweepAngel：持续的度数；
 */
public class PaintArc extends View{

    Context m_context;

    public PaintArc(Context context) {
        super(context);
        m_context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint=new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度

        Path path = new Path();
        RectF rect =  new RectF(50, 50, 240, 200);
        path.addArc(rect, 0, 100);

        canvas.drawPath(path, paint);//画出路径
    }
}
