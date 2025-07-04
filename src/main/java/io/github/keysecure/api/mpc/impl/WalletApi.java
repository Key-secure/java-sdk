package io.github.keysecure.api.mpc.impl;

import io.github.keysecure.MpcConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.bean.Result;
import io.github.keysecure.api.bean.mpc.*;
import io.github.keysecure.api.mpc.IWalletApi;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.enums.AppShowStatus;
import io.github.keysecure.enums.MpcApiUri;
import io.github.keysecure.exception.ArgsNullException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author Custody
 */
public class WalletApi extends CustodyApi implements IWalletApi {

    public WalletApi(MpcConfig cfg, IDataCrypto dataCrypto) {
        super(cfg, dataCrypto);
    }

    @Override
    public WalletResult createWallet(String walletName, AppShowStatus showStatus) {
        if (StringUtils.isBlank(walletName)) {
            throw new ArgsNullException("the request parameter 'sub_wallet_name' is required");
        }

        if (walletName.length() > 50) {
            throw new ArgsNullException("the length of parameter 'sub_wallet_name' cannot be greater than 50");
        }

        if (ObjectUtils.isEmpty(showStatus)) {
            showStatus = AppShowStatus.HIDDEN;
        }

        CreateWalletArgs args = new CreateWalletArgs();
        args.setSubWalletName(walletName);
        args.setAppShowStatus(showStatus.getShowStatus());

        return this.invoke(MpcApiUri.CREATE_WALLET, args, WalletResult.class);
    }

    @Override
    public WalletAddressResult createWalletAddress(Integer walletId, String symbol) {
        if (ObjectUtils.isEmpty(walletId)) {
            throw new ArgsNullException("the request parameter 'sub_wallet_id' is required");
        }

        if (StringUtils.isBlank(symbol)) {
            throw new ArgsNullException("the request parameter 'symbol' is required");
        }

        CreateWalletAddressArgs args = new CreateWalletAddressArgs();
        args.setSubWalletId(walletId);
        args.setSymbol(symbol);

        return this.invoke(MpcApiUri.CREATE_WALLET_ADDRESS, args, WalletAddressResult.class);
    }

    @Override
    public WalletAddressListResult queryWalletAddress(Integer walletId, String symbol, Integer maxId) {
        if (ObjectUtils.isEmpty(walletId)) {
            throw new ArgsNullException("the request parameter 'sub_wallet_id' is required");
        }

        if (StringUtils.isBlank(symbol)) {
            throw new ArgsNullException("the request parameter 'symbol' is required");
        }

        if (ObjectUtils.isEmpty(maxId)) {
            maxId = 0;
        }

        QueryAddressArgs args = new QueryAddressArgs();
        args.setSubWalletId(walletId);
        args.setSymbol(symbol);
        args.setMaxId(maxId);

        return this.invoke(MpcApiUri.GET_ADDRESS_LIST, args, WalletAddressListResult.class);
    }

    @Override
    public WalletAssetsResult getWalletAssets(Integer walletId, String symbol) {
        if (ObjectUtils.isEmpty(walletId)) {
            throw new ArgsNullException("the request parameter 'sub_wallet_id' is required");
        }

        if (StringUtils.isBlank(symbol)) {
            throw new ArgsNullException("the request parameter 'symbol' is required");
        }

        GetWalletAssetsArgs args = new GetWalletAssetsArgs();
        args.setSubWalletId(walletId);
        args.setSymbol(symbol);

        return this.invoke(MpcApiUri.GET_WALLET_ASSETS, args, WalletAssetsResult.class);
    }

    @Override
    public boolean changeWalletShowStatus(List<Integer> walletIds, AppShowStatus showStatus) {
        if (ObjectUtils.isEmpty(walletIds) || walletIds.isEmpty()) {
            throw new ArgsNullException("the request parameter 'sub_wallet_ids' empty");
        }

        if (ObjectUtils.isEmpty(showStatus)) {
            showStatus = AppShowStatus.HIDDEN;
        }

        ChangeShowStatusArgs args = new ChangeShowStatusArgs();
        args.setSubWalletIds(StringUtils.join(walletIds, ","));
        args.setAppShowStatus(showStatus.getShowStatus());

        Result result = this.invoke(MpcApiUri.CHANGE_SHOW_STATUS, args, Result.class);

        return !ObjectUtils.isEmpty(result) && result.getCode().equalsIgnoreCase("0");

    }

    @Override
    public WalletAddressInfoResult walletAddressInfo(String address, String memo) {
        if (StringUtils.isBlank(address)) {
            throw new ArgsNullException("the request parameter 'address' is required");
        }

        GetAddressInfoArgs args = new GetAddressInfoArgs();
        args.setAddress(address);
        args.setMemo(memo);

        return this.invoke(MpcApiUri.ADDRESS_INFO, args, WalletAddressInfoResult.class);
    }


}
