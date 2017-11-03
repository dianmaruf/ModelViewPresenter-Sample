package com.swarawan.modelviewpresenter_sample.module.login.presenter;

/**
 * Created by rioswarawan on 11/3/17.
 */

public interface OnLoginListener {

    void onLoginSuccess();

    void onLoginFailed(String message);
}
