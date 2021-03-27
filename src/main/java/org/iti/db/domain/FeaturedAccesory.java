package org.iti.db.domain;// default package
// Generated Mar 23, 2021, 8:48:30 PM by Hibernate Tools 6.0.0.Alpha2


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * FeaturedAccesory generated by hbm2java
 */
@Entity(name = "featuredaccesory")
@Table(name="featured_accesory"
    ,catalog="ecomm"
)
public class FeaturedAccesory  implements java.io.Serializable {


     private int featuredAccesoryId;
     private Products products;

    public FeaturedAccesory() {
    }

    public FeaturedAccesory(Products products) {
       this.products = products;
    }
   
     @GenericGenerator(name="FeaturedAccesoryIdGenerator", strategy="foreign", parameters=@Parameter(name="property", value="products"))@Id @GeneratedValue(generator="FeaturedAccesoryIdGenerator")

    
    @Column(name="featured_accesory_id", unique=true, nullable=false)
    public int getFeaturedAccesoryId() {
        return this.featuredAccesoryId;
    }
    
    public void setFeaturedAccesoryId(int featuredAccesoryId) {
        this.featuredAccesoryId = featuredAccesoryId;
    }

@OneToOne(fetch=FetchType.EAGER)@PrimaryKeyJoinColumn
    public Products getProducts() {
        return this.products;
    }
    
    public void setProducts(Products products) {
        this.products = products;
    }




}


