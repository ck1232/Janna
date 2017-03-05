<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="createExpenseForm" method="get" action="<c:url value="/expense/createExpense" />"></form>

<div class="margin">
	<div class="btn-grp">
		<button class="btn btn-primary pull-right" type="submit" form="datatableForm" formaction="<c:url value="/invoice/deleteExpense" />"> Delete</button>
		<button class="btn btn-primary pull-right" type="submit" form="createExpenseForm"><i class="fa fa-user-plus"></i> Add</button>
	</div>
</div>