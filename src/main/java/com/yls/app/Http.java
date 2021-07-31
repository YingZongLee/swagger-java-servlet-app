package com.yls.app;

import com.yls.app.interceptor.AuthInterceptor;
import com.yls.app.interceptor.LoggerInterceptor;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author yunglee on 2021/07/21
 * @package com.yls.demo
 */
public class Http {
    private static final OkHttpClient client = new OkHttpClient().newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(new AuthInterceptor())
            .addNetworkInterceptor(new LoggerInterceptor())
            .build();

    public static String get(String url) throws IOException {
        return get(url, null);
    }

    public static String get(String url, Map<String, String> queryParameter) throws IOException {
        Request request = new Request.Builder().url(httpUrl(url, queryParameter)).build();
        try(Response response = client.newCall(request).execute()) {
            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    private static HttpUrl httpUrl(String url, Map<String, String> queryParameter) {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
        if(queryParameter != null && queryParameter.size() > 0) {
            queryParameter.forEach((key, value) -> httpBuilder.addQueryParameter(key, value));
        }
        return httpBuilder.build();
    }
}
