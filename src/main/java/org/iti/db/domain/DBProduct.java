package org.iti.db.domain;

import java.util.List;

public class DBProduct {

    private Integer id;
    private String name;
    private String description;
    private Integer quantity;
    private String mainImg;
    private String category;
    private String adminName;
    private Double price;
    private List<String> secondaryImgs;


    public DBProduct() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getSecondaryImgs() {
        return secondaryImgs;
    }

    public void setSecondaryImgs(List<String> secondaryImgs) {
        this.secondaryImgs = secondaryImgs;
    }

    @Override
    public String toString() {
        return "DBProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", mainImg='" + mainImg + '\'' +
                ", category='" + category + '\'' +
                ", adminName='" + adminName + '\'' +
                ", price=" + price +
                ", secondaryImgs=" + secondaryImgs +
                '}';
    }
}
