<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">

    <!--====== Title ======-->
    <title>Login</title>

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--====== Material Design Icons CSS ======-->
    <link rel="stylesheet" href="assets/css/materialdesignicons.min.css">

    <!--====== Bootstrap CSS ======-->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">

    <!--====== Default CSS ======-->
    <link rel="stylesheet" href="assets/css/default.css">

    <!--====== Temp Style CSS ======-->
    <link rel="stylesheet" href="assets/css/tempstyle.css">

    <!--====== Style CSS ======-->
    <!-- <link rel="stylesheet" href="assets/css/style.css"> -->

</head>

<body>

    <section class="login-registration-wrapper pt-50 pb-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 align-self-center">
                    <div class="login-registration-style-2 text-center mt-50">
                        <h1 class="heading-4 font-weight-500 title">Login</h1>
                        <div class="login-registration-form pt-10">
                            <form action="login" method="post">
                                <div class="single-form form-default form-border">
                                     <label>Email Address</label>
                                     <div class="form-input">
                                         <input type="email" name="email" placeholder="user@email.com">
                                         <i class="mdi mdi-email"></i>
                                     </div>
                                 </div>
                                 <div class="single-form form-default form-border">
                                     <label>Password</label>
                                     <div class="form-input">
                                         <input id="password-5" type="password" name="password" placeholder="Password">
                                         <i class="mdi mdi-lock"></i>
                                         <span toggle="#password-5" class="mdi mdi-eye-outline toggle-password"></span>
                                     </div>
                                 </div>
                                 <div class="login-checkbox-forget d-sm-flex justify-content-between align-items-center">
                                     <div class="single-checkbox checkbox-style-3">
                                         <input type="checkbox" name="rememberMe" id="remember-me">
                                         <label for="remember-me"><span></span> </label>
                                         <p>Remember Me</p>
                                     </div>
                                 </div>
                                 <div class="single-form">
                                     <button class="main-btn primary-btn">Signin</button>
                                 </div>
                            </form>
                        </div>
                        <div class="d-sm-flex justify-content-between align-items-center">
                            <p class="login">Don’t have an account? <a href="register.html">Sign up</a></p>
                        </div>
                    </div>
                 </div>

            </div>
        </div>
    </section>


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

</body>

</html>