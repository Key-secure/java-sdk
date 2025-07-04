package io.github.keysecure.api.custody;

import io.github.keysecure.api.bean.custody.UserInfoResult;

/**
 * @author Custody
 * user related api
 */
public interface IUserApi {

    UserInfoResult registerMobileUser(String country, String mobile);

    UserInfoResult registerEmailUser(String email);

    UserInfoResult getMobileUser(String country, String mobile);

    UserInfoResult getEmailUser(String email);
}
