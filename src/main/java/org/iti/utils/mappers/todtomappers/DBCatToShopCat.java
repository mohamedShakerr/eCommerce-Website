package org.iti.utils.mappers.todtomappers;

import org.apache.commons.lang3.StringUtils;
import org.iti.db.domain.Categories;
import org.iti.dtos.ShopCategoryDto;
import org.iti.utils.mappers.Mapper;

public class DBCatToShopCat extends Mapper<ShopCategoryDto, Categories> {


    @Override
    public ShopCategoryDto convertEntityToDto(Categories entity) {
        ShopCategoryDto shopCategoryDto = new ShopCategoryDto();

        shopCategoryDto.setId(entity.getCatId());
        shopCategoryDto.setName(StringUtils.capitalize(entity.getCatName()));

        return  shopCategoryDto;
    }
}
