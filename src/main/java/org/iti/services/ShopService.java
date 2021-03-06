package org.iti.services;

import org.hibernate.Session;
import org.iti.dao.impl.CategoryImpl;
import org.iti.dao.impl.ProductImpl;
import org.iti.dao.interfaces.CategoryDao;
import org.iti.dao.interfaces.ProductDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.Categories;
import org.iti.db.domain.Products;
import org.iti.dtos.FilterCriteria;
import org.iti.dtos.ShopCategoryDto;
import org.iti.dtos.ShopProdDto;
import org.iti.utils.mappers.Mapper;
import org.iti.utils.mappers.todtomappers.DBCatToShopCat;
import org.iti.utils.mappers.todtomappers.DBProdToShopProd;

import java.util.List;

public class ShopService {


    private Session serviceSessison = null;
    private Integer BATCH_SIZE = 6;

    public ShopService(){
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        serviceSessison = dbSessionProvider.getSession();
    }

    public List<ShopProdDto> fetchProdTest(){

        ProductDao productDao = new ProductImpl(serviceSessison);

        List<Products> products = productDao.getAllProducts();

        Mapper<ShopProdDto, Products> mapper = new DBProdToShopProd();
        List<ShopProdDto> list = mapper.convertEntityListToDtoList(products);

        return  list;

    }

    public void terminateService(){
        serviceSessison.close();
    }

    public double getMaxPrice(){
        ProductDao productDao = new ProductImpl(serviceSessison);
        return  productDao.getMaximumProdPrice();
    }

    public List<ShopCategoryDto> getAllCategories(){
        CategoryDao categoryDao = new CategoryImpl(serviceSessison);
        List<Categories> categoryList =  categoryDao.getAllCategories();

        Mapper<ShopCategoryDto, Categories> mapper = new DBCatToShopCat();
        return  mapper.convertEntityListToDtoList(categoryList);
    }

    public List<ShopProdDto> filterProducts(FilterCriteria criteria){

        ProductDao productDao = new ProductImpl(serviceSessison);
        Mapper<ShopProdDto, Products> mapper = new DBProdToShopProd();
        List<ShopProdDto> prodDtos = null;

        List<Integer> categoryIds = criteria.getCategories();
        double maxPrice = criteria.getMaxPrice();
        double minprice = criteria.getMinPrice();


        if (criteria.getCategories().size() <= 0){
            List<Products> products = productDao.getAllProductsWithingPriceRange(minprice, maxPrice);
            prodDtos = mapper.convertEntityListToDtoList(products);
        }else {
            List<Products> products = productDao.getAllProductsByCatAndPriceRange(minprice,maxPrice,categoryIds);
            prodDtos = mapper.convertEntityListToDtoList(products);
        }
        return  prodDtos;
    }


    public List<ShopProdDto> batchFilterProducts(FilterCriteria criteria, int pageNumber){

        ProductDao productDao = new ProductImpl(serviceSessison);
        Mapper<ShopProdDto, Products> mapper = new DBProdToShopProd();
        List<ShopProdDto> prodDtos = null;

        List<Integer> categoryIds = criteria.getCategories();
        double maxPrice = criteria.getMaxPrice();
        double minprice = criteria.getMinPrice();


        if (criteria.getCategories().size() <= 0){
            List<Products> products = productDao.batchProductsWithingPriceRange(pageNumber, BATCH_SIZE, minprice, maxPrice);
            prodDtos = mapper.convertEntityListToDtoList(products);
        }else {
            List<Products> products = productDao.batchAllProductsByCatAndPriceRange(pageNumber,BATCH_SIZE,minprice,maxPrice,categoryIds);
            prodDtos = mapper.convertEntityListToDtoList(products);
        }
        return  prodDtos;
    }

    //Gets the number of Procusts matching this Criteria
    public long numOfProdsMatching(FilterCriteria criteria){
        ProductDao productDao = new ProductImpl(serviceSessison);

        List<Integer> categoryIds = criteria.getCategories();
        double maxPrice = criteria.getMaxPrice();
        double minprice = criteria.getMinPrice();

        long prodNumber = 0;

        if (criteria.getCategories().size() <= 0){
            prodNumber = productDao.getProdNumber(minprice, maxPrice);
        }else {
            prodNumber = productDao.getProdNumber(minprice, maxPrice, categoryIds);
        }
        return prodNumber;
    }


    public Integer getNumberOfPages(List<ShopProdDto> list){

        double pages = list.size() * 1.0 / BATCH_SIZE;
        return  (int) Math.ceil( pages );
    }

    public Integer getNumberOfPagesForAllProds(){

        ProductDao productDao = new ProductImpl(serviceSessison);

        long prodCount = productDao.getProdCount();
        double pages = prodCount*1.0 / BATCH_SIZE;

        return  (int) Math.ceil(pages);
    }


    public List<ShopProdDto> fetchProdsByBatch(Integer pageNum){

        ProductDao productDao = new ProductImpl(serviceSessison);
        List<Products> products =  productDao.fetchProductsByBatch(pageNum, BATCH_SIZE);

        Mapper<ShopProdDto, Products> mapper = new DBProdToShopProd();
        return  mapper.convertEntityListToDtoList(products);
    }



    public Integer getNumberOfPagesOfCriteria(FilterCriteria criteria){

        long prodsMatchingCount = numOfProdsMatching(criteria);
        double pages = prodsMatchingCount*1.0 / BATCH_SIZE;
        return  (int) Math.ceil(pages);
    }



}
