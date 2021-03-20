package com.example.dell.myapplication;

import android.content.Intent;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PoorActivity extends AppCompatActivity {
    private Button mBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poor);
        mBtn1 = findViewById(R.id.btn_back);


        mBtn1 = findViewById(R.id.btn_back);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoorActivity.this, First5Activity.class);
                startActivity(intent);
            }
        });
    }
}
