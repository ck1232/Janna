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
                    	<h3 class="box-title">Salary / Bonus Information</h3>
                    </div>
                    <!--FORM-->
                    <form id="backToListButton" method="get" action="<c:url value="/salarybonus/listSalaryBonus" />"></form>
                    <c:url var="post_url" value="/salarybonus/createSalaryBonus" />
                    <form:form id="createSalaryBonusForm" method="post" modelAttribute="salaryBonusForm" action="${post_url}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			              <div class="box-body">
								<div class="row">
								  	<div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Employee Name</label>
										<div class="col-sm-5">
						                    <form:select path="employeeid" class="form-control" id="employeeid">
												<form:option value="" label="--- Select ---"/>
						   						<form:options items="${employeeList}" />
											</form:select>            
											<form:errors path="employeeid" class="text-danger" />
										</div>
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
										<div class="col-sm-5">
						                    <form:select path="type" class="form-control" id="type">
												<form:option value="" label="--- Select ---"/>
						   						<form:options items="${typeList}" />
											</form:select>            
											<form:errors path="type" class="text-danger" />
										</div>
								  	</div>
								</div>
								<div id="salarydiv" style="display:none">
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
							                                id="overtimeamount" placeholder="Enter overtime amount" />
												<form:errors path="overtimeamount" class="text-danger" />
											</div>
									  	</div>
									</div>
									<div class="row">
									  	<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="col-sm-2 control-label">Overtime Hours</label>
											<div class="col-sm-5">
												<form:input path="overtimehours" type="number" class="form-control"
							                                id="overtimehours" placeholder="Enter overtime hours" />
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
							                  			  id="allowance" placeholder="Enter allowance"/>
							                  		<form:errors path="allowance" class="text-danger" />
							                	</div>
							              </div>
						            </div>
						            <div class="row">
							            <div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="col-sm-2 control-label">Unpaid Leave Amount</label>
												<div class="col-sm-5">
							                  		<form:input path="unpaidleaveamount" type="number" class="form-control" 
							                  			  id="unpaidleaveamount" placeholder="Enter unpaid leave amount"/>
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
							                  			  id="fwlevy" placeholder="Enter foreigner worker levy"/>
							                  		<form:errors path="fwlevy" class="text-danger" />
							                	</div>
							              </div>
						            </div>
						        </div>
						        <div id="bonusdiv" style="display:none">
						            <div class="row">
							            <div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="col-sm-2 control-label">Bonus Amount</label>
												<div class="col-sm-5">
							                  		<form:input path="bonusamount" type="number" class="form-control" 
							                  			  id="bonusamount" placeholder="Enter bonus amount"/>
							                  		<form:errors path="bonusamount" class="text-danger" />
							                	</div>
							              </div>
						            </div>
						        </div>
						        <div class="row">
						            <div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Employee CPF</label>
											<div class="col-sm-5">
						                  		<form:input path="employeecpf" type="number" class="form-control" 
						                  			  id="employeecpf" placeholder="Enter employee cpf"/>
						                  		<form:errors path="employeecpf" class="text-danger" />
						                	</div>
						              </div>
					            </div>
					            <div class="row">
						            <div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Employer CPF</label>
											<div class="col-sm-5">
						                  		<form:input path="employercpf" type="number" class="form-control" 
						                  			  id="employercpf" placeholder="Enter employer cpf"/>
						                  		<form:errors path="employercpf" class="text-danger" />
						                	</div>
						              </div>
					            </div>
							<br/>
							<br/>
								<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
									<div class="col-sm-10">
										<button id="addSalaryBonusBtn" type="submit" class="btn btn-primary" form ="createSalaryBonusForm">Add</button>
										<button id="addSalaryBonusAndPayBtn" type="submit" class="btn btn-primary" form ="createSalaryBonusForm" formaction="<c:url value="/salarybonus/createSalaryBonusAndPay" />">Add and Pay</button>
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
    	  $('#dateString').datepicker({
	    		format: 'dd/mm/yyyy',
		      	autoclose: true
		    });

    	  $('#type').change(function(event) {
    		  loadTypeDiv();
		    });	

    	  loadTypeDiv();
		   
	 } );

      function loadTypeDiv(){
    		var typeid = $("select#type").val();
  		if(typeid == "SALARY") {
  	      	$("#salarydiv").css("display","");
  	      	$("#bonusdiv").css("display","none");
  		}else if(typeid == "BONUS"){
  			$("#salarydiv").css("display","none");
  	      	$("#bonusdiv").css("display","");
  		}else{
  			$("#salarydiv").css("display","none");
  	      	$("#bonusdiv").css("display","none");
  	  	}
   	}

      

    </script>
    