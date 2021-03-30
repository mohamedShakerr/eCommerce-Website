package org.iti.controllers;

import com.paypal.base.rest.PayPalRESTException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.db.domain.CartItems;
import org.iti.services.CheckoutService;
import org.iti.services.PaymentServices;

import java.io.IOException;
import java.util.List;


public class CheckoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CheckoutService checkoutService=CheckoutService.getInstance();
        //Hard CODE
        List<CartItems> cartItemsList= checkoutService.getCartItems(1);

        request.setAttribute("cartItemsList",cartItemsList);
        request.setAttribute("subtotal",checkoutService.getSubTotal(1));
        RequestDispatcher rd =request.getRequestDispatcher("/checkout.jsp");

        rd.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paymentMethod=request.getParameter("paymentMethod");
        CheckoutService checkoutService=CheckoutService.getInstance();
        //Hard CODE
        List<CartItems> cartItemsList= checkoutService.getCartItems(1);
        if(paymentMethod.equals("credit")){
            String country=request.getParameter("country");
            String state=request.getParameter("state");
            String ziPcode=request.getParameter("zipcode");
        }else if(paymentMethod.equals("paypal")){
            try {
                PaymentServices paymentServices = new PaymentServices();
                //hard code   xxxxxx
                String approvalLink = paymentServices.authorizePayment(cartItemsList,checkoutService.getSubTotal(1));

                response.sendRedirect(approvalLink);

            } catch (PayPalRESTException ex) {
                request.setAttribute("errorMessage", ex.getMessage());
                ex.printStackTrace();
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
    }
}