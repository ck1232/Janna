<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

					<div class="box">
	                	<!--BOX HEADER-->
	                    <div class="box-header with-border">
	                    	<h3 class="box-title">Payment Details</h3>
	                    </div>
				            <div class="box-body no-padding">
				              	<table class="table table-striped">
				              		<c:if test="${paymentList.size() > 0}">
					                	<tr>
					                		<th style="width: 20%">Date Paid</th>
					                		<th style="width: 20%">Payment Mode</th>
					                  		<th style="width: 20%">Amount</th>
					                  		<th style="width: 20%">Cheque No</th>
					                  		<th style="width: 20%">Bounced</th>
					                	</tr>
					                	<c:forEach items="${paymentList}" var="payment">
											<tr>
												<td>${payment.paymentdateString}</td>
							          			<td>${payment.paymentmodeString}</td>
							          			<td>${payment.paymentamount}</td>
							          			<td>${payment.chequenum}</td>
							          			<td>
							          				<c:if test="${payment.bouncechqind == 'N'}">No</c:if>
							          				<c:if test="${payment.bouncechqind == 'Y'}">Yes</c:if>
							          			</td>
						          			</tr>
							        	</c:forEach>
						        	</c:if>
						        	<c:if test="${paymentList.size() == 0}">
					        			<tr>
					        				<td colspan="6">No records found.</td>
					        			</tr>
				        			</c:if>
							        
				              	</table>
				            </div>
				     		<!-- /.box-body -->
		      		<!-- /.BOX -->
              		</div>