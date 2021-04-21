<%-- 
    Document   : country
    Created on : Jun 24, 2019, 5:11:34 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/pagination_tag" %>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <h2>Xuất xứ</h2>
            
            <c:if test="${message!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${message}
                </div><br/>
                </c:if>
                
                <c:if test="${delMessage!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${delMessage}
                </div><br/>
                </c:if>
            
            <a href="${pageContext.request.contextPath}/admin/initInsertCountry.htm" class="themmoi" style="float: right; margin-bottom: 10px;" >
                <button type="button" class="btn btn-primary">Thêm mới</button>
            </a>
            <table class="table table-striped table-hover table-bordered table-borderless">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Xuất Xứ</th>
                        <th>Trạng Thái</th>
                        <th>Sửa</th>
                        <th>Xóa</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listC}" var="c" varStatus="i">
                    <tr>
                        <td>${i.index+1+offset}</td>
                        <td>${c.countryName}</td>
                        <td>
                            <span class="${c.countryStatus?"label label-success":"label label-info"}">${c.countryStatus?"Active":"Inactive"}</span>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/preUpdateCountry.htm?countryId=${c.countryId}">
                                <button type="button" class="btn btn-success">
                                    <i class="glyphicon glyphicon-wrench">	
                                    </i>
                                </button>
                            </a>
                        </td>
                        <td>										
                            <a href="${pageContext.request.contextPath}/admin/delCountry.htm?countryId=${c.countryId}">
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
                <tag:PaginationHandle count="${total}" uri="country.htm" offset="${offset}" steps="5" next="&raquo;" previous="&laquo;"/>
    </div>	
</div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>
