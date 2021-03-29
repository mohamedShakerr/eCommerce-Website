package org.iti.services;

import org.hibernate.Session;
import org.iti.dao.impl.CartImpl;
import org.iti.dao.interfaces.CartDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.CartItems;
import org.iti.dtos.CartDto;
import org.iti.dtos.CartItemDto;
import org.iti.utils.mappers.EntityToDtoMapper;
import org.iti.utils.mappers.todtomappers.DBCartItemToItemDto;

import java.util.List;

public class CartService {

    Session serviceSessison = null;
    private static CartService cartService = null;

    private CartService(){
        //TODO Should Create Session Here
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        serviceSessison = dbSessionProvider.getSession();
    }


    public static  CartService getInstance(){
        if(cartService == null){
            synchronized (CartService.class){
                if(cartService == null){
                    cartService = new CartService();
                }
            }
        }
        return cartService;
    }



    public CartDto getCartByUserId(Integer id){

        CartDto cart = new CartDto();

        CartDao cartDao = new CartImpl(serviceSessison);
        List<CartItems> cartItemsList = cartDao.getCartByUserId(id);

        cart.setUserId(id);
        EntityToDtoMapper<CartItemDto, CartItems> mapper = new DBCartItemToItemDto();
        List<CartItemDto> cartItems = mapper.convertEntityListToDtoList(cartItemsList);
        cart.setCartItems(cartItems);

        return cart;
    }

    public void decProdInCart(Integer userId, Integer prodId){
        CartDao cartDao = new CartImpl(serviceSessison);
        cartDao.decProduct(userId,prodId);
    }

    public void incProdInCart(Integer userId, Integer prodId){

        CartDao cartDao = new CartImpl(serviceSessison);
        cartDao.incProduct(userId,prodId);
    }

    public Double getCartTotal(Integer userId){
        CartDao cartDao = new CartImpl(serviceSessison);
        return cartDao.getCartTotalByUserId(userId);
    }

    public void incBulkProdInCart(Integer userId, Integer prodId, Integer quantity){

    }

    public void deleteCartItem(Integer userId, Integer prodId){
        CartDao cartDao = new CartImpl(serviceSessison);
        cartDao.deleteProduct(userId,prodId);
    }

    public void addNewItemToCart(Integer userId, Integer prodId, Integer qty){

        CartDao cartDao = new CartImpl(serviceSessison);

        if(qty < 0){
            return;
        }

        boolean isItemExist = cartDao.isCartItemExist(userId,prodId);

        if(isItemExist){
            cartDao.increaseItemQuantityByBulk(userId,prodId,qty);
        }else {
            cartDao.addCartItem(userId,prodId,qty);
        }
    }

    public void deleteAllCartItemsByUserId(Integer userId){
        CartDao cartDao = new CartImpl(serviceSessison);
        cartDao.deleteCart(userId);
    }

    public long getCartCount(Integer userId){
        CartDao cartDao = new CartImpl(serviceSessison);
        return cartDao.getCartProdCountByUserId(userId);
    }


    public void terminateService(){
        serviceSessison.close();
    }

}
