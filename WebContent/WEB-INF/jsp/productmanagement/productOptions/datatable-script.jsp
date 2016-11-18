<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
var optionTable= null;
$(function () {
    optionTable = $('#datatable1').DataTable({
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
          $(row).find('input[type="checkbox"]').prop('value', data.optionName);
          $(row).find('button[name="editBtn"]').prop('value', data.optionName);
       }
    });
});
</script>
