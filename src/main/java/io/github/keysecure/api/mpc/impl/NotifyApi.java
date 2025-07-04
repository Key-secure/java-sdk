package io.github.keysecure.api.mpc.impl;

import com.alibaba.fastjson.JSONObject;
import io.github.keysecure.MpcConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.bean.mpc.NotifyArgs;
import io.github.keysecure.api.mpc.INotifyApi;
import io.github.keysecure.crypto.IDataCrypto;
import org.apache.commons.lang3.StringUtils;

public class NotifyApi extends CustodyApi implements INotifyApi {

    public NotifyApi(MpcConfig cfg, IDataCrypto dataCrypto) {
        super(cfg, dataCrypto);
    }

    @Override
    public NotifyArgs notifyRequest(String cipher) {
        if (StringUtils.isBlank(cipher)) {
            logger.info("NotifyRequest cipher can not be empty");
            return null;
        }

        String raw = this.dataCrypto.decode(cipher);
        logger.info("NotifyRequest decode data:{}", raw);
        if (StringUtils.isBlank(raw)) {
            logger.error("NotifyRequest decode cipher return null");
            return null;
        }

        NotifyArgs notify = JSONObject.parseObject(raw, NotifyArgs.class);
        if (notify == null) {
            logger.error("NotifyRequest json decode return null");
            return null;
        }
        return notify;
    }

}
