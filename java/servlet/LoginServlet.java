package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		public LoginServlet() {
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//リクエストパラメータの取得
			request.setCharacterEncoding("UTF-8");
			String userId = request.getParameter("userId");
			String pass = request.getParameter("pass");
			
			Login login = new Login(userId, pass);
			LoginLogic bo = new LoginLogic();
			Account loginAccount = bo.execute(login);
			
			//ログイン処理の成否によって処理を分岐
			if(loginAccount != null) {	//ログイン成功時
				//セッションスコープにユーザーIDを保存
				HttpSession session = request.getSession();
				session.setAttribute("loginAccount", loginAccount);
				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginOK.jsp");
				dispatcher.forward(request, response);
			}else {		//ログイン失敗時
				//リダイレクト
				response.sendRedirect("LoginServlet");
			}
		}
	}
