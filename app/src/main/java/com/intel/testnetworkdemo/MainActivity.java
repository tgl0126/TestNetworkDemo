package com.intel.testnetworkdemo;

import android.os.Bundle;
import android.util.Log;

import com.intel.testnetworkdemo.Bean.Data;
import com.intel.testnetworkdemo.Utils.HttpCallback;
import com.intel.testnetworkdemo.Utils.HttpHelper;
import com.intel.testnetworkdemo.http.IRequestCallback;
import com.intel.testnetworkdemo.http.IRequestManager;
import com.intel.testnetworkdemo.http.RequestFactory;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String URL_HTTP = "https://www.wanandroid.com/wxarticle/chapters/json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //测试请求
        String url = "https://www.wanandroid.com/wxarticle/chapters/json";
        //这里发起请求依赖的是IRequestManager接口
        IRequestManager requestManager = RequestFactory.getRequestManager();
        requestManager.get(url, new IRequestCallback() {
            @Override
            public void onSuccess(String response) {
                Log.e("TAG", "onSuccess: " + response);
            }

            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
                Log.e("TAG", "错误：" + throwable.getMessage());
            }
        });

        getDatas();


    }

    private void getDatas() {
        //Utils
        HttpHelper.obtain().get(URL_HTTP, null, new HttpCallback<Data>() {

            @Override
            public void onFailed(String msg) {
                Log.e("TAGUtils", "错误：" + msg);
            }

            @Override
            public void onSuccess(Data data) {
                Log.e("TAGUtils", "数据：" + data.toString());

            }
        });
    }
}