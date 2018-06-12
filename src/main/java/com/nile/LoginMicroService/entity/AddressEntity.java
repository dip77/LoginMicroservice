package com.nile.LoginMicroService.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = AddressEntity.TABLE_NAME)
public class AddressEntity {

    static final String TABLE_NAME = "address";
    static final String ID_COLUMN = "address_id";
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = AddressEntity.ID_COLUMN)
    private String addressId;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country="india";
    private String zip;
    private String landmark;

    @Override
    public String toString() {
        return "AddressEntity{" +
                "addressId='" + addressId + '\'' +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zip='" + zip + '\'' +
                ", landmark='" + landmark + '\'' +
                '}';
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getIdColumn() {
        return ID_COLUMN;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressEntity)) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(getAddressId(), that.getAddressId()) &&
                Objects.equals(getLine1(), that.getLine1()) &&
                Objects.equals(getLine2(), that.getLine2()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getState(), that.getState()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getZip(), that.getZip()) &&
                Objects.equals(getLandmark(), that.getLandmark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressId(), getLine1(), getLine2(), getCity(), getState(), getCountry(), getZip(), getLandmark());
    }
}
