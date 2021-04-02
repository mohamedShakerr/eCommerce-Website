package org.iti.controllers.customer;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

import org.iti.dtos.CustomerDto;
import org.iti.services.CustomerServices;


public class CustomerProfileServlet extends HttpServlet{
	 
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
//		String idStr=request.getParameter("userid");

		HttpSession session = request.getSession();
//		int id = (int)session.getAttribute("userId");

		int id = 1;

		CustomerServices customerServices=new CustomerServices();
		CustomerDto customerDto=customerServices.showCustomerProfile(id);

		session.setAttribute("customerDto", customerDto);
		RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
		rd.forward(request, response);


	}

	
}