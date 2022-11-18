<%@page import="model.bean.Skill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
    <div class="container tm-mt-big tm-mb-big">
      <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
        	<div class="quanly">
                QUẢN LÝ KỸ NĂNG
            </div>
          <div class="tm-bg-primary-dark tm-block tm-block-h-auto formday">
            <div class="row">
              <div class="col-12">
                <h2 class="tm-block-title d-inline-block">Sửa kỹ năng</h2>
              </div>
            </div>
             <%
	        	String err = request.getParameter("err");
             	String name = request.getParameter("name");
             	String value = request.getParameter("value");
	        	Skill item = (Skill) request.getAttribute("item");
	        	if(item != null){
	        		name = item.getName();
	        		value = String.valueOf(item.getValue());
	        	}
	        	if("1".equals(err)){
	        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Có lỗi xảy ra!</span>");
	        	}
	        	if("2".equals(err)){
	        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Kỹ năng đã tồn tại!</span>");
	        	}
	        	if("3".equals(err)){
	        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Giá trị là số!</span>");
	        	}
	       	 %>
            <div class="row tm-edit-product-row">
              <div class="col-12">
                <form action="" class="tm-edit-product-form" method="post">
                  <div class="form-group mb-3">
                    <label
                      for="name"
                      >Tên kỹ năng
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
                      for="value"
                      >Giá trị
                    </label>
                    <input
                      id="value"
                      value="<%if(value != null){out.print(value);} %>"
                      name="value"
                      type="number"
                      class="form-control validate"
                      required
                    />
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
