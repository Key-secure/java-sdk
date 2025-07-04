package io.github.keysecure.api.bean.custody;


import io.github.keysecure.api.bean.Result;

import java.io.Serializable;
import java.util.List;

/**
 * @author Custody
 * Batch query withdrawal and deposit records
 */
public class DepositListResult extends Result<List<Deposit>> implements Serializable {

    private static final long serialVersionUID = -7258327179461704198L;

}
