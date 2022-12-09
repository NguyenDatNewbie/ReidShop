package reidshop.Controller.user.Purchase;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reidshop.DAO.ICartDAO;
import reidshop.DAO.ICartItemDAO;
import reidshop.DAO.IDeliveryDAO;
import reidshop.DAO.IImagesDAO;
import reidshop.DAO.IProductDAO;
import reidshop.DAO.IStoreDAO;
import reidshop.DAO.Impl.CartDAOImpl;
import reidshop.DAO.Impl.CartItemDAO;
import reidshop.DAO.Impl.DeliveryDAOImpl;
import reidshop.DAO.Impl.ImagesDAOImpl;
import reidshop.DAO.Impl.ProductDAOImpl;
import reidshop.DAO.Impl.StoreDAOImpl;
import reidshop.Entity.*;

/**
 * Servlet implementation class DeleteItemController
 */
@WebServlet("/user/delete")
public class DeleteItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteItemController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		Integer iId = Integer.valueOf(id);
		String username = String.valueOf(session.getAttribute("username"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String storeOption = request.getParameter("store");
		Integer istoreOption = Integer.valueOf(storeOption);
		String DeliverOption = request.getParameter("deliveryOption");
		Integer iDeliveryOption = Integer.valueOf(DeliverOption);

		ICartDAO cartDAO = new CartDAOImpl();
		IImagesDAO ImagesDAO = new ImagesDAOImpl();
		IProductDAO productDAO = new ProductDAOImpl();
		ICartItemDAO cartItemDAO = new CartItemDAO();
		IStoreDAO istoreDAO = new StoreDAOImpl();
		Cart cart = cartDAO.getByUserName(username);
		cartItemDAO.Delete(iId);
		IDeliveryDAO iDeliveryDAO = new DeliveryDAOImpl();
		List<CartItem> listCart = cartItemDAO.getCartByCartId(cart.getId());
		PrintWriter out = response.getWriter();
		BigDecimal total = cartItemDAO.TotalPrice(cart);
		out.print("<div class=\"row\">\r\n" + "                    <div class=\"col-12\">\r\n"
				+ "                        <div class=\"table_desc\">\r\n"
				+ "                            <div class=\"cart_page table-responsive\">\r\n"
				+ "                                <table>\r\n" + "                                    <thead>\r\n"
				+ "                                        <tr>\r\n"
				+ "                                            <th class=\"product_remove\">Xóa</th>\r\n"
				+ "                                            <th class=\"product_thumb\">Hình ảnh</th>\r\n"
				+ "                                            <th class=\"product_name\">Sản phẩm</th>\r\n"
				+ "                                            <th class=\"product-price\">Giá</th>\r\n"
				+ "                                            <th class=\"product_quantity\">Số lượng</th>\r\n"
				+ "                                            <th class=\"product_total\">Tổng tiền(VNĐ)</th>\r\n"
				+ "                                        </tr>\r\n"
				+ "                                    </thead>\r\n" + "                                    <tbody>");

		
		for (CartItem cartItem : listCart) {
			Product product = productDAO.getProduct(cartItem.getProductId());
			Images img = ImagesDAO.getByProductId(product.getId());
			BigDecimal discount = productDAO.TotalPrice_Promotion_count(product, 1);
			out.print("<tr>\r\n" 
					+ "<td class=\"product_remove\"\r\n"
					+ "													onclick=\"deleteItem("+cartItem.getId()+")\"><a><i\r\n"
					+ "														class=\"fa fa-trash-o\"></i></a></td>"
					
					+ "      <td class=\"product_thumb\"><a href=\"#\"><img style=\"width:120px\" src=\"" + img.getImg()
					+ "\" alt=\"\"></a></td>\r\n" + "       <td class=\"product_name\"><a href=\"#\">"
					+ product.getName() + "</a></td>\r\n" + "       <td class=\"product-price\">\r\n" + "           "
					+ discount + "                                               \r\n" + "       </td>\r\n"
					+ "           <td class=\"product_quantity\" ><input min=\"1\" max=\"100\" value=\""
					+ cartItem.getCount() + "\" type=\"number\" name=\"quantity\"  onchange=\"load(this.value,"
					+ cartItem.getId() + ")\"></td>\r\n" + "           <td class=\"product_total\">"
					+ product.Tich(cartItem.getCount(), discount) + "</td>\r\n" + "</tr>");
		}

		out.print("</tbody>\r\n" + "                                </table>   \r\n"
				+ "                            </div>  \r\n"
				+ "                           <div class=\"cart_submit\">\r\n"
				+ "								<a class=\"button\" href=\"./shop\">Tiếp tục mua sắm</a>\r\n"
				+ "							</div>" 
				+ "                        </div>\r\n"
				+ "                    </div>\r\n" + "                </div>\r\n" + "                \r\n"
				+ "                <!--coupon code area start-->\r\n"
				+ "                <div class=\"coupon_area\">\r\n" + "                    <div class=\"row\">\r\n"
				+ "                        <div class=\"col-lg-6 col-md-6\">\r\n"
				+ "                            <div class=\"coupon_code left\">\r\n"
				+ "								<h3>Thông tin giao hàng</h3>\r\n"
				+ "								<div class=\"coupon_inner\">\r\n"
				+ "									<input placeholder=\"Địa chỉ giao hàng\" name=\"address\" id=\"address\" value=\""+address+"\" \r\n " 
				+ "										type=\"text\" required> <input\r\n"
				+ "										placeholder=\"Số điện thoại nhận hàng\" name=\"phone\" type=\"text\" id=\"phone\" value=\""+phone+"\" \r\n "
				+ "										required>"
				+ "									<div class=\"product_variant size\"\r\n"
				+ "										style=\"margin-top: 15px; margin-bottom: 0px;\">\r\n"
				+ "										<h3 style=\"background: white; margin-right: 117px;\">Chi\r\n"
				+ "											nhánh</h3>\r\n"
				+ "										<select class=\"select_option\" id=\"store\" name=\"storeId\">\r\n");
		for (Store store : istoreDAO.getAll()) {
			if(store.getId()==istoreOption)
				out.print("		<option selected value=\""+store.getId()+"\">" + store.getName() + "</option>\r\n");
			else
				out.print("		<option  value=\"" + store.getId() + "\">" + store.getName() + "</option>\r\n");

		}

		out.print("										</select>\r\n" + "									</div>\r\n"
				+ "\r\n" + "								</div>\r\n" + "							</div>"
				+ "                        </div>\r\n" + "                        <div class=\"col-lg-6 col-md-6\">\r\n"
				+ "                            <div class=\"coupon_code right\" id=\"cart-sub\">\r\n"
				+ "                                <h3>Hóa đơn</h3>\r\n"
				+ "                                <div class=\"coupon_inner\">\r\n"
				+ "                                   <div class=\"cart_subtotal\">\r\n"
				+ "                                       <p>Tổng tiền</p>\r\n"
				+ "                                       <p class=\"cart_amount\">" + total + "</p>\r\n"
				+ "                                   </div>\r\n"

				+ "                                   <div class=\"cart_subtotal\" id=\"price_deli\">\r\n"
				+ "										<p>Phí giao hàng</p>\r\n"
				+ "										<p class=\"cart_amount\">"+iDeliveryDAO.get(iDeliveryOption).getPrice()+"</p>\r\n"
				+ "									</div>\r\n"
				+ "									<div class=\"cart_subtotal\">\r\n"
				+ "										<p>Đơn vị vận chuyển</p>\r\n"
				+ "										<select class=\"select_option\" id=\"deliveryOption\" name=\"deliveryId\"\r\n"
				+ "											onchange=\"changeDeli(this)\">\r\n");

		for (Delivery delivery : iDeliveryDAO.getAll()) {
			if(delivery.getId()==iDeliveryOption)
				out.print("<option selected value=\"" + delivery.getId() + "\">" + delivery.getName() + "</option>\r\n");
			else
				out.print("<option value=\"" + delivery.getId() + "\">" + delivery.getName() + "</option>\r\n");
		}
		out.print("										</select>\r\n" + "									</div>"
				+ "                                   \r\n"
				+ "                                   <div class=\"cart_subtotal\">\r\n"
				+ "                                       <p>Thành tiền</p>\r\n"
				+ "                                       <p class=\"cart_amount\">"
				+ total.add(iDeliveryDAO.get(iDeliveryOption).getPrice()) + "VNĐ</p>\r\n" + "                                   </div>\r\n"
				+ "                                   <div class=\"checkout_btn\">\r\n"
				+ "										<button type=\"submit\">Thanh toán</button>\r\n"
				+ "									</div>" 
				+ "                                </div>\r\n"
				+ "                            </div>\r\n" + "                        </div>\r\n"
				+ "                    </div>\r\n" + "                </div>");

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
