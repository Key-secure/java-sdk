package io.github.keysecure.api.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @author CUstody
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -6240736530698048710L;

    private static final String SUCCESS_CODE = "0";

    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toJson() {
        return JSONObject.toJSONString(this);
    }

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(this.getCode());
    }
}
