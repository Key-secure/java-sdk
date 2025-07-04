package io.github.keysecure.api.custody;

import io.github.keysecure.api.bean.custody.TransferArgs;
import io.github.keysecure.api.bean.custody.TransferListResult;
import io.github.keysecure.api.bean.custody.TransferResult;

/**
 * @author Custody
 * Transfer operation related api
 */
public interface ITransferApi {

    String REQUEST_ID = "request_id";
    String RECEIPT = "receipt";

    /**
     * Custody internal merchants transfer money to each other
     * @param  args TransferArgs
     * @return TransferResult
     */
    TransferResult accountTransfer(TransferArgs args);

    /**
     * Query transfer records
     * @param idsType String
     * @param ids String
     * @return  TransferListResult
     */
    TransferListResult getAccountTransferList(String ids, String idsType);

    /**
     * Sync transfer records
     * @param maxId Integer
     * @return TransferListResult
     */
    TransferListResult syncAccountTransferList(Integer maxId);

}
