package org.iti.dtos;

import java.util.ArrayList;
import java.util.List;

public class AdminProductDto {

    private Integer productId;
    private String productName;
    private Double productPrice;
    private String imageUrl;
    private Integer quantity;
    private String description;
    private List<String> prodImages = new ArrayList<>();


    public AdminProductDto() { }

    public AdminProductDto(Integer prodId, String prodName, Double prodPrice, Integer prodQuantity, String prodDesc) {
        productId = prodId;
        productName = prodName;
        productPrice = prodPrice;
        quantity = prodQuantity;
        description = prodDesc;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public List<String> getProdImages() { return prodImages; }

    public void setProdImages(List<String> prodImages) { this.prodImages = prodImages; }


    @Override
    public String toString() {
        return "AdminProductDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", imageUrl='" + imageUrl + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", prodImages=" + prodImages +
                '}';
    }
}
