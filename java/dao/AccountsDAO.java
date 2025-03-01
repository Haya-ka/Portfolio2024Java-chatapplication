package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountsDAO {
	private final String JDBC_URL="jdbc:postgresql://localhost:5432/memorandum";
	private final String DB_USER="postgres";
	private final String DB_PASS="sql";

	public Account findByLogin(Login login) {
		Account account = null;
		//JDBCドライバを読み込む
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//select文を準備
			String sql = "SELECT user_id, pass, mail, name from accounts where user_id = ? and pass = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());
			
			//select文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				//ユーザーが存在したらデータを取得し、そのユーザーを表すAccountインスタンスを生成
				String userId = rs.getString("user_id");
				String pass = rs.getString("pass");
				String mail = rs.getString("mail");
				String name = rs.getString("name");
				account = new Account(userId, pass, mail, name);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}

	public Account insertNewUser(String userId, String pass, String mail, String name) {
		Account account = null;
		//JDBCドライバを読み込む
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//select文を準備
			String sql = "insert into accounts(user_id, pass, mail, name)values(?, ?, ?, ?);";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			pStmt.setString(2, pass);
			pStmt.setString(3, mail);
			pStmt.setString(4, name);
			
			//select文を実行
			pStmt.execute();
			account = new Account(userId, pass, mail, name);
			return account;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String useridCheckOK(String userId) {
		String errorMsg = null;
		//JDBCドライバを読み込む
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//select文を準備
			String sql = "SELECT * from accounts where user_id = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			
			//select文を実行し結果が存在すればid重複エラー
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				errorMsg = "すでに存在しているユーザーIDです。<br>";
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return errorMsg;
	}
}
