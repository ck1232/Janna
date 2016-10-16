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
                    	<h3 class="box-title">Module Information</h3>
                    </div>
                    <!--FORM-->
                    <form:form id="backToListButton" method="get" action="/JJ/listModule"></form:form>
                    <form:form id="updateModuleToDbForm" method="post" modelAttribute="module" action="/JJ/updateModuleToDb">
		              <div class="box-body">
		              		<form:input path="id" type="hidden" id="id"/>
							<div class="col-sm-2">Name</div>
							<div class="col-sm-10">${module.name}</div>
							
						    <div class="col-sm-2">Icon</div>
						    <div class="col-sm-10">${module.icon} <i class="fa ${module.icon}"></i></div>
						<br/><br/>
						<tiles:insertAttribute name = "datatable" />
		            	<!--/.FORM-->
		            		<div class="col-sm-2"></div>
							<div class="col-sm-10">
			                  <button type="submit" class="btn btn-primary" form="backToListButton"><i class="fa fa-remove"></i> Done
			            	</button>
							</div>
		              </div>
		              <!-- /.box-body -->
		            </form:form>
		            <!--/.FORM-->
                </div>
             </div>
    	</div>
    </section>