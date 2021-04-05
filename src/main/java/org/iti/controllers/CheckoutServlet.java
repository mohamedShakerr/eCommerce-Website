package org.iti.controllers;

import com.paypal.base.rest.PayPalRESTException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.CartItems;
import org.iti.db.domain.Customers;
import org.iti.dtos.CustomerDto;
import org.iti.services.CheckoutCreditService;
import org.iti.services.CheckoutService;
import org.iti.services.CustomerServices;
import org.iti.services.PaymentServices;

import java.io.IOException;
import java.util.List;


public class CheckoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CheckoutService checkoutService=CheckoutService.getInstance();
        HttpSession session=request.getSession();
        int id=(int)session.getAttribute("userId");
        List<CartItems> cartItemsList= checkoutService.getCartItems(id);

        request.setAttribute("cartItemsList",cartItemsList);
        request.setAttribute("subtotal",checkoutService.getSubTotal(id));
        RequestDispatcher rd =request.getRequestDispatcher("/checkout.jsp");

        rd.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paymentMethod=request.getParameter("paymentMethod");
        CheckoutService checkoutService=CheckoutService.getInstance();
        HttpSession session=request.getSession();
        int id=(int)session.getAttribute("userId");
        List<CartItems> cartItemsList= checkoutService.getCartItems(id);
        if(paymentMethod.equals("credit")){
            String address=request.getParameter("address");
            String country=request.getParameter("country");
            String state=request.getParameter("state");
            String ziPcode=request.getParameter("zipcode");
            CheckoutCreditService checkoutCreditService=CheckoutCreditService.getInstance();


            //check credit limit
            if(address.equals("")||country.equals("")||state.equals("")||ziPcode.equals("")||
                    (!checkoutCreditService.checkCreditLimit(id,checkoutService.getSubTotal(id)+20))){
                return;
            }
            request.setAttribute("countryBilling",country);
            request.setAttribute("stateBilling",state);
            request.setAttribute("zipcodeBilling",ziPcode);
            request.setAttribute("addressBilling",address);
            DBSessionProvider dbSessionProvider = DBSessionProvider.getInstance();
            Session hsession = dbSessionProvider.getSession();
            Customers customers = hsession.find(Customers.class, id);
            CustomerDto dto = new CustomerDto();
            dto.setEmail(customers.getEmail());
            dto.setName(customers.getName());
            hsession.close();

            request.setAttribute("customerDto",dto);

            request.setAttribute("subtotal",checkoutService.getSubTotal(id));

            request.getRequestDispatcher("reviewCredit.jsp").forward(request, response);

        }else if(paymentMethod.equals("paypal")){
            try {
                PaymentServices paymentServices = new PaymentServices();
                String contextPath=request.getContextPath();
                String approvalLink = paymentServices.authorizePayment(cartItemsList,checkoutService.getSubTotal(id),contextPath);

                response.sendRedirect(approvalLink);

            } catch (PayPalRESTException ex) {
                request.setAttribute("errorMessage", ex.getMessage());
                ex.printStackTrace();
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
    }
}