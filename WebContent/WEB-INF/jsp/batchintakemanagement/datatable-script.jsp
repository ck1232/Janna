<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
$(function () {
	
    
    table = $('#datatable1').DataTable({
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
          $(row).find('input[type="checkbox"]').prop('value', data.batchid);
          $(row).find('button[name="editBtn"]').prop('value', data.batchid);
       }
    });

    initTableSearch();


    $('#saveAddressBtn').on('click', function() {
       	$('#saveAddressBtn').submit();
    });
});

function editAddress(data) {
	alert("in");
	alert(data.id);
	$('#addressid').prop('value', data.id);
	$("#recipientname").prop('value', data.recipientname);
	$("#address").prop('value', data.address);
	$("#postalcode").prop('value', data.postalcode);
	$("#contactnumber").prop('value', data.contactnumber);
    $('#editModal').modal('show');

}
</script>
