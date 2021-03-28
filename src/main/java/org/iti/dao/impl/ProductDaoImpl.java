package org.iti.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.iti.dao.interfaces.ProductDao;
import org.iti.db.domain.DBProduct;
import org.iti.db.domain.FeaturedProds;
import org.iti.db.domain.Products;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    Session session = null;

    public ProductDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public List<Products> getAllProducts() {
        Query<Products> query = session.createQuery("from Products", Products.class);
        return query.getResultList();
    }

    @Override
    public DBProduct getProductById(Integer productId) {
        return null;
    }

    @Override
    public List<DBProduct> getProductsByCategoryName(String categoryName) {
        return null;
    }

    @Override
    public List<DBProduct> getProductsByCategoryId(Integer categoryId) {
        return null;
    }

    @Override
    public List<String> getProductSecondaryImgsById(Integer productId) {
        return null;
    }

    @Override
    public List<DBProduct> getAllFeaturedProducts() {
        return null;
    }
}
