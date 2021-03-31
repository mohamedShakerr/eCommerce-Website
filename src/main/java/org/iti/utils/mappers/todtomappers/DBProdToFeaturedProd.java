package org.iti.utils.mappers.todtomappers;


import org.iti.db.domain.FeaturedProds;
import org.iti.db.domain.Products;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.utils.mappers.Mapper;

public class DBProdToFeaturedProd extends Mapper<FeaturedIndexProductDto, FeaturedProds> {


    @Override
    public FeaturedIndexProductDto convertEntityToDto(FeaturedProds featuredProd) {


        FeaturedIndexProductDto featuredProdDto = new FeaturedIndexProductDto();

        Products entity = featuredProd.getProducts();

        featuredProdDto.setProductId(entity.getProdId());
        featuredProdDto.setProductName(entity.getName());
        featuredProdDto.setProductPrice(entity.getPrice());
        featuredProdDto.setImageUrl(entity.getImg());

        return  featuredProdDto;
    }



}
