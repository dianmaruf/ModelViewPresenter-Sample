package com.swarawan.modelviewpresenter_sample.module.login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.swarawan.modelviewpresenter_sample.R;
import com.swarawan.modelviewpresenter_sample.module.login.model.Login;
import com.swarawan.modelviewpresenter_sample.module.login.presenter.LoginPresenter;
import com.swarawan.modelviewpresenter_sample.module.login.presenter.OnLoginListener;
import com.swarawan.modelviewpresenter_sample.module.student.view.StudentActivity;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText inputUsername, inputPassword;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUsername = findViewById(R.id.input_username);
        inputPassword = findViewById(R.id.input_password);
        loginButton = findViewById(R.id.button_login);

        loginButton.setOnClickListener(onLoginClicked);

        presenter = new LoginPresenter(onLoginListener);
    }

    private View.OnClickListener onLoginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Login login = new Login();
            login.username = inputUsername.getText().toString();
            login.password = inputPassword.getText().toString();

            presenter.loginNow(login);
        }
    };

    private OnLoginListener onLoginListener = new OnLoginListener() {
        @Override
        public void onLoginSuccess() {
            // start activity
            Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
            startActivity(intent);
        }

        @Override
        public void onLoginFailed(String message) {
            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };
}
