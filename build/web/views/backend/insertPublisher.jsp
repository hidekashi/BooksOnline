<%-- 
    Document   : insertPublisher
    Created on : Jun 26, 2019, 4:20:15 PM
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
                <h2>Thêm mới nhà xuất bản</h2>

                <c:if test="${message!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${message}
                </div><br/>
                </c:if>
            <spring:form action="insertPub.htm" modelAttribute="newPub">
                    <table width="52%">
                            <tr>
                                <td><b>Tên nhà xuất bản</b></td>
                                <td><spring:input type="text" path="publisherName" class="form-control" /></td>
                            </tr><br/>
                        <tr>
                            <td><b>Địa chỉ</b></td>
                            <td><spring:input type="text" path="publisherAddress" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td><b>Số điện thoại</b></td>
                            <td><spring:input type="text" path="publisherPhone" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td><b>Email</b></td>
                            <td><spring:input type="email" path="publisherEmail" class="form-control" /></td>
                        </tr>
                        <tr>
                            <td><b>Trạng thái</b></td>						
                            <td><spring:checkbox path="publisherStatus" value="true" /></td>
                        </tr>
                        <tr>
                        <td></td>
                        <td>
                            <spring:button class="btn btn-success col-sm-4" style="margin: 20px 0 20px 50px;">Lưu dữ liệu</spring:button>
                            <spring:button class="btn btn-info col-sm-4" type="reset" style="margin: 20px 0 20px 30px"><a style="color:#FFF" href="${pageContext.request.contextPath}/admin/publisher.htm">Back to list</a></spring:button>
                                <div class="col-sm-4"></div>
                            </td>
                        </tr>
                    </table>
                </spring:form>					       
            </div>
            <div style="height: 300px"></div>
            <div class="clear"></div>
        </div>	
    </div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>