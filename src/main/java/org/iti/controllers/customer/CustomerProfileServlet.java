package org.iti.controllers.customer;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import org.iti.domain.Customer;
import org.iti.services.CustomerServices;


public class CustomerProfileServlet extends HttpServlet{
	 
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		String idStr=request.getParameter("userid");
		int id=Integer.parseInt(idStr);
		CustomerServices customerServices=new CustomerServices(request,response);
		customerServices.showCustomerProfile(id);



	}

	
}