package org.iti.services;

import org.iti.dao.impl.FeaturedProductImpl;
import org.iti.dao.impl.ProductImpl;
import org.iti.dao.interfaces.FeaturedProductDao;
import org.iti.dao.interfaces.ProductDao;
import org.iti.db.domain.FeaturedAccesory;
import org.iti.db.domain.FeaturedProds;
import org.iti.db.domain.Products;
import org.iti.dtos.ProdDetailDto;
import org.iti.utils.mappers.Mapper;

import org.hibernate.Session;
import org.iti.db.DBSessionProvider;
import org.iti.dtos.FeaturedIndexProductDto;

import org.iti.utils.mappers.todtomappers.DBProdToDetailedProd;
import org.iti.utils.mappers.todtomappers.DBProdToFeaturedAccessory;
import org.iti.utils.mappers.todtomappers.DBProdToFeaturedProd;

import java.util.List;

public class FeaturedProductsService {

    Session serviceSessison = null;

    public FeaturedProductsService(){
        //TODO Should Create Session Here
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        serviceSessison = dbSessionProvider.getSession();
    }



    public List<FeaturedIndexProductDto> getAllFeaturedProducts(){

        FeaturedProductDao dao = new FeaturedProductImpl(serviceSessison);

        List<FeaturedProds> dbProducts = dao.getAllFeaturedProducts();

        Mapper<FeaturedIndexProductDto,FeaturedProds> mapper = new DBProdToFeaturedProd();
        return mapper.convertEntityListToDtoList(dbProducts);

    }

    public List<FeaturedIndexProductDto> getAllFeaturedAccessories(){

        FeaturedProductDao dao = new FeaturedProductImpl(serviceSessison);

        List<FeaturedAccesory> dbProducts = dao.getAllFeaturedAccessories();

        Mapper<FeaturedIndexProductDto, FeaturedAccesory> mapper = new DBProdToFeaturedAccessory();

        return  mapper.convertEntityListToDtoList(dbProducts);
    }

    public ProdDetailDto getOculusFeaturedProduct(){

        ProductDao productDao = new ProductImpl(serviceSessison);
        //TODO ZABAT DEH ===========>>>
        Products OculusFeaturedProd = productDao.getProductById(3);
        Mapper<ProdDetailDto, Products> mapper = new DBProdToDetailedProd();

        return  mapper.convertEntityToDto(OculusFeaturedProd);
    }

}
