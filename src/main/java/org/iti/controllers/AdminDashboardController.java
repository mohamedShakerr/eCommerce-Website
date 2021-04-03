package org.iti.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iti.dtos.CustomerDto;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.services.CustomerService;
import org.iti.services.FeaturedProductsService;
import org.iti.services.ProductService;
import org.iti.utils.S3UploadManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AdminDashboardController extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		RequestDispatcher rd = request.getRequestDispatcher("admin_screen.jsp");

		ProductService productsService = new ProductService();
		List<FeaturedIndexProductDto> productsList = productsService.getAllProducts();

		request.setAttribute("productsList", productsList);

		rd.forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Integer productId = Integer.valueOf(request.getParameter("productId"));

		ProductService productsService = new ProductService();

		boolean result = productsService.deleteProduct(productId);

		out.println(result);

	}


}
	