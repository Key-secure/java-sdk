package io.github.keysecure.api.bean.custody;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Custody
 * Merchant account balance
 */
public class CompanyAccountResult implements Serializable {

    private static final long serialVersionUID = -6260689780157415419L;

    private String symbol;

    private BigDecimal amount;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
