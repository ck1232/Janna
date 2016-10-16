<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Content Wrapper. Contains page content -->

                <div class="box">
                	<!--BOX HEADER-->
                    <div class="box-header with-border">
                    	<h3 class="box-title">Submodule Information</h3>
                    </div>
                    <!--FORM-->
                    <form:form id="backToListButton" method="post" action="/JJ/updateModule">
                    	<input type="hidden" name="editBtn" value="${submodule.parentid}"/>
                    </form:form>
                    <form:form id="updateSubmoduleToDbForm" method="post" modelAttribute="submodule" action="/JJ/updateSubmoduleToDb">
		              <div class="box-body">
		              		<form:input path="id" type="hidden" id="id"/>
		              		<form:input path="parentid" type="hidden" id="parentid"/>
		              		<form:input path="deleteind" type="hidden" id="deleteind"/>
		              		
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Submodule Name</label>
							<div class="col-sm-10">
								<form:input path="name" type="text" class="form-control"
				                                id="name" placeholder="Enter submodule name" />
								<form:errors path="name" class="text-danger" />
							</div>
						  </div>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Icon</label>
							<div class="col-sm-10">
								<form:input path="icon" type="text" class="form-control"
				                                id="icon" placeholder="Enter icon" />
								<form:errors path="icon" class="text-danger" />
							</div>
						  </div>
						  <div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Url</label>
							<div class="col-sm-10">
								<form:input path="url" type="text" class="form-control"
				                                id="url" placeholder="Enter submodule name" />
								<form:errors path="url" class="text-danger" />
							</div>
						  </div>
						<br/>
						<br/>
						<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
			                  <button type="submit" class="btn btn-primary" form="updateSubmoduleToDbForm">Update
			                  </button>
			                  <button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel
			            </button>
							</div>
						  </div>
		              </div>
		              <!-- /.box-body -->
		            </form:form>
		            <!--/.FORM-->
                </div>
    		