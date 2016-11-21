package com.swt.im.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesUtils {
    public final static String SELECTDATE = "im";

    public final static String TOKEN = "token";//
    public final static String NIKENAME = "nikeName";//昵称
    public final static String USERNAME = "etName";//账号
    public final static String PASSWORD = "etPwd";//密码
    public final static String CHECKED_LOGIN_TIME = "checked_login_time";//记住密码的当前时间
    public final static String ISSAVE = "is_save";//是否免登录；0要登录，1免登录

    public SharedPreferences sharedpreferences;
    private static SharedPreferencesUtils instance;

    public static SharedPreferencesUtils getInstance(Context mContext) {
        if (instance == null) {
            instance = new SharedPreferencesUtils(mContext);
        }
        return instance;
    }

    public SharedPreferencesUtils(Context mContext) {
        sharedpreferences = mContext.getSharedPreferences(SELECTDATE, 0);
    }


    public void setUserName(String userName) {
        Editor editor = sharedpreferences.edit();
        editor.putString(USERNAME, userName);
        editor.commit();
    }

    public String getNikename() {
        return sharedpreferences.getString(NIKENAME, null);
    }

    public void setNikename(String nikename) {
        Editor editor = sharedpreferences.edit();
        editor.putString(NIKENAME, nikename);
        editor.commit();
    }

    public String getUserName() {
        return sharedpreferences.getString(USERNAME, null);
    }

    public void setPassword(String password) {
        Editor editor = sharedpreferences.edit();
        editor.putString(PASSWORD, password);
        editor.commit();
    }

    public String getPassword() {
        return sharedpreferences.getString(PASSWORD, null);
    }

    public void setCheckedLoginTime(long loginTime) {
        Editor editor = sharedpreferences.edit();
        editor.putLong(CHECKED_LOGIN_TIME, loginTime);
        editor.commit();
    }

    public long getCheckedLoginTime() {
        return sharedpreferences.getLong(CHECKED_LOGIN_TIME, 0);
    }

    public int getIssave() {
        return sharedpreferences.getInt(ISSAVE, 0);
    }

    public void setIssave(int issave) {
        Editor editor = sharedpreferences.edit();
        editor.putInt(ISSAVE, issave);
        editor.commit();
    }


    public String getTOKEN() {
        return sharedpreferences.getString(TOKEN, "");
    }

    public void setTOKEN(String token) {
        Editor editor = sharedpreferences.edit();
        editor.putString(TOKEN, token);
        editor.commit();
    }
}
