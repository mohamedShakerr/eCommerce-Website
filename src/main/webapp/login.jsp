<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">

    <!--====== Title ======-->
    <title>Login</title>

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon1/png">

    <!--====== Material Design Icons CSS ======-->
    <link rel="stylesheet" href="assets/css/materialdesignicons.min.css">

    <!--====== FONT Awesome Icons CSS ======-->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
          crossorigin="anonymous" />

    <!--====== Bootstrap CSS ======-->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">

    <!--====== Default CSS ======-->
    <link rel="stylesheet" href="assets/css/default.css">

    <!--====== Temp Style CSS ======-->
    <link rel="stylesheet" href="assets/css/tempstyle.css">

    <!--====== font-awesome Style CSS ======-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    <!--====== Style CSS ======-->
    <link rel="stylesheet" href="assets/css/style.css">

</head>

<body>

<c:set var="userId" value="${sessionScope.userId}" scope="session"/>
<jsp:include page="navbar.jsp"/>

    <section class="login-registration-wrapper pt-50 pb-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 align-self-center">
                    <c:if test='${requestScope["cookiesState"].equals("cookiesBlocked")}'>
                        <jsp:include page="alertCookies.jsp"/>
                    </c:if>
                    <div class="login-registration-style-2 text-center mt-50">
                        <div>
                            <h3 style="color: #542DED;">
                                <i class="fab fa-playstation"></i>
                                <i class="fas fa-gamepad"></i>
                            </h3>
                            <h1 class="heading-4 font-weight-500 title" style="color: #542DED;">Login</h1>
                        </div>

                        <div class="login-registration-form pt-10">
                            <form action="login" method="post">

                                <div class="single-form form-default form-border">

                                    <c:if test='${! empty requestScope.InputError}'>
                                        <span id="inputErr" style="color: #ff0000;">
                                            Invalid email or password.
                                        </span>
                                    </c:if>
                                    <span id="invalidInput"></span>
                                     <div class="form-input">
                                         <input type="email" name="email" id="email" placeholder="Email">
                                         <i class="mdi mdi-email" style="color: #542DED;"></i>
                                     </div>
                                    <br>

                                 </div>
                                 <div class="single-form form-default form-border">
                                     <div class="form-input">
                                         <input id="password-5" type="password" name="password" placeholder="Password" required>
                                         <i class="mdi mdi-lock" style="color: #542DED;"></i>
<%--                                         <span toggle="#password-5" class="mdi mdi-eye-outline toggle-password"></span>--%>
                                     </div>
                                     <br>
                                 </div>
                                 <div class="login-checkbox-forget d-sm-flex justify-content-between align-items-center">
                                     <div class="single-checkbox checkbox-style-3">
                                         <input type="checkbox" name="rememberMe" id="remember-me" value="true" >
                                         <label for="remember-me"><span></span> </label>
                                         <p>Remember Me</p>
                                     </div>
                                 </div>
                                 <div class="single-form">
                                     <button class="main-btn primary-btn" id="lgnBtn">Sign in</button>
                                 </div>
                            </form>
                        </div>
                        <div class="d-sm-flex justify-content-between align-items-center">
                            <p class="login" >Don't have an account? <a href="register">Sign up</a></p>
                        </div>
                    </div>
                 </div>

            </div>
        </div>
    </section>

<!--====== Footer Style 5 Part Start ======-->

<jsp:include page="footer.jsp"/>
<!--====== Footer Style 5 Part Ends ======-->

    <!--====== Bootstrap js ======-->
    <script src="assets/js/bootstrap.min.js"></script>

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

    <!--====== JQuery js ======-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


    <!--====== LoginForm js ======-->
    <script src="assets/js/loginForm.js"></script>


</body>

</html>