package com.ck.spring.prop;

import com.ck.spring.util.JsonUtils;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * @Author caikun
 * @Description
 * @Date 下午4:29 22-1-28
 **/
public class JsonPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        Map<String, Object> stringObjectMap = loadJsonIntoProperties(resource);
        String sourceName = name != null ? name : resource.getResource().getFilename();
        return new DynamicPropertySource(sourceName, stringObjectMap);
    }


    private Map<String, Object> loadJsonIntoProperties(EncodedResource resource) throws FileNotFoundException {
        return JsonUtils.getFromJsonStream(resource);
    }
}
