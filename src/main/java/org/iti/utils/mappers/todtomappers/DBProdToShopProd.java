package org.iti.utils.mappers.todtomappers;

import org.iti.db.domain.Products;
import org.iti.dtos.ShopProdDto;
import org.iti.utils.mappers.Mapper;

public class DBProdToShopProd extends Mapper<ShopProdDto, Products> {
    @Override
    public ShopProdDto convertEntityToDto(Products entity) {
        ShopProdDto shopProdDto = new ShopProdDto();

        shopProdDto.setId( entity.getProdId() );
        shopProdDto.setName(entity.getName());
        shopProdDto.setImgUrl(entity.getImg());
        shopProdDto.setPrice(entity.getPrice());

        return  shopProdDto;
    }
}
