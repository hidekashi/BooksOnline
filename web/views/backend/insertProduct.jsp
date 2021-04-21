<%-- 
    Document   : insertProduct
    Created on : Jun 16, 2019, 10:49:26 AM
    Author     : Hide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
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

    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <div id="rightContent">
                <h2>Thêm mới sản phẩm</h2>

<!--                <div class="informasi" style="border: 1px solid #cbe0b5; background: #f7ffe8 no-repeat left center;    width: 640px; height: 50px; padding-top: 15px; margin-bottom: 20px;">
                    Hãy chỉnh sửa dữ liệu cẩn thận nhé ^^
                </div>-->

            <c:if test="${message!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${message}
                </div>
            </c:if>
                <br/>
            <spring:form action="insertProduct.htm" commandName="newProduct" enctype="multipart/form-data">
                <table width="52%">
                    <tr>
                        <td><b>Tên Sách</b></td>
                        <td><spring:input type="text" path="productName" id="productName" class="form-control" /></td>
                    </tr>
                    <tr>
                        <td><b>Số lượng</b></td>
                        <td><spring:input type="number" min="0" value="0" path="productQuantity" id="productQuantity" class="form-control" /></td>
                    </tr><br/>
                    <!--                    <tr>
                                            <td><b>Ngày thêm</b></td>
                                            <td><input type="date" name="madahmuc" class="form-control"></td>
                                        </tr>-->
                    <tr>
                        <td><b>Ảnh</b></td>
                        <td><spring:input type="file" path="productFeatureImage" id="productFeatureImage" class="form-control" /></td>
                    </tr>
                    <tr>
                        <td><b>Danh mục</b></td>
                        <td>
                            <spring:select path="categoryId.categoryId" id="categoryId" class="form-control">
                                <c:forEach items="${listCate}" var="cate">
                                    <spring:option value="${cate.categoryId}">${cate.categoryName}</spring:option>
                                </c:forEach>
                            </spring:select>
                        </td>
                    </tr>
                    <tr>
                        <td><b>Tác giả</b></td>
                        <td>
                            <spring:select path="authorId.authorId" id="authorId" class="form-control">
                                <c:forEach items="${listA}" var="a">
                                    <spring:option value="${a.authorId}">${a.authorName}</spring:option>
                                </c:forEach>
                            </spring:select>
                        </td>
                    </tr>
                    <tr>
                        <td><b>Nhà xuất bản</b></td>
                        <td>
                            <spring:select path="publisherId.publisherId" id="publisherId" class="form-control">
                                <c:forEach items="${listPub}" var="pub">
                                    <spring:option value="${pub.publisherId}">${pub.publisherName}</spring:option>
                                </c:forEach>
                            </spring:select>
                        </td>
                    </tr>
                    <tr>
                        <td><b>Quốc gia</b></td>
                        <td>
                            <spring:select path="countryId.countryId" id="countryId" class="form-control">
                                <c:forEach items="${listC}" var="c">
                                    <spring:option value="${c.countryId}">${c.countryName}</spring:option>
                                </c:forEach>
                            </spring:select>
                        </td>
                    </tr>
                    <tr>
                        <td><b>Giá gốc</b></td>
                        <td><spring:input type="number" min="0" value="0" path="productPrice" id="productPrice" class="form-control" /></td>
                    </tr>
                    <tr>
                        <td><b>Giá khuyến mãi (nếu có)</b></td>
                        <td><spring:input type="number" min="0" value="0" path="productDiscount" id="productDiscount" class="form-control" /></td>
                    </tr>
                    <tr>
                        <td><b>Mô tả</b></td>
                        <td><spring:textarea path="productDescription" id="productDescription" class="form-control" rows="3" required="required"></spring:textarea></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <spring:button class="btn btn-success col-sm-4" style="margin: 20px 0 20px 50px;">Lưu dữ liệu</spring:button>
                                <spring:button class="btn btn-info col-sm-4" type="reset" style="margin: 20px 0 20px 30px"><a style="color:#FFF" href="${pageContext.request.contextPath}/admin/product.htm">Back to list</a></spring:button>
                                <div class="col-sm-4"></div>
                            </td>
                        </tr>
                    </table>
            </spring:form>	
        </div>
        <div class="clear"></div>
    </div>	
</div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>
