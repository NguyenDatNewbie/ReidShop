package reidshop.Controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reidshop.DAO.IImagesDAO;
import reidshop.DAO.IProductDAO;
import reidshop.DAO.ISizeDAO;
import reidshop.DAO.Impl.ImagesDAOImpl;
import reidshop.DAO.Impl.ProductDAOImpl;
import reidshop.DAO.Impl.SizeDAOImpl;
import reidshop.Entity.Product;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet("/user/product-detail")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
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
		String idString = request.getParameter("id");
		Integer id  = Integer.parseInt(idString);
		
		IImagesDAO imgs = new ImagesDAOImpl();
		IProductDAO productDAO = new ProductDAOImpl();
		ISizeDAO sizeDAO = new SizeDAOImpl();
		Product product = productDAO.getProduct(id);
		
		request.setAttribute("sizeDAO", sizeDAO);
		request.setAttribute("ImagesDAO", imgs);
		request.setAttribute("product", product);
		request.setAttribute("productDAO", productDAO);
		request.getRequestDispatcher("/user/product-details.jsp").forward(request, response);
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
