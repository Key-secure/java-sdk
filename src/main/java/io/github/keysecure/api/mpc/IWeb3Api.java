package io.github.keysecure.api.mpc;


import io.github.keysecure.api.bean.mpc.CreateWeb3Args;
import io.github.keysecure.api.bean.mpc.CreateWeb3Result;
import io.github.keysecure.api.bean.mpc.Web3AccelerationArgs;
import io.github.keysecure.api.bean.mpc.Web3RecordResult;

import java.util.List;

/**
 * @author Custody
 */
public interface IWeb3Api {

    /**
     * Create Web3 Transaction
     * https://custodydocs-en.keysecure.io/api-references/mpc-apis/apis/web3/web3-create
     *
     * @param web3TransArgs       required true
     *                            create web3 transaction args
     * @param needTransactionSign transactions require signature fields
     * @return CreateWeb3Result
     */
    CreateWeb3Result createWeb3Trans(CreateWeb3Args web3TransArgs, boolean needTransactionSign);

    /**
     * Create Web3 Transaction
     * https://custodydocs-en.keysecure.io/api-references/mpc-apis/apis/web3/web3-create
     *
     * @param web3TransArgs required true
     *                      create web3 transaction args
     * @return CreateWeb3Result
     */
    CreateWeb3Result createWeb3Trans(CreateWeb3Args web3TransArgs);

    /**
     * Web3 Transaction Acceleration
     * https://custodydocs-en.keysecure.io/api-references/mpc-apis/apis/web3/web3-pending
     *
     * @param accelerationArgs required true
     *                         acceleration web3 transaction args
     * @return boolean
     */
    boolean accelerationWeb3Trans(Web3AccelerationArgs accelerationArgs);


    /**
     * Get Web3 Transaction Records
     * Get all Web3 transaction records under a wallet, maximum of 100 records.
     * https://custodydocs-en.keysecure.io/api-references/mpc-apis/apis/web3/web3-record-list
     *
     * @param requestIds required: true
     *                   many request_id string
     * @return Web3RecordResult
     */
    Web3RecordResult getWeb3Records(List<String> requestIds);

    /**
     * Sync Web3 Transaction Records
     * Get all Web3 transaction records under a wallet, maximum of 100 records.
     * https://custodydocs-en.keysecure.io/api-references/mpc-apis/apis/web3/web3-record-sync-list
     *
     * @param maxId required: true
     *              Starting ID of Web3 transactions, default:0
     * @return Web3RecordResult
     */
    Web3RecordResult syncWeb3Records(Integer maxId);


}
