package service;
import java.sql.SQLException;
import java.util.List;

import Bean.UserBigData;
import Bean.OrderBigdata;
import Dao.BigDataDao;
import exception.AddGoodsException;
import exception.FindGoodsByIdException;
import exception.ListGoodsException;

public class BigDataService {
    private BigDataDao dao = new BigDataDao();
    public void addUserBigdata(UserBigData p) throws AddGoodsException, SQLException {
        dao.addUserBigdata(p);
    }
    public void addOrderBigdata(OrderBigdata p) throws SQLException {
        dao.addOrderBigdata(p);
    }
}
