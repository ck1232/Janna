<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
$(function(){
	$(window).keydown(function(event){
	    if(event.keyCode == 13 && $(event.target).is("input")) {
	      event.preventDefault();
	      return false;
	    }
	  });
	
	// instantiate the uploader
	var sortableList = $("#dZUpload");
	var uploadImageOrderList = [];

	function getSortOrder(){
		var listElements = $("#dZUpload").find(".dz-success img");
		uploadImageOrderList = [];

		for(var i=0;i<listElements.length;i++){
			var alt = $(listElements[i]).attr("alt");						
			uploadImageOrderList.push(alt);
		}
		return uploadImageOrderList; 
	}
	var sortEventHandler = function(event, ui){
		var uploadImageOrderList = getSortOrder();
		var orderAjax = $.ajax({
	  		  type: "POST",
	  		  url: "sortFile",
	  		  data: JSON.stringify(uploadImageOrderList),
	  		  contentType:"application/json; charset=utf-8",
			  beforeSend: function( xhr ) {
				  xhr.setRequestHeader(header, token);

				}
	  		}).done(function() {});
	};

	sortableList.sortable({
	    stop: sortEventHandler
	});

	// You can also set the event handler on an already existing Sortable widget this way:

	sortableList.on("sortchange", sortEventHandler);
	
  Dropzone.autoDiscover = false;
  
    var dz = $("#dZUpload").dropzone({
        url: "uploadFile",
        headers: {
            header: token
        },
        param:{header:token},
        addRemoveLinks: true,
        sending:function (file, xhr, formData){
        	xhr.setRequestHeader(header, token);
		},
        success: function (file, response) {
            var imgName = response;
            file.previewElement.classList.add("dz-success");
            //console.log("Successfully uploaded :" + imgName);
        },
        error: function (file, response) {
            file.previewElement.classList.add("dz-error");
        },
        removedfile: function (file) {
        	console.log(file.previewElement);
        	$(document).find(file.previewElement).remove();
        	var deleteAjax = $.ajax({
        		  type: "POST",
        		  url: "removeUploadFile",
        		  data: {fileName:file.name},
        		  dataType: 'json',
    			  beforeSend: function( xhr ) {
    				  xhr.setRequestHeader(header, token);
    				}
        		}).done(function() {
   				    //alert( "success" );
 				  	});
        		
	        	//console.log("success");	
			}
	      	
        
    });

	$(".dropzone").sortable({
          items:'.dz-preview',
          cursor: 'move',
          opacity: 0.5,
          containment: '.dropzone',
          distance: 20,
          tolerance: 'pointer'
      });
});
</script>


<div class="box box-default">
	<div class="box-header with-border">
	  <h3 class="box-title">Upload Invoice</h3>
	  
	  <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
      </div>
	</div>
	<c:url var="post_url" value="/invoice/uploadInvoice" />
	<form:form id = "uploadInvoiceForm" method = "post" modelAttribute = "invoiceForm" action="${post_url}">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<div class="box-body">
		    <div class="row">
		      <div class="col-md-12">
		      	 <div class="form-group">
	                <div id="image_tab" class="tab-pane">
				      	<div id="dZUpload" class="dropzone">
						      <div class="dz-default dz-message"></div>
						</div>
            		</div>
	              </div>
		      </div>
		    </div>
	    </div>
	</form:form>
    <div class="margin">
		<div class="btn-grp">
			<button class="btn btn-primary pull-right" type="submit" form="uploadInvoiceForm"><i class="fa fa-search"></i> Upload</button>
		</div>
	</div>
	<br>
	<br>
</div>