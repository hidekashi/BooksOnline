<%-- 
    Document   : cart.jsp
    Created on : Jun 12, 2019, 7:04:02 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <!-- products-breadcrumb -->
    <div class="products-breadcrumb">
        <div class="container custom-breadcrumb">
            <ul>
                <li><i class="fa fa-home" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/client/home.htm">Trang chủ</a><span>|</span></li>
            <li>Giỏ hàng</li>
        </ul>
    </div>
</div>
<!-- //products-breadcrumb -->
<jsp:include page="navbar.jsp" flush="true"></jsp:include>


    <div class="w3l_banner_nav_right">
        <!-- about -->
        <div class="privacy about">
            <h3>Giỏ <span>Hàng</span></h3>

        <c:if test="${listCart == null}">
            <h4> Không có sản phẩm trong giỏ hàng</h4>
        </c:if>

        <c:if test="${listCart !=  null}">
            <c:if test="${listCart.size() == 0}">
                <h4> Không có sản phẩm trong giỏ hàng</h4>
            </c:if>
            <c:if test="${listCart.size() > 0}">
                <form action="update.htm" enctype="multipart/form-data">
                    <div class="checkout-right">
                        <h4>Giỏ hàng của bạn có: <span>${listCart.size()} Sản phẩm</span></h4>
                        <p style="color: red;">${quanMes}</p>
                        ${quanMes!=null?'<br/>':''}
                        <table class="timetable_sub">
                            <thead>
                                <tr>
                                    <!--<th>STT</th>-->	
                                    <th>Hình ảnh</th>
                                    <th>Tên sách</th>
                                    <th>Giá lẻ</th>
                                    <th>Số lượng</th>
                                    <th>Tổng cộng</th>



                                    <th>Xóa</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${listCart}" var="c">
                                    <tr class="rem1">
                                        <td class="invert-image">
                                            <a href="${pageContext.request.contextPath}/client/productById.htm?proId=${c.product.productId}&auId=${c.product.authorId.authorId}&cateId=${c.product.categoryId.categoryId}&countryId=${c.product.countryId.countryId}&pubId=${c.product.publisherId.publisherId}">
                                                <img src="${pageContext.request.contextPath}/views/frontend/assets/images/${c.product.productFeatureImage}" alt=" " style="width: 100px; height: 100px" class="img-responsive">
                                            </a>
                                        </td>

                                        <td class="invert">${c.product.productName}</td>
                                        <td class="invert">
                                            <fmt:formatNumber value="${c.product.productDiscount>0?c.product.productDiscount:c.product.productPrice}" type="currency"></fmt:formatNumber>
                                            </td>
                                            <td class="invert">
                                                <div class="quantity"> 
                                                    <input  type="number" style="width: 50px" value="${c.quantity}" min="1" class="input-control type_1" name="quantity" id="quantity">
                                            </div>
                                        </td>
                                        <td class="invert">
                                            <fmt:formatNumber value="${c.product.productDiscount>0?c.product.productDiscount*c.quantity:c.product.productPrice*c.quantity}" type="currency"></fmt:formatNumber>
                                            </td>


                                            <td class="invert">
                                                <div class="rem">
                                                    <a href="${pageContext.request.contextPath}/client/remove.htm?id=${c.product.productId}"><div style="margin-right: 20px;" class="close1" onclick="return confirm('Bạn có chắc chắn muốn xóa?')"> </div></a>
                                            </div>

                                        </td>
                                    </tr>
                                </c:forEach>



                            </tbody></table>
                    </div>
                    <div class="button-cart" style="padding-top: 10px;">
                        <button class="button-blue" type="submit" name="update" >
                            Cập nhật
                        </button>
                        <a href="home.htm" class="button-transparent">
                            Tiếp tục mua hàng
                        </a>
                    </div>
                </form>
            </c:if>
        </c:if>

        <div class="checkout-left">	
            <c:if test="${listCart !=  null && listCart.size() > 0}">
                <div class="col-md-8"></div>
                <div class="col-md-4 checkout-left-basket" style="margin-top: -50px;">
                    <h4 style="background: gray">Tạm tính</h4>
                    <ul>
                        <c:forEach items="${listCart}" var="c">
                            <li style="color: black">${c.product.productName} <i>:</i> <span><fmt:formatNumber value="${c.product.productDiscount>0?c.product.productDiscount*c.quantity:c.product.productPrice*c.quantity}" type="currency"></fmt:formatNumber></span></li>
                            </c:forEach>
                        <li>-----------------------------------------------------</li>
                        <li style="color: black">Tổng tiền <i>:</i> <span>${totalPrice!=null?totalPrice:""} ₫</span></li>
                        <a href="initPayment.htm" class="button-blue">Tiến hành đặt hàng</a>
                    </ul>
                </div>
            </c:if>

            <div class="clearfix"> </div>

        </div>

    </div>
    <!-- //about -->
</div>
<div class="clearfix"></div>
</div>


<jsp:include page="footer.jsp" flush="true"></jsp:include>