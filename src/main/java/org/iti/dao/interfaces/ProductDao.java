package org.iti.dao.interfaces;


import org.iti.db.domain.DBProduct;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {


    List<DBProduct> getAllProducts() throws SQLException;

    DBProduct getProductById(Integer productId) throws  SQLException;

    List<DBProduct> getProductsByCategoryName(String categoryName) throws  SQLException;

    List<DBProduct> getProductsByCategoryId(Integer categoryId) throws  SQLException;

    List<String> getProductSecondaryImgsById(Integer productId) throws  SQLException;

    List<DBProduct> getAllFeaturedProducts() throws  SQLException;




}
