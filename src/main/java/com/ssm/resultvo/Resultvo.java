package com.ssm.resultvo;

import java.util.List;

public class Resultvo {
    private int resultCode = 0;
    private String errMsg = "";
    private List data = null;

    public Resultvo() {
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
