<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="editOptionForm" method="post" action="<c:url value="/admin/updateUser" />">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<script>
	var option = new Bloodhound({
	  datumTokenizer: Bloodhound.tokenizers.whitespace,
	  queryTokenizer: Bloodhound.tokenizers.whitespace,
	  prefetch: '<c:url context="/JJ" value="/product/product/getProductOptionName" />'
	});
	
	function addOption(){
		$("#optionModal").show();
	}

	function closeOption(){
		$("#optionModal").hide();
	}

	function saveOption(){
		var optionName = $("#name").val();
		var subOptionList = [];
		var subOptionDivList = $("#subOptionDiv").find("div.subOptionDiv");
		if(subOptionDivList != null && subOptionDivList.length > 0){
			for(var i=0; i< subOptionDivList.length;i++){
				var item = subOptionDivList.get(i);
				var displayInd = $(item).find(".display i").hasClass("fa-eye");
				var subOption = {
					subOptionName:$(item).find("label").text(),
					display:displayInd,
					seq:i+1
				}
				subOptionList.push(subOption);
			}
		}
		var data = {
			optionName : optionName,
			subOptionList : subOptionList
		}

		var saveAjax = $.ajax({
  		  type: "POST",
  		  url: "saveOption",
  		  data: JSON.stringify(data),
  		  contentType:"application/json; charset=utf-8",
		  beforeSend: function( xhr ) {
			  xhr.setRequestHeader(header, token);

			}
  		}).done(function() {
			    alert( "success" );
		});
	}
	function addNewSubOption(){
		var subOption = $.trim($("#subOptionInput").val());
		if(subOption != ""){
			$( "#subOptionDiv" ).append( '<div class="subOptionDiv" style="padding:0px 5%;"><label>'+ subOption +'</label><a class="pull-right icon" onclick="removeSubOption(this)">x</a><a class="pull-right icon display" onclick="toggleView(this);"><i class="fa fa-eye"></i></a></div>' );
			$("#subOptionInput").val("");
		}
	}
	function removeSubOption(suboption){
		$(suboption).closest("div").remove();
	}

	function toggleView(suboption){
		var icon = $(suboption).find("i");
		if(icon.hasClass("fa-eye")){
			icon.removeClass("fa-eye");
			icon.addClass("fa-eye-slash");
		}else{
			icon.addClass("fa-eye");
			icon.removeClass("fa-eye-slash");
		}
	}
	$(function(){
		$('#addOptionNameDiv .typeahead').typeahead(null, {
			  name: 'option',
			  source: option
		});

		$("#subOptionDiv").sortable({
	          items:'.subOptionDiv',
	          cursor: 'move',
	          opacity: 0.5,
	          containment: '#subOptionDiv',
	          distance: 20,
	          tolerance: 'pointer'
	      });
	});
	
</script>
<div class="margin">
	<div class="btn-grp">
		<button class="btn btn-primary pull-right" type="submit" form="datatableForm" formaction="<c:url value="/admin/deleteUser" />"><i class="fa fa-user-times"></i> Delete Option</button>
		<button class="btn btn-primary pull-right" type="button" onclick="addOption();"><i class="fa fa-user-plus"></i> Add Option</button>
	</div>
</div>

<div id="optionModal" class="modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title">Add Option</h3>
			</div>
			<form id="addOptionForm" method="post" action="<c:url value="/product/product/addOption" />">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="modal-body">
				<div class="row">
					<div class="form-group">
						<label class="col-sm-3 control-label">Name</label>
						<div class="col-sm-9" id="addOptionNameDiv">
							<input id="name" class="form-control typeahead col-sm-12" type="text" />
						</div>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="form-group">
							<label class="col-sm-3 control-label">Option</label>
							<div class="col-sm-6">
								<input id="subOptionInput" name="subOptionInput" type="text" class="form-control"  />
							</div>
							<div class="col-sm-3">
								<button id="add-new-option" type="button" onclick="addNewSubOption();" class="btn btn-primary btn-flat">Add</button>
							</div>
					 </div>
				</div>
				<div class="row" style="padding-top:15px;">
					<div class="col-sm-3"></div>
					<div class="box-body form-group col-sm-6 bg-gray" id="subOptionDiv">
				    </div>
				</div>
			</div>
			</form>
			<div class="modal-footer">
				<button id="saveOptionBtn" class="btn btn-primary" type="button" onclick="saveOption();">Save changes</button>
				<button type="button" onclick="closeOption();" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->