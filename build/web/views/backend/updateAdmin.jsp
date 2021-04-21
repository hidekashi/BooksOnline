<%-- 
    Document   : updateAdmin
    Created on : Jul 4, 2019, 10:53:12 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <div id="rightContent">
                <h2>Thêm mới sản phẩm</h2>

                 <c:if test="${message!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${message}
                </div><br/>
                 </c:if>
            <form:form action="updateAdmin.htm" modelAttribute="adminn">
                <table width="52%">
                        <tr>
                            <td><b>#</b></td>
                            <td><form:input readonly="true" type="text" path="adminId" class="form-control"/></td>
                        </tr>
                        <tr>
                            <td><b>Tên quản trị viên</b></td>
                            <td><form:input type="text" path="adminName" class="form-control"/></td>
                        </tr><br/>
                    <tr>
                        <td><b>Tài khoản</b></td>
                        <td><form:input type="text" path="adminUser" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><b>Mật khẩu</b></td>
                        <td><form:input type="text" path="adminPassword" class="form-control"/></td>
                    </tr>  

                    <tr>
                        <td><b>Trạng thái</b></td>						
                        <td><form:checkbox path="adminStatus" value="true"></form:checkbox></td>
                        </tr>
                        <tr>
                        <td></td>
                        <td>
                            <form:button class="btn btn-success col-sm-4" style="margin: 20px 0 20px 50px;">Lưu dữ liệu</form:button>
                            <form:button class="btn btn-info col-sm-4" type="reset" style="margin: 20px 0 20px 30px"><a style="color:#FFF" href="${pageContext.request.contextPath}/admin/admin.htm">Back to list</a></form:button>
                            <div class="col-sm-4"></div>
                        </td>
                    </tr>
                    </table>
                    <!--<input type="submit" class="btn btn-success" value="Lưu dữ liệu" style="margin: 20px 0 20px 350px;">--> 
            </form:form>					       
        </div>
        <div class="clear"></div>
        <div style="height: 200px;"></div>
    </div>	
</div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>
