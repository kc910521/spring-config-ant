package com.ck.spring.tool.define;

import java.util.Objects;

/**
 * @Author caikun
 * @Description 三级省市区+地址
 * @Date 下午1:57 22-1-24
 **/
public class AddressName {

    private String province;

    private String city;

    private String street;

    private String detail;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "AddressName{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressName)) return false;
        AddressName that = (AddressName) o;
        return getProvince().equals(that.getProvince()) &&
                getCity().equals(that.getCity()) &&
                Objects.equals(getStreet(), that.getStreet()) &&
                Objects.equals(getDetail(), that.getDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProvince(), getCity(), getStreet(), getDetail());
    }
}
