<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Content Wrapper. Contains page content -->
	<script type="text/javascript">
	Dropzone.options.dZUpload = {
    	    init: function() {
    	    	var myDropzone = this;
    	    	//set preload image
    	    	var getPreUploadImageAjax = $.ajax({
          		  type: "POST",
          		  url: "getPreUploadImage",
          		  dataType: 'json',
         			  beforeSend: function( xhr ) {
         				  xhr.setRequestHeader(header, token);
         				}
          		}).done(function(data) {
              		$.each(data, function(i, fileMeta){
              			var image = { name: fileMeta.fileName, size: fileMeta.fileSize};
              			var imageUrl = "<c:out value="${pageContext.request.contextPath}" />/product/product/getImage/"+fileMeta.imageId;
              			console.log(imageUrl);
              			myDropzone.emit("addedfile", image);
              			myDropzone.createThumbnailFromUrl(image, imageUrl);
              			myDropzone.emit("complete", image);
                  	});
	    		});

	    		this.on("removedfile", function(file){
		    		console.log(file);
		    		$(document).find(file.previewElement).remove();
		    		var data = {"fileName": file.name};
	    			var removePreUploadImageAjax = $.ajax({
	            		  type: "POST",
	            		  url: "removeUploadImage",
	            		  dataType: 'json',
	            		  data: JSON.stringify(data),
	           			  beforeSend: function( xhr ) {
	           				  xhr.setRequestHeader(header, token);
	           				}
	            		}).done(function(data) {
	            			
	  	    			});
		    	});
  			}
	    };
	$(function(){
	// instantiate the uploader
		var sortableList = $("#dZUpload");
		var uploadImageOrderList = [];

		function getSortOrder(){
			var listElements = $("#dZUpload").find(".dz-success img");
			uploadImageOrderList = [];

			for(var i=0;i<listElements.length;i++){
				var alt = $(listElements[i]).attr("alt");						
				uploadImageOrderList.push(alt);
			}
			return uploadImageOrderList; 
		}
		var sortEventHandler = function(event, ui){
			var uploadImageOrderList = getSortOrder();
			var orderAjax = $.ajax({
		  		  type: "POST",
		  		  url: "sortImage",
		  		  data: JSON.stringify(uploadImageOrderList),
		  		  contentType:"application/json; charset=utf-8",
				  beforeSend: function( xhr ) {
					  xhr.setRequestHeader(header, token);

					}
		  		}).done(function() {});
		};

		sortableList.sortable({
		    stop: sortEventHandler
		});

		// You can also set the event handler on an already existing Sortable widget this way:

		sortableList.on("sortchange", sortEventHandler);
		
	  Dropzone.autoDiscover = false;
	  
	    var dz = $("#dZUpload").dropzone({
	        url: "uploadImage",
	        headers: {
	            header: token
	        },
	        param:{header:token},
	        addRemoveLinks: true,
	        sending:function (file, xhr, formData){
	        	xhr.setRequestHeader(header, token);
			},
	        success: function (file, response) {
	            var imgName = response;
	            file.previewElement.classList.add("dz-success");
	            //console.log("Successfully uploaded :" + imgName);
	        },
	        error: function (file, response) {
	            file.previewElement.classList.add("dz-error");
	        },
	        removedfile: function (file) {
	        	console.log(file.previewElement);
	        	$(document).find(file.previewElement).remove();
	        	var deleteAjax = $.ajax({
	        		  type: "POST",
	        		  url: "removeUploadImage",
	        		  data: {fileName:file.name},
	        		  dataType: 'json',
        			  beforeSend: function( xhr ) {
        				  xhr.setRequestHeader(header, token);
        				}
	        		}).done(function() {
       				    //alert( "success" );
     				  	});
	        		
		        	//console.log("success");	
				}
		      	
	        
	    });
	    
	    
	    
		CKEDITOR.replace('productInfoEditor');

		$(".dropzone").sortable({
	          items:'.dz-preview',
	          cursor: 'move',
	          opacity: 0.5,
	          containment: '.dropzone',
	          distance: 20,
	          tolerance: 'pointer'
	      });
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
                    <c:url var="post_url" value="/product/product/saveProduct?_csrf=${_csrf.token}" />
                    <form:form id="productForm" method="post"  modelAttribute="productForm" action="${post_url}"  enctype="multipart/form-data">
                    	<input type="hidden" id="token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    	<form:input path="id" type="hidden" class="form-control" id="productId"/>
			              <div class="box-body">
			              	<!-- upper row -->
				              <div class="row form-group">
				              	<!-- image panel -->
				              	
				              	<!-- main content -->
				              	<div class="col-sm-7">
				              		<div class="row">
					              		<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="col-sm-2 control-label">Name:</label>
											<div class="col-sm-10 input-group">
												<form:input path="productName" type="text" class="form-control"
								                                id="productName" placeholder="Enter product name" />
												<form:errors path="productName" class="text-danger" />
											</div>
									  	</div>
				              		</div>
				              		
				              		<div class="row">
					              		<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="col-sm-2 control-label">Category:</label>
											<div class="col-sm-10 input-group">
												<form:select path="subcategoryId" type="text" class="form-control" id="subcategory" >
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
												<form:errors path="subcategoryId" class="text-danger" />
											</div>
									  	</div>
				              		</div>
				              		
				              		<div class="row">
					              		<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="col-sm-2 control-label">Price:</label>
											<div class="col-sm-10 input-group">
												<span class="input-group-addon">$</span>
												<form:input path="unitPrice" type="text" class="form-control"
								                                id="unitPrice" placeholder="" />
								                <span class="input-group-addon">.00</span>
												<form:errors path="unitPrice" class="text-danger" />
											</div>
									  	</div>
				              		</div>
				              		
				              		<div class="row">
					              		<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="col-sm-2 control-label">Weight:</label>
											<div class="col-sm-10 input-group">
												<form:input path="weight" type="text" class="form-control"
								                                id="weight" placeholder="Enter weight" />
								                <span class="input-group-addon">gram</span>
												<form:errors path="weight" class="text-danger" />
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
				              				<form:textarea path="productInfo" id="productInfoEditor" name="productInfo" rows="10" cols="80" />
				              				<form:errors path="productInfo" class="text-danger" />
				              			</div>
				              			<div id="image_tab" class="tab-pane">
									      	<div id="dZUpload" class="dropzone">
											      <div class="dz-default dz-message"></div>
											</div>
				              			</div>
				              			<div id="option_tab" class="tab-pane">
				              				<tiles:insertAttribute name = "options" />
				              			</div>
				              		</div>
				              	</div>
				              	<div class="row">
				              		<button type="submit" class="btn btn-default pull-right" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
									<tiles:insertAttribute name = "button" />
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