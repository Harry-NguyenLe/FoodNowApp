package model;

import java.io.Serializable;

public class Store implements Serializable {
    private int logo;
    private String name;
    private String address;

    public Store() {
    }

    public Store(int logo, String name, String address) {
        this.logo = logo;
        this.name = name;
        this.address = address;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
