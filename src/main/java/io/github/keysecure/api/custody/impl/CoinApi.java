package io.github.keysecure.api.custody.impl;

import io.github.keysecure.CustodyConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.bean.custody.CoinInfoArgs;
import io.github.keysecure.api.bean.custody.CoinInfoListResult;
import io.github.keysecure.api.custody.ICoinApi;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.enums.ApiUri;

/**
 * @author Custody
 * coin related api
 */
public class CoinApi extends CustodyApi implements ICoinApi {

    public CoinApi(CustodyConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    @Override
    public CoinInfoListResult getCoinList() {
        CoinInfoArgs args = new CoinInfoArgs();
        return this.invoke(ApiUri.COIN_LIST, args, CoinInfoListResult.class);
    }
}
