<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Content Wrapper. Contains page content -->

                <div class="box">
                	<!--BOX HEADER-->
                    <div class="box-header with-border">
                    	<h3 class="box-title">Salary / Bonus Information</h3>
                    </div>
                    <!--FORM-->
                    <form id="backToListButton" method="get" action="<c:url value="/salarybonus/listSalaryBonus" />"></form>
                    <c:url var="post_url" value="/salarybonus/updateSalaryBonusToDb" />
                    <form:form id="updateSalaryBonusToDbForm" method="post" modelAttribute="salaryBonusForm" action="${post_url}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <form:input type="hidden" path="id" id="id"/>
                    <form:input type="hidden" path="employeeid" id="employeeid"/>
                    <form:input type="hidden" path="name" id="name"/>
                    <form:input type="hidden" path="type" id="type"/>
		              <div class="box-body">
		              <div class="row">
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Employee Name</label>
							<div class="col-sm-5">${salaryBonusForm.name}</div>
						  </div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Date</label>
							<div class="col-sm-5">
								<form:input path="dateString" type="text" class="form-control" 
		                  			  		id="dateString" placeholder="Press to select date"/>
		                  		<form:errors path="dateString" class="text-danger" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Type</label>
							<div class="col-sm-5">${salaryBonusForm.type}</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Basic Salary</label>
							<div class="col-sm-5">
								<form:input path="basicsalary" type="number" class="form-control" 
			                  				id="basicsalary" placeholder="Enter basic salary"/>
			                  	<form:errors path="basicsalary" class="text-danger" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Overtime Amount</label>
							<div class="col-sm-5">
								<form:input path="overtimeamount" type="number" class="form-control" 
			                  				id="overtimeamount" placeholder="Enter overtime amount"/>
			                  	<form:errors path="overtimeamount" class="text-danger" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Overtime Hours</label>
							<div class="col-sm-5">
								<form:input path="overtimehours" type="number" class="form-control" 
			                  				id="overtimehours" placeholder="Enter overtime hours"/>
			                  	<form:errors path="overtimehours" class="text-danger" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Overtime Remarks</label>
							<div class="col-sm-5">
								<form:input path="overtimeremark" type="text" class="form-control" 
			                  				id="overtimeremark" placeholder="Enter overtime remarks"/>
			                  	<form:errors path="overtimeremark" class="text-danger" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Allowance / Medical</label>
							<div class="col-sm-5">
								<form:input path="allowance" type="number" class="form-control"
				                            id="allowance" placeholder="Enter allowance" />
								<form:errors path="allowance" class="text-danger" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Unpaid Leave Amount</label>
							<div class="col-sm-5">
								<form:input path="unpaidleaveamount" type="number" class="form-control"
				                                id="unpaidleaveamount" placeholder="Enter unpaid leave amount" />
								<form:errors path="unpaidleaveamount" class="text-danger" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Unpaid Leave Remarks</label>
							<div class="col-sm-5">
								<form:input path="unpaidleaveremark" type="text" class="form-control" 
		                  			  		id="unpaidleaveremark" placeholder="Enter unpaid leave remarks"/>
		                  		<form:errors path="unpaidleaveremark" class="text-danger" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">CDAC Amount</label>
							<div class="col-sm-5">
								<form:input path="cdacamount" type="number" class="form-control" 
		                  			  		id="cdacamount" placeholder="Enter cdac amount"/>
		                  		<form:errors path="cdacamount" class="text-danger" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">SDL Amount</label>
							<div class="col-sm-5">
								<form:input path="sdlamount" type="number" class="form-control" 
		                  			  		id="sdlamount" placeholder="Enter sdl amount"/>
		                  		<form:errors path="sdlamount" class="text-danger" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Foreign Worker Levy</label>
							<div class="col-sm-5">
								<form:input path="fwlevy" type="number" class="form-control" 
		                  			  		id="fwlevy" placeholder="Enter sdl amount"/>
		                  		<form:errors path="fwlevy" class="text-danger" />
							</div>
						</div>
					</div>	  
						<br/>
						<br/>
						<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
			                  <button id="updateSalaryBonusBtn" type="submit" class="btn btn-primary" form="updateSalaryBonusToDbForm">Update
			                  </button>
			                  <button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel
			            </button>
							</div>
						  </div>
		              </div>
		              <!-- /.box-body -->
		            </form:form>
		            <!--/.FORM-->
                </div>
    		
    <script>
      $( function() {
    	  $('#dateString').datepicker({
	    		format: 'dd/mm/yyyy',
		      	autoclose: true
		    });
		   
	 } );

      

    </script>