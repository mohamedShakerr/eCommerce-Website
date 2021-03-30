package org.iti.services;


import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.iti.db.domain.CartItems;

import java.util.ArrayList;
import java.util.List;

public class PaymentServices {
    private static final String CLIENT_ID = "AcgMm3D5O0JIaSuTD_hFGNu37HzRqZT-ezQVvDi5qHc9qNLGrnstIBwoBE4wiTQIYFoQzagBDs0AHHZB";
    private static final String CLIENT_SECRET = "EJP4m7mC0Lp0z97Lti-Lm1hUjxzeDRRlMJKQVVW97txNanqtKqDwmAvLo025wOlDnuMp1wTo5H9kJM1P";
    private static final String MODE = "sandbox";

    public String authorizePayment(List<CartItems> orderDetail,double subTotal) throws PayPalRESTException {

        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail,subTotal);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        return getApprovalLink(approvedPayment);

    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("William")
                .setLastName("Peterson")
                .setEmail("william.peterson@company.com");

        payer.setPayerInfo(payerInfo);

        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:9191/eCommerceWebsite/cancel.html");
        redirectUrls.setReturnUrl("http://localhost:9191/eCommerceWebsite/review_payment");

        return redirectUrls;
    }

    private List<Transaction> getTransactionInformation(List<CartItems> orderDetail,double subTotal) {
        Details details = new Details();
        details.setShipping("10");//orderDetail.getShipping()
        details.setTax("10");//orderDetail.getTax()
        details.setSubtotal(String.valueOf(subTotal));//orderDetail.getSubtotal()

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(String.valueOf(subTotal+20));//orderDetail.getTotal()
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
//        transaction.setDescription("XXXXXXXXXXXXXDEscription");

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();
        for (CartItems cartItems:orderDetail) {
            Item item = new Item();
            item.setCurrency("USD");
            item.setName(cartItems.getProducts().getName());
            item.setPrice(String.valueOf(cartItems.getProducts().getPrice()));
            // item.setTax("5");
            item.setQuantity(String.valueOf(cartItems.getQuantity()));
            items.add(item);
        }



        itemList.setItems(items);
        transaction.setItemList(itemList);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);

        return listTransaction;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }

        return approvalLink;
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        return payment.execute(apiContext, paymentExecution);
    }
}