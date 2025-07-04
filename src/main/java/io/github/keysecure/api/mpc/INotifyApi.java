package io.github.keysecure.api.mpc;

import io.github.keysecure.api.bean.mpc.NotifyArgs;

public interface INotifyApi {

    /**
     * Decrypt deposit and withdrawal notification parameters
     *
     * @param cipher String
     * @return NotifyArgs
     */
    NotifyArgs notifyRequest(String cipher);
}
