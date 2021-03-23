package org.iti.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.iti.dao.interfaces.FeaturedProductDao;
import org.iti.db.domain.FeaturedProds;


import java.util.List;

public class FeaturedProductImpl implements FeaturedProductDao {

    Session session = null;
    public  FeaturedProductImpl(Session session){
        this.session = session;
    }

    @Override
    public void addFeaturedProduct(FeaturedProds featuredProds) {

    }

    @Override
    public List<FeaturedProds> getAllFeaturedProducts() {
        Query<FeaturedProds> query =  session.createQuery("from featuredprods", FeaturedProds.class);
        return query.getResultList();
    }

    @Override
    public FeaturedProds getFeaturedProdsBytId(Integer id) {
        return null;
    }
}
