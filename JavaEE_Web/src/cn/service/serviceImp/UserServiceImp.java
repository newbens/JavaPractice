package cn.service.serviceImp;

import cn.domain.User;
import cn.service.UserService;
import dao.UserDao;
import dao.UserDao333;
import dao.UserDaoImp;

public class UserServiceImp implements UserService {
    UserDao ud = new UserDaoImp();

    @Override
    public Boolean selectUser(String name) {
        User user= ud.findUser(name);
        if (user == null) {
            return true;
        }else {
            return false;
        }
    }
}
