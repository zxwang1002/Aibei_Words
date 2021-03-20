package com.example.dell.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import com.example.dell.myapplication.util.ToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class First1_1Activity extends Activity {

    private GridView mGv;
    private Button mBtnNext;
    private Button mBtnOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first1_1);

        mGv = findViewById(R.id.gv);
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //去判断他点击的是不是正确的图片
                if(position == 1){
                    ToastUtil.showMsg(First1_1Activity.this,"恭喜你，回答正确！");
                }else{
                    ToastUtil.showMsg(First1_1Activity.this,"回答错误，再接再厉！");
                }
            }
        });

        int[] imageAry = new int[]{
                R.drawable.grape,R.drawable.strawberry,R.drawable.banana,R.drawable.apple
        };

        List list = new ArrayList();

        for (int i = 0;i<imageAry.length;i++){
            Map map = new HashMap();
            map.put("image",imageAry[i]);
            list.add(map);
        }
        //实例化SimpleAdapter适配器的对象
        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.layout_grid_item1,
                new String[]{"image"},new int[]{R.id.iv_grid});
        //获得GridView组件
        GridView gridView = (GridView) findViewById(R.id.gv);
        //向GridView中添加内容
        gridView.setAdapter(adapter);

        mBtnNext = findViewById(R.id.btn_next);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First1_1Activity.this,First1_2Activity.class);
                startActivity(intent);
            }
        });
        mBtnOver = findViewById(R.id.btn_over);
        mBtnOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First1_1Activity.this,FirstActivity.class);
                startActivity(intent);
            }
        });

    }
}


