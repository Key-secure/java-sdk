package io.github.keysecure.api.custody.impl;

import io.github.keysecure.CustodyConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.custody.ITransferApi;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.enums.ApiUri;
import io.github.keysecure.exception.ArgsNullException;
import io.github.keysecure.api.bean.custody.*;

/**
 * @author Custody
 * Transfer operation related api
 */
public class TransferApi extends CustodyApi implements ITransferApi {

    public TransferApi(CustodyConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    /**
     * Custody internal merchants transfer money to each other
     */
    @Override
    public TransferResult accountTransfer(TransferArgs args) {
        if (args == null) {
            throw new ArgsNullException("args can not be null");
        }
        return this.invoke(ApiUri.ACCOUNT_TRANSFER, args, TransferResult.class);
    }

    /**
     * Query transfer records
     */
    @Override
    public TransferListResult getAccountTransferList(String ids, String idsType) {
        TransferListArgs args = new TransferListArgs();
        args.setIds(ids);
        args.setIdsType(idsType);
        return this.invoke(ApiUri.ACCOUNT_TRANSFER_LIST, args, TransferListResult.class);
    }

    /**
     * Sync transfer records
     */
    @Override
    public TransferListResult syncAccountTransferList(Integer maxId) {
        SyncTransferListArgs args = new SyncTransferListArgs();
        args.setMaxId(maxId);
        return this.invoke(ApiUri.SYNC_ACCOUNT_TRANSFER_LIST, args, TransferListResult.class);
    }

}
