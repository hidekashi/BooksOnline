<%-- 
    Document   : register
    Created on : Jul 2, 2019, 12:18:14 AM
    Author     : Hide
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp" flush="true"></jsp:include>
    <!-- products-breadcrumb -->
    <div class="products-breadcrumb">
        <div class="container custom-breadcrumb">
            <ul>
                <li><i class="fa fa-home" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/client/home.htm">Trang chủ</a><span>|</span></li>
            <li>Đăng nhập & Đăng ký</li>
        </ul>
    </div>
</div>
<!-- //products-breadcrumb -->
<jsp:include page="navbar.jsp" flush="true"></jsp:include>


    <script>


        function validate2() {
            var fullname = document.getElementById("full-name").value;
            var username1 = document.getElementById("user-name").value;
            var password1 = document.getElementById("pass-word").value;
            var phone = document.getElementById("phone").value;
            var email = document.getElementById("email").value;
            var pattern = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
            if (fullname != "" && username1 != "" && password1 != "" && phone != "" && email != "" && address != "" && pattern.test(email) == true) {
                return true;
            } else {
                if (fullname == "") {
                    alert("Bạn phải nhập họ tên.");
                    document.getElementById("full-name").focus();
                    return false;
                }
                if (username1 == "") {
                    alert("Bạn phải nhập tên đăng nhập.");
                    document.getElementById("user-name").focus();
                    return false;
                }
                if (password1 == "") {
                    alert("Bạn phải nhập mật khẩu.");
                    document.getElementById("pass-word").focus();
                    return false;
                }
                if (email == "") {
                    alert("Bạn phải nhập email.");
                    document.getElementById("email").focus();
                    return false;
                } else {

                    if (!pattern.test(email)) {
                        alert("Bạn nhập sai định dạng email. Mời bạn nhập lại.");
                        document.getElementById("email").focus();
                        return false;
                    }
                }
                if (phone == "") {
                    alert("Bạn phải nhập số điện thoại.");
                    document.getElementById("phone").focus();
                    return false;
                }
            }
        }
    </script>


    <div class="w3l_banner_nav_right">
        <!-- login -->
        <div class="w3_login">
            <h3>Đăng kí</h3>
            <div class="w3_login_module">
                <div class="module form-module">
                    <div class="toggle"><i class="fa fa-times fa-pencil"></i>
                        <!--<div class="tooltip">Click Me</div>--> 
                    </div>
                    <div class="form">
                        <h2>Tạo tài khoản</h2>
                        <div style="color: red; margin-bottom: 10px;">${regMessage}</div>
                    <spring:form accept-charset='UTF-8' action="register.htm" id='customer_register' commandName="register" onsubmit="return validate2()">
                        <spring:input id="full-name" type="text" path="customerName" placeholder="Họ và tên" required=" " />
                        <spring:input id="user-name" type="text" path="customerUser" placeholder="Tên tài khoản" required=" " />
                        <spring:input id="pass-word" type="password" path="customerPassword" placeholder="Mật khẩu" required=" " />
                        <spring:input id="email" type="email" path="customerEmail" placeholder="Địa chỉ email" required=" " />
                        <spring:input id="phone" type="text" path="customerPhone" placeholder="Số điện thoại" required=" " />
                        <spring:button class="btn-submit">Đăng kí</spring:button>
                    </spring:form>
                </div>
                <div class="cta"><a href="#">Quên mật khẩu?</a></div>
            </div>
        </div>

    </div>
    <!-- //login -->
</div>
<div class="clearfix"></div>
</div>


<jsp:include page="footer.jsp" flush="true"></jsp:include>