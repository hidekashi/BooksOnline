<%-- 
    Document   : menu
    Created on : May 29, 2019, 5:28:11 PM
    Author     : Hide
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--copy rights start here-->
<div class="copyrights">
	 <p>© 2019 BookShop</p>
</div>	
<!--COPY rights end here-->
</div>
</div>
<!--slider menu-->
    <div class="sidebar-menu">
		  	<div class="logo"> <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> <a href="#"> <span id="logo" ></span> 
			      <!--<img id="logo" src="" alt="Logo"/>--> 
			  </a> </div>		  
		    <div class="menu">
		      <ul id="menu" >
		        <li id="menu-home" ><a href="${pageContext.request.contextPath}/admin/home.htm"><i class="fa fa-tachometer"></i><span>Dashboard</span></a></li>
                        <li id="menu-comunicacao" ><a href="${pageContext.request.contextPath}/admin/product.htm"><i class="fa fa-book nav_icon"></i><span>Quản lý sản phẩm</span></a>
		        <li><a href="#"><i class="fa fa-cogs"></i><span>Quản lý danh mục</span><span class="fa fa-angle-right" style="float: right"></span></a>
		          <ul>
		            <li><a href="${pageContext.request.contextPath}/admin/category.htm">Danh mục</a></li>
		            <li><a href="${pageContext.request.contextPath}/admin/publisher.htm">Nhà xuất bản</a></li>
		            <li><a href="${pageContext.request.contextPath}/admin/country.htm">Xuất xứ</a></li>
		            <li><a href="${pageContext.request.contextPath}/admin/author.htm">Tác giả</a></li>		            
		          </ul>
		        </li>
		        <li id="menu-comunicacao" >
                            <a href="${pageContext.request.contextPath}/admin/order.htm">
                                <i class="fa fa-book nav_icon"></i><span>Quản lý đơn hàng</span>
                            </a>
		        </li>
                        
                        <li>
                            <a href="${pageContext.request.contextPath}/admin/customer.htm"><i class="fa fa-user"></i><span>Khách hàng</span>
                            </a>
                        </li>
                        
		          <!--<li><a href="maps.html"><i class="fa fa-map-marker"></i><span>Tin tức</span></a></li>-->
<!--		        <li id="menu-academico" >
                            <a href="#"><i class="fa fa-file-text"></i><span>Hình ảnh</span></a>
		        </li>-->
		        
<!--		        <li><a href="charts.html"><i class="fa fa-bar-chart"></i><span>Mã giảm giá</span></a></li>
		        <li><a href="charts.html"><i class="fa fa-shopping-cart"></i><span>Khuyến mãi</span></a></li>-->
		        <li><a href="${pageContext.request.contextPath}/admin/feedback.htm"><i class="fa fa-envelope"></i><span>Phản hồi</span></a></li>
		        </li>
		         <li><a href="${pageContext.request.contextPath}/admin/admin.htm"><i class="fa fa-cog"></i><span>Admin</span></span></a></li>
		         <!-- <li><a href="#"><i class="fa fa-shopping-cart"></i><span>E-Commerce</span><span class="fa fa-angle-right" style="float: right"></span></a>
		         	<ul id="menu-academico-sub" >
			            <li id="menu-academico-avaliacoes" ><a href="product.html">Product</a></li>
			            <li id="menu-academico-boletim" ><a href="price.html">Price</a></li>
		             </ul>
		         </li> -->
		      </ul>
		    </div>
	 </div>
	<div class="clearfix"> </div>
	</div>
<!--slide bar menu end here-->
<script>
var toggle = true;
            
$(".sidebar-icon").click(function() {                
  if (toggle)
  {
    $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
    $("#menu span").css({"position":"absolute"});
  }
  else
  {
    $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
    setTimeout(function() {
      $("#menu span").css({"position":"relative"});
    }, 400);
  }               
                toggle = !toggle;
            });
            
</script>
<!--scrolling js-->
		<script src="/BooksOnline/views/backend/assets/js/jquery.nicescroll.js"></script>
		<script src="/BooksOnline/views/backend/assets/js/scripts.js"></script>
		<!--//scrolling js-->
<script src="/BooksOnline/views/backend/assets/js/bootstrap.js"> </script>
<!-- mother grid end here-->
</body>
</html>     
