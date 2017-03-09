<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="viewInvoiceForm" method="post" action="<c:url value="/invoice/viewInvoice" />">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<div class="margin">
	<div class="btn-grp">
		<button class="btn btn-primary pull-right" type="submit" form="datatableForm" formaction="<c:url value="/invoice/deleteInvoice" />"> Delete</button>
		<button class="btn btn-primary pull-right" type="submit" form="datatableForm" formaction="<c:url value="/payment/createPayInvoice" />"><i class="fa fa-user-plus"></i> Add Payment</button>
	</div>
</div>