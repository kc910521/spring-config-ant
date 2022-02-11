package com.ck.spring.prop;

import org.springframework.util.PropertyPlaceholderHelper;

import java.util.List;

/**
 * @Author caikun
 * @Description //TODO $END
 * @Date 下午6:32 22-2-10
 **/
public class RefreshPropertyPlaceholderHelper extends PropertyPlaceholderHelper {

    public RefreshPropertyPlaceholderHelper(String placeholderPrefix, String placeholderSuffix) {
        super(placeholderPrefix, placeholderSuffix);
    }

    public RefreshPropertyPlaceholderHelper(String placeholderPrefix, String placeholderSuffix, String valueSeparator, boolean ignoreUnresolvablePlaceholders) {
        super(placeholderPrefix, placeholderSuffix, valueSeparator, ignoreUnresolvablePlaceholders);
    }

    // using replacePlaceholders(String value, final Properties properties)

    public void addToPlaceholderKeys(String value, List<String> keys) {
        assert keys != null;


    }

}
