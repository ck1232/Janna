<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="editOptionForm" method="post" action="<c:url value="/admin/updateUser" />">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<script>
	function addOption(){

	}
</script>
<div class="margin">
	<div class="btn-grp">
		<button class="btn btn-primary pull-right" type="submit" form="datatableForm" formaction="<c:url value="/admin/deleteUser" />"><i class="fa fa-user-times"></i> Delete Option</button>
		<button class="btn btn-primary pull-right" type="button" onclick="addOption"><i class="fa fa-user-plus"></i> Add Option</button>
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
						
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<label class="col-sm-3 control-label">Sequence</label>
						<div class="col-sm-9">
							<input id="seqno" name="seqno" type="text" class="form-control"  />
						</div>
					  </div>
				</div>
			</div>
			</form>
			<div class="modal-footer">
				<button id="saveTypeSeqBtn" class="btn btn-primary" type="button" data-dismiss="modal" onclick="$('#updatePermissionTypeSeqToDbForm').submit();">Save changes</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->