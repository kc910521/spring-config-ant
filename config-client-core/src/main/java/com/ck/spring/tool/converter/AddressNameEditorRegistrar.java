package com.ck.spring.tool.converter;

import com.ck.spring.tool.define.AddressName;
import com.ck.spring.tool.define.AddressNamePropertyEditor;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @Author caikun
 * @Description 注册入口
 * @Date 下午2:11 22-1-24
 **/
public class AddressNameEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        propertyEditorRegistry.registerCustomEditor(AddressName.class, new AddressNamePropertyEditor());
    }
}
