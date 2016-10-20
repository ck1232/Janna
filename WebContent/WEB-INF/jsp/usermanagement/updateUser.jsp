<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Content Wrapper. Contains page content -->

                <div class="box">
                	<!--BOX HEADER-->
                    <div class="box-header with-border">
                    	<h3 class="box-title">User Information</h3>
                    </div>
                    <!--FORM-->
                    
		              <div class="box-body">
		              <form:form id="backToListButton" method="get" action="/JJ/listUser"></form:form>
		              <form:form id="updateUserToDbForm" method="post" modelAttribute="userForm" action="/JJ/updateUserToDb">
		              		<form:input path="id" type="hidden" id="id"/>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">User id</label>
							<div class="col-sm-10">
								<form:input path="userid" type="text" class="form-control"
				                                id="userid" placeholder="Enter userid" />
								<form:errors path="userid" class="text-danger" />
							</div>
						  </div>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<form:input path="name" type="text" class="form-control"
				                                id="name" placeholder="Enter name" />
								<form:errors path="name" class="control-label" />
							</div>
						  </div>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Email Address</label>
							<div class="col-sm-10">
								<form:input path="emailaddress" class="form-control"
				                                id="emailaddress" placeholder="Enter email address" />
								<form:errors path="emailaddress" class="control-label" />
							</div>	
							</div>	
							
							<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Password</label>
							<div class="col-sm-10">
								<button type="button" class="btn btn-primary" onclick="$('#passwordModal').modal('show');">Reset Password</button>
							</div>	
							</div>				  
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Enabled</label>
							<div class="col-sm-10">
								<div class="checkbox">
								  <label>
				                       <form:checkbox path="enabled" id="enabled" />
								  </label>
								     <form:errors path="enabled" class="control-label" />
								</div>
							</div>
						  </div>

						<br/>
						
						  </form:form>
						  <!--/.FORM-->
						  
						  <div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary" form="updateUserToDbForm">Update
			                  </button>
			                  <button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel
			            </button>
			                </div>
						  </div>
		              </div>
		              <!-- /.box-body -->
		            
                </div>
<div id="passwordModal" class="modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Reset Password</h4>
			</div>
			<div class="modal-body">
			<form action="/JJ/resetpassword" id="resetPasswordForm" name="resetPasswordForm" method="post">
				<input type="hidden" value="${userForm.userid}" name="userid" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<div class="row form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Password</label>
							<div class="col-sm-10">
								<input name="password" class="form-control" type="password"
				                    id="password" placeholder="Reset Password" />
							</div>
				</div>
			</form>
				<p></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default pull-left"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="$('#resetPasswordForm').submit();">Reset</button>
			</div>
		</div>
	</div>
</div>