package org.iti.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.dtos.ProdDetailDto;
import org.iti.services.CartService;
import org.iti.services.ProductService;
import software.amazon.awssdk.regions.servicemetadata.Route53ServiceMetadata;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CartEditServlet" , urlPatterns = "/cartedit")
public class CartEditServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {


    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        String edit = request.getParameter("edit");
        String prodId = request.getParameter("prodId");
        String qty = request.getParameter("qty");

        PrintWriter out  = response.getWriter();
        Object outMsg = null;
        if( edit!= null ){
            //TODO REFACTOR
//            Integer userId = (Integer) request.getSession().getAttribute("userId");
            Integer userId = 1;
            Integer productId = null;
            Integer quantity  = null;


            if(prodId != null)
                 productId = Integer.parseInt(prodId);

            if(qty != null){
                quantity = Integer.parseInt(qty);
            }

            CartService cartService = CartService.getInstance();
            switch (edit) {
                case "inc":
                    cartService.incProdInCart(userId,productId);
                    outMsg = "success";
                    break;
                case "dec":
                    cartService.decProdInCart(userId,productId);
                    outMsg = "success";
                    break;
                case "delete":
                    cartService.deleteCartItem(userId,productId);
                    outMsg = "success";
                    break;
                case "updateTotal":
                    outMsg = cartService.getCartTotal(userId);
                    break;
                case "countTotal":
                    outMsg = (Long)cartService.getCartCount(userId);
                    break;
                case "addNew":
                    cartService.addNewItemToCart(userId,productId,quantity);
                    break;
                default:
                    out.print("err");
            }
        }else {
            out.print("err");
            System.out.println("xd");
        }
        out.print(outMsg);
    }


}