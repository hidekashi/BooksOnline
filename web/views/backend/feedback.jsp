<%-- 
    Document   : feedback
    Created on : Jul 4, 2019, 10:17:00 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/pagination_tag" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <h2>Bảng phản hồi </h2>
            <c:if test="${delMessage!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${delMessage}
                </div><br/>
                </c:if>
            <table class="table table-striped table-hover table-bordered table-borderless">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Tên khách hàng</th>
                        <th>Email</th>	
                        <th>Số điện thoại</th>
                        <th>Link sản phẩm</th>	
                        <th>Nội dung phản hồi</th>                   
                        <!--<th>Trạng thái</th>-->
                        <th></th>
                    </tr>
                </thead>
            <c:forEach items="${listF}" var="f" varStatus="i">
                <tbody>
                    <tr>
                        <td>${i.index+1 + offset}</td>
                        <td>${f.feedBackName}</td>
                        <td>${f.feedBackEmail}</td>
                        <td>${f.feedBackPhone}</td>
                        <td>${f.feedBackProductLink}</td>
                        <td>${f.feedBackContent}</td>
                        <!--<td>${f.feedBackStatus}</td>-->
                        
                        <td>	
                            <a href="${pageContext.request.contextPath}/admin/delfb.htm?id=${f.feedBackId}">
                                <i class="glyphicon glyphicon-trash" style="color: red;" onclick="return confirm('are you sure?')">
                                </i>	
                            </a>
                        </td>                     
                    </tr>
                </tbody>
            </c:forEach>
        </table>
                <tag:PaginationHandle count="${total}" uri="feedback.htm" offset="${offset}" steps="5" next="&raquo;" previous="&laquo;"/>
    </div>	
</div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>