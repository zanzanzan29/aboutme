<%@page import="model.dao.NewsDAO"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>About Me Admin</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/admin/assets/css/fontawesome.min.css">
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/admin/assets/css/bootstrap.min.css">
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/admin/assets/css/templatemo-style.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/admin/assets/css/style.css">
    
    <!--
	Product Admin CSS Template
	https://templatemo.com/tm-524-product-admin
	-->
</head>

<body id="reportsPage">
    <div class="" id="home">
        <nav class="navbar navbar-expand-xl">
            <div class="container h-100">
                <a class="navbar-brand" href="<%=request.getContextPath()%>/admin">
                    <h1 class="tm-site-title mb-0"><img src="<%=request.getContextPath() %>/templates/admin/assets/img/logo1.png" /></h1>
                </a>
                <button class="navbar-toggler ml-auto mr-0" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-bars tm-nav-icon"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto h-100">
                        <li class="nav-item">
                            <a class="nav-link" id="trangchu" href="<%=request.getContextPath()%>/admin">
                                <i class="fas fa-tachometer-alt"></i>
                                TRANG CH???
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" id="baiviet" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-file-alt"></i>
                                <span>
                                    QU???N L?? B??I VI???T <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            	<%
                            		NewsDAO newsDAO = new NewsDAO();
                            		int i = 0; 
                            		i = newsDAO.getTT0();
                            	%>
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/cats">DANH M???C</a>
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/newss">TIN T???C <%if(i > 0){out.print("("+i+")");} %></a>
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/comments">B??NH LU???N</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="nguoidung" href="<%=request.getContextPath()%>/admin/users">
                                <i class="fas fa-shopping-cart"></i>
                                QU???N L?? NG?????I D??NG
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" id="lienhe" href="<%=request.getContextPath()%>/admin/contacts">
                                <i class="far fa-user"></i>
                                QU???N L?? LI??N H???
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="thongtin" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-cog"></i>
                                <span>
                                    QU???N L?? TH??NG TIN <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/infors">TH??NG TIN</a>
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/skills">K??? N??NG</a>
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/projects">D??? ??N</a>
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/changduongs">CH???NG ???????NG</a>
                            </div>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                        <%
                        	User userLogin = (User) session.getAttribute("userLogin");
                        	if(userLogin != null){
                        %>
                            <a class="nav-link d-block" href="<%=request.getContextPath()%>/logout">
                               CH??O <%=userLogin.getFullname() %>, <b>????ng xu???t</b>
                            </a>
                         <% }else{ %>
                         <a class="nav-link d-block" href="<%=request.getContextPath()%>/login">
                               CH??O KH??CH, <b>????ng nh???p</b>
                            </a>
                         <% } %>
                        </li>
                    </ul>
                </div>
            </div>

        </nav>