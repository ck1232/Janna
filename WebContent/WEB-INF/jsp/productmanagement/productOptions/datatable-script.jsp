<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
var optionTable= null;

$(function () {
	
    optionTable = $('#datatable1').DataTable({
    	"rowReorder": true,
      "paging": true,
      "responsive" : true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "order": [1, 'asc'],
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
      
      
      'rowCallback': function(row, data, dataIndex){
          // Get row ID
          $(row).find('input[type="checkbox"]').prop('value', data.optionName);
          $(row).find('button[name="editBtn"]').prop('value', data.optionName);
       }
    });
    
    $('#datatable1').on( 'row-reorder', function ( e, diff, edit ) {
        var seqArray = [];
        for ( var i=0, ien=diff.length ; i<ien ; i++ ) {
            var rowData = table.row( diff[i].node ).data();
 			var seq = {
 				optionName : rowData[1],
 				sequence : diff[i].newData
 		 			};
 			seqArray.push(seq);
        }

        var sortAjax = $.ajax({
    		  type: "POST",
    		  url: "sortOption",
    		  data: JSON.stringify(seqArray),
    		  contentType:"application/json; charset=utf-8",
  		  beforeSend: function( xhr ) {
  			  xhr.setRequestHeader(header, token);

  			}
    		}).done(function() {});
    });

});
</script>
