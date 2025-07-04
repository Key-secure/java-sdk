package io.github.keysecure.api.mpc.impl;

import io.github.keysecure.MpcConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.bean.BaseArgs;
import io.github.keysecure.api.bean.mpc.*;
import io.github.keysecure.api.mpc.IWorkSpaceApi;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.enums.MpcApiUri;
import io.github.keysecure.exception.ArgsNullException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Custody
 */
public class WorkSpaceApi extends CustodyApi implements IWorkSpaceApi {

    public WorkSpaceApi(MpcConfig cfg, IDataCrypto dataCrypto) {
        super(cfg, dataCrypto);
    }

    @Override
    public SupportMainChainResult getSupportMainChain() {
        return this.invoke(MpcApiUri.SUPPORT_MAIN_CHAIN, new BaseArgs(), SupportMainChainResult.class);
    }

    @Override
    public CoinDetailsResult getCoinDetails(String symbol, String baseSymbol, Boolean openChain) {
        GetCoinDetailsArgs args = new GetCoinDetailsArgs();
        args.setSymbol(symbol);
        args.setBaseSymbol(baseSymbol);
        args.setOpenChain(openChain);
        return this.invoke(MpcApiUri.COIN_DETAILS, args, CoinDetailsResult.class);
    }

    @Override
    public GetLastBlockHeightResult getLastBlockHeight(String baseSymbol) {
        if (StringUtils.isBlank(baseSymbol)) {
            throw new ArgsNullException("get last block height, the request parameter 'bas_sSymbol' empty");
        }

        GetLastBlockHeightArgs args = new GetLastBlockHeightArgs();
        args.setBaseSymbol(baseSymbol);
        return this.invoke(MpcApiUri.CHAIN_HEIGHT, args, GetLastBlockHeightResult.class);
    }
}
