package com.intel.testnetworkdemo.http;

/**
 * @author Guilin Tian
 * @package com.intel.testnetworkdemo.http
 * @date on 2020/12/18
 * @decribe
 *  IRequestManager 此接口提供的就是http请求通用的方法，该接口可以用Volley来实现，也能用OkHttp等其它方式来实现
 *  接口说明：
 *  get方法参数包含一个url，以及返回数据的接口
 *  post/put/delete方法还需要提供一个请求体参数
 */
public interface IRequestManager {
    abstract void get(String url, IRequestCallback requestCallback);
    abstract void post(String url, String requestBodyJson, IRequestCallback requestCallback);
    abstract void put(String url, String requestBodyJson, IRequestCallback requestCallback);
    abstract void delete(String url, String requestBodyJson, IRequestCallback requestCallback);
}
