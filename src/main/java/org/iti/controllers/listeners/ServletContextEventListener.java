package org.iti.controllers.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.iti.utils.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ServletContextEventListener implements ServletContextListener{
    
    
    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("===============Context Initialized");
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

    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("=================Context Destroyed");
    } 

}