package com.juaracoding.utils;

public enum ScenarioTests {

    // T1 - T10000
    // feature login
    T1("Invalid login scenarios"),
    T2("Invalid login scenarios"),
    T3("Invalid login scenarios"),
    T4("Invalid login scenarios"),
    T5("Invalid login scenarios"),
    T6("Valid login scenarios"),
    T7("Add Product to Cart"),
    T8("Add Product to Cart"),
    T9("Add Product to Cart"),
    T10("Add Product to Cart"),
    T11("Add Product to Cart"),
    T12("Add Product to Cart"),
    T13("Invalid Checkout Data"),
    T14("Invalid Checkout Data"),
    T15("Invalid Checkout Data"),
    T16("Invalid Checkout Data"),
    T17("Invalid Checkout Data"),
    T18("Valid Checkout Data"),
    T19("Invalid login scenarios"),
    T20("Invalid login scenarios"),
    T21("Invalid login scenarios"),
    T22("Invalid login scenarios"),
    T23("Invalid login scenarios"),
    T24("Valid login scenarios"),
    T25("Add Product to Cart"),
    T26("Add Product to Cart"),
    T27("Add Product to Cart"),
    T28("Add Product to Cart"),
    T29("Add Product to Cart"),
    T30("Add Product to Cart"),
    T31("Invalid Checkout Data"),
    T32("Invalid Checkout Data"),
    T33("Invalid Checkout Data"),
    T34("Invalid Checkout Data"),
    T35("Invalid Checkout Data"),
    T36("Valid Checkout Data");

    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }

}