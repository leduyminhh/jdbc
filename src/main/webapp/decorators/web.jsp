<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang Chủ" /></title>

<!-- Custom styles for this template -->
<link
	href="<c:url value = '/template/web/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value = '/template/web/css/style.css'/>"
	rel="stylesheet">
</head>
<body class="no-skin">
	<!-- Header -->
	<%@include file="/common/web/header.jsp"%>
	<!-- Header -->

	<div class="container">
		<dec:body />
	</div>

	<!-- Footer -->
	<%@include file="/common/web/footer.jsp"%>
	<!-- Footer -->
	<script src="<c:url value = '/template/web/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value = '/template/web/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

</body>
</html>