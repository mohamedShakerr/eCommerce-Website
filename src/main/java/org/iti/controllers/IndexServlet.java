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
import org.iti.utils.*;

import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {


	}


	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");



		// ============== Call On Services And Get Required Stuff ================
		//======================== Featured Product Service ================
		FeaturedProductsService featuredProductsService = new FeaturedProductsService();
		List<FeaturedIndexProductDto> featuredProducts = featuredProductsService.getAllFeaturedProducts();
		List<FeaturedIndexProductDto> featuredAccessories = featuredProductsService.getAllFeaturedAccessories();


		HttpSession session = request.getSession(true);
//		session.setAttribute("userId",1);

		S3UploadManager uploadManager = new S3UploadManager();

		request.setAttribute("featuredProducts", featuredProducts);
		request.setAttribute("featuredAccessories", featuredAccessories);


		rd.forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


	}


}
	