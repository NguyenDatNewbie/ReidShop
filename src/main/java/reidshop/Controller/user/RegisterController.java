package reidshop.Controller.user;

import reidshop.DAO.IAccountDAO;
import reidshop.DAO.ICartDAO;
import reidshop.DAO.IInfoUserDAO;
import reidshop.DAO.Impl.AccountDAOImpl;
import reidshop.DAO.Impl.CartDAOImpl;
import reidshop.DAO.Impl.InfoUserDAOImpl;
import reidshop.Entity.Account;
import reidshop.Entity.Cart;
import reidshop.Entity.InfoUser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/user/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
		request.getRequestDispatcher("/user/login").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String fullName = request.getParameter("fullName");
		String usernameNew = request.getParameter("usernameNew");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String passwordNew = request.getParameter("passwordNew");
		String repasswordNew = request.getParameter("repasswordNew");
		String messageRegisterFail ="";
		System.out.println(passwordNew);
		System.out.println(repasswordNew);

		if(passwordNew.equals(repasswordNew)==false)
		{
			messageRegisterFail = "Mật khẩu không trùng";
			request.setAttribute("messageRegisterFail",messageRegisterFail);
			request.setAttribute("fullName",fullName);
			request.setAttribute("usernameNew",usernameNew);
			request.setAttribute("phone",phone);
			request.setAttribute("address",address);
			request.setAttribute("passwordNew",passwordNew);
			request.setAttribute("repasswordNew",repasswordNew);
			request.getRequestDispatcher("/user/sign-up-out.jsp").forward(request, response);
		}
		else 
		{
			IAccountDAO iAccountDAO = new AccountDAOImpl();
			IInfoUserDAO iInfoUserDAO = new InfoUserDAOImpl();
			ICartDAO iCartDAO = new CartDAOImpl();

			InfoUser info = new InfoUser(0, fullName, usernameNew, phone, address, null, null, null);
			iInfoUserDAO.Insert(info);

			Account account = new Account(0, usernameNew, passwordNew, 2);
			iAccountDAO.Insert(account);

			Cart cart = new Cart(0, usernameNew, 1, Byte.parseByte("0"));
			iCartDAO.Insert(cart);


			HttpSession session = request.getSession();
			session.setAttribute("username", usernameNew);
			request.getRequestDispatcher("./shop").forward(request, response);
		}
	}

}
