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
import jakarta.servlet.http.HttpSession;
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
        HttpSession session=request.getSession();
        int id=(int)session.getAttribute("userId");
        CheckoutService checkoutService=CheckoutService.getInstance();
        double subTotal=checkoutService.getSubTotal(id);
        CheckoutCreditService checkoutCreditService=CheckoutCreditService.getInstance();
        if(!checkoutCreditService.checkCreditLimit(id,subTotal+20)){
            return;
        }
        checkoutCreditService.decreaseCreditCard(subTotal+20,id);
        //populate order table
        List<CartItems> cartItemsList=checkoutService.getCartItems(id);
        checkoutCreditService.saveOrders(cartItemsList);
        //delete cart
        CartDao cartDao=new CartImpl();
        cartDao.deleteCart(id);

        //decrease product quantity
        checkoutCreditService.decreaseProductQuantity(cartItemsList);


        request.setAttribute("subTotal", subTotal);
        request.getRequestDispatcher("receiptCredit.jsp").forward(request, response);


    }

}