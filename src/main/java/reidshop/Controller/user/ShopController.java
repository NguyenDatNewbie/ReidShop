package reidshop.Controller.user;

import reidshop.DAO.ICategoryDAO;
import reidshop.DAO.IImagesDAO;
import reidshop.DAO.IProductDAO;
import reidshop.DAO.Impl.CategoryDAOImpl;
import reidshop.DAO.Impl.ImagesDAOImpl;
import reidshop.DAO.Impl.ProductDAOImpl;
import reidshop.Entity.Category;
import reidshop.Entity.Product;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShopController
 */
@WebServlet("/user/shop")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ICategoryDAO categoryDAO = new CategoryDAOImpl();
		IProductDAO productDAO = new ProductDAOImpl();
		IImagesDAO ImagesDAO = new ImagesDAOImpl();
		List<Category> categories = categoryDAO.getAll();
		List<Product> products = productDAO.getTop9(1,1);


		request.setAttribute("ImagesDAO",ImagesDAO);
		request.setAttribute("products",products);
		request.setAttribute("categories",categories);
		request.getRequestDispatcher("/user/shop_category.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
