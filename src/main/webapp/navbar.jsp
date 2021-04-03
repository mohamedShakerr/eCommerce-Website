<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--======================== Navbar  Starts ====================================-->
<c:set var="cart" value="${requestScope.cartItems}" scope="request"/>
<c:set var="userId" value="${sessionScope.userId}" scope="request"/>


<c:out value="sdsd"/>
<c:out value="${userId};"/>
<c:out value="${sessionScope.userId};"/>
<c:out value="${requestScope.userId};"/>


<section class="navigation sticky-top">

    <!--====== Navbar Style 11 Part Start ======-->

    <header class="menu-style-11 position-relative" style="background-color: #fafafa">

        <!-- main navbar Start -->
        <nav class="nav-navbar">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 col-3">
                        <!-- navbar cart start -->
                        <div class="navbar-toggle icon-text-btn d-lg-none">
                            <a class="icon-btn primary-icon-text mobile-menu-open-11" href="javascript:void(0)"><i
                                    class="mdi mdi-menu"></i></a>
                        </div>
                        <!-- navbar cart Ends -->

                        <div class="navbar-container navbar-sidebar-11">
                            <!-- navbar close  Ends -->
                            <div class="navbar-close d-lg-none">
                                <a class="close-mobile-menu-11" href="javascript:void(0)"><i
                                        class="mdi mdi-close"></i></a>
                            </div>
                            <!-- navbar close  Ends -->

                            <!-- navbar wrapper Start -->
                            <div class="navbar-wrapper d-lg-flex flex-wrap">
                                <!-- navbar Menu start -->
                                <nav class="main-navbar">
                                    <div class="navbar-menu">

                                        <div class="navbar-menu-toggle d-none d-lg-block">
                                            <button id="toggle-menu-11" class="menu-toggle collapsed"
                                                    data-bs-toggle="collapse" data-bs-target="#menuVertical11-1"
                                                    aria-controls="menuVertical11-1" aria-expanded="false"
                                                    aria-label="Toggle navigation">
                                                <span class="toggle-icon"></span>
                                                <span class="toggle-icon"></span>
                                                <span class="toggle-icon"></span>
                                            </button>
                                        </div>

                                        <ul class="main-menu menu-vertical-11 collapse" id="menuVertical11-1">
                                            <li class="menu-item-has-children">
                                                <a href="#0" class="collapsed" data-bs-toggle="collapse"
                                                   data-bs-target="#menuVertical11-2"
                                                   aria-controls="menuVertical11-2" aria-expanded="false"
                                                   aria-label="Toggle navigation">Arts & Crafts <i
                                                        class="mdi mdi-chevron-right"></i></a>

                                                <!-- sub mega dropdown Start -->
                                                <ul class="sub-mega-dropdown collapse" id="menuVertical11-2">
                                                    <li>
                                                        <div class="mega-dropdown-menu">
                                                            <ul class="container mega-dropdown d-flex flex-wrap">
                                                                <li
                                                                        class="mega-dropdown-list menu-item-has-children">
                                                                    <h6 class="heading-6 font-weight-500 mega-title collapsed"
                                                                        data-bs-toggle="collapse"
                                                                        data-bs-target="#menuVertical11-3"
                                                                        aria-controls="menuVertical11-3"
                                                                        aria-expanded="false"
                                                                        aria-label="Toggle navigation">
                                                                        New Arrivals
                                                                        <i class="mdi mdi-chevron-right"></i>
                                                                    </h6>
                                                                    <ul class="collapse" id="menuVertical11-3">
                                                                        <li><a href="#0">Dressess</a></li>
                                                                        <li><a href="#0">Jackets</a></li>
                                                                        <li><a href="#0">Hoodies & Sweatshirts</a>
                                                                        </li>
                                                                        <li><a href="#0">Sweaters</a></li>
                                                                        <li><a href="#0">Tops & Tees</a></li>
                                                                        <li><a href="#0">Party Dressess</a></li>
                                                                    </ul>
                                                                </li>
                                                                <li
                                                                        class="mega-dropdown-list menu-item-has-children">
                                                                    <h6 class="heading-6 font-weight-500 mega-title collapsed"
                                                                        data-bs-toggle="collapse"
                                                                        data-bs-target="#menuVertical11-4"
                                                                        aria-controls="menuVertical11-4"
                                                                        aria-expanded="false"
                                                                        aria-label="Toggle navigation">
                                                                        Trending
                                                                        <i class="mdi mdi-chevron-right"></i>
                                                                    </h6>
                                                                    <ul class="collapse" id="menuVertical11-4">
                                                                        <li><a href="#0">Dressess</a></li>
                                                                        <li><a href="#0">Jackets</a></li>
                                                                        <li><a href="#0">Hoodies & Sweatshirts</a>
                                                                        </li>
                                                                        <li><a href="#0">Sweaters</a></li>
                                                                        <li><a href="#0">Tops & Tees</a></li>
                                                                        <li><a href="#0">Party Dressess</a></li>
                                                                    </ul>
                                                                </li>
                                                                <li class="mega-dropdown-list">
                                                                    <div class="d-md-flex d-lg-block">
                                                                        <div class="menu-image">
                                                                            <img src="assets/images/menu-1.jpg"
                                                                                 alt="">
                                                                        </div>
                                                                        <div class="menu-image">
                                                                            <img src="assets/images/menu-2.jpg"
                                                                                 alt="">
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>
                                                </ul>
                                                <!-- sub mega dropdown Ends -->
                                            </li>
                                            <li class="menu-item-has-children">
                                                <a href="#0" class="collapsed" data-bs-toggle="collapse"
                                                   data-bs-target="#menuVertical11-5"
                                                   aria-controls="menuVertical11-5" aria-expanded="false"
                                                   aria-label="Toggle navigation">Fashion <i
                                                        class="mdi mdi-chevron-right"></i></a>

                                                <!-- sub mega dropdown Start -->
                                                <ul class="sub-mega-dropdown collapse" id="menuVertical11-5">
                                                    <li>
                                                        <div class="mega-dropdown-menu">
                                                            <ul class="container mega-dropdown d-flex flex-wrap">
                                                                <li
                                                                        class="mega-dropdown-list menu-item-has-children">
                                                                    <h6 class="heading-6 font-weight-500 mega-title collapsed"
                                                                        data-bs-toggle="collapse"
                                                                        data-bs-target="#menuVertical11-6"
                                                                        aria-controls="menuVertical11-6"
                                                                        aria-expanded="false"
                                                                        aria-label="Toggle navigation">
                                                                        New Arrivals
                                                                        <i class="mdi mdi-chevron-right"></i>
                                                                    </h6>
                                                                    <ul class="collapse" id="menuVertical11-6">
                                                                        <li><a href="#0">Dressess</a></li>
                                                                        <li><a href="#0">Jackets</a></li>
                                                                        <li><a href="#0">Hoodies & Sweatshirts</a>
                                                                        </li>
                                                                        <li><a href="#0">Sweaters</a></li>
                                                                        <li><a href="#0">Tops & Tees</a></li>
                                                                        <li><a href="#0">Party Dressess</a></li>
                                                                    </ul>
                                                                </li>
                                                                <li
                                                                        class="mega-dropdown-list menu-item-has-children">
                                                                    <h6 class="heading-6 font-weight-500 mega-title collapsed"
                                                                        data-bs-toggle="collapse"
                                                                        data-bs-target="#menuVertical11-7"
                                                                        aria-controls="menuVertical11-7"
                                                                        aria-expanded="false"
                                                                        aria-label="Toggle navigation">
                                                                        Trending
                                                                        <i class="mdi mdi-chevron-right"></i>
                                                                    </h6>
                                                                    <ul class="collapse" id="menuVertical11-7">
                                                                        <li><a href="#0">Dressess</a></li>
                                                                        <li><a href="#0">Jackets</a></li>
                                                                        <li><a href="#0">Hoodies & Sweatshirts</a>
                                                                        </li>
                                                                        <li><a href="#0">Sweaters</a></li>
                                                                        <li><a href="#0">Tops & Tees</a></li>
                                                                        <li><a href="#0">Party Dressess</a></li>
                                                                    </ul>
                                                                </li>
                                                                <li class="mega-dropdown-list">
                                                                    <div class="d-md-flex d-lg-block">
                                                                        <div class="menu-image">
                                                                            <img src="assets/images/menu-1.jpg"
                                                                                 alt="">
                                                                        </div>
                                                                        <div class="menu-image">
                                                                            <img src="assets/images/menu-2.jpg"
                                                                                 alt="">
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>
                                                </ul>
                                                <!-- sub mega dropdown Ends -->
                                            </li>
                                            <li><a href="#0">Health & Household <i
                                                    class="mdi mdi-chevron-right"></i></a></li>
                                            <li><a href="#0">Bages & Shoes <i class="mdi mdi-chevron-right"></i></a>
                                            </li>
                                            <li><a href="#0">Jewelry & Watchs <i
                                                    class="mdi mdi-chevron-right"></i></a></li>
                                            <li><a href="#0">Beauty & Health <i
                                                    class="mdi mdi-chevron-right"></i></a></li>
                                            <li><a href="#0">Electronics <i class="mdi mdi-chevron-right"></i></a>
                                            </li>
                                            <li><a href="#0">Home & Garden <i class="mdi mdi-chevron-right"></i></a>
                                            </li>

                                            <!-- BACK END STUFF HERE -->
                                            <!-- Check if User is logged In Or Not -->

                                            <c:choose>

                                                <c:when test="${userId != null}">
                                                    <!-- TODO REMOVE DEBUGGIMG -->
                                                    <script> console.log("user Logged In") </script>
                                                    <li><a href="${pageContext.request.contextPath}/profile" id="BurgerMenuLoginRegBtns"> Profile  <i class="mdi mdi-card-account-details"></i></a></li>
                                                    <li><a href="${pageContext.request.contextPath}/logout" id="BurgerMenuLoginRegBtns">Logout  <i class="mdi mdi-logout-variant"></i></a></li>
                                                </c:when>

                                                <c:when test="${userId == null}">
                                                    <!-- TODO REMOVE DEBUGGIMG -->
                                                    <script> console.log("user NOT Logged In") </script>
                                                    <li><a href="${pageContext.request.contextPath}/login" id="BurgerMenuLoginRegBtns"> Login <i class="mdi mdi-login-variant"></i></a></li>
                                                    <li><a href="${pageContext.request.contextPath}/register" id="BurgerMenuLoginRegBtns">Register <i class="mdi mdi-account-multiple-plus"></i></a></li>

                                                </c:when>

                                            </c:choose>

                                        </ul>
                                    </div>
                                </nav>
                                <!-- navbar Menu Ends -->
                            </div>
                            <!-- navbar wrapper Ends -->
                        </div>
                    </div>
                    <div class="col-lg-4 col-6">
                        <!-- desktop logo Start -->
                        <div class="desktop-logo text-center">
                            <a href="${pageContext.request.contextPath}" type="button">
