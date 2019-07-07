package com.gmail.deamon999.scheduler.temp_models;

import java.util.List;

public class Selections {
    private double decimal;
    private List<Double> decimalList;
    private String string;
    private List<String> stringList;
    private int integer;
    private List<Integer> integerList;
    private String bool;
    private boolean notApplicable;

    public Selections() {
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public List<Double> getDecimalList() {
        return decimalList;
    }

    public void setDecimalList(List<Double> decimalList) {
        this.decimalList = decimalList;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public String getBool() {
        return bool;
    }

    public void setBool(String bool) {
        this.bool = bool;
    }

    public boolean isNotApplicable() {
        return notApplicable;
    }

    public void setNotApplicable(boolean notApplicable) {
        this.notApplicable = notApplicable;
    }
}
