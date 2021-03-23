package org.iti.controllers.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.FeaturedProds;
import org.iti.db.domain.Products;
import org.iti.utils.*;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
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

    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("=================Context Destroyed");
    } 

}