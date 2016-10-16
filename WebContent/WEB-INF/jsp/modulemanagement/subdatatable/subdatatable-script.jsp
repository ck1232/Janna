<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
function subdatatable(){
	var subdatatable = $('#subdatatable').DataTable({
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
	      "order": [2, 'asc'],
	      'rowCallback': function(row, data, dataIndex){
	          $(row).find('input[type="checkbox"]').prop('value', data.id);
	          if(data.checked == "Y"){
	          	$(row).find('input[type="checkbox"]').prop('checked', true);
	          }else{
	        	  $(row).find('input[type="checkbox"]').prop('checked', false);
	          }
	          $(row).find('button[name="editBtn"]').prop('value', data.id);
	          $(row).find('button[name="viewBtn"]').prop('value', data.id);
	          $(row).find('div[name="iconDiv"]').html(data.icon+" <i class='fa "+data.icon+"'></i>");
	          
	       }
	    });
}

</script>
