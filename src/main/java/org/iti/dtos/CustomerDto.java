package org.iti.dtos;

import java.io.Serializable;
import java.util.Date;

public class CustomerDto implements Serializable {

    String name;
    String email;
    String password;
    String address;
    double credit;
    Date  registerDate;
    String url;
    String phone;

    public CustomerDto() {
    }

    public CustomerDto(String name, String email, String password, String address, double credit, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.credit = credit;
        this.phone = phone;
    }

    public CustomerDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
