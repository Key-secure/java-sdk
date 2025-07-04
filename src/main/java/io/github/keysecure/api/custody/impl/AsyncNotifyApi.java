package io.github.keysecure.api.custody.impl;

import com.alibaba.fastjson.JSONObject;
import io.github.keysecure.CustodyConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.bean.custody.AsyncNotifyArgs;
import io.github.keysecure.api.bean.custody.WithdrawArgs;
import io.github.keysecure.api.custody.IAsyncNotifyApi;
import io.github.keysecure.crypto.IDataCrypto;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Custody
 */
public class AsyncNotifyApi extends CustodyApi implements IAsyncNotifyApi {

    public AsyncNotifyApi(CustodyConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    @Override
    public AsyncNotifyArgs notifyRequest(String cipher) {
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

        AsyncNotifyArgs notify = JSONObject.parseObject(raw, AsyncNotifyArgs.class);
        if (notify == null) {
            logger.error("NotifyRequest json decode return null");
            return null;
        }
        return notify;
    }

    @Override
    public WithdrawArgs verifyRequest(String cipher) {
        if (StringUtils.isBlank(cipher)) {
            this.info("VerifyRequest cipher can not be empty");
            return null;
        }

        String raw = this.dataCrypto.decode(cipher);
        this.info("VerifyRequest decode data:{}", raw);
        if (StringUtils.isBlank(raw)) {
            logger.error("VerifyRequest decode cipher return null");
            return null;
        }

        WithdrawArgs withdraw = JSONObject.parseObject(raw, WithdrawArgs.class);
        if (withdraw == null) {
            logger.error("VerifyRequest json decode withdraw return null");
            return null;
        }
        return withdraw;
    }

    @Override
    public String verifyResponse(WithdrawArgs withdraw) {
        if (withdraw == null) {
            logger.error("VerifyResponse withdraw can not be empty");
            return null;
        }

        String withdrawJson = JSONObject.toJSONString(withdraw);

        String raw = this.dataCrypto.encode(withdrawJson);
        if (StringUtils.isBlank(raw)) {
            logger.error("VerifyResponse encode cipher return null");
            return null;
        }
        return raw;
    }
}
