package reidshop.Controller.user.Purchase;


import reidshop.Service.Impl.PayServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PayController
 */
@WebServlet("/user/pay")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String username = String.valueOf(session.getAttribute("username"));
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String storeId = request.getParameter("storeId");
		String delivery = request.getParameter("deliveryId");
		Integer istoreId = Integer.parseInt(storeId);
		Integer deliveryId = Integer.parseInt(delivery);
		
		
		
		PayServiceImpl payService = new PayServiceImpl();
		payService.Handle(username,address,phone,istoreId,deliveryId);
	
		request.getRequestDispatcher("./listCart").forward(request, response);
	}

}
