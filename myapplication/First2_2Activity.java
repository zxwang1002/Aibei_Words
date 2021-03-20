package com.example.dell.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class First2_2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first2_2);
        //声明控件
        TextView qu = (TextView) findViewById(R.id.textView3);
        Button submit = (Button) findViewById(R.id.button3);
        Button nex = (Button) findViewById(R.id.button2);

        final TextView tv = (TextView) findViewById(R.id.textView2);
        final RadioButton c1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton c2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton c3 = (RadioButton) findViewById(R.id.radioButton3);


        //100道题目
        final String[] quen;
        quen = new String[]{"wardrobe", "narrow","tail","remove","sort","stocking","stove",
                "decorate", "attack", "eagle"};


        //100道题目的答案
        final String[] an;
        an = new String[]{"B", "A", "C", "B", "C", "A", "B", "B", "C", "A"};


        //100道题的选项
        final String[][] se;
        se = new String[][]{
                {"n.月亮", "n.衣橱", "n.治理，政府"}, {"adj.狭窄的；v.使变窄", "n.娱乐，消遣", "n.朋友，友人"}, {"n.娱乐，消遣", "n.朋友，友人", "n.尾巴，末端"}, {"n.娱乐，消遣", "v.除掉，去除", "n.朋友，友人"},
                {"n.衣橱", "n.娱乐，消遣", "v.分类；n.种类"}, {"n.长袜", "n.朋友，友人", "n.衣橱"}, {"v.除掉，去除", "n.火炉，电炉", "n.朋友，友人"}, {"adj.狭窄的；v.使变窄", "v.装饰，装修", "n.娱乐，消遣"},
                {"v.除掉，去除", "n.月亮", "v.攻击，进攻"}, {"n.鹰状标志", "n.衣橱", "n.娱乐，消遣"}
        };


        final CCC b = new CCC();      //CCC的作用是是：产生一个0~90的随机数，存储在cnt中
        int a = b.cnt;
        qu.setText(quen[a]);

        //设置选项ABC的内容
        c1.setText("A  "+se[a][0]);
        c2.setText("B  "+se[a][1]);
        c3.setText("C  "+se[a][2]);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int e = b.cnt;
                String ret = String.valueOf(0);
                if (c1.isChecked()) {
                    ret = "A";
                } else if (c2.isChecked()) {
                    ret = "B";
                } else if (c3.isChecked()) {
                    ret = "C";
                }
                if(ret.equals("0")){
                    String q2= "未选择选项";     //未选择选项
                    tv.setText(q2+"  ");
                }else if (ret.equals(an[e])) {
                    String q1="恭喜你，回答正确";      //答案正确
                    tv.setText(q1);

                    correctn c = new correctn();
                    c.setI(1);

                    new Thread(){
                        @Override
                        public void run(){
                            super.run();
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException f) {
                                f.printStackTrace();
                            }
                            Intent intent= new Intent(First2_2Activity.this, First2_2Activity.class);
                            startActivity(intent);

                        }
                    }.start();
                } else {
                    String q3="答案错误，正确答案为";   //回答错误，并显示正确答案
                    tv.setText(q3+" "+an[e]+".    ");
                    new Thread(){
                        @Override
                        public void run(){
                            super.run();
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException f) {
                                f.printStackTrace();
                            }
                            Intent intent= new Intent(First2_2Activity.this, First2_2Activity.class);
                            startActivity(intent);

                        }
                    }.start();
                }
                e++;

                alln Q = new alln();
                Q.setI(1);
            }
        });


        nex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent= new Intent(First2_2Activity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

    }
}
