package org.iti.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.dtos.AdminProductDto;
import org.iti.dtos.CustomerDto;
import org.iti.dtos.FeaturedIndexProductDto;
import org.iti.dtos.ProdDetailDto;
import org.iti.services.CustomerService;
import org.iti.services.ProductService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AdminProductDetailsController extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {

	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		RequestDispatcher rd = request.getRequestDispatcher("/admin/products/admin_product_details.jsp");

		String productId = request.getParameter("productId");

		System.out.println("parameter is " + productId);

		ProductService productService = new ProductService();
		AdminProductDto product = productService.getAdminProductById(Integer.valueOf(productId));

		System.out.println("product is " + product);

		if(productId != null){
			request.setAttribute("myProduct", product);
			System.out.println(" parameter is "+ product);
		}

		rd.forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		Integer prodId = Integer.valueOf(request.getParameter("productId"));
		String prodName = request.getParameter("productName");
		Double prodPrice = Double.valueOf(request.getParameter("productPrice"));
		Integer prodQuantity = Integer.valueOf(request.getParameter("quantity"));
		String prodDesc = request.getParameter("description");

		System.out.println("prod name is " + prodName);
		System.out.println("prod id is " + prodId);

		ProductService productService = new ProductService();

		AdminProductDto product = productService.getAdminProductById(prodId);

		product.setProductName(prodName);
		product.setProductPrice(prodPrice);
		product.setQuantity(prodQuantity);
		product.setDescription(prodDesc);

		AdminProductDto updatedProduct = productService.updateProduct(product);

		System.out.println("updated prod : " + updatedProduct);

		productService.terminateService();

		PrintWriter out = response.getWriter();
		out.print(updatedProduct);

	}

}
	