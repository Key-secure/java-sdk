package io.github.keysecure.api;

import com.alibaba.fastjson.JSONObject;
import io.github.keysecure.CustodyConfig;
import io.github.keysecure.api.bean.Args;
import io.github.keysecure.api.bean.BaseArgs;
import io.github.keysecure.crypto.IDataCrypto;
import io.github.keysecure.enums.ApiUri;
import io.github.keysecure.enums.MpcApiUri;
import io.github.keysecure.exception.CryptoException;
import io.github.keysecure.util.HttpClientUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Custody
 */
public class CustodyApi {
    protected static final Logger logger = LoggerFactory.getLogger(CustodyApi.class);

    protected CustodyConfig cfg;

    protected IDataCrypto dataCrypto;

    public CustodyApi(CustodyConfig cfg, IDataCrypto dataCrypto) {
        this.cfg = cfg;
        this.dataCrypto = dataCrypto;
    }

    public CustodyConfig getCfg() {
        return cfg;
    }

    public void setCfg(CustodyConfig cfg) {
        this.cfg = cfg;
    }

    public IDataCrypto getDataCrypto() {
        return dataCrypto;
    }

    public void setDataCrypto(IDataCrypto dataCrypto) {
        this.dataCrypto = dataCrypto;
    }

    /**
     * call Custody mpc api
     * @param uri api path
     * @param args request args
     * @param clazz response type
     * @param <T> response
     * @return T
     */
    protected <T> T invoke(MpcApiUri uri, BaseArgs args, Class<T> clazz) {
        return this.invoke(uri.getValue(), uri.getMethod(), args, clazz);
    }

    /**
     * call Custody api
     * @param uri ApiUri
     * @param args BaseArgs
     * @param clazz Class
     * @param <T> response
     * @return T
     */
    protected <T> T invoke(ApiUri uri, BaseArgs args, Class<T> clazz) {
        return this.invoke(uri.getValue(), uri.getMethod(), args, clazz);
    }

    /**
     * call Custody api
     * @param uri String
     * @param requestMethod String
     * @param args BaseArgs
     * @param clazz  Class
     * @param <T> response
     * @return T
     */
    protected <T> T invoke(String uri, String requestMethod, BaseArgs args, Class<T> clazz) {
        // default parameters
        args.setCharset(this.cfg.getCharset());
        args.setTime(System.currentTimeMillis());

        // encryption parameters
        String raw = args.toJson();
        this.info("request api:{}, request args:{}", uri, raw);
        String data = this.dataCrypto.encode(raw);
        this.info("request api: {}, encode args:{}", uri, data);

        if (StringUtils.isBlank(data)) {
            logger.error("request api:{}, encode args return null", uri);
            throw new CryptoException("data crypto return null");
        }

        // request interface
        String url = String.format("%s%s", this.cfg.getDomain(), uri);
        Args params = new Args(this.cfg.getAppId(), data);
        String resp;
        if (HttpGet.METHOD_NAME.equalsIgnoreCase(requestMethod)) {
            url += "?" + params.toString();
            resp = HttpClientUtil.getInstance().doGetWithJsonResult(url);
        } else {
            resp = HttpClientUtil.getInstance().doPostWithJsonResult(url, params.toMap());
        }

        this.info("request api: {} raw result:{}", uri, resp);
        // The interface return data is empty
        if (StringUtils.isBlank(resp)) {
            logger.error("request api: {} api return null", uri);
            return null;
        }

        JSONObject jsonObject = JSONObject.parseObject(resp);
        if (ObjectUtils.isEmpty(jsonObject)
                || !jsonObject.containsKey("data")
                || StringUtils.isBlank(jsonObject.getString("data"))) {
            // The data returned by the interface does not contain the data field
            logger.error("request api: {}, result do not found data field or data field is empty", uri);
            return null;
        }

        // Decrypt response data
        String respRaw = this.dataCrypto.decode(jsonObject.getString("data"));
        this.info("request api:{} decode result :{}", uri, respRaw);
        if (StringUtils.isBlank(respRaw)) {
            logger.error("request api:{}, decode result return null", uri);
            return null;
        }

        T result = JSONObject.parseObject(respRaw, clazz);
        if (ObjectUtils.isEmpty(result)) {
            logger.error("request api:{}, result parse json to object error, json:{}", uri, respRaw);
            return null;
        }
        return result;
    }

    protected void info(String format, Object... object) {
        if (this.getCfg().getEnableLog()) {
            logger.info(format, object);
        }
    }
}
