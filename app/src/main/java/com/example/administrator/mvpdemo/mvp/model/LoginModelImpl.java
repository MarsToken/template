package com.example.administrator.mvpdemo.mvp.model;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public class LoginModelImpl implements ILoginModel {
    @Override
    public void login(final String name, final String pwd, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(name)) {
                    error = true;
                    listener.onUserNameError();
                }
                if (TextUtils.isEmpty(pwd)) {
                    error = true;
                    listener.onPasswordError();
                }
                if (!error) {
                    listener.onSuccess();
                }
            }
        }, 3000);
    }
}
