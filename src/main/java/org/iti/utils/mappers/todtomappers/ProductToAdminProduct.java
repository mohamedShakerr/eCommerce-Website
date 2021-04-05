package org.iti.utils.mappers.todtomappers;

import org.iti.db.domain.ProdImages;
import org.iti.db.domain.Products;
import org.iti.dtos.AdminProductDto;
import org.iti.utils.mappers.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ProductToAdminProduct extends Mapper<AdminProductDto, Products> {


    @Override
    public AdminProductDto convertEntityToDto(Products entity) {

        AdminProductDto adminProductDto = new AdminProductDto();

        adminProductDto.setProductId(entity.getProdId());
        adminProductDto.setProductName(entity.getName());
        adminProductDto.setProductPrice(entity.getPrice());
        adminProductDto.setImageUrl(entity.getImg());
        adminProductDto.setQuantity(entity.getQuantity());
        adminProductDto.setDescription(entity.getDescription());

        List<String> images = new ArrayList<>();

        images.add(entity.getImg());

        entity.getProdImageses().forEach(prodImage -> {
            images.add(prodImage.getImageUrl());
        });
        adminProductDto.setProductImageURLs(images);

        return adminProductDto;
    }


    public Products convertDtoToEntity(AdminProductDto productDto) {

        Products product = new Products();

        product.setName(productDto.getProductName());
        product.setPrice(productDto.getProductPrice());
        product.setImg(productDto.getImageUrl());
        product.setQuantity(productDto.getQuantity());

        product.setDescription(productDto.getDescription());


        productDto.getProductImageURLs().forEach(prodImage ->{
            product.getProdImageses().add(new ProdImages(product, prodImage));
        } );

        System.out.println("################################### inside product to admin product" +
                ""+product.getProdImageses().size());
        return product;
    }
}
