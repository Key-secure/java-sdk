package io.github.keysecure.api.bean.custody;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 * Batch query withdrawal records
 */
public class StringIdsArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 7418332321561807830L;

    @JSONField(name ="ids")
    private String idList;

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }
}
