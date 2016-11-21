package com.swt.im.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.hyphenate.chat.EMClient;
import com.swt.im.R;
import com.swt.im.model.Model;

/**
 * 闪屏页
 * Created by swt on 2016/11/21.
 */

public class RootActivity extends Activity {
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //如果当前Activity已经销毁，我就不处理handler消息
            if (isFinishing()) {
                return;
            }

            toMianOrLogin();
        }
    };

    //判断进入主页面还是登录页面
    private void toMianOrLogin() {

        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                //判断当前账号是否已经登录
                if (EMClient.getInstance().isLoggedInBefore()) {
                    //登录过，跳转至主页面
                    Intent intent = new Intent(RootActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    //没登录过
                    Intent intent = new Intent(RootActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

                //结束当前页面
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root);
        //延迟2s发送一个消息，进入主页面
        handler.sendMessageDelayed(Message.obtain(), 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁当前页面中所有的handler
        handler.removeCallbacksAndMessages(null);
    }
}
