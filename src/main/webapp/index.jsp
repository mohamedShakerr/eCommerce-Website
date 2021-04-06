<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">

    <!--====== Title ======-->
    <title>Unity Store</title>

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--====== Favicon Icon ======-->
    <link rel="shortcut icon" href="./assets/images/favicon.png" type="image/png">

    <!--====== Tiny Slider CSS ======-->
    <link rel="stylesheet" href="./assets/css/tiny-slider.css">

    <!--====== Line Icons CSS ======-->
    <link rel="stylesheet" href="./assets/css/LineIcons.css">

    <!--====== Material Design Icons CSS ======-->
    <link rel="stylesheet" href="./assets/css/materialdesignicons.min.css">

    <!--====== FONT Awesome Icons CSS ======-->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
          crossorigin="anonymous" />
    <!--====== Bootstrap CSS ======-->
    <link rel="stylesheet" href="./assets/css/bootstrap-5.0.0-beta1.min.css">

    <!--====== gLightBox CSS ======-->
    <link rel="stylesheet" href="./assets/css/glightbox.min.css">

    <!--====== nouiSlider CSS ======-->
    <link rel="stylesheet" href="./assets/css/nouislider.min.css">

    <!--====== Default CSS ======-->
    <link rel="stylesheet" href="./assets/css/default.css">

    <!--====== Temp CSS ======-->
    <link rel="stylesheet" href="./assets/css/tempstyle.css">

    <!-- =======Style CSS ============ -->
    <link rel="stylesheet" href="./assets/css/style.css">

    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>

</head>

<body>



<!--====== Navbar Style 11 Part Start ======-->

<c:set var="cart" value="${requestScope.cartItems}" scope="request"/>
<c:set var="oculus" value="${requestScope.featuredOculus}" scope="request"/>

<!--======================== Navbar  Starts ====================================-->
<c:set var="userId" value="${sessionScope.userId}" scope="session"/>
<jsp:include page="navbar.jsp"/>
<!--======================== Navbar  Ends ====================================-->

<section class="header-style-1 header-style-dark-1 mt-20">
    <div class="header-big position-relative">
        <div class="header-items-active-dark-1">
            <div class="single-header-item bg_cover" style='background-image: url("./assets/images/cyberpunk2077.jpg");'>
                <div class="header-item-content">
                    <h3 class="title">The New Dystopian Future CYBERPUNK 2077, is here make sure to grab it</h3>
                    <a href="shop?cat=2" class="link">check our latest games</a>
                </div>
            </div>
            <div class="single-header-item bg_cover" style='background-image: url("./assets/images/ps5_bg.jpg");'>
                <div class="header-item-content">
                    <h3 class="title">the powerful PS5 is here ,grab it !   </h3>
                    <a href="shop/prod-detail?prodId=15" class="link">Very limited supply </a>
                </div>
            </div>
            <div class="single-header-item bg_cover" style='background-image: url("./assets/images/xbox_bg.png");'>
                <div class="header-item-content">
                    <h3 class="title">XBOX Series X</h3>
                    <a href="shop/prod-detail?prodId=16" class="link">Check it out NOW!</a>
                </div>
            </div>
        </div>
    </div>
    <div class="header-min">
        <div class="header-min-item product-style-25 bg_cover" style='background-image: url("./assets/images/ps5_c_bg.jpg");'>
            <div class="product-content">
                <h4 class="title"><a href="shop/prod-detail?prodId=17">PS5 Joystick</a></h4>
                <p>Powerful PS5 joystick </p>
                <a href="shop/prod-detail?prodId=17" class="main-btn secondary-2-btn"> <img src="./assets/images/icon-svg/cart-7.svg" alt="">Buy Now</a>
            </div>
        </div>
        <div class="header-min-item product-style-25 bg_cover" style='background-image: url("./assets/images/xbox_1.jpg");'>
            <div class="product-content">
                <h4 class="title"><a href="shop/prod-detail?prodId=18">XBOX Joystick</a></h4>
                <p>Slick XBOX Joystick</p>
                <a href="shop/prod-detail?prodId=18" class="main-btn secondary-2-btn"> <img src="./assets/images/icon-svg/cart-7.svg" alt="">Buy Now</a>
            </div>
        </div>
    </div>
