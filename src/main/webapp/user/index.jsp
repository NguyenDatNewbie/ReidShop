<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Fashion eCommerce HTML Template</title>
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

	<!--slider area start-->
	<div class="slider_area slider_style home_three_slider owl-carousel">
		<div class="single_slider"
			data-bgimg="./assets/img/slider/slider4.jpg">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-12">
						<div class="slider_content content_one">
							<img src="./assets/img/slider/content3.png" alt="">
							<p>the wooboom clothing summer collection is back at half
								price</p>
							<a href="shop.jsp">Discover Now</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="single_slider"
			data-bgimg="./assets/img/slider/slider5.jpg">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-12">
						<div class="slider_content content_two">
							<img src="./assets/img/slider/content4.png" alt="">
							<p>the wooboom clothing summer collection is back at half
								price</p>
							<a href="shop.jsp">Discover Now</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="single_slider"
			data-bgimg="./assets/img/slider/slider6.jpg">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-12">
						<div class="slider_content content_three">
							<img src="./assets/img/slider/content5.png" alt="">
							<p>the wooboom clothing summer collection is back at half
								price</p>
							<a href="shop.jsp">Discover Now</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--slider area end-->

	<!--banner area start-->
	<div class="banner_section banner_section_three">
		<div class="container-fluid">
			<div class="row ">
				<div class="col-lg-4 col-md-6">
					<div class="banner_area">
						<div class="banner_thumb">
							<a href="shop.jsp"><img src="./assets/img/bg/banner8.jpg"
								alt="#"></a>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="banner_area">
						<div class="banner_thumb">
							<a href="shop.jsp"><img src="./assets/img/bg/banner9.jpg"
								alt="#"></a>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="banner_area bottom">
						<div class="banner_thumb">
							<a href="shop.jsp"><img src="./assets/img/bg/banner10.jpg"
								alt="#"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--banner area end-->

	<!--product section area start-->
	<section class="product_section womens_product">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section_title">
						<h2>Sản phẩm bán chạy</h2>
						<p>Các sản phẩm mới nhất bán với số lượng nhiều của chúng tôi</p>
					</div>
				</div>
			</div>
			<div class="product_area">
				<div class="row">
					<div class="col-12">
						<div class="product_tab_button">
							<ul class="nav" role="tablist">
								<c:forEach var="category" items="${categories}">
									<li><a id="tablist-${category.id}" data-toggle="tab" href="#tabItem-${category.id}" role="tab"
										aria-controls="${category.id}" aria-selected="false">${category.name}</a>
									</li>
								</c:forEach>
                               
							</ul>
						</div>
					</div>
				</div>
				<div class="tab-content">
					<c:forEach var="category" items="${categories}">
						<div class="tab-pane fade" id="tabItem-${category.id}" role="tabpanel">
							<div class="product_container">
								<div class="row product_column4">
									<c:forEach var="product"
										items="${productDAO.getProductByCategory(1,category.id)}">
										<div class="col-lg-3">
											<div class="single_product">
												<div class="product_thumb">
													<a class="primary_img" href="./product-detail?id=${product.id}"><img src="${ImagesDAO.getByProductId(product.id).img}" alt=""></a>

													<div class="quick_button">
														<a data-toggle="modal"
												data-target="#modal_box-${product.id}"
												title="quick_view">Xem nhanh</a>
													</div>
												</div>
												<div class="product_content">
													<h3>
														<a href="product-details.jsp">${product.name}</a>
													</h3>
												
												</div>
											</div>
										</div>
									</c:forEach>


								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<!--product section area end-->

	<!--banner area start-->
	<section class="banner_section banner_section_three">
		<div class="container-fluid">
			<div class="row ">
				<div class="col-lg-6 col-md-6">
					<div class="banner_area">
						<div class="banner_thumb">
							<a href="shop.jsp"><img src="./assets/img/bg/banner11.jpg"
								alt="#"></a>
							<div class="banner_content">
								<h1>
									Handbag <br> Menâs Collection
								</h1>
								<a href="shop.jsp">Discover Now</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="banner_area">
						<div class="banner_thumb">
							<a href="shop.jsp"><img src="./assets/img/bg/banner12.jpg"
								alt="#"></a>
							<div class="banner_content">
								<h1>
									Sneaker <br> Menâs Collection
								</h1>
								<a href="shop.jsp">Discover Now</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--banner area end-->

	<!--product section area start-->
	<section class="product_section womens_product bottom">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section_title">
						<h2>Sản phẩm thịnh hành</h2>
						<p>Sản phẩm thịnh thành và bán chạy nhất</p>
					</div>
				</div>
			</div>
			<div class="product_area">
				<div class="row">
					<div class="product_carousel product_three_column4 owl-carousel">
                        <c:forEach items="${products}" var="product">
						<div class="col-lg-3">
							<div class="single_product">
								<div class="product_thumb">
										<a class="primary_img" href="./product-detail?id=${product.id}"><img src="${ImagesDAO.getByProductId(product.id).img}" alt=""></a>
									<div class="quick_button">
										<a href="#" data-toggle="modal"
												data-target="#modal_box-${product.id}"
												title="quick_view">Xem nhanh</a>
									</div>

									<div class="product_sale">
										<span>-${product.promotion}%</span>
									</div>
								</div>
								<div class="product_content">
									<h3>
										<a href="product-details.jsp">${product.name}</a>
									</h3>
									<span class="current_price">${product.price}</span> 
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

	<!--blog section area start-->
	<section class="blog_section blog_section_three">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section_title">
						<h2>Bài viết mới nhất</h2>
						<p>Cập nhật xu thế thời trang</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="blog_wrapper blog_column3 owl-carousel">
					<div class="col-lg-4">
						<div class="single_blog">
							<div class="blog_thumb">
								<a href="blog-details.jsp"><img
									src="./assets/img/blog/blog1.jpg" alt=""></a>
								<div class="blog_icon">
									<a href="blog-details.jsp"></a>
								</div>
							</div>
							<div class="blog_content">
								<h3>
									<a href="blog-details.jsp">Mercedes Benzâ Mirror To The
										Soul 360</a>
								</h3>
								<div class="author_name">
									<p>
										<span class="post_by">by</span> <span class="themes">ecommerce
											Themes</span> / 30 Oct 2017
									</p>

								</div>
								<div class="post_desc">
									<p>Maria Denardo is the Fashion Director at theFashionSpot.
										Prior to joining tFS, she worked as...</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="single_blog">
							<div class="blog_thumb">
								<a href="blog-details.jsp"><img
									src="./assets/img/blog/blog2.jpg" alt=""></a>
								<div class="blog_icon">
									<a href="blog-details.jsp"></a>
								</div>
							</div>
							<div class="blog_content">
								<h3>
									<a href="blog-details.jsp">Dior F/W 2015 First Fashion
										Experience</a>
								</h3>
								<div class="author_name">
									<p>
										<span class="post_by">by</span> <span class="themes">ecommerce
											Themes</span> / 30 Oct 2017
									</p>

								</div>
								<div class="post_desc">
									<p>Maria Denardo is the Fashion Director at theFashionSpot.
										Prior to joining tFS, she worked as...</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="single_blog">
							<div class="blog_thumb">
								<a href="blog-details.jsp"><img
									src="./assets/img/blog/blog3.jpg" alt=""></a>
								<div class="blog_icon">
									<a href="blog-details.jsp"></a>
								</div>
							</div>
							<div class="blog_content">
								<h3>
									<a href="blog-details.jsp">London Fashion Week & Royal Day</a>
								</h3>
								<div class="author_name">
									<p>
										<span class="post_by">by</span> <span class="themes">ecommerce
											Themes</span> / 30 Oct 2017
									</p>

								</div>
								<div class="post_desc">
									<p>Maria Denardo is the Fashion Director at theFashionSpot.
										Prior to joining tFS, she worked as...</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="single_blog">
							<div class="blog_thumb">
								<a href="blog-details.jsp"><img
									src="./assets/img/blog/blog2.jpg" alt=""></a>
								<div class="blog_icon">
									<a href="blog-details.jsp"></a>
								</div>
							</div>
							<div class="blog_content">
								<h3>
									<a href="blog-details.jsp">Best of New York Spring/Summer
										2016</a>
								</h3>
								<div class="author_name">
									<p>
										<span class="post_by">by</span> <span class="themes">ecommerce
											Themes</span> / 30 Oct 2017
									</p>

								</div>
								<div class="post_desc">
									<p>Maria Denardo is the Fashion Director at theFashionSpot.
										Prior to joining tFS, she worked as...</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--blog section area end-->

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