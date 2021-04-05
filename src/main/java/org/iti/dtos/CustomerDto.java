package org.iti.dtos;

import java.io.Serializable;
import java.util.Date;

public class CustomerDto implements Serializable {

    private Integer customerId;
    private String name;
    private String email;
    private String password;
    private String address;
    private double credit;
    private Date  registerDate;
    private String url;
    private String phone;
    private String job;
    private String interests;

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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }


    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", credit=" + credit +
                ", registerDate=" + registerDate +
                ", url='" + url + '\'' +
                ", phone='" + phone + '\'' +
                ", job='" + job + '\'' +
                ", interests='" + interests + '\'' +
                '}';
    }
}
