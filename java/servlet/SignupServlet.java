package servlet;

import java.io.IOException;

import dao.AccountsDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.SignupLogic;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String errorMsg = null;
	
	public SignupServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		errorMsg = null;
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		
		inputCheck(userId, pass, mail, name);
		
		//入力データに不備があるときエラーメッセージをリクエストに保存しフォワード
		if(!errorMsg.isEmpty()) {
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
		}
		//入力データに不備が無いときは処理を続ける
		else {
			SignupLogic bo = new SignupLogic();
			Account newAccount= bo.execute(userId, pass, mail, name);
			
			//登録成功時はアカウントをセッションに保存しフォワード
			if(newAccount != null) {
				HttpSession session = request.getSession();
				session.setAttribute("newAccount", newAccount);

				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/signupOK.jsp");
				dispatcher.forward(request, response);
			//登録失敗時はリダイレクト
			}else {
				response.sendRedirect("SignupServlet");
			}
		}
	}
	
	public void inputCheck(String userId, String pass, String mail, String name) {
		//ユーザーIＤが空欄のとき
		if(userId.isEmpty()) {
			errorMsg += "ユーザーIDを設定してください<br>";
		}else {
			//id重複チェック
			AccountsDAO dao = new AccountsDAO();
			errorMsg += dao.useridCheckOK(userId);
		}
		//パスワードが空欄のとき
		if(pass.isEmpty()) {
			errorMsg += "パスワードを設定してください。<br>";
		}
		//メールアドレスが空欄のとき
		if(mail.isEmpty()) {
			errorMsg += "メールアドレスの入力は必須です。<br>";
		}
		//姓名が空欄のとき
		if(name.isEmpty()) {
			errorMsg += "姓名の入力は必須です。<br>";
		}
		
		//エラー文言からnull文字を削除
		if(errorMsg != null) {
			errorMsg = errorMsg.replaceAll("null", "");
		}
	}
}