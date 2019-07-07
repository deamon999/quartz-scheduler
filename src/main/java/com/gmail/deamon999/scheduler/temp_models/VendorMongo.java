package com.gmail.deamon999.scheduler.temp_models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VendorMongo {
    private String id;
    private String vendorName;
    private Set<Associate> associates = new HashSet<>();

    public VendorMongo(String id, String vendorName) {
        this.id = id;
        this.vendorName = vendorName;
    }

    public VendorMongo(String id, String vendorName, Set<Associate> associates) {
        this.id = id;
        this.associates = associates;
        this.vendorName = vendorName;
    }

    public VendorMongo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Associate> getAssociates() {
        return associates;
    }

    public void setAssociates(Set<Associate> associates) {
        this.associates = associates;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorMongo that = (VendorMongo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(associates, that.associates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, associates);
    }
}
