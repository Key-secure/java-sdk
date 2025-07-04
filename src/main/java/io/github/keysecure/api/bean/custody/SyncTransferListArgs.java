package io.github.keysecure.api.bean.custody;


import com.alibaba.fastjson.annotation.JSONField;
import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 * Sync transfer record list parameters
 */
public class SyncTransferListArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 2001795963308584747L;

    @JSONField(name ="max_id")
    private Integer maxId;

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }
}
