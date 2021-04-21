<%-- 
    Document   : home
    Created on : May 29, 2019, 5:34:46 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/pagination_tag" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>

    <!-- script-for sticky-nav -->
    <script>
        $(document).ready(function () {
            var navoffeset = $(".header-main").offset().top;
            $(window).scroll(function () {
                var scrollpos = $(window).scrollTop();
                if (scrollpos >= navoffeset) {
                    $(".header-main").addClass("fixed");
                } else {
                    $(".header-main").removeClass("fixed");
                }
            });

        });
    </script>
    <!-- /script-for sticky-nav -->
    <!--inner block start here-->
    <div class="inner-block">
        <!--market updates updates-->
        <div class="market-updates">
            <div class="col-md-4 market-update-gd">
                <div class="market-update-block clr-block-1">
                    <div class="col-md-8 market-update-left">
                        <h3>${total}</h3>
                        <h4>Sản phẩm</h4>
                        <p>Other hand, we denounce</p>
                    </div>
                    <div class="col-md-4 market-update-right">
                        <i class="fa fa-file-text-o"> </i>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="col-md-4 market-update-gd">
                <div class="market-update-block clr-block-2">
                    <div class="col-md-8 market-update-left">
                        <h3>${orderRecord}</h3>
                        <h4>Đơn hàng</h4>
                        <p>Other hand, we denounce</p>
                    </div>
                    <div class="col-md-4 market-update-right">
                        <i class="fa fa-eye"> </i>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="col-md-4 market-update-gd">
                <div class="market-update-block clr-block-3">
                    <div class="col-md-8 market-update-left">
                        <h3>${totalfb}</h3>
                        <h4>Phản hồi</h4>
                        <p>Other hand, we denounce</p>
                    </div>
                    <div class="col-md-4 market-update-right">
                        <i class="fa fa-envelope-o"> </i>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
        <!--market updates end here-->
        <!--mainpage chit-chating-->
        <div class="chit-chat-layer1">
            <div class="col-md-6 chit-chat-layer1-left">
                <div class="work-progres">
                    <div class="chit-chat-heading">
                        Đơn hàng
                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Khách hàng</th>                                  

                                    <th>Thời gian</th>
                                    <th>Trạng thái</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listOrder}" var="od" varStatus="i">
                                <tr>
                                    <td>${i.index+1+offsetod}</td>
                                    <td>${od.customerId.customerName}</td>                         

                                    <td><fmt:formatDate value="${od.orderDate}"></fmt:formatDate></td>
                                    <td><span class="${od.orderStatus?"label label-success":"label label-info"}">${od.orderStatus==false?"Đang chờ":"Đã xác nhận"}</span></td>
                                </tr>   
                            </c:forEach>                         
                        </tbody>
                    </table>
                        <tag:PaginationHandle count="${totalod}" uri="home.htm" offset="${offsetod}" steps="5" next="&raquo;" previous="&laquo;"/>
                </div>
            </div>
        </div>
        <div class="col-md-6 chit-chat-layer1-rit">    	
            <div class="work-progres">
                <div class="chit-chat-heading">
                    Phản hồi
                </div>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Người gửi</th>
                                <!--<th>Số điện thoại</th>-->                                   

                                <!--<th>Email</th>-->
                                <th>Nội dung</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach items="${lstfb}" var="f" varStatus="i">
                                <tr>
                                <td>${i.index + 1 + offsetfb}</td>
                                <td>${f.feedBackName}</td>
                                <!--<td>${f.feedBackPhone}</td>-->                                 

                                <!--<td>${f.feedBackEmail}</td>-->
                                <td>${f.feedBackContent}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <tag:PaginationHandle count="${totalfb}" uri="home.htm" offset="${offsetfb}" steps="5" next="&raquo;" previous="&laquo;"/>
                </div>
            </div>
        </div>
        <!--</div>-->
        <div class="clearfix"> </div>
    </div>
    <!--main page chit chating end here-->
    <!--main page chart start here-->
    <div class="main-page-charts">
        <div class="main-page-chart-layer1">
            <div class="col-md-12 chart-layer1-left"> 
                <div class="work-progres">
                    <div class="chit-chat-heading">
                        Sản phẩm
                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Tên Sách</th>
                                    <th>Tác Giả</th>                                   

                                    <th>Quốc Gia</th>
                                    <th>Nhà Xuất Bản</th>
                                    <th>Giá</th>
                                    <th>Ngày Thêm</th>
                                    <th>Trạng Thái</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listP}" var="b" varStatus="i">
                                    <tr>
                                        <td>${i.index+1+offset}</td>
                                        <td><span class="label label-danger">${b.productName}</span></td>
                                        <td><span class="label label-warning">${b.authorId.authorName}</span></td>

                                        <td>${b.countryId.countryName}</td>                                 
                                        <td>${b.publisherId.publisherName}</td>
                                        <td><fmt:formatNumber value="${b.productDiscount!=null?b.productDiscount:b.productPrice}"></fmt:formatNumber></td>
                                        <td><fmt:formatDate value="${b.productAddedTime}"></fmt:formatDate></td>
                                        <td><span class="${b.productStatus?"label label-success":"label label-info"}">${b.productStatus?"Active":"Inactive"}</span></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <tag:PaginationHandle count="${total}" uri="home.htm" offset="${offset}" steps="5" next="&raquo;" previous="&laquo;"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<!--main page chart layer2-->

<!--climate start here-->
<!--climate end here-->
<!--</div>-->
<!--inner block end here-->

<jsp:include page="menu.jsp" flush="true"></jsp:include>
