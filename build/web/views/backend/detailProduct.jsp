<%-- 
    Document   : detailProduct
    Created on : Jul 2, 2019, 3:14:19 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <div id="rightContent">
                <h2>Chi tiết sản phẩm</h2>



                <br/>
                <table width="90%" border="1px">
                    <tr>
                        <td><b>Tên Sách: </b></td>
                        <td>${p.productName}</td>
                </tr>
                <tr>
                    <td><b>Ngày thêm: </b></td>
                    <td><fmt:formatDate value="${p.productAddedTime}"></fmt:formatDate></td>
                    </tr>

                    <tr>
                        <td><b>Ảnh đại diện: </b></td>
                        <td><img class="product-image" title=" " alt=" " src="${pageContext.request.contextPath}/views/frontend/assets/images/${p.productFeatureImage}" /></td>
                </tr>

                <tr>
                    <td><b>Tác giả: </b></td>
                    <td>${p.authorId.authorName}</td>
                </tr>

                <tr>
                    <td><b>Nhà xuất bản: </b></td>
                    <td>${p.publisherId.publisherName}</td>
                </tr>
                <tr>
                    <td><b>Quốc gia: </b></td>
                    <td>${p.countryId.countryName}</td>
                </tr>
                <tr>
                    <td><b>Danh mục: </b></td>
                    <td>${p.categoryId.categoryName}</td>
                </tr>

                <tr>
                    <td><b>Số lượng: </b></td>
                    <td>${p.productQuantity>0?p.productQuantity:"Đã hết"}</td>
                </tr>
                
                <tr>
                    <td><b>Mô tả: </b></td>
                    <td><p>${p.productDescription}</p></td>
            </tr>
            
            <tr>
                <td><b>Trạng thái: </b></td>						
                <td><span class="${p.productStatus?"label label-success":"label label-info"}">${p.productStatus?"Active":"Inactive"}</span></td>
            </tr>
            </table>
            <button class="btn btn-info" type="reset" style="margin: 20px 0 20px 30px"><a style="color:#FFF" href="${pageContext.request.contextPath}/admin/product.htm">Back to list</a></button>
        </div>
        <div class="clear"></div>
    </div>	
</div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>

