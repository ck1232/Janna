<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Content Wrapper. Contains page content -->
    <section class="content">
    	<div class="row">
    		<div class="col-md-12">
    			<!--BOX-->
                <div class="box">
                	<!--BOX HEADER-->
                    <div class="box-header with-border">
                    	<h3 class="box-title">Basic Information</h3>
                    </div>
                    <!--FORM-->
                    <form:form id="backToListButton" method="get" action="/JJ/listUser"></form:form>
                    <form:form id="updateUserForm" method="post" action="/JJ/updateUser"></form:form>
		              <div class="box-body">
							<div class="col-sm-2">User id</div>
							<div class="col-sm-10">${user.userid}</div>
							
							<div class="col-sm-2">Password</div>
							<div class="col-sm-10">${user.password}</div>
							
							<div class="col-sm-2">Name</div>
							<div class="col-sm-10">${user.name}</div>
							
						    <div class="col-sm-2">Email Address</div>
						    <div class="col-sm-10">${user.emailaddress}</div>
												  
							<div class="col-sm-2">Enabled</div>
							<div class="col-sm-10">${user.enabled}</div>
						<br/><br/>
		            	<!--/.FORM-->
		            		<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-info btn-edit" form ="updateUserForm">Edit
			                  </button>
			                  <button type="submit" class="btn btn-info btn-edit" form="backToListButton"><i class="fa fa-remove"></i> Cancel
			            	</button>
							</div>
						</div>
		              </div>
		              <!-- /.box-body -->
                </div>
    	</div>
    </section>