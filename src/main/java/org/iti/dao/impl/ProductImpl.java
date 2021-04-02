package org.iti.dao.impl;

import org.hibernate.Session;
import org.iti.dao.interfaces.ProductDao;
import org.iti.db.domain.Categories;
import org.iti.db.domain.Products;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<Products> fetchProductsByBatch(Integer pageNum, Integer batchSize) {

        Query query = session.createQuery("from products",Products.class);

        int startingIndex = (pageNum * batchSize) - batchSize;
        //page1 : ( 1 * 6 ) - 6 = 0
        //page2:  ( 2 * 6 ) - 6 = 6
        //page3:  ( 3 * 6 ) - 6 = 12
        query.setFirstResult(startingIndex);

        query.setMaxResults(batchSize);


        return  query.getResultList();
    }

    @Override
    public List<Products> fetchProductsByBatchApplyingCriteria(Integer startingId, Integer batchSize) {
        return null;
    }

    @Override
    public Double getMaximumProdPrice() {

        Query q = session.createQuery("select max(p.price) from products p");
        return (Double) q.getResultList().get(0);
    }

    @Override
    public long getProdCount() {
        Query q = session.createQuery("select count(*) from products");

        return  (long)q.getResultList().get(0);
    }



    @Override
    public List<Products> getAllProductsByCategoryId(Integer categoryId) {

        Categories cat = session.find(Categories.class, categoryId);
        Set<Products> productSet = cat.getProductses();
        List<Products> productsList = new ArrayList<>(productSet);
        return  productsList;
    }

    @Override
    public List<Products> getAllProductsByCategoryIds(Integer... categoryId) {

        List<Integer> idArr = List.of(categoryId);

        Query q = session.createQuery( "from products p where p.categories.id in (:ids)" )
                .setParameter("ids", idArr);

        return  q.getResultList();

    }

    @Override
    public List<Products> getAllProductsWithingPriceRange(double min, double max) {


        Query q = session.createQuery("from products p where p.price between :min and :max")
                .setParameter("min" , min)
                .setParameter("max", max);

        return q.getResultList();
    }

    @Override
    public List<Products> batchProductsWithingPriceRange(int pageNum, int batchSize, double min, double max) {

        Query query = session.createQuery("from products p where p.price between :min and :max")
                .setParameter("min" , min)
                .setParameter("max", max);

        int startingIndex = (pageNum * batchSize) - batchSize;
        //page1 : ( 1 * 6 ) - 6 = 0
        //page2:  ( 2 * 6 ) - 6 = 6
        //page3:  ( 3 * 6 ) - 6 = 12
        query.setFirstResult(startingIndex);

        query.setMaxResults(batchSize);

        return query.getResultList();

    }

    @Override
    public List<Products> getAllProductsByCatAndPriceRange(double min, double max, List<Integer> categoryId) {

        Query q = session.createQuery("from products p where p.categories.id in (:ids) AND p.price between :min and :max ")
                .setParameter("ids", categoryId)
                .setParameter("min", min)
                .setParameter("max", max);

        return q.getResultList();
    }

    @Override
    public List<Products> batchAllProductsByCatAndPriceRange(int pageNum,int batchSize, double min, double max, List<Integer> categoryId) {
        Query q = session.createQuery("from products p where p.categories.id in (:ids) AND p.price between :min and :max ")
                .setParameter("ids", categoryId)
                .setParameter("min", min)
                .setParameter("max", max);

        int startingIndex = (pageNum * batchSize) - batchSize;
        //page1 : ( 1 * 6 ) - 6 = 0
        //page2:  ( 2 * 6 ) - 6 = 6
        //page3:  ( 3 * 6 ) - 6 = 12
        q.setFirstResult(startingIndex);

        q.setMaxResults(batchSize);

        return q.getResultList();
    }

    @Override
    public long getProdNumber(double min, double max) {

        Query q = session.createQuery("select count(*) from products p where p.price between :min and :max")
                .setParameter("min" , min)
                .setParameter("max", max);

        return (long) q.getResultList().get(0);
    }

    @Override
    public long getProdNumber(double min, double max, List<Integer> categoryId) {

        Query q = session.createQuery("select count(*) from products p where p.categories.id in (:ids) AND p.price between :min and :max ")
                .setParameter("ids", categoryId)
                .setParameter("min", min)
                .setParameter("max", max);

        return (long) q.getResultList().get(0);
    }

    @Override
    public void decreaseProductAmount(int prodId,int amount){
        session.beginTransaction();
        Query q=session.createQuery("update products p set p.quantity=p.quantity- :amount where p.prodId=:prodId")
                .setParameter("prodId",prodId)
                .setParameter("amount",amount);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void clearProductAmount(int prodId){
        session.beginTransaction();
        Query q=session.createQuery("update products p set p.quantity=0 where p.prodId=:prodId")
                .setParameter("prodId",prodId);
        q.executeUpdate();
        session.getTransaction().commit();
    }

}
