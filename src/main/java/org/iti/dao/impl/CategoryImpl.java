package org.iti.dao.impl;

import org.hibernate.Session;
import org.iti.dao.interfaces.CategoryDao;
import org.iti.db.domain.Categories;
import org.iti.db.domain.Products;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryImpl implements CategoryDao {

    Session session = null;

    public CategoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public List<Categories> getAllCategories() {
        Query q = session.createQuery("from categories", Categories.class);
        return q.getResultList();
    }


    @Override
    public Categories getCategoryByProdId(Integer prodId) {

        session.beginTransaction();

        Query q = session.createQuery("from products p where p.id = :prodId")
                .setParameter("prodId", prodId);
        Products product = (Products) q.getResultList().get(0);
        session.getTransaction().commit();

        return product.getCategories();
    }

    @Override
    public boolean isCategoryExist(Integer categoryId) {
        session.beginTransaction();
        Categories categories = session.find(Categories.class, categoryId);
        session.getTransaction().commit();
        if (categories == null) return false;
        else return true;
    }

    @Override
    public void addCategory(Categories addedCat) {
        session.beginTransaction();
        session.persist(addedCat);
        session.getTransaction().commit();

    }

    @Override
    public Categories getCategoryById(Integer categoryId) {

        return session.find(Categories.class, categoryId);
    }
}
