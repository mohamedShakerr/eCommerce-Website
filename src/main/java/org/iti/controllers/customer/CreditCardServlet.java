package org.iti.controllers.customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.iti.domain.Customer;
import org.iti.services.CustomerServices;

import java.io.*;
import java.util.*;

public class CreditCardServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
			String messagesStr="{\"msg\":\"Money added successfully\"}";
            String money=request.getParameter("money");
            double moneyAdded=Double.parseDouble(money);
		    CustomerServices customerServices=new CustomerServices();
		HttpSession session = request.getSession();
		Customer customer=(Customer) session.getAttribute("customer");

		    double totalMoney=customerServices.addMoneyToCredit(moneyAdded,customer.getId());
		    customer.setCredit(totalMoney);
		
	}
	


}