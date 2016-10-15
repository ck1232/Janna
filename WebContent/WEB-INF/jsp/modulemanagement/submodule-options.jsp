<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form id="createModuleForm" method="get" action="/JJ/createModule"></form:form>
<form:form id="updateModuleForm" method="post" action="/JJ/updateModule"></form:form>
<form:form id="viewModuleForm" method="post" action="/JJ/viewModule"></form:form>

<div class="margin">
	<div class="btn-grp">
		<button class="btn btn-primary pull-right" type="submit" form="datatableForm" formaction="/JJ/deleteModule"><i class="fa fa-user-times"></i> Delete Sub Module</button>
		<button class="btn btn-primary pull-right" type="submit" form="createModuleForm"><i class="fa fa-user-plus"></i> Add Sub Module</button>
	</div>
</div>