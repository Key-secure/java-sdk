package io.github.keysecure.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 */
public class SyncDepositRecordArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 1013291748580371783L;

    /**
     * Custody withdraw record id
     */
    @JSONField(name = "max_id")
    private Integer maxId;

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }
}
