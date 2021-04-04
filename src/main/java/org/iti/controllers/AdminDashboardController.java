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
import java.util.ArrayList;
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


            Part filePart = request.getPart("productImageFile");

            ProductService productsService = new ProductService();

            byte[] imageBytes = filePart.getInputStream().readAllBytes();


            List<Part> albumParts = (List<Part>) request.getParts();



            List<byte[]> productAlbumData = new ArrayList<>();

            for (int i = 0; i < albumParts.size(); i++){
                if (albumParts.get(i).getSubmittedFileName() != null && !albumParts.get(i).getSubmittedFileName().isEmpty()){
                    if(!albumParts.get(i).getName().equals("productImageFile")){
                        String fileNamePart = albumParts.get(i).getSubmittedFileName();
                        productAlbumData.add(albumParts.get(i).getInputStream().readAllBytes());
                        System.out.println("prodAlbumPart name =======" + fileNamePart);
                    }
                }
            }


            AdminProductDto productDto = new AdminProductDto(productName,Double.valueOf(productPrice),
                    Integer.valueOf(productQuantity),productCategory,productDescription,imageBytes,productAlbumData);

          productsService.addNewProduct(productDto);

          this.doGet(request,response);

        }
    }
}
	