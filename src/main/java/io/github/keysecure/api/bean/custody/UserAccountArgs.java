package io.github.keysecure.api.bean.custody;

import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 * user account args
 */
public class UserAccountArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 4382599705708634083L;

    private Integer uid;

    private String symbol;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
