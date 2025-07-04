package io.github.keysecure.api.custody.impl;

import io.github.keysecure.CustodyConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.custody.IBillingApi;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.enums.ApiUri;
import io.github.keysecure.exception.ArgsNullException;
import io.github.keysecure.api.bean.custody.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author Custody
 * Fund related api
 */
public class BillingApi extends CustodyApi implements IBillingApi {

    public BillingApi(CustodyConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    @Override
    public WithdrawResult withdraw(WithdrawArgs args) {
        if (args == null) {
            throw new ArgsNullException("args can not be null");
        }
        return this.invoke(ApiUri.BILLING_WITHDRAW, args, WithdrawResult.class);
    }

    @Override
    public WithdrawListResult withdrawList(List<String> idList) {
        StringIdsArgs args = new StringIdsArgs();
        args.setIdList(StringUtils.join(idList, ","));
        return this.invoke(ApiUri.WITHDRAW_LIST, args, WithdrawListResult.class);
    }

    @Override
    public WithdrawListResult syncWithdrawList(int maxId) {
        SyncWithdrawArgs args = new SyncWithdrawArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_WITHDRAW, args, WithdrawListResult.class);
    }

    @Override
    public DepositListResult depositList(List<Integer> idList) {
        StringIdsArgs args = new StringIdsArgs();
        args.setIdList(StringUtils.join(idList, ","));
        return this.invoke(ApiUri.DEPOSIT_LIST, args, DepositListResult.class);
    }

    @Override
    public DepositListResult syncDepositList(int maxId) {
        SyncDepositArgs args = new SyncDepositArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_DEPOSIT, args, DepositListResult.class);
    }

    @Override
    public MinerFeeListResult minerFeeList(List<Integer> idList) {
        StringIdsArgs args = new StringIdsArgs();
        args.setIdList(StringUtils.join(idList, ","));
        return this.invoke(ApiUri.MINER_FEE_LIST, args, MinerFeeListResult.class);
    }

    @Override
    public MinerFeeListResult syncMinerFeeList(int maxId) {
        SyncDepositArgs args = new SyncDepositArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_MINER_FEE, args, MinerFeeListResult.class);
    }
}
