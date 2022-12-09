<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Shop category</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">


<!-- CSS 
    ========================= -->


<!-- Plugins CSS -->
<link rel="stylesheet" href="assets/css/plugins.css">

<!-- Main Style CSS -->
<link rel="stylesheet" href="assets/css/style.css">

</head>

<body>
	<!-- Header Section Begin-->
	<jsp:include page="header.jsp" />
	<!-- Header Section End -->

	<!--breadcrumbs area start-->
	<div class="breadcrumbs_area">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="breadcrumb_content">
						<ul>
							<li><a href="index.jsp">home</a></li>
							<li>/</li>
							<li>shop</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--breadcrumbs area end-->

	<!--shop  area start-->
	<div class="shop_area shop_reverse">
		<div class="container">
			<div class="shop_inner_area">
				<div class="row">
					<div class="col-lg-3 col-md-12">
						<!--sidebar widget start-->
						<div class="sidebar_widget">
							<div class="widget_list widget_filter"></div>
							<div class="widget_list widget_categories">
								<h2>Loại sản phẩm</h2>
								<ul>
									<c:forEach var="category" items="${categories}">
										<li><a
											href="./ShopFilterCategory?categoryId=${category.id}">${category.name}</a></li>
									</c:forEach>

								</ul>
							</div>
						</div>
						<!--sidebar widget end-->
					</div>
					<div class="col-lg-9 col-md-12">
						<!--shop wrapper start-->
						<!--shop toolbar start-->
						<div class="shop_title">
							<h1>shop</h1>
						</div>
						<div class="shop_toolbar_wrapper">
							<div class="shop_toolbar_btn">

								<button data-role="grid_3" type="button"
									class="active btn-grid-3" data-toggle="tooltip" title="3"></button>

								<button data-role="grid_4" type="button" class=" btn-grid-4"
									data-toggle="tooltip" title="4"></button>

								<button data-role="grid_5" type="button" class="btn-grid-5"
									data-toggle="tooltip" title="5"></button>

								<button data-role="grid_list" type="button" class="btn-list"
									data-toggle="tooltip" title="List"></button>
							</div>

							<select class="select_option" onchange="filterSort(this)" id="sort-option">
								<option selected value="1">Sắp xếp theo</option>
								<option value="2"">Sản phẩm bán chạy</option>
								<option value="3">Giảm dần</option>
								<option value="4">Tăng dần</option>
							</select>


						</div>
						<!--shop toolbar end-->

						<div class="row shop_wrapper" id="content-product">
							<c:forEach var="product" items="${products}">
								<div class="product col-lg-4 col-md-4 col-12 ">
									<div class="single_product">
										<div class="product_thumb">
											<a class="primary_img" href="product-details.jsp"><img
												src="${ImagesDAO.getByProductId(product.id).img}" alt=""></a>
											<div class="quick_button">
												<a href="./product-detail?id=${product.id}" title="quick_view">Xem sản
													phẩm</a>
											</div>
											<div class="double_base">
												<div class="product_sale">
													<c:if test="${product.promotion!=0}">
														<span>-${product.promotion}%</span>
													</c:if>
												</div>
											</div>
										</div>

										<div class="product_content grid_content">
											<h3>
												<a href="product-details.jsp">${product.name}</a>
											</h3>
											<span class="current_price">${product.price-product.price*product.promotion/100}VNĐ</span>
											<c:if test="${product.promotion!=0}">
												<span class="old_price">${product.price}VNĐ</span>
											</c:if>
										</div>

										<div class="product_content list_content">
											<h3>
												<a href="product-details.jsp">${product.name}</a>
											</h3>
											<div class="product_ratting">
												<ul>
													<li><a href="#"><i class="fa fa-star"></i></a></li>
													<li><a href="#"><i class="fa fa-star"></i></a></li>
													<li><a href="#"><i class="fa fa-star"></i></a></li>
													<li><a href="#"><i class="fa fa-star"></i></a></li>
													<li><a href="#"><i class="fa fa-star"></i></a></li>
												</ul>
											</div>
											<div class="product_price">
												<span class="current_price">${product.price-product.price*product.promotion/100}VNĐ</span>
												<span class="old_price">${product.price}</span>
											</div>
											<div class="product_desc">
												<p>${product.description}</p>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>


						</div>
						<div class="shop_toolbar t_bottom">
							<div class="pagination">
								<button onclick="loadMore()" class="btn-outline-primary"
									style="width: 350px; font-size: 20px; line-height: 24px;">Xem
									tiếp</button>
							</div>
						</div>
						<!--shop toolbar end-->
					</div>
				</div>


				<!--shop wrapper end-->
			</div>
		</div>
	</div>


	<!--shop  area end-->

	<!--footer area start-->
	<jsp:include page="footer.jsp" />
	<!--footer area start-->



	<!-- JS
============================================ -->

	<!-- Plugins JS -->
	<script src="assets/js/plugins.js"></script>

	<!-- Main JS -->
	<script src="assets/js/main.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

	<script>
		function filterSort(obj) {
			var option = obj.value;
			var x = location.href;
			var tmp = "";
			for (let i =x.length; i>0;i--){
				if(x[i]=="/")
				{
					tmp = x.slice(i, x.length);
					break;
				}
			}
			var url = "./shop-sort";
			if(tmp!="/shop")
				url = url+tmp;
			console.log(url);
			if (option != 1) {
				$.ajax({
					url : url,
					type : "get",
					data : {
						exits : option
					},
					success : function(data) {
						var row = document.getElementById("content-product");
						row.innerHTML = data;
					},
					error : function(xhr) {
					}
				});
			}
		}
		
		function loadMore() {
			var amount = document.getElementsByClassName("product").length;
			var option = document.getElementById("sort-option").value;
			var x = location.href;
			var tmp = "";
			for (let i =x.length; i>0;i--){
				if(x[i]=="/")
				{
					tmp = x.slice(i, x.length);
					break;
				}
			}
			var url = "./shoploadMore";
			if(tmp!="/shop")
				url = url+tmp;

			$.ajax({
				url : url,
				type : "get",
				data : {
					exits : amount,
					option: option
				},
				success : function(data) {
					var row = document.getElementById("content-product");
					row.innerHTML += data;
				},
				error : function(xhr) {
				}
			});
		};
	</script>

</body>

</html>