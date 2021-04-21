<%-- 
    Document   : productById
    Created on : Jun 11, 2019, 11:20:25 AM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <!-- products-breadcrumb -->
    <div class="products-breadcrumb">
        <div class="container custom-breadcrumb">
            <ul>
                <li><i class="fa fa-home" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/client/home.htm">Trang chủ</a><span>|</span></li>
            <li>Xem Chi Tiết</li>
        </ul>
    </div>
</div>
<!-- //products-breadcrumb -->
<jsp:include page="navbar.jsp" flush="true"></jsp:include>


    <div class="w3l_banner_nav_right">
        <!-- <div class="w3l_banner_nav_right_banner3">
                <h3>Best Deals For New Products<span class="blink_me"></span></h3>
        </div> -->
        <div class="agileinfo_single">
            <div class="col-md-12">
                <h5 style="color: red;" class="col-md-4 text-center">${single.productName}</h5>
            <span class="col-md-8"></span>
        </div>
        <div class="col-md-4 agileinfo_single_left">
            <img id="example" src="/BooksOnline/views/frontend/assets/images/${single.productFeatureImage}" alt=" " class="img-responsive" />
        </div>
        <div class="col-md-8 agileinfo_single_right single-right" style="margin-top: -67px;">
            <!-- <div class="rating1">
                    <span class="starRating">
                            <input id="rating5" type="radio" name="rating" value="5">
                            <label for="rating5">5</label>
                            <input id="rating4" type="radio" name="rating" value="4">
                            <label for="rating4">4</label>
                            <input id="rating3" type="radio" name="rating" value="3" checked>
                            <label for="rating3">3</label>
                            <input id="rating2" type="radio" name="rating" value="2">
                            <label for="rating2">2</label>
                            <input id="rating1" type="radio" name="rating" value="1">
                            <label for="rating1">1</label>
                    </span>
            </div> -->
            <div class="w3agile_description">
                <h4>Thông tin chi tiết :</h4>
                <p class="p-author">Tác giả: <a href="${pageContext.request.contextPath}/client/productByAuthorId.htm?auId=${single.authorId.authorId}"><span>${single.authorId.authorName}</span></a></p>
                <p class="p-publisher">Nhà xuất bản: <a href="${pageContext.request.contextPath}/client/productByPublisherId.htm?pubId=${single.publisherId.publisherId}"><span>${single.publisherId.publisherName}</span></a></p>
                <p class="p-publisher">Quốc gia: <a href="${pageContext.request.contextPath}/client/productByCountryId.htm?countryId=${single.countryId.countryId}"><span>${single.countryId.countryName}</span></a></p>

                <p>${single.productDescription}</p>
            </div>
            <div class="snipcart-item block">
                <div class="snipcart-thumb agileinfo_single_right_snipcart">
                    <h4><fmt:formatNumber value="${single.productDiscount>0?single.productDiscount:single.productPrice}" type="currency"></fmt:formatNumber> <span><fmt:formatNumber value="${single.productDiscount>0?single.productPrice:null}" type="currency"></fmt:formatNumber></span></h4>
                    </div>

                    <div class="snipcart-thumb agileinfo_single_right_snipcart">
                            <h4><p style="color: red;">${quanMes}</p></h4>
                </div>



                <div class="snipcart-details agileinfo_single_right_details">
                    <form action="addCart.htm" method="get">
                        <ul class="form-addtocart" style="width: 500px;">
                            <li><input style="width: 70px;" type="number" name="quantity" id="quantity" value="1" min="1" class="form-control" step required="required" title="Số lượng cần đặt mua" /></li>
                            <li><input type="hidden" name ="id" id="Id" value="${single.productId}" ></li>
                            <li><input type="hidden" name ="cateId" id="cateId" value="${single.categoryId.categoryId}" ></li>
                            <li><input ${single.productQuantity>0||single.productQuantity!=null?'':'disabled=""'} style="width: 130px;" type="submit" value="Thêm vào giỏ" class="button" /></li>
                            <li><span class="book-able" style="color: red; font-size: 24px;">${single.productQuantity>0?"":"Đã hết hàng!"}</span></li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<div class="clearfix"></div>
