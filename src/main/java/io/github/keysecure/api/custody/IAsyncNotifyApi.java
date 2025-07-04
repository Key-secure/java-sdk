package io.github.keysecure.api.custody;

import io.github.keysecure.api.bean.custody.AsyncNotifyArgs;
import io.github.keysecure.api.bean.custody.WithdrawArgs;

/**
 * @author Custody
 */
public interface IAsyncNotifyApi {

    /**
     * Decrypt deposit and withdrawal notification parameters
     *
     * @param cipher String
     * @return String
     */
    AsyncNotifyArgs notifyRequest(String cipher);

    /**
     * Decryption withdrawal secondary verification request parameters
     *
     * @param cipher String
     * @return WithdrawArgs
     */
    WithdrawArgs verifyRequest(String cipher);

    /**
     * Encrypt the secondary verification withdrawal response data
     *
     * @param withdraw WithdrawArgs
     * @return String
     */
    String verifyResponse(WithdrawArgs withdraw);
}
