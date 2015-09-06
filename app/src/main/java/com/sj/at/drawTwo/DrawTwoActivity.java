package com.sj.at.drawTwo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.sj.at.customview.R;

/**
 * 作者： Shaojia on 2015/8/24.
 * 邮箱： 309814872@qq.com
 *
 * 路径及文字
 *
 * http://blog.csdn.net/harvic880925/article/details/38926877
 *
 * canvas中绘制路径利用：
 * void drawPath (Path path, Paint paint)
 *
 */
public class DrawTwoActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_draw_two);

        initLayout();
    }

    private void initLayout(){

        //直线路径
        FrameLayout draw_two_oneF=(FrameLayout)findViewById(R.id.draw_two_oneF);
        draw_two_oneF.addView(new PaintLine(DrawTwoActivity.this));

        //矩形   （方向）
        FrameLayout draw_two_twoF=(FrameLayout)findViewById(R.id.draw_two_twoF);
        draw_two_twoF.addView(new PaintRectF(DrawTwoActivity.this));

        //圆角矩形
        FrameLayout draw_two_threeF=(FrameLayout)findViewById(R.id.draw_two_threeF);
        draw_two_threeF.addView(new PaintRoundRect(DrawTwoActivity.this));

        //圆
        FrameLayout draw_two_fourF=(FrameLayout)findViewById(R.id.draw_two_fourF);
        draw_two_fourF.addView(new PaintCircle(DrawTwoActivity.this));

        //椭圆
        FrameLayout draw_two_fiveF=(FrameLayout)findViewById(R.id.draw_two_fiveF);
        draw_two_fiveF.addView(new PaintOval(DrawTwoActivity.this));

        //弧形
        FrameLayout draw_two_sixF=(FrameLayout)findViewById(R.id.draw_two_sixF);
        draw_two_sixF.addView(new PaintArc(DrawTwoActivity.this));

        //字体
        FrameLayout draw_two_sevenF=(FrameLayout)findViewById(R.id.draw_two_sevenF);
        draw_two_sevenF.addView(new PaintText(DrawTwoActivity.this));

    }

}
