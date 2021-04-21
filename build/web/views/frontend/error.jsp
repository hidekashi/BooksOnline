<%-- 
    Document   : error
    Created on : Jul 2, 2019, 12:07:52 AM
    Author     : Hide
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <!-- products-breadcrumb -->
    <div class="products-breadcrumb">
        <div class="container custom-breadcrumb">
            <ul>
                <li><i class="fa fa-home" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/client/home.htm">Trang chủ</a><span>|</span></li>
                <li>Đăng ký thất bại</li>
            </ul>
        </div>
    </div>
    <!-- //products-breadcrumb -->
<jsp:include page="navbar.jsp" flush="true"></jsp:include>


<div class="w3l_banner_nav_right">
    <h3>Lỗi hệ thống</h3>
    </div>
    <div class="clearfix"></div>
</div>


<jsp:include page="footer.jsp" flush="true"></jsp:include>
