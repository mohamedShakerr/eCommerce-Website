package org.iti.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.dtos.CustomerDto;
import org.iti.services.CustomerService;

import java.io.IOException;

public class AdminCustomerProfileController extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {

	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		RequestDispatcher rd = request.getRequestDispatcher("/admin/customers/admin_customer_profile.jsp");

		Integer customerId = Integer.parseInt(request.getParameter("customerId"));

		System.out.println("parameter is" + customerId);

		CustomerService customerService = new CustomerService();
		CustomerDto customer = customerService.getCustomerByUserId(customerId);

		customerService.terminateService();

		if(customerId != null){
			request.setAttribute("myCustomer", customer);
		}

		rd.forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


	}


}
	