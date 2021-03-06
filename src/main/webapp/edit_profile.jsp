<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">

    <!--====== Title ======-->
    <title>EditProfile</title>

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

    <!--====== FONT Awesome Icons CSS ======-->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
          crossorigin="anonymous" />

    <!--====== Bootstrap CSS ======-->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">

    <!--====== gLightBox CSS ======-->
    <link rel="stylesheet" href="assets/css/glightbox.min.css">

    <!--====== nouiSlider CSS ======-->
    <link rel="stylesheet" href="assets/css/nouislider.min.css">

    <!--====== Default CSS ======-->
    <link rel="stylesheet" href="assets/css/default.css">

    <!--====== Template Style CSS ======-->
    <link rel="stylesheet" href="assets/css/tempstyle.css">

    <!--====== Template Style CSS ======-->
    <link rel="stylesheet" href="assets/css/style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <style>
     #avatar:hover{
         cursor: pointer;
     }
    </style>
    <script type="text/javascript">

        $("#btnSubmit").click(function (event) {

            // Fetch form to apply custom Bootstrap validation
            var form = $("#myForm")

            if (form[0].checkValidity() === false) {
                event.preventDefault()
                event.stopPropagation()
            }

            // Perform ajax submit here...

        });

    </script>
</head>

<body>

<!--====== Header ======-->
<c:set var="userId" value="${sessionScope.userId}" scope="session"/>
<jsp:include page="./navbar.jsp"/>
<!--====== Header======-->

<!--====== Profile Start ======-->

<section class="profile-wrapper pt-100 pb-100">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-9">
                <div class="profile">
                    <div class="profile-header">
                        <div class="profile-cover-photo bg_cover" hidden></div>
                        <div class="profile-author d-sm-flex flex-row-reverse justify-content-between align-items-end">
                            <div class="profile-photo">
                                <img id="avatar" src="<c:out value="${customerDto.url}"/>" alt="Profile Photo">
                                <input id="ajaxfile" type="file" accept="image/*" style="display:none"/> <br/>
                                <%--                                <button onclick="uploadFile()"> Change </button>--%>
                                <%--                                <button class="btn btn-primary" type="button" id="customFileInput">Upload</button>--%>

                            </div>
                            <div class="profile-name">
                                <h4 class="name"><c:out value="${customerDto.name}"/></h4>
                            </div>
                        </div>
                    </div>
                    <div class="profile-body">
                        <div class="profile-title">
                            <h5 class="title">Personal Details</h5>

                        </div>

                        <div class="profile-details">
                            <form action="editprofile" method="post" class="was-validated">
                                <div class="form-group">
                                    <div class="single-details-item d-flex flex-wrap">
                                        <div class="details-title">
                                            <h6 class="title">User Full Name:</h6>
                                        </div>
                                        <div class="details-content media-body">
                                            <input type="text" id="name" name="name" class="form-control" required
                                                   value='<c:out value="${customerDto.name}"/>'/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="single-details-item d-flex flex-wrap">
                                        <div class="details-title">
                                            <h6 class="title">Email:</h6>
                                        </div>
                                        <div class="details-content media-body">
                                            <input type="email" id="email" name="email" class="form-control" required
                                                   value="<c:out value="${customerDto.email}"/>"/>
                                            <div class="invalid-feedback">Invalid Email address</div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="single-details-item d-flex flex-wrap">
                                        <div class="details-title">
                                            <h6 class="title">Password</h6>
                                        </div>
                                        <div class="details-content media-body">
                                            <input type="password" id="password" pattern=".{6,}" name="password"
                                                   class="form-control" required
                                                   value="<c:out value="${customerDto.password}"/>"/>
                                            <div class="invalid-feedback">Must be at least 6 characters long</div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="single-details-item d-flex flex-wrap">
                                        <div class="details-title">
                                            <h6 class="title">Phone:</h6>
                                        </div>
                                        <div class="details-content media-body">
                                            <input type="text" id="phone" pattern="^(011|015|012|010)[0-9]{8}"
                                                   name="phone" class="form-control" required
                                                   value="<c:out value="${customerDto.phone}"/>"/>
                                            <div class="invalid-feedback">Invalid phone number</div>

                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="single-details-item d-flex flex-wrap">
                                        <div class="details-title">
                                            <h6 class="title">Address:</h6>
                                        </div>
                                        <div class="details-content media-body">
                                            <input type="text" id="address" name="address" class="form-control" required
                                                   value="<c:out value="${customerDto.address}"/>"/>
                                        </div>
                                    </div>
                                </div>
                                </br></br>
                                <input type="submit" class="btn btn-primary" value="Save" id="btnSubmit">
                            </form>

                            <c:if test="${not empty requestScope.success}">
                                </br>
                                <c:choose>
                                    <c:when test="${requestScope.success}">
                                        <div class="alert alert-success" role="alert">
                                            Your account updates have been saved
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="alert alert-danger" role="alert">
                                            We couldn???t save your changes.
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </div>

                    </div>


                </div>
            </div>
        </div>
    </div>
</section>

<!--====== Profile Ends ======-->

<%--============ FOOTER =============--%>
<jsp:include page="./footer.jsp"/>
<%--============ FOOTER END =============--%>



<!--====== Bootstrap js ======-->
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="assets/js/bootstrap.bundle-5.0.0-beta1.min.js"></script>

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


<!-- Ajax to Java File Upload Logic -->
<script>

    $(document).ready(function () {
        $('#avatar').on('click', function () {
            $('#ajaxfile').trigger('click');
        });
        $("#ajaxfile").on('change', function () {
            //do whatever you want
            uploadFile();
        });
    });

    async function uploadFile() {
        let formData = new FormData();
        if (ajaxfile.files[0] != null) {
            formData.append("file", ajaxfile.files[0]);
            let response = await fetch('ChangeAvatarServlet', {

                method: "POST",
                body: formData
            });

            let result = await response.json();

            $("#avatar").attr("src", result.message);
        }
    }

</script>

<%--=======CART SCRIPT======--%>
<script src="./assets/js/cart.js"></script>


</body>

</html>