package org.iti.dao.interfaces;

import org.iti.db.domain.CartItems;

import java.util.List;

public interface CartDao {


    List<CartItems> getCartByUserId(Integer id);

    long getCartProdCountByUserId(Integer id);

    void incProduct(Integer userId,Integer prodId);

    void decProduct(Integer userId,Integer prodId);

    void deleteProduct(Integer userId, Integer prodId);

    void deleteCart(Integer userId);

    Double getCartTotalByUserId(Integer userId);

    void addCartItem(Integer userId, Integer prodId,Integer qty);

    void increaseItemQuantityByBulk(Integer userId, Integer prodId,Integer increaseAmount);

    long getProdQuantityByUserId(Integer userId, Integer prodId);

    boolean isCartItemExist(Integer userId, Integer prodId);

}
