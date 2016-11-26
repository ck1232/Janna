<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
$(function () {
	
    
    $('#datatable1').DataTable({
      "paging": true,
      "responsive" : true,
      "lengthChange": false,
      "searching": true,
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
          $(row).find('input[type="checkbox"]').prop('value', data.customerid);
          $(row).find('button[name="updateBtn"]').prop('value', data.customerid);
       }
    });
});

function addOption(){
	$("#productModal").show();
}
</script>
