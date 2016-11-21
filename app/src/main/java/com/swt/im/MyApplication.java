package com.swt.im;

import android.app.Application;

import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;
import com.swt.im.model.Model;

/**
 * Created by swt on 2016/11/21.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化环信EasyUI
        EMOptions options = new EMOptions();
        options.setAcceptInvitationAlways(false);// 默认添加好友时，是不需要验证的，改成需要验证
        options.setAutoAcceptGroupInvitation(false);// 默认群添加好友时，是不需要验证的，改成需要验证
        EaseUI.getInstance().init(this, options);

        //初始化
        Model.getInstance().init(this);
    }
}
