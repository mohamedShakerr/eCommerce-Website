package org.iti.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.iti.dao.interfaces.ProductDao;
import org.iti.db.domain.DBProduct;
import org.iti.db.domain.FeaturedProds;
import org.iti.db.domain.Products;

import java.sql.SQLException;
import java.util.List;

public class ProductImpl implements ProductDao {

    Session session = null;
    public ProductImpl(Session session){
        this.session = session;
    }

    @Override
    public List<Products> getAllProducts() throws SQLException {
        Query<Products> query =  session.createQuery("from Products", Products.class);
//        return query.getResultList();
        return null;
    }

    @Override
    public DBProduct getProductById(Integer productId) throws SQLException {
        return null;
    }

    @Override
    public List<DBProduct> getProductsByCategoryName(String categoryName) throws SQLException {
        return null;
    }

    @Override
    public List<DBProduct> getProductsByCategoryId(Integer categoryId) throws SQLException {
        return null;
    }

    @Override
    public List<String> getProductSecondaryImgsById(Integer productId) throws SQLException {
        return null;
    }

    @Override
    public List<DBProduct> getAllFeaturedProducts() throws SQLException {
        return null;
    }
}