</div>
<!-- //banner -->
<!-- brands -->
<div class="w3ls_w3l_banner_nav_right_grid w3ls_w3l_banner_nav_right_grid_popular">
    <div class="container">
        <h3>Sản phẩm liên quan</h3>
        <div class="w3ls_w3l_banner_nav_right_grid1">
            <!--<h6>Cùng tác giả</h6>-->
            <c:forEach items="${relaCate}" var="b">
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


        <!--        <div class="w3ls_w3l_banner_nav_right_grid1">
                    <h6>Cùng danh mục</h6>
        <c:forEach items="${relaCate}" var="b">
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
                                <form action="checkout.html" method="post">
                                    <fieldset>
                                        <input type="hidden" name="cmd" value="_cart" />
                                        <input type="hidden" name="add" value="1" />
                                        <input type="hidden" name="business" value=" " />
                                            <input type="hidden" name="item_name" value="${b.productName}" />
                                    <input type="hidden" name="amount" value="${b.productDiscount>0?b.productDiscount:b.productPrice}" />
                                    <input type="hidden" name="discount_amount" value="${b.productDiscount>0?b.productPrice-b.productDiscount:0}" />
                                    <input type="hidden" name="currency_code" value="đ" />
                                    <input type="hidden" name="return" value=" " />
                                    <input type="hidden" name="cancel_return" value=" " />
                                    <input type="submit" name="submit" value="Thêm vào giỏ" class="button" />
                                </fieldset>
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
    
    <div class="w3ls_w3l_banner_nav_right_grid1">
        <h6>Cùng quốc gia</h6>
        <c:forEach items="${relaCountry}" var="b">
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
                                <form action="checkout.html" method="post">
                                    <fieldset>
                                        <input type="hidden" name="cmd" value="_cart" />
                                        <input type="hidden" name="add" value="1" />
                                        <input type="hidden" name="business" value=" " />
                                            <input type="hidden" name="item_name" value="${b.productName}" />
                                    <input type="hidden" name="amount" value="${b.productDiscount>0?b.productDiscount:b.productPrice}" />
                                    <input type="hidden" name="discount_amount" value="${b.productDiscount>0?b.productPrice-b.productDiscount:0}" />
                                    <input type="hidden" name="currency_code" value="đ" />
                                    <input type="hidden" name="return" value=" " />
                                    <input type="hidden" name="cancel_return" value=" " />
                                    <input type="submit" name="submit" value="Thêm vào giỏ" class="button" />
                                </fieldset>
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
    
    <div class="w3ls_w3l_banner_nav_right_grid1">
        <h6>Cùng nhà xuất bản</h6>
        <c:forEach items="${relaPub}" var="b">
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
                                <form action="checkout.html" method="post">
                                    <fieldset>
                                        <input type="hidden" name="cmd" value="_cart" />
                                        <input type="hidden" name="add" value="1" />
                                        <input type="hidden" name="business" value=" " />
                                            <input type="hidden" name="item_name" value="${b.productName}" />
                                    <input type="hidden" name="amount" value="${b.productDiscount>0?b.productDiscount:b.productPrice}" />
                                    <input type="hidden" name="discount_amount" value="${b.productDiscount>0?b.productPrice-b.productDiscount:0}" />
                                    <input type="hidden" name="currency_code" value="đ" />
                                    <input type="hidden" name="return" value=" " />
                                    <input type="hidden" name="cancel_return" value=" " />
                                    <input type="submit" name="submit" value="Thêm vào giỏ" class="button" />
                                </fieldset>
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
    </div>-->

    </div>
</div>
<!-- //brands -->


<jsp:include page="footer.jsp" flush="true"></jsp:include>