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
							<img id="zoom1"
								src="${ImagesDAO.getByProductId(product.id).img}"
								data-zoom-image="${ImagesDAO.getByProductId(product.id).img}" alt="big-1">
						</div>

						<div class="single-zoom-thumb">
							<ul class="s-tab-zoom owl-carousel single-product-active"
								id="gallery_01">
								<c:forEach items="${ImagesDAO.getAllByProductId(product.id)}" var="img">
								<li><a href="#" class="elevatezoom-gallery active"
									data-update="" data-image="${img.img}"
									data-zoom-image="${img.img}"> <img
										src="${img.img}" alt="zo-th-1" />
								</a></li>
								</c:forEach>
								
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-7 col-md-7">
					<div class="product_d_right">
						<form action="#">

							<h1 style="margin-bottom: 0px;">${product.name}</h1>
							<div class=" product_ratting" style="margin-bottom:5px;">
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
									name="produc_color">
									<option selected value="1">size</option>
									<c:forEach items="${sizeDAO.getSizeByProductId(product.id)}" var="size">
									<option value="${size.size}">${size.size}</option>
									</c:forEach>
								</select>
							</div>
							<div class="product_variant quantity">
								<label>quantity</label> <input min="1" max="100" value="1"
									type="number">
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
					<c:forEach var="product_cate" items="${productDAO.getProductByCategory(product.id)}">
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="${ImagesDAO.getByProductId(product.category_id).img}" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>
													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>
												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>

									<div class="product_sale">
										<span>-${product_cate.promotion}%</span>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">${product_cate.promotion}</a>
									</h3>
									<span class="current_price"></span> <span
										class="old_price">Â£86.00</span>
								</div>
							</div>
						</div>
					</c:forEach>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product27.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product28.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">Koss KPH7 Portable</a>
									</h3>
									<span class="current_price">Â£60.00</span>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product6.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product5.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>

								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">Beats Solo2 Solo 2</a>
									</h3>
									<span class="current_price">Â£60.00</span>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product7.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product8.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>

									<div class="product_sale">
										<span>-7%</span>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">Beats EP Wired</a>
									</h3>
									<span class="current_price">Â£60.00</span> <span
										class="old_price">Â£86.00</span>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product24.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product25.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">Bose SoundLink Bluetooth</a>
									</h3>
									<span class="current_price">Â£60.00</span>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product10.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product11.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>

									<div class="product_sale">
										<span>-7%</span>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">Apple iPhone SE 16GB</a>
									</h3>
									<span class="current_price">Â£60.00</span> <span
										class="old_price">Â£86.00</span>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product23.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product24.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">JBL Flip 3 Portable</a>
									</h3>
									<span class="current_price">Â£60.00</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>
	<!--product section area end-->

	<!--product section area start-->
	<section class="product_section upsell_product">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section_title">
						<h2>Upsell Products</h2>
						<p>Contemporary, minimal and modern designs embody the Lavish
							Alice handwriting</p>
					</div>
				</div>
			</div>
			<div class="product_area">
				<div class="row">
					<div class="product_carousel product_three_column4 owl-carousel">
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product15.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product16.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>

									<div class="product_sale">
										<span>-7%</span>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">Marshall Portable Bluetooth</a>
									</h3>
									<span class="current_price">Â£60.00</span> <span
										class="old_price">Â£86.00</span>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product17.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product18.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">Koss KPH7 Portable</a>
									</h3>
									<span class="current_price">Â£60.00</span>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product19.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product20.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>

								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">Beats Solo2 Solo 2</a>
									</h3>
									<span class="current_price">Â£60.00</span>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product7.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product8.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>

									<div class="product_sale">
										<span>-7%</span>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">Beats EP Wired</a>
									</h3>
									<span class="current_price">Â£60.00</span> <span
										class="old_price">Â£86.00</span>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product24.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product25.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">Bose SoundLink Bluetooth</a>
									</h3>
									<span class="current_price">Â£60.00</span>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product10.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product11.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>

									<div class="product_sale">
										<span>-7%</span>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">Apple iPhone SE 16GB</a>
									</h3>
									<span class="current_price">Â£60.00</span> <span
										class="old_price">Â£86.00</span>
								</div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
									<a class="primary_img" href="product-details.jsp"><img
										src="assets/img/product/product23.jpg" alt=""></a> <a
										class="secondary_img" href="product-details.jsp"><img
										src="assets/img/product/product24.jpg" alt=""></a>
									<div class="product_action">
										<div class="hover_action">
											<a href="#"><i class="fa fa-plus"></i></a>
											<div class="action_button">
												<ul>

													<li><a title="add to cart" href="cart.jsp"><i
															class="fa fa-shopping-basket" aria-hidden="true"></i></a></li>
													<li><a href="wishlist.jsp" title="Add to Wishlist"><i
															class="fa fa-heart-o" aria-hidden="true"></i></a></li>

													<li><a href="compare.jsp" title="Add to Compare"><i
															class="fa fa-sliders" aria-hidden="true"></i></a></li>

												</ul>
											</div>
										</div>

									</div>
									<div class="quick_button">
										<a href="#" data-toggle="modal" data-target="#modal_box"
											title="quick_view">+ quick view</a>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">JBL Flip 3 Portable</a>
									</h3>
									<span class="current_price">Â£60.00</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>
	<!--product section area end-->

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



</body>

</html>
