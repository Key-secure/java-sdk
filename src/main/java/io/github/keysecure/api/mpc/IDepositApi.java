package io.github.keysecure.api.mpc;


import io.github.keysecure.api.bean.mpc.DepositRecordResult;

import java.util.List;

/**
 * @author Custody
 */
public interface IDepositApi {

    /**
     * Get Receiving records
     * Get all wallet receiving records under the workspace, and return up to 100 records
     * https://custodydocs-en.keysecure.io/api-references/mpc-apis/apis/deposit/deposit-list
     *
     * @param ids required: true
     *            Receiving id
     * @return DepositRecordResult
     */
    DepositRecordResult getDepositRecords(List<Integer> ids);

    /**
     * Synchronize Transfer(deposit) Records
     * https://custodydocs-en.keysecure.io/api-references/mpc-apis/apis/deposit/deposit-sync-list
     *
     * @param maxId required: true
     *              receiving record initial id, e.g.：100
     * @return DepositRecordResult
     */
    DepositRecordResult syncDepositRecords(Integer maxId);
}
