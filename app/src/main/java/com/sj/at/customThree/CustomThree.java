package com.sj.at.customThree;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sj.at.customview.R;

/**
 * 作者： Shaojia on 2015/9/6.
 * 邮箱： 309814872@qq.com
 */
public class CustomThree extends Activity implements View.OnClickListener{

    private CustomProgressBar cpb_one;
    private Button btn_change_color;
    private Button btn_change_size;

    private boolean flagChangeColor = true;
    private boolean flagChangeSize = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom_progress);
        initLayout();
    }

    private void initLayout(){
        cpb_one = (CustomProgressBar) this.findViewById(R.id.cpb_one);
        btn_change_color = (Button) this.findViewById(R.id.btn_change_color);
        btn_change_size = (Button) this.findViewById(R.id.btn_change_size);

        btn_change_color.setOnClickListener(this);
        btn_change_size.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_change_color:
                if(flagChangeColor){
                    cpb_one.setColor(getResources().getColor(R.color.text_f37b1d), getResources().getColor(R.color.tetx_e2e9eb));
                    flagChangeColor = false;
                }else{
                    cpb_one.setColor(getResources().getColor(R.color.text_D4F668), getResources().getColor(R.color.text_2F9DD2));
                    flagChangeColor = true;
                }

                break;
            case R.id.btn_change_size:
                if(flagChangeSize){
                    cpb_one.setSize(40);
                    flagChangeSize = false;
                }else{
                    cpb_one.setSize(24);
                    flagChangeSize = true;
                }
                break;

            default:
                break;
        }
    }

}
