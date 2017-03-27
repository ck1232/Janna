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
												<td>${payment.paymentDateString}</td>
							          			<td>${payment.paymentModeString}</td>
							          			<td>${payment.paymentAmt}</td>
							          			<td>${payment.chequeNum}</td>
							          			<td>
							          				<c:if test="${payment.bounceChequeInd == 'N'}">No</c:if>
							          				<c:if test="${payment.bounceChequeInd == 'Y'}">Yes</c:if>
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