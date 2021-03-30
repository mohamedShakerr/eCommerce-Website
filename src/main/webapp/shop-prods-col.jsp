<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="prods" value="${requestScope.products}"  scope="request"/>
<c:set var="paginationSize" value="${requestScope.NumberOfPages}" scope="request"/>

<%--================ HOLD ALL PRODUCTS--%>
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

<%--================ FOR PAGINATION--%>
<div class="row " style="padding: 10px">
    <nav aria-label="Page navigation example " style="margin:20px auto; ">
        <ul class="pagination justify-content-center ">

            <c:forEach varStatus="page" begin="1" end="${paginationSize}">

                <li class="page-item ${page.isFirst()? 'active': ''} ">
                    <a class="page-link" onclick="">${page.index}</a>
                </li>

            </c:forEach>


            <%--                                <li class="page-item active"><a class="page-link " href="#">1</a></li>--%>

            <%--                                <li class="page-item"><a class="page-link" href="#">2</a></li>--%>

            <%--                                <li class="page-item"><a class="page-link" href="#">3</a></li>--%>

        </ul>
    </nav>
</div>
