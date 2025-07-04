package io.github.keysecure.api.custody.impl;

import io.github.keysecure.CustodyConfig;
import io.github.keysecure.api.CustodyApi;
import io.github.keysecure.api.bean.custody.RegisterArgs;
import io.github.keysecure.api.bean.custody.UserInfoArgs;
import io.github.keysecure.api.bean.custody.UserInfoResult;
import io.github.keysecure.api.custody.IUserApi;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.enums.ApiUri;

/**
 * @author Custody
 * user related api
 */
public class UserApi extends CustodyApi implements IUserApi {

    public UserApi(CustodyConfig cfg, IDataCrypto crypto) {
        super(cfg, crypto);
    }

    @Override
    public UserInfoResult registerMobileUser(String country, String mobile) {
        RegisterArgs args = new RegisterArgs();
        args.setCountry(country);
        args.setMobile(mobile);
        return this.invoke(ApiUri.CREATE_USER_MOBILE, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult registerEmailUser(String email) {
        RegisterArgs args = new RegisterArgs();
        args.setEmail(email);
        return this.invoke(ApiUri.CREATE_USER_EMAIL, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult getMobileUser(String country, String mobile) {
        UserInfoArgs args = new UserInfoArgs();
        args.setCountry(country);
        args.setMobile(mobile);
        return this.invoke(ApiUri.GET_USER_INFO, args, UserInfoResult.class);
    }

    @Override
    public UserInfoResult getEmailUser(String email) {
        UserInfoArgs args = new UserInfoArgs();
        args.setEmail(email);
        return this.invoke(ApiUri.GET_USER_INFO, args, UserInfoResult.class);
    }
}
