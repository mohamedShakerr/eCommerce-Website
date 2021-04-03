package org.iti.services;

import org.hibernate.Session;
import org.iti.dao.impl.ProductImpl;
import org.iti.dao.interfaces.ProductDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.Products;
import org.iti.dtos.AdminProductDto;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.dtos.ProdDetailDto;
import org.iti.utils.mappers.EntityDtoMapper;
import org.iti.utils.mappers.Mapper;
import org.iti.utils.mappers.todtomappers.DBProdToDetailedProd;
import org.iti.utils.mappers.todtomappers.ProductToAdminProduct;
import org.iti.utils.mappers.todtomappers.ProductToFeaturedProduct;

import java.util.List;

public class ProductService {

    Session serviceSessison = null;

    public ProductService() {
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        serviceSessison = dbSessionProvider.getSession();
    }


    public ProdDetailDto getProductById(Integer id) {

        ProductDao productDao = new ProductImpl(serviceSessison);
        Products product = productDao.getProductById(id);

        Mapper<ProdDetailDto, Products> mapper = new DBProdToDetailedProd();
        return mapper.convertEntityToDto(product);
    }

    public List<FeaturedIndexProductDto> getAllProducts() {

        //Access DaoImpl , Pass The Sesison
        ProductDao productDao = new ProductImpl(serviceSessison);

        List<Products> products = productDao.getAllProducts();

        EntityDtoMapper<Products, FeaturedIndexProductDto> mapper = new ProductToFeaturedProduct();
        return mapper.entityListToDtoList(products);

    }

    public AdminProductDto getAdminProductById(Integer id) {

        ProductDao productDao = new ProductImpl(serviceSessison);
        Products product = productDao.getProductById(id);

        Mapper<AdminProductDto, Products> mapper = new ProductToAdminProduct();
        return mapper.convertEntityToDto(product);
    }

    public AdminProductDto updateProduct(AdminProductDto productDto) {

        ProductDao productDao = new ProductImpl(serviceSessison);

        Products product = productDao.getProductById(productDto.getProductId());

        product.setName(productDto.getProductName());
        product.setPrice(productDto.getProductPrice());
        product.setQuantity(productDto.getQuantity());
        product.setDescription(productDto.getDescription());

        product = productDao.updateProduct(product);

        Mapper<AdminProductDto, Products> mapper = new ProductToAdminProduct();

        if (product != null) {
            return mapper.convertEntityToDto(product);
        }

        return null;
    }


    public boolean deleteProduct(Integer productId) {

        ProductDao productDao = new ProductImpl(serviceSessison);

        return productDao.deleteProductById(productId);
    }

    public void terminateService() {
        serviceSessison.close();
    }


}
