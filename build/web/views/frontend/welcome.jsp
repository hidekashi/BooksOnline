<%-- 
    Document   : welcome
    Created on : Jul 1, 2019, 11:59:07 PM
    Author     : Hide
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <!-- products-breadcrumb -->
    <div class="products-breadcrumb">
        <div class="container custom-breadcrumb">
            <ul>
                <li><i class="fa fa-home" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/client/home.htm">Trang chủ</a><span>|</span></li>
                <li>Đăng ký thành công</li>
            </ul>
        </div>
    </div>
    <!-- //products-breadcrumb -->
<jsp:include page="navbar.jsp" flush="true"></jsp:include>


<div class="w3l_banner_nav_right">
        <!-- login -->
        <section class="page-account">
                <div class="container"> 
                    <!--<div class="col-xs-12 col-sm-12 col-md-6 col-md-offset-3">-->
                    <div></div>
                    <br />
                    <hr />
                    <div style="font-size: 28px" class="text-center">Đăng kí thành công!</div>
                    <div style="font-size: 28px" class="text-center">Chào mừng bạn đến với cửa hàng sách trực tuyến Books Online!</div>
                    <div style="font-size: 28px" class="text-center">Hy vọng dịch vụ mà chúng tôi mang lại sẽ làm bạn hài lòng ^^</div>
                    <br/>
                    <div class="text-center"><a href="home.htm" class="btn btn-primary" >Tiếp tục mua sắm</a></div>
                   
                    <!--</div>-->
                </div>
            </section> 
        <!-- //login -->
    </div>
    <div class="clearfix"></div>
</div>


<jsp:include page="footer.jsp" flush="true"></jsp:include>
