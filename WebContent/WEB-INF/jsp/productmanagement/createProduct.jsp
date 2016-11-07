<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Content Wrapper. Contains page content -->
	<script type="text/javascript">
	$(function(){
	// instantiate the uploader
	  
	  Dropzone.autoDiscover = false;
	    $("#dZUpload").dropzone({
	        url: "uploadImage",
	        param:{header:token},
	        addRemoveLinks: true,
	        success: function (file, response) {
	            var imgName = response;
	            file.previewElement.classList.add("dz-success");
	            console.log("Successfully uploaded :" + imgName);
	        },
	        error: function (file, response) {
	            file.previewElement.classList.add("dz-error");
	        }
	    });
		CKEDITOR.replace('productInfoEditor');
	});
		
	</script>
	<!-- Our main JS file -->
	
    <section class="content">
    	<div class="row">
    		<div class="col-md-12">
    			<!--BOX-->
                <div class="box">
                	<!--BOX HEADER-->
                    <div class="box-header with-border">
                    	<h3 class="box-title">Product Information</h3>
                    </div>
                    <!--FORM-->
                    <form id="backToListButton" method="get" action="<c:url value="/product/product/listProduct" />"></form>
                    <c:url var="post_url" value="/product/product/createProduct" />
                    <form:form id="createProductForm" method="post"  modelAttribute="productForm" action="${post_url}"  enctype="multipart/form-data">
                    <input type="hidden" id="token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			              <div class="box-body">
			              	<!-- upper row -->
				              <div class="row form-group">
				              	<!-- image panel -->
				              	
				              	<!-- main content -->
				              	<div class="col-sm-7">
				              		<div class="row">
					              		<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="col-sm-2 control-label">Name:</label>
											<div class="col-sm-10">
												<form:input path="productname" type="text" class="form-control"
								                                id="productName" placeholder="Enter product name" />
												<form:errors path="productname" class="text-danger" />
											</div>
									  	</div>
				              		</div>
				              		
				              		<div class="row">
					              		<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="col-sm-2 control-label">Category:</label>
											<div class="col-sm-10">
												<form:select path="subcategoryid" type="text" class="form-control" id="subcategory" >
													<form:option value="">No Category</form:option>
								                	<c:forEach items="${categoryList}" var="category">
								                		<c:if test="${category.isparent == true}">
								                			<optgroup label="${category.name}">
								                				<c:forEach items="${category.subcategoryList}" var="sub">
								                					<form:option value="${sub.id}">${sub.name}</form:option>
								                				</c:forEach>
								                			</optgroup>
								                		</c:if>
								                		<c:if test="${category.isparent == false}">
								                			<form:option value="${category.subcategoryList.get(0).id}">${category.subcategoryList.get(0).name}</form:option>
								                		</c:if>
								                	</c:forEach>
								                </form:select>
												<form:errors path="subcategoryid" class="text-danger" />
											</div>
									  	</div>
				              		</div>
				              	</div>
				              	<div class="col-sm-5">
					              	
				              	</div>
				              </div>
				              
				              <!-- lower row -->
				              <div class="row form-group col-sm-12" >
				              	<!-- tabs -->
				              	<div class="nav-tabs-custom">
				              		<!-- tab header -->
				              		<ul class="nav nav-tabs">
				              			<!-- product info tab header -->
				              			<li class="active">
				              				<a href="#product_info_tab" data-toggle="tab" aria-expanded="false">Product Info</a>
				              			</li>
				              			<li>
				              				<a href="#image_tab" data-toggle="tab" aria-expanded="false">Image</a>
				              			</li>
				              			<li>
				              				<a href="#option_tab" data-toggle="tab" aria-expanded="false">Option</a>
				              			</li>
				              		</ul>
				              		<div class="tab-content">
				              			<div id="product_info_tab" class="tab-pane active">
				              				<textarea id="productInfoEditor" name="productInfoEditor" rows="10" cols="80">
                                            	This is my textarea to be replaced with CKEditor.
                    						</textarea>
				              			</div>
				              			<div id="image_tab" class="tab-pane">
									      	<div id="dZUpload" class="dropzone">
											      <div class="dz-default dz-message"></div>
											</div>
				              			</div>
				              			<div id="option_tab" class="tab-pane">
				              				
				              			</div>
				              		</div>
				              	</div>
				              </div>
				            </div>
			              <!-- /.box-body -->
		            </form:form>
		            <!--/.FORM-->
                </div>
    		</div>
    	</div>
    </section>