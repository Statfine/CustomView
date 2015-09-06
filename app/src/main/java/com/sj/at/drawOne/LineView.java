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
 * 直线
 *
 */
public class LineView extends View{

    Context m_context;

    public LineView(Context context) {
        super(context);

        m_context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式
        paint.setStrokeWidth(5);//设置画笔宽度

        //直线
        //单挑直线startX:开始点X坐标；startY:开始点Y坐标；stopX:结束点X坐标；stopY:结束点Y坐标
        //canvas.drawLine(100, 100, 200, 200, paint);

        float []pts={10,10,100,100,200,200,400,400};
        canvas.drawLines(pts,paint);
    }
}
