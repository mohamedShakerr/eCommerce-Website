package org.iti.db.domain;// default package
// Generated Mar 23, 2021, 6:50:21 PM by Hibernate Tools 6.0.0.Alpha2


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProdImages generated by hbm2java
 */
@Entity
@Table(name="prod_images"
    ,catalog="ecomm"
)
public class ProdImages  implements java.io.Serializable {


     private Integer imageId;
     private Products products;
     private String imageUrl;

    public ProdImages() {
    }

    public ProdImages(Products products, String imageUrl) {
       this.products = products;
       this.imageUrl = imageUrl;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="image_id", unique=true, nullable=false)
    public Integer getImageId() {
        return this.imageId;
    }
    
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="prod_id")
    public Products getProducts() {
        return this.products;
    }
    
    public void setProducts(Products products) {
        this.products = products;
    }

    
    @Column(name="image_url", length=200)
    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }




}


