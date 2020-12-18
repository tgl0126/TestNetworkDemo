package com.intel.testnetworkdemo.Utils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author Guilin Tian
 * @package com.intel.testnetworkdemo.Utils
 * @date on 2020/12/18
 * @decribe 添加描述
 */
public class OkHttpLoader implements IHttpLoader {
    private static OkHttpClient mOkHttpClient;

    public OkHttpLoader() {
        mOkHttpClient = new OkHttpClient();
    }


    @Override
    public void get(String url, Map<String, Object> params, final IHttpCallback callback) {
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callback.onFailed(e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    callback.onSuccess(result);
                } else {
                    callback.onFailed(response.message());
                }
            }
        });
    }

    @Override
    public void post(String url, Map<String, Object> params, final IHttpCallback callback) {
        RequestBody requestBody = appendBody(params);
        Request request = new Request.Builder().post(requestBody).url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callback.onFailed(e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    callback.onSuccess(result);
                } else {
                    callback.onFailed(response.message());
                }
            }
        });
    }

    private RequestBody appendBody(Map<String, Object> params) {
        FormBody.Builder body = new FormBody.Builder();
        if (params == null || params.isEmpty()) {
            return body.build();
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            body.add(entry.getKey(), entry.getValue().toString());
        }
        return body.build();
    }
}
