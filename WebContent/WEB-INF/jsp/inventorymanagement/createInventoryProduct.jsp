<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script>

     var productList = new Bloodhound({
    	  datumTokenizer: Bloodhound.tokenizers.obj.whitespace('productname'),
    	  queryTokenizer: Bloodhound.tokenizers.whitespace,
    	  prefetch: '<c:url context="/JJ" value="/batchintake/getProductList" />'
    	}); 
 	
    $( function() {
    	$('#addProductNameDiv .typeahead').keyup(function(){
   			$("#productId").val("");
   	    	$("#quantity").val("");
   	    	$("#unitPrice").val("");
   	    	$('#optionDiv').empty();
   	    	$('#quantityDiv').css("display", "none");
   		  	$('#unitcostDiv').css("display", "none");
		});
	    
    	$('#addProductNameDiv .typeahead').typeahead(null, {
    		 name: 'productList',
    		  display: 'productname',
    		source: productList
		});
		
    	$('#addProductNameDiv .typeahead').on('typeahead:selected', function(evt, item) {
        	$("#productId").val(item.productid);
    		getList(item);
    	});
	 } );

    function getList(item) {
		var id = item.productid;
		var data = {
	  	        "productid" : id
	    	}
		$.ajax({
	  		  type: "POST",
	  		  url: "getBatchProductVo",
	  		  data: JSON.stringify(data),
	  		  contentType:"application/json; charset=utf-8",
		  	  success: function (result) {
		            //console.log(result.status);
		        },
			  beforeSend: function( xhr ) {
				  xhr.setRequestHeader(header, token);

				}
	  		}).done(function(productVo) {
  	  			//alert("done");
  	  			console.log(productVo);
  	  			$('#optionDiv').empty();
  	  			$.each(productVo.optionList, function(index){
					$("#optionDiv").append('<div class="row"><div class="form-group">'+
							'<label class="col-sm-3 control-label">'+this.optionName+'</label>'+
							'<select class="selectpicker col-sm-9" id='+this.optionName+' name ='+this.optionName+'></select></div></div>');
					var name = this.optionName;
					$.each(this.subOptionList, function(index){
						$('#'+name).append('<option value=' + this.subOptionId + '>' + this.subOptionName + '</option>');
					});
					$('#'+name).selectpicker('val', "");
  	  	  	  	});
  	  		$('#quantityDiv').css("display", "");
  	  		$('#unitcostDiv').css("display", "");
			});
	}

	
    
    function addProduct(){
    	$("#name").val("");
    	$("#productId").val("");
    	$("#quantity").val("");
    	$("#unitPrice").val("");
    	$('#optionDiv').empty();
		$("#productModal").show();
	}

    function closeProduct(){
    	$('#optionDiv').empty();
    	$('#quantityDiv').css("display", "none");
	  	$('#unitcostDiv').css("display", "none");
		$("#productModal").hide();
	}

    function saveAddIntakeProduct(){
    	var productName = $("#name").val();
    	var productId = $("#productId").val();
    	var productData = {
    	    productid  : productId,
    		productname : productName
    	}
    	var qty = $("#quantity").val();
    	var unitprice = $("#unitPrice").val();
		var productDivList = $("#optionDiv").find("select");
		console.log(productDivList);
		var subOptionList = []; 
		if(productDivList != null && productDivList.length > 0){
			$.each(productDivList, function(index){
				var optionName = $(this).attr('id');
				var subOptionId = $(this).val();
				var subOptionData = {
					optionName : optionName,
					subOptionId : subOptionId
				}
				subOptionList.push(subOptionData);
			});
		}

		var data = {
			product : productData,
			subOptionList : subOptionList,
			unitcost : unitprice,
			qty : qty
		}
		

		var saveAjax = $.ajax({
  		  type: "POST",
  		  url: "saveAddProduct",
  		  data: JSON.stringify(data),
  		  contentType:"application/json; charset=utf-8",
		  beforeSend: function( xhr ) {
			  xhr.setRequestHeader(header, token);

			},
			success: function(data, textStatus ){
				if(data.status =="error"){
					alert(data.message);
				}else{
					console.log(textStatus);
					$("#optionDiv").empty();
					$("#name").val("");
					$("#quantity").val("");
					$("#unitPrice").val("");
					closeProduct();
					intakeTable.ajax.reload();
				}
		    }
  		}); 
    }


</script>


<!-- Content Wrapper. Contains page content -->
    <section class="content">
    	<div class="row">
    		<div class="col-md-12">
    			<!--BOX-->
                <div class="box">
                	<!--BOX HEADER-->
                    <div class="box-header with-border">
                    	<h3 class="box-title">Add Inventory Product</h3>
                    </div>
                    <!--FORM-->
                    <form id="backToListButton" method="get" action="<c:url value="/inventory/listInventoryProduct" />"></form>
                    <c:url var="post_url" value="/inventory/createInventoryProduct" />
                    <form:form id="createInventoryProductForm" method="post" modelAttribute="inventoryProductForm" action="${post_url }">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		             	<div class="box-body">
		              		<div class="row">
							  	<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="col-sm-2 control-label">Remarks</label>
									<div class="col-sm-10">
										<form:input path="remarks" type="text" class="form-control"
						                                id="remarks" placeholder="Enter remarks for adding" />
											<form:errors path="remarks" class="text-danger" />
									</div>
							  	</div>
							</div>
							<div class="row">
						            <div class="form-group ${status.error ? 'has-error' : ''}">
										<label class="col-sm-2 control-label">Initial Location</label>
											<div class="col-sm-10" id="addLocationNameDiv">
						                  		<form:input type="text" class="form-control typeahead" 
						                  			  path="storagelocationname" id="storagelocationname" />
						                  		<form:input path="storagelocation" id="storagelocation" type="hidden"/>
						                  		<form:errors path="storagelocation" class="text-danger" />
						                	</div>
						              </div>
					            </div>
					            <br/><br/>
		            	</div>
		            	<tiles:insertAttribute name = "productList" />
	            		<div class="row">
							<div class="form-group">
								<label class="col-sm-2 control-label"></label>
									<div class="col-sm-10">
										<button type="submit" class="btn btn-primary" form ="createInventoryProductForm">Add</button>
			                  			<button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
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
							<input id="productId" type="hidden">
						</div>
					</div>
				</div>
				<div id = "optionDiv"></div>
				<hr>
				<div class="row" id="unitcostDiv" style="display:none">
					<div class="form-group">
						<label class="col-sm-3 control-label">Unit Cost</label>
						<div class="col-sm-9">
							<input id="unitPrice" class="form-control col-sm-12" type="number" />
						</div>
					</div>
				</div>
				<div class="row" id="quantityDiv" style="display:none">
					<div class="form-group">
						<label class="col-sm-3 control-label">Quantity</label>
						<div class="col-sm-9">
							<input id="quantity" class="form-control col-sm-12" type="number" />
						</div>
					</div>
				</div>
				
			</div>
			<div class="modal-footer">
				<button id="saveProductBtn" class="btn btn-primary" type="button" onclick="saveAddInventoryProduct();">Add</button>
				<button type="button" onclick="closeProduct();" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>