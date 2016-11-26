<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="margin">
	<div class="btn-grp">
		<button class="btn btn-primary pull-right" type="button" form="datatableForm" formaction="<c:url value="/admin/deleteProductOption" />"><i class="fa fa-user-times"></i> Delete Option</button>
		<button class="btn btn-primary pull-right" type="button" onclick="addProduct();"><i class="fa fa-user-plus"></i> Add Product</button>
	</div>
</div>