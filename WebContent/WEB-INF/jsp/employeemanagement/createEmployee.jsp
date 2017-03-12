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
										<label class="col-sm-2 control-label">Employment Type</label>
										<div class="col-sm-10">
											<form:input path="promotionmessage" type="text" class="form-control"
						                                id="promotionmessage" placeholder="Enter promotion message" />
											<form:errors path="promotionmessage" class="text-danger" />
										</div>
										<label class="col-sm-2 control-label">Type</label>
										<div class="col-sm-5">
						                    <form:select path="expensetypeid" class="form-control" id="expensetypeid">
												<form:option value="" label="--- Select ---"/>
						   						<form:options items="${expenseTypeList}" />
											</form:select>            
											<form:errors path="expensetypeid" class="text-danger" />
										</div>
								  	</div>
								</div>
					            <div class="row">
						            <div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Promotion Period</label>
											<div class="col-sm-10">
						                  		<form:input path="promotionperiod" type="text" class="form-control" 
						                  			  id="promotionperiod" placeholder="Press to select date"/>
						                  		<form:errors path="promotionperiod" class="text-danger" />
						                	</div>
						              </div>
					            </div>
								<div class="row">		  
							  	<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="col-sm-2 control-label">Active</label>
									<div class="col-sm-10">
										<div class="checkbox">
									  		<label><form:checkbox path="isactive" id="isactive" /></label>
									     	<form:errors path="isactive" class="text-danger" />
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
										<button id="addPromotionBtn" type="submit" class="btn btn-primary" form ="createPromotionForm">Add</button>
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
    	//Date range picker with time picker
    	$('#promotionperiod').daterangepicker(
   	    	{
   	    		timePicker: true,
   	         	timePickerIncrement: 1,
   	         	locale: {
   	             format: 'DD/MM/YYYY h:mm A'
   	 			}
           	}, 
   	    	function(start, end, label) {
       	    	$("#promotionstartdate").prop("value", start.format('YYYY-MM-DD h:mm'));
       	    	$("#promotionenddate").prop("value", end.format('YYYY-MM-DD h:mm'));
        });

	   	var date = new Date();
		var day = date.getUTCDate();
		var month = date.getUTCMonth();
		var year = date.getUTCFullYear();
	   if (document.getElementById("promotionstartdate").value == '') {			
			$("#promotionstartdate").datepicker("setDate", new Date(year, month, day));
	    }
	   if (document.getElementById("promotionenddate").value == '') {			
			$("#promotionenddate").datepicker("setDate", new Date(year, month, day));
	    }

	    $("#addPromotionBtn").click(function(){
	    	if (document.getElementById("promotionstartdate").value == '') {			
				$("#promotionstartdate").datepicker("setDate", new Date(year, month, day));
		    }
		   if (document.getElementById("promotionenddate").value == '') {			
				$("#promotionenddate").datepicker("setDate", new Date(year, month, day));
		    }
		}); 
		   
	 } );

      

    </script>
    