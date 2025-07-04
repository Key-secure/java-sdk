package io.github.keysecure.api.bean.mpc;


import com.alibaba.fastjson.annotation.JSONField;
import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 */
public class GetLastBlockHeightArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 5725608221014531468L;

    @JSONField(name = "base_symbol")
    private String baseSymbol;

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }
}
