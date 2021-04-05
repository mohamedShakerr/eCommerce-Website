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
          crossorigin="anonymous"/>

    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="admin_assets/images/favicon2.png">

    <!-- Custom CSS -->
    <link href="admin_assets/css/chartist.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="admin_assets/css/style.min.css" rel="stylesheet">

    <!-- M-Img-Picker JS -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- JQuery -->
    <script src="admin_assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="admin_assets/m-Img-Picker/js/spartan-multi-image-picker-min.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>


<!-- Modal -->
<div class="modal fade" id="editProdModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color: #5c636a">
                <h5 class="modal-title" style="color: white">Edit Product</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <!--                    <span aria-hidden="true">×</span>-->
                    <i class="fas fa-window-close" style="color: white"></i>
                </button>
            </div>
            <div class="modal-body">

<%--                <img src="https://ecommerece-iti.s3.eu-central-1.amazonaws.com/fbe5336c-352d-499a-ac8e-4c013520f2c0"/>--%>
                <form  method="POST" action="admin" enctype="multipart/form-data" class="form-horizontal form-material mx-2">
                    <input type="text" name="operation" value="addProduct" hidden/>
                    <div class="form-group">
                        <label class="col-md-12">Product Name</label>
                        <div class="col-md-12">
                            <input id="productName" name="productName" value="thisIsProductNAme" type="text" class="form-control form-control-line">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-12">Price</label>
                        <div class="col-md-12">
                            <input id="productPrice" name="productPrice" type="text"
                                   class="form-control form-control-line">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-12">Quantity</label>
                        <div class="col-md-12">
                            <input id="productQuantity" name="productQuantity" type="text"
                                   class="form-control form-control-line">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-12">Category</label>
                        <div  class="col-sm-12">
                            <select id="categorySelector" name="categorySelector" class="form-select shadow-none form-control-line">
                                <option value="1">Consoles</option>
                                <option value="2">Games</option>
                                <option value="3">Joysticks</option>
                                <option value="4">VR</option>
                                <option value="5">Headsets</option>
                                <option value="6">Cables</option>
                                <option value="7">Thubsticks</option>
                                <option value="8">Cards</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="form-label col-md-12">Main Image</label>
                        <div class="col-md-12">
                            <input  id="productImageFile" name="productImageFile" type="file" accept="image/*" class="form-control form-control-sm">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-12">Description</label>
                        <div class="col-md-12">
                            <textarea id="productDescription" name="productDescription" rows="5" class="form-control form-control-line" style="resize: none"></textarea>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="form-label col-md-12">Albums</label>
                        <div class="col-md-12" >
                            <div id="coba" class="row"></div>
                        </div>
                    </div>

                    <div class="modal-footer" style="background-color: #5c636a">
                        <button type="button" class="btn btn-danger" style="color: white" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Update Product</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<!-- Modal -->
