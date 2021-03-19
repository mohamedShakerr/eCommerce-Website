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

    <!--====== Bootstrap CSS ======-->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">

    <!--====== gLightBox CSS ======-->
    <link rel="stylesheet" href="assets/css/glightbox.min.css">

    <!--====== nouiSlider CSS ======-->
    <link rel="stylesheet" href="assets/css/nouislider.min.css">

    <!--====== Default CSS ======-->
    <link rel="stylesheet" href="assets/css/default.css">

    <!--====== Style CSS ======-->
    <link rel="stylesheet" href="assets/css/style.css">

</head>

<body>

    <!--====== Header ======-->


    <!--====== Header======-->

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
                                <a class="profile-link" href="#0">Add Cards</a>
                            </div>
                            <div class="profile-card-info">
                                <div class="row">
                                    <div class="col-md-4 col-sm-6">
                                        <div class="single-card-info d-flex">
                                            <div class="card-icon">
                                                <img src="assets/images/visa.png" alt="Card">
                                            </div>
                                            <div class="card-info media-body">
                                                <h5 class="card-name">Musa Ahmed</h5>
                                                <p class="card-number">.... 4534 <span>02/20</span></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-6">
                                        <div class="single-card-info d-flex">
                                            <div class="card-icon">
                                                <img src="assets/images/american-express.png" alt="Card">
                                            </div>
                                            <div class="card-info media-body">
                                                <h5 class="card-name">Musa Ahmed</h5>
                                                <p class="card-number">.... 4534 <span>02/20</span></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-6">
                                        <div class="single-card-info d-flex">
                                            <div class="card-icon">
                                                <img src="assets/images/mastercard.png" alt="Card">
                                            </div>
                                            <div class="card-info media-body">
                                                <h5 class="card-name">Musa Ahmed</h5>
                                                <p class="card-number">.... 4534 <span>02/20</span></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!--====== Profile Ends ======-->

   <!--====== Footer ======-->


    <!--====== Footer======-->

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

    <!--====== Main js ======-->
    <script src="assets/js/main.js"></script>

</body>

</html>