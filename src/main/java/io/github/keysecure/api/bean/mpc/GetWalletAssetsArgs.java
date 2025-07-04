package io.github.keysecure.api.bean.mpc;


import com.alibaba.fastjson.annotation.JSONField;
import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 */
public class GetWalletAssetsArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = -8831747607916221135L;

    @JSONField(name = "sub_wallet_id")
    private Integer subWalletId;

    private String symbol;

    public Integer getSubWalletId() {
        return subWalletId;
    }

    public void setSubWalletId(Integer subWalletId) {
        this.subWalletId = subWalletId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
