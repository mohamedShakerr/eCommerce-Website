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

            String currentPage = request.getParameter("page");

            //if current page is null, assume we are in the first page
            //entering the first time.
            if(currentPage == null)
                currentPage = "1";

            ShopService shopService = new ShopService();

            //Get Max Price of Prods
            double maxPrice = shopService.getMaxPrice();
            //Get All Categories we Have
            List<ShopCategoryDto> categoryList = shopService.getAllCategories();
            //Get Number Of Pages we gonna have
            Integer numberOfPages = shopService.getNumberOfPagesForAllProds();
            System.out.println(numberOfPages);
            //Be Default we view the first page
            //fetch the first 6 products
            //Parse current page to pageNum
            int pageNum = Integer.parseInt(currentPage);

            List<ShopProdDto> prodList = shopService.fetchProdsByBatch(pageNum);

//            int NumberOfPages = shopService.getNumberOfPages(prodList);


            shopService.terminateService();

            request.setAttribute("currentPage",pageNum);
            request.setAttribute("categories", categoryList);
            request.setAttribute("products", prodList);
            request.setAttribute("maxPrice", maxPrice);
            request.setAttribute("NumberOfPages", numberOfPages);


            rd.forward(request,response);
        }
        else {
            System.out.println(filter);
            Gson gson = new Gson();
            //Got The Filter Criteria
            FilterCriteria criteria  = gson.fromJson(filter, FilterCriteria.class);

            //Shop Service
            ShopService shopService = new ShopService();

            List<ShopProdDto> prodList = shopService.filterProducts(criteria);

            double maxPrice = shopService.getMaxPrice();
            List<ShopCategoryDto> categoryList = shopService.getAllCategories();

            System.out.println("=========" + shopService.getNumberOfCriteriaProducts(criteria));

            int NumberOfPages = shopService.getNumberOfPages(prodList);

            shopService.terminateService();

//            request.setAttribute("categories", categoryList);
            request.setAttribute("products", prodList);
//            request.setAttribute("maxPrice", maxPrice);
            request.setAttribute("NumberOfPages", NumberOfPages);


            RequestDispatcher filterd = request.getRequestDispatcher("shop-prods-col.jsp");
            filterd.forward(request,response);
        }

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


    }


}