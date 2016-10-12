<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Add New User</h1>
		<ol class="breadcrumb">
			<li><a href="/JJ/dashboard.html"><i class="fa fa-dashboard"> Home</i></a></li>
			<li><a href="/JJ/listUser.html">Add New User</a></li>
		</ol>
	</section>
    
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
                    <form:form method="post" modelAttribute="userForm" action="/JJ/createUser">
		              <div class="box-body">
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">First Name</label>
							<div class="col-sm-10">
								<form:input path="name" type="text" class="form-control"
				                                id="name" placeholder="Enter name" />
								<form:errors path="name" class="text-danger" />
							</div>
						  </div>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Email Address</label>
							<div class="col-sm-10">
								<form:input path="emailaddress" class="form-control"
				                                id="emailaddress" placeholder="Enter email" />
								<form:errors path="emailaddress" class="control-label" />
							</div>
						  </div>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Username</label>
							<div class="col-sm-10">
								<form:input path="userid" type="text" class="form-control"
				                                id="userid" placeholder="Enter username" />
								<form:errors path="userid" class="control-label" />
							</div>
						  </div>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Password</label>
							<div class="col-sm-10">
								<form:password path="password" class="form-control"
				                                id="password" placeholder="Enter password" />
								<form:errors path="password" class="control-label" />
							</div>
						  </div>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Active</label>
							<div class="col-sm-10">
								<div class="checkbox">
								  <label>
				                       <form:checkbox path="enabled" id="active" />
								  </label>
								     <form:errors path="enabled" class="control-label" />
								</div>
							</div>
						  </div>
						<br/>
						<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-info btn-add">Add
			                  </button>
							</div>
						  </div>
		              </div>
		              <!-- /.box-body -->
		            </form:form>
		            <!--/.FORM-->
                </div>
    		</div>
    	</div>
    </section>
</div>