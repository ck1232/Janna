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
                    	<h3 class="box-title">Employee Information</h3>
                    </div>
                    <!--FORM-->
                    <form id="backToListButton" method="get" action="<c:url value="/employee/listEmployee" />"></form>
                    <c:url var="post_url" value="/employee/createEmployee" />
                    <form:form id="createEmployeeForm" method="post" modelAttribute="employeeForm" action="${post_url}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			              <div class="box-body">
				              	<div class="row">
								  	<div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Name</label>
										<div class="col-sm-10">
											<form:input path="name" type="text" class="form-control"
						                                id="name" placeholder="Enter employee name" />
											<form:errors path="name" class="text-danger" />
										</div>
								  	</div>
								</div>
								<div class="row">
								  	<div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Employee Type</label>
										<div class="col-sm-5">
						                    <form:select path="employmenttype" class="form-control" id="employmenttypeid">
												<form:option value="" label="--- Select ---"/>
						   						<form:options items="${employmentTypeList}" />
											</form:select>            
											<form:errors path="employmenttype" class="text-danger" />
										</div>
								  	</div>
								</div>
					            <div class="row">
						            <div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Date of Birth</label>
											<div class="col-sm-10">
						                  		<form:input path="dobString" type="text" class="form-control" 
						                  			  id="dobString" placeholder="Press to select date"/>
						                  		<form:errors path="dobString" class="text-danger" />
						                	</div>
						              </div>
					            </div>
					            <div class="row">
								  	<div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Nationality</label>
										<div class="col-sm-10">
											<form:input path="nationality" type="text" class="form-control"
						                                id="nationality" placeholder="Enter employee nationality" />
											<form:errors path="nationality" class="text-danger" />
										</div>
								  	</div>
								</div>
								<div class="row">
								  	<div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Basic Salary</label>
										<div class="col-sm-10">
											<form:input path="basicsalary" type="number" class="form-control"
						                                id="basicsalary" placeholder="Enter employee basic salary" />
											<form:errors path="basicsalary" class="text-danger" />
										</div>
								  	</div>
								</div>
								<div class="row">
						            <div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Employee Start Date</label>
											<div class="col-sm-10">
						                  		<form:input path="employstartdateString" type="text" class="form-control" 
						                  			  id="employstartdateString" placeholder="Press to select date"/>
						                  		<form:errors path="employstartdateString" class="text-danger" />
						                	</div>
						              </div>
					            </div>
					            <div class="row">
						            <div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Employee End Date</label>
											<div class="col-sm-10">
						                  		<form:input path="employenddateString" type="text" class="form-control" 
						                  			  id="employenddateString" placeholder="Press to select date"/>
						                  		<form:errors path="employenddateString" class="text-danger" />
						                	</div>
						              </div>
					            </div>
								<div class="row">		  
								  	<div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">CDAC Indicator</label>
										<div class="col-sm-10">
											<div class="checkbox">
										  		<label><form:checkbox path="cdacindBoolean" id="cdacindBoolean" /></label>
										     	<form:errors path="cdacindBoolean" class="text-danger" />
											</div>
										</div>
								  	</div>
								</div>
							<br/>
							<br/>
								<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-10">
										<button id="addEmployeeBtn" type="submit" class="btn btn-primary" form ="createEmployeeForm">Add</button>
					                  <button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
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
    
    <script>
      $( function() {
    	  $('#dobString').datepicker({
	    		format: 'dd/mm/yyyy',
		      	autoclose: true
		    });

    	  $('#employstartdateString').datepicker({
	    		format: 'dd/mm/yyyy',
		      	autoclose: true
		    });

    	  $('#employenddateString').datepicker({
	    		format: 'dd/mm/yyyy',
		      	autoclose: true
		    });
		   
	 } );

      

    </script>
    