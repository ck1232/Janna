<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Content Wrapper. Contains page content -->
    <section class="content">
    	<div class="row">
    		<div class="col-md-12">
    			<!--BOX-->
                <div class="box">
                	<!--BOX HEADER-->
                    <div class="box-header with-border">
                    	<h3 class="box-title">Submodule Information</h3>
                    </div>
                    <!--FORM-->
                    <form id="backToListButton" method="post" action="<c:url value="/admin/updateModule" />">
                    	<input type="hidden" name="editBtn" value="${submodule.parentid}"/>
                    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <c:url var = "post_url" value="/admin/updateSubmodule" />
                    <form:form id="updateSubmoduleForm" method="post" action="${post_url }">
                    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    	<input type="hidden" name="editBtn" value="${submodule.id}"/>
                    </form:form>
		              <div class="box-body">
							<div class="col-sm-2">Submodule name</div>
							<div class="col-sm-10">${submodule.name}</div>
							
							<div class="col-sm-2">Icon</div>
							<div class="col-sm-10">${submodule.icon}</div>
							
							<div class="col-sm-2">Url</div>
							<div class="col-sm-10">${submodule.url}</div>
							
						    <div class="col-sm-2" style="display: none">Parent Id</div>
						    <div class="col-sm-10" style="display: none">${submodule.parentid}</div>
						    
						    <div class="col-sm-2">Parent Module Name</div>
						    <div class="col-sm-10">${submodule.parentModuleName}</div>
						<br/><br/>
						
		            	<!--/.FORM-->
		            		<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary" form ="updateSubmoduleForm">Edit
			                  </button>
			                  <button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel
			            	</button>
							</div>
						</div>
		              </div>
		              <!-- /.box-body -->
                </div>
    	</div>
    </section>