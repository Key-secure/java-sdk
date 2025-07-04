package io.github.keysecure.api.bean.custody;


import io.github.keysecure.api.bean.Result;

import java.io.Serializable;
import java.util.List;

/**
 * obtain coins list
 * @author Custody
 */
public class CoinInfoListResult extends Result<List<CoinInfo>> implements Serializable {

    private static final long serialVersionUID = 2781667383263512987L;

}
