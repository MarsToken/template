package com.example.administrator.mvpdemo.mvp.model;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public interface ILoginModel {
    void login(String name, String pwd, OnLoginFinishedListener listener);
}
