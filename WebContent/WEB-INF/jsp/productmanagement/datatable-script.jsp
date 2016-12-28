<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
$(function () {
    $('#datatable1').DataTable({
      "paging": true,
      "scrollY": 300,
      "scrollCollapse": true,
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
          // Get row ID
          var rowId = data[0];
          $(row).find('input[type="checkbox"]').prop('value', data.productid);
          $(row).find('button[name="editBtn"]').prop('value', data.productid);
          $(row).find('img[name="img"]').prop('src', "./getProductImage/"+data.productid);
       }
    });
});
</script>