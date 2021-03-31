package org.iti.utils.mappers.todtomappers;


import org.iti.db.domain.DBProduct;
import org.iti.db.domain.Products;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.utils.mappers.EntityDtoMapper;

public class ProductToFeaturedProduct extends EntityDtoMapper<Products, FeaturedIndexProductDto> {


    @Override
    public FeaturedIndexProductDto toDto(Products entity) {

        FeaturedIndexProductDto featuredProd = new FeaturedIndexProductDto();

        featuredProd.setProductId(entity.getProdId());
        featuredProd.setProductName(entity.getName());
        featuredProd.setProductPrice(entity.getPrice().doubleValue());
        featuredProd.setImageUrl(entity.getImg());
        featuredProd.setQuantity(entity.getQuantity());

        return featuredProd;
    }

    @Override
    public Products toEntity(FeaturedIndexProductDto entity) {

        // todo complete the mapping logic
        Products product = new Products();

        product.setProdId(entity.getProductId());
        product.setName(entity.getProductName());
        product.setPrice(entity.getProductPrice().doubleValue());
        product.setImg(entity.getImageUrl());
        product.setQuantity(entity.getQuantity());
        return product;

    }


}
