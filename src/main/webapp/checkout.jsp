<%@ page import="java.util.*,org.iti.db.domain.CartItems" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.82.0">
    <title>Checkout example · Bootstrap v5.0</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/checkout/">

    

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      .container {
        max-width: 960px;
      }

    </style>

    
    <!-- Custom styles for this template -->
    <link href="form-validation.css" rel="stylesheet">
  </head>
  <body class="bg-light">
    
<div class="container">
  <main>
    
    <div class="row g-5">


      <div class="col-md-5 col-lg-4 order-md-last">
        <h4 class="d-flex justify-content-between align-items-center mb-3">
          <span class="text-primary">Your cart</span>
          <span class="badge bg-primary rounded-pill"><c:out value="${requestScope.cartItemsList.size()}"/></span>
        </h4>
        <ul class="list-group mb-3">
<c:if test="${not empty requestScope.cartItemsList}">

  <c:forEach items="${requestScope.cartItemsList}" var="cartItem">
          <li class="list-group-item d-flex justify-content-between lh-sm">
            <div>
              <h7><c:out value="${cartItem.quantity}"/>X</h7> <h6 class="my-0"><c:out value="${cartItem.products.name}"/></h6>
              <small class="text-muted"><c:out value="${cartItem.products.description}"/></small>
            </div>
            <span class="text-muted"><c:out value="${cartItem.products.price}"/></span>
          </li>
  </c:forEach>
</c:if>
          <li class="list-group-item d-flex justify-content-between">
            <span>Sub Total (USD)</span>
            <strong>$<c:out value="${requestScope.subtotal}"/></strong>
          </li>
          <li class="list-group-item d-flex justify-content-between">
            <span>Shipping (USD)</span>
            <strong>$10</strong>
          </li>
          <li class="list-group-item d-flex justify-content-between">
            <span>Tax (USD)</span>
            <strong>$10</strong>
          </li>


          <li class="list-group-item d-flex justify-content-between">
            <span>Total (USD)</span>
            <strong>$<c:out value="${requestScope.subtotal+20}"/></strong>
          </li>
        </ul>


      </div>

      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">Billing address</h4>

        <form class="needs-validation" novalidate method="post" action="checkout">
          <div class="row g-3">
         

            <div class="col-12">
              <label for="address" class="form-label">Address</label>
              <input type="text" class="form-control" id="address" placeholder="1234 Main St" required>
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>

            <div class="col-md-5">
              <label for="country" class="form-label">Country</label>
              <input type="text" class="form-control" id="country" name="country" required>
                
              <div class="invalid-feedback">
                Please select a valid country.
              </div>
            </div>

            <div class="col-md-4">
              <label for="state" class="form-label">State</label>
              <input type="text" class="form-control" id="state" name="state" required>
               
              <div class="invalid-feedback">
                Please provide a valid state.
              </div>
            </div>

            <div class="col-md-3">
              <label for="zip" class="form-label">Zip</label>
              <input type="text" class="form-control" id="zip" name="zipcode" placeholder="" required>
              <div class="invalid-feedback">
                Zip code required.
              </div>
            </div>
          </div>

          <hr class="my-4">

          

          <h4 class="mb-3">Payment</h4>

          <div class="my-3">
            <div class="form-check">
              <input id="credit" name="paymentMethod" type="radio" class="form-check-input" value="credit" checked required>
              <label class="form-check-label" for="credit">Credit card</label>
            </div>
         
            <div class="form-check">
              <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" value="paypal" required>
              <label class="form-check-label" for="paypal">PayPal</label>
            </div>
          </div>


          <hr class="my-4">

          <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
        </form>
      </div>
    </div>
  </main>

</div>


    <script src="assets/js/bootstrap.bundle-5.0.0-beta1.min.js"></script>

      <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })
})()

      </script>
  </body>
</html>
