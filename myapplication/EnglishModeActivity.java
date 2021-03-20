package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnglishModeActivity extends AppCompatActivity {

    private Button mBtnChinese_Mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_mode);


        mBtnChinese_Mode = findViewById(R.id.btn_chinese_mode);
        mBtnChinese_Mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnglishModeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
