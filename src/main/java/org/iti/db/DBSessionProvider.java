package org.iti.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import  org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;;
public class DBSessionProvider {


    private SessionFactory sessionFactory= null;
    private static DBSessionProvider dbSessionProvider = null;

    private DBSessionProvider(){}

    public  static DBSessionProvider getInstance(){
        if(dbSessionProvider == null){
            synchronized (DBSessionProvider.class){
                if(dbSessionProvider == null){
                    dbSessionProvider = new DBSessionProvider();
                }
            }
        }
        return  dbSessionProvider;
    }

    public  void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public Session getSession(){
        return sessionFactory.openSession();
    }

    public void terminateSessionFactory(){
        sessionFactory.close();
    }

}
