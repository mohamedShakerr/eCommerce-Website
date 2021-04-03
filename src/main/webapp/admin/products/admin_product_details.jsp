<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="robots" content="noindex,nofollow">
    <title>Admin Dashboard</title>

    <!-- Load Bootstrap -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
          integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
          crossorigin="anonymous" />

    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="../../admin_assets/images/favicon2.png">

    <!-- Custom CSS -->
    <link href="../admin_assets/css/chartist.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../admin_assets/css/style.min.css" rel="stylesheet">

    <!-- Flickey CSS for ImgSlider -->
    <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<%--<jsp:include page="editProdModal.jsp"/>--%>
<%@ include file="editProdModal.jsp" %>
<!-- Modal -->
<div class="modal fade" id="exampleModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color: #5c636a">
                <h5 class="modal-title" style="color: white">Add New Product</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <!--                    <span aria-hidden="true">×</span>-->
                    <i class="fas fa-window-close" style="color: white"></i>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="prodName" placeholder="Name">
                        <label for="prodName">Name</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="prodPrice" placeholder="Price">
                        <label for="prodPrice">Price</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="proQuant" placeholder="Quantity">
                        <label for="proQuant">Quantity</label>
                    </div>
                    <div class="form-floating">
                        <textarea class="form-control" placeholder="Description" id="prodDesc" style="resize: none; height: 100px"></textarea>
                        <label for="prodDesc">Description</label>
                    </div>
                </form>
            </div>
            <div class="modal-footer" style="background-color: #5c636a">
                <button type="button" class="btn btn-danger"  style="color: white" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary">Add Product</button>
            </div>
        </div>
    </div>
</div>

<!-- ============================================================== -->
<!-- Preloader - style you can find in spinners.css -->
<!-- ============================================================== -->
<div class="preloader">
    <div class="lds-ripple">
        <div class="lds-pos"></div>
        <div class="lds-pos"></div>
    </div>
