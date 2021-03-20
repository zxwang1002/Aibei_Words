package com.example.dell.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class First2_3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first2_3);
        //声明控件
        TextView qu = (TextView) findViewById(R.id.textView3);
        Button submit = (Button) findViewById(R.id.button3);
        Button nex = (Button) findViewById(R.id.button2);

        final TextView tv = (TextView) findViewById(R.id.textView2);
        final RadioButton c1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton c2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton c3 = (RadioButton) findViewById(R.id.radioButton3);


        //10道题目
        final String[] quen;
        quen = new String[]{"object", "regulation","chew","bench","exploit","tear","glue",
                "institution", "partly", "glory"};


        //10道题目的答案
        final String[] an;
        an = new String[]{"B", "A", "C", "B", "C", "A", "B", "B", "C", "A"};


        //10道题的选项
        final String[][] se;
        se = new String[][]{
                {"n.承诺；许诺", "n.物体；v.反对", "v.缝补"}, {"n.法规，条例", "n.理发师", "adj.主观的"}, {"v.缝补", "n.承诺；许诺", "v.咀嚼"}, {"adj.主观的", "n.长凳", "adj.舒适的，安逸的"},
                {"n.承诺；许诺", "v.缝补", "v.剥削，利用"}, {"v.撕碎；n.眼泪", "adj.主观的", "n.承诺；许诺"}, {"adj.舒适的，安逸的", "n.胶水；v.用胶粘", "n.理发师"}, {"adj.主观的", "n.机构", "adj.舒适的，安逸的"},
                {"n.理发师", "v.缝补", "adv.部分地，在一定程度上"}, {"n.光荣，荣誉", "n.理发师", "n.承诺；许诺"}
        };


        final CCC b = new CCC();      //CCC的作用是是：产生一个0~10的随机数，存储在cnt中
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
                            Intent intent= new Intent(First2_3Activity.this, First2_3Activity.class);
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
                            Intent intent= new Intent(First2_3Activity.this, First2_3Activity.class);
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
                Intent intent= new Intent(First2_3Activity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

    }
}
