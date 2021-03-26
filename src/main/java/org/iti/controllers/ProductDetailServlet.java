package org.iti.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.dtos.ProdDetailDto;
import org.iti.services.FeaturedProductsService;
import org.iti.services.ProductService;
import org.iti.utils.S3UploadManager;

import java.io.IOException;
import java.util.List;


public class ProductDetailServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {


    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Integer productId = Integer.parseInt( request.getParameter("prodId") );

        ProductService prodService = new ProductService();
        ProdDetailDto product = prodService.getProductById(productId);

        System.out.println(productId);
        System.out.println(product);

        request.setAttribute("product", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("prod-detail.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


    }


}