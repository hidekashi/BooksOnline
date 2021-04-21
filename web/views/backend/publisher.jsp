<%-- 
    Document   : publisher
    Created on : Jun 24, 2019, 5:11:43 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/pagination_tag" %>

<jsp:include page="header.jsp" flush="true"></jsp:include>
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <h2>Nhà Xuất Bản</h2>
            <a href="initInsertPub.htm" class="themmoi" style="float: right; margin-bottom: 10px;" >
                <button type="button" class="btn btn-primary">Thêm mới</button>
            </a>
            <table class="table table-striped table-hover table-bordered table-borderless">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Tên Nhà Xuất Bản</th>		
                        <th>Địa Chỉ</th>
                        <th>Số Điện Thoại</th>
                        <th>Email</th>
                        <th>Trạng Thái</th>
                        <th>Sửa</th>
                        <th>Xóa</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listPub}" var="p" varStatus="i">
                    <tr>
                        <td>${i.index+1+offset}</td>
                        <td>${p.publisherName}</td>
                        <td>${p.publisherAddress}</td>
                        <td>${p.publisherPhone}</td>
                        <td>${p.publisherEmail}</td>
                        <td>
                            <span class="${p.publisherStatus?"label label-success":"label label-info"}">${p.publisherStatus?"Active":"Inactive"}</span>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/preUpdatePublisher.htm?publisherId=${p.publisherId}">
                                <button type="button" class="btn btn-success">
                                    <i class="glyphicon glyphicon-wrench">
                                    </i>
                                </button>
                            </a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/delPub.htm?pubId=${p.publisherId}">
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
        <tag:PaginationHandle count="${total}" uri="publisher.htm" offset="${offset}" steps="5" next="&raquo;" previous="&laquo;"/>
    </div>	
</div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>
