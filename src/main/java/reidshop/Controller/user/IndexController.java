package reidshop.Controller.user;

import reidshop.DAO.ICategoryDAO;
import reidshop.DAO.IImagesDAO;
import reidshop.DAO.IProductDAO;
import reidshop.DAO.ISizeDAO;
import reidshop.DAO.Impl.CategoryDAOImpl;
import reidshop.DAO.Impl.ImagesDAOImpl;
import reidshop.DAO.Impl.ProductDAOImpl;
import reidshop.DAO.Impl.SizeDAOImpl;
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
 * Servlet implementation class IndexController
 */
@WebServlet("/user/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		IImagesDAO ImagesDAO = new ImagesDAOImpl();
		ICategoryDAO categoryDAO = new CategoryDAOImpl();
		List<Category> categories = categoryDAO.getAll();
		IProductDAO productDAO = new ProductDAOImpl();
		List<Product> products = productDAO.getSellingProduct(1);
		ISizeDAO sizeDAO = new SizeDAOImpl();

		request.setAttribute("ImagesDAO",ImagesDAO);
		request.setAttribute("products",products);
		request.setAttribute("categories",categories);
		request.setAttribute("productDAO",productDAO);
		request.setAttribute("sizeDAO",sizeDAO);
		request.getRequestDispatcher("/user/index.jsp").forward(request, response);
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
