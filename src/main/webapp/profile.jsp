<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">

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

</head>

<body>

<!--======================== Navbar  Starts ====================================-->
<c:set var="userId" value="${sessionScope.userId}" scope="session"/>
<jsp:include page="./navbar.jsp"/>
<!--======================== Navbar  Ends ====================================-->


    <!--====== Profile Start ======-->

    <section class="profile-wrapper pt-100 pb-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-9">
                    <div class="profile">
                        <div class="profile-header">
                            <div class="profile-cover-photo bg_cover" ></div>
                            <div class="profile-author d-sm-flex flex-row-reverse justify-content-between align-items-end">
                                <div class="profile-photo">
                                    <img src="<c:out value="${customer.image}"/>" alt="Profile Photo">
                                </div>
                                <div class="profile-name">
                                    <h4 class="name"><c:out value="${customer.name}"/></h4>
                                </div>
                            </div>
                        </div>
                        <div class="profile-body">
                            <div class="profile-title">
                                <h5 class="title">Personal Details</h5>
                                <a class="profile-link" href="edit_profile.jsp">edit</a>
                            </div>
                            <div class="profile-details">
                                <div class="single-details-item d-flex flex-wrap">
                                    <div class="details-title">
                                        <h6 class="title">User Full Name:</h6>
                                    </div>
                                    <div class="details-content media-body">
                                        <p><c:out value="${customer.name}"/></p>
                                    </div>
                                </div>
								
                                <div class="single-details-item d-flex flex-wrap">
                                    <div class="details-title">
                                        <h6 class="title">Email:</h6>
                                    </div>
                                    <div class="details-content media-body">
                                        <p><c:out value="${customer.email}"/></p>
                                    </div>
                                </div>
								
								
                                <div class="single-details-item d-flex flex-wrap">
                                    <div class="details-title">
                                        <h6 class="title">Phone:</h6>
                                    </div>
                                    <div class="details-content media-body">
                                        <p><c:out value="${customer.phone}"/></p>
                                    </div>
                                </div>
								
                                <div class="single-details-item d-flex flex-wrap">
                                    <div class="details-title">
                                        <h6 class="title">Address:</h6>
                                    </div>
                                    <div class="details-content media-body">
                                        <p><c:out value="${customer.address}"/></p>
                                    </div>
                                </div>
                           
								
                                <div class="single-details-item d-flex flex-wrap">
                                    <div class="details-title">
                                        <h6 class="title">Registration date:</h6>
                                    </div>
                                    <div class="details-content media-body">
                                        <p><c:out value="${customer.regDate}"/></p>
                                    </div>
                                </div>
                                <div class="single-details-item d-flex flex-wrap">
                                    <div class="details-title">
                                        <h6 class="title">Credit limit:</h6>
                                    </div>
                                    <div class="details-content media-body">
                                        <p><c:out value="${customer.credit}"/></p>
                                    </div>
                                </div>
								
								 <div class="single-details-item d-flex flex-wrap">
                                    <div class="details-title">
                                        <h6 class="title">Interests:</h6>
                                    </div>
                                    <div class="details-content media-body">
                                        <p>xxx,xx</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="profile-footer mt-45">
                            <div class="profile-title">
                                <h5 class="title">Cards</h5>
                                <a class="profile-link" href="#0" onclick="showCard()">Add Cards</a>
                            </div>
                            <div class="profile-card-info">
                                <div id="creditCardFormId" class="creditCardForm" style="display: none">

                                    <div class="payment">
                                        <form>
                                            <div class="form-group owner" >
                                                <label for="owner">Owner</label>
                                                <input type="text" class="form-control" id="owner">
                                                <div class="alert alert-danger" id="ownerNameError" style="display:none">

                                                </div>
                                            </div>
                                            <div class="form-group CVV">
                                                <label for="cvv">CVV</label>
                                                <input type="text" class="form-control" id="cvv">
                                                <div class="alert alert-danger" id="CVVError" style="display:none">

                                                </div>
                                            </div>
                                            <div class="form-group" id="card-number-field">
                                                <label for="cardNumber">Card Number</label>
                                                <input type="text" class="form-control" id="cardNumber">
                                                <div class="alert alert-danger" id="cardNumberError" style="display:none" >

                                                </div>
                                            </div>
                                            <div class="form-group" id="expiration-date">
                                                <label>Expiration Date</label>
                                                <select>
                                                    <option value="01">January</option>
                                                    <option value="02">February </option>
                                                    <option value="03">March</option>
                                                    <option value="04">April</option>
                                                    <option value="05">May</option>
                                                    <option value="06">June</option>
                                                    <option value="07">July</option>
                                                    <option value="08">August</option>
                                                    <option value="09">September</option>
                                                    <option value="10">October</option>
                                                    <option value="11">November</option>
                                                    <option value="12">December</option>
                                                </select>
                                                <select>
                                                    <option value="21"> 2021</option>
                                                    <option value="22"> 2022</option>
                                                    <option value="23"> 2023</option>
                                                    <option value="24"> 2024</option>
                                                    <option value="25"> 2025</option>
                                                    <option value="26"> 2026</option>
                                                </select>
                                            </div>
                                            <div class="form-group" id="credit_cards">
                                                <img src="assets/imgs/visa.jpg" id="visa">
                                                <img src="assets/imgs/mastercard.jpg" id="mastercard">

                                            </div>
                                            <div class="form-group" id="money-field">
                                                <label >Money</label>
                                                <input type="text" class="form-control" id="money">
                                                <div class="alert alert-danger" id="moneyError" style="display:none" >

                                                </div>
                                            </div>
                                            <div class="form-group" id="pay-now">
                                                <button  class="btn btn-default" id="confirm-purchase">Confirm</button>
                                            </div>
                                        </form>

<%--                                        <div class="alert alert-danger" role="alert">--%>
<%--                                            This is a danger alert—check it out!--%>
<%--                                        </div>--%>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
<%--    <tr>--%>
<%--        <td>Visa</td>--%>
<%--        <td>4716108999716531</td>--%>
<%--        <td>257</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Master Card</td>--%>
<%--        <td>5281037048916168</td>--%>
<%--        <td>043</td>--%>
<%--    </tr>--%>
    <!--====== Profile Ends ======-->

<%--============ FOOTER =============--%>
<jsp:include page="./footer.jsp"/>
<%--============ FOOTER END =============--%>

    <!--====== Bootstrap js ======-->
    <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--====== Tiny Slider js ======-->
    <script src="assets/js/tiny-slider.js"></script>

    <!--====== nouiSlider js ======-->
    <script src="assets/js/nouislider.min.js"></script>

    <!--====== count up js ======-->
    <script src="assets/js/count-up.min.js"></script>

    <!--====== gLightBox js ======-->
    <script src="assets/js/glightbox.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!--====== Main js ======-->
    <script src="assets/js/main.js"></script>

    <script src="assets/js/card.js"></script>
    <script src="assets/js/jquery.payform.min.js" charset="utf-8"></script>

    <%--=======CART SCRIPT======--%>
    <script src="./assets/js/cart.js"></script>
<script>
    function showCard(){
        if(document.getElementById("creditCardFormId").style.display=="none"){
            document.getElementById("creditCardFormId").style.display="block";
        }else{
            document.getElementById("creditCardFormId").style.display="none";
        }
    }
</script>
</body>

</html>