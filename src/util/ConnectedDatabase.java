package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectedDatabase {
    public static Connection getConnectedDB() {
        Connection c=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://LAPTOP-2EA7CM4Q:1433;databaseName=QuanLiDienThoai;encrypt=false;characterEncoding=UTF-8";
			String username="sa";
			String password="123456789";
			c=DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Ket noi co so du lieu that bai");
		}
		return c;
    }

    public static void closeConnectedDB(Connection c) {
        if (c != null) {
            try {
                c.close();
                System.out.println("Dong ket noi thanh cong!");
            } catch (SQLException e) {
                System.err.println("Khong the dong ket noi!");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = getConnectedDB();
        closeConnectedDB(conn);
    }
}
