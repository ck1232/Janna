<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Content Wrapper. Contains page content -->
<script type="text/javascript">
	function viewProduct(productId){
		$("#selectedEditProduct").val(productId);
		$("#productSubmitForm").attr("action", "./editProduct");
		$("#productSubmitForm").submit();
	}
</script>
<div class="row">
	<div class="col-xs-12">
    	<div class="box">
            <div class="box-header">
              <h3 class="box-title"><tiles:insertAttribute name = "table-title" /></h3>
              <tiles:insertAttribute name = "options" />
            </div>
            
            <div class="box-body">
	            <form:form id="productSubmitForm" method="post">
	            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	            	<input type="hidden" name="editBtn" id="selectedEditProduct" />
	            	
						<div class= "row margin-three">
							<c:forEach items="${productList}" var="product">
								<div class="col-md-3 col-sm-6 text-center margin-one">
										<a href="#" onclick="viewProduct(${product.productid});">
											<img alt="" src="./getProductImage/${product.productid}">
											<input type="checkbox" class="selectionCheckbox" name="checkboxId" value="${product.productid}"/>
										</a>
									<span class="product-link">
										<a href="#" onclick="viewProduct(${product.productid});">${product.productname}</a>
									</span>
								</div>
							</c:forEach>
						</div>

	            </form:form>
            </div>
		</div>
	</div>
</div>