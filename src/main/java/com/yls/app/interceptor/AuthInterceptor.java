package com.yls.app.interceptor;

import com.yls.app.PropertyConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author yunglee on 2021/07/21
 * @package com.yls.demo.interceptor
 */
public class AuthInterceptor implements Interceptor {
    private static final String Authorization = "Authorization";
    @Override
    public Response intercept(Chain chain) throws IOException {
        HttpUrl url = chain.request().url()
                .newBuilder()
                .addQueryParameter(Authorization, PropertyConfig.getAuth())
                .build();
        Request request = chain.request().newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
