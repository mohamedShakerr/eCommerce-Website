package org.iti.services;

import org.hibernate.Session;
import org.iti.dao.impl.ProductImpl;
import org.iti.dao.interfaces.ProductDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.Products;
import org.iti.dtos.ProdDetailDto;
import org.iti.utils.mappers.EntityToDtoMapper;
import org.iti.utils.mappers.todtomappers.DBProdToDetailedProd;

public class ProductService {

    Session serviceSessison = null;

    public ProductService(){
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        serviceSessison = dbSessionProvider.getSession();
    }


    public ProdDetailDto getProductById(Integer id){

        ProductDao productDao = new ProductImpl(serviceSessison);
        Products product = productDao.getProductById(id);

        EntityToDtoMapper<ProdDetailDto, Products> mapper = new DBProdToDetailedProd();
        return mapper.convertEntityToDto(product);
    }


    public  void terminateService(){
        serviceSessison.close();
    }

}
