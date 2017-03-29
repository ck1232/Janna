<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(function () {
	var rows_selected = [];
	var selectedRoleId = 0;
    $('#datatable1').DataTable({
      "paging": true,
      "responsive" : true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "sScrollX": "100%",
      "sScrollXInner": "110%",
      "ajax":{
          "url":'<tiles:getAsString name="data-list" />',
          "data":{
				<tiles:insertAttribute name="datatable-data" />
            	}
       },
	  "columns": [
	              <tiles:insertAttribute name="column-mapping" />
	            ],
      "order": [0, 'asc'],
      'rowCallback': function(row, data, dataIndex){
          // Get row ID
          var rowId = data[0];
          $(row).find('button[name="editBtn"]').prop('value', data.roleid);
          $(row).find('button[name="editPermissionBtn"]').click(function(){editPermission(data)});
       }
    });

    $('#savePermissionBtn').on('click', function() {
       	$('#savePermissionForm').submit();
    });
});

function editPermission(data) {
	$('#roleid').prop('value', data.roleid);
	$('#rolenameDiv').html(data.rolename);
    $('#editModal').modal('show');
    var permissionArr = "";
    if(data.permissionId != null){
    	permissionArr = data.permissionId.split(",");
    }
    $('#submodulePermission').selectpicker('val', permissionArr);

}

</script>
