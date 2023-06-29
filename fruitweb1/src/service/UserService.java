package service;

import dao.UserDao;

public class UserService {
    public String login(String name,String password){
        UserDao dao=new UserDao();
        {
            if (name != null&&name.length()>0) {
                return dao.login(name,password);
            }else {
                return "5";
            }
        }
    }
}
