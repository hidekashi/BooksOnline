<%-- 
    Document   : insertAdmin
    Created on : Jul 4, 2019, 10:53:03 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <div id="rightContent">
                <h2>Thêm mới Admin</h2>

<!--                <div class="informasi" style="border: 1px solid #cbe0b5; background: #f7ffe8 no-repeat left center;    width: 640px; height: 50px; padding-top: 15px; margin-bottom: 20px;">
                    Hãy chỉnh sửa dữ liệu cẩn thận nhé ^^
                </div>-->


                <c:if test="${message!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${message}
                </div><br/>
                </c:if>
            <spring:form action="insertAdmin.htm" modelAttribute="newAdmin">
                <table width="52%">
                    <tr>
                        <td><b>Họ tên: </b></td>
                        <td><spring:input type="text" path="adminName" class="form-control" /></td>
                    </tr>
                    <tr>
                        <td><b>Tên tài khoản: </b></td>
                        <td><spring:input type="text" path="adminUser" class="form-control" /></td>
                    </tr>
                    <tr>
                        <td><b>Mật khẩu: </b></td>
                        <td><spring:input type="password" path="adminPassword" class="form-control" /></td>
                    </tr>
                    <tr>
                        <td><b>Trạng thái</b></td>						
                        <td><spring:checkbox path="adminStatus" value="true" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <spring:button class="btn btn-success col-sm-4" style="margin: 20px 0 20px 50px;">Lưu dữ liệu</spring:button>
                            <spring:button class="btn btn-info col-sm-4" type="reset" style="margin: 20px 0 20px 30px"><a style="color:#FFF" href="${pageContext.request.contextPath}/admin/admin.htm">Back to list</a></spring:button>
                            <div class="col-sm-4"></div>
                        </td>
                    </tr>
                    </table>
            </spring:form>					       
        </div>
        <div style="height: 400px"></div>
        <div class="clear"></div>
    </div>	
</div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>
