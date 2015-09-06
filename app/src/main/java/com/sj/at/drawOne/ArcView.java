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
 * 弧形
 *
 * 弧是椭圆的一部分，而椭圆是根据矩形来生成的，所以弧当然也是根据矩形来生成的；
 * void drawArc (RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
 *
 * 参数：
 * RectF oval:生成椭圆的矩形
 * float startAngle：弧开始的角度，以X轴正方向为0度
 * float sweepAngle：弧持续的角度
 * boolean useCenter:是否有弧的两边，True，还两边，False，只有一条弧
 */
public class ArcView extends View {

    Context m_context;

    public ArcView(Context context) {
        super(context);
        m_context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        RectF rect1 = new RectF(100, 10, 300, 100);
        canvas.drawArc(rect1, 0, 90, true, paint);

        RectF rect2 = new RectF(400, 10, 600, 100);
        canvas.drawArc(rect2, 0, 90, false, paint);
    }
}
