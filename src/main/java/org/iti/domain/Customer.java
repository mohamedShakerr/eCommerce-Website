package org.iti.domain;

import java.util.Date;

public class Customer{
    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    private Date regDate;
    private double credit;
    private String image;
    private String phone;

    public Customer(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public Date getRegDate() {
        return regDate;
    }

    public double getCredit() {
        return credit;
    }

    public String getImage() {
        return image;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}