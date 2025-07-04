package io.github.keysecure.api.bean.custody;


import io.github.keysecure.api.bean.Result;

import java.io.Serializable;
import java.util.List;

/**
 * @author Custody
 * Batch query withdrawal and deposit records
 */
public class MinerFeeListResult extends Result<List<MinerFee>> implements Serializable {

    private static final long serialVersionUID = -4702567367783624688L;

}
