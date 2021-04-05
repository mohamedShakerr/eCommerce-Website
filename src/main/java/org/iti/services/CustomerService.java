package org.iti.services;

import org.hibernate.Session;
import org.iti.dao.impl.CustomerDaoImpl;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.Customers;
import org.iti.db.domain.OrderItems;
import org.iti.db.domain.Orders;
import org.iti.dtos.CustomerDto;
import org.iti.utils.mappers.EntityDtoMapper;
import org.iti.utils.mappers.todtomappers.CustomerMapper;

import java.util.ArrayList;
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

    public CustomerDto getCustomerByUserEmail(String userEmail) {

        CustomerDao customerDao = new CustomerDaoImpl();

        Customers customer = customerDao.getCustomerByUserEmail(userEmail);

        EntityDtoMapper<Customers, CustomerDto> mapper = new CustomerMapper();

        return mapper.toDto(customer);

    }

    public CustomerDto getCustomerByUserId(Integer customerId) {

        CustomerDao customerDao = new CustomerDaoImpl();

        Customers customer = customerDao.getCustomerByUserId(customerId);

        EntityDtoMapper<Customers, CustomerDto> mapper = new CustomerMapper();

        return mapper.toDto(customer);
    }


    public List<List<Object>> getOrdersDetailsByUserId(Integer customerId) {

        CustomerDao customerDao = new CustomerDaoImpl();

        List<Orders> orders = customerDao.getOrdersByUserId(customerId);

        List<List<Object>> allOrders = new ArrayList<>();

        for(Orders order : orders){
            List<Object> OrderDetail = new ArrayList<>();
            double totalPrice = 0 ;

            OrderDetail.add(order.getOrderId());
            OrderDetail.add(order.getOrderItemses().size());

            for (OrderItems orderItems: order.getOrderItemses()){
                totalPrice += orderItems.getUnitPrice() * orderItems.getQuantity();
            }
            OrderDetail.add(totalPrice);

            OrderDetail.add(order.getDate());

            allOrders.add(OrderDetail);
        }

        return allOrders;
    }


    public void terminateService() {
        serviceSessison.close();
    }

}
