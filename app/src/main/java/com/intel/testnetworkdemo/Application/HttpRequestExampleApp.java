package com.intel.testnetworkdemo.Application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.intel.testnetworkdemo.Utils.HttpHelper;
import com.intel.testnetworkdemo.Utils.OkHttpLoader;

/**
 * 作者：Created by lzw
 * 时间：Created on 2017/6/17 0017 22:59
 * 邮箱：lzw20099002@126.com
 */

public class HttpRequestExampleApp extends Application{

    public static RequestQueue mQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        //http
        mQueue = Volley.newRequestQueue(this);


        //Utils
        HttpHelper.init(new OkHttpLoader());
//        HttpHelper.init(new VolleyHttpLoader(this));
    }
}
