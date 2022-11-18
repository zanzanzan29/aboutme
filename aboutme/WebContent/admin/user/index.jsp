<%@page import="model.bean.User"%>
<%@page import="model.bean.News"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
        <div class="container">
            <div class="quanly">
                QUẢN LÝ NGƯỜI DÙNG
            </div>
            <div class="table-responsive">
                <div class="row">
                    <div class="col-sm-6">
                    <%
                    	User userLog = (User) session.getAttribute("userLogin");
                    	if("Admin".equals(userLog.getChucvu())){
                    %>
                        <a href="<%=request.getContextPath() %>/admin/user/add" class="btn btn-success btn-md them">Thêm</a>
                     <% } %>
                    </div>
                </div>
                <div class="allbang">
                    <div class="ttbang">
                        <p>Danh sách người dùng</p>
                    </div>
                    <%
			        	String msg = request.getParameter("msg");
                    	String err = request.getParameter("err");
				    	if("1".equals(msg)){
				    		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Thêm người dùng thành công!</span>");
				    	}
				    	if("2".equals(msg)){
				    		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Sửa người dùng thành công!</span>");
				    	}
				    	if("3".equals(msg)){
				    		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Xóa người dùng thành công!</span>");
				    	}
				    	if("1".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Id không tồn tại!</span>");
				    	}
				    	if("2".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Xóa người dùng thất bại!</span>");
				    	}
				    	if("3".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Có lỗi xảy ra!</span>");
				    	}
				    	if("4".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Không có quyền thêm người dùng!</span>");
				    	}
				    	if("5".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Không có quyền sửa!</span>");
				    	}
				    	if("6".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Không có quyền xóa!</span>");
				    	}
			    	%>
                    <div class="bang">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                                <tr>
                                    <th>ID người dùng</th>
                                    <th>Username</th>
                                    <th>Fullname</th>
                                    <th>Chức vụ</th>
                                    <th width="160px">Chức năng</th>
                                </tr>
                            </thead>
                            <%
                            	ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listUser");
                            	if(listUser != null && listUser.size() > 0){
                            		for(User items: listUser){
                            %>
                            <tbody>
                                <tr>
                                    <td><%=items.getId() %></td>
                                    <td class="center"><%=items.getUsername() %></td>
                                    <td class="center"><%=items.getFullname() %></td>
                                    <td class="center"><%=items.getChucvu() %></td>
                                    <td class="center">
                                    <%
                                    	if("Admin".equals(userLog.getChucvu()) || items.getId() == userLog.getId()){
                                    %>
                                        <a href="<%=request.getContextPath() %>/admin/user/edit?id=<%=items.getId() %>" title="" class="btn btn-primary sua"> Sửa</a>
                                    <% } %>    
                             		<% if("Admin".equals(userLog.getChucvu()) && !"Admin".equals(items.getChucvu())){ %>
                                        <a href="<%=request.getContextPath() %>/admin/user/del?id=<%=items.getId() %>" title="" class="btn btn-danger xoa" onclick="return confirm('Bạn có chắc muốn xóa?')"> Xóa</a>
                                    <% } %>
                                    </td>
                                </tr>
                            </tbody>
                            <% } }else{ %>
                            <tbody>
                                <tr>
                                    <td colspan="5" align="center">Chưa có người dùng</td>
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
        		<li ><a class="<%if(currentPage == 1){out.print("disabled");} %>" href="<%=request.getContextPath()%>/admin/users?page=<%=currentPage - 1%>"><<</a></li>
        		<% for(int n = 1; n <= numberOfPages ; n++){ %>
        		<li "><a class="<% if(n == currentPage){out.print("active");}%>" href="<%=request.getContextPath()%>/admin/users?page=<%=n%>"><%=n %></a></li>
        		<% } %>
        		<li ><a class="<%if(currentPage == numberOfPages){out.print("disabled");} %>" href="<%=request.getContextPath()%>/admin/users?page=<%=currentPage + 1%>">>></a></li>
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
    document.getElementById("nguoidung").classList.add('active');
</script>
        <%@ include file="/templates/admin/inc/footer.jsp" %>