<%-- 
    Document   : orderConfirm
    Created on : Jun 29, 2019, 9:15:41 AM
    Author     : Hide
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <!-- products-breadcrumb -->
    <div class="products-breadcrumb">
        <div class="container custom-breadcrumb">
            <ul>
                <li><i class="fa fa-home" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/client/home.htm">Trang chủ</a><span>|</span></li>
            <li>Đặt hàng</li>
        </ul>
    </div>
</div>
<!-- //products-breadcrumb -->
<jsp:include page="navbar.jsp" flush="true"></jsp:include>

    <script>


        function validate() {
            var tinh = document.getElementById("orderTinhTP").value;
            var huyen = document.getElementById("orderQuanHuyen").value;
            var xa = document.getElementById("orderXaPhuong").value;
            var so = document.getElementById("orderSoNha").value;
            if (tinh !== "" && huyen !== "" && xa !== "" && so !== "") {
                return true;
            } else {
                if (tinh === "") {
                    alert("Bạn phải chọn tỉnh!");
                    document.getElementById("orderTinhTP").focus();
                    return false;
                }
                if (huyen === "") {
                    alert("Bạn phải chọn huyện.");
                    document.getElementById("orderQuanHuyen").focus();
                    return false;
                }
                if (xa === "") {
                    alert("Bạn phải chọn xã phường.");
                    document.getElementById("orderXaPhuong").focus();
                    return false;
                }
                if (so === "") {
                    alert("Bạn phải nhập số nhà.");
                    document.getElementById("orderSoNha").focus();
                    return false;
                } 
            }
        }
    </script>

    <div class="w3l_banner_nav_right">
        <!-- about -->
        <div class="privacy about">
            <h3>Xác nhận đơn hàng</h3>
            <div class="checkout-left">	
                
                <div class="col-md-4 checkout-left-basket">
                    <h4 style="background: gray">Đơn hàng</h4>
                    <ul>
                        <c:forEach items="${listCart}" var="c">
                            <li>${c.product.productName} x ${c.quantity} <i>:</i> <span><fmt:formatNumber value="${c.product.productDiscount>0?c.product.productDiscount*c.quantity:c.product.productPrice*c.quantity}" type="currency"></fmt:formatNumber></span></li>
                                    </c:forEach>
                        <li>-----------------------------------------------------</li>
                        <li>Tổng tiền <i>:</i> <span>${totalPrice!=null?totalPrice:""} ₫</span></li>
                    </ul>
                </div>
                
                <div class="col-md-8 address_form_agile">
                    <!--<h4>Thêm địa chỉ mới</h4>-->
                    <form action="checkOutConfirm.htm" onsubmit="return validate()" class="creditly-card-form agileinfo_form">
                    <section class="creditly-wrapper wthree, w3_agileits_wrapper">
                        <div class="information-wrapper">
                            <div class="first-row form-group">
                                <!-- <div class="controls">
                                        <label class="control-label">Tên đầy đủ: </label>
                                        <input class="billing-address-name form-control" type="text" name="name" placeholder="Full name">
                                </div> -->
                                <div class="w3_agileits_card_number_grids">
                                    <div class="w3_agileits_card_number_grid_left">
                                        <!-- <div class="controls">
                                                <label class="control-label">Số di động:</label>
                                                <input class="form-control" type="text" placeholder="Mobile number">
                                        </div> -->
                                    </div>
                                    <div class="w3_agileits_card_number_grid_right">
                                        <div class="controls">
                                            <label class="control-label">Tỉnh/Thành phố: </label>                                                                                                   
                                            <select name="orderTinhTP" id="orderTinhTP" class="form-control custom-control">
                                                <option id="city" value="">Chọn Tỉnh/Thành phố</option>
                                                <c:forEach items="${tinhtp}" var="t">
                                                    <option value="${t.matp}">${t.name}</option>
                                                </c:forEach>
                                                <!--<option value="2">Quỳnh Lâm</option>-->
                                            <select>
                                        </div>
                                    </div>
                                    <div class="w3_agileits_card_number_grid_right">
                                        <div class="controls">
                                            <label class="control-label">Quận/Huyện: </label>                                                                  
                                            <select name="orderQuanHuyen" id="orderQuanHuyen" class="form-control custom-control">
                                                <option value="">Chọn Quận/Huyện</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="w3_agileits_card_number_grid_right">
                                        <div class="controls">
                                            <label class="control-label">Phường/Xã: </label>
                                            <select name="orderXaPhuong" id="orderXaPhuong" class="form-control custom-control">
                                                <option value="">Chọn Phường/Xã</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="w3_agileits_card_number_grid_right">
                                        <div class="controls">
                                            <label class="control-label">Địa chỉ: </label>
                                            <textarea name="orderSoNha" id="orderSoNha" class="form-control custom-control" rows="3" placeholder="Ví dụ: 52, đường Trần Hưng Đạo"></textarea>
                                        </div>
                                    </div>
                                    <input name="customerId" value="${us.customerId}" hidden/>
                                    <div class="clear"> </div>
                                </div>
                            </div>
                            <button class="submit check_out">Đặt hàng</button>
                        </div>
                    </section>
                <form>
