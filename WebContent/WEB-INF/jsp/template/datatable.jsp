<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!-- DataTables -->
<script type="text/javascript" src="development/plugins/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="development/plugins/datatables/dataTables.bootstrap.min.js"></script>

<!-- common -->
<tiles:insertAttribute name="datatable-script"/>

<div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">All Users</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="datatable1" class="table table-bordered table-hover">
                <thead>
                	<tiles:insertAttribute name="column-header" />
                </thead>
               
                <tfoot>
                <tr>
                  <tiles:insertAttribute name="column-header" />
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
          </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->