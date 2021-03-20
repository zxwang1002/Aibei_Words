package com.example.dell.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class First2Activity extends AppCompatActivity {
    private Button mBtn_1;
    private Button mBtn_2;
    private Button mBtn_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first2);

        mBtn_1 = findViewById(R.id.btn_1);
        mBtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(First2Activity.this, First2_1Activity.class);
                startActivity(intent);

            }
        });


        mBtn_2 = findViewById(R.id.btn_2);
        mBtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(First2Activity.this, First2_2Activity.class);
                startActivity(intent);

            }
        });


        mBtn_3 = findViewById(R.id.btn_3);
        mBtn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(First2Activity.this, First2_3Activity.class);
                startActivity(intent);

            }
        });

    }
}

