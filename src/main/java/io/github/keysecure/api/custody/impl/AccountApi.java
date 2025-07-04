package io.github.keysecure.api.custody.impl;

import io.github.keysecure.CustodyConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.custody.IAccountApi;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.enums.ApiUri;
import io.github.keysecure.api.bean.custody.*;

/**
 * @author Custody
 * API related to account operation
 */
public class AccountApi extends CustodyApi implements IAccountApi {

    public AccountApi(CustodyConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    @Override
    public UserAccountResult getUserAccount(Integer uid, String symbol) {
        UserAccountArgs args = new UserAccountArgs();
        args.setSymbol(symbol);
        args.setUid(uid);
        return this.invoke(ApiUri.USER_SYMBOL_ACCOUNT, args, UserAccountResult.class);
    }

    @Override
    public UserAddressResult getUserAddress(Integer uid, String symbol) {
        UserAddressArgs args = new UserAddressArgs();
        args.setSymbol(symbol);
        args.setUid(uid);
        return this.invoke(ApiUri.USER_DEPOSIT_ADDRESS, args, UserAddressResult.class);
    }

    @Override
    public AccountResult getCompanyAccount(String symbol) {
        CompanyAccountArgs args = new CompanyAccountArgs();
        args.setSymbol(symbol);

        return this.invoke(ApiUri.COMPANY_SYMBOL_ACCOUNT, args, AccountResult.class);
    }

    @Override
    public UserAddressResult getUserAddressInfo(String address) {
        UserAddressArgs args = new UserAddressArgs();
        args.setAddress(address);
        return this.invoke(ApiUri.USER_DEPOSIT_ADDRESS_INFO, args, UserAddressResult.class);
    }
}
