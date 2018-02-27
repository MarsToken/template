package com.example.administrator.mvpdemo.mvp.presenter;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public interface ILoginPresenter {
    /**
     * 登录验证
     *
     * @param username
     * @param password
     */
    void validateCredentials(String username, String password);

    void onDestroy();
}
