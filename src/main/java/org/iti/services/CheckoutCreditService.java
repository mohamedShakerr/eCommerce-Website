package org.iti.services;

import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.iti.dao.impl.CustomerDaoImpl;
import org.iti.dao.impl.ProductImpl;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.dao.interfaces.ProductDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.CartItems;
import org.iti.db.domain.OrderItems;
import org.iti.db.domain.Orders;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckoutCreditService {
    Session serviceSessison = null;
    private static CheckoutCreditService checkoutCreditService = null;

    private CheckoutCreditService(){

        DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
        serviceSessison = dbSessionProvider.getSession();
    }


    public static  CheckoutCreditService getInstance(){
        if(checkoutCreditService == null){
            synchronized (CartService.class){
                if(checkoutCreditService == null){
                    checkoutCreditService = new CheckoutCreditService();
                }
            }
        }
        return checkoutCreditService;
    }


    public boolean checkCreditLimit(int id,double cartTotalMoney){
        CustomerDao customerDao=new CustomerDaoImpl();
        if(customerDao.getCreditLimit(id) >= cartTotalMoney){
            return true;
        }
        return false;
    }

    public void decreaseCreditCard(double decreasedAmount,int id){
        CustomerDao customerDao=new CustomerDaoImpl();

        customerDao.subMoneyToCredit(id,decreasedAmount);
    }

    public void saveOrders(List<CartItems> cartItemsList ){
        Orders order=new Orders();
        order.setCustomers(cartItemsList.get(0).getCustomers());
        order.setDate(new Date());
        Set<OrderItems> orderItemsSet=new HashSet<>();
        serviceSessison.beginTransaction();
        for (CartItems cartItem:cartItemsList){
            OrderItems orderItems=new OrderItems();
            orderItems.setOrders(order);
            orderItems.setProdId(cartItem.getProducts().getProdId());
            orderItems.setQuantity(cartItem.getQuantity());
            orderItems.setUnitPrice(cartItem.getProducts().getPrice());

            orderItemsSet.add(orderItems);
        }

        serviceSessison.persist(order);
        for (OrderItems orderItem:orderItemsSet){
            serviceSessison.persist(orderItem);
        }
        serviceSessison.getTransaction().commit();
    }

    public void decreaseProductQuantity(List<CartItems> cartItemsList ){
        ProductDao productDao=new ProductImpl(serviceSessison);
        for(CartItems cartItem:cartItemsList){
            if (cartItem.getQuantity()>cartItem.getProducts().getQuantity()){
                productDao.clearProductAmount(cartItem.getProducts().getProdId());
            }else {
                productDao.decreaseProductAmount(cartItem.getProducts().getProdId(), cartItem.getQuantity());
            }
        }
    }
}
