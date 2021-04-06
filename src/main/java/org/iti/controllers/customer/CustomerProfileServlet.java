package org.iti.controllers.customer;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

import org.iti.dtos.CartDto;
import org.iti.dtos.CustomerDto;
import org.iti.services.CartService;
import org.iti.services.CustomerServices;


public class CustomerProfileServlet extends HttpServlet{
	 
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
//		String idStr=request.getParameter("userid");

		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("userId");



		CustomerServices customerServices=new CustomerServices();
		CustomerDto customerDto=customerServices.showCustomerProfile(id);

		CartService cartService = CartService.getInstance();

		Integer userId = (Integer) session.getAttribute("userId");

		if(userId != null){
			CartDto cart = cartService.getCartByUserId(userId);
			request.setAttribute("cartItems", cart.getCartItems());
		}else{
			request.setAttribute("cartItems", new ArrayList<>());
		}
		cartService.terminateService();

		session.setAttribute("customerDto", customerDto);
		RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
		rd.forward(request, response);


	}

	
}