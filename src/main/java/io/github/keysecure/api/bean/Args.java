package io.github.keysecure.api.bean;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.keysecure.enums.AsyncNotifyType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Custody
 */
public class Args implements Serializable {

    private static final long serialVersionUID = 9084284544827752321L;

    @JSONField(name ="app_id")
    private String appId;

    @JSONField(name ="data")
    private String data;

    @JSONField(name ="data_type")
    private AsyncNotifyType dataType;

    public Args() {
    }

    public Args(String appId, String data) {
        this.appId = appId;
        this.data = data;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public AsyncNotifyType getDataType() {
        return dataType;
    }

    public void setDataType(AsyncNotifyType dataType) {
        this.dataType = dataType;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>(2, 1);
        map.put("app_id", this.appId);
        map.put("data", this.data);

        if (this.dataType != null) {
            map.put("data_type", this.dataType.name());
        }
        return map;
    }

    @Override
    public String toString() {
        String s = String.format("app_id=%s&data=%s", this.appId, this.data);
        if (this.dataType != null) {
            s += "&data_type=" + this.dataType.name();
        }
        return s;
    }
}
