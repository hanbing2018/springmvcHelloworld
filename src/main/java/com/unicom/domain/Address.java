package com.unicom.domain;

import java.util.Date;

/**
 * @author hanbing
 * @create 2019-09-06 15:23
 */
public class Address {
    String street;
    String build;
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", build='" + build + '\'' +
                ", date=" + date +
                '}';
    }
}
