package dao;

import tools.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public String login(String name,String password){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from user where username=? and password=?";

        try {
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            rs=pstmt.executeQuery();
            if (rs.next()) {
                return "1";
            }else{
                return "2";
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "3";
        } catch (SQLException e) {
            e.printStackTrace();
            return "4";
        }finally {
            JDBCUtils.release(rs,pstmt,conn);
        }
    }
}
