package org.iti.db.domain;// default package
// Generated Mar 23, 2021, 6:50:21 PM by Hibernate Tools 6.0.0.Alpha2


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Categories generated by hbm2java
 */
@Entity
@Table(name="categories"
    ,catalog="ecomm"
    , uniqueConstraints = @UniqueConstraint(columnNames="cat_name") 
)
public class Categories  implements java.io.Serializable {


     private Integer catId;
     private String catName;
     private Set<Products> productses = new HashSet<Products>(0);

    public Categories() {
    }

    public Categories(String catName, Set<Products> productses) {
       this.catName = catName;
       this.productses = productses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="cat_id", unique=true, nullable=false)
    public Integer getCatId() {
        return this.catId;
    }
    
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    
    @Column(name="cat_name", unique=true, length=50)
    public String getCatName() {
        return this.catName;
    }
    
    public void setCatName(String catName) {
        this.catName = catName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categories")
    public Set<Products> getProductses() {
        return this.productses;
    }
    
    public void setProductses(Set<Products> productses) {
        this.productses = productses;
    }




}

