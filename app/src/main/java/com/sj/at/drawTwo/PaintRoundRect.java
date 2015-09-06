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
 * 圆角矩形
 * void addRoundRect (RectF rect, float[] radii, Path.Direction dir)
 * void addRoundRect (RectF rect, float rx, float ry, Path.Direction dir)
 *
 * 这里有两个构造函数，部分参数说明如下：
 * 第一个构造函数：可以定制每个角的圆角大小：
 * float[] radii：必须传入8个数值，分四组，分别对应每个角所使用的椭圆的横轴半径和纵轴半径，如｛x1,y1,x2,y2,x3,y3,x4,y4｝，其中，x1,y1对应第一个角的（左上角）用来产生圆角的椭圆的横轴半径和纵轴半径，其它类推……
 * 第二个构造函数：只能构建统一圆角大小
 * float rx：所产生圆角的椭圆的横轴半径；
 * float ry：所产生圆角的椭圆的纵轴半径；
 */
public class PaintRoundRect extends View {

    Context m_context;

    public PaintRoundRect(Context context) {
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
        RectF rect1 =  new RectF(50, 50, 240, 200);
        path.addRoundRect(rect1, 10, 15 , Path.Direction.CCW);

        RectF rect2 =  new RectF(290, 50, 480, 200);
        float radii[] ={10,15,20,25,30,35,40,45};
        path.addRoundRect(rect2, radii, Path.Direction.CCW);

        canvas.drawPath(path, paint);
    }
}
