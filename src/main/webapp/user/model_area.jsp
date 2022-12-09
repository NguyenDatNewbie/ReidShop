<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- modal area start-->
<c:forEach var="product" items="${productDAO.getAll(1)}">
	<!-- modal area start-->
	<div class="modal fade" id="modal_box-${product.id}" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="modal_body">
					<div class="product_details">
						<div class="container">
							<div class="row">
								<div class="col-lg-5 col-md-5">
									<div class="product-details-tab">
										<div id="img-2" class="zoomWrapper single-zoom">
											<img 
												src="${ImagesDAO.getByProductId(product.id).img}"
												alt="big-1">
										</div>

										<div class="single-zoom-thumb">
											<ul class="s-tab-zoom owl-carousel single-product-active"
												id="gallery_02">
												<c:forEach
													items="${ImagesDAO.getAllByProductId(product.id)}"
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
													<c:forEach
														items="${sizeDAO.getSizeByProductId(product.id)}"
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
				</div>
			</div>
		</div>
	</div>
</c:forEach>
<%--	<!-- modal area start-->--%>