<%--                                <img src="assets/images/logo.svg" alt="Logo">--%>
                                <span class="shop-logo">
                                    <h3 style="color: #4726CA">
                                        <i class="fab fa-playstation"></i>
                                        <i class="fas fa-gamepad"></i>
                                    </h3>
                                </span>
                                <span class="shop-logo-text" >
                                    <h4 style="color: #4726CA">Unity</h4>
                                </span>
                            </a>
                        </div>
                        <!-- desktop logo Ends -->
                    </div>
                    <div class="col-lg-4 col-3">

                        <!-- navbar Meta start -->
                        <div class="navbar-meta ">
                            <ul class="meta">
                                <!-- BACK END STUFF HERE -->
                                <c:choose>

                                    <c:when test="${userId != null}">

                                        <li id="userMenu" >
                                            <!--Will Apper only if the useer is LOGGED IN-->
                                            <div class="navbar-user dropdown">

                                                <a class="icon-btn primary-icon-text icon-text-btn" href="#dropdown11"
                                                   role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
                                                        class="mdi mdi-account"></i></a>
                                                <ul class="dropdown-menu" id="dropdown11">
                                                    <li><a href="${pageContext.request.contextPath}/profile"><i class="mdi mdi-account"></i> My Profile</a></li>
                                                    <li><a href="${pageContext.request.contextPath}/logout"><i class="mdi mdi-import"></i> Logout</a></li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li id="user-cart">
                                            <div class="navbar-cart">
                                                <a class="icon-btn primary-icon-text icon-text-btn" href="#0"><img
                                                        src="https://ecommerece-iti.s3.eu-central-1.amazonaws.com/d385ecd9-7979-4087-8eac-e57805691dec" alt="Icon" style="padding-top: 10px;"><span id="cart-count"
                                                                                                                                            class="icon-text text-style-1">--</span></a>

                                                <div class="navbar-cart-dropdown">
                                                    <div class="checkout-style-2">
                                                        <div class="checkout-header d-flex justify-content-between">
                                                            <h6 class="title">Shopping Cart </h6>
                                                        </div>

                                                        <div class="checkout-table table-responsive">
                                                            <table class="table">
                                                                <tbody id="cart-items-table">
                                                                <c:forEach var="item" items="${cart}">
                                                                    <tr id="table-row-${item.productId}">
                                                                        <td class="checkout-product">
                                                                            <div class="product-cart d-flex">
                                                                                <div class="product-thumb">
                                                                                    <img src="${item.productImage}"
                                                                                         alt="Product">
                                                                                </div>
                                                                                <div class="product-content media-body">
                                                                                    <h5 class="title"><a href="shop/prod-detail?prodId=${item.productId}">
                                                                                            ${item.productName}
                                                                                    </a></h5>
                                                                                    <ul>
                                                                                        <li><span id="item-qty-${item.productId}">${item.productQty}</span>
                                                                                            <span>X$</span>
                                                                                            <span id="item-price">${item.productPrice}</span>
                                                                                        </li>
                                                                                        <li><a class="delete" onclick="deleteProduct(${item.productId})"><i
                                                                                                class="mdi mdi-delete"></i></a>
                                                                                        </li>
                                                                                    </ul>
                                                                                </div>
                                                                            </div>
                                                                        </td>
                                                                        <td class="checkout-quantity">
                                                                            <div class="product-quantity d-inline-flex">
                                                                                <button type="button" id="sub"
                                                                                        class="sub" onclick="decProdQty(${item.productId},${item.productPrice})"><i
                                                                                        class="mdi mdi-minus"></i></button>
                                                                                <input id="item-${item.productId}-qty-input" type="text" value="${item.productQty}" disabled>
                                                                                <button type="button" id="add"
                                                                                        class="add" onclick="incProdQty(${item.productId},${item.productPrice})">
                                                                                    <i
                                                                                            class="mdi mdi-plus"></i>
                                                                                </button>
                                                                            </div>
                                                                        </td>
                                                                        <td class="checkout-price">
                                                                            <p id="total-item-price-${item.productId}" class="price">${item.productPrice * item.productQty }</p>
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                        <div class="checkout-footer">
                                                            <div class="checkout-sub-total d-flex justify-content-between">
                                                                <p class="value">Subotal Price:</p>
                                                                <p class="price" id="cart-total-price">$144</p>
                                                            </div>
                                                            <div class="checkout-btn">
                                                                <a href="#0" class="main-btn primary-btn-border">View
                                                                    Cart</a>
                                                                <a href="#0" class="main-btn primary-btn">To Checkout</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>

                                    </c:when>

                                    <c:when test="${userId == null}">

                                        <li id="userSignInRegister">
                                            <a class="icon-btn primary-icon-text icon-text-btn customMenuBtn" href="${pageContext.request.contextPath}/login" role="button">
                                                <class class="mdi mdi-login-variant"></class>Login
                                            </a>

                                            <a class="icon-btn primary-icon-text icon-text-btn customMenuBtn" href="${pageContext.request.contextPath}/register" role="button">
                                                <class class="mdi mdi-account-multiple-plus"></class>Register
                                            </a>

                                        </li>

                                    </c:when>

                                </c:choose>

                            </ul>
                        </div>
                        <!-- navbar Meta Ends -->
                    </div>
                </div>
            </div>
        </nav>
        <!-- main navbar Ends -->
        <div class="overlay-11"></div>
    </header>
    <!--====== Navbar Style 11 Part Ends ======-->
