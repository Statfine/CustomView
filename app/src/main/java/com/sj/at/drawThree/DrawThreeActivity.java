package com.sj.at.drawThree;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sj.at.customview.R;
import com.sj.at.drawOne.CircleView;
import com.sj.at.drawOne.DrawOneActivity;

/**
 * 作者： Shaojia on 2015/8/24.
 * 邮箱： 309814872@qq.com
 *
 * 区域Range
 *
 * http://blog.csdn.net/harvic880925/article/details/39056701
 */
public class DrawThreeActivity extends Activity {

    private RegionView m_RegionView;

    RadioGroup radiogroup;
    RadioButton radio0,radio1,radio2,radio3,radio4,radio5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_draw_three);

        initLayout();
    }

    private void initLayout(){
        FrameLayout draw_three_oneF=(FrameLayout)findViewById(R.id.draw_three_oneF);
        m_RegionView = new RegionView(DrawThreeActivity.this);
        draw_three_oneF.addView(m_RegionView);

        radiogroup = (RadioGroup)this.findViewById(R.id.radioGroup2);
        radio0 = (RadioButton)this.findViewById(R.id.radioGroup2Button0);
        radio1 = (RadioButton)this.findViewById(R.id.radioGroup2Button1);
        radio2 = (RadioButton)this.findViewById(R.id.radioGroup2Button2);
        radio3 = (RadioButton)this.findViewById(R.id.radioGroup2Button3);
        radio4 = (RadioButton)this.findViewById(R.id.radioGroup2Button4);
        radio5 = (RadioButton)this.findViewById(R.id.radioGroup2Button5);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int change = 0;
                switch (i){
                    case R.id.radioGroup2Button0:
                        change = 0;
                        break;
                    case R.id.radioGroup2Button1:
                        change = 1;
                        break;
                    case R.id.radioGroup2Button2:
                        change = 2;
                        break;
                    case R.id.radioGroup2Button3:
                        change = 3;
                        break;
                    case R.id.radioGroup2Button4:
                        change = 4;
                        break;
                    case R.id.radioGroup2Button5:
                        change = 5;
                        break;
                        default:;
                }
                m_RegionView.change(change);
            }
        });

    }
}
