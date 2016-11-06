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
                    	<h3 class="box-title">Promotion Information</h3>
                    </div>
                    <!--FORM-->
                    <form id="backToListButton" method="get" action="<c:url value="/product/promotion/listPromotion" />"></form>
                    <form id="updatePromotionForm" method="post" action="<c:url value="/product/promotion/updatePromotion" />">
                    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    	<input type="hidden" name="editBtn" value="${promotion.promotionid}"/>
                    </form>
                    <!--/.FORM-->
		             	<div class="box-body">
			              	<div class="row">
			              		<div class="form-group">
				              		<div class="col-sm-2 control-label">Name</div>
									<div class="col-sm-10">${promotion.promotionname}</div>
								</div>
			              	</div>
							<div class="row">
						  		<div class="form-group">
									<div class="col-sm-2">Message</div>
									<div class="col-sm-10">${promotion.promotionmessage}</div>
								</div>
							</div>
							<div class="row">
						  		<div class="form-group">
								    <div class="col-sm-2">Start Date</div>
								    <div class="col-sm-10">${promotion.promotionstartdate}</div>
								</div>
							</div>			
							<div class="row">
						  		<div class="form-group">	  
									<div class="col-sm-2">End Date</div>
									<div class="col-sm-10">${promotion.promotionenddate}</div>
								</div>
							</div>	
							<div class="row">
						  		<div class="form-group">	  
									<div class="col-sm-2">Active</div>
									<div class="col-sm-10">${promotion.isactive}</div>
								</div>
							</div>	
							<br/>
							<br/>
		            	
			            	<div class="row">
			            		<div class="form-group">
				            		<div class="col-sm-2"></div>
									<div class="col-sm-10">
										<button type="submit" class="btn btn-primary" form ="updatePromotionForm">Edit</button>
					                  	<button type="submit" class="btn btn-default" form="backToListButton"><i class="fa fa-remove"></i> Cancel</button>
									</div>
								</div>
							</div>	
						</div>
						<!-- /.box-body -->
		      		</div>
		      		<!-- /.BOX -->
              </div>
    	</div>
    </section>