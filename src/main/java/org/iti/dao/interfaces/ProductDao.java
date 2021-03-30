package org.iti.dao.interfaces;


import org.iti.db.domain.DBProduct;
import org.iti.db.domain.Products;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {


//    List<DBProduct> getAllProducts() throws SQLException;
//
//    DBProduct getProductById(Integer productId) throws  SQLException;
//
//    List<DBProduct> getProductsByCategoryName(String categoryName) throws  SQLException;
//
//    List<DBProduct> getProductsByCategoryId(Integer categoryId) throws  SQLException;
//
//    List<String> getProductSecondaryImgsById(Integer productId) throws  SQLException;
//
//    List<DBProduct> getAllFeaturedProducts() throws  SQLException;

    List<Products> getAllProducts();

    Products getProductById(Integer id);

    List<Products> fetchProductsByBatch(Integer startingId, Integer batchSize);

    List<Products> fetchProductsByBatchApplyingCriteria(Integer startingId, Integer batchSize);

    List<Products> getAllProductsByCategoryId(Integer categoryId);

    List<Products> getAllProductsByCategoryIds(Integer  ... categoryId);

    List<Products> getAllProductsWithingPriceRange(double min, double max);

    List<Products> getAllProductsByCatAndPriceRange(double min, double max, List<Integer> categoryId);

    long getProdNumber(double min, double max);

    long getProdNumber(double min, double max, List<Integer> categoryId);


    Double getMaximumProdPrice();

    long getProdCount();



}
