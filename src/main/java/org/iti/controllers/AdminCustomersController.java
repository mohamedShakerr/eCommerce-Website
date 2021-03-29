package org.iti.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.dtos.CustomerDto;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.services.CustomerService;
import org.iti.services.ProductsService;

import java.io.IOException;
import java.util.List;

public class AdminCustomersController extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {

	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		RequestDispatcher rd = request.getRequestDispatcher("admin_customers.jsp");

		CustomerService customerService = new CustomerService();
		List<CustomerDto> customersList = customerService.getAllCustomers();

		request.setAttribute("customersList", customersList);

		rd.forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


	}


}
	