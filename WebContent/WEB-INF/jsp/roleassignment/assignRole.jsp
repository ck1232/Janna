<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    	<h3 class="box-title">Selected User</h3>
                    </div>
                    <!--FORM-->
                    <form:form id="backToListButton" method="get" action="/JJ/listUser"></form:form>
                    <form:form id="saveRoleToUserForm" method="post" modelAttribute="user" action="/JJ/saveRoleToUser">
		              <div class="box-body">
		              		<form:input path="id" type="hidden" id="id"/>
							<div class="col-sm-2">User id</div>
							<div class="col-sm-10">${user.userid}</div>
							<tiles:insertAttribute name = "datatable" />
							
						<br/><br/>
		            	<!--/.FORM-->
		            		<div class="col-sm-2"></div>
							<div class="col-sm-10">
							  <button name="saveRoleBtn" class="btn btn-info btn-edit" type="submit" form="saveRoleToUserForm">Save</button>
			                  <button class="btn btn-info btn-edit" type="submit" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
							</div>
						</div>
						</form:form>
		              </div>
		              <!-- /.box-body -->
                </div>
    	</div>
    </section>