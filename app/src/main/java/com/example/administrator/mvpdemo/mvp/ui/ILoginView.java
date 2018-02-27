package com.example.administrator.mvpdemo.mvp.ui;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public interface ILoginView {
    void showProgress();

    void hideProgress();

    void setUserNameError();

    void setPasswordError();

    void navigateToHome();
}
