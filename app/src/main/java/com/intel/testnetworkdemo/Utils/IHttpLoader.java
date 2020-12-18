package com.intel.testnetworkdemo.Utils;

import java.util.Map;

/**
 * @author Guilin Tian
 * @package com.intel.testnetworkdemo.Utils
 * @date on 2020/12/18
 * @decribe 添加描述
 */
interface IHttpLoader {
    /**
     * GET方式请求
     *
     * @param url
     * @param params
     * @param callback
     */
    void get(String url, Map<String, Object> params, IHttpCallback callback);

    /**
     * POST方式请求
     *
     * @param url
     * @param params
     * @param callback
     */
    void post(String url, Map<String, Object> params, IHttpCallback callback);

}
