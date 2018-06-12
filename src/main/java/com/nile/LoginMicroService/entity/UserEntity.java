package com.nile.LoginMicroService.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = UserEntity.TABLE_NAME)

public class UserEntity {


    static final String TABLE_NAME = "user_details";
    static final String ID_COLUMN = "user_id";


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = UserEntity.ID_COLUMN)
    private String userId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String mobile;
    @OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @Override
    public String toString() {
        return "UserEntity{" +
                "addressId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", addressEntity=" + addressEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getMobile(), that.getMobile()) &&
                Objects.equals(getAddressEntity(), that.getAddressEntity());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserId(), getFirstName(), getLastName(), getEmail(), getPassword(), getMobile(), getAddressEntity());
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getIdColumn() {
        return ID_COLUMN;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}
