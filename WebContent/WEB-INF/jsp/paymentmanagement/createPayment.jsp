<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Content Wrapper. Contains page content -->

<tiles:insertAttribute name = "billtable" />

<div class="box">
	<!--BOX HEADER-->
    <div class="box-header with-border">
    	<h3 class="box-title">Payment Information</h3>
    </div>
    <!--FORM-->
    
	<div class="box-body">
		<tiles:insertAttribute name = "paymentoption" />
		<form:form id="savePaymentToDbForm" method="post" modelAttribute="paymentForm" action="${posturl}">
			<c:forEach var="referenceId" items="${idList}">
				<input type = "hidden" name = "referenceIds" value="${referenceId}" />
			</c:forEach>
			<input type ="hidden" name = "totalamount" value="${totalamount}" />
			<input type ="hidden" name = "lastdate" value="${lastdate}" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="row">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Payment Date</label>
					<div class="col-sm-4">
                  		<form:input path="paymentdateString" type="text" class="form-control" 
                  			  id="paymentdateString" placeholder="Press to select date"/>
                  		<form:errors path="paymentdateString" class="text-danger" />
                	</div>
	 			</div>
 			</div>
 			<div class="row">
			  	<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Payment Mode</label>
					<div class="col-sm-4">
						<div class="checkbox">
					  		<label><form:checkbox path="paymentmodecash" value="cash" id="paymentmodecash"/> Cash</label>
					     	<form:errors path="paymentmodecash" class="text-danger" />
						</div>
					</div>
					<label id="cashAmountLabel" class="col-sm-2 control-label" style="display:none">Cash Amount</label>
					<div id="cashAmountInput" class="col-sm-4" style="display:none">
	                    <form:input path="cashamount" type="text" class="form-control" 
                  			  id="cashamount" placeholder=""/>
                  		<form:errors path="cashamount" class="text-danger" />
					</div>
			  	</div>
			</div>
 			<div class="row">
			  	<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-4">
						<div class="checkbox">
					  		<label><form:checkbox path="paymentmodecheque" value="cheque" id="paymentmodecheque"/> Cheque</label>
					     	<form:errors path="paymentmodecheque" class="text-danger" />
						</div>
					</div>
					<div id="chequeNoDiv" style="display:none">
						<label class="col-sm-2 control-label">Cheque No</label>
						<div class="col-sm-4">
		                    <form:input path="chequeno" type="text" class="form-control" 
	                  			  id="chequeno" placeholder=""/>
	                  		<form:errors path="chequeno" class="text-danger" />
						</div>
					</div>
			  	</div>
			</div>
			<div class="row">
			  	<div id="chequeAmountDiv" class="form-group ${status.error ? 'has-error' : ''}" style="display:none">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-4"></div>
					<label class="col-sm-2 control-label">Cheque Amount</label>
					<div class="col-sm-4">
	                    <form:input path="chequeamount" type="text" class="form-control" 
                  			  id="chequeamount" placeholder=""/>
                  		<form:errors path="chequeamount" class="text-danger" />
					</div>
			  	</div>
			</div>
			<div class="row">
			  	<div id="chequeDateDiv" class="form-group ${status.error ? 'has-error' : ''}" style="display:none">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-4"></div>
					<label class="col-sm-2 control-label">Cheque Date</label>
					<div class="col-sm-4">
	                    <form:input path="chequedateString" type="text" class="form-control" 
                  			  id="chequedateString" placeholder="Click to select date"/>
                  		<form:errors path="chequedateString" class="text-danger" />
					</div>
			  	</div>
			</div>
  		</form:form>
		<!--/.FORM-->
		</div>
        <!-- /.box-body -->
	</div>
	<!-- /.BOX -->	
	<div class="row">
	 	<div class="form-group">
			<label class="col-sm-2 control-label"></label>
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary" form="savePaymentToDbForm">Save</button>
		        <button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
		    </div>
		</div>
	</div>
	
	 <script>
      $( function() {
    	  $('#paymentdateString').datepicker({
	    		format: 'dd/mm/yyyy',
		      	autoclose: true
		    });
    	  $('#chequedateString').datepicker({
	    		format: 'dd/mm/yyyy',
		      	autoclose: true
		    });


		  $('#paymentmodecash').change(function(event) {
			  loadPaymentCash();
		    });	

		  $('#paymentmodecheque').change(function(event) {
			  loadPaymentCheque();
		    });	
		  loadPaymentCash();
		  loadPaymentCheque();
	 } );

  	 function loadPaymentCash(){
		if($("#paymentmodecash").prop('checked') != true) {
	      	$("#cashAmountLabel").css("display","none");
	      	$("#cashAmountInput").css("display","none");
	      	$("#cashamount").val("");
		}else{
		   	$("#cashAmountLabel").css("display","");
		   	$("#cashAmountInput").css("display","");
		}
  	 }

  	function loadPaymentCheque(){
		if($("#paymentmodecheque").prop('checked') != true) {
			$("#chequeNoDiv").css("display","none");
			$("#chequeAmountDiv").css("display","none");
	      	$("#chequeDateDiv").css("display","none");
	      	$("#chequeno").val("");
	      	$("#chequeamount").val("");
	      	$("#chequedateString").val("");
		}else{
			$("#chequeNoDiv").css("display","");
			$("#chequeAmountDiv").css("display","");
	      	$("#chequeDateDiv").css("display","");
		}
  	 }

      

    </script>