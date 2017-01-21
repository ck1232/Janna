<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="box box-default">
	<div class="box-header with-border">
	  <h3 class="box-title">Filter</h3>
	  
	  <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
      </div>
	</div>
	
	<div class="box-body">
	    <div class="row">
	      <div class="col-md-6">
	      	 <div class="form-group">
                <label>Minimal</label>
                <select class="form-control select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1" aria-hidden="true">
                  <option selected="selected">Alabama</option>
                  <option>Alaska</option>
                  <option>California</option>
                  <option>Delaware</option>
                  <option>Tennessee</option>
                  <option>Texas</option>
                  <option>Washington</option>
                </select>
              </div>
	      </div>
	      <div class="col-md-6">
	      	<div class="form-group">
                <label>Disabled</label>
                <select class="form-control select2 select2-hidden-accessible" disabled="" style="width: 100%;" tabindex="-1" aria-hidden="true">
                  <option selected="selected">Alabama</option>
                  <option>Alaska</option>
                  <option>California</option>
                  <option>Delaware</option>
                  <option>Tennessee</option>
                  <option>Texas</option>
                  <option>Washington</option>
                </select>
              </div>
	      </div>
	    </div>
    </div>
</div>