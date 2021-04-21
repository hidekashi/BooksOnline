<%-- 
    Document   : updatePublisher
    Created on : Jul 4, 2019, 9:07:00 PM
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
                <h2>Chỉnh sửa nhà xuất bản</h2>

                <c:if test="${message!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${message}
                </div><br/>
                </c:if>
            <form:form action="updatePublisher.htm" modelAttribute="pub">
                <table width="52%">
                        <tr>
                            <td><b>Mã Loại</b></td>
                            <td><form:input readonly="true" type="text" path="publisherId" class="form-control"/></td>
                        </tr>
                        <tr>
                            <td><b>Tên nhà xuất bản</b></td>
                            <td><form:input type="text" path="publisherName" class="form-control"/></td>
                        </tr><br/>
                    <tr>
                        <td><b>Địa chỉ</b></td>
                        <td><form:input type="text" path="publisherAddress" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><b>Số điện thoại</b></td>
                        <td><form:input type="text" path="publisherPhone" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><b>Email</b></td>
                        <td><form:input type="email" path="publisherEmail" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><b>Trạng thái</b></td>
                        <td><form:checkbox  path="publisherStatus" value="true"></form:checkbox></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <form:button class="btn btn-success col-sm-4" style="margin: 20px 0 20px 50px;">Lưu dữ liệu</form:button>
                            <form:button class="btn btn-info col-sm-4" type="reset" style="margin: 20px 0 20px 30px"><a style="color:#FFF" href="${pageContext.request.contextPath}/admin/publisher.htm">Back to list</a></form:button>
                            <div class="col-sm-4"></div>
                        </td>
                    </tr>
                </table>

                <!--<input type="submit" class="btn btn-success" value="Lưu dữ liệu" style="margin: 20px 0 20px 350px;">-->
            </form:form>	
        </div>
        <div class="clear"></div>
    </div>	
</div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>