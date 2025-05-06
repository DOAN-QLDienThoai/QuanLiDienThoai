package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectedDatabase {
    public static Connection getConnectedDB() {
        Connection c = null;
        try {
            // Tải driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL kết nối đến MySQL qua XAMPP (cổng mặc định là 3306)
            String url = "jdbc:mysql://localhost:3306/QuanLiDienThoai?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            String username = "root";           // Mặc định XAMPP user là root
            String password = "";               // Mặc định không có mật khẩu

            c = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Kết nối cơ sở dữ liệu thất bại");
        }
        return c;
    }

    public static void closeConnectedDB(Connection c) {
        try {
            if (c != null) {
                c.close();
                System.out.println("Đóng kết nối thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể đóng kết nối.");
        }
    }
}
