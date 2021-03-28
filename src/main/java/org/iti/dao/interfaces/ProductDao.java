package org.iti.dao.interfaces;


import org.iti.db.domain.DBProduct;
import org.iti.db.domain.Products;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {


    List<Products> getAllProducts();

    DBProduct getProductById(Integer productId) ;

    List<DBProduct> getProductsByCategoryName(String categoryName) ;

    List<DBProduct> getProductsByCategoryId(Integer categoryId) ;

    List<String> getProductSecondaryImgsById(Integer productId) ;

    List<DBProduct> getAllFeaturedProducts() ;




}
