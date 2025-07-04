package io.github.keysecure.api.mpc.impl;

import io.github.keysecure.MpcConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.bean.mpc.DepositRecordResult;
import io.github.keysecure.api.bean.mpc.GetDepositRecordArgs;
import io.github.keysecure.api.bean.mpc.SyncDepositRecordArgs;
import io.github.keysecure.api.mpc.IDepositApi;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.enums.MpcApiUri;
import io.github.keysecure.exception.ArgsNullException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author Custody
 */
public class DepositApi extends CustodyApi implements IDepositApi {

    public DepositApi(MpcConfig cfg, IDataCrypto dataCrypto) {
        super(cfg, dataCrypto);
    }

    @Override
    public DepositRecordResult getDepositRecords(List<Integer> ids) {
        if (ObjectUtils.isEmpty(ids) || ids.isEmpty()) {
            throw new ArgsNullException("the request parameter 'ids' empty");
        }

        GetDepositRecordArgs args = new GetDepositRecordArgs();
        args.setIds(StringUtils.join(ids, ","));

        return this.invoke(MpcApiUri.DEPOSIT_RECORDS, args, DepositRecordResult.class);
    }

    @Override
    public DepositRecordResult syncDepositRecords(Integer maxId) {
        SyncDepositRecordArgs args = new SyncDepositRecordArgs();
        args.setMaxId(ObjectUtils.isEmpty(maxId) ? 0 : maxId);

        return this.invoke(MpcApiUri.SYNC_DEPOSIT_RECORDS, args, DepositRecordResult.class);
    }
}
