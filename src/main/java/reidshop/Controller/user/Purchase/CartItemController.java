package reidshop.Controller.user.Purchase;

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
import reidshop.Entity.Cart;
import reidshop.Entity.CartItem;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartItemController
 */
@WebServlet("/user/listCart")
public class CartItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		Object obj = session.getAttribute("username");
		if(obj==null){
			request.getRequestDispatcher("./login").forward(request,response);
		}
		else{
			String username = String.valueOf(obj);
			ICartDAO cartDAO = new CartDAOImpl();
			IImagesDAO ImagesDAO = new ImagesDAOImpl();
			IProductDAO productDAO = new ProductDAOImpl();
			ICartItemDAO cartItemDAO = new CartItemDAO();
			IDeliveryDAO iDeliveryDAO = new DeliveryDAOImpl();
			IStoreDAO storeDAO = new StoreDAOImpl();
			Cart cart = cartDAO.getByUserName(username);
			List<CartItem> listCart = cartItemDAO.getCartByCartId(cart.getId());
			
			request.setAttribute("listCart",listCart);
			request.setAttribute("cart",cart);
			request.setAttribute("ImagesDAO",ImagesDAO);
			request.setAttribute("productDAO",productDAO);
			request.setAttribute("cartItemDAO",cartItemDAO);
			request.setAttribute("storeDAO",storeDAO);
			request.setAttribute("iDeliveryDAO",iDeliveryDAO);
			request.getRequestDispatcher("/user/cart.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
