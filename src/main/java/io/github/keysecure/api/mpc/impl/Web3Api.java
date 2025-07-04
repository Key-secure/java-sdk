package io.github.keysecure.api.mpc.impl;

import io.github.keysecure.MpcConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.bean.Result;
import io.github.keysecure.api.bean.mpc.*;
import io.github.keysecure.api.mpc.IWeb3Api;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.enums.MpcApiUri;
import io.github.keysecure.exception.ArgsNullException;
import io.github.keysecure.exception.ConfigException;
import io.github.keysecure.exception.CryptoException;
import io.github.keysecure.util.Md5Util;
import io.github.keysecure.util.MpcSignUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Custody
 */
public class Web3Api extends CustodyApi implements IWeb3Api {

    public Web3Api(MpcConfig cfg, IDataCrypto dataCrypto) {
        super(cfg, dataCrypto);
    }

    @Override
    public CreateWeb3Result createWeb3Trans(CreateWeb3Args createWeb3Args, boolean needTransactionSign) {
        if (ObjectUtils.isEmpty(createWeb3Args)) {
            throw new ArgsNullException("mpc create web3 transaction args empty");
        }

        if (needTransactionSign && StringUtils.isBlank(((MpcConfig) this.cfg).getSignPrivateKey())) {
            logger.error("mpc create web3 transaction, requires the 'sign' parameter, but the configured 'signPrivateKey' data is empty");
            throw new ConfigException("configure 'signPrivateKey' as empty");
        }

        if (needTransactionSign) {
            Map<String, String> signParamsMap = MpcSignUtil.getWeb3SignParams(createWeb3Args);
            String signData = MpcSignUtil.paramsSort(signParamsMap);
            if (StringUtils.isBlank(signData)) {
                throw new CryptoException("mpc create web3 transaction, parameter signing failed");
            }
            this.info("mpc create web3 transaction, sign params string:{}, md5:{}", signData, Md5Util.getMd5(signData));

            String sign = MpcSignUtil.sign(signData, ((MpcConfig) this.cfg).getSignPrivateKey());
            if (StringUtils.isBlank(sign)) {
                throw new CryptoException("mpc create web3 transaction, sign parameter error");
            }
            // set sign params
            createWeb3Args.setSign(sign);
        }

        return this.invoke(MpcApiUri.CREATE_WEB3_TRANSACTION, createWeb3Args, CreateWeb3Result.class);
    }

    @Override
    public CreateWeb3Result createWeb3Trans(CreateWeb3Args web3TransArgs) {
        if (ObjectUtils.isEmpty(web3TransArgs)) {
            throw new ArgsNullException("mpc create web3 transaction args empty");
        }

        return this.invoke(MpcApiUri.CREATE_WEB3_TRANSACTION, web3TransArgs, CreateWeb3Result.class);
    }

    @Override
    public boolean accelerationWeb3Trans(Web3AccelerationArgs accelerationArgs) {
        if (ObjectUtils.isEmpty(accelerationArgs)) {
            throw new ArgsNullException("acceleration web3 transaction args empty");
        }

        Result result = this.invoke(MpcApiUri.WEB3_TRANS_ACCELERATION, accelerationArgs, Result.class);

        return !ObjectUtils.isEmpty(result) && result.getCode().equalsIgnoreCase("0");
    }


    @Override
    public Web3RecordResult getWeb3Records(List<String> requestIds) {
        if (ObjectUtils.isEmpty(requestIds) || requestIds.isEmpty()) {
            throw new ArgsNullException("get web3 records, the request parameter 'ids' empty");
        }

        GetTransactionRecordArgs args = new GetTransactionRecordArgs();
        args.setIds(StringUtils.join(requestIds, ","));

        return this.invoke(MpcApiUri.WEB3_TRANS_RECORDS, args, Web3RecordResult.class);
    }

    @Override
    public Web3RecordResult syncWeb3Records(Integer maxId) {
        SyncTransactionRecordArgs args = new SyncTransactionRecordArgs();
        args.setMaxId(ObjectUtils.isEmpty(maxId) ? 0 : maxId);

        return this.invoke(MpcApiUri.SYNC_WEB3_RECORDS, args, Web3RecordResult.class);
    }
}
