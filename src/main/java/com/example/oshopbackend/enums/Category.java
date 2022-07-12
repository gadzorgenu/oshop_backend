package com.example.oshopbackend.enums;

public enum Category {
    BREAD("Bread"), DAIRY("Dairy"), FRUIT("Fruit"),VEGETABLES("Vegetables"), SEASONING("Seasoning"), SPICES("Spices");

    String value;

    Category(String val){
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
