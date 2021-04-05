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

		String customerEmail = request.getParameter("email");

		System.out.println("parameter is" + customerEmail);

		CustomerService customerService = new CustomerService();
		CustomerDto customer = customerService.getCustomerByUserEmail(customerEmail);

		customerService.terminateService();

		if(customerEmail != null){
			request.setAttribute("myCustomer", customer);
		}

		rd.forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


	}


}
	