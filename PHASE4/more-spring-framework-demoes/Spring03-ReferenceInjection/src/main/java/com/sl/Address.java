package com.sl;

public class Address {
    private String city;
    private String zip;

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    @Override
    public String toString() {
        return "Address{city='" + city + "', zip='" + zip + "'}";
    }
}