package service;

import Dao.GoodsDao;
import Bean.Goods;
import exception.AddGoodsException;

import java.sql.SQLException;

public class BoardService {
    private GoodsDao dao = new GoodsDao();
    public void addProduct(Goods p) throws AddGoodsException {
        try {
            dao.addProduct(p);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AddGoodsException("添加商品失败");
        }
    }
}
