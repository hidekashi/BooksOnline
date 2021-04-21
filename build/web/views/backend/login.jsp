<%-- 
    Document   : login
    Created on : Jun 13, 2019, 11:27:53 AM
    Author     : Hide
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <link href="/BooksOnlineBackEnd/views/assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
        <!-- Custom Theme files -->
        <link href="/BooksOnlineBackEnd/views/assets/css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <!--js-->
        <script src="/BooksOnlineBackEnd/views/assets/js/jquery-2.1.1.min.js"></script> 
        <!--icons-css-->
        <link href="/BooksOnlineBackEnd/views/assets/css/font-awesome.css" rel="stylesheet"> 
        <!--Google Fonts-->
        <link href='https://fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,500,600' rel='stylesheet' type='text/css'>
        <style>
            .spring-btn-login {
                border: none;
                outline: none;
                cursor: pointer;
                color: #fff;
                background: #337AB7;
                width: 100%;
                margin: 0 auto;
                border-radius: 3px;
                padding: 0.5em 1em;
                font-size: 1em;
                display: block;
                font-family: 'Carrois Gothic', sans-serif;
            }

            .spring-btn-login:hover {
                background:#68AE00;
                transition: 0.5s all;
                -webkit-transition: 0.5s all;
                -moz-transition: 0.5s all;
                -o-transition: 0.5s all ;
                -ms-transition: 0.5s all;
            }
        </style>
        <!--static chart-->
    </head>
    <body>	
        <div class="login-page">
            <div class="login-main">  	
                <div class="login-head">
                    <h1>Login</h1>
                </div>
                <div class="login-block">
                    <div class="message">
                        ${message}
                    </div>
                        <spring:form action="login.htm" commandName="admin">
                        <spring:input type="text" path="adminUser" placeholder="Username" required="" />
                        <spring:input type="password" path="adminPassword" placeholder="Password" required="" />

                        <div class="forgot-top-grids">
                            <div class="forgot-grid">
                                <ul>
                                    <li>
                                        <input type="checkbox" id="brand1" value="">
                                        <label for="brand1"><span></span>Remember me</label>
                                    </li>
                                </ul>
                            </div>
                            <div class="forgot">
                                <a href="#">Forgot password?</a>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <!--<input type="submit" name="Sign In" value="Login">-->
                        <spring:button class="spring-btn-login">Login</spring:button>
                            <h3>Not a member?<a href="#"> Sign up now</a></h3>				
                            <h2>or login with</h2>
                            <div class="login-icons">
                                <ul>
                                    <li><a href="#" class="facebook"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#" class="google"><i class="fa fa-google-plus"></i></a></li>						
                                </ul>
                            </div>
                    </spring:form>

                    <h5><a href="${pageContext.request.contextPath}/admin/home.htm">Go Back to Home</a></h5>
                </div>
            </div>
        </div>
        <!--inner block end here-->
        <!--copy rights start here-->
        <div class="copyrights">
            <p>© 2016 Shoppy. All Rights Reserved | Design by  <a href="#" target="_blank">W3layouts</a> </p>
        </div>	
        <!--COPY rights end here-->

        <!--scrolling js-->
        <script src="/BooksOnlineBackEnd/views/assets/js/jquery.nicescroll.js"></script>
        <script src="/BooksOnlineBackEnd/views/assets/js/scripts.js"></script>
        <!--//scrolling js-->
        <script src="/BooksOnlineBackEnd/views/assets/js/bootstrap.js"></script>
        <!-- mother grid end here-->
    </body>
</html>
