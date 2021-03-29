package org.iti.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.services.FeaturedProductsService;
import org.iti.services.ProductsService;
import org.iti.utils.S3UploadManager;

import java.io.IOException;
import java.util.List;

public class AdminController extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {


	}


	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		RequestDispatcher rd = request.getRequestDispatcher("admin_screen.jsp");


		ProductsService productsService = new ProductsService();
		List<FeaturedIndexProductDto> productsList = productsService.getAllProducts();

		request.setAttribute("productsList", productsList);

		rd.forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


	}


}
	