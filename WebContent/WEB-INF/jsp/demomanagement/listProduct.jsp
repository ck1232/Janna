<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- common -->
<tiles:insertAttribute name="script"/>
<div class="row">
	<div class="col-xs-12">
    	<div class="box">
            <div class="box-header">
              <h3 class="box-title"><tiles:insertAttribute name = "table-title" /></h3>
              <tiles:insertAttribute name = "options" />
            </div>
            <!-- /.box-header -->
            <div class="box-body">
            </div>
        </div>
    </div>
</div>