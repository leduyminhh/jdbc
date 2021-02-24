<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="ApiURL" value="/api-admin-new" />
<c:url var="NewURL" value="/admin-new" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
	<div class="main-content">
		<form method="GET" id="formSubmit"
			action="<c:url value='/admin-new'></c:url>">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href='<c:url value='/admin'/>'>Trang
								Chủ</a></li>
						<small> <i class="ace-icon fa fa-angle-double-right"></i>
							Danh sách bài viết
						</small>
					</ul>
					<!-- /.breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-lg-12">
							<div class="page-header">
								<div class="col-6 text-danger">
									<h5>
										<strong>DANH SÁCH BÀI VIẾT</strong>
									</h5>
								</div>

							</div>
							<!-- /.page-header -->
							<div class="col-lg-12">
								<div class="row">
									<div class="col-6 text-right">
										<a href='<c:url value="/admin-new?type=edit"/>'
											class="btn btn-sm btn-success" title="Thêm mới"><i
											class="fas fa-plus"></i> </a>
										<button id="btnDelete" class="btn btn-sm btn-danger"
											title="Xóa">
											<span> <i class="fas fa-trash-alt"></i></span>
										</button>
									</div>
								</div>
							</div>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th><input type="checkbox" value="" id="checkAll"></th>
										<th scope="col">Tên Bài Viết</th>
										<th scope="col">Mô Tả Ngắn</th>
										<th scope="col">Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${model.lst}">
										<tr>
											<td><input type="checkbox" value="${item.id}" id="checkBox_${item.id}"></td>
											<td>${item.title}</td>
											<td>${item.shortDescription}</td>
											<td><a title="Chỉnh sửa bài viết" href="<c:url value='/admin-new?id=${item.id}&type=edit'></c:url>"><i
													class="far fa-edit fa-2x"></i></a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
							<div class="center">
								<nav aria-label="Page navigation">
									<ul class="pagination" id="pagination"></ul>
								</nav>
							</div>
						</div>
						<input type="hidden" id="page" value="" name="page"> <input
							type="hidden" id="maxPageItem" value="" name="maxPageItem">
						<input type="hidden" id="sortName" value="" name="sortName">
						<input type="hidden" id="sortBy" value="" name="sortBy"> <input
							type="hidden" id="type" value="" name="type">
					</div>

				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</form>
	</div>

	<!-- pagination -->
	<script type="text/javascript">
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 5;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						//goi submit form
						$('#page').val(page); //gan page vao input id = page
						$('#maxPageItem').val(limit);
						$('#sortName').val('title');
						$('#sortBy').val('asc');
						$('#type').val('list');

						$('#formSubmit').submit();
					}
				}
			});
		});
		
		$("#btnDelete").click(function() {
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function () {
	            return $(this).val();
	        }).get();
			data['ids'] = ids;
			deleteNew(data);
		});
		
		function deleteNew(data) {
	        $.ajax({
	            url: '${ApiURL}',
	            type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function (result) {
	                window.location.href = '${NewURL}?type=list&maxPageItem=5&page=1&message=delete_success';
	            },
	            error: function (error) {
	            	window.location.href = '${NewURL}?type=list&maxPageItem=5&page=1&message=error_system';
	            }
	        });
	    }
	</script>

</body>
</html>