package reidshop.Controller.user;

import reidshop.DAO.IAccountDAO;
import reidshop.DAO.Impl.AccountDAOImpl;
import reidshop.Entity.Account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/user/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/user/sign-up-out.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		IAccountDAO accountDAO = new AccountDAOImpl();
		Account accountCheck = accountDAO.CheckLogin(username, password);
		String message = "";
		if (accountCheck == null) {
			message = "Tài khoản hoặc mật khẩu của bạn không đúng";
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/user/sign-up-out.jsp").forward(request, response);
		} else {
			if (accountCheck.getRole() != 2) {
				message = "Tài khoản của bạn đang ở một quyền khác";
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.setAttribute("message", message);
				request.getRequestDispatcher("/user/sign-up-out.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				request.getRequestDispatcher("/user/shop").forward(request, response);
			}
		}
	}

}
