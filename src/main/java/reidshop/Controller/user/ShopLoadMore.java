package reidshop.Controller.user;

import reidshop.DAO.IImagesDAO;
import reidshop.DAO.IProductDAO;
import reidshop.DAO.Impl.ImagesDAOImpl;
import reidshop.DAO.Impl.ProductDAOImpl;
import reidshop.Entity.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShopLoadMore
 */
@WebServlet("/user/shoploadMore")
public class ShopLoadMore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopLoadMore() {
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
		String amount = request.getParameter("exits");
		int iamount = Integer.parseInt(amount);
		
		IProductDAO productDAO = new ProductDAOImpl();
		IImagesDAO ImagesDAO = new ImagesDAOImpl();
		List<Product> products = productDAO.getTop9Next(1,iamount);
		
		PrintWriter out = response.getWriter();
		for (Product product: products
			 ) {
			BigDecimal discount = product.getPrice().subtract(product.Tich(product.getPromotion()/100,product.getPrice()));
			out.println("<div class=\"product col-lg-4 col-md-4 col-12 \">\r\n"
					+ "									<div class=\"single_product\">\r\n"
					+ "										<div class=\"product_thumb\">\r\n"
					+ "											<a class=\"primary_img\" href=\"product-details.jsp\"><img src=\""+ImagesDAO.getByProductId(product.getId()).getImg()+"\" alt=\"\"></a>\r\n"
					+ "											<div class=\"quick_button\">\r\n"
					+ "												<a href=\"product-details.jsp\" title=\"quick_view\">Xem sản phẩm</a>\r\n"
					+ "											</div>\r\n");
			
			if(product.getPromotion()!=0)
				{
				out.println("<div class=\"double_base\">\r\n"
						+ "												<div class=\"product_sale\">\r\n"
						+ "														<span>-"+product.getPromotion()+"%</span>\r\n"
						+ "												</div>\r\n"
						+ "											</div>");
				}
			
			out.println("</div>"
					+ "<div class=\"product_content grid_content\">\r\n"
					+ "											<h3>\r\n"
					+ "												<a href=\"product-details.jsp\">"+product.getName()+"</a>\r\n"
					+ "											</h3>\r\n"
					+ "											<span class=\"current_price\">"+discount+"VNĐ</span>");
			
			if(product.getPromotion()!=0) {
				out.println("	<span class=\"old_price\">"+product.getPrice()+"VNĐ</span>");
			}
			out.println("</div>"
					+ "<div class=\"product_content list_content\">\r\n"
					+ "											<h3>\r\n"
					+ "												<a href=\"product-details.jsp\">"+product.getName()+"</a>\r\n"
					+ "											</h3>\r\n"
					+ "											<div class=\"product_ratting\">\r\n"
					+ "												<ul>\r\n"
					+ "													<li><a href=\"#\"><i class=\"fa fa-star\"></i></a></li>\r\n"
					+ "													<li><a href=\"#\"><i class=\"fa fa-star\"></i></a></li>\r\n"
					+ "													<li><a href=\"#\"><i class=\"fa fa-star\"></i></a></li>\r\n"
					+ "													<li><a href=\"#\"><i class=\"fa fa-star\"></i></a></li>\r\n"
					+ "													<li><a href=\"#\"><i class=\"fa fa-star\"></i></a></li>\r\n"
					+ "												</ul>\r\n"
					+ "											</div>\r\n"
					+ "											<div class=\"product_price\">\r\n"
					+ "												<span class=\"current_price\">"+discount+"VNĐ</span> <span\r\n"
					+ "													class=\"old_price\">"+product.getPrice()+"VNĐ</span>\r\n"
					+ "											</div>\r\n"
					+ "											<div class=\"product_desc\">\r\n"
					+ "												<p>"+product.getDescription()+"</p>\r\n"
					+ "											</div>\r\n"
					+ "										</div>\r\n"
					+ "									</div>\r\n"
					+ "								</div>");
				
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
