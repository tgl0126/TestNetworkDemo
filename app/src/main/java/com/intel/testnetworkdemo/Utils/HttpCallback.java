package com.intel.testnetworkdemo.Utils;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Guilin Tian
 * @package com.intel.testnetworkdemo.Utils
 * @date on 2020/12/18
 * @decribe 添加描述
 */
public abstract class HttpCallback<Result> implements IHttpCallback {

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clazz = analysisClazzInfo(this);
        Result resultObj = (Result) gson.fromJson(result, clazz);
        onSuccess(resultObj);
    }

    /**
     * 成功时的回调
     *
     * @param result
     */
    public abstract void onSuccess(Result result);

    private Class<?> analysisClazzInfo(Object object) {
        Type genType = object.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<?>) params[0];
    }
}
