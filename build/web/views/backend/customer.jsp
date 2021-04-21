<%-- 
    Document   : customer
    Created on : Jul 4, 2019, 8:14:58 AM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/pagination_tag" %>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <h2>Quản lí khách hàng</h2>
                
                <c:if test="${delMessage!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${delMessage}
                </div><br/>
                </c:if>
            
            <a href="${pageContext.request.contextPath}/admin/initInsertCus.htm" class="themmoi" style="float: right; margin-bottom: 10px;" >
                <button type="button" class="btn btn-primary">Thêm mới</button>
            </a>
            <table class="table table-striped table-hover table-bordered table-borderless">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Khách hàng</th>
                        <th>Tài khoản</th>
                        <th>Mật khẩu</th>
                        <th>Email</th>
                        <th>Số điện thoại</th>
                        <th>Trạng thái</th>
                        <th>Sửa</th>
                        <th>Xóa</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listCus}" var="a" varStatus="i">
                    <tr>
                        <td>${i.index+1+offset}</td>
                        <td>${a.customerName}</td>
                        <td>${a.customerUser}</td>
                        <td>${a.customerPassword}</td>
                        <td>${a.customerEmail}</td>
                        <td>${a.customerPhone}</td>
                        <td>
                            <span class="${a.customerStatus?"label label-success":"label label-info"}">${a.customerStatus?"Active":"Inactive"}</span>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/preUpdateCustomer.htm?customerId=${a.customerId}">
                                <button type="button" class="btn btn-success">
                                    <i class="glyphicon glyphicon-wrench">	
                                    </i>
                                </button>
                            </a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/delCus.htm?cusId=${a.customerId}">
                            <button type="button" class="btn btn-warning" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">
                                <i class="glyphicon glyphicon-trash">
                                </i>
                            </button>	
                            </a>
                        </td>

                    </tr>
                    </c:forEach>
                </tbody>
            </table>
             <tag:PaginationHandle count="${total}" uri="customer.htm" offset="${offset}" steps="5" next="&raquo;" previous="&laquo;"/>
            
        </div>	
    </div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>
