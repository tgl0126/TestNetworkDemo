package com.intel.testnetworkdemo.Utils;

/**
 * @author Guilin Tian
 * @package com.intel.testnetworkdemo.Utils
 * @date on 2020/12/18
 * @decribe 添加描述
 */
interface IHttpCallback {
    /**
            * 成功时的回调
     *
             * @param result
     */
    void onSuccess(String result);

    /**
     * 失败时的回调
     *
     * @param msg
     */
    void onFailed(String msg);
}
