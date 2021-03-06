<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">

    <!--====== Title ======-->
    <title>Game On</title>

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon1.png">

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

    <!--====== Style CSS ======-->
    <link rel="stylesheet" href="assets/css/style.css">

    <!--====== font-awesome Style CSS ======-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>

<body>



<c:set var="userId" value="${sessionScope.userId}" scope="session"/>
<jsp:include page="navbar.jsp"/>


<section class="login-registration-wrapper pt-50 pb-100">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6 align-self-center">
                <div class="login-registration-style-3 registration text-center mt-50">
                    <h3 style="color: #542DED;">
                        <i class="fab fa-playstation"></i>
                        <i class="fas fa-gamepad"></i>
                    </h3>
                    <h1 class="heading-4 font-weight-500 title" style="color: #542DED;">Create an Account</h1>
                    <div class="login-registration-form pt-10">
                        <form action="register" method="post">
                            <div class="single-form form-default form-border text-left">
                                <b class="inputsLabel">Name</b>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="form-input">
                                            <input type="text" id="userName" name="userName" placeholder="Name"
                                                   required
                                                   onblur="validateUserName(userName)">
                                            <i class="mdi mdi-account" style="color: #542DED;"></i>
                                        </div>
                                        <span id="nameError" class="err"
                                              style="display: none;">name already existed</span>
                                        <span id="nameSuccess" class="suc"
                                              style=" display: none;">Valid user name</span>
                                        <span id="nameInvalid" class="err" style=" display: none;">Invalid user name format</span>

                                    </div>
                                </div>
                            </div>
                            <div class="single-form form-default form-border text-left">
                                <b class="inputsLabel" >Email</b>
                                <div class="form-input">
                                    <input type="email" id="email" name="email" placeholder="user@email.com" required
                                           onblur="validateEmail(email)">

                                    <i class="mdi mdi-email" style="color: #542DED;"></i>
                                </div>
                                <span id="emailError" class="err" style="display: none;">E-mail already existed</span>
                                <span id="emailSuccess" class="suc" style=" display: none;">Valid email</span>
                                <span id="emailInvalid" class="err" style=" display: none;">Invalid E-mail format</span>
                            </div>

                            <div class="single-form form-default form-border text-left">
                                <b class="inputsLabel">Password</b>
                                <div class="form-input">
                                    <input id="password-3" name="password" type="password" placeholder="Password"
                                           required minlength="8" maxlength="20">
                                    <i class="mdi mdi-lock" style="color: #542DED;"></i>
<!--                                    <span toggle="#password-3" class="mdi mdi-eye-outline toggle-password"></span>-->
                                </div>
                            </div>

                            <div class="single-form form-default form-border text-left">
                                <b class="inputsLabel">Address</b>
                                <div class="form-input">
                                    <input type="text" minlength="3" maxlength="30" name="address"
                                           placeholder="Cairo, Egypt" required>
                                    <i class="mdi mdi-map-marker" style="color: #542DED;"></i>
                                </div>
                            </div>
                            <div class="single-form form-default form-border text-left">
                                <b class="inputsLabel">Phone</b>
                                <div class="form-input">
                                    <input type="tel" minlength="8" name="phone" placeholder="+20xxxxxxxxxx" required>
                                    <i class="mdi mdi-phone" style="color: #542DED;"></i>
                                </div>
                            </div>

                            <div class="single-form form-default form-border text-left">
                                <b class="inputsLabel" style="padding-right: 10%">Job</b>
                                <div class="form-input">
                                    <input type="text" minlength="5" name="job" placeholder="Engineer">
                                    <i class="mdi mdi-briefcase" style="color: #542DED;"></i>
                                </div>
                            </div>

                            <div class="single-form form-default form-border text-left">
                                <b class="inputsLabel">Interests</b>
                                <div class="form-input">
                                    <input type="text" name="interests" placeholder="controllers">
                                    <i class="mdi mdi-thought-bubble mdi" style="color: #542DED;"></i>
                                </div>
                            </div>


<!--                            &lt;!&ndash;todo handle this checkbox &ndash;&gt;-->
<!--                            <div class="single-checkbox checkbox-style-3">-->
<!--                                <input type="checkbox" name="terms" id="login-3" required>-->
<!--                                <label for="login-3"><span></span> </label>-->
<!--                                <p>I accept the Terms of Use.</p>-->
<!--                            </div>-->

                            <div class="single-form">
                                <button class="main-btn primary-btn">Sign up</button>
                            </div>
                        </form>
                    </div>
                    <div class="d-sm-flex justify-content-between align-items-center">
                        <p class="login" >Already have an account? <a href="login.jsp">Sign in</a></p>
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

<!--====== Ajax validation ======-->

<script>


    function validateUserName(username) {

        $.get("validateRegister?type=name&name=" + $("#userName").val(), function (nameExists) {

            if (nameExists == "true") {

                document.getElementById("nameSuccess").style.display = 'none';
                document.getElementById("nameInvalid").style.display = 'none';
                document.getElementById("nameError").style.display = 'block';
                console.log("name invalid");
                return true;

            } else {

                var userNameFormat = /^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$/;
                if (!userNameFormat.test($("#userName").val())) {

                    document.getElementById("nameSuccess").style.display = 'none';
                    document.getElementById("nameInvalid").style.display = 'block';
                    document.getElementById("nameError").style.display = 'none';

                    return true;
                }

                document.getElementById("nameSuccess").style.display = 'block';
                document.getElementById("nameInvalid").style.display = 'none';
                document.getElementById("nameError").style.display = 'none';
                console.log("email invalid");
                return true;

            }

        });

    }


    function validateEmail(field) {

        $.get("validateRegister?type=email&email=" + $("#email").val(), function (emailExists) {

            if (emailExists == "true") {

                document.getElementById("emailSuccess").style.display = 'none';
                document.getElementById("emailInvalid").style.display = 'none';
                document.getElementById("emailError").style.display = 'block';
                console.log("email invalid");
                return true;

            } else {

                var mailformat = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!mailformat.test($("#email").val())) {
                    tmp = $("#email").val();
                    console.log(tmp);
                    document.getElementById("emailSuccess").style.display = 'none';
                    document.getElementById("emailError").style.display = 'none';
                    document.getElementById("emailInvalid").style.display = 'block';
                    return true;

                }

                document.getElementById("emailSuccess").style.display = 'block';
                document.getElementById("emailError").style.display = 'none';
                document.getElementById("emailInvalid").style.display = 'none';

                console.log("email invalid");
                return true;

            }
        });
    }

    document.getElementById("login-3").required = true;

</script>

</body>

</html>