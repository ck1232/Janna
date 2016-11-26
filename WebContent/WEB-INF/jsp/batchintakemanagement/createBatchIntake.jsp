<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>

    var productname = new Bloodhound({
    	  datumTokenizer: Bloodhound.tokenizers.whitespace,
    	  queryTokenizer: Bloodhound.tokenizers.whitespace,
    	  prefetch: '<c:url context="/JJ" value="/batchintake/getProductNameList" />'
    	});
    
    $( function() {
    	$('#date').datepicker(
    	{
    		dateFormat: 'dd/MM/yyyy',
	      	autoclose: true
	    });
	    
    	$('#addProductNameDiv .typeahead').typeahead(null, {
			  name: 'productname',
			  source: productname
		});
		
    	$('#addProductNameDiv .typeahead').on('typeahead:selected', function(evt, item) {
    		getList(item);
    		//alert(item);
    	});
	 } );

	function getList(item) {
		alert(item);
		
		$.ajax({
	  		  type: "POST",
	  		  url: "getBatchProductVo",
	  		  data: item,
	  		  contentType:"application/json; charset=utf-8",
		  	  success: function (result) {
		            alert(result.status);
		        },
			  beforeSend: function( xhr ) {
				  xhr.setRequestHeader(header, token);

				}
	  		}).done(function() {
  	  			//alert("done");
			});
	}
    
    function addProduct(){
		$("#productModal").show();
	}

    function closeProduct(){
		$("#productModal").hide();
	}

    function saveProduct(){
    	closeProduct();
    }
      

</script>
<!-- Content Wrapper. Contains page content -->
    <section class="content">
    	<div class="row">
    		<div class="col-md-12">
    			<c:url var="post_url" value="/batchintake/createBatchIntake" />
    			<form id="backToListButton" method="get" action="<c:url value="/batchintake/listBatchIntake" />"></form>
    			<form:form id="createBatchIntakeForm" method="post" modelAttribute="batchIntakeForm" action="${post_url}">
    			<!--BOX-->
                <div class="box">
                	<!--BOX HEADER-->
                    <div class="box-header with-border">
                    	<h3 class="box-title">Batch Information</h3>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			              <div class="box-body">
				              	<div class="row">
								  	<div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Remarks</label>
										<div class="col-sm-10">
											<form:input path="remarks" type="text" class="form-control"
						                                id="remarks" placeholder="Enter batch remarks" />
											<form:errors path="remarks" class="text-danger" />
										</div>
								  	</div>
								</div>
								<div class="row">
								  	<div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Purchase Date</label>
										<div class="col-sm-10">
											<form:input path="date" type="text" class="form-control"
						                                id="date" placeholder="Press to select date" />
											<form:errors path="date" class="text-danger" />
										</div>
								  	</div>
								</div>
					            <div class="row">
						            <div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Initial Location</label>
											<div class="col-sm-10">
						                  		<form:input path="storagelocation" type="text" class="form-control" 
						                  			  id="storagelocation" placeholder="Enter initial location"/>
						                  		<form:errors path="storagelocation" class="text-danger" />
						                	</div>
						              </div>
					            </div>
					            <div class="row">
								  	<div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Total Cost</label>
										<div class="col-sm-10">
											<form:input path="totalcost" type="number" class="form-control"
						                                id="totalcost" placeholder="Enter total cost" />
											<form:errors path="totalcost" class="text-danger" />
										</div>
								  	</div>
								</div>		
			              </div>
			              <!-- /.box-body -->
		            
                </div>
                <tiles:insertAttribute name = "productList" />
                <div class="row">
					<div class="form-group">
						<label class="col-sm-2 control-label"></label>
						<div class="col-sm-10">
							<button id="addBatchIntakeBtn" type="submit" class="btn btn-primary" form ="createBatchIntakeForm">Add</button>
		                  <button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
						</div>
					</div>
				</div>
				</form:form>
		        <!--/.FORM-->
    		</div>
    	</div>
    </section>
    
    
    <div id="productModal" class="modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title">Add Product</h3>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="form-group">
						<label class="col-sm-3 control-label">Name</label>
						<div class="col-sm-9" id="addProductNameDiv">
							<input id="name" class="form-control typeahead col-sm-12" type="text" />
						</div>
						<hr>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="saveOptionBtn" class="btn btn-primary" type="button" onclick="saveProduct();">Save changes</button>
				<button type="button" onclick="closeProduct();" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
    