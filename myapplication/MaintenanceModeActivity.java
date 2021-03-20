package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MaintenanceModeActivity extends AppCompatActivity {
    private Button mBtnOperation;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_mode);

        mBtnOperation = findViewById(R.id.btn_operation_mode);
        mBtnOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaintenanceModeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        mBtn1 = findViewById(R.id.btn_1);
        mBtn2 = findViewById(R.id.btn_2);
        mBtn3 = findViewById(R.id.btn_3);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "发送指令c\nFPGA控制伺服电机运转\n返回指令e", Toast.LENGTH_LONG).show();
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "发送指令g\n读取红外传感器所测距离\n红外传感器返回：检测到用户距离 L 为 x cm ", Toast.LENGTH_LONG).show();
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "请进入内部代码检测操作模式", Toast.LENGTH_LONG).show();
            }
        });
    }
}
