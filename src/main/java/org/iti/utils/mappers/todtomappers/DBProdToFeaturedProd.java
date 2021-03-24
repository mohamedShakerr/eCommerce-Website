package org.iti.utils.mappers.todtomappers;


import org.iti.db.domain.DBProduct;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.utils.mappers.EntityDtoMapper;

public class DBProdToFeaturedProd extends EntityDtoMapper<DBProduct,FeaturedIndexProductDto> {


    @Override
    public FeaturedIndexProductDto toDto(DBProduct entity) {

        FeaturedIndexProductDto featuredProd = new FeaturedIndexProductDto();

        featuredProd.setProductId(entity.getId());
        featuredProd.setProductName(entity.getName());
        featuredProd.setProductPrice(entity.getPrice());
        featuredProd.setImageUrl(entity.getMainImg());
        featuredProd.setQuantity(entity.getQuantity());

        return  featuredProd;
    }

    @Override
    public DBProduct toEntity(FeaturedIndexProductDto entity) {
        return null;
    }


}
