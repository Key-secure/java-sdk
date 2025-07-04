package io.github.keysecure.api.custody;

import io.github.keysecure.api.bean.custody.CoinInfoListResult;

/**
 * @author Custody
 * coin related api
 *
 */
public interface ICoinApi {

    /**
     * get coin list
     * @return CoinInfoListResult
     */
    CoinInfoListResult getCoinList();
}
