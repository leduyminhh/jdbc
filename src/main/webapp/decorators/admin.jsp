<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang Chủ" /></title>
<link rel="stylesheet"
	href="<c:url value = '/template/admin/assets/css/bootstrap.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value = '/template/admin/assets/font-awesome/css/all.css'/>" />
<link rel="stylesheet"
	href="<c:url value = '/template/admin/assets/fonts/fonts.googleapis.com.css'/>" />
<link rel="stylesheet"
	href="<c:url value = '/template/admin/assets/css/ace.min.css' />" />
<script
	src="<c:url value = '/template/admin/assets/js/jquery.2.1.1.min.js'/>"></script>

<!-- ace settings handler -->
<script
	src="<c:url value = '/template/admin/assets/js/ace-extra.min.js' />"></script>

</head>
<body class="no-skin">

	<!-- Header -->
	<%@include file="/common/admin/header.jsp"%>
	<!-- Header -->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<!-- Menu -->
		<%@include file="/common/admin/menu.jsp"%>
		<!-- Menu -->

		<dec:body />

		<!-- Footer -->
		<%@include file="/common/admin/footer.jsp"%>
		<!-- Footer -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>


	<script
		src="<c:url value = '/template/admin/assets/js/bootstrap.min.js'/>"></script>
	<script
		src="<c:url value = '/template/admin/assets/js/jquery-ui.custom.min.js'/>"></script>
	<script
		src="<c:url value = '/template/admin/assets/js/jquery.ui.touch-punch.min.js'/>"></script>
	<script
		src="<c:url value = '/template/admin/assets/js/jquery.easypiechart.min.js'/>"></script>
	<script
		src="<c:url value = '/template/admin/assets/js/jquery.sparkline.min.js'/>"></script>
	<script
		src="<c:url value = '/template/admin/assets/js/jquery.flot.min.js'/>"></script>
	<script
		src="<c:url value = '/template/admin/assets/js/jquery.flot.pie.min.js'/>"></script>
	<script
		src="<c:url value = '/template/admin/assets/js/jquery.flot.resize.min.js'/>"></script>
	<script
		src="<c:url value = '/template/paging/jquery.twbsPagination.js'/>"></script>
	<script
		src="<c:url value = '/ckeditor/ckeditor.js'/>"></script>

	<!-- ace scripts -->
	<script
		src="<c:url value = '/template/admin/assets/js/ace-elements.min.js'/>"></script>
	<script src="<c:url value = '/template/admin/assets/js/ace.min.js'/>"></script>
	<!-- inline scripts related to this page -->


</body>

</body>
</html>