</div>
<!-- ============================================================== -->
<!-- Main wrapper - style you can find in pages.scss -->
<!-- ============================================================== -->
<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
     data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
    <!-- ============================================================== -->
    <!-- Topbar header - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <header class="topbar" data-navbarbg="skin5">
        <nav class="navbar top-navbar navbar-expand-md navbar-dark">
            <div class="navbar-header" data-logobg="skin5">
                <!-- ============================================================== -->
                <!-- Logo -->
                <!-- ============================================================== -->
                <a class="navbar-brand" href="../admin">
                    <!-- Logo icon -->
                    <b class="logo-icon">
                        <h3>
                            <i class="fab fa-playstation"></i>
                            <i class="fas fa-gamepad"></i>
                        </h3>
                    </b>
                    <!--End Logo icon -->
                    <!-- Logo text -->
                    <h3>
                        <span class="logo-text">UnityStore</span>
                    </h3>

                </a>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <!-- This is for the sidebar toggle which is visible on mobile only -->
                <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="javascript:void(0)"><i
                        class="ti-menu ti-close"></i></a>
            </div>
            <!-- ============================================================== -->
            <!-- End Logo -->
            <!-- ============================================================== -->
            <div class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin5">
                <!-- ============================================================== -->
                <!-- toggle and nav items -->
                <!-- ============================================================== -->
                <ul class="navbar-nav float-start me-auto">
                    <!-- ============================================================== -->
                    <!-- Search -->
                    <!-- ============================================================== -->
                    <li class="nav-item search-box"> <a class="nav-link waves-effect waves-dark"
                                                        href="javascript:void(0)"><i class="ti-search"></i></a>
                        <form class="app-search position-absolute">
                            <input type="text" class="form-control" placeholder="Search"> <a
                                class="srh-btn"><i class="ti-close"></i></a>
                        </form>
                    </li>
                </ul>
                <!-- ============================================================== -->
                <!-- Right side toggle and nav items -->
                <!-- ============================================================== -->
                <ul class="navbar-nav float-end">
                    <!-- ============================================================== -->
                    <!-- User profile and search -->
                    <!-- ============================================================== -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="m-r-10 mdi mdi-account-settings-variant fa-2x" style="color: white"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end user-dd animated" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="javascript:void(0)">
                                <i class="fa fa-power-off m-r-5 m-l-5"></i>
                                Logout</a>
                        </ul>

                    </li>
                    <!-- ============================================================== -->
                    <!-- User profile and search -->
                    <!-- ============================================================== -->
                </ul>
            </div>
        </nav>
    </header>
    <!-- ============================================================== -->
    <!-- End Topbar header -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Left Sidebar - style you can find in sidebar.scss  -->
    <!-- ============================================================== -->
    <aside class="left-sidebar" data-sidebarbg="skin6">
        <!-- Sidebar scroll-->
        <div class="scroll-sidebar">
            <!-- Sidebar navigation-->
            <nav class="sidebar-nav">
                <ul id="sidebarnav">
                    <li class="p-15 m-t-10" >
                        <button type="button" class="btn d-block w-100 create-btn text-white no-block d-flex align-items-center" data-toggle="modal" data-target="#exampleModal" data-whatever="@geeksforgeeks">
                            <i class="fa fa-plus-square"></i>
                            <span class="hide-menu m-l-5">Add New Product</span>
                        </button>

                    </li>
                    <!-- User Profile-->
                    <li class="sidebar-item">
                        <a class="sidebar-link waves-effect waves-dark sidebar-link"
                           href="../admin" aria-expanded="false">
                            <i class="fas fa-shopping-cart"></i>&nbsp;
                            <span class="hide-menu">Products</span>
                        </a>
                    <li class="sidebar-item">
                        <a class="sidebar-link waves-effect waves-dark sidebar-link"
                           href="../admin/customers" aria-expanded="false">
                            <i class="fas fa-users"></i>&nbsp;
                            <span class="hide-menu">Customers</span>
                        </a>
                    </li>
                </ul>

            </nav>
            <!-- End Sidebar navigation -->
        </div>
        <!-- End Sidebar scroll-->
    </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb" style="background-color: #5c636a">
                <div class="row align-items-center">
                    <h3 style="text-align: center; color: white">
                        Product Details
                        <i class="fas fa-shopping-basket"></i>
                    </h3><br><br><br>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
                <div class="row">
                    <!-- Column -->
                    <c:if test='${! empty requestScope.myProduct}'>
                            <div class="col-lg-5 col-xlg-4 col-md-5">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="m-t-30" style="text-align: center;">
                                            <img src="${myProduct.imageUrl}" class="rounded-circle" width="150" />
                                            <h4 class="card-title m-t-10">
                                                <c:out value="${myProduct.productName}" />
                                            </h4>
                                            <div class="row text-center justify-content-md-center">
                                                <div class="col-4">
                                                    <a href="javascript:void(0)" class="link">
                                                        <i class="icon-people"></i>
                                                        <span class="font-medium">
                                                            Quantity: <c:out value="${myProduct.quantity}" />
                                                        </span>
                                                    </a>
                                                </div>
                                                <div class="col-4">
                                                    <a href="javascript:void(0)" class="link">
                                                        <i class="icon-picture"></i>
                                                        <span class="font-medium">
                                                            Price: $<c:out value="${myProduct.productPrice}" />
                                                        </span>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <hr>
                                    </div>
                                    <div class="card-body">
                                        <h3 style="text-align: center; color: #262d35">
                                            Product
                                            <c:if test='${! empty requestScope.myProduct}'>
                                                <c:out value="${myProduct.productId}" />
                                            </c:if>
                                            Album
                                            <i class="fas fa-images"></i>
                                        </h3>
                                        <div class="card-body">
                                            <div class="carousel" data-flickity='{ "wrapAround": "true", "autoPlay": true, "imagesLoaded": true}'>
                                                <c:forEach var="prodImg" items="${myProduct.prodImages}" varStatus="counter" begin="0" end="${myProduct.prodImages.size()-1}">
                                                    <div class="carousel-cell"  id="v-pills-${counter.index}">
                                                        <div class="carousel-cell">
                                                            <img src="${prodImg}" width="350" height="330">
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    <!-- Column -->
                    <!-- Column -->
                        <div class="col-lg-7 col-xlg-8 col-md-7">
                            <h3 style="text-align: center;">
                                Product
                                <c:if test='${! empty requestScope.myProduct}'>
                                    <c:out value="${myProduct.productId}" />
                                </c:if>
                                information
                                <i class="m-r-10 mdi mdi-cart"></i>
                            </h3><br>
                            <div class="card" style="background-color: #262d35">
                                <div class="card-body">
                                    <form class="form-horizontal form-material mx-2">
                                        <div class="form-group">
                                            <label class="col-md-12" style="color: white">Product Name</label>
                                            <div class="col-md-12">
                                                <input type="text" id="nameInputId" value="${myProduct.productName}" class="form-control form-control-line" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-12" style="color: white">Price</label>
                                            <div class="col-md-12">
                                                <input type="text" id="priceInputId" value="${myProduct.productPrice}"
                                                    class="form-control form-control-line" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-12" style="color: white">Quantity</label>
                                            <div class="col-md-12">
                                                <input type="text" placeholder="50" id="quantityInputId"
                                                       value="${myProduct.quantity}" class="form-control form-control-line" disabled>
                                            </div>
                                        </div>
