'<div class="row">'+
'<div class="col-xs-12">'+
'<div class="box">'+
'<div class="box-header">'+
'<form id="createSubModuleForm" method="post" action="/JJ/createSubmodule"><input type="hidden" value="'+data.id+'" name="moduleid"></form>'+
'<form id="updateSubModuleForm" method="post" action="/JJ/updateSubmodule"></form>'+

'<div class="margin">'+
	'<div class="btn-grp">'+
		'<button class="btn btn-primary pull-right" type="submit" form="datatableForm" formaction="/JJ/deleteSubModule"><i class="fa fa-user-times"></i> Delete Sub Module</button>'+
		'<button class="btn btn-primary pull-right" type="submit" form="createSubModuleForm"><i class="fa fa-user-plus"></i> Add Sub Module</button>'+
	'</div>'+
'</div>'+
'</div>'+
'<div class="box-body">'+
'<table id="subdatatable" class="table table-bordered table-hover">'+
'<thead>'+
'<tr>'+
 '<th></th>'+
  '<th>Name</th>'+
  '<th>Icon</th>'+
  '<th>Action</th>'+
'</tr>'+
'</thead>'+
'<tfoot>'+
'<tr>'+
'<tr>'+
 '<th></th>'+
  '<th>Name</th>'+
  '<th>Icon</th>'+
  '<th>Action</th>'+
'</tr>'+
'</tr>'+
'</tfoot>'+
'</table>'+
'</div>'+
'</div>'+
'</div>'+
'</div>'