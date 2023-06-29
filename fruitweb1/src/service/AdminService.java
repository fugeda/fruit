package Service;

import bean.FruitItem;
import dao.AdminDao;

import java.util.ArrayList;

public class AdminService {
    private AdminDao adminDao=new AdminDao();

    public ArrayList<FruitItem> queryFruitItem(){
        ArrayList<FruitItem> data=adminDao.queryAllData();
        return data;
    }
    //增加
    public boolean addFruitItem(String number,String name,String price,String unit){
        //调用dao层的获取所有所有数据方法获取所有数据
       ArrayList<FruitItem> data=queryFruitItem();
       //使用输入的编号与所有数据进行对比
        for (int i = 0; i < data.size(); i++) {
            FruitItem fruitItem=data.get(i);
            if (number.equals(fruitItem.getNumber())) {
                //如果编号重复，则添加不成功
              return false;
            }
        }
        FruitItem thisFruitItem=new FruitItem(number,name,Double.parseDouble(price),unit);
        //调用dao层添加数据方法
        adminDao.addFruitItem(thisFruitItem);
        //在添加数据后，返回添加成功
        return true;
    }
    //修改
    public boolean updateFruitItem(String number,String name,String price,String unit){
        //调用dao层的获取所有所有数据方法获取所有数据
        ArrayList<FruitItem> data=queryFruitItem();
        //使用输入的编号与所有数据进行对比，相同编号可以更新
        for (int i = 0; i < data.size(); i++) {
            FruitItem fruitItem=data.get(i);
            if (number.equals(fruitItem.getNumber())) {
               FruitItem thisFruitItem=new FruitItem(number,name,Double.parseDouble(price),unit);
               adminDao.updateFruitItem(thisFruitItem);
               return true;
            }
        }
        //不存在相同编号，不可以修改
        return false;
    }

    //删除
    public boolean delFruitItem(String delNumber){
        //调用dao层的获取所有所有数据方法获取所有数据
        ArrayList<FruitItem> data=queryFruitItem();
        //使用输入的编号与所有数据进行对比，相同编号可以更新
        for (int i = 0; i < data.size(); i++) {
            FruitItem fruitItem=data.get(i);
            if (delNumber.equals(fruitItem.getNumber())) {
                adminDao.delFruitItem(delNumber);
                return true;
            }
        }
        //
        return false;
    }

    //条件查询
    public ArrayList<FruitItem> queryFruitItemForcon(String conNumber, String conName, String conPrice, String conUnit){
        ArrayList<FruitItem> data=adminDao.queryDataForcon(conNumber,conName,conPrice,conUnit);
        return data;
    }
}
