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
 * 椭圆
 *
 * void addOval (RectF oval, Path.Direction dir)
 *
 * 参数说明：
 * RectF oval：生成椭圆所对应的矩形
 * Path.Direction :生成方式，与矩形一样，分为顺时针与逆时针，意义完全相同，不再重复
 */
public class PaintOval extends View{

    Context m_context;

    public PaintOval(Context context) {
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
        path.addOval(rect, Path.Direction.CCW);
        canvas.drawPath(path, paint);
    }
}