</section>



<!--====== Content Card Style 6 Part Start ======-->
<section class="content-card-style-6 pt-95 pb-100">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <div class="content-card-title text-center pb-30">
                    <h6 class="sub-title">ACCESSORIES & PARTS</h6>
                    <h2 class="main-title">Everything you <br> need to Go</h2>
                </div>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-4 col-sm-9">
                <div class="single-content-card text-center mt-30">
                    <div class="content-card-image">
                        <img src="assets/images/content-card-4/caontent-1.jpg" alt="">
                    </div>
                    <div class="content-card-content">
                        <h4 class="title"><a href="shop/prod-detail?prodId=22">Replacement Controller</a></h4>
                        <p>A replacement for the Oculus Go controller. Only one controller can be synced.</p>
                        <a href="shop/prod-detail?prodId=22" class="main-btn primary-btn"><img src="assets/images/icon-svg/cart-4.svg"
                                                                       alt=""> BUY</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-9">
                <div class="single-content-card text-center mt-30">
                    <div class="content-card-image">
                        <img src="assets/images/content-card-4/caontent-2.jpg" alt="">
                    </div>
                    <div class="content-card-content">
                        <h4 class="title"><a href="shop/prod-detail?prodId=23">Fitted Interface</a></h4>
                        <p>A replacement for the Oculus Go controller. Only one controller can be synced.</p>
                        <a href="shop/prod-detail?prodId=23" class="main-btn primary-btn"><img src="assets/images/icon-svg/cart-4.svg"
                                                                       alt=""> BUY</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-9">
                <div class="single-content-card text-center mt-30">
                    <div class="content-card-image">
                        <img src="assets/images/content-card-4/caontent-3.jpg" alt="">
                    </div>
                    <div class="content-card-content">
                        <h4 class="title"><a href="shop/prod-detail?prodId=24">Oculus Go Case</a></h4>
                        <p>A replacement for the Oculus Go controller. Only one controller can be synced.</p>
                        <a href="shop/prod-detail?prodId=24" class="main-btn primary-btn"><img src="assets/images/icon-svg/cart-4.svg"
                                                                       alt=""> BUY</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--====== Content Card Style 6 Part Ends ======-->
<!--====== Content Card Style 1 Part Start ======-->
<section class="content-card-wrapper">
    <div class="content-card-style-1">
        <div class="container">
            <div class="row justify-content-end">
                <div class="col-md-6">
                    <div class="content-card-content">
                        <h6 class="sub-title">ALL-IN-ONE VR</h6>
                        <h2 class="main-title">Always ready when you are</h2>
                        <p>Oculus Go is our all-in-one VR headset that’s portable and easy to use. Experience
                            entertainment on the go with no PC, wires or hassles.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="content-card-image-2 bg_cover"
             style="background-image: url(assets/images/content-card-1/content-2.jpg);"></div>
    </div>
</section>
<!--====== Content Card Style 1 Part Ends ======-->
<!--====== Content Card Style 4 Part Start ======-->
<section class="content-card-style-4 bg-white pt-70 pb-100">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-4 col-md-7 col-sm-8">
                <div class="single-content mt-15 text-center">
                    <div class="content-icon">
                        <i class="mdi mdi-truck-fast"></i>
                    </div>
                    <div class="content-content">
                        <h4 class="title"><a href="aboutus">Two-hour delivery</a></h4>
                        <p>Available in most metros on selected in-stock products</p>
                        <a href="aboutus" class="more">learn more</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-7 col-sm-8">
                <div class="single-content mt-15 text-center">
                    <div class="content-icon">
                        <i class="mdi mdi-message-text"></i>
                    </div>
                    <div class="content-content">
                        <h4 class="title"><a href="contactus">Get help buying</a></h4>
                        <p>Have a question? Call a Specialist or chat online for help</p>
                        <a href="contactus" class="more">Contact us</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-7 col-sm-8">
                <div class="single-content mt-15 text-center">
                    <div class="content-icon">
                        <i class="mdi mdi-ticket-percent"></i>
                    </div>
                    <div class="content-content">
                        <h4 class="title"><a href="aboutus">Find the card for you</a></h4>
                        <p>Get 3% Daily Cash with special financing offers from us</p>
                        <a href="aboutus" class="more">learn more</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--====== Content Card Style 4 Part Ends ======-->
