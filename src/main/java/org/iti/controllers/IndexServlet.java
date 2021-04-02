package org.iti.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iti.dtos.CartDto;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.dtos.ProdDetailDto;
import org.iti.services.CartService;
import org.iti.services.FeaturedProductsService;
import org.iti.utils.*;

import java.io.IOException;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

public class IndexServlet extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {


	}


	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

		HttpSession session = request.getSession(true);


		if( session.getAttribute("rememberMe") != null){
			if( session.getAttribute("userId") != null ){
				session.setAttribute("userId", null);
			}
		}

		// ============== Call On Services And Get Required Stuff ================
		//======================== Featured Product Service ================
		FeaturedProductsService featuredProductsService = new FeaturedProductsService();
		List<FeaturedIndexProductDto> featuredProducts = featuredProductsService.getAllFeaturedProducts();
		List<FeaturedIndexProductDto> featuredAccessories = featuredProductsService.getAllFeaturedAccessories();
		ProdDetailDto featuredOculus = featuredProductsService.getOculusFeaturedProduct();

		//====================== Cart Service =======================================
		CartService cartService = CartService.getInstance();
		//TODO CHANGE THIS SHIT
		CartDto cart = cartService.getCartByUserId(1);

		request.setAttribute("featuredProducts", featuredProducts);
		request.setAttribute("featuredAccessories", featuredAccessories);
		request.setAttribute("cartItems", cart.getCartItems());
		request.setAttribute("featuredOculus", featuredOculus);


		rd.forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


	}


}
	