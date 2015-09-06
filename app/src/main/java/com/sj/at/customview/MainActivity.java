package com.sj.at.customview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sj.at.customFour.CustomFour;
import com.sj.at.customOne.CustomOne;
import com.sj.at.customThree.CustomThree;
import com.sj.at.customTwo.CustomTwo;
import com.sj.at.myAuto.AutoActivity;
import com.sj.at.myDrag.VDHActivity;
import com.sj.at.drawFour.DrawFourActivity;
import com.sj.at.drawOne.DrawOneActivity;
import com.sj.at.drawThree.DrawThreeActivity;
import com.sj.at.drawTwo.DrawTwoActivity;

/**
 * 作者： Shaojia on 2015/8/14.
 * 邮箱： 309814872@qq.com
 *
 * 部分自定义控件
 * 第一排  paint(画笔) canvas（画布） 基础；文字；区域；变换操作
 * 第二排  自定义View起步
 * 第三排  自定义的控件
 *
 */

public class MainActivity extends Activity implements View.OnClickListener{

    private Button btn_graphics_one_step,btn_graphics_two_step,btn_graphics_three_step,btn_graphics_four_step = null;
    private Button btn_one_step,btn_two_step,btn_three_step,btn_four_step = null;
    private Button btn_one_view,btn_two_view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
    }

    public void initLayout(){

        //Draw方法
        btn_graphics_one_step = (Button) this.findViewById(R.id.btn_graphics_one_step);
        btn_graphics_two_step = (Button) this.findViewById(R.id.btn_graphics_two_step);
        btn_graphics_three_step = (Button) this.findViewById(R.id.btn_graphics_three_step);
        btn_graphics_four_step = (Button) this.findViewById(R.id.btn_graphics_four_step);

        //自定义布局初学之路
        btn_one_step = (Button) this.findViewById(R.id.btn_one_step);
        btn_two_step = (Button) this.findViewById(R.id.btn_two_step);
        btn_three_step = (Button) this.findViewById(R.id.btn_three_step);
        btn_four_step = (Button) this.findViewById(R.id.btn_four_step);

        //自定义布局实战
        btn_one_view = (Button) this.findViewById(R.id.btn_one_view);
        btn_two_view = (Button) this.findViewById(R.id.btn_two_view);


        btn_graphics_one_step.setOnClickListener(this);
        btn_graphics_two_step.setOnClickListener(this);
        btn_graphics_three_step.setOnClickListener(this);
        btn_graphics_four_step.setOnClickListener(this);

        btn_one_step.setOnClickListener(this);
        btn_two_step.setOnClickListener(this);
        btn_three_step.setOnClickListener(this);
        btn_four_step.setOnClickListener(this);

        btn_one_view.setOnClickListener(this);
        btn_two_view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_graphics_one_step:
                startActivity(new Intent(this,DrawOneActivity.class));
                break;
            case R.id.btn_graphics_two_step:
                startActivity(new Intent(this,DrawTwoActivity.class));
                break;
            case R.id.btn_graphics_three_step:
                startActivity(new Intent(this,DrawThreeActivity.class));
                break;
            case R.id.btn_graphics_four_step:
                startActivity(new Intent(this,DrawFourActivity.class));
                break;


            /*自定义布局初学之路
             *      1、自定义View的属性
             *      2、在View的构造方法中获得我们自定义的属性
             *      [ 3、重写onMesure ]
             *      4、重写onDraw
             */
            case R.id.btn_one_step:
                startActivity(new Intent(this,CustomOne.class));
                break;
            case R.id.btn_two_step:
                startActivity(new Intent(this,CustomTwo.class));
                break;
            case R.id.btn_three_step:
                startActivity(new Intent(this,CustomThree.class));
                break;
            case R.id.btn_four_step:
                startActivity(new Intent(this,CustomFour.class));
                break;


            case R.id.btn_one_view:
                // 自动换行布局
                startActivity(new Intent(this,AutoActivity.class));
                break;
            case R.id.btn_two_view:
                // 拖动
                startActivity(new Intent(this,VDHActivity.class));
                break;
            default:
        }
    }
}
