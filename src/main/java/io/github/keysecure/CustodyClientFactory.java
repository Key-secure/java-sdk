package io.github.keysecure;

import io.github.keysecure.api.custody.impl.*;
import io.github.keysecure.crypto.DataCrypto;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.api.mpc.impl.*;

/**
 * @author Custody
 */
public class CustodyClientFactory {

    public static CustodyClient createClient(CustodyConfig cfg) {
        DataCrypto crypto = new DataCrypto(cfg.getUserPrivateKey(), cfg.getCustodyPublicKey());
        return createClient(cfg, crypto);
    }

    public static CustodyClient createClient(CustodyConfig cfg, IDataCrypto crypto) {
        return CustodyClient.CustodyClientBuilder.builder()
                .accountApi(new AccountApi(cfg, crypto))
                .asyncNotifyApi(new AsyncNotifyApi(cfg, crypto))
                .billingApi(new BillingApi(cfg, crypto))
                .coinApi(new CoinApi(cfg, crypto))
                .userApi(new UserApi(cfg, crypto))
                .transferApi(new TransferApi(cfg, crypto))
                .build();
    }

    public static MpcClient createMpcClient(MpcConfig cfg) {
        DataCrypto crypto = new DataCrypto(cfg.getUserPrivateKey(), cfg.getCustodyPublicKey());
        return createMpcClient(cfg, crypto);
    }

    public static MpcClient createMpcClient(MpcConfig cfg, IDataCrypto crypto) {
        return MpcClient.MpcClientBuilder.builder()
                .workSpaceApi(new WorkSpaceApi(cfg, crypto))
                .walletApi(new WalletApi(cfg, crypto))
                .depositApi(new DepositApi(cfg, crypto))
                .withdrawApi(new WithdrawApi(cfg, crypto))
                .web3Api(new Web3Api(cfg, crypto))
                .autoSweepApi(new AutoSweepApi(cfg, crypto))
                .notifyApi(new NotifyApi(cfg, crypto))
                .build();
    }

}
