<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">

    <!--====== Title ======-->
    <title>Product</title>

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--====== Favicon Icon ======-->
    <link rel="shortcut icon" href="../assets/images/favicon.png" type="image/png">

    <!--====== Tiny Slider CSS ======-->
    <link rel="stylesheet" href="../assets/css/tiny-slider.css">

    <!--====== Line Icons CSS ======-->
    <link rel="stylesheet" href="../assets/css/LineIcons.css">

    <!--====== Material Design Icons CSS ======-->
    <link rel="stylesheet" href="../assets/css/materialdesignicons.min.css">

    <!--====== FONT Awesome Icons CSS ======-->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
          crossorigin="anonymous" />

    <!--====== Bootstrap CSS ======-->
    <link rel="stylesheet" href="../assets/css/bootstrap-5.0.0-beta1.min.css">

    <!--====== gLightBox CSS ======-->
    <link rel="stylesheet" href="../assets/css/glightbox.min.css">

    <!--====== nouiSlider CSS ======-->
    <link rel="stylesheet" href="../assets/css/nouislider.min.css">

    <!--====== Default CSS ======-->
    <link rel="stylesheet" href="../assets/css/default.css">

    <!--====== Temp CSS ======-->
    <link rel="stylesheet" href="../assets/css/tempstyle.css">

    <!-- =======Style CSS ============ -->
    <link rel="stylesheet" href="../assets/css/style.css">

    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>

</head>

<body>


    <!--====== Product Details Style 2 Part Start ======-->

    <c:set var = "product" scope="request" value="${requestScope.product}"/>
    <c:set var = "prodAdded" scope="request" value="${requestScope.prodAdded}"/>
    <!--======================== Navbar  Starts ====================================-->
    <c:set var="userId" value="${sessionScope.userId}" scope="session"/>
    <jsp:include page="../navbar.jsp"/>
    <!--======================== Navbar  Ends ====================================-->

    <c:if test="${prodAdded != null}">
        <div class="container" style="text-align: center;margin: 10px auto;">
            <div class="alert alert-success" role="alert">
                Product Added to Cart
                <br>
                <a href="${pageContext.request.contextPath}/shop" type="button" class="main-btn primary-btn"style="margin-left: 20px" >
                    Continue Shopping
                </a>
            </div>
        </div>


    </c:if>


    <section class="product-details-wrapper mt-30 pt-70 pb-100">
        <div class="container">
            <div class="product-details-style-2">
                <div class="product-details-content text-center">
                    <h2 class="title">${product.prodName}</h2>
<%--                    <p class="sub-title">Experience VR that’s portable and easy to use.</p>--%>
                </div>

                <div class="row">
                    <div class="col-lg-6">
                        <div class="product-details-image mt-50">
                            <div class="product-image">
                                <div class="product-image-active tab-content" id="v-pills-tabContent-2">


                                    <c:forEach var="prodImg" items="${product.prodImages}" varStatus="counter" begin="0"  end="${product.prodImages.size()-1}">

                                        <div class="single-image tab-pane fade ${counter.isFirst()? ' show active ' : ''}"  id="v-pills-${counter.index}" role="tabpanel"
                                             aria-labelledby="v-pills-${counter.index}-tab">
                                            <img class="img-fluid" src="${prodImg}" alt="">
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>
                            <div class="product-thumb-image">

                                <div class="product-thumb-image-active nav nav-pills" id="v-pills-tab-2" role="tablist"
                                    aria-orientation="vertical">
                                    <c:forEach var="prodImg" items="${product.prodImages}" varStatus="counter" begin="0"  end="${product.prodImages.size()-1}">
                                        <div class="single-thumb ${counter.isFirst()? 'active':''}" id="v-pills-${counter.index}-tab" data-bs-toggle="pill"
                                             href="#v-pills-${counter.index}" role="tab" aria-controls="v-pills-${counter.index}" aria-selected="true">
                                            <img src="${prodImg}" alt="">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="product-details-content mt-45">

                            <div class="product-items flex-wrap">
                                <h6 class="item-title"> Description: </h6><br>
                                <p class="prod-description">
                                    ${product.prodDescription}
                                </p>

                            </div>

                            <div class="product-select-wrapper flex-wrap">

                                <div class="select-item">
                                    <h6 class="select-title">Select Quantity: </h6>

                                    <div class="select-quantity">
                                        <button type="button" id="sub" class="sub"><i
                                                class="mdi mdi-minus" onclick="subQuantity()"></i></button>
                                        <input id="prod-quantity" type="text" value="1" disabled/>
                                        <button type="button" id="add" class="add" onclick="addQuantity()"><i class="mdi mdi-plus"></i></button>

                                    </div>
                                </div>
