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
      "ajax":{
          "url":'<tiles:getAsString name="data-list" />',
          "data":{
				<tiles:insertAttribute name="datatable-data" />
            	}
       },
	  "columns": [
	              <tiles:insertAttribute name="column-mapping" />
	            ],
      "order": [1, 'asc'],
      'rowCallback': function(row, data, dataIndex){
          // Get row ID
          var rowId = data[0];
          $(row).find('button[name="editBtn"]').prop('value', data.id);
          $(row).find('button[name="editTypeSeqBtn"]').click(function(){editPermissionTypeSeq(data)});
          $(row).find('input[type="checkbox"]').prop('value', data.id);
       }
    });

    $('#saveTypeSeqBtn').on('click', function() {
       	$('#saveTypeSeqBtn').submit();
    });
});

function editPermissionTypeSeq(data) {
	$('#permissionTypeid').prop('value', data.id);
	$('#permissionTypeDiv').html(data.permissiontype);
	$("#seqno").prop('value', data.seqno);
    $('#editModal').modal('show');

}

</script>
