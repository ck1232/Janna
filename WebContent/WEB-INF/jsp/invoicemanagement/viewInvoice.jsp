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
                    	<h3 class="box-title">Invoice Information</h3>
                    </div>
                    <!--FORM-->
                    <form id="backToListButton" method="get" action="<c:url value="/invoice/listInvoice" />"></form>
  
                    <!--/.FORM-->
		             	<div class="box-body">
							<div class="row">
						  		<div class="form-group">
									<div class="col-sm-2">Invoice id</div>
									<div class="col-sm-5">${invoice.invoiceId}</div>
								</div>
							</div>
							<div class="row">
						  		<div class="form-group">
								    <div class="col-sm-2">Messenger</div>
								    <div class="col-sm-5">${invoice.messenger}</div>
								</div>
							</div>			
							<div class="row">
						  		<div class="form-group">	  
									<div class="col-sm-2">Total Price</div>
									<div class="col-sm-5">${invoice.totalAmt}</div>
								</div>
							</div>	
							<div class="row">
						  		<div class="form-group">
								    <div class="col-sm-2">Invoice Date</div>
								    <div class="col-sm-5">${invoice.invoicedateString}</div>
								</div>
							</div>	
							<div class="row">
						  		<div class="form-group">
								    <div class="col-sm-2">Status</div>
								    <div class="col-sm-5">${invoice.status}</div>
								</div>
							</div>	
						</div>
						<!-- /.box-body -->
		      		</div>
		      		<!-- /.BOX -->
		      		
		      		<tiles:insertAttribute name="paymentdetail"/>
		      		
		      		<div class="row">
	            		<div class="form-group">
		            		<div class="col-sm-2"></div>
							<div class="col-sm-10">
			                  	<button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
							</div>
						</div>
					</div>	
              </div>
    	</div>
    </section>