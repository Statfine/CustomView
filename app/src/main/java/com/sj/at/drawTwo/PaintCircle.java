package com.sj.at.drawTwo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * 作者： Shaojia on 2015/8/24.
 * 邮箱： 309814872@qq.com
 *
 * 圆
 *
 * void addCircle (float x, float y, float radius, Path.Direction dir)
 *
 * 参数说明：
 * float x：圆心X轴坐标
 * float y：圆心Y轴坐标
 * float radius：圆半径
 */
public class PaintCircle extends View{

    Context m_context;

    public PaintCircle(Context context) {
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

        Path path = new Path();
        path.addCircle(200, 200, 100, Path.Direction.CCW);
        canvas.drawPath(path, paint);
    }
}
