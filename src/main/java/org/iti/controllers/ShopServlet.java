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
            Gson gson = new Gson();
            String currentPage = request.getParameter("page");

            //if current page is null, assume we are in the first page
            //entering the first time.
            if(currentPage == null)
                currentPage = "1";


            //Get The Filter Criteria
            FilterCriteria criteria  = gson.fromJson(filter, FilterCriteria.class);

            //Initialize our service
            ShopService shopService = new ShopService();

            //Get Number Of Pages we gonna have
            long numberOfPages = shopService.getNumberOfPagesOfCriteria(criteria);

            //By Default we view the first page
            //fetch the first 6 products
            //Parse current page to pageNum
            //BATCH SIZE is configurable in  shop service class
            int pageNum = Integer.parseInt(currentPage);
            //FilterProducts And Fetch First Page Of result ONLY
            List<ShopProdDto> prodList = shopService.batchFilterProducts(criteria, pageNum);


            shopService.terminateService();
            request.setAttribute("currentPage", pageNum);
            request.setAttribute("products", prodList);
            request.setAttribute("NumberOfPages", numberOfPages);

            RequestDispatcher filtered = request.getRequestDispatcher("shop-prods-col.jsp");
            filtered.forward(request,response);
        }

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


    }


}