package com.yls.app;

import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

/**
 * @author yunglee on 2021/07/25
 * @package com.yls.demo
 */
public class JsonAdapter implements JsonDeserializer {
    private static final Logger log = LogManager.getLogger(JsonAdapter.class);
    @Override
    public Object deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        log.info("typeName {}", type.getTypeName());
        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray location = jsonObject.get("records").getAsJsonObject()
                .get("location").getAsJsonArray();
        location.forEach(data -> {
            JsonObject each = data.getAsJsonObject();
            log.info(each);
        });
//        return jsonDeserializationContext.deserialize(location, type);
        return context.deserialize(json, type);
    }
}
