<%-- 
    Document   : insertCountry
    Created on : Jun 26, 2019, 4:19:54 PM
    Author     : Hide
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <div id="rightContent">
                <h2>Chỉnh sửa xuất xứ</h2>

            <c:if test="${message!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${message}
                </div><br/>
            </c:if>
            <spring:form action="insertCountry.htm" modelAttribute="newCountry">
                <table width="52%">
                    <tr>
                        <td><b>Xuất xứ</b></td>
                        <td><spring:input type="text" path="countryName" class="form-control"/></td>
                    </tr>									
                    <tr>
                        <td><b>Trạng thái</b></td>						
                        <td><spring:checkbox value="true" path="countryStatus" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <spring:button class="btn btn-success col-sm-4" style="margin: 20px 0 20px 50px;">Lưu dữ liệu</spring:button>
                            <spring:button class="btn btn-info col-sm-4" type="reset" style="margin: 20px 0 20px 30px"><a style="color:#FFF" href="${pageContext.request.contextPath}/admin/country.htm">Back to list</a></spring:button>
                                <div class="col-sm-4"></div>
                            </td>
                        </tr>
                    </table>
            </spring:form>					
        </div>       
    </div>
        <div style="height: 400px"></div>
    <div class="clear"></div>
</div>	
<jsp:include page="menu.jsp" flush="true"></jsp:include>
