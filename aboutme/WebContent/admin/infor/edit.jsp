<%@page import="model.bean.Information"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
    <div class="container tm-mt-big tm-mb-big">
      <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
        	<div class="quanly">
                QUẢN LÝ THÔNG TIN
            </div>
          <div class="tm-bg-primary-dark tm-block tm-block-h-auto formday">
            <div class="row">
              <div class="col-12">
                <h2 class="tm-block-title d-inline-block">Sửa thông tin</h2>
              </div>
            </div>
             <%
	        	String err = request.getParameter("err");
             	String name = request.getParameter("name");
	        	String diachi = request.getParameter("diachi");
	        	String email = request.getParameter("email");
	        	String date = request.getParameter("date");
	        	String phone = request.getParameter("phone");
	        	String gioithieu = request.getParameter("gioithieu");
	        	Information item = (Information) request.getAttribute("item");
	        	if(item != null){
	        		name = item.getName();
	        		diachi = item.getDiachi();
	        		email = item.getEmail();
	        		date = item.getDate();
	        		phone = String.valueOf(item.getPhone());
	        		gioithieu = item.getContent();
	        	}
	        	if("1".equals(err)){
	        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Có lỗi xảy ra!</span>");
	        	}
	        	if("2".equals(err)){
	        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Vui lòng nhập số điện thoại bằng số!</span>");
	        	}
	       	 %>
            <div class="row tm-edit-product-row">
              <div class="col-12">
                <form action="" class="tm-edit-product-form" method="post">
                  <div class="form-group mb-3">
                    <label
                      for="name"
                      >Họ và tên
                    </label>
                    <input
                      id="name"
                      value="<%if(name != null){out.print(name);} %>"
                      name="name"
                      type="text"
                      class="form-control validate"
                      required
                    />
                  </div>
                  <div class="form-group mb-3 col-xs-12 col-sm-6">
                          <label
                            for="date"
                            >Ngày sinh
                          </label>
                          <input
                            id="date"
                            value="<%if(date != null){out.print(date);} %>"
                            name="date"
                            type="date"
                            class="form-control validate"
                            data-large-mode="true"
                            required
                          />
                   </div>
                   <div class="form-group mb-3">
                    <label
                      for="diachi"
                      >Địa chỉ
                    </label>
                    <input
                      id="diachi"
                      value="<%if(diachi != null){out.print(diachi);} %>"
                      name="diachi"
                      type="text"
                      class="form-control validate"
                      required
                    />
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="phone"
                      >Số điện thoại
                    </label>
                    <input
                      id="phone"
                      value="<%if(phone != null){out.print(phone);} %>"
                      name="phone"
                      type="number"
                      class="form-control validate"
                      required
                      number
                    />
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="email"
                      >Email
                    </label>
                    <input
                      id="email"
                      value="<%if(email != null){out.print(email);} %>"
                      name="email"
                      type="email"
                      class="form-control validate"
                      required
                    />
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="gioithieu"
                      >Giới thiệu</label
                    >
                    <textarea
                      name="gioithieu"
                      class="form-control validate"
                      rows="3"
                      required
                    ><%if(gioithieu != null){out.print(gioithieu);} %></textarea>
                  </div>
                  
              </div>
              </div>
              <div class="col-12">
                <button type="submit" class="btn btn-primary btn-block text-uppercase">Sửa</button>
              </div>
            </form>
            </div>
          </div>
        </div>
      </div>
    </div>
<script>
    document.getElementById("thongtin").classList.add('active');
</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>
