package com.uyoung.web.bean;

/**
 * User: KennyZhu
 * Date: 15/9/28
 * Desc:
 */
public class BaseResult {
    private int result;
    private String resultDesc;
    private Object resultData;

    public BaseResult(int result, String resultDesc) {
        this.result = result;
        this.resultDesc = resultDesc;
    }

    public BaseResult() {

    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
}
