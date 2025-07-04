package io.github.keysecure.api.bean.mpc;

import java.io.Serializable;

/**
 * @author Custody
 */
public class LastBlockHeight implements Serializable {

    private static final long serialVersionUID = -3216938055348212336L;

    private Long height;

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }
}
