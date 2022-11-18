<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
        <div class="container">
            <div class="chaomung">
                CHÀO MỪNG BẠN ĐẾN VỚI TRANG QUẢN TRỊ WEBSITE ABOUTME
            </div>  
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                  <img src="<%=request.getContextPath() %>/templates/admin/assets/img/1.jpg" alt="slide1" class="img-responsive img-slide">
                </div>
                <div class="item">
                  <img src="<%=request.getContextPath() %>/templates/admin/assets/img/2.jpg" alt="slide2" class="img-responsive img-slide">
                </div>
                <div class="item">
                  <img src="<%=request.getContextPath() %>/templates/admin/assets/img/3.jpg" alt="slide3" class="img-responsive img-slide">
                </div>
              </div>
        </div>
    
<script>
    document.getElementById("trangchu").classList.add('active');
</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>