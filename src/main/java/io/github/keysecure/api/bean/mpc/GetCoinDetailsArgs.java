package io.github.keysecure.api.bean.mpc;


import com.alibaba.fastjson.annotation.JSONField;
import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 */
public class GetCoinDetailsArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 8835435777668227645L;

    /**
     * Unique identifier for the coin, used for transfers, e.g.：USDTERC20
     * required : false
     */
    private String symbol;

    /**
     * Main chain coins, Unique identifier for the coin, used for transfers, e.g.：ETH
     * required : false
     */
    @JSONField(name = "base_symbol")
    private String baseSymbol;

    /**
     * Main chain coin, default to getting all, true to get opened coins, false to get unopened coins
     * required : false
     */
    @JSONField(name = "open_chain")
    private Boolean openChain;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    public Boolean getOpenChain() {
        return openChain;
    }

    public void setOpenChain(Boolean openChain) {
        this.openChain = openChain;
    }

}
