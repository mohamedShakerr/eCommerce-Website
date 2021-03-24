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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name="products"
    ,catalog="ecomm"
)
public class Products  implements java.io.Serializable {


     private Integer prodId;
     private Categories categories;
     private String name;
     private String description;
     private int quantity;
     private String img;
     private Integer adminId;
     private Long price;
     private Set<CartItems> cartItemses = new HashSet<CartItems>(0);
     private Set<ProdImages> prodImageses = new HashSet<ProdImages>(0);

    public Products() {
    }

	
    public Products(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }
    public Products(Categories categories, String name, String description, int quantity, String img, Integer adminId, Long price, Set<CartItems> cartItemses, Set<ProdImages> prodImageses) {
       this.categories = categories;
       this.name = name;
       this.description = description;
       this.quantity = quantity;
       this.img = img;
       this.adminId = adminId;
       this.price = price;
       this.cartItemses = cartItemses;
       this.prodImageses = prodImageses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="prod_id", unique=true, nullable=false)
    public Integer getProdId() {
        return this.prodId;
    }
    
    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cat_id")
    public Categories getCategories() {
        return this.categories;
    }
    
    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    
    @Column(name="name", nullable=false, length=256)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="description", nullable=false, length=1000)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="quantity", nullable=false)
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    @Column(name="img", length=256)
    public String getImg() {
        return this.img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }

    
    @Column(name="admin_id")
    public Integer getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    
    @Column(name="price", precision=10, scale=0)
    public Long getPrice() {
        return this.price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="products")
    public Set<CartItems> getCartItemses() {
        return this.cartItemses;
    }
    
    public void setCartItemses(Set<CartItems> cartItemses) {
        this.cartItemses = cartItemses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="products")
    public Set<ProdImages> getProdImageses() {
        return this.prodImageses;
    }
    
    public void setProdImageses(Set<ProdImages> prodImageses) {
        this.prodImageses = prodImageses;
    }




}

