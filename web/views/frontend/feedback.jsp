<%-- 
    Document   : feedback
    Created on : Jun 9, 2019, 10:37:10 PM
    Author     : Hide
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <!-- products-breadcrumb -->
    <div class="products-breadcrumb">
        <div class="container custom-breadcrumb">
            <ul>
                <li><i class="fa fa-home" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/home.htm">Trang chủ</a><span>|</span></li>
                <li>Phản Hồi</li>
            </ul>
        </div>
    </div>
    <!-- //products-breadcrumb -->
<jsp:include page="navbar.jsp" flush="true"></jsp:include>

<script>


        function validate() {
            var feedBackName = document.getElementById("feedBackName").value;
            var feedBackEmail = document.getElementById("feedBackEmail").value;
            var feedBackPhone = document.getElementById("feedBackPhone").value;
            var feedBackContent = document.getElementById("feedBackContent").value;
            var pattern = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
            
            if (feedBackName !== "" && feedBackEmail !== "" && feedBackPhone !== "" && feedBackContent !== "") {
                return true;
            } else {
                if (feedBackName === "") {
                    alert("Bạn phải nhập họ tên!");
                    document.getElementById("feedBackName").focus();
                    return false;
                }
                if (feedBackEmail == "") {
                    alert("Bạn phải nhập email.");
                    document.getElementById("feedBackEmail").focus();
                    return false;
                } else {

                    if (!pattern.test(feedBackEmail)) {
                        alert("Bạn nhập sai định dạng email. Mời bạn nhập lại.");
                        document.getElementById("feedBackEmail").focus();
                        return false;
                    }
                }
                if (feedBackPhone === "") {
                    alert("Bạn phải nhập số điện thoại!");
                    document.getElementById("feedBackPhone").focus();
                    return false;
                }
                if (feedBackContent === "") {
                    alert("Bạn phải nhập nội dung.");
                    document.getElementById("feedBackContent").focus();
                    return false;
                }
            }
        }
    </script>

    <div class="w3l_banner_nav_right">
        <!-- mail -->
        <div class="mail">
            
        <div style="color: red;">${statusfb}</div>
            <h3>Phản hồi cho chúng tôi</h3>
            <div class="agileinfo_mail_grids">
                <div class="col-md-4 agileinfo_mail_grid_left">
                    <ul>
                        <li><i class="fa fa-home" aria-hidden="true"></i></li>
                        <li>Địa chỉ<span>107, Tô Hiệu, Nghĩa Tân, Cầu Giấy, Hà Nội</span></li>
                    </ul>
                    <ul>
                        <li><i class="fa fa-envelope" aria-hidden="true"></i></li>
                        <li>email<span><a href="mailto:info@example.com">feedback@bookonline.com</a></span></li>
                    </ul>
                    <ul>
                        <li><i class="fa fa-phone" aria-hidden="true"></i></li>
                        <li>liên lạc với chúng tôi<span>(+123) 233 2362 826</span></li>
                    </ul>
                </div>
                <div class="col-md-8 agileinfo_mail_grid_right">
                    
                    <spring:form action="addFeedback.htm" modelAttribute="fb" onsubmit="return validate()">
                        <div class="col-md-6 wthree_contact_left_grid">
                            <spring:input type="text" path="feedBackName" id="feedBackName" placeholder="Họ Tên..."/>
                            <spring:input type="email" id="feedBackEmail" path="feedBackEmail" placeholder="Email..."/>
                        </div>
                        <div class="col-md-6 wthree_contact_left_grid">
                            <spring:input type="text" path="feedBackPhone"  id="feedBackPhone" placeholder="Số điện thoại..."/>
                            <spring:input type="text" path="feedBackProductLink" id="feedBackProductLink" placeholder="Link sản phẩm nếu có..."/>
                        </div>
                        <div class="clearfix"> </div>
                        <spring:textarea  path="feedBackContent" id="feedBackContent" placeholder="Nội dung..."></spring:textarea>
                        <spring:button class="feedback-button" type="submit">Gửi</spring:button>
                        <spring:button class="feedback-button" type="reset">Đặt lại</spring:button>
                    </spring:form>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <!-- //mail -->
    </div>
    <div class="clearfix"></div>
</div>
<!-- //banner -->
<!-- map -->
<div class="map">
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.753171936847!2d105.79387121521711!3d21.042559992682275!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab3a30903e2f%3A0xda1e411fea010fb3!2zSGnhu4d1IHPDoWNoIE5ow6MgTmFt!5e0!3m2!1svi!2s!4v1544375140585" style="border:0" allowfullscreen></iframe>
</div>
<!-- //map -->

<jsp:include page="footer.jsp" flush="true"></jsp:include>