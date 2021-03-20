package com.example.dell.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.dell.myapplication.QuizActivity;
import com.example.dell.myapplication.R;

public class First5Activity extends AppCompatActivity {

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharePrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;
    private Button mBtnEvaluate;
    private Button mBtnBack;

    private int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first5);

        mBtnEvaluate = findViewById(R.id.button_evaluate);
        mBtnBack = findViewById(R.id.btn_back);
        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadHighscore();

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First5Activity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }

    private  void startQuiz() {
        Intent intent = new Intent(First5Activity.this, QuizActivity.class);
        startActivityForResult(intent,REQUEST_CODE_QUIZ);
    }

    //设置显示最高分数
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ)  {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE,0);
                if(score > highscore) {
                    updateHighscore(score);
                }
            }
        }

       if (highscore > 3 ){
            mBtnEvaluate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "发送指令a", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(First5Activity.this,WellActivity.class);
                    startActivity(intent);
                }
            });
        }
       else {
           mBtnEvaluate.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(getApplicationContext(), "发送指令b", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(First5Activity.this, PoorActivity.class);
                   startActivity(intent);
               }
           });
       }
    }

    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE,0);
        textViewHighscore.setText("最高分: " + highscore);

    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("最高分: " + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE,highscore);
        editor.apply();
    }


}
