<%-- 
    Document   : searchPro
    Created on : Jul 5, 2019, 2:25:50 AM
    Author     : Hide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@taglib prefix="tag" uri="/WEB-INF/tlds/pagination_tag" %>--%>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/pagin_order_detail_tag" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>


    <!-- script-for sticky-nav -->
    <script>
        $(document).ready(function () {
            var navoffeset = $(".header-main").offset().top;
            $(window).scroll(function () {
                var scrollpos = $(window).scrollTop();
                if (scrollpos >= navoffeset) {
                    $(".header-main").addClass("fixed");
                } else {
                    $(".header-main").removeClass("fixed");
                }
            });

        });
    </script>
    <!-- /script-for sticky-nav -->
    <!--inner block start here-->
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <h2>Sản Phẩm</h2>
            <a href="${pageContext.request.contextPath}/admin/initInsertProduct.htm" class="themmoi" style="float: right; margin-bottom: 10px;" >
            <button type="button" class="btn btn-primary">Thêm mới</button>
        </a>
        <table class="table table-striped table-hover table-bordered table-borderless">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Sản Phẩm</th>
                    <th>Ngày Thêm</th>	
                    <th>Ảnh Đại Diện</th>
                    <th>Tác Giả</th>
                    <!--<th>Nhà Xuất Bản</th>-->	
                    <th hidden="">Quốc gia</th>	
                    <th hidden="">Danh Mục</th>	
                    <th>Giá Hiện Tại</th>
                    <!--<th>Số lượng</th>-->
                    <!--<th>Mô Tả</th>-->
                    <th>Trạng Thái</th>
                    <th></th>
                    <!--                        <th></th>
                                            <th></th>-->
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listP}" var="p" varStatus="i">
                    <tr>
                        <td>${i.index+1+offset}</td>
                        <td>${p.productName}</td>
                        <td><fmt:formatDate value="${p.productAddedTime}"></fmt:formatDate></td>
                        <td><img class="product-image" title=" " alt=" " src="${pageContext.request.contextPath}/views/frontend/assets/images/${p.productFeatureImage}" /></td>
                        <td>${p.authorId.authorName}</td>
                        <!--<td>${p.publisherId.publisherName}</td>-->
                        <td hidden="">${p.countryId.countryName}</td>
                        <td hidden="">${p.categoryId.categoryName}</td>
                        <td><fmt:formatNumber value="${p.productDiscount>0?p.productDiscount:p.productPrice}" type="currency"></fmt:formatNumber></td>
                        <!--<td>${p.productQuantity>0?p.productQuantity:"Đã hết"}</td>-->
                        <!--<td class="text-center">${p.productDescription}</td>-->
                        <td><span class="${p.productStatus?"label label-success":"label label-info"}">${p.productStatus?"Active":"Inactive"}</span></td>

                        <td>
                            <div class="col-sm-4">
                                <a href="${pageContext.request.contextPath}/admin/detailProduct.htm?productId=${p.productId}"> 
                                    <button type="button" class="btn btn-info">
                                        <i class="glyphicon glyphicon-zoom-in">	
                                        </i>
                                    </button>
                                </a>
                            </div>
                            <!--</td>-->
                            <!--<td>-->
                            <div class="col-sm-4">
                                <a href="${pageContext.request.contextPath}/admin/preUpdateProduct.htm?productId=${p.productId}">
                                    <button type="button" class="btn btn-success">
                                        <i class="glyphicon glyphicon-wrench">	
                                        </i>
                                    </button>
                                </a>
                            </div>
                            <!--</td>-->
                            <!--<td>-->	
                            <div class="col-sm-4">
                                <a href="${pageContext.request.contextPath}/admin/delProduct.htm?productId=${p.productId}">
                                    <button type="button" class="btn btn-warning" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">
                                        <i class="glyphicon glyphicon-trash">
                                        </i>
                                    </button>
                                </a>
                            </div>
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <%--<tag:PaginationHandle count="${total}" uri="searchPro.htm" offset="${offset}" steps="8" next="&raquo;" previous="&laquo;"/>--%>
        <tag:PaginOderDetail count="${total}" uri="searchPro.htm?name=${key}" offset="${offset}" steps="8" next="&raquo;" previous="&laquo;"/>
    </div>	
</div>
<!--main page chart layer2-->

<!--climate start here-->
<!--climate end here-->
<!--</div>-->
<!--inner block end here-->

<jsp:include page="menu.jsp" flush="true"></jsp:include>