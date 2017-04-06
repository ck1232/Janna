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
                    	<h3 class="box-title">Cheque Information</h3>
                    </div>
                    <!--FORM-->
                    <form id="backToListButton" method="get" action="<c:url value="/cheque/listCheque" />"></form>
                    <!--/.FORM-->
		             	<div class="box-body">
							<div class="row">
						  		<div class="form-group">
									<div class="col-sm-2">Cheque No</div>
									<div class="col-sm-5">${cheque.chequeNum}</div>
								</div>
							</div>
							<div class="row">
						  		<div class="form-group">
								    <div class="col-sm-2">Cheque Amount</div>
								    <div class="col-sm-5">${cheque.chequeAmt}</div>
								</div>
							</div>			
							<div class="row">
						  		<div class="form-group">	  
									<div class="col-sm-2">Cheque Date</div>
									<div class="col-sm-5">${cheque.chequeDate}</div>
								</div>
							</div>	
							<div class="row">
						  		<div class="form-group">
								    <div class="col-sm-2">Debit Date</div>
								    <div class="col-sm-5">${cheque.debitDate}</div>
								</div>
							</div>	
							<div class="row">
						  		<div class="form-group">
								    <div class="col-sm-2">Remarks</div>
								    <div class="col-sm-5">${cheque.remarks}</div>
								</div>
							</div>	
							<div class="row">
						  		<div class="form-group">
								    <div class="col-sm-2">Bounced</div>
								    <div class="col-sm-5">${cheque.bounceChequeInd}</div>
								</div>
							</div>	
						</div>
						<!-- /.box-body -->
		      		</div>
		      		<!-- /.BOX -->
              </div>
    	</div>
    	<c:if test="${expenseList != null}">
	    	<div class="box">
				<div class="box-header with-border">
	                  	<h3 class="box-title">All Paid Expense</h3>
	                  </div>
	            	<div class="box-body">
	            		<div class="row">
							<div class="col-sm-2">Expense Date</div>
							<div class="col-sm-2">Expense Type</div>
							<div class="col-sm-2">Description</div>
							<div class="col-sm-2">Expense Amount</div>
							<div class="col-sm-2">Supplier</div>
							<div class="col-sm-2">Status</div>
						</div>
						<c:forEach items="${expenseList}" var="expense">
							<div class="row">
								<div class="col-sm-2">${expense.expensedateString}</div>
							    <div class="col-sm-2">${expense.expensetype}</div>
							    <div class="col-sm-2">${expense.description}</div>
							    <div class="col-sm-2">${expense.totalAmt}</div>
							    <div class="col-sm-2">${expense.supplier}</div>
							    <div class="col-sm-2">${expense.status}</div>
							</div>
						</c:forEach>
				</div>
			</div>
		</c:if>
		<c:if test="${salaryList != null}">
	    	<div class="box">
				<div class="box-header with-border">
	                  	<h3 class="box-title">All Paid Salary</h3>
	                  </div>
	            	<div class="box-body">
	            		<div class="row">
							<div class="col-sm-2">Salary Month</div>
							<div class="col-sm-2">Employee Name</div>
							<div class="col-sm-2">Salary Amount</div>
							<div class="col-sm-2">Status</div>
						</div>
						<c:forEach items="${salaryList}" var="salary">
							<div class="row">
								<div class="col-sm-2">${salary.dateString}</div>
							    <div class="col-sm-2">${salary.name}</div>
							    <div class="col-sm-2">${salary.takehomeAmt}</div>
							    <div class="col-sm-2">${salary.status}</div>
							</div>
						</c:forEach>
				</div>
			</div>
		</c:if>
		<c:if test="${bonusList != null}">
	    	<div class="box">
				<div class="box-header with-border">
	                  	<h3 class="box-title">All Paid Bonus</h3>
	                  </div>
	            	<div class="box-body">
	            		<div class="row">
							<div class="col-sm-2">Bonus Year</div>
							<div class="col-sm-2">Employee Name</div>
							<div class="col-sm-2">Bonus Amount</div>
							<div class="col-sm-2">Status</div>
						</div>
						<c:forEach items="${bonusList}" var="bonus">
							<div class="row">
								<div class="col-sm-2">${bonus.dateString}</div>
							    <div class="col-sm-2">${bonus.name}</div>
							    <div class="col-sm-2">${bonus.bonusAmt}</div>
							    <div class="col-sm-2">${bonus.status}</div>
							</div>
						</c:forEach>
				</div>
			</div>
		</c:if>
		<c:if test="${invoiceList != null}">
	    	<div class="box">
				<div class="box-header with-border">
	                  	<h3 class="box-title">All Paid invoice</h3>
	                  </div>
	            	<div class="box-body">
	            		<div class="row">
							<div class="col-sm-2">Invoice Id</div>
							<div class="col-sm-4">Messenger</div>
							<div class="col-sm-2">Total Price</div>
							<div class="col-sm-2">Invoice Date</div>
							<div class="col-sm-2">Status</div>
						</div>
						<c:forEach items="${invoiceList}" var="invoice">
							<div class="row">
								<div class="col-sm-2">${invoice.invoiceId}</div>
							    <div class="col-sm-4">${invoice.messenger}</div>
							    <div class="col-sm-2">${invoice.totalAmt}</div>
							    <div class="col-sm-2">${invoice.invoiceDate}</div>
							    <div class="col-sm-2">${invoice.status}</div>
							</div>
						</c:forEach>
				</div>
			</div>
		</c:if>
    	<div class="row">
       		<div class="form-group">
	        	<div class="col-sm-2"></div>
				<div class="col-sm-10">
	            	<button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
				</div>
			</div>
		</div>	
    </section>