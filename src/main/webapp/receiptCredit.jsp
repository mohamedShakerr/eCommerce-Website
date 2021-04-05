<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Receipt</title>
    <style type="text/css">
        table { border: 0; }
        table td { padding: 5px; }
    </style>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
<div align="center">
    <h1>Payment Done. Thank you for purchasing our products</h1>
    <br/>
    <h2>Receipt Details:</h2>
    <table>
        <tr>
            <td><b>Merchant:</b></td>
            <td>Unity Store .</td>
        </tr>
        <tr>
            <td><b>Payer:</b></td>
            <td>${customerDto.name}</td>
        </tr>

        <tr>
            <td><b>Subtotal:</b></td>
            <td>${requestScope.subTotal} USD</td>
        </tr>
        <tr>
            <td><b>Shipping:</b></td>
            <td>10 USD</td>
        </tr>
        <tr>
            <td><b>Tax:</b></td>
            <td>10 USD</td>
        </tr>
        <tr>
            <td><b>Total:</b></td>
            <td>${requestScope.subTotal+20} USD</td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}">Continue Shopping</a>
</div>
</body>
</html>