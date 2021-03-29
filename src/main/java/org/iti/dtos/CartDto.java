package org.iti.dtos;

import java.util.List;

public class CartDto {

    private Integer userId;

    private List<CartItemDto> cartItems;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "userId=" + userId +
                ", cartItems=" + cartItems +
                '}';
    }
}
