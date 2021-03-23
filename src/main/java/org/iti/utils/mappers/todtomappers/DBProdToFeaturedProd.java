package org.iti.utils.mappers.todtomappers;


import org.iti.db.domain.DBProduct;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.utils.mappers.EntityToDtoMapper;

public class DBProdToFeaturedProd extends EntityToDtoMapper<FeaturedIndexProductDto, DBProduct> {


    @Override
    public FeaturedIndexProductDto convertEntityToDto(DBProduct entity) {

        FeaturedIndexProductDto featuredProd = new FeaturedIndexProductDto();

        featuredProd.setProductId(entity.getId());
        featuredProd.setProductName(entity.getName());
        featuredProd.setProductPrice(entity.getPrice());
        featuredProd.setImageUrl(entity.getMainImg());
        featuredProd.setQuantity(entity.getQuantity());

        return  featuredProd;
    }



}
