package org.iti.dao.interfaces;


import org.iti.db.domain.DBProduct;
import org.iti.db.domain.Products;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {


    List<Products> getAllProducts();

    Products getProductById(Integer id);

    List<Products> fetchProductsByBatch(Integer startingId, Integer batchSize);

    List<Products> fetchProductsByBatchApplyingCriteria(Integer startingId, Integer batchSize);

    List<Products> getAllProductsByCategoryId(Integer categoryId);

    List<Products> getAllProductsByCategoryIds(Integer  ... categoryId);

    List<Products> getAllProductsWithingPriceRange(double min, double max);

    List<Products> batchProductsWithingPriceRange(int pageNum, int batchSize, double min, double max);

    List<Products> getAllProductsByCatAndPriceRange(double min, double max, List<Integer> categoryId);

    List<Products> batchAllProductsByCatAndPriceRange(int pageNum,int batchSize,double min, double max, List<Integer> categoryId);

    long getProdNumber(double min, double max);

    long getProdNumber(double min, double max, List<Integer> categoryId);


    Double getMaximumProdPrice();

    long getProdCount();

    void decreaseProductAmount(int prodId,int amount);

    void clearProductAmount(int prodId);
    Products updateProduct(Products product);

    boolean deleteProductById(Integer productId);

    void addProduct(Products product);

}
