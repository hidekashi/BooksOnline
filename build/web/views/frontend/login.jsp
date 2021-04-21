<%-- 
    Document   : login.jsp
    Created on : Jun 12, 2019, 7:10:34 PM
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
                <li>Đăng nhập</li>
            </ul>
        </div>
    </div>
    <!-- //products-breadcrumb -->
<jsp:include page="navbar.jsp" flush="true"></jsp:include>


<script>
        function validate(){
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            if(username != "" && password != ""){
                return true;
            }else {
                if(username == ""){
                    alert("Ban phai nhap ten dang nhap.");
                    document.getElementById("username").focus();
                    return false;
                    
                }
                if(password == ""){
                    
                    alert("Ban phai nhap mat khau.");
                    document.getElementById("password").focus();
                    return false;
                }
            } 
            
            
              
            }
          
    </script>


    <div class="w3l_banner_nav_right">
        <!-- login -->
        <div class="w3_login">
            <h3>Đăng nhập</h3>
            <div class="w3_login_module">
                <div class="module form-module">
                    <div class="toggle"><i class="fa fa-times fa-pencil"></i>
                         <!--<div class="tooltip">Click Me</div>--> 
                    </div>
                    <div class="form">
                        <div style="color: red; margin-bottom: 10px;">${tb}</div>
                        
                        <h2>Đăng nhập</h2>
                        <spring:form id="customer-login" action="login.htm" commandName="account" onsubmit="return validate()">
                            <input name='FormType' type='hidden' value='customer_login' />
                            <input id="test-action" name='action' type='hidden' value='${action}' />
                                <input name='utf8' type='hidden' value='true' />
                                
                                <div style="color: red; margin-bottom: 10px;">${message}</div>
                            
                            <spring:input id="username" type="text" path="customerUser" placeholder="Tên tài khoản" required=" " />
                            <spring:input id="password" type="password" path="customerPassword" placeholder="Mật khẩu" required=" " />
                            <input type="submit" value="Đăng nhập">
                        </spring:form>
                    </div>
                </div>
            </div>
        </div>
        <!-- //login -->
    </div>
    <div class="clearfix"></div>
</div>

<script>
    var test = document.getElementById("test-action").value;
            console.log("aaaa: " + test);
</script>

<jsp:include page="footer.jsp" flush="true"></jsp:include>