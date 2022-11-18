<%@page import="model.bean.Information"%>
<%@page import="model.bean.User"%>
<%@page import="model.bean.News"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
        <div class="container">
            <div class="quanly">
                QUẢN LÝ THÔNG TIN
            </div>
            <div class="table-responsive">
                <div class="row">
                    <div class="col-sm-6">
                        <a href="<%=request.getContextPath() %>/admin/infor/add" class="btn btn-success btn-md them">Thêm</a>
                    </div>
                </div>
                <div class="allbang">
                    <div class="ttbang">
                        <p>Danh sách thông tin</p>
                    </div>
                    <%
			        	String msg = request.getParameter("msg");
                    	String err = request.getParameter("err");
				    	if("1".equals(msg)){
				    		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Thêm thông tin thành công!</span>");
				    	}
				    	if("2".equals(msg)){
				    		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Sửa thông tin thành công!</span>");
				    	}
				    	if("3".equals(msg)){
				    		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Xóa thông tin thành công!</span>");
				    	}
				    	if("1".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Id không tồn tại!</span>");
				    	}
				    	if("2".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Xóa thông tin thất bại!</span>");
				    	}
				    	if("3".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Có lỗi xảy ra!</span>");
				    	}
			    	%>
                    <div class="bang">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Ngày sinh</th>
                                    <th>Email</th>
                                    <th>Địa chỉ</th>
                                    <th>Số điện thoại</th>
                                    <th>Nội dung</th>
                                    <th>Trạng thái</th>
                                    <th width="160px">Chức năng</th>
                                </tr>
                            </thead>
                            <%
                            	ArrayList<Information> listInfor = (ArrayList<Information>) request.getAttribute("listInfor");
                            	if(listInfor != null && listInfor.size() > 0){
                            		for(Information items: listInfor){
                            %>
                            <tbody>
                                <tr>
                                    <td><%=items.getName() %></td>
                                    <td class="center"><%=items.getDate() %></td>
                                    <td class="center"><%=items.getEmail() %></td>
                                    <td class="center"><%=items.getDiachi() %></td>
                                    <td class="center"><%=items.getPhone() %></td>
                                    <td class="center"><%=items.getContent() %></td>
                                    <td class="center" id="active-<%=items.getId()%>">
                                    	<%
                                    		if(items.getStatus() == 1){
                                    	%>
                                        <a href="javascript:void(0)" title="" class="btn btn-primary sua" style="background: #00FFFF; border:1px solid #00FFFF"> Đang hiển thị</a>
                                    	<% }else{ %>
                                        <a href="javascript:void(0)" onclick="return getActive(<%=items.getId() %>,1)" title="" class="btn btn-primary sua" style="background: green; border:1px solid green"> Hiển Thị</a>
                                    	<% } %>
                                    </td>
                                    <td class="center">
                                        <a href="<%=request.getContextPath() %>/admin/infor/edit?id=<%=items.getId() %>" title="" class="btn btn-primary sua"> Sửa</a>
                                        <a href="<%=request.getContextPath() %>/admin/infor/del?id=<%=items.getId() %>" title="" class="btn btn-danger xoa" onclick="return confirm('Bạn có chắc muốn xóa?')"> Xóa</a>
                                    </td>
                                </tr>
                            </tbody>
                            <script type="text/javascript">
								function getActive(iid,trangthai){
									$.ajax({
										url: '<%=request.getContextPath()%>/admin/infors',
										type: 'POST',
										cache: false,
										data: {
											aiid: iid,
											atrangthai: trangthai
										},
										success: function(data){
											tmp = "#active-"+iid;
											$(tmp).html(data);
										},
										error: function (){
											alert('Có lỗi xảy ra');
										}
									});
									return false;
								}
							</script>
                            <% } }else{ %>
                            <tbody>
                                <tr>
                                    <td colspan="5" align="center">Chưa có thông tin</td>
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
        		<li ><a class="<%if(currentPage == 1){out.print("disabled");} %>" href="<%=request.getContextPath()%>/admin/infors?page=<%=currentPage - 1%>"><<</a></li>
        		<% for(int n = 1; n <= numberOfPages ; n++){ %>
        		<li "><a class="<% if(n == currentPage){out.print("active");}%>" href="<%=request.getContextPath()%>/admin/infors?page=<%=n%>"><%=n %></a></li>
        		<% } %>
        		<li ><a class="<%if(currentPage == numberOfPages){out.print("disabled");} %>" href="<%=request.getContextPath()%>/admin/infors?page=<%=currentPage + 1%>">>></a></li>
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