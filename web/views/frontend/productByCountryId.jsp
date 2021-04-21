<%-- 
    Document   : productByCountryId
    Created on : Jun 9, 2019, 3:43:41 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/pagination_tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
     <!-- products-breadcrumb -->
	<div class="products-breadcrumb">
		<div class="container custom-breadcrumb">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/client/home.htm">Trang chủ</a><span>|</span></li>
				<li>Sản Phẩm</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->
<jsp:include page="navbar.jsp" flush="true"></jsp:include>
<%--<jsp:include page="banner.jsp" flush="true"></jsp:include>--%>



<div class="w3l_banner_nav_right">
    <div class="w3ls_w3l_banner_nav_right_grid">
        <!--<h3 style="margin-top:30px;">Sản Phẩm</h3>-->
        <div class="w3ls_w3l_banner_nav_right_grid1" style="padding:10px 30px">
            <h6 style="margin-left: 30px">Danh sách sản phẩm</h6>
            <c:forEach items="${pByCountryId}" var="b">
                <div class="col-md-3 top_brand_left" style="margin-bottom: 15px; padding:0px 20px;">
                    <div class="hover14 column">
                        <div class="agile_top_brand_left_grid">
                             ${b.productDiscount>0?'<div class="agile_top_brand_left_grid_pos"><img src="/BooksOnline/views/frontend/assets/images/offer.png" alt=" " class="img-responsive" /></div>':''}
                            <div class="agile_top_brand_left_grid1">
                                <figure>
                                    <div class="snipcart-item block" >
                                        <div class="snipcart-thumb">
                                            <a href="${pageContext.request.contextPath}/client/productById.htm?proId=${b.productId}&auId=${b.authorId.authorId}&cateId=${b.categoryId.categoryId}&countryId=${b.countryId.countryId}&pubId=${b.publisherId.publisherId}"><img title=" " alt=" " src="/BooksOnline/views/frontend/assets/images/${b.productFeatureImage}" /></a>		
                                            <p class="text-center">${b.productName}</p>
                                            <h4 class="text-center"><fmt:formatNumber value="${b.productDiscount>0?b.productDiscount:b.productPrice}" type="currency"></fmt:formatNumber> <span><fmt:formatNumber value="${b.productDiscount>0?b.productPrice:null}" type="currency"></fmt:formatNumber> </span></h4>
                                        </div>
                                        <div class="snipcart-details top_brand_home_details">
                                            <form method="get" action="addCart.htm" enctype="multipart/form-data">

                                                        <input type="hidden" name="quantity" value="1">
                                                            <input type="hidden" name="id" value="${b.productId}">
                                                    <button ${b.productQuantity==0||b.productQuantity==null?'disabled=""':''} class="btn-transparent pull-left" type="submit">Thêm vào giỏ</button>


                                                </form>
                                        </div>
                                    </div>
                                </figure>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <div class="clearfix"> </div>
            <div class="text-center">
                <tag:PaginationHandle count="${total}" uri="productByCountryId.htm" offset="${offset}" steps="8" next="&raquo;" previous="&laquo;"/>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
</div>

<jsp:include page="footer.jsp" flush="true"></jsp:include>
