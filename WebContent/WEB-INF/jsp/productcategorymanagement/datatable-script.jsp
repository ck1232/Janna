<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
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
          
          if(data.isparent == false){
         	$(row).find('button[name="manageSubCategoryBtn"]').prop('style', 'display:none');
          }else{
        	  $(row).find('button[name="manageSubCategoryBtn"]').prop('value', data.id);
          }
          
       }
    });
});

</script>
