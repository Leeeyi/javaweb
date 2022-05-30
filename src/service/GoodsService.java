package service;
import java.sql.SQLException;
import java.util.List;
import Dao.GoodsDao;
import Bean.Goods;
import exception.AddGoodsException;
import exception.FindGoodsByIdException;
import exception.ListGoodsException;
public class GoodsService {
    private GoodsDao dao = new GoodsDao();
    // 添加商品
    public void addProduct(Goods p) throws AddGoodsException {
        try {
            dao.addProduct(p);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AddGoodsException("添加商品失败");
        }
    }
    // 查找所有商品信息
    public List<Goods> listAll() throws ListGoodsException {
        try {
            return dao.listAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ListGoodsException("查询商品失败");
        }
    }

    // 根据id查找商品
    public Goods findGoodsById(String id) throws FindGoodsByIdException {
        try {
            return dao.findGoodsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FindGoodsByIdException("根据ID查找商品失败");
        }
    }

    // 修改商品信息
    public void editProduct(Goods p) {
        try {
            dao.editProduct(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //后台系统，根据id删除商品信息
    public void deleteProduct(String id) {
        try {
            dao.deleteProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException("后台系统根据id删除商品信息失败！");
        }
    }
}
