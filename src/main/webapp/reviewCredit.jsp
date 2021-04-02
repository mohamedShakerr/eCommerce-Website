<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Review</title>
    <style type="text/css">
        table { border: 0; }
        table td { padding: 5px; }
    </style>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
<div align="center">
    <h1>Please Review Before Paying</h1>
    <form action="execute_payment_credit" method="post">
        <table>
            <tr>
                <td colspan="2"><b>Transaction Details:</b></td>
            </tr>

            <tr>
                <td>Subtotal:</td>
                <td>${requestScope.subtotal} USD</td>
            </tr>
            <tr>
                <td>Shipping:</td>
                <td>10 USD</td>
            </tr>
            <tr>
                <td>Tax:</td>
                <td>10 USD</td>
            </tr>
            <tr>
                <td>Total:</td>
                <td>${requestScope.subtotal+20} USD</td>
            </tr>
            <tr><td><br/></td></tr>
            <tr>
                <td colspan="2"><b>Payer Information:</b></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${customerDto.name}</td>
            </tr>

            <tr>
                <td>Email:</td>
                <td>${customerDto.email}</td>
            </tr>
            <tr><td><br/></td></tr>
            <tr>
                <td colspan="2"><b>Shipping Address:</b></td>
            </tr>
            <tr>
                <td>Recipient Name:</td>
                <td>${customerDto.name}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${requestScope.addressBilling}</td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>${requestScope.countryBilling}</td>
            </tr>
            <tr>
                <td>State:</td>
                <td>${requestScope.stateBilling}</td>
            </tr>
            <tr>
                <td>Zip Code:</td>
                <td>${requestScope.zipcodeBilling}</td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Pay Now" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>