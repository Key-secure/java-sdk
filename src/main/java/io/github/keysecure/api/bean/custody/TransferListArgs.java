package io.github.keysecure.api.bean.custody;


import com.alibaba.fastjson.annotation.JSONField;
import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 * Transfer Record List Parameters
 */
public class TransferListArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 2368315566759720927L;

    private String ids;

    /**
     * id type（request_id：request ID（default）；receipt：） ids_type
     */
    @JSONField(name = "ids_type")
    private String idsType;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getIdsType() {
        return idsType;
    }

    public void setIdsType(String idsType) {
        this.idsType = idsType;
    }
}
