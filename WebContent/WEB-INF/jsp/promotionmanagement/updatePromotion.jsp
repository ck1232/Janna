<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Content Wrapper. Contains page content -->

                <div class="box">
                	<!--BOX HEADER-->
                    <div class="box-header with-border">
                    	<h3 class="box-title">Promotion Information</h3>
                    </div>
                    <!--FORM-->
                    <form id="backToListButton" method="get" action="<c:url value="/product/promotion/listPromotion" />"></form>
                    <c:url var="post_url" value="/product/promotion/updatePromotionToDb" />
                    <form:form id="updatePromotionToDbForm" method="post" modelAttribute="promotionForm" action="${post_url}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <form:input path="promotionstartdate" type="hidden" id="promotionstartdate"/>
                    <form:input path="promotionenddate" type="hidden" id="promotionenddate"/>
                    <form:input path="deleteind" type="hidden" id="deleteind"/>
		              <div class="box-body">
		              		<form:input path="promotionid" type="hidden" id="promotionid"/>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<form:input path="promotionname" type="text" class="form-control"
				                                id="promotionname" placeholder="Enter promotion name" />
								<form:errors path="promotionname" class="text-danger" />
							</div>
						  </div>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Message</label>
							<div class="col-sm-10">
								<form:input path="promotionmessage" type="text" class="form-control"
				                                id="promotionmessage" placeholder="Enter promotion message" />
								<form:errors path="promotionmessage" class="text-danger" />
							</div>
						  </div>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Promotion Period</label>
							<div class="col-sm-10">
								<form:input path="promotionperiod" type="text" class="form-control"
				                                id="promotionperiod" placeholder="Press to select date" />
								<form:errors path="promotionperiod" class="text-danger" />
							</div>
						  </div>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Active</label>
							<div class="col-sm-10">
								<div class="checkbox">
							  		<label><form:checkbox path="isactive" id="isactive" /></label>
							     	<form:errors path="isactive" class="text-danger" />
								</div>
							</div>
						  </div>
						  
						<br/>
						<br/>
						<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
			                  <button id="updatePromotionBtn" type="submit" class="btn btn-primary" form="updatePromotionToDbForm">Update
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

	    $("#updatePromotionBtn").click(function(){
	    	if (document.getElementById("promotionstartdate").value == '') {			
				$("#promotionstartdate").datepicker("setDate", new Date(year, month, day));
		    }
		   if (document.getElementById("promotionenddate").value == '') {			
				$("#promotionenddate").datepicker("setDate", new Date(year, month, day));
		    }
		}); 
		   
	 } );

      

    </script>