<!--====== Product Style 7 Part Start ======-->
<section class="product-wrapper pb-100">
    <div class="container">
        <h3 class="main-title text-center">FEATURED PRODUCTS</h3>
        <div class="row">
            <c:forEach var="myProd" items="${requestScope.featuredProducts}">
                <div class="col-lg-6" id="${myProd.productId}">
                    <div class="product-style-7 mt-30">
                        <div class="product-image">
                            <div class="product-active">
                                <div class="product-item active bg_cover" >
<%--                                    <div style='background-image: url("${myProd.imageUrl}");width: 100%;'></div>--%>
                                    <img src="${myProd.imageUrl}" alt="product">
                                </div>
                            </div>
                        </div>
                        <div class="product-content">
                            <ul class="product-meta">
                                <li>
                                    <a class="add-wishlist" href="#0">
                                        <i class="mdi mdi-heart-outline"></i>
                                        Add to Favourite
                                    </a>
                                </li>
                                <li>
                                    <span><i class="mdi mdi-star"></i> 4.5/5</span>
                                </li>
                            </ul>
                            <h4 class="title"><a href="shop/prod-detail?prodId=${myProd.productId}">${myProd.productName}</a></h4>
<%--                            <p>In Stock : ${myProd.quantity}</p>--%>
                            <span class="price">$ ${myProd.productPrice}</span>
                            <a href="shop/prod-detail?prodId=${myProd.productId}" class="main-btn primary-btn"> <img src="assets/images/icon-svg/cart-4.svg"
                                                                            alt="">
                                Buy</a>
                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>
    </div>
</section>
<!--====== Product Style 7 Part Ends ======-->
<!--======  Product Details Style 6 Part Start ======-->
<section class="product-details-wrapper mt-30 pb-100">
    <div class="product-details-bg bg_cover" style="background-image: url(assets/images/product-details-bg.jpg);">
    </div>
    <div class="container">
        <div class="product-details-style-6">
            <div class="product-details-image">
                <div class="product-image">
                    <div class="product-image-active tab-content" id="v-pills-tabContent-6">
                        <div class="single-image tab-pane fade show active" id="v-pills-26" role="tabpanel"
                             aria-labelledby="v-pills-26-tab">
                            <img src="assets/images/product-details-1/product-1.jpg" alt="">
                        </div>
                        <div class="single-image tab-pane fade" id="v-pills-27" role="tabpanel"
                             aria-labelledby="v-pills-27-tab">
                            <img src="assets/images/product-details-1/product-2.jpg" alt="">
                        </div>
                        <div class="single-image tab-pane fade" id="v-pills-28" role="tabpanel"
                             aria-labelledby="v-pills-28-tab">
                            <img src="assets/images/product-details-1/product-3.jpg" alt="">
                        </div>
                        <div class="single-image tab-pane fade" id="v-pills-29" role="tabpanel"
                             aria-labelledby="v-pills-29-tab">
                            <img src="assets/images/product-details-1/product-4.jpg" alt="">
                        </div>
                        <div class="single-image tab-pane fade" id="v-pills-30" role="tabpanel"
                             aria-labelledby="v-pills-30-tab">
                            <img src="assets/images/product-details-1/product-5.jpg" alt="">
                        </div>
                    </div>
                </div>
                <div class="product-thumb-image">
                    <div class="product-thumb-image-active nav nav-pills" id="v-pills-tab-6" role="tablist"
                         aria-orientation="vertical">
                        <div class="single-thumb active" id="v-pills-26-tab" data-bs-toggle="pill"
                             href="#v-pills-26" role="tab" aria-controls="v-pills-26" aria-selected="true">
                            <img src="assets/images/product-details-1/thunb-1.jpg" alt="">
                        </div>
                        <div class="single-thumb" id="v-pills-27-tab" data-bs-toggle="pill" href="#v-pills-27"
                             role="tab" aria-controls="v-pills-27" aria-selected="false">
                            <img src="assets/images/product-details-1/thunb-2.jpg" alt="">
                        </div>
                        <div class="single-thumb" id="v-pills-28-tab" data-bs-toggle="pill" href="#v-pills-28"
                             role="tab" aria-controls="v-pills-28" aria-selected="false">
                            <img src="assets/images/product-details-1/thunb-3.jpg" alt="">
                        </div>
                        <div class="single-thumb" id="v-pills-29-tab" data-bs-toggle="pill" href="#v-pills-29"
                             role="tab" aria-controls="v-pills-29" aria-selected="false">
                            <img src="assets/images/product-details-1/thunb-4.jpg" alt="">
                        </div>
                        <div class="single-thumb" id="v-pills-30-tab" data-bs-toggle="pill" href="#v-pills-30"
                             role="tab" aria-controls="v-pills-30" aria-selected="false">
                            <img src="assets/images/product-details-1/thunb-5.jpg" alt="">
                        </div>
                    </div>
                </div>
            </div>

            <div class="product-details-content mt-25">
