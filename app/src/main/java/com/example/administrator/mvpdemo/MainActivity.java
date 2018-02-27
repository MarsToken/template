package com.example.administrator.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.administrator.mvpdemo.mvp.presenter.ILoginPresenter;
import com.example.administrator.mvpdemo.mvp.presenter.LoginPresenterImpl;
import com.example.administrator.mvpdemo.mvp.ui.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    private ProgressBar progressBar;
    private EditText userName;
    private EditText password;
    private ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressbar);
        userName = findViewById(R.id.name);
        password = findViewById(R.id.pwd);
        presenter = new LoginPresenterImpl(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        userName.setError("error");
    }

    @Override
    public void setPasswordError() {
        password.setError("error");
    }

    @Override
    public void navigateToHome() {
        //presenter.onDestroy();
        Toast.makeText(this, "login success!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(userName.getText().toString(), password.getText().toString());
    }
}