<!--                <div class="checkout-right-basket">
                    <a href="payment.html">Thanh toán <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
                </div>-->
            </div>
                                                
                

            <div class="clearfix"> </div>

        </div>

    </div>
    <!-- //about -->
</div>
<div class="clearfix"></div>
</div>


<!-- footer -->
<div class="footer">
    <div class="container">
        <div class="col-md-3 w3_footer_grid">
            <h3>Thông tin</h3>
            <ul class="w3_footer_grid_list">
                <li><a href="events.html">Sự kiện</a></li>
                <li><a href="about.html">Giới thiệu</a></li>
                <li><a href="products.html">Sản phẩm đề xuất</a></li>
                <li><a href="services.html">Chương trình khuyến mãi</a></li>
            </ul>
        </div>
        <div class="col-md-3 w3_footer_grid">
            <h3>Thông tin chính sách</h3>
            <ul class="w3_footer_grid_list">
                <li><a href="faqs.html">Câu hỏi thường gặp</a></li>
                <li><a href="privacy.html">Chính sách bảo mật</a></li>
                <li><a href="privacy.html">Chính sách đổi trả</a></li>
            </ul>
        </div>
        <div class="col-md-3 w3_footer_grid">
            <h3>Nhà cung cấp hàng đầu</h3>
            <ul class="w3_footer_grid_list">
                <li><a href="pet.html">Nhà sách Nhã Nam</a></li>
                <li><a href="frozen.html">Nhà sách Phương Nam</a></li>
                <li><a href="kitchen.html">Nhà sách Văn Minh</a></li>
                <li><a href="products.html">Thanh Hà Books</a></li>
            </ul>
        </div>
        <div class="col-md-3 w3_footer_grid">
            <h3>Tin tức</h3>
            <ul class="w3_footer_grid_list1">
                <li><label class="fa fa-twitter" aria-hidden="true"></label><i>01 ngày trước</i><span>Attack on titan chương 112</span></li>
                <li><label class="fa fa-twitter" aria-hidden="true"></label><i>02 ngày trước</i><span>Tác giả truyện tranh Doremon qua đời ở tuổi 53</span></li>
            </ul>
        </div>
        <div class="clearfix"> </div>
        <div class="agile_footer_grids">
            <div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
                <div class="w3_footer_grid_bottom">
                    <h4>100% thanh toán bảo mật</h4>
                    <img src="/BooksOnline/views/frontend/assets/images/card.png" alt=" " class="img-responsive" />
                </div>
            </div>
            <div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
                <div class="w3_footer_grid_bottom">
                    <h5>Kết nối với chúng tôi</h5>
                    <ul class="agileits_social_icons">
                        <li><a href="#" class="facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                        <li><a href="#" class="twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                        <li><a href="#" class="google"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
                        <li><a href="#" class="instagram"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                        <li><a href="#" class="dribbble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="wthree_footer_copy">
            <p>© 2018 Book online</p>
        </div>
    </div>
