package io.github.keysecure.api.bean.custody;


import io.github.keysecure.api.bean.Result;

import java.io.Serializable;

/**
 * @author Custody
 * User withdrawal result. Note that the interface only returns the status string
 */
public class WithdrawResult extends Result<Withdraw> implements Serializable {

    private static final long serialVersionUID = 4145976711610357553L;

}
