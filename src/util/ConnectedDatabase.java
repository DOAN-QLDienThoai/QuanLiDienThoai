package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectedDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/quanlidienthoai?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String USER = "root";  // Thay đổi nếu tài khoản khác
    private static final String PASSWORD = "";  // Nhập mật khẩu của bạn (hoặc để trống nếu không có)

    public static Connection getConnectedDB() {
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver cho MySQL
            c = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Ket noi SQL thanh cong!");
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy Driver MySQL JDBC!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Loi ket noi CSDL: " + e.getMessage());
            e.printStackTrace();
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