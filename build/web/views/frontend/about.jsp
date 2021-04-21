<%-- 
    Document   : product
    Created on : Jun 9, 2019, 2:21:18 PM
    Author     : Hide
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <!-- products-breadcrumb -->
    <div class="products-breadcrumb">
        <div class="container custom-breadcrumb">
            <ul>
                <li><i class="fa fa-home" aria-hidden="true"></i><a href="${pageContext.request.contextPath}/client/home.htm">Trang chủ</a><span>|</span></li>
            <li>Giới thiệu</li>
        </ul>

    </div>

</div>

<!-- //products-breadcrumb -->
<jsp:include page="navbar.jsp" flush="true"></jsp:include>
    <div class="w3l_banner_nav_right">
        <div class="w3ls_w3l_banner_nav_right_grid">
            <!--<h3 style="margin-top:30px;">Sản Phẩm</h3>-->
            <div class="about">
                <div class="container">		
                    <h3 class="title text-center news-detail">Giới thiệu BookshopOnline</h3>
                    <br>
                    <p>❁ BookOnline là một trang bán hàng online chuyên về sách dành cho những khách hàng quan tâm đến lĩnh vực sách và yêu sách.
                        <br>
                        <br>
                        <br>
                        ❁ Từ khi thành lập đến nay, BookOnline luôn là trang web bán chạy tại Việt Nam và được ghi nhận từ nhiều người bạn của shop. Quan trọng hơn hết, BookOnline được hàng trăm khách hàng thường xuyên mua sắm trực tuyến đặt sự tin tưởng và tín nhiệm của mình trong suốtthời gian qua để BookOnline luôn được phục vụ và phát triển.
                        Với sứ mệnh xóa bỏ mọi giới hạn về không gian trong việc phân phối "tri thức" đến mọi miền đất nước bằng mô hình mua sắm trực tuyến hiện đại, từ miền núi đến hải đảo xa xôi, từ thành phố đến vùng quê và từ Việt Nam đến kiều bào ta ở trên toàn thế giới.
                        <br>
                        <br>
                        <br>
                        ❁ Mục tiêu của chúng tôi là luôn mở rộng thị trường sách trực tuyến cùng với đà phát triển của công nghệ thông tin. Để thực hiện mục tiêu đó, chúng tôi đã có những nhận thức đúng đắn về vai trò của nguồn nhân lực trong xây dựng và phát triển kinh doanh. Chúng tôi đã và đang không ngừng hoàn thiện hơn nữa môi trường làm việc với các trang thiết bị hiện đại, cung cách làm việc hiệu quả để ngày càng hoàn thiện việc phục vụ khách hàng.</p>
                    <br>
                    <br>
                    <br>
                    <p>❁ Thế Giới thời Trang Baby được thành lập vào 16 tháng 10 năm 2016. Tuy có “tuổi đời” non trẻ nhưng hiện nay đã có hàng triệu trẻ em Việt Nam đang sở hữu những mẫu quần áo trẻ em chất lượng từ Thế Giới Thời Trang Baby.</p>
                    <br>
                    <p>❁ Không chỉ là nơi được những khách hàng buôn sỉ, đại lý shop, đại lý bán hàng online,…tin dùng để lấy sỉ. Chúng tôi cũng đang nổi lực để xây dựng và phát triển chuỗi hệ thống cửa hàng quần áo trẻ em AN TOÀN dành cho trẻ em Việt Nam.</p>
                    <br>
                    <p>❁ Hiện tại, chúng tôi đang cung cấp hơn 5 ngàn sản phẩm AN TOÀN, TIỆN ÍCH, được chứng nhận an toàn cho cho trẻ em, không chỉ giúp bé yêu đẹp mà còn khỏe mạnh</p>
                    <br>
                    <p>❁ Thế Giới Thời Trang Baby mong muốn sẽ trở thành người bạn đồng hành đáng tin cậy của hàng triệu bà mẹ trẻ năng động trên khắp Việt Nam.</p>
                    <br>
                    <b>Đội ngũ BookOnline</b><br><br>
                    Với đội ngũ trẻ trung, yêu mến sách và với mong muốn thúc đẩy văn hóa đọc của người Việt, các nhân viên BookOnline sẵn sàng đáp ứng mọi nhu cầu quý khách về sách với chất lượng phục vụ tốt nhất.
                    <br>
                    <br>
                    <b>Phong cách BookOnline</b><br><br>

                    ▪ Phục vụ khách hàng tốt nhất, nhanh nhất, chu đáo nhất và tiết kiệm nhất.BookOnline là Nhà sách, vì vậy Dịch vụ của BookOnline hướng đến và hiểu những quý khách hàng là những người đọc sách. <br>
                    ▪ Hiện nay, BookOnline là nhà sách thường xuyên cập nhật tựa sách mới mỗi ngày.
                    <br>
                    <br>
                    <b>Dịch vụ BookOnline</b> <br> <br>
                    ▪  Đặt hàng trực tuyến, giao hàng tận nơi<br>
                    ▪ Sách trước khi giao được bao bọc cẩn thận trong thùng giấy hoặc túi giấy Kraft Vintage, lịch sự và bảo vệ môi trường<br>
                    ▪  Đội ngũ giao hàng trong thành phố thân thiện, tận tâm<br>
                    ▪ Sẵn sàng giao đến mọi miền đất nước thông qua dịch vụ giao hàng của Bưu Chính Việt Nam<br>
                    ▪  Chuyển sách đi nước ngoài thông qua dịch vụ chuyển phát nhanh DHL hoặc chuyển phát bằng máy bay.<br>
                    ▪ Nhiều hình thức thanh toán tiện lợi, trả trước bằng thẻ trực tuyến hoặc thu tiền tận nơi<br>
                    ▪  Dịch vụ bọc sách bằng bọc nhựa cao cấp, thực hiện tỉ mỉ và cẩn thận cho từng cuốn<br>
                    ▪  Dịch vụ gói quà, giúp quý khách gởi tặng những món quà tinh thần bổ ích đến những người thân yêu<br>
                    ▪  Dịch vụ chăm sóc khách hàng 7 ngày trong tuần, kể cả thứ 7 và chủ nhật thông qua tổng đài 19006401 hoặc hệ thống hỗ trợ khách hàng qua email tại email@bookonline.com hoặc các hình thức chat trực tuyến Yahoo Messenger, Skype và Facebook.<br>
                    ▪ Trong trường hợp quý khách có bất kỳ nhu cầu hay câu hỏi nào về sách, đừng ngần ngại gởi email về cho chúng tôi theo địa chỉ: hotro@bookonline.com hoặc tổng đài BookOnline 19006401.<br>

                </div>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
</div>
<jsp:include page="footer.jsp" flush="true"></jsp:include>