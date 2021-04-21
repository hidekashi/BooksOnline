<%-- 
    Document   : updateProduct
    Created on : Jun 23, 2019, 11:25:57 AM
    Author     : Hide
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
    <div class="inner-block">
        <div class="cols-grids panel-widget">   	
            <div id="rightContent">
                <h2>Chỉnh sửa sản phẩm</h2>

                <c:if test="${message!=null}" >
                <div class="sukses" style="border: 1px solid #86afe7; background: #e7f1ff no-repeat left center; width: 640px; height: 50px; padding-top: 15px;">
                    ${message}
                </div>
            </c:if><br/>
            <spring:form action="updateProduct.htm" commandName="productId" enctype="multipart/form-data">
                    <table width="52%">
                            <tr>
                                <td><b>#</b></td>
                                <td><spring:input readonly="true" type="text" path="productId"  class="form-control"/></td>
                            </tr>
                            <tr>
                                <td><b>Sản phẩm</b></td>
                                <td><spring:input type="text" path="productName"  class="form-control"/></td>
                            </tr><br/>
                        <tr>
                            <td><b>Ngày thêm</b></td>
                            <td><spring:input type="date" path="productAddedTime"  class="form-control"/></td>
                        </tr>
                        <tr>
                            <td><b>Ảnh đại diện</b></td>
                            <td>
                                <spring:input type="file" path="productFeatureImage"  class="form-control"/>                           
                                <spring:hidden path="imageOld"/>
                            </td>
                        </tr>
                        <tr>
                            <td><b>Số lượng</b></td>
                            <td>
                                <spring:input type="number" path="productQuantity"  class="form-control"/>
                             
                            </td>
                        </tr>
                        <tr>
                            <td><b>Tác giả</b></td>
                            <td>
                                <spring:select type="text" path="authorId.authorId"  class="form-control">
                                    <spring:options items="${listAuthor}" itemLabel="authorName" itemValue="authorId"/>
                                </spring:select> 
                            </td>
                        </tr>
                        <tr>
                            <td><b>Nhà xuất bản</b></td>
                            <td> <spring:select type="text" path="publisherId.publisherId"  class="form-control">
                                    <spring:options items="${listPub}" itemLabel="publisherName" itemValue="publisherId"/>
                                </spring:select> </td>
                        </tr>
                        <tr>
                            <td><b>Xuất xứ</b></td>
                            <td> <spring:select type="text" path="countryId.countryId"  class="form-control">
                                    <spring:options items="${listCountry}" itemLabel="countryName" itemValue="countryId"/>
                                </spring:select> </td>
                        </tr>
                        <tr>
                            <td><b>Danh mục</b></td>
                            <td> <spring:select type="text" path="categoryId.categoryId"  class="form-control">
                                    <spring:options items="${listCate}" itemLabel="categoryName" itemValue="categoryId"/>
                                </spring:select> </td>
                        </tr>
                        <tr>
                            <td><b>Giá gốc</b></td>
                            <td><spring:input type="number" path="productPrice"  class="form-control"/></td>
                        </tr>
                        <tr>
                            <td><b>Giá khuyến mãi</b></td>
                            <td><spring:input type="number" path="productDiscount"  class="form-control"/></td>
                        </tr>
                        <tr>
                            <td><b>Mô tả</b></td>
                            <td><spring:textarea path="productDescription" class="form-control" rows="3" required="required"></spring:textarea></td>
                        </tr>
                        <tr>
                            <td><b>Trạng thái</b></td>						
                            <td>
                            <spring:checkbox path="productStatus" value="true"></spring:checkbox>
                        </td>
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
<!--                            <input type="submit" class="btn btn-success" value="Lưu dữ liệu" style="margin: 20px 0 20px 350px;">      -->
            </spring:form>					       
           
            </div>
            <div class="clear"></div>
        </div>	
    </div>
<jsp:include page="menu.jsp" flush="true"></jsp:include>