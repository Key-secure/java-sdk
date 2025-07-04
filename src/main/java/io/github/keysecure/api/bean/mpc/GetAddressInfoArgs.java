package io.github.keysecure.api.bean.mpc;


import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 */
public class GetAddressInfoArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 2018358055861584592L;

    private String address;

    private String memo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
