<!DOCTYPE HTML>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>CERPSOFT</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="-1" />
	
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.png">
    <!-- Normalize CSS -->
    <link rel="stylesheet" href="static/css/normalize.css">
    <!-- Main CSS -->
    <link rel="stylesheet" href="static/css/main.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="static/css/all.min.css">
    <!-- Flaticon CSS -->
    <link rel="stylesheet" href="static/fonts/flaticon.css">
    <!-- Full Calender CSS -->
    <link rel="stylesheet" href="static/css/fullcalendar.min.css">
    <!-- Animate CSS -->
    <link rel="stylesheet" href="static/css/animate.min.css">
    <!-- Datepicker CSS -->
    <link rel="stylesheet" href="static/css/datepicker.min.css">
    <!-- Timepicker CSS -->
    <link rel="stylesheet" href="static/css/timepicker.css">
    <!-- Select 2 CSS -->
    <link rel="stylesheet" href="static/css/select2.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="static/css/style.css">
    <!-- Data Table CSS -->
    <link rel="stylesheet" href="static/css/jquery-ui.css">
    <link rel="stylesheet" href="static/css/dataTables.jqueryui.min.css">
    <link rel="stylesheet" href="static/css/select2-bootstrap.min.css" />
    <link rel="stylesheet" href="static/datatable/css/jquery.dataTables.min.css" />
    <link rel="stylesheet" href="static/datatable/css/buttons.dataTables.min.css" />
    
    <!-- Modernize js -->
    <script src="static/js/modernizr-3.6.0.min.js"></script>
    <!-- jquery-->
    <script src="static/js/jquery-3.5.1.min.js"></script>
</head>

<body>
    <div id="preloader"></div>
	<div id="wrapper" class="wrapper bg-ash">
		<tiles:insert attribute="header" />
		<div class="dashboard-page-one">
			<tiles:insert attribute="menu" />
			<div class="dashboard-content-one">
				<tiles:insert attribute="body" />
				<tiles:insert attribute="footer" />
			</div>
		</div>
	</div>
	
	<!-- Plugins js -->
    <script src="static/js/plugins.js"></script>
    <!-- Popper js -->
    <script src="static/js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="static/js/bootstrap.min.js"></script>
    <!-- Counterup Js -->
    <script src="static/js/jquery.counterup.min.js"></script>
    <!-- Moment Js -->
    <script src="static/js/moment.min.js"></script>
    <!-- Waypoints Js -->
    <script src="static/js/jquery.waypoints.min.js"></script>
    <!-- Scroll Up Js -->
    <script src="static/js/jquery.scrollUp.min.js"></script>
    <!-- Datepicker Js -->
    <script src="static/js/datepicker.min.js"></script>
    <!-- Timepicker Js -->
    <script src="static/js/bootstrap-timepicker.js"></script>
    <!-- Full Calender Js -->
    <script src="static/js/fullcalendar.min.js"></script>
    <!-- Chart Js -->
    <script src="static/js/Chart.min.js"></script>
    <!-- Data Table Js -->
    <script src="static/js/jquery-ui.js"></script>
    <script src="static/js/jquery.dataTables.min.js"></script>
    <script src="static/js/dataTables.jqueryui.min.js"></script>
    <!-- <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script> -->
    <script src="static/datatable/js/dataTables.buttons.min.js"></script>
    <script src="static/datatable/js/jszip.min.js"></script>
    <script src="static/datatable/js/pdfmake.min.js"></script>
    <script src="static/datatable/js/vfs_fonts.js"></script>
    <script src="static/datatable/js/buttons.html5.min.js"></script>
    <script src="static/datatable/js/buttons.print.min.js"></script>
    <script src="static/datatable/js/buttons.colVis.min.js"></script>
	<!-- Select 2 Js -->
    <script src="static/js/select2.min.js"></script>
    <!-- Menu Highlight Js -->
    <script src="views/js/highlight.js"></script>
    <!-- Custom Js -->
    <script src="static/js/main.js"></script>

</body>
	
</html>