package io.github.keysecure.api.custody;

import io.github.keysecure.api.bean.custody.*;

import java.util.List;

/**
 * @author Custody
 * Funding related APIs
 */
public interface IBillingApi {

    WithdrawResult withdraw(WithdrawArgs args);

    WithdrawListResult withdrawList(List<String> requestIdList);

    WithdrawListResult syncWithdrawList(int maxId);

    DepositListResult depositList(List<Integer> idList);

    DepositListResult syncDepositList(int maxId);

    MinerFeeListResult minerFeeList(List<Integer> idList);

    MinerFeeListResult syncMinerFeeList(int maxId);
}
