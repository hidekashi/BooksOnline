<%-- 
    Document   : banner
    Created on : May 29, 2019, 8:08:07 PM
    Author     : Hide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- banner -->
<div class="banner">
    <div class="w3l_banner_nav_left">
        <nav class="navbar nav_bottom">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header nav_2">
                <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div> 
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                <div class="categories-wrapper">
                    <h4 class="sidebar-title">Công ty phát hành</h4>
                    <ul class="nav navbar-nav nav_1">
                        <c:forEach items="${listPub}" var="lp">
                            <!--<li><a href="#">${lp.publisherName}</a></li>-->
                            <li><a href="${pageContext.request.contextPath}/client/productByPublisherId.htm?pubId=${lp.publisherId}">${lp.publisherName}</a></li>
                        </c:forEach>
                    </ul>
                </div>

                <div class="categories-wrapper">
                    <h4 class="sidebar-title">Quốc gia</h4>
                    <ul class="nav navbar-nav nav_1">
                        <c:forEach items="${listC}" var="lc">
                            <!--<li><a href="#">${lc.countryName}</a></li>-->
                            <li><a href="${pageContext.request.contextPath}/client/productByCountryId.htm?countryId=${lc.countryId}">${lc.countryName}</a></li>
                        </c:forEach>
                    </ul>
                </div>

                <div class="categories-wrapper">
                    <h4 class="sidebar-title">Tác giả</h4>
                    <ul class="nav navbar-nav nav_1">
                        <c:forEach items="${listA}" var="a">
                            <!--<li><a href="#">${a.authorName}</a></li>-->
                            <li><a href="${pageContext.request.contextPath}/client/productByAuthorId.htm?auId=${a.authorId}">${a.authorName}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div><!-- /.navbar-collapse -->
        </nav>
    </div>