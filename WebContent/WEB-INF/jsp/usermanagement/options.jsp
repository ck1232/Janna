<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form id="createUserForm" method="get" action="/JJ/createUser"></form:form>
<form:form id="updateUserForm" method="post" action="/JJ/updateUser"></form:form>
<form:form id="viewUserForm" method="post" action="/JJ/viewUser"></form:form>

<div class="margin">
	<div class="btn-grp">
		<button class="btn btn-info btn-edit pull-right" type="submit" form="datatableForm" formaction="/JJ/deleteUser"><i class="fa fa-user-times"></i> Delete User</button>
		<button class="btn btn-info btn-edit pull-right" type="submit" form="createUserForm"><i class="fa fa-user-plus"></i> Add User</button>
	</div>
</div>