package io.github.keysecure.api.bean.custody;


import io.github.keysecure.api.bean.Result;

import java.io.Serializable;
import java.util.List;

/**
 * @author Custody
 *  user withdrawal records
 */
public class WithdrawListResult extends Result<List<Withdraw>> implements Serializable {

    private static final long serialVersionUID = 7561492060036680509L;

}
