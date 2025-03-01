package model;

import dao.AccountsDAO;

public class SignupLogic {
	public Account execute(String userId, String pass, String mail, String name) {
		AccountsDAO dao = new AccountsDAO();
		Account account = dao.insertNewUser(userId, pass, mail, name);
		return account;
	}
}
