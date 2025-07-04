package io.github.keysecure;

public class CustodyConfig {

    /**
     * Custody appId
     */
    private String appId;

    /**
     * Customer Rsa private key
     */
    private String userPrivateKey;

    /**
     * The Rsa public key provided by Custody
     */
    private String custodyPublicKey;

    /**
     * Custody domain name
     */
    private String domain;

    private String version = "v2";

    private String charset = "utf-8";

    private Boolean enableLog = true;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUserPrivateKey() {
        return userPrivateKey;
    }

    public void setUserPrivateKey(String userPrivateKey) {
        this.userPrivateKey = userPrivateKey;
    }

    public String getCustodyPublicKey() {
        return custodyPublicKey;
    }

    public void setCustodyPublicKey(String custodyPublicKey) {
        this.custodyPublicKey = custodyPublicKey;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public Boolean getEnableLog() {
        return enableLog;
    }

    public void setEnableLog(Boolean enableLog) {
        this.enableLog = enableLog;
    }
}
