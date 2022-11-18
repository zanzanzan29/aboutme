<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Aboutme Quang Trường</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="<%=request.getContextPath() %>/templates/public/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Great+Vibes&family=Montserrat:wght@400;600&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="<%=request.getContextPath() %>/templates/public/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/templates/public/lib/lightbox/css/lightbox.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="<%=request.getContextPath() %>/templates/public/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/templates/public/css/stylechinh.css" rel="stylesheet">
</head>

<body data-spy="scroll" data-target=".navbar" data-offset="51">
    <!-- Navbar Start -->
    <nav class="navbar fixed-top shadow-sm navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-lg-5">
        <a href="index.html" class="navbar-brand d-block d-lg-none">
            <h1 class="font-secondary text-white mb-n2">Jack <span class="text-primary">&</span> Rose</h1>
        </a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <%
        	String home = (String) request.getAttribute("home");
        	String about = (String) request.getAttribute("about");
        	String exp = (String) request.getAttribute("exp");
        	String project = (String) request.getAttribute("project");
        	String skill = (String) request.getAttribute("skill");
        	String idnews = (String) request.getAttribute("idnews");
        	String contact = (String) request.getAttribute("contact");
        %>
        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
            <div class="navbar-nav ml-auto py-0">
                <a href="<%if(home != null){out.print(home);}else{%><%=request.getContextPath()%><% ;} %>" class="nav-item nav-link active">Trang chủ</a>
                <a href="<%if(about != null){out.print(about);}else{%><%=request.getContextPath() %>/about<% ;} %>" class="nav-item nav-link">TÔI LÀ AI?</a>
                <a href="<%if(exp != null){out.print(exp);}else{%><%=request.getContextPath() %>/exp<% ;} %>" class="nav-item nav-link">Chặng đường đã qua</a>
                <a href="<%if(project != null){out.print(project);}else{%><%=request.getContextPath() %>/project<% ;} %>" class="nav-item nav-link">Dự Án</a>
            </div>
            <a href="<%=request.getContextPath() %>" class="navbar-brand mx-5 d-none d-lg-block">
                <h1 class="font-secondary text-white mb-n2">About<span class="text-primary">Me</span></h1>
            </a>
            <div class="navbar-nav mr-auto py-0">
                <a href="<%if(skill != null){out.print(skill);}else{%><%=request.getContextPath() %>/skill<% ;} %>" class="nav-item nav-link">Kỹ năng</a>
                <a href="<%if(idnews != null){out.print(idnews);}else{%><%=request.getContextPath() %>/idnews<% ;} %>" class="nav-item nav-link">Tin Công Nghệ</a>
                <a href="<%if(contact != null){out.print(contact);}else{%><%=request.getContextPath() %>/contact<% ;} %>" class="nav-item nav-link">Liên hệ</a>
                <a href="#contact" class="nav-item nav-link">Giới thiệu</a>
            </div>
        </div>
    </nav>
    <!-- Navbar End -->