<%--                                <p style="color: #4726CA">In Stock: <span id="stock">${product.quantity}</span> </p>--%>
                            </div>

                            <div class="product-price">
                                <h6 class="price-title">Price: </h6>
                                <p class="sale-price">$ ${product.price} USD</p>
<%--                                <p class="regular-price">$ 179 USD</p>--%>
                            </div>

                            <div class="product-btn">
                                <a class="main-btn primary-btn" onclick="addProdToCart(${product.id})"><img src="../assets/images/icon-svg/cart-4.svg"
                                        alt=""> Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!--====== Product Details Style 2 Part Ends ======-->

    <%--============ FOOTER =============--%>
    <jsp:include page="../footer.jsp"/>
    <%--============ FOOTER END =============--%>



    <!--=========================================Scripts=====================================-->

    <!--====== Bootstrap js ======-->
    <script src="../assets/js/bootstrap.bundle-5.0.0-beta1.min.js"></script>

    <!--====== Tiny Slider js ======-->
    <script src="../assets/js/tiny-slider.js"></script>

    <!--====== nouiSlider js ======-->
    <script src="../assets/js/nouislider.min.js"></script>

    <!--====== count up js ======-->
    <script src="../assets/js/count-up.min.js"></script>

    <!--====== gLightBox js ======-->
    <script src="../assets/js/glightbox.min.js"></script>

    <!--====== Main js ======-->
    <script src="../assets/js/main.js"></script>

    <%--=======CART SCRIPT======--%>
    <script src="../assets/js/cart.js"></script>


    <script>

        function addProdToCart(prodId){

            var addedQuantity = $("#prod-quantity").val();

            $.post("cartedit?edit=addNew&prodId="+prodId+"&qty="+addedQuantity, function (data){
                // console.log(data);
                // var host = window.location.host;
                // console.log(host)
                //
                // $(location).attr('href', host+"/"+data);
                // location.reload();
                console.log(data);

                if( data.includes( "partial-response") ){
                    console.log("EDELO");
                    rgx = /url="(.*)"/;
                    var arr = rgx.exec(data);
                    console.log(arr[1]);
                    var host = window.location.protocol + "//" + window.location.host;
                    location.href = host + arr[1];
                }else {
                    if (location.href.endsWith("added=")){
                        location.href = location.href + "";
                        console.log("Added yasta 5las");
                    }else {
                        location.href = location.href + "&added=";
                    }
                }

            });
        }


        // =========== select-item-2 active
        selectItem2 = document.querySelectorAll("#select-item-2 .single-item");
        for (var i = 0; i < selectItem2.length; i++) {
            selectItem2[i].onclick = function () {
                var el = selectItem2[0];
                while (el) {
                    if (el.tagName === "DIV") {
                        el.classList.remove("active");
                    }
                    el = el.nextSibling;
                }
                this.classList.add("active");
            };
        }


        function addQuantity() {

            var quantityInput = document.getElementById("prod-quantity");

            var quantity = quantityInput.value;

            if (isNaN(quantity) || quantityInput.value < 1) {
                quantityInput.value = 1;
                return;
            }

            // if(quantityInput.value >= 10) {
            //     quantityInput.value = 10;
            //     return;
            // }

            quantity++;

            quantityInput.value = quantity;

        }


        function subQuantity() {

            var quantityInput = document.getElementById("prod-quantity");

            var quantity = quantityInput.value;

            if (isNaN(quantity) || quantityInput.value <=1){
                quantityInput.value = 1;
                return;
            }

            // if(quantityInput.value >= 10) {
            //     quantityInput.value = 10;
            //     return;
            // }

            quantity--;

            quantityInput.value = quantity;
        }


        // ==================Inc Dec Quantity
    </script>

</body>

</html>