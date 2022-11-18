<%@page import="model.bean.Project"%>
<%@page import="model.bean.News"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
        <div class="container">
            <div class="quanly">
                QUẢN LÝ DỰ ÁN
            </div>
            <div class="table-responsive">
                <div class="row">
                    <div class="col-sm-6">
                        <a href="<%=request.getContextPath() %>/admin/project/add" class="btn btn-success btn-md them">Thêm</a>
                    </div>
                </div>
                <div class="allbang">
                    <div class="ttbang">
                        <p>Danh sách dự án</p>
                    </div>
                    <%
			        	String msg = request.getParameter("msg");
                    	String err = request.getParameter("err");
				    	if("1".equals(msg)){
				    		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Thêm dự án thành công!</span>");
				    	}
				    	if("2".equals(msg)){
				    		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Sửa dự án thành công!</span>");
				    	}
				    	if("3".equals(msg)){
				    		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Xóa dự án thành công!</span>");
				    	}
				    	if("1".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Id không tồn tại!</span>");
				    	}
				    	if("2".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Xóa dự án thất bại!</span>");
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
                                    <th>Tên dự án</th>
                                    <th>Link</th>
                                    <th>Hình ảnh</th>
                                    <th width="160px">Chức năng</th>
                                </tr>
                            </thead>
                            <%
                            	ArrayList<Project> listProject = (ArrayList<Project>) request.getAttribute("listProject");
                            	if(listProject != null && listProject.size() > 0){
                            		for(Project items: listProject){
                            %>
                            <tbody>
                                <tr>
                                    <td><%=items.getId() %></td>
                                    <td class="center"><%=items.getName() %></td>
                                    <td class="center"><%=items.getLink() %></td>
                                    <td class="center">
                                    	<img width="100px" height="100px" src="<%=request.getContextPath() %>/files/<%=items.getPicture() %>" alt="<%=items.getName()%>"/>
                                    </td>
                                    <td class="center">
                                        <a href="<%=request.getContextPath() %>/admin/project/edit?id=<%=items.getId() %>" title="" class="btn btn-primary sua"> Sửa</a>
                                        <a href="<%=request.getContextPath() %>/admin/project/del?id=<%=items.getId() %>" title="" class="btn btn-danger xoa" onclick="return confirm('Bạn có chắc muốn xóa?')"> Xóa</a>
                                    </td>
                                </tr>
                            </tbody>
                            <% } }else{ %>
                            <tbody>
                                <tr>
                                    <td colspan="6" align="center">Chưa có dự án</td>
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
        		<li ><a class="<%if(currentPage == 1){out.print("disabled");} %>" href="<%=request.getContextPath()%>/admin/projects?page=<%=currentPage - 1%>"><<</a></li>
        		<% for(int n = 1; n <= numberOfPages ; n++){ %>
        		<li "><a class="<% if(n == currentPage){out.print("active");}%>" href="<%=request.getContextPath()%>/admin/projects?page=<%=n%>"><%=n %></a></li>
        		<% } %>
        		<li ><a class="<%if(currentPage == numberOfPages){out.print("disabled");} %>" href="<%=request.getContextPath()%>/admin/projects?page=<%=currentPage + 1%>">>></a></li>
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
    document.getElementById("thongtin").classList.add('active');
</script>
        <%@ include file="/templates/admin/inc/footer.jsp" %>