package com.ck.spring.tool.define;

import java.beans.PropertyEditorSupport;

/**
 * @Author caikun
 * @Description 逗号分割的字符串转地址类型
 * @Date 下午2:04 22-1-24
 **/
public class AddressNamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        assert text != null;
        String[] splitAdd = text.split(",");
        assert splitAdd.length < 2;
        AddressName addressName = new AddressName();
        addressName.setProvince(splitAdd[0]);
        addressName.setCity(splitAdd[1]);
        if (splitAdd.length >= 3) addressName.setStreet(splitAdd[2]);
        if (splitAdd.length == 4) addressName.setStreet(splitAdd[3]);
        super.setValue(addressName);
    }
}
