<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Content Wrapper. Contains page content -->

	<div class="box">
		<!--BOX HEADER-->
	    <div class="box-header with-border">
	    	<h3 class="box-title">User Information</h3>
	    </div>
	    <!--FORM-->
	    
		<div class="box-body">
			<form id="backToListButton" method="get" action="<c:url value="/product/discount/listDiscount" />"></form>
			<c:url var="post_url" value="/product/discount/updateDiscountToDb" />
			<form:form id="updateDiscountToDbForm" method="post" modelAttribute="discountForm" action="${post_url }">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<form:input path="discountid" type="hidden" id="discountid"/>
				<form:input path="deleteind" type="hidden" id="deleteind"/>
				<div class="row">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<form:input path="discountname" type="text" class="form-control"
		                    				id="discountname" placeholder="Enter discount name" />
							<form:errors path="discountname" class="text-danger" />
						</div>
		 			</div>
	 			</div>
	 			<div class="row">
				  	<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Type</label>
						<div class="col-sm-10">
							<form:select path="discounttype" class="selectpicker" id="discounttype" name ="discounttype">
								<c:forEach items="${discTypeList}" var="discType">
							    	<option value = "${discType}" <c:if test="${discType == discountForm.discounttype }">selected</c:if>>
							    		${discType}
							    	</option>
							    </c:forEach>
							</form:select>
						</div>
				  	</div>
				</div>
				<div class="row">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-sm-2 control-label">Value</label>
						<div class="col-sm-10">
							<form:input path="discountvalue" class="form-control"
						                    id="discountvalue" placeholder="Enter discount value" />
							<form:errors path="discountvalue" class="text-danger" />
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
							<button type="submit" class="btn btn-primary" form="updateDiscountToDbForm">Update</button>
					        <button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
					    </div>
					</div>
				</div>
			</div>
	        <!-- /.box-body -->
		</div>
		<!-- /.BOX -->
		