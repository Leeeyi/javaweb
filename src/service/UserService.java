package service;
import java.sql.SQLException;
import javax.security.auth.login.LoginException;

import Bean.Goods;
import Dao.UserDao;
import Bean.Order;
import Bean.User;
import exception.AddGoodsException;
import exception.RegisterException;
import utils.Mail;

public class UserService {
    private UserDao dao = new UserDao();
    // 注册操作
    public void register(User user) throws RegisterException {
        // 调用dao完成注册操作
        try {
            dao.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RegisterException("注册失败");
        }
    }
    // 登录操作
    public User login(String name, String password) throws LoginException {
        try {
            //根据登录时表单输入的用户名和密码，查找用户
            User user = dao.findUserByUsernameAndPassword(name, password);
            if (user != null) {
                return user;
            }
            throw new LoginException("用户名或密码错误");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("登录失败");
        }
    }
    public void Mail(User user, Order order) throws RegisterException {
        // 调用dao完成注册操作
        try {
            String emailMsg = "您在Rmazon商城的购物订单信息如下" + "<br>"
                    + "所购物品：" + order.getGoodsName() + "<br>"
                    + "收货人姓名：" + order.getName() + "<br>"
                    + "收货人地址：" + order.getAddress() + "<br>"
                    + "收货人电话：" + order.getPhone();
            Mail.sendMail(user.getEmail(), emailMsg);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RegisterException("发送失败");
        }
    }
    // 修改商品信息
    public void editPasswd(User p) {
        try {
            dao.editPasswd(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //后台系统，根据id删除商品信息
    public void deleteUser(String id) {
        try {
            dao.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException("后台系统根据id删除账户失败！");
        }
    }
    // 添加账户
    public void addSalesMan(User user){
        try {
            dao.addSalesman(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
