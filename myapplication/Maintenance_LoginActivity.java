package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dell.myapplication.util.ToastUtil;

public class Maintenance_LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnOperationMode;
    private Button mBtnLogin;
    private TextView mEtID;
    private TextView mEtPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance__login);

        mEtID = findViewById(R.id.et_1);
        mEtPassWord = findViewById(R.id.et_2);


        //设置操作模式跳转
        mBtnOperationMode = findViewById(R.id.btn_operation_mode);
        mBtnOperationMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Maintenance_LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mBtnLogin = findViewById(R.id.btn_login);
        //暂时只对登录设置了情况，采用提前注入信息的形式
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //获取输入的信息
        String id = mEtID.getText().toString();
        String name = mEtPassWord.getText().toString();
        String ok = "登陆成功";
        String fail = "密码错误，登陆失败";
        Intent intent = null;

        if(id.equals("1131512351@qq.com") &&name.equals("1131512351")){
            ToastUtil.showMsg(Maintenance_LoginActivity.this,ok);
            //下面实现的是登陆界面的跳转
            intent = new Intent(Maintenance_LoginActivity.this, MaintenanceModeActivity.class);
            startActivity(intent);
        }else{
            //登录成功或者失败我们都需要弹出一个信息来告诉用户是成功还是失败
            ToastUtil.showMsg(Maintenance_LoginActivity.this,fail);
        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}