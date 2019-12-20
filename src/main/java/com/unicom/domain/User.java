package com.unicom.domain;

import java.util.List;
import java.util.Map;

/**
 * @author hanbing
 * @create 2019-09-06 15:20
 */
public class User {
    String username;
    String password;
    Double money;

    List<Address> list;
    Map<String, Address> map;

    public List<Address> getList() {
        return list;
    }

    public void setList(List<Address> list) {
        this.list = list;
    }

    public Map<String, Address> getMap() {
        return map;
    }

    public void setMap(Map<String, Address> map) {
        this.map = map;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
