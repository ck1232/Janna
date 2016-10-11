<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form id="createRoleForm" method="get" action="/JJ/createRole"></form:form>
<form:form id="updateRoleForm" method="post" action="/JJ/updateRole"></form:form>

<div class="margin">
	<div class="btn-grp">
		<button class="btn btn-info btn-edit pull-right" type="submit" form="datatableForm" formaction="/JJ/deleteRole"><i class="fa fa-user-times"></i> Delete Role</button>
		<button class="btn btn-info btn-edit pull-right" type="submit" form="createRoleForm"><i class="fa fa-user-plus"></i> Add Role</button>
	</div>
</div>