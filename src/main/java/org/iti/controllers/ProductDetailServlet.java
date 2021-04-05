package org.iti.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iti.dtos.CartDto;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.dtos.ProdDetailDto;
import org.iti.services.CartService;
import org.iti.services.FeaturedProductsService;
import org.iti.services.ProductService;
import org.iti.utils.ProductNotFoundException;
import org.iti.utils.S3UploadManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProductDetailServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {


    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Integer productId = Integer.parseInt( request.getParameter("prodId") );

        if(productId < 0){
            throw new ProductNotFoundException("-ve Product Id");
        }

        String added = request.getParameter("added");



        ProductService prodService = new ProductService();
        ProdDetailDto product = prodService.getProductById(productId);

        prodService.terminateService();

        request.setAttribute("prodAdded",added );
        request.setAttribute("product", product);

        HttpSession session = request.getSession();
        CartService cartService = CartService.getInstance();

        Integer userId = (Integer) session.getAttribute("userId");

        if(userId != null){
            CartDto cart = cartService.getCartByUserId(userId);
            request.setAttribute("cartItems", cart.getCartItems());
        }else{
            request.setAttribute("cartItems", new ArrayList<>());
        }
        cartService.terminateService();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/prod-detail.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


    }


}