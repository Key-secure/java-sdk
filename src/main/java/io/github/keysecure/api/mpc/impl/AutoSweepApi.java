package io.github.keysecure.api.mpc.impl;

import io.github.keysecure.MpcConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.bean.mpc.*;
import io.github.keysecure.api.mpc.IAutoSweepApi;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.enums.MpcApiUri;
import io.github.keysecure.exception.ArgsNullException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Custody
 */
public class AutoSweepApi extends CustodyApi implements IAutoSweepApi {

    public AutoSweepApi(MpcConfig cfg, IDataCrypto dataCrypto) {
        super(cfg, dataCrypto);
    }

    @Override
    public AutoCollectWalletsResult autoCollectSubWallets(String symbol) {
        if (StringUtils.isBlank(symbol)) {
            throw new ArgsNullException("the request parameter 'symbol' empty");
        }

        GetAutoCollectWalletArgs args = new GetAutoCollectWalletArgs();
        args.setSymbol(symbol);

        return this.invoke(MpcApiUri.AUTO_COLLECT_WALLETS, args, AutoCollectWalletsResult.class);
    }

    @Override
    public SetAutoCollectSymbolResult setAutoCollectSymbol(String symbol, String collectMin, String fuelingLimit) {
        if (StringUtils.isBlank(symbol)) {
            throw new ArgsNullException("the request parameter 'symbol' empty");
        }

        if (StringUtils.isBlank(collectMin)) {
            throw new ArgsNullException("the request parameter 'collect_min' empty");
        }

        if (StringUtils.isBlank(fuelingLimit)) {
            throw new ArgsNullException("the request parameter 'fueling_limit' empty");
        }

        SetAutoCollectSymbolArgs args = new SetAutoCollectSymbolArgs();
        args.setSymbol(symbol);
        args.setCollectMin(collectMin);
        args.setFuelingLimit(fuelingLimit);

        return this.invoke(MpcApiUri.SET_AUTO_COLLECT_SYMBOL, args, SetAutoCollectSymbolResult.class);
    }

    @Override
    public AutoCollectRecordResult syncAutoCollectRecords(Integer maxId) {
        SyncTransactionRecordArgs args = new SyncTransactionRecordArgs();
        args.setMaxId(ObjectUtils.isEmpty(maxId) ? 0 : maxId);

        return this.invoke(MpcApiUri.SYNC_AUTO_SWEEP_RECORDS, args, AutoCollectRecordResult.class);
    }
}
