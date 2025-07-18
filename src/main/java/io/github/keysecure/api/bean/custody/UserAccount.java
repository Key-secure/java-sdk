package io.github.keysecure.api.bean.custody;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Custody
 * user account entity
 */
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 4511031192480379674L;

    @JSONField(name ="normal_balance")
    private BigDecimal normalBalance;

    @JSONField(name ="lock_balance")
    private BigDecimal lockBalance;

    @JSONField(name ="deposit_address")
    private String depositAddress;

    public BigDecimal getNormalBalance() {
        return normalBalance;
    }

    public void setNormalBalance(BigDecimal normalBalance) {
        this.normalBalance = normalBalance;
    }

    public BigDecimal getLockBalance() {
        return lockBalance;
    }

    public void setLockBalance(BigDecimal lockBalance) {
        this.lockBalance = lockBalance;
    }

    public String getDepositAddress() {
        return depositAddress;
    }

    public void setDepositAddress(String depositAddress) {
        this.depositAddress = depositAddress;
    }
}
