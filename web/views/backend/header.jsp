<%-- 
    Document   : header
    Created on : May 29, 2019, 5:21:51 PM
    Author     : Hide
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Shoppy an Admin Panel Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href="/BooksOnline/views/backend/assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
        <link href="/BooksOnline/views/backend/assets/css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <script src="/BooksOnline/views/backend/assets/js/jquery-2.1.1.min.js"></script> 
        <!--icons-css-->
        <link href="/BooksOnline/views/backend/assets/css/font-awesome.css" rel="stylesheet"> 
        <!--Google Fonts-->
        <link href='https://fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,500,600' rel='stylesheet' type='text/css'>
        <!--static chart-->
        <script src="/BooksOnline/views/backend/assets/js/Chart.min.js"></script>
        <!--//charts-->
        <!-- geo chart -->
        <script src="https://cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
        <script>window.modernizr || document.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')</script>
        <!--<script src="lib/html5shiv/html5shiv.js"></script>-->
        <!-- Chartinator  -->
        <script src="/BooksOnline/views/backend/assets/js/chartinator.js" ></script>
        <!--geo chart-->
        <!--skycons-icons-->
        <script src="/BooksOnline/views/backend/assets/js/skycons.js"></script>
        <!--//skycons-icons-->
        <style>
            .product-image {
                height: 230px;
                width: 230px;
            }
            
            .form-control {
                margin-bottom: 10px;
            }
        </style>
        
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>	
        <div class="page-container">	
            <div class="left-content">
                <div class="mother-grid-inner">
                    <!--header start here-->
                    <div class="header-main">
                        <div class="header-left">
                            <div class="logo-name">
                                <a href="${pageContext.request.contextPath}/admin/home.htm"> <h1>BookShop</h1> 
                                    <!--<img id="logo" src="" alt="Logo"/>--> 
                                </a> 								
                            </div>
                            <!--search-box-->
                            <div class="search-box">
                                <form action="${action}">
                                    <input type="text" name="name" placeholder="Search...">
                                    <!--<input hidden="" name="id" value="${action =="searchOdt.htm"?odtid:""}" />-->
                                    <input type="submit" value="">					
                                </form>
                            </div><!--//end-search-box-->
                            <div class="clearfix"> </div>
                        </div>
                        <div class="header-right">
                            <div class="profile_details_left"><!--notifications of menu start -->
                                <ul class="nofitications-dropdown">
                                    <li class="dropdown head-dpdn">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i><span class="badge">3</span></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <div class="notification_header">
                                                    <h3>You have 3 new messages</h3>
                                                </div>
                                            </li>
                                            <li><a href="#">
                                                    <div class="user_img"><img src="/BooksOnline/views/backend/assets/images/p4.png" alt=""></div>
                                                    <div class="notification_desc">
                                                        <p>Lorem ipsum dolor</p>
                                                        <p><span>1 hour ago</span></p>
                                                    </div>
                                                    <div class="clearfix"></div>	
                                                </a></li>
                                            <li class="odd"><a href="#">
                                                    <div class="user_img"><img src="/BooksOnline/views/backend/assets/images/p2.png" alt=""></div>
                                                    <div class="notification_desc">
                                                        <p>Lorem ipsum dolor </p>
                                                        <p><span>1 hour ago</span></p>
                                                    </div>
                                                    <div class="clearfix"></div>	
                                                </a></li>
                                            <li><a href="#">
                                                    <div class="user_img"><img src="/BooksOnline/views/backend/assets/images/p3.png" alt=""></div>
                                                    <div class="notification_desc">
                                                        <p>Lorem ipsum dolor</p>
                                                        <p><span>1 hour ago</span></p>
                                                    </div>
                                                    <div class="clearfix"></div>	
                                                </a></li>
                                            <li>
                                                <div class="notification_bottom">
                                                    <a href="#">See all messages</a>
                                                </div> 
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="dropdown head-dpdn">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue">3</span></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <div class="notification_header">
                                                    <h3>You have 3 new notification</h3>
                                                </div>
                                            </li>
                                            <li><a href="#">
                                                    <div class="user_img"><img src="/BooksOnline/views/backend/assets/images/p5.png" alt=""></div>
                                                    <div class="notification_desc">
                                                        <p>Lorem ipsum dolor</p>
                                                        <p><span>1 hour ago</span></p>
                                                    </div>
                                                    <div class="clearfix"></div>	
                                                </a></li>
                                            <li class="odd"><a href="#">
                                                    <div class="user_img"><img src="/BooksOnline/views/backend/assets/images/p6.png" alt=""></div>
                                                    <div class="notification_desc">
                                                        <p>Lorem ipsum dolor</p>
                                                        <p><span>1 hour ago</span></p>
                                                    </div>
                                                    <div class="clearfix"></div>	
                                                </a></li>
                                            <li><a href="#">
                                                    <div class="user_img"><img src="/BooksOnline/views/backend/assets/images/p7.png" alt=""></div>
                                                    <div class="notification_desc">
                                                        <p>Lorem ipsum dolor</p>
                                                        <p><span>1 hour ago</span></p>
                                                    </div>
                                                    <div class="clearfix"></div>	
                                                </a></li>
                                            <li>
                                                <div class="notification_bottom">
                                                    <a href="#">See all notifications</a>
                                                </div> 
                                            </li>
                                        </ul>
                                    </li>	
                                    <li class="dropdown head-dpdn">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tasks"></i><span class="badge blue1">9</span></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <div class="notification_header">
                                                    <h3>You have 8 pending task</h3>
                                                </div>
                                            </li>
                                            <li><a href="#">
                                                    <div class="task-info">
                                                        <span class="task-desc">Database update</span><span class="percentage">40%</span>
                                                        <div class="clearfix"></div>	
                                                    </div>
                                                    <div class="progress progress-striped active">
                                                        <div class="bar yellow" style="width:40%;"></div>
                                                    </div>
                                                </a></li>
                                            <li><a href="#">
                                                    <div class="task-info">
                                                        <span class="task-desc">Dashboard done</span><span class="percentage">90%</span>
                                                        <div class="clearfix"></div>	
                                                    </div>
                                                    <div class="progress progress-striped active">
                                                        <div class="bar green" style="width:90%;"></div>
                                                    </div>
                                                </a></li>
                                            <li><a href="#">
                                                    <div class="task-info">
                                                        <span class="task-desc">Mobile App</span><span class="percentage">33%</span>
                                                        <div class="clearfix"></div>	
                                                    </div>
                                                    <div class="progress progress-striped active">
                                                        <div class="bar red" style="width: 33%;"></div>
                                                    </div>
                                                </a></li>
                                            <li><a href="#">
                                                    <div class="task-info">
                                                        <span class="task-desc">Issues fixed</span><span class="percentage">80%</span>
                                                        <div class="clearfix"></div>	
                                                    </div>
                                                    <div class="progress progress-striped active">
                                                        <div class="bar  blue" style="width: 80%;"></div>
                                                    </div>
                                                </a></li>
                                            <li>
                                                <div class="notification_bottom">
                                                    <a href="#">See all pending tasks</a>
                                                </div> 
                                            </li>
                                        </ul>
                                    </li>	
                                </ul>
                                <div class="clearfix"> </div>
                            </div>
                            <!--notification menu end -->
                            <div class="profile_details">		
                                <ul>
                                    <li class="dropdown profile_details_drop">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                            <div class="profile_img">	
                                                <span class="prfil-img"><img src="/BooksOnline/views/backend/assets/images/p1.png" alt=""> </span> 
                                                <div class="user-name">
                                                    <p>${admin}</p>
                                                    <span>Administrator</span>
                                                </div>
                                                <i class="fa fa-angle-down lnr"></i>
                                                <i class="fa fa-angle-up lnr"></i>
                                                <div class="clearfix"></div>	
                                            </div>	
                                        </a>
                                        <ul class="dropdown-menu drp-mnu">
                                            <li> <a href="#"><i class="fa fa-cog"></i> Settings</a> </li> 
                                            <li> <a href="#"><i class="fa fa-user"></i> Profile</a> </li> 
                                            <li> <a href="${pageContext.request.contextPath}/admin/logout.htm"><i class="fa fa-sign-out"></i> Đăng xuất</a> </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="clearfix"> </div>				
                        </div>
                        <div class="clearfix"> </div>	
                    </div>
                    <!--heder end here-->
