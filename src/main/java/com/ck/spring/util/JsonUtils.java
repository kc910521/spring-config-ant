package com.ck.spring.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @Author caikun
 * @Description
 * @Date 下午5:26 22-2-9
 **/
public class JsonUtils {

    private final static Gson gsonTool = new GsonBuilder().serializeNulls().create();

    private JsonUtils() {
    }

    public String jsonToString() {
        return "";
    }

    public static Map<String, Object> getFromJsonString(String json) {
        return gsonTool.fromJson(json, Map.class);
    }

    public static Map<String, Object> getFromJsonStream(EncodedResource er) {
        try {
//            return gsonTool.fromJson(new InputStreamReader(er.getInputStream(), er.getEncoding()), Map.class);
            return gsonTool.fromJson(new InputStreamReader(er.getInputStream()), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
