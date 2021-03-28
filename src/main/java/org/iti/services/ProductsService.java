package org.iti.services;

import org.hibernate.Session;
import org.iti.dao.impl.FeaturedProductImpl;
import org.iti.dao.impl.ProductDaoImpl;
import org.iti.dao.interfaces.FeaturedProductDao;
import org.iti.dao.interfaces.ProductDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.DBProduct;
import org.iti.db.domain.Products;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.utils.mappers.EntityDtoMapper;
import org.iti.utils.mappers.todtomappers.DBProdToFeaturedProd;
import org.iti.utils.mappers.todtomappers.ProductToFeaturedProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductsService {

    Session serviceSessison = null;

    public ProductsService() {
        //TODO Should Create Session Here
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        serviceSessison = dbSessionProvider.getSession();
    }


    public List<FeaturedIndexProductDto> getAllProducts() {

        //Access DaoImpl , Pass The Sesison
        ProductDao productDao = new ProductDaoImpl(serviceSessison);

        List<Products> products = productDao.getAllProducts();

        EntityDtoMapper<Products, FeaturedIndexProductDto> mapper = new ProductToFeaturedProduct();
        return mapper.entityListToDtoList(products);

    }

}
