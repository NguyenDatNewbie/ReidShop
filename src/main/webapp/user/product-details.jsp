<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Product details</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="./assets/img/favicon.ico">

<!-- CSS 
    ========================= -->


<!-- Plugins CSS -->
<link rel="stylesheet" href="./assets/css/plugins.css">

<!-- Main Style CSS -->
<link rel="stylesheet" href="./assets/css/style.css">

</head>

<body>
	<!-- Header Section Begin-->
	<jsp:include page="header.jsp" />
	<!-- Header Section End -->


	<!--breadcrumbs area start-->
	<div class="breadcrumbs_area product_bread">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="breadcrumb_content">
						<ul>
							<li><a href="index.jsp">home</a></li>
							<li>/</li>
							<li>product details</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--breadcrumbs area end-->

	<!--product details start-->
	<div class="product_details">
		<div class="container">
			<div class="row">
				<div class="col-lg-5 col-md-5">
					<div class="product-details-tab">
						<div id="img-1" class="zoomWrapper single-zoom">
							<img id="zoom1" src="${ImagesDAO.getByProductId(product.id).img}"
								data-zoom-image="${ImagesDAO.getByProductId(product.id).img}"
								alt="big-1">
						</div>

						<div class="single-zoom-thumb">
							<ul class="s-tab-zoom owl-carousel single-product-active"
								id="gallery_01">
								<c:forEach items="${ImagesDAO.getAllByProductId(product.id)}"
									var="img">
									<li><a href="#" class="elevatezoom-gallery active"
										data-update="" data-image="${img.img}"
										data-zoom-image="${img.img}"> <img src="${img.img}"
											alt="zo-th-1" />
									</a></li>
								</c:forEach>

							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-7 col-md-7">
					<div class="product_d_right">
						<form action="./addToCard?id=${product.id}" method="post">

							<h1 style="margin-bottom: 0px;">${product.name}</h1>
							<div class=" product_ratting" style="margin-bottom: 5px;">
								<ul>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
								</ul>
							</div>
							<div class="product_content">
								<span class="current_price">${product.price-product.price*product.promotion/100}VNĐ</span>
								<c:if test="${product.promotion!=0}">
									<span class="old_price">${product.price}VNĐ</span>
								</c:if>
							</div>
							<div class="product_desc">
								<p>${product.description}</p>
							</div>


							<div class="product_variant size">
								<h3>size</h3>
								<select class="niceselect_option" id="color1"
									name="product_size">
									<c:forEach items="${sizeDAO.getSizeByProductId(product.id)}"
										var="size">
										<option value="${size.size}">${size.size}</option>
									</c:forEach>
								</select>
							</div>
							<div class="product_variant quantity">
								<label>quantity</label> <input min="1" max="100" value="1"
									name="quantity" type="number">
								<button class="button" type="submit">add to cart</button>
							</div>
							<div class=" product_d_action">
								<ul>
									<li><a href="#" title="Add to wishlist"><i
											class="fa fa-heart-o" aria-hidden="true"></i> Add to Wish
											List</a></li>

								</ul>
							</div>

						</form>
						<div class="priduct_social">
							<h3>Share on:</h3>
							<ul>
								<li><a href="#"><i class="fa fa-rss"></i></a></li>
								<li><a href="#"><i class="fa fa-vimeo"></i></a></li>
								<li><a href="#"><i class="fa fa-tumblr"></i></a></li>
								<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
							</ul>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!--product details end-->



	<!--product section area start-->
	<section class="product_section related_product">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section_title">
						<h2>Sản phẩm liên quan</h2>
					</div>
				</div>
			</div>
			<div class="product_area">
				<div class="row">
					<div class="product_carousel product_three_column4 owl-carousel">
						<c:forEach var="product_cate"
							items="${productDAO.getProductByCategory(1,product.category_id)}">
							<div class="col-lg-3">
								<div class="single_product">
									<div class="product_thumb">
										<a class="primary_img"
											href="./product-detail?id=${product_cate.id}"><img
											src="${ImagesDAO.getByProductId(product_cate.id).img}" alt=""></a>
										
										<div class="quick_button">
											<a href="#" data-toggle="modal"
												data-target="#modal_box-${product_cate.id}"
												title="quick_view">+ Xem nhanh</a>
										</div>

										<div class="product_sale">
											<c:if test="${product_cate.promotion!=0}">
												<span>-${product_cate.promotion}%</span>
											</c:if>
										</div>
									</div>
									<div class="product_content">
										<h3>
											<a href="product-details.jsp">${product_cate.name}</a>
										</h3>
										<span class="current_price">${product_cate.price-product_cate.price*product_cate.promotion/100}VNĐ</span>
										<c:if test="${product_cate.promotion!=0}">
											<span class="old_price">${product_cate.price}</span>
										</c:if>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>

		</div>
	</section>
	<!--product section area end-->




	<!--footer area start-->
	<jsp:include page="footer.jsp" />
	<!--footer area start-->

	
	<jsp:include page="model_area.jsp"/>


	<!-- JS
============================================ -->

	<!-- Plugins JS -->
	<script src="./assets/js/plugins.js"></script>

	<!-- Main JS -->
	<script src="./assets/js/main.js"></script>



</body>

</html>
