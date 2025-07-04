package io.github.keysecure.api.custody;

import io.github.keysecure.api.bean.custody.AccountResult;
import io.github.keysecure.api.bean.custody.UserAccountResult;
import io.github.keysecure.api.bean.custody.UserAddressResult;

/**
 * @author Custody
 *  Account operation related api
 */
public interface IAccountApi {

    UserAccountResult getUserAccount(Integer uid, String symbol) ;

    UserAddressResult getUserAddress(Integer uid, String symbol) ;

    AccountResult getCompanyAccount(String symbol) ;

    UserAddressResult getUserAddressInfo(String address) ;

}
