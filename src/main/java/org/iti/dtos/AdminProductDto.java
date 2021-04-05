package org.iti.dtos;

import java.util.ArrayList;
import java.util.List;

public class AdminProductDto {

    private Integer productId;
    private String productName;
    private Double productPrice;
    private String imageUrl;
    private Integer quantity;
    private Integer category;
    private String description;
    private byte[] imageBytes;
    private List<String> productImageURLs = new ArrayList<>();

    public List<byte[]> getProductAlbum() {
        return productAlbum;
    }

    public void setProductAlbum(List<byte[]> productAlbum) {
        this.productAlbum = productAlbum;
    }

    private List<byte[]> productAlbum = new ArrayList<>();


    public AdminProductDto() {
    }

    public AdminProductDto(String productName, Double productPrice, Integer quantity, Integer category, String description, byte[] imageBytes,
                           List<byte[]> productAlbum ) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
        this.imageBytes = imageBytes;
        this.productAlbum = productAlbum;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getProductImageURLs() {
        return productImageURLs;
    }

    public void setProductImageURLs(List<String> productImageURLs) {
        this.productImageURLs = productImageURLs;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "AdminProductDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", imageUrl='" + imageUrl + '\'' +
                ", quantity=" + quantity +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", prodImages=" + productImageURLs +
                '}';
    }
}
