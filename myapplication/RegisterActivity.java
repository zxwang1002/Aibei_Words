package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1,e2,e3;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.et_1);
        e2 = (EditText) findViewById(R.id.et_2);
        e3 = (EditText) findViewById(R.id.et_3);
        b1 = (Button) findViewById(R.id.btn_register);
        b2 =(Button) findViewById(R.id.btn_login);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"未输入账号或密码",Toast.LENGTH_LONG);
                }
                else
                {
                    if(s2.equals(s3)){
                        Boolean checkmail = db.checkmail(s1);
                        if(checkmail){
                            Boolean insert = db.insert(s1,s2);
                            if(insert){
                                Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"账号已存在",Toast.LENGTH_SHORT).show();

                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"两次输入密码不一致",Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
}
