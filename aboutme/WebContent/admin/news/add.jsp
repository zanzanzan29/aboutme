<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
    <div class="container tm-mt-big tm-mb-big">
      <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
        	<div class="quanly">
                QUẢN LÝ TIN TỨC
            </div>
          <div class="tm-bg-primary-dark tm-block tm-block-h-auto formday">
            <div class="row">
              <div class="col-12">
                <h2 class="tm-block-title d-inline-block">Thêm tin</h2>
              </div>
            </div>
             <%
	        	String name = request.getParameter("name");
	        	String err = request.getParameter("err");
	        	String cat = request.getParameter("cat");
	        	String mota = request.getParameter("mota");
	        	String chitiet = request.getParameter("chitiet");
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
                      >Tên tin
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
                      for="category"
                      >Danh mục</label
                    >
                    <select
                      class="custom-select tm-select-accounts"
                      id="category" name="cat"
                    >
                    <%
                    	ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
                    		  if(categories != null && categories.size() > 0){
                    			  for(Category items: categories){
                    %>
                      <option <% if(cat!=null && cat.equals(String.valueOf(items.getId()))){out.print("selected");}%> value="<%=items.getId()%>"><%=items.getName() %></option>
                      <% } } %>
                    </select>
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
                  <div class="form-group mb-3">
                    <label
                      for="description"
                      >Mô tả</label
                    >
                    <textarea
                      name="mota"
                      class="form-control validate"
                      rows="3"
                      required
                    ><%if(mota != null){out.print(mota);} %></textarea>
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="detail"
                      >Chi tiết</label
                    >
                    <textarea
                      name="chitiet"
                      class="form-control validate"
                      rows="5"
                      required
                    ><%if(chitiet != null){out.print(chitiet);} %></textarea>
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
	var editor = CKEDITOR.replace('chitiet');
</script>
<script>
    document.getElementById("baiviet").classList.add('active');
</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>
