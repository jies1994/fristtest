package com.jies.test.service;

import java.util.List;

/**
 * Created by peijie on 17/11/29.
 */
public class DuiXiang {

    private String property;

    private List<String> listProperty;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public List<String> getListProperty() {
        return listProperty;
    }

    public void setListProperty(List<String> listProperty) {
        this.listProperty = listProperty;
    }

    @Override
    public String toString() {
        return "DuiXiang{" +
                "property='" + property + '\'' +
                ", listProperty=" + listProperty +
                '}';
    }
}
