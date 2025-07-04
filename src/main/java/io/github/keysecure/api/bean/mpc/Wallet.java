package io.github.keysecure.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author Custody
 * Create wallet : https://custodydocs-en.keysecure.io/api-references/mpc-apis/apis/sub-wallet/subwallet-create
 */
public class Wallet implements Serializable {

    private static final long serialVersionUID = 4910110162836998092L;

    /**
     * wallet id
     */
    @JSONField(name = "sub_wallet_id")
    private Integer subWalletId;

    public Integer getSubWalletId() {
        return subWalletId;
    }

    public void setSubWalletId(Integer subWalletId) {
        this.subWalletId = subWalletId;
    }
}
