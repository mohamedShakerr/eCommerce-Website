package org.iti.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.db.domain.CartItems;
import org.iti.services.CheckoutService;

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

    }
}