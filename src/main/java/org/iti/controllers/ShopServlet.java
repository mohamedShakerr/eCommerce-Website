package org.iti.controllers;

import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iti.db.domain.Products;
import org.iti.dtos.CartDto;
import org.iti.dtos.FilterCriteria;
import org.iti.dtos.ShopCategoryDto;
import org.iti.dtos.ShopProdDto;
import org.iti.services.CartService;
import org.iti.services.ShopService;
import org.iti.utils.ProductNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
        String categ = request.getParameter("cat");

        if(categ != null)
            if((!categ.matches("[0-9]+") || (Integer.parseInt(categ) < 0))){
                throw new ProductNotFoundException("Invalid Category");
            }

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
            List<ShopCategoryDto> categoryList = shopService.getAllCategories();

            //We have 2 cases, we have Query param of category, Then we will run filter
            Integer numberOfPages = 0;
            int pageNum = 1;
            List<ShopProdDto> prodList = null;
            if(categ != null){
                //Construct Filteration
                FilterCriteria criteria = new FilterCriteria();
                criteria.setMaxPrice(maxPrice);
                criteria.setMinPrice(criteria.getMinPrice());
                criteria.setCategories(Arrays.asList(Integer.parseInt(categ)));

                numberOfPages = shopService.getNumberOfPagesOfCriteria(criteria);
                pageNum = Integer.parseInt(currentPage);
                prodList = shopService.batchFilterProducts(criteria,pageNum);
            }else {
                //Get All Categories we Have
                //Get Number Of Pages we gonna have
                numberOfPages = shopService.getNumberOfPagesForAllProds();
                //Be Default we view the first page
                //fetch the first 6 products
                //Parse current page to pageNum
                pageNum = Integer.parseInt(currentPage);
                prodList = shopService.fetchProdsByBatch(pageNum);
            }


            shopService.terminateService();

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


            request.setAttribute("currentPage",pageNum);
            request.setAttribute("categories", categoryList);
            request.setAttribute("products", prodList);
            request.setAttribute("maxPrice", maxPrice);
            request.setAttribute("NumberOfPages", numberOfPages);
            if(categ == null){
                request.setAttribute("categId", -1);
            }else {
                request.setAttribute("categId", categ);
            }


            rd.forward(request,response);
        }
        else {
            Gson gson = new Gson();
            String currentPage = request.getParameter("page");
            ShopService shopService = new ShopService();

            //if current page is null, assume we are in the first page
            //entering the first time.
            if(currentPage == null)
                currentPage = "1";

            //Check if we came form idnex page with a category query  param

            FilterCriteria  criteria  = gson.fromJson(filter, FilterCriteria.class);

            //Initialize our service

            //Get Number Of Pages we gonna have
            long numberOfPages = shopService.getNumberOfPagesOfCriteria(criteria);

            //By Default we view the first page
            //fetch the first 6 products
            //Parse current page to pageNum
            //BATCH SIZE is configurable in  shop service class
            int pageNum = Integer.parseInt(currentPage);
            //FilterProducts And Fetch First Page Of result ONLY
            List<ShopProdDto> prodList = shopService.batchFilterProducts(criteria, pageNum);

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