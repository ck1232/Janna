<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
var selectSubOptionIds = null;
$(function () {
	var rows_selected = [];
	table = $('#datatable1').DataTable({
      "paging": true,
      "pageLength": 10,
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
          $(row).find('input[type="checkbox"]').prop('value', data.productid);
          $(row).find('button[name="editBtn"]').prop('value', data.productid);
          $(row).find('button[name="viewBtn"]').prop('value', data.productid);
       }
    });

	initTableSearch();

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
            subdatatable(selectSubOptionIds);
            tr.addClass('shown');
        }
    } );
});

function format ( data ) {
    // `d` is the original data object for the row
    var s1 = data.suboption1id == null ? "0": data.suboption1id.toString();
    var s2 = data.suboption2id == null ? "0": data.suboption2id.toString();
    var s3 = data.suboption3id == null ? "0": data.suboption3id.toString();
    
    selectSubOptionIds =  s1 +"_"+ s2 +"_"+ s3;
    console.log(selectSubOptionIds);
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
	          
	       }
	    });
}
</script>
