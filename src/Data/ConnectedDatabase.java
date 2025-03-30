package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectedDatabase {

    public static Connection getConnectedDB() {
        Connection c = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://LAPTOP-2EA7CM4Q:1433;databaseName=QuanLiDienThoai;encrypt=false;characterEncoding=UTF-8";
            String username = "sa";
            String password = "123456789";
            c = DriverManager.getConnection(url, username, password);
            System.out.println("Ket noi thanh cong ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ket noi co so du lieu that bai");
        }
        return c;
    }

    public static void closeConnectedDB(Connection c) {
        if (c != null) {
            try {
                c.close();
                System.out.println("Đóng kết nối thành công!");
            } catch (SQLException e) {
                System.err.println("Không thể đóng kết nối!");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = getConnectedDB();
        closeConnectedDB(conn);
    }
}
