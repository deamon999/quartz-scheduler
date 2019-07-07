package com.gmail.deamon999.scheduler.temp_models;

import java.util.Objects;

public class PhoneNumber {
    private String phone;
    private String ext;
    private String label;

    public PhoneNumber(String phone, String ext, String label) {
        this.phone = phone;
        this.ext = ext;
        this.label = label;
    }

    public PhoneNumber() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(phone, that.phone) &&
                Objects.equals(ext, that.ext) &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, ext, label);
    }
}
