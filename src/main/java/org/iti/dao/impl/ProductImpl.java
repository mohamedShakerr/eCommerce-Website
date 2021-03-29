package org.iti.dao.impl;

import org.hibernate.Session;
import org.iti.dao.interfaces.ProductDao;
import org.iti.db.domain.Products;

import java.util.List;

public class ProductImpl implements ProductDao {

    Session session = null;

    public  ProductImpl(Session session){
        this.session = session;
    }

    @Override
    public List<Products> getAllProducts() {
        return session.createQuery("from products",Products.class ).list();
    }

    @Override
    public Products getProductById(Integer id) {

        return session.find(Products.class,id );
    }
}
