package io.github.keysecure.api.bean.custody;


import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 * Merchant account balance
 */
public class CompanyAccountArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 3020904751246628592L;

    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
