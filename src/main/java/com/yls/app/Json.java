package com.yls.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author yunglee on 2021/07/24
 * @package com.yls.demo
 */
public class Json {
    private static final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .serializeNulls().create();

    public static <T> String prettyJson(T jsonObject) {
        Gson gsonp = new GsonBuilder().setPrettyPrinting().create();
        return gsonp.toJson(jsonObject);
    }

    public static <T> T fromJson(String jsonString, Class<T> typeT) {
        return gson.fromJson(jsonString, typeT);
    }

}
