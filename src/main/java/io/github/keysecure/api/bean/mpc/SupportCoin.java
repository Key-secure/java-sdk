package io.github.keysecure.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author Custody
 */
public class SupportCoin implements Serializable {

    private static final long serialVersionUID = -2359947149713191632L;

    /**
     * Unique identifier for the coin, e.g.：ETH
     */
    private String symbol;

    /**
     * Coin network, e.g.：ETH
     */
    @JSONField(name = "coin_net")
    private String coinNet;

    /**
     * Real name of the coin, e.g.：ETH
     */
    @JSONField(name = "symbol_alias")
    private String symbolAlias;


    /**
     * Indicates if acceleration is supported (true/false)
     */
    @JSONField(name = "support_acceleration")
    private Boolean supportAcceleration;

    /**
     * Indicates if the main chain is opened (false/true)
     */
    @JSONField(name = "if_open_chain")
    private Boolean ifOpenChain;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCoinNet() {
        return coinNet;
    }

    public void setCoinNet(String coinNet) {
        this.coinNet = coinNet;
    }

    public String getSymbolAlias() {
        return symbolAlias;
    }

    public void setSymbolAlias(String symbolAlias) {
        this.symbolAlias = symbolAlias;
    }

    public Boolean getSupportAcceleration() {
        return supportAcceleration;
    }

    public void setSupportAcceleration(Boolean supportAcceleration) {
        this.supportAcceleration = supportAcceleration;
    }

    public Boolean getIfOpenChain() {
        return ifOpenChain;
    }

    public void setIfOpenChain(Boolean ifOpenChain) {
        this.ifOpenChain = ifOpenChain;
    }
}
