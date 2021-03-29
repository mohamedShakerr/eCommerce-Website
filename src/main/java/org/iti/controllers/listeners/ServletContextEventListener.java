package org.iti.controllers.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.iti.dao.impl.CartImpl;
import org.iti.dao.interfaces.CartDao;
import org.iti.db.DBSessionProvider;
import org.iti.dtos.CartDto;
import org.iti.services.CartService;
import org.iti.utils.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


public class ServletContextEventListener implements ServletContextListener{
    
    
    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("===============Context Initialized ==================");
        ServletContext servletContext = sce.getServletContext();

        InputStream  inputStream= servletContext.getResourceAsStream("/WEB-INF/classes/s3client.properties");
        Properties s3Creds = new Properties();
        try {
            s3Creds.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s3Id = s3Creds.getProperty("accesskeyId");
        String s3Key = s3Creds.getProperty("accessKeySecret");
        S3ClientProvider s3ClientProvider = S3ClientProvider.getInstance();
        s3ClientProvider.initializeClient(s3Id,s3Key);


        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();

        URL url = null;
        try {
             url = servletContext.getResource("/WEB-INF/classes/hibernate.cfg.xml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(url).build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        dbSessionProvider.setSessionFactory(sessionFactory);



//        ===============================dao testings
        System.out.println("=============DAO TESTING =============");

//        System.out.println(cartDao.getCartByUserId(1));
//        System.out.println(cartDao.getCartProdCountByUserId(1));

//        CartService cartService = new CartService();
//        CartDto dto = cartService.getCartByUserId(1);
//        System.out.println(dto);


    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("=================Context Destroyed");
    } 

}