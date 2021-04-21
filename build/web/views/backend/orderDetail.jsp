<%-- 
    Document   : orderDetail
    Created on : Jun 28, 2019, 3:56:27 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/pagin_order_detail_tag" %>

<jsp:include page="header.jsp" flush="true"></jsp:include>
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <h2>Đơn hàng chi tiết</h2>
<!--            <a href="initInsertPub.htm" class="themmoi" style="float: right; margin-bottom: 10px;" >
                <button type="button" class="btn btn-primary">Thêm mới</button>
            </a>-->
            <table class="table table-striped table-hover table-bordered table-borderless">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Sản phẩm</th>		
                        <th>Hình ảnh</th>		
                        <th>Giá hiện tại</th>		
                        <th>Số Lượng</th>
                        <th>Tổng cộng</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${lstOrderDetails}" var="p" varStatus="i">
                    <tr>
                        <td>${i.index+1+offset}</td>
                        <td>${p.productId.productName}</td>
                        <td>
                            <img class="product-image" title=" " alt=" " src="${pageContext.request.contextPath}/views/frontend/assets/images/${p.productId .productFeatureImage}" />
                        </td>
                        <td><fmt:formatNumber value="${p.orderDetailCurrentPrice}" type="currency"></fmt:formatNumber></td>
                        <td>${p.orderDetailQuantity}</td>
                        <td>
                            <fmt:formatNumber value="${p.orderDetailCurrentPrice*p.orderDetailQuantity}" type="currency"></fmt:formatNumber>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <tag:PaginOderDetail count="${total}" uri="orderDetail.htm?id=${lstOrderDetails.size()>0?lstOrderDetails.get(0).getOrderId().getOrderId():''}" offset="${offset}" steps="5" next="&raquo;" previous="&laquo;"/>
        <div style="float: right; margin-right: 50px; margin-top: -60px;">
            <b>Tổng tiền: </b><fmt:formatNumber value="${totalPrice}" type="currency"></fmt:formatNumber>
        </div>
        <div style="height: ${lstOrderDetails.size()==0?'400px':''}"></div>
    </div>	
</div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>