<%--                <p class="sub-title">All-In-One VR</p>--%>
                <h2 class="title">${oculus.prodName}</h2>

                <div class="row">
                    <div class="col-lg-6">


                        <div class="product-select-wrapper mt-10 flex-wrap">
                            is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting,
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="product-price-btn text-lg-right">
                            <div class="product-price">
                                <h6 class="price-title">Price: </h6>
                                <p class="sale-price">$ ${oculus.price} USD</p>
                                <p class="regular-price">$ 179 USD</p>
                            </div>

                            <div class="product-btn">
                                <a href="shop/prod-detail?prodId=${oculus.id}" class="main-btn secondary-1-btn"><img
                                        src="assets/images/icon-svg/cart-8.svg" alt=""> Buy Now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--======  Product Details Style 6 Part Ends ======-->
<!--====== Product Style 14 Part Start ======-->

<!--
<section class="product-wrapper pt-70">
    <div class="container">
        <div class="row">

            <c:forEach var="accessory" items="${requestScope.featuredAccessories}">
                <div class="col-lg-4 col col-md-6" id="${accessory.productId}">
                    <div class="product-style-14 mt-30">
                        <div class="product-image">
                            <img src="${accessory.imageUrl}" alt="product">
                        </div>
                        <div class="product-content">
                            <h4 class="title"><a href="shop/prod-detail?prodId=${accessory.productId}">${accessory.productName}</a></h4>
                            <a href="shop/prod-detail?prodId=${accessory.productId}" class="main-btn secondary-1-btn"> <img src="assets/images/icon-svg/cart-7.svg"
                                                                                                                            alt=""> $ ${accessory.productPrice}</a>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</section>
-->

<!--====== Product Style 14 Part Ends ======-->

<!--====== Footer Style 5 Part Start ======-->
<jsp:include page="footer.jsp"/>
<!--====== Footer Style 5 Part Ends ======-->
<!--=========================================Scripts=====================================-->

<!--====== Bootstrap js ======-->
<script src="./assets/js/bootstrap.bundle-5.0.0-beta1.min.js"></script>
<!--====== Tiny Slider js ======-->
<script src="./assets/js/tiny-slider.js"></script>
<!--====== nouiSlider js ======-->
<script src="./assets/js/nouislider.min.js"></script>
<!--====== count up js ======-->
<script src="./assets/js/count-up.min.js"></script>
<!--====== gLightBox js ======-->
<script src="./assets/js/glightbox.min.js"></script>
<!--====== Main js ======-->
<script src="./assets/js/main.js"></script>

<%--=======CART SCRIPT======--%>
<script src="./assets/js/cart.js"></script>

<script>
    tns({
        autoplay: true,
        autoplayButtonOutput: false,
        mouseDrag: true,
        gutter: 0,
        container: ".header-items-active-dark-1",
        center: true,
        nav: true,
        controls: false,
        speed: 400,
        controlsText: [
            '<i class="lni lni-arrow-left-circle"></i>',
            '<i class="lni lni-arrow-right-circle"></i>',
        ],
        responsive: {
            0: {
                items: 1,
            },
        }
    });

</script>

</body>

</html>