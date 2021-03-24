package org.iti.controllers.customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class CreditCardServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
			String messagesStr="{\"msg\":\"Money added successfully\"}";

			PrintWriter out = response.getWriter();
			out.print(messagesStr);
	}
	


}