<%--                                        <div class="form-group">
                                            <label class="col-sm-12">Category</label>
                                            <div class="col-sm-12">
                                                <select class="form-select shadow-none form-control-line">
                                                    &lt;%&ndash;                                                    <option selected><c:out value="${myProduct.description}" /></option>&ndash;%&gt;
                                                    <option>cables</option>
                                                    <option>cards</option>
                                                    <option>consoles</option>
                                                    <option>games</option>
                                                    <option>headsets</option>
                                                    <option>joysticks</option>
                                                    <option>thumbsticks</option>
                                                    <option>vr</option>
                                                </select>
                                            </div>
                                        </div>--%>
                                        <div class="form-group">
                                            <label class="col-md-12" style="color: white">Description</label>
                                            <div class="col-md-12">
                                                <textarea rows="5" class="form-control"  id="descInputId" style="resize: none" disabled>
                                                    <c:out value="${myProduct.description}" />
                                                </textarea>
                                            </div>
                                        </div>
                                        <div class="form-group" style="text-align: center">
                                            <div class="d-grid gap-2 d-md-block">
                                                <button type="button" id="editBtnId" onclick="onEditClick()" class="btn btn-danger upgrade-btn text-white align-items-center">
                                                    <i class="mdi mdi-table-edit"></i>
                                                    <span class="hide-menu m-l-4">Edit Product</span>
                                                </button>&nbsp; &nbsp; &nbsp;
                                                <button type="button" id="saveBtnId" onclick="updateProduct()" class="btn btn-info upgrade-btn text-white align-items-center" disabled>
                                                    <i class="fas fa-save"></i>
                                                    <span class="hide-menu m-l-4">Save Product</span>
                                                </button>
                                            </div>
                                        </div>
                                        <span id="updateSuccess" class="suc" style=" display: none; color: green; text-align: center">
                                            <h4>
                                                Product <c:out value="${myProduct.productId}" />
                                                updated successfully
                                                <i class="fas fa-check-square"></i>
                                            </h4>

                                        </span>
                                        <span id="updateFailed" class="suc" style=" display: none; color: red; text-align: center">
                                            <h4>
                                                Failed to update Product <c:out value="${myProduct.productId}" />
                                                <i class="fas fa-times-circle"></i>
                                            </h4>
                                        </span>
                                    </form>
                                </div>
                            </div>
                            <br>
                            <div style="text-align: center; color: #262d35">
                                <h1>
                                    <i class="fab fa-playstation"></i>
                                    <i class="fas fa-gamepad"></i>
                                    <span class="logo-text">UnityStore</span>
                                </h1>
                            </div>
                        </div>
                    </c:if>

                    <!-- Column -->
                </div>

<%--                for edit product --%>
                <script>
                    var inputName = document.getElementById("nameInputId");
                    var inputPrice = document.getElementById("priceInputId");
                    var inputQuantity = document.getElementById("quantityInputId");
                    var inputDesc = document.getElementById("descInputId");
                    var saveBtn = document.getElementById("saveBtnId");

                    function onEditClick(){
                        inputName.disabled = false;
                        inputPrice.disabled = false;
                        inputQuantity.disabled = false;
                        inputDesc.disabled = false;
                        saveBtn.disabled = false;
                    }


                    function updateProduct() {

                        const queryString = window.location.search;
                        const urlParams = new URLSearchParams(queryString);
                        const productId = urlParams.get('productId');
                        console.log("prod id is " + productId);

                        var nameVar = $("#nameInputId").val();
                        var priceVar = $("#priceInputId").val();
                        var quantityVar = $("#quantityInputId").val();
                        var descVar = $("#descInputId").val();

                        var data = {
                            "productId": productId,
                            "productName": nameVar,
                            "productPrice": priceVar,
                            "quantity": quantityVar,
                            "description": descVar
                        }

                        $.post("products", data, function (updatedProduct) {
                            console.log("upda product is " + updatedProduct);

                            if (updatedProduct != null) {
                                document.getElementById("updateSuccess").style.display = 'block';
                                document.getElementById("updateFailed").style.display = 'none';

                                document.getElementById("nameInputId").innerText = nameVar;
                                document.getElementById("priceInputId").innerText = priceVar;
                                document.getElementById("quantityInputId").innerText = quantityVar;
                                document.getElementById("descInputId").innerText = descVar;

                                inputName.disabled = true;
                                inputPrice.disabled = true;
                                inputQuantity.disabled = true;
                                inputDesc.disabled = true;
                                saveBtn.disabled = true;

                                return true;

                            } else {

                                document.getElementById("updateSuccess").style.display = 'none';
                                document.getElementById("updateFailed").style.display = 'block';

                                return true;
                            }
                        });
                    }
                </script>
                <!-- Row -->
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Right sidebar -->
                <!-- ============================================================== -->
                <!-- .right-sidebar -->
                <!-- ============================================================== -->
                <!-- End Right sidebar -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <footer class="footer text-center">
                Copyright
                <i class="far fa-copyright"></i>
                2021 by JETS G.M.W.SH. All Rights Reserved.
            </footer>
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
<!-- All Jquery -->

<!-- Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>

<!-- Bootstrap -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
        integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>

<script src="../admin_assets/js/jquery.min.js"></script>
<!-- Bootstrap tether Core JavaScript -->
<script src="../admin_assets/js/bootstrap.bundle.min.js"></script>

<script src="../admin_assets/js/app-style-switcher.js"></script>
<!--Wave Effects -->
<script src="../admin_assets/js/waves.js"></script>
<!--Menu sidebar -->
<script src="../admin_assets/js/sidebarmenu.js"></script>
<!--Custom JavaScript -->
<script src="../admin_assets/js/custom.js"></script>

<!--flickity JavaScript for imgSlider -->
<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>

</body>

</html>