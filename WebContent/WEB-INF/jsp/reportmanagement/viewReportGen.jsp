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
                    	<h3 class="box-title">Report Generation</h3>
                    </div>
                    <c:url var="post_url" value="/report/generateExpenseControlReport" />
                    <form:form id="generateExpenseControlForm" method="post" modelAttribute="expenseControlForm" action="${post_url}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		            <div class="box-body">
		            	<div class="row">
		            		<div class="form-group">
			            		<div class="col-sm-2">Expense Control</div>
			            		<div class="col-sm-2">
			            			<form:select path="year" class="form-control" id="year">
				   						<form:options items="${yearList}" />
									</form:select>
								</div>
								<div class="col-sm-2">
									<button type="submit" class="btn btn-primary" form ="generateExpenseControlForm">Generate</button>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					</form:form>
		            <!--/.FORM-->
		      	</div>
		    	<!-- /.BOX -->
        	</div>
    	</div>
    </section>