package org.iti.utils.mappers.todtomappers;

import org.iti.db.domain.CartItems;
import org.iti.db.domain.Products;
import org.iti.dtos.CartItemDto;
import org.iti.utils.mappers.Mapper;

public class DBCartItemToItemDto extends Mapper<CartItemDto, CartItems> {
    @Override
    public CartItemDto convertEntityToDto(CartItems entity) {

        CartItemDto cartItemDto = new CartItemDto();
        Products prod = entity.getProducts();
        cartItemDto.setProductId(prod.getProdId());
        cartItemDto.setProductName(prod.getName());
        cartItemDto.setProductImage(prod.getImg());
        cartItemDto.setProductPrice(prod.getPrice());
        cartItemDto.setProductQty(entity.getQuantity());

        return cartItemDto;
    }

}
