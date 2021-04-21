<%-- 
    Document   : footer
    Created on : May 29, 2019, 5:29:11 PM
    Author     : Hide
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--copy rights start here-->
<div class="copyrights">
	 <p>© 2019 Books Online</p>
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
		        <li id="menu-home" ><a href="index.html"><i class="fa fa-tachometer"></i><span>Trang chủ</span></a></li>
		        <li><a href="#"><i class="fa fa-cogs"></i><span>Quản lý danh mục</span><span class="fa fa-angle-right" style="float: right"></span></a>
		          <ul>
		            <li><a href="grids.html">Danh mục</a></li>
		            <li><a href="grids.html">Nhà xuất bản</a></li>
		            <li><a href="grids.html">Xuất xứ</a></li>
		            <li><a href="portlet.html">Tác giả</a></li>		            
		          </ul>
		        </li>
		        <li id="menu-comunicacao" ><a href="#"><i class="fa fa-book nav_icon"></i><span>Quản lý đơn hàng</span></a>
		        </li>
		          <li><a href="maps.html"><i class="fa fa-map-marker"></i><span>Tin tức</span></a></li>
		        <li id="menu-academico" ><a href="#"><i class="fa fa-file-text"></i><span>Hình ảnh</span></a>
		        </li>
		        
		        <li><a href="charts.html"><i class="fa fa-bar-chart"></i><span>Mã giảm giá</span></a></li>
		        <li><a href="charts.html"><i class="fa fa-shopping-cart"></i><span>Khuyến mãi</span></a></li>
		        <li><a href="charts.html"><i class="fa fa-envelope"></i><span>Phản hồi</span></a></li>
		        <li><a href="#"><i class="fa fa-user"></i><span>Khách hàng</span></a>
		        </li>
		         <li><a href="#"><i class="fa fa-cog"></i><span>Admin</span></span></a></li>
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
		<script src="assets/js/jquery.nicescroll.js"></script>
		<script src="assets/js/scripts.js"></script>
		<!--//scrolling js-->
<script src="assets/js/bootstrap.js"> </script>
<!-- mother grid end here-->
</body>
</html>
