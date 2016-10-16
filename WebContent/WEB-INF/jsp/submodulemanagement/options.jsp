<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<form id="updateSubmoduleForm" method="post" action="/JJ/updateSubmodule"></form>
<div class="margin">
	<div class="btn-grp">
		<button class="btn btn-primary pull-right" type="submit" form="datatableForm" formaction="/JJ/deleteSubmodule"><i class="fa fa-user-times"></i> Delete</button>
		<button class="btn btn-primary pull-right" type="submit" form="datatableForm" formaction="/JJ/createSubmodule"><i class="fa fa-user-plus"></i> Add</button>
	</div>
</div>