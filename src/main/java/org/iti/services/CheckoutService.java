package org.iti.services;

import org.hibernate.Session;
import org.iti.dao.impl.CartImpl;
import org.iti.dao.interfaces.CartDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.CartItems;

import java.util.List;

public class CheckoutService {

    Session serviceSessison = null;
    private static CheckoutService checkoutService = null;

    private CheckoutService(){
        //TODO Should Create Session Here
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        serviceSessison = dbSessionProvider.getSession();
    }


    public static  CheckoutService getInstance(){
        if(checkoutService == null){
            synchronized (CartService.class){
                if(checkoutService == null){
                    checkoutService = new CheckoutService();
                }
            }
        }
        return checkoutService;
    }

    public List<CartItems> getCartItems(int id){
        CartDao cartDao=new CartImpl();
         return cartDao.getCartByUserId(id);
    }
    public double getSubTotal(int id){
        CartDao cartDao=new CartImpl();
        return cartDao.getCartTotalByUserId(id);
    }
}
