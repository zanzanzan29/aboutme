<%@page import="model.bean.Contact"%>
<%@page import="model.bean.User"%>
<%@page import="model.bean.News"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
        <div class="container">
            <div class="quanly">
                QUẢN LÝ LIÊN HỆ
            </div>
            <div class="table-responsive">
                <div class="allbang">
                    <div class="ttbang">
                        <p>Danh sách liên hệ</p>
                    </div>
                    <%
			        	String msg = request.getParameter("msg");
                    	String err = request.getParameter("err");
				    	if("3".equals(msg)){
				    		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Xóa liên hệ thành công!</span>");
				    	}
				    	if("1".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Id không tồn tại!</span>");
				    	}
				    	if("2".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Xóa liên hệ thất bại!</span>");
				    	}
				    	if("3".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Có lỗi xảy ra!</span>");
				    	}
			    	%>
                    <div class="bang">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Địa chỉ</th>
                                    <th>Số điện thoại</th>
                                    <th>Nội dung</th>
                                    <th width="160px">Chức năng</th>
                                </tr>
                            </thead>
                            <%
                            	ArrayList<Contact> listContact = (ArrayList<Contact>) request.getAttribute("listContact");
                            	if(listContact != null && listContact.size() > 0){
                            		for(Contact items: listContact){
                            %>
                            <tbody>
                                <tr>
                                    <td><%=items.getId() %></td>
                                    <td class="center"><%=items.getName() %></td>
                                    <td class="center"><%=items.getEmail() %></td>
                                    <td class="center"><%=items.getDiachi() %></td>
                                    <td class="center"><%=items.getPhone() %></td>
                                    <td class="center"><%=items.getNoidung() %></td>
                                    <td class="center">
                                        <a href="<%=request.getContextPath() %>/admin/contact/del?id=<%=items.getId() %>" title="" class="btn btn-danger xoa" onclick="return confirm('Bạn có chắc muốn xóa?')"> Xóa</a>
                                    </td>
                                </tr>
                            </tbody>
                            <% } }else{ %>
                            <tbody>
                                <tr>
                                    <td colspan="5" align="center">Chưa có liên hệ</td>
                                </tr>
                            </tbody>
                            <% } %>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%
        	int currentPage = (Integer) request.getAttribute("currentPage");
        	int numberOfPages = (Integer) request.getAttribute("numberOfPages");
        %>
        <div class="trang">
        	<ul class="center">
        		<%
        			if(numberOfPages > 1){
        		%>
        		<li ><a class="<%if(currentPage == 1){out.print("disabled");} %>" href="<%=request.getContextPath()%>/admin/contacts?page=<%=currentPage - 1%>"><<</a></li>
        		<% for(int n = 1; n <= numberOfPages ; n++){ %>
        		<li "><a class="<% if(n == currentPage){out.print("active");}%>" href="<%=request.getContextPath()%>/admin/contacts?page=<%=n%>"><%=n %></a></li>
        		<% } %>
        		<li ><a class="<%if(currentPage == numberOfPages){out.print("disabled");} %>" href="<%=request.getContextPath()%>/admin/contacts?page=<%=currentPage + 1%>">>></a></li>
        		<% } %>
        		<div class="clr"></div>
        	</ul>
        </div>
        <style type="text/css">
        	.trang{
        	width: 100%;
        	} 
        	.trang ul{
        		margin:20px 0px;
        		padding-left: 45%;
        	}
			.trang ul li{
				float: left;
				list-style: none;
				margin: 6px;
				
			}
			.disabled {
			  pointer-events: none;
			  background: #BBBBBB !important;
			}
			.trang ul .active{
				background: #3399FF;
			}
			.trang ul li a:hover{
				background: #3399FF;
			}
			.trang ul li a{
				color: white;
				background: #28a745;
				padding: 5px 10px;
			}
			.clr{
				clear: both;
			}
			
			
		</style>
<script>
    document.getElementById("lienhe").classList.add('active');
</script>
        <%@ include file="/templates/admin/inc/footer.jsp" %>