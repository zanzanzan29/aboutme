<%@page import="util.StringUtil"%>
<%@page import="model.bean.Information"%>
<%@page import="model.bean.Skill"%>
<%@page import="model.bean.Project"%>
<%@page import="model.bean.Changduong"%>
<%@page import="model.bean.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>


    <!-- Carousel Start -->
    <div class="container-fluid p-0 mb-5 pb-5" id="home">
        <div id="header-carousel" class="carousel slide carousel-fade" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item position-relative active" style="height: 100vh; min-height: 400px;">
                    <img class="position-absolute w-100 h-100" src="<%=request.getContextPath() %>/templates/public/img/carousel-1.jpg" style="object-fit: cover;">
                    <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                        <div class="p-3" style="max-width: 900px;">
                            <h1 class="display-1 font-secondary text-white mt-n3 mb-md-4">Quang Trường</h1>
                            <div class="d-inline-block border-top border-bottom border-light py-3 px-4">
                                <h3 class="text-uppercase font-weight-normal text-white m-0" style="letter-spacing: 2px;">- Web Developer -</h3>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item position-relative" style="height: 100vh; min-height: 400px;">
                    <img class="position-absolute w-100 h-100" src="<%=request.getContextPath() %>/templates/public/img/carousel-2.jpg" style="object-fit: cover;">
                    <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                        <div class="p-3" style="max-width: 900px;">
                            <h1 class="display-1 font-secondary text-white mt-n3 mb-md-4">Quang Trường</h1>
                            <div class="d-inline-block border-top border-bottom border-light py-3 px-4">
                                <h3 class="text-uppercase font-weight-normal text-white m-0" style="letter-spacing: 2px;">- Web Developer -</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev justify-content-start" href="#header-carousel" data-slide="prev">
                <div class="btn btn-primary px-0" style="width: 68px; height: 68px;">
                    <span class="carousel-control-prev-icon mt-3"></span>
                </div>
            </a>
            <a class="carousel-control-next justify-content-end" href="#header-carousel" data-slide="next">
                <div class="btn btn-primary px-0" style="width: 68px; height: 68px;">
                    <span class="carousel-control-next-icon mt-3"></span>
                </div>
            </a>
        </div>
    </div>
    <!-- Carousel End -->

	<%
		Information listInfo = (Information) request.getAttribute("listInfo");
		if(listInfo != null){
	%>

    <!-- Video Modal Start -->
    <div class="modal fade" id="videoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-body">
                	<h3> THÔNG TIN </h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button> 
                    <div>
                    	<img alt="" src="<%=request.getContextPath() %>/templates/public/img/3.jpg">	
                    </div>
                    <div class="thongtin">
                    	<h5> Chào bạn, mình là <%=listInfo.getName() %></h5>
                    	<p>Web Developer</p>
                    	<div class="ctthongtin">
                    		<div class="tungmuc">
                    			<p class="cung">Ngày sinh<p>
                    			<p class="cung">Số điện thoại<p>
                    			<p class="cung">Địa chỉ<p>
                    			<p class="cung">e-mail<p>
                    			
                    			
                    		</div>
                    		<div class="tungmuc">
                    			<p class="doi"><%=listInfo.getDate() %></p>
                    			<p class="doi"><%=listInfo.getPhone() %></p>
                    			<p class="doi"><%=listInfo.getDiachi() %></p>
                    			<p class="doi"><%=listInfo.getEmail() %></p>
                    			<div class="clr"></div>
                    		</div>
                    		<div class="clr"></div>
                    	</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <% } %>
    <!-- Video Modal End -->


    <!-- About Start -->
    <div class="container-fluid py-5" id="about">
        <div class="container py-5">
            <div class="section-title position-relative text-center">
                <h6 class="text-uppercase text-primary mb-3" style="letter-spacing: 3px;">About</h6>
                <h1 class="font-secondary display-4">Tôi Là Ai?</h1>
                <i class="far fa-heart text-dark"></i>
            </div>
            <div class="row m-0">
            <% if(listInfo != null){ %>
                <div">
                    <img class="position-absolute w-100 h-100" src="<%=request.getContextPath() %>/templates/public/img/3.jpg" style="object-fit: cover; width: 342px !important; height: 450px !important; ">
               		<div class = "position-relative mt">
	               		<div class="h-100 d-flex flex-column justify-content-center bg-secondary p-5 ">
	                        <h3 class="mb-3">Mục tiêu nghề nghiệp</h3>
	                        <p><%=listInfo.getContent() %></p>
	                        <button type="button" class="123 mx-auto" data-toggle="modal"
                                data-src="https://www.youtube.com/embed/DWRcNpR6Kdc" data-target="#videoModal">
                                XEM CHI TIẾT
                            </button>
	                    </div>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </div>
 
    
    <!-- About End -->
    


    <!-- Story Start -->
    <div class="container-fluid py-5" id="story">
        <div class="container pt-5 pb-3">
            <div class="section-title position-relative text-center">
                <h6 class="text-uppercase text-primary mb-3" style="letter-spacing: 3px;">Chặng đường</h6>
                <h1 class="font-secondary display-4">Chặng đường đã qua</h1>
                <i class="far fa-heart text-dark"></i>
            </div>
            <div class="container timeline position-relative p-0">
            <%
            	ArrayList<Changduong> listCd = (ArrayList<Changduong>) request.getAttribute("listCd");
            	if(listCd != null && listCd.size() > 0){
            		int i = 0;
            		for(Changduong items: listCd){
            			i++;
            			if(i % 2 != 0){
            %>
                <div class="row">
                    <div class="col-md-6 text-center text-md-right">
                        <img class="img-fluid mr-md-3" src="<%=request.getContextPath() %>/templates/public/img/story-1.jpg" alt="">
                    </div>
                    <div class="col-md-6 text-center text-md-left">
                        <div class="h-100 d-flex flex-column justify-content-center bg-secondary p-4 ml-md-3">
                            <h4 class="mb-2"><%=items.getName() %></h4>
                            <p class="text-uppercase mb-2"><%=items.getDate() %></p>
                            <p class="m-0"><%=items.getContent() %></p>
                        </div>
                    </div>
                </div>
                <% } else{ %>
                <div class="row">
                    <div class="col-md-6 text-center text-md-right">
                        <div class="h-100 d-flex flex-column justify-content-center bg-secondary p-4 mr-md-3">
                            <h4 class="mb-2"><%=items.getName() %></h4>
                            <p class="text-uppercase mb-2"><%=items.getDate() %></p>
                            <p class="m-0"><%=items.getContent() %></p>
                        </div>
                    </div>
                    <div class="col-md-6 text-center text-md-left">
                        <img class="img-fluid ml-md-3" src="<%=request.getContextPath() %>/templates/public/img/story-2.jpg" alt="">
                    </div>
                </div>
                <% } } } %>
            </div>
        </div>
    </div>
    <!-- Story End -->


    <!-- Gallery Start -->
    <div class="container-fluid bg-gallery" id="gallery" style="padding: 120px 0; margin: 90px 0;">
        <div class="section-title position-relative text-center" style="margin-bottom: 120px;">
            <h6 class="text-uppercase text-primary mb-3" style="letter-spacing: 3px;">Project</h6>
            <h1 class="font-secondary display-4 text-white">Dự Án</h1>
            <i class="far fa-heart text-white"></i>
        </div>
        <div class="owl-carousel gallery-carousel">
        <%
        	ArrayList<Project> listProject = (ArrayList<Project>) request.getAttribute("listProject");
        	if(listProject != null && listProject.size() > 0){
        		for(Project items: listProject){
        %>
            <div class="gallery-item">
                <a href="<%=items.getLink()%>" target=_blank"><img class="img-fluid w-100" style="width: 303.84px; height: 303.84px" src="<%=request.getContextPath() %>/files/<%=items.getPicture() %>" alt="<%=items.getName()%>"></a>
                <h5>
                <a href="<%=items.getLink()%>" target=_blank" style="text-decoration: none">
                   <%=items.getName() %> 
                </a>
                </h5>
            </div>
            <% } } %>
        </div>
    </div>
    <!-- Gallery End -->


    <!-- Event Start -->
    <div class="container-fluid py-5" id="event">
        <div class="container py-5">
            <div class="section-title position-relative text-center">
                <h6 class="text-uppercase text-primary mb-3" style="letter-spacing: 3px;">Skill</h6>
                <h1 class="font-secondary display-4">Kỹ Năng</h1>
                <i class="far fa-heart text-dark"></i>
            </div>
            <div class="row">
            <%
            	ArrayList<Skill> listSkill = (ArrayList<Skill>) request.getAttribute("listSkill");
            	if(listSkill != null && listSkill.size() > 0){
            		int a = 0;
            		String br = "";
            		for(Skill items: listSkill){
            			a++;
            			if(a == 1){
                			br = "green";
                		}
                		if(a == 2){
                			br = "blue";
                		}
                		if(a == 3){
                			br = "#FFCC66";
                		}
                		if(a == 4){
                			br = "red";
                		}
                		if(a == 5){
                			br = "#FF99CC";
                		}
                		if(a == 6){
                			br = "#000033";
                		}
                		if(a == 7){
                			br = "#66FF00";
                		}
                		if(a == 8){
                			br = "#666666";
                		}
                		if(a == 9){
                			br = "#CC0033";
                		}
                		if(a == 10){
                			a = 1;
                		}
            %>
                <div style="width: 1070px ;margin-bottom: 20px ; ">
				<h4><%=items.getName() %></h4>		
					<div class="progress" style="height: 30px; border-radius: 5px">
				
					  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="40"
					  aria-valuemin="0" aria-valuemax="100"  style="width:<%=items.getValue()%>% ; background-color: <%=br %>;"  >
					   <%=items.getValue()%>%
					  </div>
					</div>
				</div>
				<% } } %>
            </div>
        </div>
    </div>
    <!-- Event End -->


    <!-- Friends & Family Start -->
    <div class="container-fluid py-5" id="family">
        <div class="container pt-5 pb-3">
            <div class="section-title position-relative text-center">
                <h6 class="text-uppercase text-primary mb-3" style="letter-spacing: 3px;">Articles and News</h6>
                <h1 class="font-secondary display-4">Bài Viết</h1>
                <i class="far fa-heart text-dark"></i>
            </div>
            <div class="row portfolio-container">
            <%
            	ArrayList<News> listNews = (ArrayList<News>) request.getAttribute("listNews");
            	if(listNews != null && listNews.size() > 0){
            		for(News items: listNews){
            %>
                <div class="col-lg-4 col-md-6 mb-4 portfolio-item first">
                    <div class="position-relative mb-2">
                        <a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(items.getCategory().getName()) %>-<%=items.getCategory().getId() %>/<%=StringUtil.makeSlug(items.getName()) %>-<%=items.getId()%>"><img class="img-fluid w-100" style="width: 349.99px; height: 262.49px" src="<%=request.getContextPath() %>/files/<%=items.getPicture() %>" alt="<%=items.getName()%>"></a>
                        <div class="bg-secondary text-center p-4">
                            <h4 class="mb-3"><a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(items.getCategory().getName()) %>-<%=items.getCategory().getId() %>/<%=StringUtil.makeSlug(items.getName()) %>-<%=items.getId()%>" id="tintuc" style="text-decoration: none; color: black; "><%=items.getName() %></a></h4>
                        </div>
                    </div>
                </div>
               <% } } %>
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
        		<li ><a class="<%if(currentPage == 1){out.print("disabled");} %>" href="<%=request.getContextPath()%>/page/<%=currentPage - 1%>#family"><<</a></li>
        		<% for(int n = 1; n <= numberOfPages ; n++){ %>
        		<li "><a class="<% if(n == currentPage){out.print("active");}%>" href="<%=request.getContextPath()%>/page/<%=n %>#family"><%=n %></a></li>
        		<% } %>
        		<li ><a class="<%if(currentPage == numberOfPages){out.print("disabled");} %>" href="<%=request.getContextPath()%>/page/<%=currentPage + 1%>#family">>></a></li>
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
    <!-- Friends & Family End -->


    <!-- RSVP Start -->
    <div class="container-fluid py-5" id="rsvp">
        <div class="container py-5">
            <div class="section-title position-relative text-center">
                <h6 class="text-uppercase text-primary mb-3" style="letter-spacing: 3px;">RSVP</h6>
                <h1 class="font-secondary display-4">Liên Hệ</h1>
                <i class="far fa-heart text-dark"></i>
            </div>
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="text-center">
                    <%
	                    String name = request.getParameter("name");
	            		String phone = request.getParameter("phone");
	            		String email = request.getParameter("email");
	            		String diachi = request.getParameter("diachi");
	            		String message = request.getParameter("message");
	                    String msg = request.getParameter("msg");
	                	String err = request.getParameter("err");
				    	if("1".equals(msg)){
				    		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px;\">Liên hệ thành công!</span>");
				    	}
				    	if("1".equals(err)){
				    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Liên hệ thất bại!</span>");
				    	}
                    %>
                        <form action="<%=request.getContextPath()%>/contact" method="post">
                            <div class="form-row">
                                <div class="form-group col-sm-6">
                                    <input name="name" type="text" class="form-control bg-secondary border-0 py-4 px-3" placeholder="Name" value="<% if(name != null){ out.print(name);}%>"/>
                                </div>
                                <div class="form-group col-sm-6">
                                    <input name="phone" type="number" class="form-control bg-secondary border-0 py-4 px-3" placeholder="Phone Number" value="<% if(phone != null){ out.print(phone);}%>"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-sm-6">
                                    <input name="email" type="email" class="form-control bg-secondary border-0 py-4 px-3" placeholder="Email" value="<% if(email != null){ out.print(email);}%>"/>
                                </div>
                                <div class="form-group col-sm-6">
                                    <input name="diachi" type="text" class="form-control bg-secondary border-0 py-4 px-3" placeholder="address" value="<% if(diachi != null){ out.print(diachi);}%>"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <textarea name="message" class="form-control bg-secondary border-0 py-2 px-3" rows="5" placeholder="Message" required="required"><% if(message != null){ out.print(message);}%></textarea>
                            </div>
                            <div>
                                <button class="btn btn-primary font-weight-bold py-3 px-5" type="submit">Gửi</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- RSVP End -->


 

    <style type="text/css">
    	.mt{
	    	background-color: #FFCC00;
	    	border: 2px solid white;
	    	margin-left: 300px;
	    	margin-top: 89px;
    	}
    	.mt div p{
    		color: black;
    	}
    	.mt div a{
    		text-decoration: none;
    		color: black;
    	}
    	.mt div a:hover{
    		color: red;
    	}
    	.modal-content{
    		border-radius:5px;	
    	}
    	.modal-body h3{
    		padding: 16px 24px;
    		border-bottom: 1px solid #C0C0C0;
    	}
    	.modal-body img{
    		width: 160px;
    		height: 206px;
    		float: left;
    		margin: 55px 50px;
   			border: 5px solid #FF9900;
    	}
    	.modal-body .thongtin{
    		width: 160px;
    		float: left;
    		margin-top: 55px;
    		width: 500px
    	}
    	.modal-body .thongtin h5{
    		margin-bottom: 20px;
    	}
    	.modal-body .thongtin .ctthongtin{
    	    border-top: 1px dashed;
    	    padding-top: 20px;
    	    padding-bottom: 20px;
    	    }
    	.modal-body .thongtin .ctthongtin .tungmuc{
    		float: left;
    		margin-right: 10px;
    	}
    	.modal-body .thongtin .ctthongtin .tungmuc .cung{
		    font-weight: bold;
		   
    	}
    	.modal-body .thongtin .ctthongtin .tungmuc .doi{
    	}
    	.clr{
    		clear: both;
		}
		.123{
			border: 0;
		}
    </style>

 <%@include file="/templates/public/inc/footer.jsp"%>