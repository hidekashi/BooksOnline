<%-- 
    Document   : footer
    Created on : May 29, 2019, 8:18:12 PM
    Author     : Hide
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!-- newsletter -->
<div class="newsletter">
    <div class="container">
        <div class="w3agile_newsletter_left">
            <h3>đăng ký nhận thông tin mới từ chúng tôi</h3>
        </div>
        <div class="w3agile_newsletter_right">
            <!--            <form action="#" method="post">
                                <input type="email" name="Email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
                                <input type="submit" value="đăng ký ngay">
                            </form>-->
            <spring:form action="addEmail.htm"  modelAttribute="em">
                <spring:input path="emailRegistered" type="email" placeholder="Email..." />
                <spring:button class="btnEmail">đăng ký ngay</spring:button>
            </spring:form>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<!-- //newsletter -->
<!-- footer -->
<div class="footer">
    <div class="container">
        <div class="col-md-3 w3_footer_grid">
            <h3>Thông tin</h3>
            <ul class="w3_footer_grid_list">
                <li><a href="#">Sự kiện</a></li>
                <li><a href="#">Giới thiệu</a></li>
                <li><a href="#">Sản phẩm đề xuất</a></li>
                <li><a href="#">Chương trình khuyến mãi</a></li>
            </ul>
        </div>
        <div class="col-md-3 w3_footer_grid">
            <h3>Thông tin chính sách</h3>
            <ul class="w3_footer_grid_list">
                <li><a href="#">Câu hỏi thường gặp</a></li>
                <li><a href="#">Chính sách bảo mật</a></li>
                <li><a href="#">Chính sách đổi trả</a></li>
            </ul>
        </div>
        <div class="col-md-3 w3_footer_grid">
            <h3>Nhà cung cấp hàng đầu</h3>
            <ul class="w3_footer_grid_list">
                <li><a href="#">Nhà sách Nhã Nam</a></li>
                <li><a href="#">Nhà sách Phương Nam</a></li>
                <li><a href="#">Nhà sách Văn Minh</a></li>
                <li><a href="#">Thanh Hà Books</a></li>
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
<input hidden="" value="${testLogin}" id="test-login"/>
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
        var testLogin = document.getElementById("test-login").value;
        if (account !== null && account !== undefined && account !== "" && testLogin !== "testLogin") {
            document.getElementById('login-dropdown').innerHTML = "";
            $("#login-dropdown").append('<li class="after-login customer-user">${account}</li>');
            $("#login-dropdown").append('<li class="after-login"><a href="orderHistory.htm">Lịch sử mua hàng</a></li>');
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