</div>
<input hidden="" value="${status}" id="add-mail-status"/>
<input hidden="" value="${account}" id="test-account"/>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="/BooksOnline/views/frontend/assets/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $(".dropdown").hover(
                function () {
                    $('.dropdown-menu', this).stop(true, true).slideDown("fast");
                    $(this).toggleClass('open');
                },
                function () {
                    $('.dropdown-menu', this).stop(true, true).slideUp("fast");
                    $(this).toggleClass('open');
                }
        );

        var status = document.getElementById("add-mail-status").value;
        if (status !== null && status !== undefined && status !== "")
            alert(status);
        
        var account = document.getElementById("test-account").value;
        if (account !== null && account !== undefined && account !== "") {
            document.getElementById('login-dropdown').innerHTML = "";
            $("#login-dropdown").append('<li class="after-login customer-user">${account}</li>');
            $("#login-dropdown").append('<li class="after-login"><a href="logout.htm">Đăng xuất</a></li>');
//            $(".pre-login").css("hidden","true");
//            $(".after-login").css("hidden","false");
        }
        
        
            
    });
</script>
<!-- here stars scrolling icon -->
<script type="text/javascript">
    $(document).ready(function () {
        /*
         var defaults = {
         containerID: 'toTop', // fading element id
         containerHoverID: 'toTopHover', // fading element hover id
         scrollSpeed: 1200,
         easingType: 'linear' 
         };
         */

        $().UItoTop({easingType: 'easeOutQuart'});



    });
</script>
<script>

    function loadHuyenByTinh() {
        var orderTinhTP = $("#orderTinhTP").val();
        console.log(orderTinhTP);
        console.log("11111111111111111111111");
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/clientAjax/loadQuanHuyen.htm",
            data: {matp: orderTinhTP},
            dataType: "json",
            success: function (data) {
                console.log("data" + data);
                var arrData = JSON.parse(data);

                $.each(arrData, function (i, val) {
                    console.log(val.name);
                        $("#orderQuanHuyen").append('<option class="under-city" id="district" value="'+ val.maqh + '">'+ val.name +'</option>');
                });
            },
            error: function () {
                console.log('loi roiiiiiiiiiiiiiiiiiiiiii!');
            }
        });
    }
    
    function loadXaByHuyen() {
        var orderHuyen = $("#orderQuanHuyen").val();
        console.log(orderHuyen);
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/clientAjax/loadXa.htm",
            data: {maqh: orderHuyen},
            dataType: "json",
            success: function (data) {
                console.log("data" + data);
                var arrData = JSON.parse(data);

                $.each(arrData, function (i, val) {
                    console.log(val.name);
                        $("#orderXaPhuong").append('<option class="under-city under-district" id="ward" value="'+ val.xaid + '">'+ val.name +'</option>');
                });
            },
            error: function () {
                console.log('loi roiiiiiiiiiiiiiiiiiiiiii!');
            }
        });
    }

    $(function () {
        $("#orderTinhTP").change(function () {
            document.getElementById('orderQuanHuyen').innerHTML = "";
            document.getElementById('orderXaPhuong').innerHTML = "";
            $("#orderQuanHuyen").append('<option value="">Chọn Quận/Huyện</option>');
            $("#orderXaPhuong").append('<option value="">Chọn Phường/Xã</option>');
            loadHuyenByTinh();
        });
        
        $("#orderQuanHuyen").change(function () {
            document.getElementById('orderXaPhuong').innerHTML = "";
            $("#orderXaPhuong").append('<option value="">Chọn Phường/Xã</option>');
            loadXaByHuyen();
        });
    });

</script>
</body>
</html>
