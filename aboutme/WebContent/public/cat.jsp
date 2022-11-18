<%@page import="util.StringUtil"%>
<%@page import="model.bean.Category"%>
<%@page import="model.bean.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>

<div class="newstrai">
	<h5>Bài viết xem nhiều</h5>
	<div class="tintrai">
	<%
		ArrayList<News> listNN = (ArrayList<News>) request.getAttribute("listNN");
		if(listNN != null && listNN.size() > 0 ){
			for(News itemNN: listNN){
	%>
		<div>
			<a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(itemNN.getCategory().getName()) %>-<%=itemNN.getCategory().getId() %>/<%=StringUtil.makeSlug(itemNN.getName()) %>-<%=itemNN.getId()%>"><img src="<%=request.getContextPath() %>/files/<%=itemNN.getPicture() %>" alt=""></a>
			<p><i class="fa fa-eye"></i> Lượt đọc:<%=itemNN.getView() %></p>
			<h6><a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(itemNN.getCategory().getName()) %>-<%=itemNN.getCategory().getId() %>/<%=StringUtil.makeSlug(itemNN.getName()) %>-<%=itemNN.getId()%>"><%if(itemNN.getName().length() > 50){out.print(itemNN.getName().substring(0, 50) + "...");}else{out.print(itemNN.getName());} %></a></h6>
		</div>
		<% } } %>
	</div>
</div>
<div class="newsgiua">
	<div class="lienquan">
		<% Category cat = (Category) request.getAttribute("cat"); %>
		<h2><%=cat.getName() %></h2>
		<%
			ArrayList<News> listNC = (ArrayList<News>) request.getAttribute("listNC");
			if(listNC != null && listNC.size() > 0){
				for(News itemNC: listNC){
		%>
		<div class="cactin">
			<a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(itemNC.getCategory().getName()) %>-<%=itemNC.getCategory().getId() %>/<%=StringUtil.makeSlug(itemNC.getName()) %>-<%=itemNC.getId()%>"><img src="<%=request.getContextPath() %>/files/<%=itemNC.getPicture() %>" alt=""></a>
			<h4><a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(itemNC.getCategory().getName()) %>-<%=itemNC.getCategory().getId() %>/<%=StringUtil.makeSlug(itemNC.getName()) %>-<%=itemNC.getId()%>"><%=itemNC.getName() %></a></h4>
		</div>
		<% } }  %>
		<div class="clr"></div>
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
        		<li ><a class="<%if(currentPage == 1){out.print("disabled");} %>" href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(cat.getName()) %>-<%=cat.getId() %>/page/<%=currentPage - 1%>"><<</a></li>
        		<% for(int n = 1; n <= numberOfPages ; n++){ %>
        		<li "><a class="<% if(n == currentPage){out.print("active");}%>" href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(cat.getName()) %>-<%=cat.getId() %>/page/<%=n%>"><%=n %></a></li>
        		<% } %>
        		<li ><a class="<%if(currentPage == numberOfPages){out.print("disabled");} %>" href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(cat.getName()) %>-<%=cat.getId() %>/page/<%=currentPage + 1%>">>></a></li>
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
</div>
<div class="newsphai">
	<h3>Danh mục bài viết</h3>
	<div>
		<%
			ArrayList<Category> listCat = (ArrayList<Category>) request.getAttribute("listCat");
			if(listCat != null && listCat.size() > 0){
				String active = "";
				for(Category itemsCat: listCat){
					if(itemsCat.getId() == cat.getId()){
						active = "active";
					}else{
						active = "";
					}
		%>
		<h4 class="<%=active%>"><a href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(itemsCat.getName()) %>-<%=itemsCat.getId() %>"><%=itemsCat.getName() %></a></h4>
		<% } } %>
	</div>
</div>
<div class="clr"></div>
<style type="text/css">
.newsgiua .lienquan {
}
.newsgiua .lienquan h2{
	margin-top: 11px;
	border-bottom: 1px solid #C0C0C0;
	padding-bottom: 20px;
	margin-bottom: 20px;
}
.newsgiua .lienquan .cactin{
	float: left;
	width: 30%;
	margin-right: 27px;
	margin-bottom: 20px;
}
.newsgiua .lienquan .cactin img{
	width: 250px;
	height: 200px;
}
.newsgiua .lienquan .cactin h4{
	font-size: 20px;
}
.newsgiua .lienquan .cactin h4 a{
	text-decoration: none;
	color: #3366CC;
}
.newsgiua .lienquan .cactin h4:hover a{
	color: #003399 !important;
}
.newsphai h3{
	background: #003300;
	color: white;
	font-size: 18px ;
	padding: 10px;
	border-radius: 5px;
	width: 255px; 
}
.newsphai div h4{
	font-size: 15px ;
	padding: 10px;
	width: 255px; 
	color: #3366CC;
	margin-top: 0;
}
.newsphai div h4 a{
	text-decoration: none;
	color: #3366CC;
}
.newsphai div h4:hover {
 	background: #C0C0C0;
	color: white !important;
	border-radius: 5px;
}
.newsphai div h4:hover a{
	color: white !important;
}
.newsphai div .active{
	border-radius: 5px;
	background: #C0C0C0;
	color: white;
}
.newsphai div .active a{
	color: white;
}
</style>
 <%@include file="/templates/public/inc/footer.jsp"%> 