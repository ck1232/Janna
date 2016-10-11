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
                    	<h3 class="box-title">Role Information</h3>
                    </div>
                    <!--FORM-->
                    <form:form id="backToListButton" method="get" action="/JJ/listRole"></form:form>
                    <form:form id="createRoleForm" method="post" modelAttribute="roleForm" action="/JJ/createRole">
		              <div class="box-body">
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Role Name</label>
							<div class="col-sm-10">
								<form:input path="name" type="text" class="form-control"
				                                id="name" placeholder="Enter role name" />
								<form:errors path="name" class="text-danger" />
							</div>
						  </div>
						<br/>
						<br/>
						<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-info btn-add" form ="createRoleForm">Add
			                  </button>
			                  <button type="submit" class="btn btn-info btn-edit" form="backToListButton"><i class="fa fa-remove"></i> Cancel
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