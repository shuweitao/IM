package com.swt.im.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.swt.im.R;
import com.swt.im.utils.SharedPreferencesUtils;


/**
 * 登录页面
 * Created by swt on 2016/11/21.
 */
public class LoginActivity extends Activity implements OnClickListener {

    private EditText etName;
    private EditText etPwd;
    private ImageView iv_clean1;//清除用户名
    private ImageView iv_clean2;//清除密码
    private SharedPreferencesUtils sp;
    private int openNew = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            if (bundle.containsKey("openNew")) {
                openNew = bundle.getInt("openNew");
                Log.i("sean2", "LoginActivity++++++:" + openNew);
            }
        }
        sp = SharedPreferencesUtils.getInstance(this);

        setupView();
    }

    /**
     * 初始化控件
     */
    private void setupView() {
        TextView btnLogin = (TextView) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
        etPwd = (EditText) findViewById(R.id.etPwd);
        etName.setText(sp.getUserName());

        etName.addTextChangedListener(watcher1);
        etPwd.addTextChangedListener(watcher2);
        iv_clean1 = (ImageView) findViewById(R.id.iv_clean1);
        iv_clean2 = (ImageView) findViewById(R.id.iv_clean2);
        iv_clean1.setOnClickListener(this);
        iv_clean2.setOnClickListener(this);

        if (!TextUtils.isEmpty(etName.getText())) {
            iv_clean1.setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(etPwd.getText())) {
            iv_clean2.setVisibility(View.VISIBLE);
        }


    }

//    private class LoginTask extends LoadingDialog<Void, ResultModel> {
//        public LoginTask(Activity activity, int loadingMsg, int failMsg) {
//            super(activity, loadingMsg, failMsg);
//        }
//
//        @Override
//        public ResultModel doInBackground(Void... params) {
//            ResultModel ret = GetApi.login(etName.getText().toString().trim(), etPwd.getText().toString().trim());
//            return ret;
//        }
//
//        @Override
//        public void doStuffWithResult(ResultModel ret) {
////			MyApplication.user = new User();
////			MyApplication.user.setToken("test");
////			MyApplication.user.setName(etName.getText().toString().trim());
////			UiCommon.INSTANCE.showActivity(UiCommon.ACTIVITY_IDX_HOME, null);
//
//
//            if (ret.getResp_code() == 0) {
//                MyApplication.user = (User) ret.getData();
//                MyApplication.user.setAccountid(etName.getText().toString());
//                sp.setUserName(etName.getText().toString());
//                sp.setNikename(MyApplication.user.getName());
//                sp.setTOKEN(MyApplication.user.getToken());
//                if ((Integer) llCheckedBox.getTag() == 1) {
//                    sp.setCheckedLoginTime(System.currentTimeMillis());
//                    sp.setPassword(etPwd.getText().toString());
//                    sp.setIssave(1);
//                } else {
//                    sp.setCheckedLoginTime(0);
//                    sp.setPassword("");
//                    sp.setIssave(0);
//                }
//                Bundle b = new Bundle();
//                b.putInt("openNew", openNew);
//                UiCommon.INSTANCE.showActivity(UiCommon.ACTIVITY_IDX_HOME, b);
//            } else if (ret.getResp_code() == 8) {
//                sp.setPassword("");
//                UiCommon.INSTANCE.showTip("用户名或密码错误");
//            } else {
//                sp.setPassword("");
//                UiCommon.INSTANCE.showTip(getString(R.string.load_fail));
//            }
//        }
//    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.btnLogin:
                String name = etName.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                if (name.length() == 0) {
                    Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else if (pwd.length() == 0) {
                    Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

//                new LoginTask(this, R.string.loading, R.string.load_fail).executeOnExecutor(
//                        AsyncTask.THREAD_POOL_EXECUTOR);
                break;
            case R.id.iv_clean1:
                etName.setText("");
                break;
            case R.id.iv_clean2:
                etPwd.setText("");
                break;

            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    TextWatcher watcher1 = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            iv_clean1.setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(s.toString())) {
                iv_clean1.setVisibility(View.GONE);
            }
        }

    };

    TextWatcher watcher2 = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            iv_clean2.setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(s.toString())) {
                iv_clean2.setVisibility(View.GONE);
            }
        }

    };
}
