package com.sj.at.drawFour;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.sj.at.customview.R;
import com.sj.at.drawOne.CircleView;
import com.sj.at.drawOne.DrawOneActivity;

/**
 * 作者： Shaojia on 2015/8/24.
 * 邮箱： 309814872@qq.com
 *
 * canvas变换与操作
 *
 * http://blog.csdn.net/harvic880925/article/details/39080931
 *
 *      平移（translate）；旋转（Rotate）；缩放（scale ）；扭曲（skew）；
 *      裁剪画布（clip系列函数）；画布的保存与恢复（save()、restore()）
 *
 */
public class DrawFourActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_draw_four);

        initLayout();
    }

    private void initLayout(){

        //平移
        FrameLayout draw_four_oneF=(FrameLayout)findViewById(R.id.draw_four_oneF);
        draw_four_oneF.addView(new PaintTranslate(DrawFourActivity.this));

        //旋转
        FrameLayout draw_four_twoF=(FrameLayout)findViewById(R.id.draw_four_twoF);
        draw_four_twoF.addView(new PaintRotate(DrawFourActivity.this));


    }
}
