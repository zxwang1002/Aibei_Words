package com.example.dell.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First1Activity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnStart1;
    private Button mBtnSound;
    private MediaPlayer mPlayer = null;
    private boolean isRelease = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first1);

        bindViews();

        mBtnStart1 = findViewById(R.id.btn_start);
        mBtnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(First1Activity.this,First1_1Activity.class);
                startActivity(intent);
            }
        });
        mBtnSound = findViewById(R.id.btn_sound);
    }

    private void bindViews() {
        mBtnSound = findViewById(R.id.btn_sound);
        mBtnSound.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_sound:
                if(isRelease){
                    mPlayer = MediaPlayer.create(this,R.raw.v2);
                    isRelease = false;
                }
                mPlayer.start();//开始播放
                mBtnSound.setEnabled(false);
                break;
        }
    }
}
