<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>  
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title><tiles:insertAttribute name="title" ignore="true" /></title>  
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>        
        <script type="text/javascript" src="<c:url value="/development/x-tag-core.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/development/primeui-3.0.0-min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/development/primeelements-3.0.0.js"/>"></script>

        <link type="text/css" href="<c:url value="/development/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet"/>        
        <link type="text/css" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet" />
        <link type="text/css" href="<c:url value="/development/primeui-3.0.0-min.css" />" rel="stylesheet" >
		<link type="text/css" href="<c:url value="/development/themes/cruze/theme.css" />" rel="stylesheet" >
		
			<!-- Admin LTE -->
			<!-- Tell the browser to be responsive to screen width -->
		  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		  <!-- Bootstrap 3.3.6 -->
		  <link rel="stylesheet" href="<c:url value="/development/bootstrap/css/bootstrap.min.css"/>">
		  <!-- Font Awesome -->
		  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
		  <!-- Ionicons -->
		  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
		  <!-- Theme style -->
		  <link rel="stylesheet" href="<c:url value="/development/dist/css/AdminLTE.min.css"/>">
		  <!-- AdminLTE Skins. Choose a skin from the css/skins
		       folder instead of downloading all of them to reduce the load. -->
		  <link rel="stylesheet" href="<c:url value="/development/dist/css/skins/_all-skins.min.css"/>">
		  <!-- iCheck -->
		  <link rel="stylesheet" href="<c:url value="/development/plugins/iCheck/flat/blue.css"/>">
		  <!-- Morris chart -->
		  <link rel="stylesheet" href="<c:url value="/development/plugins/morris/morris.css"/>">
		  <!-- jvectormap -->
		  <link rel="stylesheet" href="<c:url value="/development/plugins/jvectormap/jquery-jvectormap-1.2.2.css"/>">
		  <!-- Date Picker -->
		  <link rel="stylesheet" href="<c:url value="/development/plugins/datepicker/datepicker3.css"/>">
		  <!-- Daterange picker -->
		  <link rel="stylesheet" href="<c:url value="/development/plugins/daterangepicker/daterangepicker.css"/>">
		  <!-- bootstrap wysihtml5 - text editor -->
		  <link rel="stylesheet" href="<c:url value="/development/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"/>">
		  <!-- datatable -->
		  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
		  
		  <link rel="stylesheet" href="<c:url value="/development/css/custom.css"/>">
		  <!-- REQUIRED JS SCRIPTS -->

		<!-- REQUIRED JS SCRIPTS -->
		
		<!-- jQuery 2.2.3 -->
		<script src="<c:url value="/development/plugins/jQuery/jquery-2.2.3.min.js"/>"></script>
		<!-- Bootstrap 3.3.6 -->
		<script src="<c:url value="/development/bootstrap/js/bootstrap.min.js"/>"></script>
		<!-- AdminLTE App -->
		<script src="<c:url value="/development/dist/js/app.min.js"/>"></script>
		<!-- Bootstrap select -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/bootstrap-select.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/i18n/defaults-*.min.js"></script>
		<script>
		$(function (){
			try{
				setNavigation();
			}catch(e){}
		})
		</script>
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