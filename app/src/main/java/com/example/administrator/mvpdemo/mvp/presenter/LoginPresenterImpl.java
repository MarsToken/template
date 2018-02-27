package com.example.administrator.mvpdemo.mvp.presenter;

import com.example.administrator.mvpdemo.mvp.model.ILoginModel;
import com.example.administrator.mvpdemo.mvp.model.LoginModelImpl;
import com.example.administrator.mvpdemo.mvp.model.OnLoginFinishedListener;
import com.example.administrator.mvpdemo.mvp.ui.ILoginView;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public class LoginPresenterImpl implements ILoginPresenter, OnLoginFinishedListener {
    private ILoginView loginView;
    private ILoginModel loginModel;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (null != loginView) {
            loginView.showProgress();
        }
        loginModel.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUserNameError() {
        if (loginView != null) {
            loginView.setUserNameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (null != loginView) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (null != loginView) {
            loginView.hideProgress();
            loginView.navigateToHome();
        }
    }
}
