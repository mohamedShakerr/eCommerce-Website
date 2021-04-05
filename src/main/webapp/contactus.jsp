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



<section class="contact-wrapper pt-50 pb-100">
    <div class="container">

        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="contact-style-3 text-center mt-50">
                    <h4 class="heading-4 font-weight-500 title">Get in Touch</h4>
                    <p class="paragraph-small sub-title mt-10">Feel free to drop us a line below!</p>
                    <form action="#">
                        <div class="single-form form-default text-start">
                            <label>Full Name</label>
                            <div class="form-input">
                                <input type="text" placeholder="Full Name">
                                <i class="mdi mdi-account"></i>
                            </div>
                        </div>
                        <div class="single-form form-default text-start">
                            <label>Email Address</label>
                            <div class="form-input">
                                <input type="text" placeholder="Email Address">
                                <i class="mdi mdi-email"></i>
                            </div>
                        </div>
                        <div class="single-form form-default text-start">
                            <label>Message</label>
                            <div class="form-input">
                                <textarea placeholder="Message"></textarea>
                                <i class="mdi mdi-message-text-outline"></i>
                            </div>
                        </div>
                        <div class="single-form">
                            <button class="main-btn primary-btn">send message</button>
                        </div>
                    </form>
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