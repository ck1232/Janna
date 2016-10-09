<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%> 

<!DOCTYPE HTML>  
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title><tiles:insertAttribute name="title" ignore="true" /></title>  
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>        
        <script type="text/javascript" src="development/x-tag-core.min.js"></script>
        <script type="text/javascript" src="development/primeui-3.0.0-min.js"></script>
        <script type="text/javascript" src="development/primeelements-3.0.0.js"></script>

        <link type="text/css" href="development/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>        
        <link type="text/css" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet">
        <link type="text/css" href="development/primeui-3.0.0-min.css" rel="stylesheet">
		<link type="text/css" href="development/themes/cruze/theme.css" rel="stylesheet"/>
		
			<!-- Admin LTE -->
			<!-- Tell the browser to be responsive to screen width -->
		  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		  <!-- Bootstrap 3.3.6 -->
		  <link rel="stylesheet" href="development/bootstrap/css/bootstrap.min.css">
		  <!-- Font Awesome -->
		  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
		  <!-- Ionicons -->
		  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
		  <!-- Theme style -->
		  <link rel="stylesheet" href="development/dist/css/AdminLTE.min.css">
		  <!-- AdminLTE Skins. Choose a skin from the css/skins
		       folder instead of downloading all of them to reduce the load. -->
		  <link rel="stylesheet" href="development/dist/css/skins/_all-skins.min.css">
		  <!-- iCheck -->
		  <link rel="stylesheet" href="development/plugins/iCheck/flat/blue.css">
		  <!-- Morris chart -->
		  <link rel="stylesheet" href="development/plugins/morris/morris.css">
		  <!-- jvectormap -->
		  <link rel="stylesheet" href="development/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
		  <!-- Date Picker -->
		  <link rel="stylesheet" href="development/plugins/datepicker/datepicker3.css">
		  <!-- Daterange picker -->
		  <link rel="stylesheet" href="development/plugins/daterangepicker/daterangepicker.css">
		  <!-- bootstrap wysihtml5 - text editor -->
		  <link rel="stylesheet" href="development/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
		  
		  <!-- REQUIRED JS SCRIPTS -->

		<!-- REQUIRED JS SCRIPTS -->
		
		<!-- jQuery 2.2.3 -->
		<script src="development/plugins/jQuery/jquery-2.2.3.min.js"></script>
		<!-- Bootstrap 3.3.6 -->
		<script src="development/bootstrap/js/bootstrap.min.js"></script>
		<!-- AdminLTE App -->
		<script src="development/dist/js/app.min.js"></script>
</head>  
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
	<tiles:insertAttribute name="header" /> 
	<tiles:insertAttribute name="menu" /> 
	<tiles:insertAttribute name="body" />  
	<tiles:insertAttribute name="footer" />  
</div>
</body>  
</html> 