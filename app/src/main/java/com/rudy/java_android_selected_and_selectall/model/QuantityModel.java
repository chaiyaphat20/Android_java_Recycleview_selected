package com.rudy.java_android_selected_and_selectall.model;

public class QuantityModel {
    public QuantityModel(String data, boolean isCheck) {
        this.data = data;
        this.isCheck = isCheck;
    }

    String data;
    boolean isCheck = false;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
