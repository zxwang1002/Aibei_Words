package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First4Activity extends AppCompatActivity {

    private Button mBtn1;
    private Button mBtn3;
    private Button mBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first4);
        //找到控件
        mBtn1 = findViewById(R.id.btn_1);
        mBtn3 = findViewById(R.id.btn_3);
        mBtnBack = findViewById(R.id.btn_back);

        //设置跳转事件
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First4Activity.this,First4_1Activity.class);
                startActivity(intent);
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First4Activity.this,First4_3Activity.class);
                startActivity(intent);
            }
        });

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First4Activity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
    }



}
