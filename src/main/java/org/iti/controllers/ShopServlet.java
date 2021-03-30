package org.iti.controllers;

import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.db.domain.Products;
import org.iti.dtos.FilterCriteria;
import org.iti.dtos.ShopCategoryDto;
import org.iti.dtos.ShopProdDto;
import org.iti.services.ShopService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShopServlet", urlPatterns = {"/shop"})
public class ShopServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        //Need to Get Number Of Pages, According to the selected Query
        String filter  = request.getParameter("filter");

        //If Filter is Null Retrieve All Prods
        if(filter == null){
            System.out.println("Filter is null");
            ShopService shopService = new ShopService();

            List<ShopProdDto> prodList = shopService.fetchProdTest();
            double maxPrice = shopService.getMaxPrice();
            List<ShopCategoryDto> categoryList = shopService.getAllCategories();
            int NumberOfPages = shopService.getNumberOfPages(prodList);

            shopService.terminateService();

            request.setAttribute("categories", categoryList);
            request.setAttribute("products", prodList);
            request.setAttribute("maxPrice", maxPrice);
            request.setAttribute("NumberOfPages", NumberOfPages);

            rd.forward(request,response);
        }
        else {
            System.out.println(filter);
            Gson gson = new Gson();
            FilterCriteria criteria  = gson.fromJson(filter, FilterCriteria.class);


            ShopService shopService = new ShopService();
            List<ShopProdDto> prodList = shopService.filterProducts(criteria);

            double maxPrice = shopService.getMaxPrice();
            List<ShopCategoryDto> categoryList = shopService.getAllCategories();

            int NumberOfPages = shopService.getNumberOfPages(prodList);

            shopService.terminateService();

            request.setAttribute("categories", categoryList);
            request.setAttribute("products", prodList);
            request.setAttribute("maxPrice", maxPrice);
            request.setAttribute("NumberOfPages", NumberOfPages);


            System.out.println(prodList);

        }


    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


    }


}