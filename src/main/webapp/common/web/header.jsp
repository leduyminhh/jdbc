<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<c:if test="${not empty USERMODEL}">
					<div class="navbar-buttons navbar-header pull-right"
						role="navigation">
						<ul class="nav ace-nav">
							<li class="light-blue"><a data-toggle="dropdown" href="#"
								class="dropdown-toggle"> <img class="nav-user-photo"
									src="<c:url value='/template/admin/assets/avatars/user.jpg'/>"
									alt="Jason's Photo" /> <span class="user-info"> <small>Xin chào,</small>
										${USERMODEL.getFullName()}
								</span> <i class="ace-icon fa fa-caret-down"></i>
							</a>

								<ul
									class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
									<li><a href="#"> <i class="ace-icon fa fa-cog"></i>
											Settings
									</a></li>

									<li><a href="profile.html"> <i
											class="ace-icon fa fa-user"></i> Profile
									</a></li>

									<li class="divider"></li>

									<li><a href="<c:url value = '/dang-nhap?action=logout'/>"> <i class="ace-icon fa fa-power-off"></i>
											Đăng xuất
									</a></li>
								</ul></li>
						</ul>
					</div>
				</c:if>
				<c:if test="${empty USERMODEL}">
					<li class="nav-item active"><a class="nav-link"
						href="<c:url value = '/dang-nhap?action=login'/>">Đăng nhập</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="<c:url value = '/dang-nhap?action=register'/>">Đăng Ký</a></li>
				</c:if>

			</ul>
		</div>
	</div>
</nav>
