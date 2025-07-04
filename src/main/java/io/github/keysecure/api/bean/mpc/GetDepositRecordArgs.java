package io.github.keysecure.api.bean.mpc;

import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 */
public class GetDepositRecordArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 4874475032767801784L;

    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

}
