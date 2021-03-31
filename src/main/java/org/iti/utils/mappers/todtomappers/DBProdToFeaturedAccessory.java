package org.iti.utils.mappers.todtomappers;


import org.iti.db.domain.FeaturedAccesory;
import org.iti.db.domain.Products;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.utils.mappers.Mapper;

public class DBProdToFeaturedAccessory extends Mapper<FeaturedIndexProductDto, FeaturedAccesory> {


    @Override
    public FeaturedIndexProductDto convertEntityToDto(FeaturedAccesory featuredAcc) {

        FeaturedIndexProductDto featuredProdDto = new FeaturedIndexProductDto();

        Products entity = featuredAcc.getProducts();

        featuredProdDto.setProductId(entity.getProdId());
        featuredProdDto.setProductName(entity.getName());
        featuredProdDto.setProductPrice(entity.getPrice());
        featuredProdDto.setImageUrl(entity.getImg());

        return  featuredProdDto;
    }



}
