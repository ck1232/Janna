<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>User Listing</h1>
		<ol class="breadcrumb">
			<li><a href="/JJ/dashboard.html"><i class="fa fa-dashboard"> Home</i></a></li>
			<li><a href="/JJ/listUser.html">User Listing</a></li>
		</ol>
	</section>
	
	<div class="pad margin no-print">
      <div class="callout callout-info" style="margin-bottom: 0!important;">
        <h4><i class="fa fa-info"></i> Note:</h4>
        This page is under development. For viewing user listing.
      </div>
    </div>
    
    <section class="content">
    	<tiles:insertAttribute name = "datatable" />
    </section>
</div>