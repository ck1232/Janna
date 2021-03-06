<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Content Wrapper. Contains page content -->

    <section class="content">
    	<div class="row">
    		<div class="col-md-12">
    			<!--BOX-->
                <div class="box">
                	<!--BOX HEADER-->
                    <div class="box-header with-border">
                    	<h3 class="box-title">Discount Information</h3>
                    </div>
                    <!--FORM-->
                    <form id="backToListButton" method="get" action="<c:url value="/product/discount/listDiscount" />"></form>
                    <c:url var="post_url" value="/product/discount/createDiscount" />
                    <form:form id="createDiscountForm" method="post" modelAttribute="discountForm" action="${post_url }">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <form:input path="deleteind" type="hidden" id="deleteind"/>
		             	<div class="box-body">
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
										<form:input path="discountvalue" type="number" class="form-control"
					                                id="discountvalue" placeholder="Enter value" />
										<form:errors path="discountvalue" class="text-danger" />
									</div>
							  	</div>
							</div>
							<div class="row">
							  	<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="col-sm-2 control-label">Apply Type</label>
									<div class="col-sm-10">
										<form:select path="applytype" class="selectpicker" id="applytype" name ="applytype">
											<c:forEach items="${applyTypeList}" var="appType">
										    	<option value = "${appType}" <c:if test="${appType == discountForm.applytype }">selected</c:if>>
										    		${appType}
										    	</option>
										    </c:forEach>
										</form:select>
									</div>
							  	</div>
							</div>
							<br/>
							<br/>
		            	
		            		<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
										<div class="col-sm-10">
											<button type="submit" class="btn btn-primary" form ="createDiscountForm">Add</button>
				                  			<button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
										</div>
								</div>
							</div>
		              	</div>
		        	</form:form>
		            <!--/.FORM-->
                </div>
                <!-- /.box-body -->
    		</div>
    	</div>
    </section>