package io.github.keysecure.api.bean.custody;


import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 * userinfo query args
 */
public class UserInfoArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 3493015347893793835L;

    private String country;

    private String mobile;

    private String email;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
