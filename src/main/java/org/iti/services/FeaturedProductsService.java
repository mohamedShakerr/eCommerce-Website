package org.iti.services;

import jakarta.websocket.Session;

import org.iti.db.domain.DBProduct;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.services.mappers.EntityToDtoMapper;
import org.iti.services.mappers.todtomappers.DBProdToFeaturedProd;

import java.util.ArrayList;
import java.util.List;

public class FeaturedProductsService {

    Session serviceSessison = null;

    public FeaturedProductsService(){
        //TODO Should Create Session Here

    }



    public List<FeaturedIndexProductDto> getAllFeaturedProducts(){

        //Access DaoImpl , Pass The Sesison
        DBProduct product1 = new DBProduct();
        product1.setMainImg("assets/images/ps4pro_black.jpg");
        product1.setName("PS4 Black PRO");
        product1.setPrice(69.69);
        product1.setId(1);
        product1.setSecondaryImgs(null);
        product1.setCategory("cat");
        product1.setDescription("Adsd");
        product1.setQuantity(100);

        DBProduct product2 = new DBProduct();
        product2.setMainImg("assets/images/ps4pro_black.jpg");
        product2.setName("PS4 Black PRO 600G.B");
        product2.setPrice(69.69);
        product2.setId(1);
        product2.setSecondaryImgs(null);
        product2.setCategory("cat");
        product2.setDescription("Adsd");
        product2.setQuantity(100);

        DBProduct product3 = new DBProduct();
        product3.setMainImg("assets/images/ps4pro_white.jpg");
        product3.setName("PS4 WHITE PRO 600G.B");
        product3.setPrice(69.69);
        product3.setId(1);
        product3.setSecondaryImgs(null);
        product3.setCategory("cat");
        product3.setDescription("Adsd");
        product3.setQuantity(100);

        DBProduct product4 = new DBProduct();
        product4.setMainImg("assets/images/ps5.jpg");
        product4.setName("PS5 WHITE PRO 600G.B");
        product4.setPrice(69.69);
        product4.setId(1);
        product4.setSecondaryImgs(null);
        product4.setCategory("cat");
        product4.setDescription("Adsd");
        product4.setQuantity(100);

        List<DBProduct> dbProducts = new ArrayList<>();
        dbProducts.add(product1);
        dbProducts.add(product2);
        dbProducts.add(product3);
        dbProducts.add(product4);


        EntityToDtoMapper<FeaturedIndexProductDto,DBProduct> mapper = new DBProdToFeaturedProd();
        return mapper.convertEntityListToDtoList(dbProducts);

    }

    public List<FeaturedIndexProductDto> getAllFeaturedAccessories(){

        //Access DaoImpl , Pass The Sesison
        DBProduct product1 = new DBProduct();
        product1.setMainImg("assets/images/thumb_1.jpg");
        product1.setName("PS4 Black PRO");
        product1.setPrice(69.69);
        product1.setId(1);
        product1.setSecondaryImgs(null);
        product1.setCategory("cat");
        product1.setDescription("Adsd");
        product1.setQuantity(100);

        DBProduct product2 = new DBProduct();
        product2.setMainImg("assets/images/thumb_2.jpg");
        product2.setName("PS4 Black PRO 600G.B");
        product2.setPrice(69.69);
        product2.setId(1);
        product2.setSecondaryImgs(null);
        product2.setCategory("cat");
        product2.setDescription("Adsd");
        product2.setQuantity(100);

        DBProduct product3 = new DBProduct();
        product3.setMainImg("assets/images/thumb_3.jpg");
        product3.setName("PS4 WHITE PRO 600G.B");
        product3.setPrice(69.69);
        product3.setId(1);
        product3.setSecondaryImgs(null);
        product3.setCategory("cat");
        product3.setDescription("Adsd");
        product3.setQuantity(100);

        DBProduct product4 = new DBProduct();
        product4.setMainImg("assets/images/thumb_5.jpg");
        product4.setName("PS4 WHITE PRO 600G.B");
        product4.setPrice(69.69);
        product4.setId(1);
        product4.setSecondaryImgs(null);
        product4.setCategory("cat");
        product4.setDescription("Adsd");
        product4.setQuantity(100);
        List<DBProduct> dbProducts = new ArrayList<>();
        dbProducts.add(product1);
        dbProducts.add(product2);
        dbProducts.add(product3);
        dbProducts.add(product4);
        dbProducts.add(product2);
        dbProducts.add(product4);

        EntityToDtoMapper<FeaturedIndexProductDto, DBProduct> mapper = new DBProdToFeaturedProd();

        return  mapper.convertEntityListToDtoList(dbProducts);
    }

}