</section>
<!--======================== Navbar  Ends ====================================-->

<%--

<section class="navigation">
    <!--====== Navbar Style 11 Part Start ======-->

    <header class="menu-style-11 position-relative">

        <!-- main navbar Start -->
        <nav class="nav-navbar">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 col-3">
                        <!-- navbar cart start -->
                        <div class="navbar-toggle icon-text-btn d-lg-none">
                            <a class="icon-btn primary-icon-text mobile-menu-open-11" href="javascript:void(0)"><i
                                    class="mdi mdi-menu"></i></a>
                        </div>
                        <!-- navbar cart Ends -->

                        <div class="navbar-container navbar-sidebar-11">
                            <!-- navbar close  Ends -->
                            <div class="navbar-close d-lg-none">
                                <a class="close-mobile-menu-11" href="javascript:void(0)"><i
                                        class="mdi mdi-close"></i></a>
                            </div>
                            <!-- navbar close  Ends -->

                            <!-- navbar wrapper Start -->
                            <div class="navbar-wrapper d-lg-flex flex-wrap">
                                <!-- navbar Menu start -->
                                <nav class="main-navbar">
                                    <div class="navbar-menu">

                                        <div class="navbar-menu-toggle d-none d-lg-block">
                                            <button id="toggle-menu-11" class="menu-toggle collapsed"
                                                    data-bs-toggle="collapse" data-bs-target="#menuVertical11-1"
                                                    aria-controls="menuVertical11-1" aria-expanded="false"
                                                    aria-label="Toggle navigation">
                                                <span class="toggle-icon"></span>
                                                <span class="toggle-icon"></span>
                                                <span class="toggle-icon"></span>
                                            </button>
                                        </div>

                                        <ul class="main-menu menu-vertical-11 collapse" id="menuVertical11-1">
                                            <li class="menu-item-has-children">
                                                <a href="#0" class="collapsed" data-bs-toggle="collapse"
                                                   data-bs-target="#menuVertical11-2"
                                                   aria-controls="menuVertical11-2" aria-expanded="false"
                                                   aria-label="Toggle navigation">Arts & Crafts <i
                                                        class="mdi mdi-chevron-right"></i></a>

                                                <!-- sub mega dropdown Start -->
                                                <ul class="sub-mega-dropdown collapse" id="menuVertical11-2">
                                                    <li>
                                                        <div class="mega-dropdown-menu">
                                                            <ul class="container mega-dropdown d-flex flex-wrap">
                                                                <li
                                                                        class="mega-dropdown-list menu-item-has-children">
                                                                    <h6 class="heading-6 font-weight-500 mega-title collapsed"
                                                                        data-bs-toggle="collapse"
                                                                        data-bs-target="#menuVertical11-3"
                                                                        aria-controls="menuVertical11-3"
                                                                        aria-expanded="false"
                                                                        aria-label="Toggle navigation">
                                                                        New Arrivals
                                                                        <i class="mdi mdi-chevron-right"></i>
                                                                    </h6>
                                                                    <ul class="collapse" id="menuVertical11-3">
                                                                        <li><a href="#0">Dressess</a></li>
                                                                        <li><a href="#0">Jackets</a></li>
                                                                        <li><a href="#0">Hoodies & Sweatshirts</a>
                                                                        </li>
                                                                        <li><a href="#0">Sweaters</a></li>
                                                                        <li><a href="#0">Tops & Tees</a></li>
                                                                        <li><a href="#0">Party Dressess</a></li>
                                                                    </ul>
                                                                </li>
                                                                <li
                                                                        class="mega-dropdown-list menu-item-has-children">
                                                                    <h6 class="heading-6 font-weight-500 mega-title collapsed"
                                                                        data-bs-toggle="collapse"
                                                                        data-bs-target="#menuVertical11-4"
                                                                        aria-controls="menuVertical11-4"
                                                                        aria-expanded="false"
                                                                        aria-label="Toggle navigation">
                                                                        Trending
                                                                        <i class="mdi mdi-chevron-right"></i>
                                                                    </h6>
                                                                    <ul class="collapse" id="menuVertical11-4">
                                                                        <li><a href="#0">Dressess</a></li>
                                                                        <li><a href="#0">Jackets</a></li>
                                                                        <li><a href="#0">Hoodies & Sweatshirts</a>
                                                                        </li>
                                                                        <li><a href="#0">Sweaters</a></li>
                                                                        <li><a href="#0">Tops & Tees</a></li>
                                                                        <li><a href="#0">Party Dressess</a></li>
                                                                    </ul>
                                                                </li>
                                                                <li class="mega-dropdown-list">
                                                                    <div class="d-md-flex d-lg-block">
                                                                        <div class="menu-image">
                                                                            <img src="assets/images/menu-1.jpg"
                                                                                 alt="">
                                                                        </div>
                                                                        <div class="menu-image">
                                                                            <img src="assets/images/menu-2.jpg"
                                                                                 alt="">
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>
                                                </ul>
                                                <!-- sub mega dropdown Ends -->
                                            </li>
                                            <li class="menu-item-has-children">
                                                <a href="#0" class="collapsed" data-bs-toggle="collapse"
                                                   data-bs-target="#menuVertical11-5"
                                                   aria-controls="menuVertical11-5" aria-expanded="false"
                                                   aria-label="Toggle navigation">Fashion <i
                                                        class="mdi mdi-chevron-right"></i></a>

                                                <!-- sub mega dropdown Start -->
                                                <ul class="sub-mega-dropdown collapse" id="menuVertical11-5">
                                                    <li>
                                                        <div class="mega-dropdown-menu">
                                                            <ul class="container mega-dropdown d-flex flex-wrap">
                                                                <li
                                                                        class="mega-dropdown-list menu-item-has-children">
                                                                    <h6 class="heading-6 font-weight-500 mega-title collapsed"
                                                                        data-bs-toggle="collapse"
                                                                        data-bs-target="#menuVertical11-6"
                                                                        aria-controls="menuVertical11-6"
                                                                        aria-expanded="false"
                                                                        aria-label="Toggle navigation">
                                                                        New Arrivals
                                                                        <i class="mdi mdi-chevron-right"></i>
                                                                    </h6>
                                                                    <ul class="collapse" id="menuVertical11-6">
                                                                        <li><a href="#0">Dressess</a></li>
                                                                        <li><a href="#0">Jackets</a></li>
                                                                        <li><a href="#0">Hoodies & Sweatshirts</a>
                                                                        </li>
                                                                        <li><a href="#0">Sweaters</a></li>
                                                                        <li><a href="#0">Tops & Tees</a></li>
                                                                        <li><a href="#0">Party Dressess</a></li>
                                                                    </ul>
                                                                </li>
                                                                <li
                                                                        class="mega-dropdown-list menu-item-has-children">
                                                                    <h6 class="heading-6 font-weight-500 mega-title collapsed"
                                                                        data-bs-toggle="collapse"
                                                                        data-bs-target="#menuVertical11-7"
                                                                        aria-controls="menuVertical11-7"
                                                                        aria-expanded="false"
                                                                        aria-label="Toggle navigation">
                                                                        Trending
                                                                        <i class="mdi mdi-chevron-right"></i>
                                                                    </h6>
                                                                    <ul class="collapse" id="menuVertical11-7">
                                                                        <li><a href="#0">Dressess</a></li>
                                                                        <li><a href="#0">Jackets</a></li>
                                                                        <li><a href="#0">Hoodies & Sweatshirts</a>
                                                                        </li>
                                                                        <li><a href="#0">Sweaters</a></li>
                                                                        <li><a href="#0">Tops & Tees</a></li>
                                                                        <li><a href="#0">Party Dressess</a></li>
                                                                    </ul>
                                                                </li>
                                                                <li class="mega-dropdown-list">
                                                                    <div class="d-md-flex d-lg-block">
                                                                        <div class="menu-image">
                                                                            <img src="assets/images/menu-1.jpg"
                                                                                 alt="">
                                                                        </div>
                                                                        <div class="menu-image">
                                                                            <img src="assets/images/menu-2.jpg"
                                                                                 alt="">
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>
                                                </ul>
                                                <!-- sub mega dropdown Ends -->
                                            </li>
                                            <li><a href="#0">Health & Household <i
                                                    class="mdi mdi-chevron-right"></i></a></li>
                                            <li><a href="#0">Bages & Shoes <i class="mdi mdi-chevron-right"></i></a>
                                            </li>
                                            <li><a href="#0">Jewelry & Watchs <i
                                                    class="mdi mdi-chevron-right"></i></a></li>
                                            <li><a href="#0">Beauty & Health <i
                                                    class="mdi mdi-chevron-right"></i></a></li>
                                            <li><a href="#0">Electronics <i class="mdi mdi-chevron-right"></i></a>
                                            </li>
                                            <li><a href="#0">Home & Garden <i class="mdi mdi-chevron-right"></i></a>
                                            </li>

                                            <!-- BACK END STUFF HERE -->
                                            <!-- Check if User is logged In Or Not -->

                                            <c:choose>

                                                <c:when test="${sessionScope.userId != null}">
                                                    <!-- TODO REMOVE DEBUGGIMG -->
                                                    <script> console.log("user Logged In") </script>
                                                    <li><a href="profile" id="BurgerMenuLoginRegBtns"> Profile  <i class="mdi mdi-card-account-details"></i></a></li>
                                                    <li><a href="logout" id="BurgerMenuLoginRegBtns">Logout  <i class="mdi mdi-logout-variant"></i></a></li>
                                                </c:when>

                                                <c:when test="${sessionScope.userId == null}">
                                                    <!-- TODO REMOVE DEBUGGIMG -->
                                                    <script> console.log("user NOT Logged In") </script>
                                                    <li><a href="login" id="BurgerMenuLoginRegBtns"> Login <i class="mdi mdi-login-variant"></i></a></li>
                                                    <li><a href="register" id="BurgerMenuLoginRegBtns">Register <i class="mdi mdi-account-multiple-plus"></i></a></li>

                                                </c:when>

                                            </c:choose>

                                        </ul>
                                    </div>
                                </nav>
                                <!-- navbar Menu Ends -->
                            </div>
                            <!-- navbar wrapper Ends -->
                        </div>
                    </div>
                    <div class="col-lg-4 col-6">
                        <!-- desktop logo Start -->
                        <div class="desktop-logo text-center">
                            <a href="#0"><img src="assets/images/logo.svg" alt="Logo"></a>
                        </div>
                        <!-- desktop logo Ends -->
                    </div>
                    <div class="col-lg-4 col-3">


                        <!-- navbar Meta start -->


                        <div class="navbar-meta ">



                            <ul class="meta">


                                <!-- BACK END STUFF HERE -->
                                <c:choose>

                                    <c:when test="${sessionScope.userId != null}">

                                        <li id="userMenu" >
                                            <!--Will Apper only if the useer is LOGGED IN-->
                                            <div class="navbar-user dropdown">

                                                <a class="icon-btn primary-icon-text icon-text-btn" href="#dropdown11"
                                                   role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
                                                        class="mdi mdi-account"></i></a>
                                                <ul class="dropdown-menu" id="dropdown11">
                                                    <li><a href="#0"><i class="mdi mdi-account"></i> My Profile</a></li>
                                                    <li><a href="#0"><i class="mdi mdi-import"></i> Logout</a></li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li id="user-cart">
                                            <div class="navbar-cart">
                                                <a class="icon-btn primary-icon-text icon-text-btn" href="#0"><img
                                                        src="assets/images/icon-svg/cart-9.svg" alt="Icon" style="padding-top: 10px;">
                                                    <span id="cart-count" class="icon-text text-style-1">-</span></a>

                                                <div class="navbar-cart-dropdown">
                                                    <div class="checkout-style-2">
                                                        <div class="checkout-header d-flex justify-content-between">
                                                            <h6 class="title">Shopping Cart </h6>
                                                        </div>

                                                        <div class="checkout-table table-responsive">
                                                            <table class="table">
                                                                <tbody id="cart-items-table">
                                                                <c:forEach var="item" items="${cart}">
                                                                    <tr id="table-row-${item.productId}">
                                                                        <td class="checkout-product">
                                                                            <div class="product-cart d-flex">
                                                                                <div class="product-thumb">
                                                                                    <img src="${item.productImage}"
                                                                                         alt="Product">
                                                                                </div>
                                                                                <div class="product-content media-body">
                                                                                    <h5 class="title"><a href="shop/prod-detail?prodId=${item.productId}">
                                                                                            ${item.productName}
                                                                                    </a></h5>
                                                                                    <ul>
                                                                                        <li><span id="item-qty-${item.productId}">${item.productQty}</span>
                                                                                            <span>X$</span>
                                                                                            <span id="item-price">${item.productPrice}</span>
                                                                                        </li>
                                                                                        <li><a class="delete" onclick="deleteProduct(${item.productId})"><i
                                                                                                class="mdi mdi-delete"></i></a>
                                                                                        </li>
                                                                                    </ul>
                                                                                </div>
                                                                            </div>
                                                                        </td>
                                                                        <td class="checkout-quantity">
                                                                            <div class="product-quantity d-inline-flex">
                                                                                <button type="button" id="sub"
                                                                                        class="sub" onclick="decProdQty(${item.productId},${item.productPrice})"><i
                                                                                        class="mdi mdi-minus"></i></button>
                                                                                <input id="item-${item.productId}-qty-input" type="text" value="${item.productQty}" disabled>
                                                                                <button type="button" id="add"
                                                                                        class="add" onclick="incProdQty(${item.productId},${item.productPrice})">
                                                                                    <i
                                                                                            class="mdi mdi-plus"></i>
                                                                                </button>
                                                                            </div>
                                                                        </td>
                                                                        <td class="checkout-price">
                                                                            <p id="total-item-price-${item.productId}" class="price">${item.productPrice * item.productQty }</p>
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                        <div class="checkout-footer">
                                                            <div class="checkout-sub-total d-flex justify-content-between">
                                                                <p class="value">Subotal Price:</p>
                                                                <p class="price" id="cart-total-price">$144</p>
                                                            </div>
                                                            <div class="checkout-btn">
                                                                <a href="#0" class="main-btn primary-btn-border">View
                                                                    Cart</a>
                                                                <a href="#0" class="main-btn primary-btn">To Checkout</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>

                                    </c:when>

                                    <c:when test="${sessionScope.userId == null}">

                                        <li id="userSignInRegister">
                                            <a class="icon-btn primary-icon-text icon-text-btn customMenuBtn" href="login" role="button">
                                                <class class="mdi mdi-login-variant"></class>Login
                                            </a>

                                            <a class="icon-btn primary-icon-text icon-text-btn customMenuBtn" href="register" role="button">
                                                <class class="mdi mdi-account-multiple-plus"></class>Register
                                            </a>

                                        </li>

                                    </c:when>

                                </c:choose>

                            </ul>
                        </div>
                        <!-- navbar Meta Ends -->
                    </div>
                </div>
            </div>
        </nav>
        <!-- main navbar Ends -->
        <div class="overlay-11"></div>
    </header>
    <!--====== Navbar Style 11 Part Ends ======-->
</section>


--%>



