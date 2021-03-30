<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">

    <!--====== Title ======-->
    <title>eCommerce HTML | Filter</title>

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



<%--Setting values--%>
<c:set var="prods" value="${requestScope.products}"/>
<c:set var="maxPrice" value="${requestScope.maxPrice}"/>
<c:set var="categories" value="${requestScope.categories}"/>

<c:set var="paginationSize" value="${requestScope.NumberOfPages}"/>


<c:out value="${paginationSize}"/>
    <!--====== Filter Part Start ======-->

    <section class="filter-wrapper pt-85" style="padding-top: 20px;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-5 col-lg-3  filters-column"  style="margin: 10px auto;">
                    <div class="filter-style-2">
                        <div class="filter-title">
                            <a class="title" data-bs-toggle="collapse" href="#pricingOne" role="button"
                                aria-expanded="false">Pricing Range</a>
                        </div>
                        <div class="collapse show" id="pricingOne">
                            <div class="price-range">
                                <div class="price-amount">
                                    <div class="amount-input">
                                        <label>Minimum Price</label>
                                        <input type="text" id="minAmount">
                                    </div>
                                    <div class="amount-input">
                                        <label>Maximum Price</label>
                                        <input type="text" id="maxAmount">
                                    </div>
                                </div>
                                <div id="slider-range" class="slider-range"></div>
                            </div>
                        </div>
                    </div>


                    <div class="filter-style-9">
                        <div class="filter-title">
                            <a class="title" data-bs-toggle="collapse" href="#platform" role="button"
                                aria-expanded="false">Software Platform</a>
                        </div>
                        <div class="collapse show" id="platform">
                            <div class="filter-platform">
                                <ul>

                                    <c:forEach  var="category" items="${categories}" varStatus="count" begin="0" end="${categories.size()}">
                                        <li>
                                            <div class="platform-check">
                                                <input type="checkbox" id="category-${count.index}"name="category" value="${category.id}">
                                                <label for="category-${count.index}"><span></span>${category.name}</label>
                                                <!-- <span class="count">88</span> -->
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>

                    </div>

                    <div class="filter-style-1">
                        <div class="filter-title">
                            <h4 class="title">Filter</h4>
                        </div>
                        <div class="filter-btn">
                            <a class="main-btn primary-btn" onclick="sendFilter()">Reset</a>
                        </div>
                    </div>

                </div>


                <div class="col-md-7 col-lg-9  products-column" style="margin: 10px auto;" id="products-column">

<%--                    HOLD ALL PRODUCTS--%>
                    <div class="row ">
                            <c:forEach var="product" items="${prods}" >
                                <div class="col-lg-4 col-md-6">
                                    <div class="product-style-17 mt-30" style="padding: 5px">
                                        <div class="product-image shop-prod-img"
                                                 id="shop-prod-img"
                                                 style='background-image: url("${product.imgUrl}")'>
                                                <a href="prod-detail?prodId=${product.id}"></a>
                                        </div>
                                        <div class="product-content text-center">
                                            <h4 class="title"><a href="prod-detail?prodId=${product.id}">${product.name}</a></h4>
                                            <p style="color:#161358;">$ ${product.price}</p>
                                            <a  href="prod-detail?prodId=${product.id}" class="main-btn primary-btn-text explore-btn">Explore <i class="mdi mdi-chevron-right"></i></a>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>

                    </div>

<%--                    FOR PAGINATION--%>
                    <div class="row " style="padding: 10px">
                        <nav aria-label="Page navigation example " style="margin:20px auto; ">
                            <ul class="pagination justify-content-center ">

                                <c:forEach varStatus="page" begin="1" end="${paginationSize}">

                                    <li class="page-item ${page.isFirst()? 'active': ''} active">
                                        <a class="page-link " href="#">${page.index}</a>
                                    </li>

                                </c:forEach>


<%--                                <li class="page-item active"><a class="page-link " href="#">1</a></li>--%>

<%--                                <li class="page-item"><a class="page-link" href="#">2</a></li>--%>

<%--                                <li class="page-item"><a class="page-link" href="#">3</a></li>--%>

                            </ul>
                        </nav>
                    </div>

                </div>
            </div>
        </div>
    </section>

    <!--====== Filter Part Ends ======-->

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


<script>

    function sendFilter(){

        var selectedCategories = [];
        var minPrice = $('#minAmount').val();
        var maxPrice = $('#maxAmount').val();

        $.each( $("input[name='category']:checked"), function (){
            selectedCategories.push( $(this).val() );
        } );

        console.log(selectedCategories);
        console.log(minPrice);
        console.log(maxPrice);

        var filterCriteria = new Object()
        filterCriteria.minPrice = minPrice;
        filterCriteria.maxPrice = maxPrice;
        filterCriteria.categories = selectedCategories;

        var jsonFilterCriteria = JSON.stringify(filterCriteria);
        console.log(jsonFilterCriteria);



        $.get("shop?filter="+jsonFilterCriteria);


    }


</script>


    <script>
        // ========= Pricing range slider one
        var stepsSlider = document.getElementById('slider-range');
        var input0 = document.getElementById('minAmount');
        var input1 = document.getElementById('maxAmount');
        var inputs = [input0, input1];
        noUiSlider.create(stepsSlider, {
            start: [0, ${maxPrice}],
            connect: true,
            step: 1,
            range: {
                'min': [0],
                'max': ${maxPrice}
            },

        });

        stepsSlider.noUiSlider.on('update', function (values, handle) {
            inputs[handle].value = values[handle];
        });

        // ========= Pricing range slider two
        var stepsSlider2 = document.getElementById('slider-range2');
        var input3 = document.getElementById('minAmount2');
        var input4 = document.getElementById('maxAmount2');
        var inputs2 = [input3, input4];
        noUiSlider.create(stepsSlider2, {
            start: [200, 1200],
            connect: true,
            step: 1,
            range: {
                'min': [0],
                'max': 2000
            },

        });

        stepsSlider2.noUiSlider.on('update', function (values, handle) {
            inputs2[handle].value = values[handle];
        });

        
        // =========== filter size active
        elements = document.querySelectorAll("#filter-size-1 ul li");
        for (var i = 0; i < elements.length; i++) {
            elements[i].onclick = function () {
                var el = elements[0];
                while (el) {
                    if (el.tagName === "LI") {
                        el.classList.remove("active");
                    }
                    el = el.nextSibling;
                }
                this.classList.add("active");
            };
        }

    </script>

</body>

</html>