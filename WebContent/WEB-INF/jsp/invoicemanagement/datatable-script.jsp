<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
$(function () {
	
	table = $('#datatable1').DataTable({
	  "dom": '<"top"<f><ip>>rt<"bottom"ip><"clear">',
      "paging": true,
      "pageLength": 30,
      "responsive" : true,
      "lengthChange": false,
      "searching": true,
      "ordering": true,
      "info": true,
      "autoWidth": true,
      "sScrollX": "100%",
      "sScrollXInner": "110%",
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
          var dataId = "";
          if(data.type == "invoice"){
        	  dataId = data.invoiceId+"-"+data.type;
          }else if(data.type = "grant"){
              dataId = data.grantId+"-"+data.type;
          }
          $(row).find('input[type="checkbox"]').prop('value', dataId);
          $(row).find('button[name="viewBtn"]').prop('value', dataId);
          if(data.status == "PAID"){
        	  $(row).find('div[name="payBtnDiv"]').css("display","none");
        	  $(row).find('div[name="statusDiv"]').css("display","none");
          }else{
        	  $(row).find('div[name="payBtnDiv"]').css("display","");
        	 $(row).find('div[name="statusDiv"]').css("display","");
        	 $(row).find('button[name="payBtn"]').prop('value', dataId);
          }
       }
    });

	initTableSearch();
});
</script>
