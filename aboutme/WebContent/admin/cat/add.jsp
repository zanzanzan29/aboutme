<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
    <div class="container tm-mt-big tm-mb-big">
      <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
        	<div class="quanly">
                QUẢN LÝ DANH MỤC
            </div>
          <div class="tm-bg-primary-dark tm-block tm-block-h-auto formday">
            <div class="row">
              <div class="col-12">
                <h2 class="tm-block-title d-inline-block">Thêm danh mục</h2>
              </div>
            </div>
             <%
	        	String name = request.getParameter("name");
	        	String err = request.getParameter("err");
	        
	        	if("1".equals(err)){
	        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Có lỗi xảy ra!</span>");
	        	}
	        	if("2".equals(err)){
	        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Tên danh mục đã tồn tại!</span>");
	        	}
	       	 %>
            <div class="row tm-edit-product-row">
              <div class="col-12">
                <form action="" class="tm-edit-product-form" method="post">
                  <div class="form-group mb-3">
                    <label
                      for="name"
                      >Tên danh mục
                    </label>
                    <input
                      id="name"
                      value="<% if(name != null){out.print(name);} %>"
                      name="name"
                      type="text"
                      class="form-control validate"
                      required
                    />
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
    document.getElementById("baiviet").classList.add('active');
</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>
