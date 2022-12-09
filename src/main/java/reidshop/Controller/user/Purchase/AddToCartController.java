package reidshop.Controller.user.Purchase;

import reidshop.DAO.ICartDAO;
import reidshop.DAO.ICartItemDAO;
import reidshop.DAO.Impl.CartDAOImpl;
import reidshop.DAO.Impl.CartItemDAO;
import reidshop.Entity.Cart;
import reidshop.Entity.CartItem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/user/addToCard")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
//
		String id= request.getParameter("id");
		String quantity = request.getParameter("quantity");
		String size = request.getParameter("product_size");
		Integer productId = Integer.parseInt(id);
		Integer iquantity = Integer.parseInt(quantity);
		Integer isize = Integer.parseInt(size);
		Object obj = session.getAttribute("username");
		String username ="";

		if(obj!=null){
			username = String.valueOf(obj);
			ICartDAO cartDAO = new CartDAOImpl();
			ICartItemDAO cartItemDAO = new CartItemDAO();
			Cart cart = cartDAO.getByUserName(username);
			
			CartItem cartItem = cartItemDAO.CheckExist(productId, cart.getId(),isize);
			if (cartItem==null) {
				cartItem = new CartItem(0, cart.getId(), productId, iquantity, isize);
				cartItemDAO.Insert(cartItem);
			} else {
				
				cartItemDAO.Update(cartItem);
			}
			request.getRequestDispatcher("/user/product-detail?"+productId.toString()).forward(request,response);
		}
		else {
			request.getRequestDispatcher("/user/sign-up-out.jsp").forward(request,response);
		}

	}

}
