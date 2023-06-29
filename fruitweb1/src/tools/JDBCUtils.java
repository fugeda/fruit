package tools;

import java.sql.*;

public class JDBCUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/fruit?useSSL=false";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);
        return conn;
    }
    public  static void release(Statement stmt, Connection conn){
        if (stmt !=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn !=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //释放Mysql
    public  static void release(ResultSet rs,Statement stmt, Connection conn){
        if (rs !=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       release(stmt,conn);
    }
    public static void main(String[] args) {

    }
}
