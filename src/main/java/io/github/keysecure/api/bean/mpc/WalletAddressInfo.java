package io.github.keysecure.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author Custody
 */
public class WalletAddressInfo implements Serializable {

    private static final long serialVersionUID = 7615919625046960924L;

    /**
     * Wallet ID
     */
    @JSONField(name = "sub_wallet_id")
    private Integer subWalletId;

    /**
     * Address type, 1: User address, 2: System address (including collection address, change address).
     * System address cannot be assigned to users, change from UTXO transactions will all go to the change address
     */
    @JSONField(name = "addr_type")
    private Integer addrType;

    /**
     * Unique coin identifier
     */
    @JSONField(name = "merge_address_symbol")
    private String mergeAddressSymbol;

    public Integer getSubWalletId() {
        return subWalletId;
    }

    public void setSubWalletId(Integer subWalletId) {
        this.subWalletId = subWalletId;
    }

    public Integer getAddrType() {
        return addrType;
    }

    public void setAddrType(Integer addrType) {
        this.addrType = addrType;
    }

    public String getMergeAddressSymbol() {
        return mergeAddressSymbol;
    }

    public void setMergeAddressSymbol(String mergeAddressSymbol) {
        this.mergeAddressSymbol = mergeAddressSymbol;
    }
}
