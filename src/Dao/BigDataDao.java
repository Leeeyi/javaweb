package Dao;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import Bean.UserBigData;
import Bean.OrderBigdata;
import utils.DataSourceUtils;

public class BigDataDao {
    // 添加商品
    public void addUserBigdata(UserBigData p) throws SQLException {
        String sql = "insert into userBigdata(id,name,loginTime,logoutTime,ip) values(?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, p.getId(), p.getName(), p.getLoginTime(), p.getLogoutTime(), p.getIp());
    }

    public void addOrderBigdata(OrderBigdata p) throws SQLException {
        String sql = "insert into orderBigdata(userid,kind,date,price) values(?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, p.getId(), p.getKind(), p.getDate(), p.getPrice());
    }
}
