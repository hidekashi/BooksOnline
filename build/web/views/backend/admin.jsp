<%-- 
    Document   : admin
    Created on : Jul 4, 2019, 10:52:52 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/WEB-INF/tlds/pagination_tag" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <h2>Quản lý Admin</h2>
            <c:if test="${delMessage!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${delMessage}
                </div><br/>
                </c:if>
            
            <a href="${pageContext.request.contextPath}/admin/initInsertAdmin.htm" class="themmoi" style="float: right; margin-bottom: 10px;" >
                <button type="button" class="btn btn-primary">Thêm mới</button>
            </a>
            <table class="table table-striped table-hover table-bordered table-borderless">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Họ tên</th>
                        <th>Tài khoản</th>	
                        <th>Mật khẩu</th>
                        <th>Trạng thái</th>	
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listA}" var="a" varStatus="i">
                    <tr>
                        <td>${i.index+1 + offset}</td>
                        <td>${a.adminName}</td>
                        <td>${a.adminUser}</td>
                        <td>${a.adminPassword}</td>
                        <td>
                            <span class="${a.adminStatus?"label label-success":"label label-info"}">${a.adminStatus?"Active":"Inactive"}</span>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/preUpdateAdmin.htm?id=${a.adminId}">
                                <i class="glyphicon glyphicon-wrench">	
                                </i>          
                            </a>
                        </td>
                        <td>	
                            <a href="${pageContext.request.contextPath}/admin/delAdmin.htm?id=${a.adminId}">
                                 <i class="glyphicon glyphicon-trash" style="color: red;" onclick="return confirm('are you sure?')">
                                </i>	
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
              <tag:PaginationHandle count="${total}" uri="admin.htm" offset="${offset}" steps="5" next="&raquo" previous="&laquo"/> 
    </div>
    <div style="height: 100px;"></div>
</div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>

