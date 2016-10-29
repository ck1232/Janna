<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
var selectedProductCategoryId = 0;
var selectedProductCategoryName = "";
$(function () {
	var table = $('#datatable1').DataTable({
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
          $(row).find('input[type="checkbox"]').prop('value', data.id);
          $(row).find('button[name="editBtn"]').prop('value', data.id);
       }
    });


    $('#datatable1 tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
 
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data())).show();
            subdatatable(selectedProductCategoryName);
            tr.addClass('shown');
        }
    } );
    
});


function format ( data ) {
    // `d` is the original data object for the row
    selectedProductCategoryId = data.id;
    selectedProductCategoryName = data.name.replace(" ","");
    return <tiles:insertAttribute name="subdatatable" />;
}

function subdatatable(datatableid){
	$('#subdatatable'+datatableid).DataTable({
	      "paging": false,
	      "responsive" : true,
	      "lengthChange": false,
	      "searching": false,
	      "ordering": true,
	      "info": false,
	      "autoWidth": false,
	      "ajax":{
	          "url":'<tiles:getAsString name="subdata-list" />',
	          "data":{
					<tiles:insertAttribute name="subdatatable-data" />
	            	}
	       },
		  "columns": [
		              <tiles:insertAttribute name="subcolumn-mapping" />
		            ],
	      "order": [1, 'asc'],
	      'rowCallback': function(row, data, dataIndex){
	          $(row).find('input[type="checkbox"]').prop('value', data.id);
	          if(data.checked == "Y"){
	          	$(row).find('input[type="checkbox"]').prop('checked', true);
	          }else{
	        	  $(row).find('input[type="checkbox"]').prop('checked', false);
	          }
	          
	       }
	    });
}


</script>
