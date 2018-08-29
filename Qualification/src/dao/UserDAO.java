package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	//学生登録
	public static void register(String ID, String pass, String Name, String Sid, String Mail) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/managedb?useSSL=false",
					"Abe",
					"Dai");

			String sql = "INSERT INTO User VALUES(?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);

			int sID = Integer.parseInt(Sid);

			pstmt.setString(1, ID);
			pstmt.setString(2, pass);
			pstmt.setString(3, Name);
			pstmt.setInt(4, sID);
			pstmt.setString(5, Mail);

			pstmt.executeUpdate();

		} catch(SQLException | ClassNotFoundException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
			System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}

	//学生登録
	public static String login(String ID, String pass) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/managedb?useSSL=false",
					"Abe",
					"Dai");

			String sql = "SELECT user.id, user.name FROM User WHERE id = ? && name = ?";

			pstmt = con.prepareStatement(sql);


			pstmt.setString(1, ID);
			pstmt.setString(2, pass);

			ResultSet rs = pstmt.executeQuery();

			String day = rs.getString("day");
			String result = rs.getString("result");

		} catch(SQLException | ClassNotFoundException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return result;
	}
}
