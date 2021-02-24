<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="ApiURL" value="/api-admin-new" />
<c:url var ="NewURL" value="/admin-new"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa bài viết</title>
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
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								Chủ</a></li>
						<c:if test="${not empty model.id}">
							<small> <i class="ace-icon fa fa-angle-double-right"></i>
								Chỉnh sửa bài viết
							</small>
						</c:if>
						<c:if test="${empty model.id}">
							<small> <i class="ace-icon fa fa-angle-double-right"></i>
								Thêm mới bài viết
							</small>
						</c:if>

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
										<c:if test="${not empty model.id}">
											<strong>CHỈNH SỬA BÀI VIẾT</strong>
										</c:if>
										<c:if test="${empty model.id}">
											<strong>THÊM MỚI BÀI VIẾT</strong>
										</c:if>

									</h5>
								</div>

							</div>
							<!-- /.page-header -->
							<div class="form-group">
								<label>Thể loại</label> <select class="form-control"
									id="categoryCode" name="categoryCode">
									<c:if test="${empty model.categoryCode}">
										<option>Chọn loại bài viết</option>
										<c:forEach var="item" items="${categories}">
											<option value="${item.code}">${item.name}</option>
										</c:forEach>
									</c:if>
									<c:if test="${not empty model.categoryCode}">
										<c:forEach var="item" items="${categories}">
											<c:if test="${model.categoryCode == item.code}">
												<option value="${item.code}" selected="selected">${item.name}</option>
											</c:if>
											<c:if test="${model.categoryCode != item.code}">
												<option value="${item.code}">${item.name}</option>
											</c:if>
										</c:forEach>

									</c:if>
								</select>
							</div>
							<div class="form-group">
								<label>Tên bài viết</label> <input type="text"
									class="form-control" id="title" name="title"
									value="${model.title}">
							</div>
							<div class="form-group">
								<label>Mô tả ngắn</label> <input type="text"
									class="form-control" id="shortDescription"
									name="shortDescription" value="${model.shortDescription}">
							</div>
							<div class="form-group">
								<label>Hình ảnh</label> <input type="text" class="form-control"
									id="thumbnail" name="thumbnail">
							</div>
							<div class="form-group">
								<label>Nội dung</label>
								<textarea class="form-control" rows="5" id="content">${model.content}</textarea>
							</div>
							<c:if test="${not empty model.id}">
								<input type="button" class="btn btn-danger btn-bold"
									value="Sửa bài viết" id="btnAddOrEditNew" />
							</c:if>
							<c:if test="${empty model.id}">
								<input type="button" class="btn btn-danger btn-bold"
									value="Thêm bài viết" id="btnAddOrEditNew" />
							</c:if>
							<input type="hidden" value="${model.id }" id="id" name="id" />
						</div>
					</div>

				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</form>
	</div>
	<script>
		var editor = '';
		//public static void main
		$(document).ready(function() {
			editor = CKEDITOR.replace('content');
		});
		$("#btnAddOrEditNew").click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(index, value) {
				data["" + value.name + ""] = value.value;
			})
			data["content"] = editor.getData();
			var id = $('#id').val();
			if (id == "") {
				addNew(data);
			} else {
				updateNew(data);
			}
		});
		function addNew(data) {
			$.ajax({
				url : '${ApiURL}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success: function (result) {
	            	window.location.href = "${NewURL}?type=list&maxPageItem=5&page=1&message=insert_success";
	            },
	            error: function (error) {
	            	window.location.href = "${NewURL}?type=list&maxPageItem=5&page=1&message=error_system";
	            }
			});
		}
		function updateNew(data) {
			$.ajax({
				url : '${ApiURL}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				 success: function (result) {
		            	window.location.href = "${NewURL}?type=list&maxPageItem=5&page=1&message=update_success";
		            },
		            error: function (error) {
		            	window.location.href = "${NewURL}?type=list&maxPageItem=5&page=1&message=error_system";
		            }
			});
		}
	</script>
</body>
</html>