<%@ page import="java.util.*,org.iti.db.domain.CartItems" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <!--====== Title ======-->
    <title>eCommerce HTML | Profile</title>

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--====== Favicon Icon ======-->
    <link rel="shortcut icon" href="assets/images/favicon.png" type="image/png">

    <!--====== Tiny Slider CSS ======-->
    <link rel="stylesheet" href="assets/css/tiny-slider.css">

    <!--====== Line Icons CSS ======-->
    <link rel="stylesheet" href="assets/css/LineIcons.css">

    <!--====== Material Design Icons CSS ======-->
    <link rel="stylesheet" href="assets/css/materialdesignicons.min.css">

    <!--====== FONT Awesome Icons CSS ======-->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
          crossorigin="anonymous" />

    <!--====== Bootstrap CSS ======-->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">

    <!--====== gLightBox CSS ======-->
    <link rel="stylesheet" href="assets/css/glightbox.min.css">


    <!--====== nouiSlider CSS ======-->
    <link rel="stylesheet" href="assets/css/nouislider.min.css">

    <!--====== Default CSS ======-->
    <link rel="stylesheet" href="assets/css/default.css">

    <!--====== Template Style CSS ======-->
    <link rel="stylesheet" href="assets/css/tempstyle.css">

    <!--====== Style CSS ======-->
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- card style-->
    <link rel="stylesheet" type="text/css" href="assets/css/card.css">

    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>

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
    <%--    <link href="form-validation.css" rel="stylesheet">--%>
</head>
<body >

<!--======================== Navbar  Starts ====================================-->
<c:set var="userId" value="${sessionScope.userId}" scope="session"/>
<jsp:include page="./navbar.jsp"/>
<!--======================== Navbar  Ends ====================================-->

<div class="container mt-30 mb-30">
    <main>
        <div class="row g-5">


            <div class="col-md-5 col-lg-4 order-md-last">
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-primary">Your cart</span>
                    <span class="badge bg-primary rounded-pill"><c:out
                            value="${requestScope.cartItemsList.size()}"/></span>
                </h4>
                <ul class="list-group mb-3" id="cartItemsExpadable">
                    <c:choose>
                    <c:when test="${not empty requestScope.cartItemsList}">

                    <c:forEach items="${requestScope.cartItemsList}" var="cartItem" varStatus="count">
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                            <div type="button" data-bs-toggle="collapse" data-bs-target="#collapse${count.index}" aria-expanded="true" aria-controls="collapse${count.index}" class="">
                                <h7><c:out value="${cartItem.quantity}"/>X</h7>
                                <h6 class="my-0"><c:out value="${cartItem.products.name}"/></h6>
                                <div id="collapse${count.index}" class="accordion-collapse collapse " aria-labelledby="heading${count.index}" data-bs-parent="#cartItemsExpadable" style="border: none">
                                    <small class="text-muted"><c:out value="${cartItem.products.description}"/></small>
                                </div>

                            </div>
                            <span class="text-muted"><c:out value="${cartItem.products.price}"/></span>
                        </li>
                    </c:forEach>

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

                    </c:when>
                        <c:otherwise>
                            <li class="list-group-item d-flex justify-content-between">

                                <strong>Your Cart is Empty</strong>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>


            </div>

<c:if test="${not empty requestScope.cartItemsList}">
            <div class="col-md-7 col-lg-8">
                <h4 class="mb-3">Billing address</h4>

                <form class="needs-validation" novalidate method="post" action="checkout">
                    <div class="row g-3">


                        <div class="col-12">
                            <label for="address" class="form-label">Address</label>
                            <input type="text" class="form-control" id="address" name="address"
                                   placeholder="1234 Main St" required>
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
                            <input id="credit" name="paymentMethod" type="radio" class="form-check-input" value="credit"
                                   checked required>
                            <label class="form-check-label" for="credit"><i class="far fa-credit-card"></i>Credit card</label>
                        </div>

                        <div class="form-check">
                            <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" value="paypal"
                                   required>
                            <label class="form-check-label" for="paypal"><i class="fab fa-cc-paypal"></i>PayPal</label>
                        </div>
                    </div>


                    <hr class="my-4">

                    <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
                </form>
            </div>

</c:if>
        </div>
    </main>

</div>

<%--============ FOOTER =============--%>
<jsp:include page="./footer.jsp"/>
<%--============ FOOTER END =============--%>


<!--====== Bootstrap js ======-->
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>--%>
<script src="assets/js/bootstrap.bundle-5.0.0-beta1.min.js"></script>

<!--====== Tiny Slider js ======-->
<script src="assets/js/tiny-slider.js"></script>

<!--====== nouiSlider js ======-->
<script src="assets/js/nouislider.min.js"></script>

<!--====== count up js ======-->
<script src="assets/js/count-up.min.js"></script>

<!--====== gLightBox js ======-->
<script src="assets/js/glightbox.min.js"></script>
<!--====== Main js ======-->
<script src="assets/js/main.js"></script>

<script src="assets/js/card.js"></script>

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
