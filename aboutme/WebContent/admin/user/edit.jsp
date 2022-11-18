<%@page import="model.bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
    <div class="container tm-mt-big tm-mb-big">
      <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
        	<div class="quanly">
                QUẢN LÝ NGƯỜI DÙNG
            </div>
          <div class="tm-bg-primary-dark tm-block tm-block-h-auto formday">
            <div class="row">
              <div class="col-12">
                <h2 class="tm-block-title d-inline-block">Sửa người dùng</h2>
              </div>
            </div>
             <%
	        	String err = request.getParameter("err");
             	String name = request.getParameter("name");
	        	String fullname = request.getParameter("fullname");
	        	String chucvu = request.getParameter("chucvu");
	        	User item = (User) request.getAttribute("item");
	        	if(item != null){
	        		name = item.getUsername();
	        		fullname = item.getFullname();
	        		chucvu = item.getChucvu();
	        	}
	        	if("1".equals(err)){
	        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Có lỗi xảy ra!</span>");
	        	}
	        	if("2".equals(err)){
	        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">UserName đã tồn tại!</span>");
	        	}
	       	 %>
            <div class="row tm-edit-product-row">
              <div class="col-12">
                <form action="" class="tm-edit-product-form" method="post">
                  <div class="form-group mb-3">
                    <label
                      for="name"
                      >Username
                    </label>
                    <input
                      id="name"
                      value="<%if(name != null){out.print(name);} %>"
                      name="name"
                      type="text"
                      class="form-control validate"
                      disabled="disabled"
                      required
                    />
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="password"
                      >Password
                    </label>
                    <input
                      id="password"
                      value=""
                      name="password"
                      type="password"
                      class="form-control validate"
                    />
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="fullname"
                      >Họ và tên
                    </label>
                    <input
                      id="fullname"
                      value="<%if(fullname != null){out.print(fullname);} %>"
                      name="fullname"
                      type="text"
                      class="form-control validate"
                      required
                    />
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="chucvu"
                      >Chức vụ</label
                    >
                    <select
                      class="custom-select tm-select-accounts"
                      id="chucvu" name="chucvu"
                    >
                      <option <% if(chucvu != null && "Nhân viên".equals(chucvu)){out.print("selected");} %> value="Nhân viên">Nhân viên</option>
                      <option <% if(chucvu != null && "Admin".equals(chucvu)){out.print("selected");} %> value="Admin">Admin</option>
                    </select>
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
    document.getElementById("nguoidung").classList.add('active');
</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>
