package org.iti.controllers.customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.iti.dtos.CustomerDto;
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
			CustomerDto customerDto=(CustomerDto) session.getAttribute("customerDto");
			/******xxxxxxxxxxxxxxx***********/
			int id=1;
		    double totalMoney=customerServices.addMoneyToCredit(id,moneyAdded);
			customerDto.setCredit(totalMoney);
		
	}
	


}