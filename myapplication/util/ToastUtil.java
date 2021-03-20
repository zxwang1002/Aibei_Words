package com.example.dell.myapplication.util;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2019/4/20.
 */

public class ToastUtil {
    public static Toast mToast;     //定义Toast
    public static void showMsg(Context context, String msg){ //显示信息的方法，传参：界面信息，要显示的信息
        if(mToast==null){
            mToast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else{
            mToast.setText(msg);
        }
        mToast.show();
    }
}