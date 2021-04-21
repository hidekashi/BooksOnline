<%-- 
    Document   : header
    Created on : May 29, 2019, 8:02:31 PM
    Author     : Hide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Book Online</title>
        <style>
            /**/
            /* Dropdown Button */
            .dropbtn {
                background-color: #fff;
                color: #212121;
                /* padding: 16px; */
                font-size: 25px;
                border: none;
            }

            /* The container <div> - needed to position the dropdown content */
            .dropdown {
                position: relative;
                display: inline-block;
            }

            /* Dropdown Content (Hidden by Default) */
            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f1f1f1;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            /* Links inside the dropdown */
            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
                font-size: 5px;
            }

            /* Change color of dropdown links on hover */
            .dropdown-content a:hover {background-color: #ddd;}

            /* Show the dropdown menu on hover */
            .dropdown:hover .dropdown-content {display: block;}

            /* Change the background color of the dropdown button when the dropdown content is shown */
            .dropdown:hover .dropbtn {color: #FA1818;}

            .dropdown .dropdown-content a {
                font-size: 18px;
            }

            /**/

            .btnEmail {
                outline: none;
                padding: 10px 0;
                background: #fff;
                border: 1px solid #fff;
                font-size: 14px;
                color: #FA1818;
                width: 25.7%;
                text-transform: uppercase;
            }

            .btnEmail:hover {
                background:#84C639;
                border: 1px solid #84C639;
                color:#fff;
            }

            /**/

            .p-author, .p-publisher {
                font-size: 18px;
                font-weight: bold;
            }

            .p-author span, .p-publisher span {
                font-size: 18px;
                font-weight: bold;
                font-style: italic;
                color: #f15f14;
            }

            .fset {
                display: inline-block;
            }

            .form-addtocart {
                display: flex;
                list-style-type: none;
            }

            .form-addtocart li {
                margin-left: 20px;
            }

            .form-addtocart:first-child {
                margin-left: -20px;
            }

            .form-addtocart li .button {
                width: 130px;
            }

            .w3agile_description p:last-child {
                text-indent: 10px;
            }

            /**/
            .feedback-button {
                outline: none;
                padding: 10px 0;
                font-size: 14px;
                color: #fff;
                background: #84C639;
                width: 46.6%;
                border: none;
                text-transform: uppercase;
                margin-left: 1.1em;
                -webkit-appearance: button;
                cursor: pointer;
            }

            .feedback-button:hover {
                background: #212121;
            }

            .snipcart-details button{
                font-size: 14px;
                color: #fff;
                background: #FA1818;
                text-decoration: none;
                position: relative;
                border: none;
                border-radius: 0;
                width: 100%;
                text-transform: uppercase;
                padding: .5em 0;
                outline: none;
            }

            .button-blue {
                border-color: #207AD1; background: #207AD1; border: solid 2px #fff;color: #EEEFF7;display: inline-block;line-height: 40px;padding: 0 25px;font-family: 'Cabin', sans-serif;text-transform: uppercase;
            }

            .button-transparent {
                border-color: green; background: green; border: solid 2px #fff;color: #EEEFF7;display: inline-block;line-height: 40px;padding: 0 25px;font-family: 'Cabin', sans-serif;text-transform: uppercase;
            }

            .customer-user {
                font-size: 20px;
                color: red;
            }

            .btn-submit {
                background: #84C639;
                width: 100%;
                border: 0;
                padding: 10px 15px;
                color: #ffffff;
                -webkit-transition: 0.3s ease;
                transition: 0.3s ease;
                font-size: 14px;
                font-weight: bold;
            }
            
            .btn-submit:hover {
                background: #FA1818;
            }
            
            .total-price {
                float: right;
                margin-right: 150px;
            }
        </style>
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link rel="icon" href="${pageContext.request.contextPath}/views/frontend/assets/images/book-logo.png" type="image/gif" sizes="16x16">
        <!-- //for-mobile-apps -->
        <link href="${pageContext.request.contextPath}/views/frontend/assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="${pageContext.request.contextPath}/views/frontend/assets/css/style.css" rel="stylesheet" type="text/css" media="all" />
        <!-- font-awesome icons -->
        <link href="${pageContext.request.contextPath}/views/frontend/assets/css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
        <!-- //font-awesome icons -->

        <link href="${pageContext.request.contextPath}/views/frontend/assets/css/mycss.css" rel="stylesheet" type="text/css" media="all" />
        <!-- js -->
        <script src="${pageContext.request.contextPath}/views/frontend/assets/js/jquery-1.11.1.min.js"></script>
        <!-- //js -->
        <link href='https://fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
        <!-- start-smoth-scrolling -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/views/frontend/assets/js/move-top.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/views/frontend/assets/js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <!-- start-smoth-scrolling -->
    </head>

    <body>
        <!-- header -->
        <div class="agileits_header">
            <div class="w3l_offers">
                <a href="offerProduct.htm">Sản phẩm đang giảm giá</a>
            </div>
            <div class="w3l_search">
                <form action="search.htm">
                    <input type="text" name="name" value="Tìm sản phẩm..." onfocus="this.value = '';" onblur="if (this.value == '') {
                                this.value = 'Search a product...';
                            }" required="">
                    <input type="submit" value=""/>
                </form>
            </div>
            <div class="product_list_header">  
                <form action="myCart.htm" class="last">
                    <fieldset>
                        <!--                        <input type="hidden" name="cmd" value="_cart" />
                                                <input type="hidden" name="display" value="1" />-->
                        <input type="submit" name="submit" value="   Giỏ hàng (${listCart.size()})" class="button" />
                        <!--<a href="myCart.htm" >Xem giỏ hàng</a>-->
                    </fieldset>
                </form>
            </div>
            <div class="w3l_header_right">
                <ul>
                    <li class="dropdown profile_details_drop">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user" aria-hidden="true"></i><span class="caret"></span></a>
                        <div class="mega-dropdown-menu">
                            <div class="w3ls_vegetables">
                                <ul class="dropdown-menu drp-mnu" id="login-dropdown">
                                    <li class="pre-login"><a href="initLogin.htm">Đăng nhập</a></li> 
                                    <li class="pre-login"><a href="initRegister.htm">Đăng ký</a></li>
<!--                                    <li class="after-login" hidden="true">${account}</li>
                                    <li class="after-login" hidden="true"><a href="#">Đăng xuất</a></li>-->
                                </ul>
                            </div>                  
                        </div>	
                    </li>
                </ul>
            </div>
            <div class="w3l_header_right1">
                <h2><a href="#">Liên hệ</a></h2>
            </div>
            <div class="clearfix"> </div>
        </div>
        <!-- script-for sticky-nav -->
        <script>
            $(document).ready(function () {
                var navoffeset = $(".agileits_header").offset().top;
                $(window).scroll(function () {
                    var scrollpos = $(window).scrollTop();
                    if (scrollpos >= navoffeset) {
                        $(".agileits_header").addClass("fixed");
                    } else {
                        $(".agileits_header").removeClass("fixed");
                    }
                });

            });
        </script>
        <!-- //script-for sticky-nav -->
        <div class="logo_products">
            <div class="container">
                <div class="w3ls_logo_products_left">
                    <a href="${pageContext.request.contextPath}/client/home.htm">
                        <img src="${pageContext.request.contextPath}/views/frontend/assets/images/book-logo.png" alt="" class="img-responsive">
                        <div class="online text-center">
                            ONLINE
                        </div>
                    </a>
                </div>
                <div class="w3ls_logo_products_left1">
                    <ul class="special_items">
                        <!--<li><a href="${pageContext.request.contextPath}/views/frontend/product.jsp">Sản Phẩm</a><i>|</i></li>-->
                        <li><a href="${pageContext.request.contextPath}/client/product.htm">Sản Phẩm</a><i>|</i></li>
                        <li>
                            <div class="dropdown">
                                <button class="dropbtn">Danh Mục</button>
                                <div class="dropdown-content">

                                    <c:forEach items="${listCate}" var="cate">
<!--                                        <a>${cate.categoryName}</a>-->
                                        <a href="${pageContext.request.contextPath}/client/productByCategoryId.htm?cateId=${cate.categoryId}">${cate.categoryName}</a>
                                    </c:forEach>
                                </div>
                            </div>
                            <i>|</i>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/client/feedback.htm">Phản Hồi</a><i>|</i></li>
                        <li><a href="${pageContext.request.contextPath}/client/about.htm">Giới Thiệu</a></li>
                    </ul>
                </div>
                <div class="w3ls_logo_products_left1">
                    <ul class="phone_email">
                        <li><i class="fa fa-phone" aria-hidden="true"></i>(+0123) 234 567</li>
                        <li><i class="fa fa-envelope-o" aria-hidden="true"></i><a href="mailto:order@booksonline.com">order@bookonline.com</a></li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <!-- //header -->
