package org.iti.services;

import org.hibernate.Session;
import org.iti.dao.impl.CustomerDaoImpl;
import org.iti.dao.impl.ProductDaoImpl;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.dao.interfaces.ProductDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.Customers;
import org.iti.db.domain.Products;
import org.iti.dtos.CustomerDto;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.utils.mappers.EntityDtoMapper;
import org.iti.utils.mappers.todtomappers.CustomerMapper;
import org.iti.utils.mappers.todtomappers.ProductToFeaturedProduct;

import java.util.List;

public class CustomerService {

    // Todo make session usage consistant just like products service
    Session serviceSessison = null;

    public CustomerService() {
        //TODO Should Create Session Here
        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        serviceSessison = dbSessionProvider.getSession();
    }


    public List<CustomerDto> getAllCustomers() {

        //Access DaoImpl , Pass The Sesison
        CustomerDao customerDao = new CustomerDaoImpl();

        List<Customers> customers = customerDao.getAllCustomers();

        EntityDtoMapper<Customers, CustomerDto> mapper = new CustomerMapper();

        return mapper.entityListToDtoList(customers);

    }

}
