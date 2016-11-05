<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Content Wrapper. Contains page content -->

	<div class="box">
		<!--BOX HEADER-->
	    <div class="box-header with-border">
	    	<h3 class="box-title">Product Category Information</h3>
	    </div>
	    <!--FORM-->
	    
		<div class="box-body">
			<form id="backToListButton" method="get" action="<c:url value="/product/category/listProductCategory" />"></form>
			<c:url var="post_url" value="/product/category/updateProductCategoryToDb" />
			<form:form id="updateProductCategoryToDbForm" method="post" modelAttribute="categoryForm" action="${post_url }">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<form:input path="id" type="hidden" id="id"/>
				<form:input path="deleteind" type="hidden" id="deleteind"/>
				<form:input path="id" type="hidden" id="id"/>
	 			<div class="row">
		 			<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<form:input path="name" type="text" class="form-control"
						                    id="name" placeholder="Enter name" />
							<form:errors path="name" class="text-danger" />
						</div>
					</div>
				</div>
				<div class="row">		  
		 			<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Parent Category</label>
						<div class="col-sm-10">
							<div class="checkbox">
						  		<label><form:checkbox path="isparent" id="isparent" /></label>
		   						<form:errors path="isparent" class="text-danger" />
							</div>
						</div>
		  			</div>
		  		</div>
				<div class="row">		  
		 			<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Allow Display</label>
						<div class="col-sm-10">
							<div class="checkbox">
						  		<label><form:checkbox path="displayind" id="displayind" /></label>
		   						<form:errors path="displayind" class="text-danger" />
							</div>
						</div>
		  			</div>
		  		</div>
	
				<br/>
				<br/>
	
	  		</form:form>
			<!--/.FORM-->
	 			<div class="row">
				 	<div class="form-group">
						<label class="col-sm-2 control-label"></label>
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary" form="updateProductCategoryToDbForm">Update</button>
					        <button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
					    </div>
					</div>
				</div>
			</div>
	        <!-- /.box-body -->
		</div>
		<!-- /.BOX -->