package com.example.booksolx.model;

public class UserCheck {
    private boolean userNameValid;
    private boolean emailValid;
    private boolean mobileNumberValid;

    public UserCheck() {
    }

    public boolean isUserNameValid() {
        return userNameValid;
    }

    public void setUserNameValid(boolean userNameValid) {
        this.userNameValid = userNameValid;
    }

    public boolean isEmailValid() {
        return emailValid;
    }

    public void setEmailValid(boolean emailValid) {
        this.emailValid = emailValid;
    }

    public boolean isMobileNumberValid() {
        return mobileNumberValid;
    }

    public void setMobileNumberValid(boolean mobileNumberValid) {
        this.mobileNumberValid = mobileNumberValid;
    }
}
