package reidshop.Controller.user.Purchase;

import reidshop.DAO.ICartDAO;
import reidshop.DAO.ICartItemDAO;
import reidshop.DAO.IDeliveryDAO;
import reidshop.DAO.Impl.CartDAOImpl;
import reidshop.DAO.Impl.CartItemDAO;
import reidshop.DAO.Impl.DeliveryDAOImpl;
import reidshop.Entity.Cart;
import reidshop.Entity.Delivery;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeliveryController
 */
@WebServlet("/user/loadDeli")
public class DeliveryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeliveryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String username = String.valueOf(session.getAttribute("username"));
		String DeliverOption = request.getParameter("id");
		Integer iDeliveryOption = Integer.valueOf(DeliverOption);

		IDeliveryDAO iDeliveryDAO = new DeliveryDAOImpl();
		ICartDAO cartDAO = new CartDAOImpl();
		ICartItemDAO cartItemDAO = new CartItemDAO();
		Cart cart = cartDAO.getByUserName(username);
		BigDecimal total = cartItemDAO.TotalPrice(cart);
		PrintWriter out = response.getWriter();

		out.print("<h3>Hóa đơn</h3>\r\n" + "                                <div class=\"coupon_inner\">\r\n"
				+ "                                   <div class=\"cart_subtotal\">\r\n"
				+ "                                       <p>Tổng tiền</p>\r\n"
				+ "                                       <p class=\"cart_amount\">" + total + "</p>\r\n"
				+ "                                   </div>\r\n"

				+ "                                   <div class=\"cart_subtotal\" id=\"price_deli\">\r\n"
				+ "										<p>Phí giao hàng</p>\r\n"
				+ "										<p class=\"cart_amount\">"
				+ iDeliveryDAO.get(iDeliveryOption).getPrice() + "</p>\r\n"
				+ "									</div>\r\n"
				+ "									<div class=\"cart_subtotal\">\r\n"
				+ "										<p>Đơn vị vận chuyển</p>\r\n"
				+ "										<select class=\"select_option\" id=\"deliveryOption\" name=\"deliveryId\"\r\n"
				+ "											onchange=\"changeDeli(this)\">\r\n");

		for (Delivery delivery : iDeliveryDAO.getAll()) {
			if (delivery.getId() == iDeliveryOption)
				out.print(
						"<option selected value=\"" + delivery.getId() + "\">" + delivery.getName() + "</option>\r\n");
			else
				out.print("<option value=\"" + delivery.getId() + "\">" + delivery.getName() + "</option>\r\n");
		}
		out.print("										</select>\r\n" + "									</div>"
				+ "                                   \r\n"
				+ "                                   <div class=\"cart_subtotal\">\r\n"
				+ "                                       <p>Thành tiền</p>\r\n"
				+ "                                       <p class=\"cart_amount\">"
				+ total.add(iDeliveryDAO.get(iDeliveryOption).getPrice()) + "VNĐ</p>\r\n"
				+ "                                   </div>\r\n"
				+ "                                   <div class=\"checkout_btn\">\r\n"
				+ "										<button type=\"submit\">Thanh toán</button>\r\n"
				+ "									</div>" + "                                </div>\r\n"
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
