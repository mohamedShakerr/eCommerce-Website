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
import org.iti.services.PaymentServices;

import java.io.IOException;
import java.util.List;

@WebServlet("/execute_payment")
public class ExecutePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");

        try {
            PaymentServices paymentServices = new PaymentServices();
            Payment payment = paymentServices.executePayment(paymentId, payerId);

            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);

            CheckoutCreditService checkoutCreditService=CheckoutCreditService.getInstance();
            CartDao cartDao=new CartImpl();
            HttpSession session=request.getSession();
            int id=(int)session.getAttribute("userId");
            List<CartItems> cartItemsList=cartDao.getCartByUserId(id);
            checkoutCreditService.decreaseProductQuantity(cartItemsList);
            checkoutCreditService.saveOrders(cartItemsList);
            //delete cart

            cartDao.deleteCart(id);

            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);

            request.getRequestDispatcher("receipt.jsp").forward(request, response);

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}