package org.iti.controllers;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.dao.impl.CartImpl;
import org.iti.dao.interfaces.CartDao;
import org.iti.db.domain.CartItems;
import org.iti.services.CheckoutCreditService;
import org.iti.services.CheckoutService;


import java.io.IOException;
import java.util.List;

@WebServlet("/execute_payment_credit")
public class ExecutePaymentCreditServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //decrease credit limit
        CheckoutService checkoutService=CheckoutService.getInstance();
        double subTotal=checkoutService.getSubTotal(1);
        CheckoutCreditService checkoutCreditService=CheckoutCreditService.getInstance();
        if(!checkoutCreditService.checkCreditLimit(1,subTotal+20)){
            return;
        }
        checkoutCreditService.decreaseCreditCard(subTotal+20);
        //populate order table
        List<CartItems> cartItemsList=checkoutService.getCartItems(1);
        checkoutCreditService.saveOrders(cartItemsList);
        //delete cart
        CartDao cartDao=new CartImpl();
        cartDao.deleteCart(1);

        //decrease product quantity
        checkoutCreditService.decreaseProductQuantity(cartItemsList);


        request.setAttribute("subTotal", subTotal);
        request.getRequestDispatcher("receiptCredit.jsp").forward(request, response);


    }

}