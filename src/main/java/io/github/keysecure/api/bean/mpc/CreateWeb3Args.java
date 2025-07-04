package io.github.keysecure.api.bean.mpc;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.keysecure.api.bean.BaseArgs;

import java.io.Serializable;

/**
 * @author Custody
 * Create Web3 Transaction, https://custodydocs-en.keysecure.io/api-references/mpc-apis/apis/web3/web3-create
 */
public class CreateWeb3Args extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 3278172340747622780L;

    /**
     * Wallet ID
     * required : true
     */
    @JSONField(name = "sub_wallet_id")
    private Integer subWalletId;

    /**
     * The unique identifier for transferring coins
     * required : true
     */
    @JSONField(name = "request_id")
    private String requestId;

    /**
     * Main chain coin symbol, Unique identifier for the coin, e.g.：ETH
     * required: true
     */
    @JSONField(name = "main_chain_symbol")
    private String mainChainSymbol;

    /**
     * Transaction initiation address. In the case of multiple addresses in the wallet, you can specify the transaction address.
     * If not specified, the wallet’s “commonly used address” will be used by default.
     * required: false
     */
    private String from;

    /**
     * Interactive contract
     * required: true
     */
    @JSONField(name = "interactive_contract")
    private String interactiveContract;

    /**
     * Transfer amount
     * required : true
     */
    private String amount;

    /**
     * Gas fee，unit：Gwei
     * required : true
     */
    @JSONField(name = "gas_price")
    private String gasPrice;

    /**
     * Gas limit fee
     * required : true
     */
    @JSONField(name = "gas_limit")
    private String gasLimit;

    /**
     * Hexadecimal data for contract transaction
     * required : true
     */
    @JSONField(name = "input_data")
    private String inputData;

    /**
     * 0: Authorization transaction, 1: Other transaction. If 0, the amount field is invalid.
     * required : true
     */
    @JSONField(name = "trans_type")
    private String transType;

    /**
     * Dapp name
     * required : false
     */
    @JSONField(name = "dapp_name")
    private String dappName;

    /**
     * Dapp URL
     * required : false
     */
    @JSONField(name = "dapp_url")
    private String dappUrl;

    /**
     * Dapp image
     * required : false
     */
    @JSONField(name = "dapp_img")
    private String dappImg;

    /**
     * RSA private key signature.
     * Parameters involved in the signature: “request_id”, “sub_wallet_id”, “main_chain_symbol”, “interactive_contract”, “amount”, “input_data”.
     * signature rules: https://custodydocs-en.keysecure.io/api-references/mpc-apis/co-signer/sign-verify
     * <p>
     * required : false
     */
    private String sign;

    public Integer getSubWalletId() {
        return subWalletId;
    }

    public void setSubWalletId(Integer subWalletId) {
        this.subWalletId = subWalletId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMainChainSymbol() {
        return mainChainSymbol;
    }

    public void setMainChainSymbol(String mainChainSymbol) {
        this.mainChainSymbol = mainChainSymbol;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getInteractiveContract() {
        return interactiveContract;
    }

    public void setInteractiveContract(String interactiveContract) {
        this.interactiveContract = interactiveContract;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getDappName() {
        return dappName;
    }

    public void setDappName(String dappName) {
        this.dappName = dappName;
    }

    public String getDappUrl() {
        return dappUrl;
    }

    public void setDappUrl(String dappUrl) {
        this.dappUrl = dappUrl;
    }

    public String getDappImg() {
        return dappImg;
    }

    public void setDappImg(String dappImg) {
        this.dappImg = dappImg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
