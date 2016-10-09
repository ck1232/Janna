<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form id="createUserForm" method="get" modelAttribute="userForm" action="/JJ/createUser"></form:form>

<div class="margin">
	<div class="btn-grp">
		<button class="btn btn-default btn-primary pull-right" type="button"><i class="fa fa-user-times"></i> Delete User</button>
		<button class="btn btn-default btn-primary pull-right" type="submit" form="createUserForm"><i class="fa fa-user-plus"></i> Add User</button>
	</div>
</div>