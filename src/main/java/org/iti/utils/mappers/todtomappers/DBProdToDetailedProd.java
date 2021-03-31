package org.iti.utils.mappers.todtomappers;

import org.iti.db.domain.Products;
import org.iti.dtos.ProdDetailDto;
import org.iti.utils.mappers.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DBProdToDetailedProd extends Mapper<ProdDetailDto, Products> {


    @Override
    public ProdDetailDto convertEntityToDto(Products entity) {

        ProdDetailDto prodDetailDto = new ProdDetailDto();

        prodDetailDto.setId(entity.getProdId());
        prodDetailDto.setPrice(entity.getPrice());
        prodDetailDto.setProdDescription(entity.getDescription());
        prodDetailDto.setQuantity(entity.getQuantity());
        prodDetailDto.setProdName(entity.getName());

        List<String> images = new ArrayList<>();
        images.add(entity.getImg());
        entity.getProdImageses().forEach(prodImage ->{
            images.add(prodImage.getImageUrl());
        } );
        prodDetailDto.setProdImages(images);

        return prodDetailDto;
    }
}
