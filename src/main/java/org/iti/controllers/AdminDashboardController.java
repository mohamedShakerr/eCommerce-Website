package org.iti.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import org.iti.dtos.AdminProductDto;
import org.iti.dtos.CustomerDto;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.services.CustomerService;
import org.iti.services.FeaturedProductsService;
import org.iti.services.ProductService;
import org.iti.utils.S3UploadManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@MultipartConfig
public class AdminDashboardController extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("admin_screen.jsp");

        ProductService productsService = new ProductService();
        List<FeaturedIndexProductDto> productsList = productsService.getAllProducts();

        request.setAttribute("productsList", productsList);

        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();


        String operation = request.getParameter("operation") ;

        System.out.println("Request url" + request.getRequestURL());


        if (operation.equals("deleteProduct")) {

            Integer productId = Integer.valueOf(request.getParameter("productId"));
            ProductService productsService = new ProductService();
            boolean result = productsService.deleteProduct(productId);
            out.println(result);

        } else if (operation.equals("addProduct")) {


            String productName = request.getParameter("productName");
            String productPrice = request.getParameter("productPrice");
            String productQuantity = request.getParameter("productQuantity");
            Integer productCategory = Integer.valueOf(request.getParameter("categorySelector"));
            String productDescription = request.getParameter("productDescription");

            System.out.println("name =======" + productName);
            System.out.println("price =======" + productPrice);
            System.out.println("quantity =======" + productQuantity);
            System.out.println("category =======" + productCategory);
            System.out.println("descprition =======" + productDescription);

            Part filePart = request.getPart("productImageFile");

            String fileName = filePart.getSubmittedFileName();
            ProductService productsService = new ProductService();

            byte[] imageBytes = filePart.getInputStream().readAllBytes();

            AdminProductDto productDto = new AdminProductDto(productName,Double.valueOf(productPrice),
                    Integer.valueOf(productQuantity),productCategory,productDescription,imageBytes);


          productsService.addNewProduct(productDto);

        }


    }


}
	