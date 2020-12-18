package com.intel.testnetworkdemo.Utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * @author Guilin Tian
 * @package com.intel.testnetworkdemo.Utils
 * @date on 2020/12/18
 * @decribe 添加描述
 */
class VolleyHttpLoader implements IHttpLoader {
    private static RequestQueue mRequestQueue;

    public VolleyHttpLoader(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void get(String url, Map<String, Object> params, final IHttpCallback callback) {
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        callback.onSuccess(s);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callback.onFailed(volleyError.toString());
            }
        });
        mRequestQueue.add(request);
    }

    @Override
    public void post(String url, Map<String, Object> params, final IHttpCallback callback) {
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        callback.onSuccess(s);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callback.onFailed(volleyError.toString());
            }
        });
        mRequestQueue.add(request);
    }
}
