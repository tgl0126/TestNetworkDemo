package com.intel.testnetworkdemo.http;

/**
 * @author Guilin Tian
 * @package com.intel.testnetworkdemo.http
 * @date on 2020/12/18
 * @decribe 请求返回成功/失败，成功时，把服务器返回的结果回调出去，失败时回调异常信息
 */
public interface IRequestCallback {
    abstract void onSuccess(String response);
    abstract void onFailure(Throwable throwable);
}
