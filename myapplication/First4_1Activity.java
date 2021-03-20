package com.example.dell.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First4_1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnPlay;
    private Button mBtnPause;
    private Button mBtnStop;
    private MediaPlayer mPlayer = null;
    private boolean isRelease = true;   //判断是否MediaPlayer是否释放的标志

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first4_1);
        bindViews();
    }

    private void bindViews() {
        mBtnPlay = findViewById(R.id.btn_play);
        mBtnPause = findViewById(R.id.btn_pause);
        mBtnStop = findViewById(R.id.btn_stop);

        mBtnPlay.setOnClickListener(this);
        mBtnPause.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_play:
                if(isRelease){
                    mPlayer = MediaPlayer.create(this,R.raw.passage);
                    isRelease = false;
                }
                mPlayer.start();//开始播放
                mBtnPlay.setEnabled(false);
                mBtnPause.setEnabled(true);
                mBtnStop.setEnabled(true);
                break;
            case R.id.btn_pause:
                mPlayer.pause();//暂停播放
                mBtnPlay.setEnabled(true);
                mBtnPause.setEnabled(false);
                mBtnStop.setEnabled(false);
                break;
            case R.id.btn_stop:
                //mPlayer.pause();
                mPlayer.reset();     //重置MediaPlayer
                mPlayer.release();   //释放MediaPlayer
                isRelease = true;
                mBtnPlay.setEnabled(true);
                mBtnPause.setEnabled(false);
                mBtnStop.setEnabled(false);

                break;
        }
    }
}




