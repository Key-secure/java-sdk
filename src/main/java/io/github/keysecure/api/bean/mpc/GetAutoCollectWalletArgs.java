package io.github.keysecure.api.bean.mpc;

import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 */
public class GetAutoCollectWalletArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 8978228705962627779L;

    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
