package com.example.dell.myapplication;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    private Button mBtnBack;
    private Button mBtnSound;
    private MediaPlayer mPlayer = null;
    private boolean isRelease = true;   //判断是否MediaPlayer是否释放的标志

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        bindViews();

        mBtn1 = findViewById(R.id.btn_1);
        mBtn2 = findViewById(R.id.btn_2);
        mBtn3 = findViewById(R.id.btn_3);
        mBtn4 = findViewById(R.id.btn_4);
        mBtn5 = findViewById(R.id.btn_5);
        mBtn6 = findViewById(R.id.btn_6);
        mBtnBack = findViewById(R.id.btn_back);

        //设置监听事件
        setListener();
    }

    private void bindViews() {
        mBtnSound = findViewById(R.id.btn_sound);
        mBtnSound.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_sound:
                if(isRelease){
                    mPlayer = MediaPlayer.create(this,R.raw.v1);
                    isRelease = false;
                }
                mPlayer.start();//开始播放
                mBtnSound.setEnabled(false);
                break;
        }
    }


    private void setListener(){
        OnClick onClick = new OnClick();
        mBtn1.setOnClickListener(onClick);
        mBtn2.setOnClickListener(onClick);
        mBtn3.setOnClickListener(onClick);
        mBtn4.setOnClickListener(onClick);
        mBtn5.setOnClickListener(onClick);
        mBtn6.setOnClickListener(onClick);
        mBtnBack.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_1:
                    intent = new Intent(FirstActivity.this, First1Activity.class);
                    break;
                case R.id.btn_2:
                    intent = new Intent(FirstActivity.this, First2Activity.class);
                    break;
                case R.id.btn_3:
                    intent = new Intent(FirstActivity.this,First3Activity.class);
                    break;
                case R.id.btn_4:
                    intent = new Intent(FirstActivity.this,First4Activity.class);
                    break;
                case R.id.btn_5:
                    intent = new Intent(FirstActivity.this,First5Activity.class);
                    break;
                case R.id.btn_6:
                    intent = new Intent(FirstActivity.this,First4_2Activity.class);
                    break;
                case R.id.btn_back:
                    intent = new Intent(FirstActivity.this,MainActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

}
