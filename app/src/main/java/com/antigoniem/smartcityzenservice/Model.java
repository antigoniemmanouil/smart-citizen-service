package com.antigoniem.smartcityzenservice;

class Model {

    private String title;
    private String value;

    Model(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

}
