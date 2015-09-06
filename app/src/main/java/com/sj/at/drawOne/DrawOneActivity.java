package com.sj.at.drawOne;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.sj.at.customview.MainActivity;
import com.sj.at.customview.R;

/**
 * 作者： Shaojia on 2015/8/19.
 * 邮箱： 309814872@qq.com
 *
 * 概述及基本几何图形绘制
 *
 * 在自定义的View里面
 * Paint就是相当于笔，而Canvas就是纸，这里叫画布
 * 所以，凡有跟要要画的东西的设置相关的，比如大小，粗细，画笔颜色，透明度，字体的样式等等，都是在Paint里设置；
 * 同样，凡是要画出成品的东西，比如圆形，矩形，文字等相关的都是在Canvas里生成。
 *
 *下面先说下Paint的基本设置函数：
 *
 *   paint.setAntiAlias(true);//抗锯齿功能
 *   paint.setColor(Color.RED);  //设置画笔颜色
 *   paint.setStyle(Style.FILL);//设置填充样式
 *   paint.setStrokeWidth(30);//设置画笔宽度
 *   paint.setShadowLayer(10, 15, 15, Color.GREEN);//设置阴影
 *
 *然后是Canvas的基本设置：
 *画布背景设置：
 *
 *   canvas.drawColor(Color.BLUE);
 *   canvas.drawRGB(255, 255, 0);   //这两个功能一样，都是用来设置背景颜色的。
 *
 *   http://blog.csdn.net/harvic880925/article/details/38875149
 *
 */
public class DrawOneActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_one);

        initLayout();
    }

    private void initLayout(){

        //圆形drawCircle
        FrameLayout draw_one_oneF=(FrameLayout)findViewById(R.id.draw_one_oneF);
        draw_one_oneF.addView(new CircleView(DrawOneActivity.this));

        //直线drawLine
        FrameLayout draw_one_twoF=(FrameLayout)findViewById(R.id.draw_one_twoF);
        draw_one_twoF.addView(new LineView(DrawOneActivity.this));

        //椭圆矩形
        FrameLayout draw_one_threeF=(FrameLayout)findViewById(R.id.draw_one_threeF);
        draw_one_threeF.addView(new OvalView(DrawOneActivity.this));

        //弧形
        FrameLayout draw_one_fourF=(FrameLayout)findViewById(R.id.draw_one_fourF);
        draw_one_fourF.addView(new ArcView(DrawOneActivity.this));
    }

}
