package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Manage;

public class ManageDAO {

	//学生登録
	public static void register(String id, String name, String grade, String class0) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/managedb?useSSL=false",
					"Abe",
					"Dai");

			String sql = "INSERT INTO Students VALUES(?,?,?,?)";

			pstmt = con.prepareStatement(sql);

			int Id = Integer.parseInt(id);
			int Grade = Integer.parseInt(grade);

			pstmt.setInt(1, Id);
			pstmt.setString(2, name);
			pstmt.setInt(3, Grade);
			pstmt.setString(4, class0);

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
	//受験データ入力
	public static void manage(String qId, String day, String id, String result) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/managedb?useSSL=false",
					"Abe",
					"Dai");

			String sql = "INSERT INTO Manage VALUES(?,?,?,?)";

			pstmt = con.prepareStatement(sql);

			int qID = Integer.parseInt(qId);
			int Id = Integer.parseInt(id);

			pstmt.setInt(1, qID);
			pstmt.setString(2, day);
			pstmt.setInt(3, Id);
			pstmt.setString(4, result);

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
	//受験データの一覧表示
	public static ArrayList<Manage> index() {
		ArrayList<Manage> resultList = new ArrayList<Manage>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/managedb?useSSL=false",
					"Abe",
					"Dai");

			String sql = "SELECT Manage.qId, qualification.qName, Manage.id, Students.name, Students.grade, "
					+ "Students.class0, day, result "
					+ "FROM Manage "
					+ "JOIN Qualification "
					+ "ON Manage.qId = Qualification.qId "
					+ "JOIN Students "
					+ "ON Manage.id = Students.id";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				int Grade = rs.getInt("grade");
				String Class = rs.getString("class0");
				int qId = rs.getInt("qId");
				String qName = rs.getString("qName");
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String day = rs.getString("day");
				String result = rs.getString("result");
				resultList.add(new Manage(qId,qName,id,name,Grade,Class,day,result));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return resultList;
	}

	//条件付き一覧表示
	public static ArrayList<Manage> indexIf(String grade, String class0) {
		ArrayList<Manage> resultList = new ArrayList<Manage>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/managedb?useSSL=false",
					"Abe",
					"Dai");

			String sql = "SELECT Students.grade, Students.class0, Students.name, Manage.qId, qualification.qName, "
					+ "Manage.id, day, result "
					+ "FROM Manage "
					+ "JOIN Qualification "
					+ "ON Manage.qId = Qualification.qId "
					+ "JOIN Students "
					+ "ON Manage.id = Students.id";

			String sql1 = "SELECT Students.grade, Students.class0, Students.name, Manage.qId, qualification.qName, "
					+ "Manage.id, day, result "
					+ "FROM Manage "
					+ "JOIN Qualification "
					+ "ON Manage.qId = Qualification.qId "
					+ "JOIN Students "
					+ "ON Manage.id = Students.id "
					+ "WHERE Students.grade = ?";

			String sql2 = "SELECT Students.grade, Students.class0, Students.name, Manage.qId, qualification.qName, "
					+ "Manage.id, day, result "
					+ "FROM Manage "
					+ "JOIN Qualification "
					+ "ON Manage.qId = Qualification.qId "
					+ "JOIN Students "
					+ "ON Manage.id = Students.id "
					+ "WHERE Students.class0 = ?";

			// 両方選択されている場合
			if("-----------".equals(grade) && "-----------".equals(class0)) {
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();

				while(rs.next() == true) {
					int Grade = rs.getInt("grade");
					String Class = rs.getString("class0");
					int qId = rs.getInt("qId");
					String qName = rs.getString("qName");
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String day = rs.getString("day");
					String result = rs.getString("result");
					resultList.add(new Manage(qId,qName,id,name,Grade,Class,day,result));
				}
			// gradeのみ選択時
			}else if(!("-----------".equals(grade)) && "-----------".equals(class0)) {
				pstmt = con.prepareStatement(sql1);

				rs = pstmt.executeQuery();

				while(rs.next() == true) {
					int Grade = rs.getInt("grade");
					String Class = rs.getString("class0");
					int qId = rs.getInt("qId");
					String qName = rs.getString("qName");
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String day = rs.getString("day");
					String result = rs.getString("result");
					resultList.add(new Manage(qId,qName,id,name,Grade,Class,day,result));
				}
			// classのみ選択時
			}else if("-----------".equals(grade) && !("-----------".equals(class0))) {
				pstmt = con.prepareStatement(sql2);

				rs = pstmt.executeQuery();

				while(rs.next() == true) {
					int Grade = rs.getInt("grade");
					String Class = rs.getString("class0");
					int qId = rs.getInt("qId");
					String qName = rs.getString("qName");
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String day = rs.getString("day");
					String result = rs.getString("result");
					resultList.add(new Manage(qId,qName,id,name,Grade,Class,day,result));
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return resultList;
	}
	//資格の登録
	public static void qualification(String qId, String qName) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/managedb?useSSL=false",
					"Abe",
					"Dai");

			String sql = "INSERT INTO Qualification VALUES(?,?)";

			pstmt = con.prepareStatement(sql);

			int qID = Integer.parseInt(qId);

			pstmt.setInt(1, qID);
			pstmt.setString(2, qName);

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
}
