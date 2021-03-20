package com.example.dell.myapplication;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.example.dell.myapplication.util.ToastUtil;


public class MainActivity extends AppCompatActivity {

    //声明控件
    private Button mBtnLogin;
    private EditText mTID;
    private EditText mTPassword;
    private Button mBtnRegister;

    private Button mBtnMaintenance;
    private Button mBtnEnglish;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //找到控件
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegister = findViewById(R.id.btn_register);
        mTID = findViewById(R.id.et_1);
        mTPassword = findViewById(R.id.et_2);
        mBtnMaintenance = findViewById(R.id.btn_maintenance_mode);
        mBtnEnglish = findViewById(R.id.btn_english_mode);

        db = new DatabaseHelper(this);

        //设置维护模式和英文模式的跳转事件
        mBtnMaintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Maintenance_LoginActivity.class);
                startActivity(intent);
            }
        });
        mBtnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EnglishModeActivity.class);
                startActivity(intent);
            }
        });

        //设置注册界面的跳转
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //设置登录界面的跳转
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mTID.getText().toString();
                String password = mTPassword.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email, password);
                if (Chkemailpass) {
                    Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(getApplicationContext(), "账号或密码错误", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

