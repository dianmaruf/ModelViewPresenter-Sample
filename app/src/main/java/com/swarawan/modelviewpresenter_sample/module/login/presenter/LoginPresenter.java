package com.swarawan.modelviewpresenter_sample.module.login.presenter;

import android.util.Log;

import com.swarawan.modelviewpresenter_sample.module.login.model.Login;

/**
 * Created by rioswarawan on 11/3/17.
 */

public class LoginPresenter {

    private OnLoginListener listener;

    public LoginPresenter(OnLoginListener listener) {
        this.listener = listener;
    }

    public void loginNow(Login login) {
        if (!isFormValid(login)) {
            listener.onLoginFailed("Form tidak boleh ada yang kosong");
            return;
        }

        if ("binarian".equals(login.username) &&
                "12345678".equals(login.password)) {
            listener.onLoginSuccess();
        } else {
            listener.onLoginFailed("Username / Password salah");
        }
    }

    private Boolean isFormValid(Login login) {
        if ("".equals(login.username)) {
            return false;
        } else if ("".equals(login.password)) {
            return false;
        }
        return true;
    }
}
