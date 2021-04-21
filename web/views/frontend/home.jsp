<%-- 
    Document   : home
    Created on : May 29, 2019, 8:19:02 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/pagination_tag" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<jsp:include page="navbar.jsp" flush="true"></jsp:include>
<jsp:include page="banner.jsp" flush="true"></jsp:include>
    <!-- top-brands -->
    <div class="top-brands">
        <div class="container">
            <h3 style="margin-top: -15px;">Top sản phẩm đang khuyến mãi</h3>
            <div class="agile_top_brands_grids">
            <c:forEach items="${listOfferP}" var="b">
                <%--<c:if test="${b.productDiscount>0}">--%>
                    <div class="col-md-3 top_brand_left" style="margin-bottom: 15px;">
                        <div class="hover14 column">
                            <div class="agile_top_brand_left_grid">
                                ${b.productDiscount>0?'<div class="agile_top_brand_left_grid_pos"><img src="/BooksOnline/views/frontend/assets/images/offer.png" alt=" " class="img-responsive" /></div>':''}
                                <div class="agile_top_brand_left_grid1">
                                    <figure>
                                        <div class="snipcart-item block" >
                                            <div class="snipcart-thumb">
                                                <a href="${pageContext.request.contextPath}/client/productById.htm?proId=${b.productId}&auId=${b.authorId.authorId}&cateId=${b.categoryId.categoryId}&countryId=${b.countryId.countryId}&pubId=${b.publisherId.publisherId}"><img title=" " alt=" " src="${pageContext.request.contextPath}/views/frontend/assets/images/${b.productFeatureImage}" /></a>		
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
                <%--</c:if>--%>
            </c:forEach>
            <div class="clearfix"> </div>

        </div>
    </div>
</div>
<!-- //top-brands -->

<!-- top-brands -->
<div class="top-brands" style="margin-top: -70px;">
    <div class="container">
        <h3 style="margin-top: -15px;">Sản phẩm mới nhất</h3>
        <div class="agile_top_brands_grids">
            <c:forEach items="${listNewP}" var="b">
                <div class="col-md-3 top_brand_left" style="margin-bottom: 15px;">
                    <div class="hover14 column">
                        <div class="agile_top_brand_left_grid">
                            ${b.productDiscount>0?'<div class="agile_top_brand_left_grid_pos"><img src="/BooksOnline/views/frontend/assets/images/offer.png" alt=" " class="img-responsive" /></div>':''}
                            <div class="agile_top_brand_left_grid1">
                                <figure>
                                    <div class="snipcart-item block" >
                                        <div class="snipcart-thumb">
                                            <a href="${pageContext.request.contextPath}/client/productById.htm?proId=${b.productId}&auId=${b.authorId.authorId}&cateId=${b.categoryId.categoryId}&countryId=${b.countryId.countryId}&pubId=${b.publisherId.publisherId}"><img title=" " alt=" " src="${pageContext.request.contextPath}/views/frontend/assets/images/${b.productFeatureImage}" /></a>		
                                            <p class="text-center">${b.productName}</p>
                                            <h4 class="text-center"><fmt:formatNumber value="${b.productDiscount>0?b.productDiscount:b.productPrice}" type="currency"></fmt:formatNumber> <span><fmt:formatNumber value="${b.productDiscount>0?b.productPrice:null}" type="currency"></fmt:formatNumber> </span></h4>
                                            </div>
                                            <div class="snipcart-details top_brand_home_details">
                                                <form method="get" action="addCart.htm" enctype="multipart/form-data">

                                                    <input type="hidden" name="quantity" value="1">
                                                        <input type="hidden" name="id" value="${b.productId}">
                                                <button ${b.productQuantity==0||b.productQuantity==null?'disabled=""':''} class="btn-transparent pull-left" type="submit">Thêm vào giỏ</button>


                                            </form>
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
        </div>
    </div>
</div>
<!-- //top-brands -->

<jsp:include page="footer.jsp" flush="true"></jsp:include>
