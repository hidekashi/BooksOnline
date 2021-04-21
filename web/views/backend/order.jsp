<%-- 
    Document   : order
    Created on : Jun 28, 2019, 3:56:11 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/pagination_tag" %>

<jsp:include page="header.jsp" flush="true"></jsp:include>
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <h2>Đơn hàng</h2>
            <!--            <a href="initInsertPub.htm" class="themmoi" style="float: right; margin-bottom: 10px;" >
                            <button type="button" class="btn btn-primary">Thêm mới</button>
                        </a>-->
            <table class="table table-striped table-hover table-bordered table-borderless">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Khách hàng</th>		
                        <th>Thời gian</th>		
                        <th>Số nhà</th>
                        <th>Xã/Phường</th>
                        <th>Quận/Huyện</th>
                        <th>Tỉnh/Thành phố</th>
                        <th>Trạng thái</th>
                        <th>Người duyệt</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listOrder}" var="p" varStatus="i">
                    <tr>
                        <td>${i.index+1+offset}</td>
                        <td>${p.customerId.customerName}</td>
                        <td><fmt:formatDate value="${p.orderDate}" /></td>
                        <td>${p.orderSoNha}</td>
                        <td>${p.orderXaPhuong}</td>
                        <td>${p.orderQuanHuyen}</td>
                        <td>${p.orderTinhTP}</td>
                        <td>
                            <span class="${p.orderStatus?"label label-success":"label label-info"}">${p.orderStatus?"Đã xác nhận":"Đang chờ"}</span>
                        </td>
                        <td>${p.adminId.adminName}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/orderDetail.htm?id=${p.orderId}"> 
                                <button type="button" class="btn btn-warning">
                                    <i class="glyphicon glyphicon-zoom-in">	
                                    </i>
                                </button>
                            </a>
                        </td>
                        <td>
                            <button ${p.adminId!=null?'disabled=""':''} type="button" class="btn btn-info">
                                <a href="${pageContext.request.contextPath}/admin/orderConfirm.htm?orderId=${p.orderId}">
                                    Duyệt
                                </a>
                            </button>	
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <tag:PaginationHandle count="${total}" uri="order.htm" offset="${offset}" steps="5" next="&raquo;" previous="&laquo;"/>
    </div>	
</div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>
