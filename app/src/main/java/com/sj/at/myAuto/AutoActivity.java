package com.sj.at.myAuto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.sj.at.customview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： Shaojia on 2015/8/14.
 * 邮箱： 309814872@qq.com
 *
 *  自定换行布局
 *  注意 ：如果布局文件 对这个自定义布局做了padding或者marging的话
 *  CustomListView 当中的 argRight需要相应的减去你得设置。不然会有偏差。自己debug可以测试出来的！
 *
 */
public class AutoActivity extends Activity {


    private String TAG = AutoActivity.class.getSimpleName();
    private CustomListView lv;
    private List<String> list = null;
    private MainSexangleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto);

        lv = (CustomListView) findViewById(R.id.sexangleView);
        setData();
        ShowSexangleListView();
    }

    private void ShowSexangleListView(){

        adapter = new MainSexangleAdapter(this, list);
        lv.setDividerHeight(10);
        lv.setDividerWidth(10);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(AutoActivity.this, "点击了 : " + arg2, Toast.LENGTH_SHORT).show();
            }
        });

        lv.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(AutoActivity.this, "点击了 : " + arg2, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


    private void setData(){
        list = new ArrayList<String>();
        list.add("Powerball");
        list.add("Lil Kim Pregnant");
        list.add("Nicki Minaj");
        list.add("MTA");
        list.add("House of Cards");
        list.add("Valentine's Day");

    }

}
