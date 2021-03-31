package org.iti.data.daoimpl;

import org.iti.domain.Customer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomerDAO {
    private static Map <Integer, Customer> customers= new HashMap<>();
    static {
        Customer customer=new Customer();
        customer.setId(1);
        customer.setAddress("Egypt");
        customer.setCredit(2000);
        customer.setEmail("mshaker809@yahoo.com");
        customer.setImage("https://via.placeholder.com/300/?Text=Prod");
        customer.setName("Mohamed Shaker");
        customer.setPhone("+2011117360890");
        customer.setPassword("123456");
        customer.setRegDate(new Date());
        customers.put(1,customer);
    }
    public Customer getCustomer(int id){
        if(customers.containsKey(id)){
            return  customers.get(id);
        }
        return null;
    }

    public void updateCustomer(Customer customer){
        customers.put(customer.getId(),customer);
    }
}
