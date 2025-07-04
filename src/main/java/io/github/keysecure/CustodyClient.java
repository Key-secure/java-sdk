package io.github.keysecure;

import io.github.keysecure.api.custody.*;

/**
 * @author Custody
 */
public class CustodyClient {

    private IAccountApi accountApi;

    private IAsyncNotifyApi asyncNotifyApi;

    private IBillingApi billingApi;

    private ICoinApi coinApi;

    private IUserApi userApi;

    private ITransferApi transferApi;

    public IAccountApi getAccountApi() {
        return accountApi;
    }

    public void setAccountApi(IAccountApi accountApi) {
        this.accountApi = accountApi;
    }

    public IAsyncNotifyApi getAsyncNotifyApi() {
        return asyncNotifyApi;
    }

    public void setAsyncNotifyApi(IAsyncNotifyApi asyncNotifyApi) {
        this.asyncNotifyApi = asyncNotifyApi;
    }

    public IBillingApi getBillingApi() {
        return billingApi;
    }

    public void setBillingApi(IBillingApi billingApi) {
        this.billingApi = billingApi;
    }

    public ICoinApi getCoinApi() {
        return coinApi;
    }

    public void setCoinApi(ICoinApi coinApi) {
        this.coinApi = coinApi;
    }

    public IUserApi getUserApi() {
        return userApi;
    }

    public void setUserApi(IUserApi userApi) {
        this.userApi = userApi;
    }

    public ITransferApi getTransferApi() {
        return transferApi;
    }

    public void setTransferApi(ITransferApi transferApi) {
        this.transferApi = transferApi;
    }

    public static final class CustodyClientBuilder {
        private IAccountApi accountApi;
        private IAsyncNotifyApi asyncNotifyApi;
        private IBillingApi billingApi;
        private ICoinApi coinApi;
        private IUserApi userApi;
        private ITransferApi transferApi;

        private CustodyClientBuilder() {
        }

        public static CustodyClientBuilder builder() {
            return new CustodyClientBuilder();
        }

        public CustodyClientBuilder accountApi(IAccountApi accountApi) {
            this.accountApi = accountApi;
            return this;
        }

        public CustodyClientBuilder asyncNotifyApi(IAsyncNotifyApi asyncNotifyApi) {
            this.asyncNotifyApi = asyncNotifyApi;
            return this;
        }

        public CustodyClientBuilder billingApi(IBillingApi billingApi) {
            this.billingApi = billingApi;
            return this;
        }

        public CustodyClientBuilder coinApi(ICoinApi coinApi) {
            this.coinApi = coinApi;
            return this;
        }

        public CustodyClientBuilder userApi(IUserApi userApi) {
            this.userApi = userApi;
            return this;
        }

        public CustodyClientBuilder transferApi(ITransferApi transferApi) {
            this.transferApi = transferApi;
            return this;
        }

        public CustodyClient build() {
            CustodyClient custodyClient = new CustodyClient();
            custodyClient.setAccountApi(accountApi);
            custodyClient.setAsyncNotifyApi(asyncNotifyApi);
            custodyClient.setBillingApi(billingApi);
            custodyClient.setCoinApi(coinApi);
            custodyClient.setUserApi(userApi);
            custodyClient.setTransferApi(transferApi);
            return custodyClient;
        }
    }
}
