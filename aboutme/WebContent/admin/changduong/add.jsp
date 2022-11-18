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
                <h2 class="tm-block-title d-inline-block">Thêm thông tin</h2>
              </div>
            </div>
             <%
	        	String err = request.getParameter("err");
             	String name = request.getParameter("name");
	        	String phanloai = request.getParameter("phanloai");
	        	String date = request.getParameter("date");
	        	String content = request.getParameter("content");
	        	if("1".equals(err)){
	        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Có lỗi xảy ra!</span>");
	        	}
	       	 %>
            <div class="row tm-edit-product-row">
              <div class="col-12">
                <form action="" class="tm-edit-product-form" method="post">
                  <div class="form-group mb-3">
                    <label
                      for="name"
                      >Tên thông tin
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
                  <div class="form-group mb-3">
                    <label
                      for="phanloai"
                      >Phân loại</label
                    >
                    <select
                      class="custom-select tm-select-accounts"
                      id="phanloai" name="phanloai"
                    >
                      <option <% if(phanloai != null && "Học tập".equals(phanloai)){out.print("selected");} %> value="Học tập">Học tập</option>
                      <option <% if(phanloai != null && "Kinh nghiệm".equals(phanloai)){out.print("selected");} %> value="Kinh nghiệm">Kinh nghiệm</option>
                    </select>
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="date"
                      >Thời gian
                    </label>
                    <input
                      id="date"
                      value="<%if(date != null){out.print(date);} %>"
                      name="date"
                      type="date"
                      class="form-control validate"
                      required
                    />
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="content"
                      >Nội dung</label
                    >
                    <textarea
                      name="content"
                      class="form-control validate"
                      rows="3"
                      required
                    ><%if(content != null){out.print(content);} %></textarea>
                  </div>
                  
              </div>
              </div>
              <div class="col-12">
                <button type="submit" class="btn btn-primary btn-block text-uppercase">Thêm</button>
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
