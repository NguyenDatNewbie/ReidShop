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
							<div class="widget_list widget_filter">
								<h2>Filter by price</h2>
								<form action="#">
									<div id="slider-range"></div>
									<button type="submit">Filter</button>
									<input type="text" name="text" id="amount" />

								</form>
							</div>
							<div class="widget_list widget_categories">
								<h2>Product categories</h2>
								<ul>
									<c:forEach var="category" items="${categories}">
										<li><a href="#">${category.name}</a></li>
									</c:forEach>


								</ul>
							</div>

							<div class="widget_list widget_categories">
								<h2>Manufacturer</h2>
								<ul>
									<li><a href="#">Calvin Klein <span>6</span></a></li>
									<li><a href="#"> Chanel <span>10</span></a></li>
									<li><a href="#">Christian Dior <span>4</span></a></li>
									<li><a href="#"> ferragamo <span>4</span></a></li>
									<li><a href="#">hermes <span>10</span></a></li>
									<li><a href="#">louis vuitton <span>8</span></a></li>
									<li><a href="#">Tommy Hilfiger <span>7</span></a></li>
									<li><a href="#">Versace <span>6</span></a></li>

								</ul>
							</div>
							<div class="widget_list widget_categories">
								<h2>Select By Color</h2>
								<ul>
									<li><a href="#">Black <span>6</span></a></li>
									<li><a href="#"> Blue <span>10</span></a></li>
									<li><a href="#">Brown <span>4</span></a></li>
									<li><a href="#"> Green <span>4</span></a></li>
									<li><a href="#">Pink <span>7</span></a></li>
									<li><a href="#">White<span>8</span></a></li>
									<li><a href="#">Yellow <span>5</span></a></li>

								</ul>
							</div>
							<div class="widget_list tag-cloud">
								<h2>Popular Tags</h2>
								<div class="tag_widget">
									<ul>
										<li><a href="#">Creams</a></li>
										<li><a href="#">Eyebrow Pencil</a></li>
										<li><a href="#">Eyeliner</a></li>
										<li><a href="#">Eye Shadow</a></li>
										<li><a href="#">Lotions</a></li>
										<li><a href="#">Mascara</a></li>
										<li><a href="#">Oils</a></li>
										<li><a href="#">Powders</a></li>
										<li><a href="#">Shampoos</a></li>
									</ul>
								</div>
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
							<div class=" niceselect_option">

								<form class="select_option" action="#">
									<select name="orderby" id="short">

										<option selected value="1">Sort by average rating</option>
										<option value="2">Sort by popularity</option>
										<option value="3">Sort by newness</option>
										<option value="4">Sort by price: low to high</option>
										<option value="5">Sort by price: high to low</option>
										<option value="6">Product Name: Z</option>
									</select>
								</form>


							</div>
							<div class="page_amount">
								<p>Showing 1â9 of 21 results</p>
							</div>
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
												<a href="product-details.jsp" title="quick_view">Xem sản
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
												<span class="old_price">${product.price}VNĐ</span>
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

	</div>
	</div>
	<!--shop  area end-->

	<!--footer area start-->
	<jsp:include page="footer.jsp" />
	<!--footer area start-->

	<!-- modal area start-->
	<div class="modal fade" id="modal_box" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="modal_body">
					<div class="container">
						<div class="row">
							<div class="col-lg-5 col-md-5 col-sm-12">
								<div class="modal_tab">
									<div class="tab-content product-details-large">
										<div class="tab-pane fade show active" id="tab1"
											role="tabpanel">
											<div class="modal_tab_img">
												<a href="#"><img src="assets/img/product/product4.jpg"
													alt=""></a>
											</div>
										</div>
										<div class="tab-pane fade" id="tab2" role="tabpanel">
											<div class="modal_tab_img">
												<a href="#"><img src="assets/img/product/product6.jpg"
													alt=""></a>
											</div>
										</div>
										<div class="tab-pane fade" id="tab3" role="tabpanel">
											<div class="modal_tab_img">
												<a href="#"><img src="assets/img/product/product8.jpg"
													alt=""></a>
											</div>
										</div>
										<div class="tab-pane fade" id="tab4" role="tabpanel">
											<div class="modal_tab_img">
												<a href="#"><img src="assets/img/product/product2.jpg"
													alt=""></a>
											</div>
										</div>
										<div class="tab-pane fade" id="tab5" role="tabpanel">
											<div class="modal_tab_img">
												<a href="#"><img src="assets/img/product/product12.jpg"
													alt=""></a>
											</div>
										</div>
									</div>
									<div class="modal_tab_button">
										<ul class="nav product_navactive owl-carousel" role="tablist">
											<li><a class="nav-link active" data-toggle="tab"
												href="#tab1" role="tab" aria-controls="tab1"
												aria-selected="false"><img
													src="assets/img/s-product/product3.jpg" alt=""></a></li>
											<li><a class="nav-link" data-toggle="tab" href="#tab2"
												role="tab" aria-controls="tab2" aria-selected="false"><img
													src="assets/img/s-product/product.jpg" alt=""></a></li>
											<li><a class="nav-link button_three" data-toggle="tab"
												href="#tab3" role="tab" aria-controls="tab3"
												aria-selected="false"><img
													src="assets/img/s-product/product2.jpg" alt=""></a></li>
											<li><a class="nav-link" data-toggle="tab" href="#tab4"
												role="tab" aria-controls="tab4" aria-selected="false"><img
													src="assets/img/s-product/product4.jpg" alt=""></a></li>
											<li><a class="nav-link" data-toggle="tab" href="#tab5"
												role="tab" aria-controls="tab5" aria-selected="false"><img
													src="assets/img/s-product/product5.jpg" alt=""></a></li>

										</ul>
									</div>
								</div>
							</div>
							<div class="col-lg-7 col-md-7 col-sm-12">
								<div class="modal_right">
									<div class="modal_title mb-10">
										<h2>Handbag feugiat</h2>
									</div>
									<div class="modal_price mb-10">
										<span class="new_price">$64.99</span> <span class="old_price">$78.99</span>
									</div>
									<div class="modal_description mb-15">
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit. Mollitia iste laborum ad impedit pariatur esse optio
											tempora sint ullam autem deleniti nam in quos qui nemo ipsum
											numquam, reiciendis maiores quidem aperiam, rerum vel
											recusandae</p>
									</div>
									<div class="variants_selects">
										<div class="variants_size">
											<h2>size</h2>
											<select class="select_option">
												<option selected value="1">s</option>
												<option value="1">m</option>
												<option value="1">l</option>
												<option value="1">xl</option>
												<option value="1">xxl</option>
											</select>
										</div>
										<div class="variants_color">
											<h2>color</h2>
											<select class="select_option">
												<option selected value="1">purple</option>
												<option value="1">violet</option>
												<option value="1">black</option>
												<option value="1">pink</option>
												<option value="1">orange</option>
											</select>
										</div>
										<div class="modal_add_to_cart">
											<form action="#">
												<input min="0" max="100" step="2" value="1" type="number">
												<button type="submit">add to cart</button>
											</form>
										</div>
									</div>
									<div class="modal_social">
										<h2>Share this product</h2>
										<ul>
											<li class="facebook"><a href="#"><i
													class="fa fa-facebook"></i></a></li>
											<li class="twitter"><a href="#"><i
													class="fa fa-twitter"></i></a></li>
											<li class="pinterest"><a href="#"><i
													class="fa fa-pinterest"></i></a></li>
											<li class="google-plus"><a href="#"><i
													class="fa fa-google-plus"></i></a></li>
											<li class="linkedin"><a href="#"><i
													class="fa fa-linkedin"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- modal area start-->


	<!-- JS
============================================ -->

	<!-- Plugins JS -->
	<script src="assets/js/plugins.js"></script>

	<!-- Main JS -->
	<script src="assets/js/main.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

	<script>
		function loadMore() {
			var amount = document.getElementsByClassName("product").length;
			$.ajax({
				url : "./shoploadMore",
				type : "get",
				data : {
					exits : amount
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