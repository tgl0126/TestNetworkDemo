package com.intel.testnetworkdemo.Utils;

import java.util.Map;

/**
 * @author Guilin Tian
 * @package com.intel.testnetworkdemo.Utils
 * @date on 2020/12/18
 * @decribe 添加描述
 */
public class HttpHelper implements IHttpLoader{
    private static IHttpLoader mHttpLoader;

    private HttpHelper() {

    }

    public static void init(IHttpLoader httpLoader) {
        mHttpLoader = httpLoader;
    }

    public static HttpHelper obtain() {
        return HttpHelperHolder.INSTANCE;
    }

    static class HttpHelperHolder {
        private static HttpHelper INSTANCE = new HttpHelper();
    }

    @Override
    public void get(String url, Map<String, Object> params, IHttpCallback callback) {
        mHttpLoader.get(url, params, callback);
    }

    @Override
    public void post(String url, Map<String, Object> params, IHttpCallback callback) {
        mHttpLoader.post(url, params, callback);
    }
}
