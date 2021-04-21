<%-- 
    Document   : banner
    Created on : May 29, 2019, 8:11:04 PM
    Author     : Hide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="w3l_banner_nav_right">
    <section class="slider">
        <div class="flexslider">
            <ul class="slides">
                <li>
                    <div class="w3l_banner_nav_right_banner">
                    </div>
                </li>
                <li>
                    <div class="w3l_banner_nav_right_banner1">
                    </div>
                </li>
                <li>
                    <div class="w3l_banner_nav_right_banner2">
                    </div>
                </li>
            </ul>
        </div>
    </section>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/frontend/assets/css/flexslider.css" type="text/css" media="screen" property="" />
    <script defer src="/BooksOnline/views/frontend/assets/js/jquery.flexslider.js"></script>
    <script type="text/javascript">
        $(window).load(function () {
            $('.flexslider').flexslider({
                animation: "slide",
                start: function (slider) {
                    $('body').removeClass('loading');
                }
            });
        });
    </script>
    <!-- //flexSlider -->
</div>
<div class="clearfix"></div>
</div>
<!-- banner -->
<div class="banner_bottom">
    <div class="wthree_banner_bottom_left_grid_sub">
    </div>
    <div class="wthree_banner_bottom_left_grid_sub1">
        <c:forEach items="${promotions}" var="p">
            <div class="col-md-4 wthree_banner_bottom_left">
                <div class="wthree_banner_bottom_left_grid">
                    <a href="${pageContext.request.contextPath}/client/promotion.htm?promoId=${p.promotionId}">
                        <img src="${pageContext.request.contextPath}/views/frontend/assets/images/${p.promotionImage}" alt=" " class="img-responsive" />
                    </a>
                </div>
            </div>
        </c:forEach>
        <!--        <div class="col-md-4 wthree_banner_bottom_left">
                    <div class="wthree_banner_bottom_left_grid">
                        <img src="/BooksOnline/views/frontend/assets/images/special2.jpg" alt=" " class="img-responsive" />
                        <div class="wthree_banner_btm_pos">
                        </div>
                    </div>
                </div>
                <div class="col-md-4 wthree_banner_bottom_left">
                    <div class="wthree_banner_bottom_left_grid">
                        <img src="/BooksOnline/views/frontend/assets/images/special3.jpg" alt=" " class="img-responsive" />
                    </div>
                </div>-->
        <div class="clearfix"> </div>
    </div>
    <div class="clearfix"> </div>
</div>