<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
    <div class="container tm-mt-big tm-mb-big">
      <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
        	<div class="quanly">
                QUẢN LÝ DỰ ÁN
            </div>
          <div class="tm-bg-primary-dark tm-block tm-block-h-auto formday">
            <div class="row">
              <div class="col-12">
                <h2 class="tm-block-title d-inline-block">Thêm dự án</h2>
              </div>
            </div>
             <%
	        	String err = request.getParameter("err");
	        	String name = request.getParameter("name");
	        	String link = request.getParameter("link");
	        	if("1".equals(err)){
	        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Có lỗi xảy ra!</span>");
	        	}
	       	 %>
            <div class="row tm-edit-product-row">
              <div class="col-12">
                <form action="" class="tm-edit-product-form" method="post" enctype="multipart/form-data">
                  <div class="form-group mb-3">
                    <label
                      for="name"
                      >Tên dự án
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
                      for="link"
                      >Link
                    </label>
                    <input
                      id="link"
                      value="<%if(link != null){out.print(link);} %>"
                      name="link"
                      type="url"
                      class="form-control validate"
                      required
                    />
                  </div>
                  <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
	                
	                <div class="custom-file mt-3 mb-3">
	                	<label for="picture" style="color: white;">Hình ảnh</label>
	                  <input
	                    type="file"
	                    name="picture"
	                    class="btn btn-primary btn-block mx-auto"
	                    value="CHỌN HÌNH ẢNH"
	                    onclick="document.getElementById('fileInput').click();"
	                  />
	                </div>
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