<%--<jsp:include page="admin/products/editProdModal.jsp"/>--%>


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

                </ul>
                <!-- ============================================================== -->
                <!-- Right side toggle and nav items -->
                <!-- ============================================================== -->
                <ul class="navbar-nav float-end">
                    <!-- ============================================================== -->
                    <!-- User profile and search -->
                    <!-- ============================================================== -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="#"
                           id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="m-r-10 mdi mdi-account-settings-variant fa-2x" style="color: white"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end user-dd animated" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="javascript:void(0)">

                                <a href="admin/admin-logout">
                                    <i class="fa fa-power-off m-r-5 m-l-5"></i>
                                    Logout

                                </a>
                            </a>
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
                    <li class="p-15 m-t-10">
                        <button type="button"
                                class="btn d-block w-100 create-btn text-white no-block d-flex align-items-center"
                                data-toggle="modal" data-target="#editProdModal" data-whatever="@geeksforgeeks">
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
                           href="admin/customers" aria-expanded="false">
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
    <!-- Page wrapper  -->
    <!-- ============================================================== -->
    <div class="page-wrapper">
        <!-- Container fluid  -->
        <div class="container-fluid">
            <!-- Table -->
            <!-- ============================================================== -->
            <div class="row">
                <!-- column -->
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title" style="text-align: center">
                                Products Store
                                <i class="fas fa-shopping-basket"></i>
                                <%--                                    <i class="fa fa-product-hunt"></i>--%>
                            </h4>
                        </div>
                        <div class="search-box">
                            <a class="waves-effect waves-dark" href="javascript:void(0)" >&nbsp; &nbsp;
                                <i class="ti-search" style="color: black"></i>
                            </a>
                            <form class="app-search position-absolute">
                                <input type="text" id="searchInp" class="form-control" placeholder="Search">
                                <a class="srh-btn"><i class="ti-close"></i></a>
                            </form>
                        </div><br>
                        <div class="table-responsive">
                            <table class="table v-middle table-striped table-hover" id="myTable" onkeyup="myFunction()">
                                <thead class="table-dark text-light">
                                <tr class="bg-dark">
                                    <th class="border-top-0" style="color: papayawhip">#</th>
                                    <th class="border-top-0" style="color: papayawhip">Name</th>
                                    <th class="border-top-0" style="color: papayawhip">Price</th>
                                    <th class="border-top-0" style="color: papayawhip">Quantity</th>
                                    <th class="border-top-0" style="color: papayawhip" colspan="2">&nbsp;&nbsp;Action
                                    </th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:choose>
                                    <c:when test='${! empty requestScope.productsList}'>
                                        <c:forEach var="myProduct" items='${requestScope["productsList"]}'>
                                            <tr id="row${myProduct.productId}">
                                                <td>
                                                    <c:out value="${myProduct.productId}"/>
                                                </td>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div class="m-r-10">
                                                            <img class="btn btn-circle d-flex btn-info text-white" style="padding: 1px"
                                                                 src="${myProduct.imageUrl}" width="50"
                                                                 class="rounded-circle" alt="product"/>
                                                        </div>
                                                        <div class="">
                                                            <h4 class="m-b-0 font-16">
                                                                <c:out value="${myProduct.productName}"/>
                                                            </h4>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <label class="label label-primary">
                                                        <c:out value="${myProduct.productPrice}"/>
                                                    </label>
                                                </td>
                                                <td>
                                                    <label class="label label-danger">
                                                        <c:out value="${myProduct.quantity}"/>
                                                    </label>
                                                </td>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div class="m-r-10">
                                                            <a class="main-btn primary-btn"
                                                               href="admin/products?productId=${myProduct.productId}"><i
                                                                    class="fas fa-edit"></i></a>
                                                        </div>&nbsp; &nbsp; &nbsp;
                                                        <div class="m-r-10">
                                                            <a id="deleteProductBtn" class="main-btn primary-btn"
                                                               onclick="onDeleteProduct(${myProduct.productId})"><i
                                                                    class="fas fa-trash-alt"></i></a>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan=8 align="center" bgcolor="red">
                                                <b>There is no Products Found</b>
                                            </td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- Table -->
            <!-- ============================================================== -->
        </div>


        <script>

            function onDeleteProduct(productId) {

                $.post("admin?operation=deleteProduct&productId=" + productId, function (result) {

                    if (result) {
                        //deleted
                        $('#row' + productId).remove();
                        console.log("Product " + productId + " was deleted");
                    } else {
                        // failed
                        console.log("couldn't delete produect");
                    }

                });

            }
        </script>

        <%-- ==== Img Picker ==== --%>
        <script>
            var imgIcon = "https://www.google.com/url?sa=i&url=https%3A%2F%2Ftoppng.com%2Ffile-upload-image-icon-PNG-free-PNG-Images_223100&psig=AOvVaw39eu6kmuPWUUbh7IYfCH15&ust=1617649445842000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCVvfqj5e8CFQAAAAAdAAAAABAO";
            $("#coba").spartanMultiImagePicker({
                fieldName: 'fileUpload[]',
                maxCount: 4,
                loaderIcon: '<i class="fas fa-sync fa-spin"></i>',
                rowHeight: '100px',
                groupClassName: 'col-md-3 col-sm-3 col-xs-4',
                allowedExt: 'png|jpg|jpeg',
                maxFileSize: '2000000',
                dropFileLabel: "Drop Here",
                placeholderImage: {
                    image: "",
                    width: '100%'
                },
                onExtensionErr : function(index, file){
                    console.log(index, file);
                    alert('Please only input png or jpg type file');
                },
                onSizeErr : function(index, file){
                    console.log(index, file);
                    alert('File size too big');
                }
            });

            <%--  ================== Table Search ================== --%>
            $(document).ready(function() {
                $("#searchInp").on("keyup", function() {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function() {
                        $(this).toggle($(this).text()
                            .toLowerCase().indexOf(value) > -1)
                    });
                });
            });

        </script>

        <!-- ============================================================== -->
        <!-- End Container fluid  -->
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
<!-- All Jquery -->

<!-- Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>

<!-- Bootstrap -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
        integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>


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