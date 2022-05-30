package Dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;
import Bean.User;

public class UserDao {
    // 添加用户
    public void addUser(User user) throws SQLException {
        String sql = "insert into user(name,password,gender,email,phone,role) values(?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        int row = runner.update(sql, user.getName(), user.getPassword(),
                user.getGender(), user.getEmail(), user.getTelephone(), user.getRole());
        if (row == 0) {
            throw new RuntimeException();
        }
    }
    //根据用户名与密码查找用户
    public User findUserByUsernameAndPassword(String user, String password) throws SQLException {
        String sql="select * from user where name=? and password=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class),user,password);
    }
    //后台系统，根据id删除用户信息
    public void deleteUser(String id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, id);
    }
    // 修改用户信息
    public void editPasswd(User p) throws SQLException {
        //1.创建集合并将商品信息添加到集合中
        List<Object> obj = new ArrayList<Object>();
        obj.add(p.getName());
        obj.add(p.getPassword());
        //2.创建sql语句，并拼接sql
        String sql  = "update user " +
                "set  name=?,password=?";
        sql += " where id=?";
        obj.add(p.getId());
        //3.创建QueryRunner对象
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        //4.使用QueryRunner对象的update()方法更新数据
        runner.update(sql, p.getName(), p.getPassword(), p.getId());
    }
    // 添加销售人员
    public void addSalesman(User user) throws SQLException {
        String sql = "insert into user(name,password,role) values(?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, user.getName(), user.getPassword(), "sale");
    }
}
