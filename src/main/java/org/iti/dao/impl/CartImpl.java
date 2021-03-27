package org.iti.dao.impl;

import org.apache.logging.log4j.core.util.JsonUtils;
import org.hibernate.Session;
import org.iti.dao.interfaces.CartDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.CartItems;
import org.iti.db.domain.CartItemsId;
import org.iti.db.domain.Customers;
import org.iti.db.domain.Products;

import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


public class CartImpl  implements CartDao {


    Session session = null;

    public CartImpl(Session sesison){
        this.session = sesison;
    }




    @Override
    public List<CartItems> getCartByUserId(Integer id) {

        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        Session session = dbSessionProvider.getSession();

        String queryString = "from cart WHERE customer_id = :userId";
        Query query = session.createQuery( queryString, CartItems.class )
                .setParameter("userId", id);

        List<CartItems> cartItems = query.getResultList();
        session.close();
        return  cartItems;

    }

    @Override
    public long getCartProdCountByUserId(Integer id) {

        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        Session session = dbSessionProvider.getSession();

        String queryString = " select sum (quantity) from cart where customer_id = :userId";
        Query query = session.createQuery(queryString)
                .setParameter("userId",id);

        Object res = query.getSingleResult();
        if(res == null){
            session.close();
            return 0;
        }else{
            long count = (long) res;
            session.close();
            return  count;
        }
    }

    @Override
    public void incProduct(Integer userId, Integer prodId) {


        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        Query q = session.createQuery("update cart c set c.quantity = c.quantity+1 where products.id =:prodId and customers.id =:userId")
                .setParameter("prodId", prodId)
                .setParameter("userId", userId);

        q.executeUpdate();

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void decProduct(Integer userId, Integer prodId) {

        //TODO Ref
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        //TODO impl if prod is Only 1 Qty, Donot dec

        Query q = session.createQuery("update cart c set c.quantity = c.quantity-1 where products.id =:prodId and customers.id =:userId")
                .setParameter("prodId", prodId)
                .setParameter("userId", userId);

        q.executeUpdate();

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void deleteProduct(Integer userId, Integer prodId) {

        //TODO Ref
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        CartItems cartItems = session.find(CartItems.class,new CartItemsId(userId,prodId));
        session.remove(cartItems);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void deleteCart(Integer userId) {

        //TODO Ref
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        //TODO impl if prod is Only 1 Qty, Donot dec

        Query q = session.createQuery("delete from cart c where c.customers.id = :userId")
                .setParameter("userId", userId);

        q.executeUpdate();

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Double getCartTotalByUserId(Integer userId) {

        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        Query q = session.createQuery("from cart WHERE customer_id = :userId")
                .setParameter("userId", userId);

        List<CartItems> cartItems = q.getResultList();


        Double cartTotal = cartItems.stream().reduce(0.0,(partial, cartItem) -> {

            Double totalPerItem = partial + (cartItem.getProducts().getPrice() * cartItem.getQuantity());

            return totalPerItem;
        }, Double::sum);
        session.close();
        return  cartTotal;
    }

    @Override
    public void addCartItem(Integer userId, Integer prodId, Integer qty) {

        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        Products prod = session.find(Products.class, prodId);
        Customers customer = session.find(Customers.class, userId);

        CartItemsId cartItemsId = new CartItemsId(userId, prodId);

        CartItems cartItem = new CartItems();
        cartItem.setQuantity(qty);
        cartItem.setCustomers(customer);
        cartItem.setProducts(prod);
        cartItem.setId(cartItemsId);

        session.persist(cartItem);

        session.getTransaction().commit();

        session.close();
    }


    @Override
    public void increaseItemQuantityByBulk(Integer userId, Integer prodId, Integer increaseAmount) {
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        Query q = session.createQuery("update cart c set c.quantity = c.quantity+:qty where products.id =:prodId and customers.id =:userId")
                .setParameter("qty", increaseAmount)
                .setParameter("prodId", prodId)
                .setParameter("userId", userId);

        q.executeUpdate();

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public long getProdQuantityByUserId(Integer userId, Integer prodId) {

        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        CartItems cartItem = session.find(CartItems.class, new CartItemsId(userId, prodId));

        if(cartItem == null){
            session.close();
            return 0;
        }else{
            long count = cartItem.getQuantity();
            session.close();
            return  count;
        }
    }

    @Override
    public boolean isCartItemExist(Integer userId, Integer prodId) {
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        CartItems cartItem = session.find(CartItems.class, new CartItemsId(userId, prodId));
        if(cartItem == null){
            session.close();
            return false;
        }else {
            session.close();
            return  true;
        }
    }


}
