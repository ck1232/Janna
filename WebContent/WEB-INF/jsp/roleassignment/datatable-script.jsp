<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
$(function () {
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
          $(row).find('input[type="checkbox"]').prop('value', data.roleid);
          if(data.checked == "Y"){
          	$(row).find('input[type="checkbox"]').prop('checked', true);
          }else{
        	  $(row).find('input[type="checkbox"]').prop('checked', false);
          }
          $(row).find('button[name="editBtn"]').prop('value', data.roleid);
          $(row).find('button[name="viewBtn"]').prop('value', data.roleid);
          $(row).find('button[name="saveRoleBtn"]').prop('value', data.checkboxId);
          
       }
    });
});
</script>
