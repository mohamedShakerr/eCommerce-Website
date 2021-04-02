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
    <link rel="icon" type="image/png" sizes="16x16" href="admin_assets/images/favicon2.png">

    <!-- Custom CSS -->
    <link href="admin_assets/css/chartist.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="admin_assets/css/style.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

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
                <a class="navbar-brand" href="admin">
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
                            <img src="admin_assets/images/users/1.jpg" alt="user" class="rounded-circle" width="31">
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
                           href="admin" aria-expanded="false">
                            <i class="fas fa-shopping-cart"></i>&nbsp;
                            <span class="hide-menu">Products</span>
                        </a>
                    <li class="sidebar-item">
                        <a class="sidebar-link waves-effect waves-dark sidebar-link"
                           href="customers" aria-expanded="false">
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
            <div class="page-breadcrumb">
                <div class="row align-items-center">
<!--                    <div class="col-5">-->
<!--                        <h4 class="page-title">Customer Profile</h4>-->
<!--                    </div>-->
                    <div class="feed-widget page-title">
                        <ul class="list-style-none feed-body m-0 p-b-20">
                            <li class="feed-item">
                                <div class="feed-icon bg-danger"><i class="ti-user"></i></div>
                                <h4>Customer Profile</h4>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
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
                    <c:if test='${! empty requestScope.myCustomer}'>
                        <div class="col-lg-5 col-xlg-4 col-md-5">
                            <div class="card">
                                <div class="card-body">
                                    <center class="m-t-30">
                                        <img src="${myCustomer.url}" class="rounded-circle" width="150" />
                                        <h4 class="card-title m-t-10">
                                            <c:out value="${myCustomer.name}" />
                                        </h4>
                                        <div class="row text-center justify-content-md-center">
                                            <div class="col-4">
                                                <a href="javascript:void(0)" class="link">
                                                    <i class="icon-people"></i>
                                                    <font class="font-medium">
                                                        254
                                                    </font>
                                                </a>
                                            </div>
                                            <div class="col-4">
                                                <a href="javascript:void(0)" class="link">
                                                    <i class="icon-picture"></i>
                                                    <font class="font-medium">
                                                        54
                                                    </font>
                                                </a>
                                            </div>
                                        </div>
                                    </center>
                                </div>
                                <div>
                                    <hr>
                                </div>
                            </div>
                        </div>
                    <!-- Column -->
                    <!-- Column -->
                        <div class="col-lg-7 col-xlg-8 col-md-7">
                            <div class="card">
                                <div class="card-body">
                                    <form class="form-horizontal form-material mx-2">
                                        <div class="form-group">
                                            <label class="col-md-12">Customer Name</label>
                                            <div class="col-md-12">
<%--                                                <input type="text" value="customerName" class="form-control form-control-line" disabled>--%>
                                                <input type="text" value="${myCustomer.name}" class="form-control form-control-line" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="example-email" class="col-md-12">Email</label>
                                            <div class="col-md-12">
<%--                                                <input type="email" placeholder="johnathan@admin.com"--%>
<%--                                                    class="form-control form-control-line" name="example-email"--%>
<%--                                                    id="example-email" value="customerMail" disabled>--%>
                                                <input type="email" placeholder="johnathan@admin.com"
                                                    class="form-control form-control-line" name="example-email"
                                                    id="example-email" value="${myCustomer.email}" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-12">Address</label>
                                            <div class="col-md-12">
<%--                                                <input type="text" value="customerAddress"--%>
<%--                                                    class="form-control form-control-line" disabled>--%>
                                                <input type="text" value="${myCustomer.address}"
                                                    class="form-control form-control-line" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-12">Phone</label>
                                            <div class="col-md-12">
<%--                                                <input type="text" placeholder="123 456 7890"--%>
<%--                                                       value="customerPhone" class="form-control form-control-line" disabled>--%>
                                                <input type="text" placeholder="123 456 7890"
                                                       value="${myCustomer.phone}" class="form-control form-control-line" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-12">Register Date</label>
                                            <div class="col-md-12">
<%--                                                <input type="text" placeholder="123 456 7890"--%>
<%--                                                       value="customerRegisterDate" class="form-control form-control-line" disabled>--%>
                                                <input type="text" placeholder="123 456 7890"
                                                       value="${myCustomer.registerDate}" class="form-control form-control-line" disabled>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:if>



<%--                    <div class="col-lg-7 col-xlg-8 col-md-7">--%>
<%--                        <div class="card">--%>
<%--                            <div class="card-body">--%>
<%--                                <form class="form-horizontal form-material mx-2">--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label class="col-md-12">Customer Name</label>--%>
<%--                                        <div class="col-md-12">--%>
<%--                                            <input type="text" value="customerName" class="form-control form-control-line" disabled>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label for="example-email" class="col-md-12">Email</label>--%>
<%--                                        <div class="col-md-12">--%>
<%--                                            <input type="email" placeholder="johnathan@admin.com"--%>
<%--                                                   class="form-control form-control-line" name="example-email"--%>
<%--                                                   id="example-email" value="customerMail" disabled>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label class="col-md-12">Address</label>--%>
<%--                                        <div class="col-md-12">--%>
<%--                                            <input type="text" value="customerAddress"--%>
<%--                                                   class="form-control form-control-line" disabled>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label class="col-md-12">Phone</label>--%>
<%--                                        <div class="col-md-12">--%>
<%--                                            <input type="text" placeholder="123 456 7890"--%>
<%--                                                   value="customerPhone" class="form-control form-control-line" disabled>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label class="col-md-12">Register Date</label>--%>
<%--                                        <div class="col-md-12">--%>
<%--                                            <input type="text" placeholder="123 456 7890"--%>
<%--                                                   value="customerRegisterDate" class="form-control form-control-line" disabled>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </form>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>



                    <!-- Column -->
                </div>
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
                All Rights Reserved by JETS G.M.W.SH
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

<script src="admin_assets/js/jquery.min.js"></script>
<!-- Bootstrap tether Core JavaScript -->
<script src="admin_assets/js/bootstrap.bundle.min.js"></script>

<script src="admin_assets/js/app-style-switcher.js"></script>
<!--Wave Effects -->
<script src="admin_assets/js/waves.js"></script>
<!--Menu sidebar -->
<script src="admin_assets/js/sidebarmenu.js"></script>
<!--Custom JavaScript -->
<script src="admin_assets/js/custom.js"></script>

</body>

</html>