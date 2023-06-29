package dao;

import bean.FruitItem;
import tools.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//小工作用
public class AdminDao {
    public ArrayList<FruitItem> queryAllData(){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        ArrayList<FruitItem> list=new ArrayList<>();
        try {
            conn= JDBCUtils.getConnection();
            stmt=conn.createStatement();
            String sql="select*from fruit";//发送SQL语句
            rs=stmt.executeQuery(sql);
            while(rs.next()){
               FruitItem fruitItem=new FruitItem();
               fruitItem.setNumber(rs.getString("number"));
               fruitItem.setName(rs.getString("name"));
               fruitItem.setPrice(rs.getDouble("price"));
               fruitItem.setUnit(rs.getString("unit"));
               list.add(fruitItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return list;//将原料放在list集合中
    }
    //增加水果功能
    public void addFruitItem(FruitItem fruitItem){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            //获取数据连接
            conn= JDBCUtils.getConnection();
            //获取statement对象
            stmt=conn.createStatement();
            //发送SQL语句
            String sql="INSERT INTO fruit(number,name,price,unit)"
                    +"VALUES("+fruitItem.getNumber()+",'"+fruitItem.getName()+"','"+fruitItem.getPrice()
                    +"','"+fruitItem.getUnit()+"')";
            int num=stmt.executeUpdate(sql);
            if (num >0) {
                System.out.println("插入数据成功");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(stmt,conn);
        }

    }

    //修改数据功能
    public void updateFruitItem(FruitItem fruitItem){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            //获取数据连接
            conn= JDBCUtils.getConnection();
            //获取statement对象
            stmt=conn.createStatement();
            //发送SQL语句
            String sql="update fruit set name='"+fruitItem.getName()+"',price='"+fruitItem.getPrice()+"',unit='"
                    +fruitItem.getUnit()+"'where number='"+fruitItem.getNumber()+"'";
            int num=stmt.executeUpdate(sql);
            if (num >0) {
                System.out.println("修改数据成功");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
    }

    //删除数据功能
    public void delFruitItem(String delNumber){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            //获取数据连接
            conn= JDBCUtils.getConnection();
            //获取statement对象
            stmt=conn.createStatement();
            //发送SQL语句
            String sql="DELETE FROM fruit WHERE number="+delNumber;
            int num=stmt.executeUpdate(sql);
            if (num >0) {
                System.out.println("删除数据成功");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
    }

    //查询数据功能
    public ArrayList<FruitItem> queryDataForcon (String number, String name, String price, String unit) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<FruitItem> List = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from fruit where 1=1";
            if (number != null && number.trim().length() != 0) {
                sql = sql + " and number='" + number.trim() + "'";
            }
            if (name != null && name.trim().length() != 0) {
                sql = sql + " and name like'%" + name.trim() + "%'";
            }
            if (price != null && price.trim().length() != 0) {
                sql = sql + " and price=" + price.trim() ;
            }
            if (unit != null && unit.trim().length() != 0) {
                sql = sql + " and unit='" + unit.trim() + "'";
            }
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                FruitItem fruitItem = new FruitItem();
                fruitItem.setNumber(rs.getString("number"));
                fruitItem.setName(rs.getString("name"));
                fruitItem.setPrice(rs.getDouble("price"));
                fruitItem.setUnit(rs.getString("unit"));
                List.add(fruitItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return List;
    }


}
