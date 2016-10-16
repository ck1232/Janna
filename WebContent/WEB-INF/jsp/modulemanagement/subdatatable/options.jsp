<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

'<form id="createSubModuleForm" method="get" action="/JJ/createSubModule"></form>'+
'<form id="updateSubModuleForm" method="post" action="/JJ/updateSubModule"></form>'+

'<div class="margin">'+
	'<div class="btn-grp">'+
		'<button class="btn btn-primary pull-right" type="submit" form="subdatatableForm" formaction="/JJ/deleteModule"><i class="fa fa-user-times"></i> Delete Module</button>'+
		'<button class="btn btn-primary pull-right" type="submit" form="createSubModuleForm"><i class="fa fa-user-plus"></i> Add Module</button>'+
	'</div>'+
'</div>'+