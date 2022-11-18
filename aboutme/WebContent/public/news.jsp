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
			<p><i class='fas fa-pen'></i> <%=itemNN.getNguoiviet() %>   <i class="fa fa-eye"></i> Lượt đọc:<%=itemNN.getView() %></p>
			<h6><a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(itemNN.getCategory().getName()) %>-<%=itemNN.getCategory().getId() %>/<%=StringUtil.makeSlug(itemNN.getName()) %>-<%=itemNN.getId()%>"><%if(itemNN.getName().length() > 50){out.print(itemNN.getName().substring(0, 50) + "...");}else{out.print(itemNN.getName());} %></a></h6>
		</div>
		<% } } %>
	</div>
</div>
<div class="newsgiua">
<%
	News itemN = (News) request.getAttribute("itemN");
	if(itemN != null){
%>
	<h4><%=itemN.getCategory().getName() %></h4>
	<div class="tingiua">
		<h3><%=itemN.getName() %></h3>
		<p class="icon"><i class='fas fa-pen'></i> <%=itemN.getNguoiviet() %>  <i class="fa fa-eye"></i> Lượt đọc:<%=itemN.getView() %></p>
		<p class="chitiet"><%=itemN.getMota() %></p>
		<img src="<%=request.getContextPath() %>/files/<%=itemN.getPicture() %>" alt="">
		<p class="chitiet"><%=itemN.getChitiet() %></p>
	
	</div>
	<div class="binhluan">
		<h3>Tham gia bình luận:</h3>
		<%
                String msg = request.getParameter("msg");
            	String err = request.getParameter("err");
			   	if("1".equals(msg)){
			   		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Bình luận thành công!</span>");
			   	}
			   	if("1".equals(err)){
			   		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Bình luận thất bại!</span>");
			   	}
         %>
		<form action="" method="post">
            <div class="form-row">
                <div class="form-group">
                    <input name="name" type="text" class="form-control bg-secondary border-0 py-4 px-3" placeholder="Nhập tên của bạn" value="" required/>
                </div>
            </div>
            <div class="form-group">
                <textarea name="message" class="form-control bg-secondary border-0 py-2 px-3" rows="5" placeholder="Nhập bình luận" required="required"></textarea>
            </div>
            <div>
                <button class="btn btn-primary font-weight-bold py-3 px-5" type="submit">Gửi bình luận</button>
            </div>
        </form>
	</div>
	<% } %>
	<div class="lienquan">
		<h2>BÀI VIẾT CÙNG CHUYÊN MỤC</h2>
		<%
			ArrayList<News> listNC = (ArrayList<News>) request.getAttribute("listNC");
			if(listNC != null && listNC.size() > 0){
				int a = 0;
				for(News itemNC: listNC){
					if(itemN.getId() != itemNC.getId()){
						a++;
						if(a < 4){
		%>
		<div class="cactin">
			<a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(itemNC.getCategory().getName()) %>-<%=itemNC.getCategory().getId() %>/<%=StringUtil.makeSlug(itemNC.getName()) %>-<%=itemNC.getId()%>"><img src="<%=request.getContextPath() %>/files/<%=itemNC.getPicture() %>" alt=""></a>
			<h4><a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(itemNC.getCategory().getName()) %>-<%=itemNC.getCategory().getId() %>/<%=StringUtil.makeSlug(itemNC.getName()) %>-<%=itemNC.getId()%>"><%=itemNC.getName() %></a></h4>
		</div>
		<%} } } } %>
		<div class="clr"></div>
	</div>
</div>
<div class="newsphai">
	<h3>Danh mục bài viết</h3>
	<div>
		<%
			ArrayList<Category> listCat = (ArrayList<Category>) request.getAttribute("listCat");
			if(listCat != null && listCat.size() > 0){
				String active = "";
				for(Category itemsCat: listCat){
					if(itemsCat.getId() == itemN.getCategory().getId()){
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
	padding-top: 67px;
}
.newsgiua .lienquan .cactin{
	float: left;
	width: 30%;
	margin-right: 27px;
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