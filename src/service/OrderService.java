package service;
import java.sql.SQLException;
import Dao.OrderDao;
import Dao.GoodsDao;
import Bean.Order;
import utils.DataSourceUtils;
public class OrderService {
    private OrderDao odao = new OrderDao();
    private GoodsDao gdao = new GoodsDao();
    // 1.添加订单
    public void addOrder(Order order) {
        try {
            // 1.开启事务
            DataSourceUtils.startTransaction();
            // 2.完成操作
            // 2.1向orders表中添加数据
            odao.addProduct(order);
            // 2.2修改商品表中数据.
            gdao.changeProductNum(order);
            gdao.addSellNum(order);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                DataSourceUtils.rollback(); // 事务回滚
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                // 关闭，释放以及提交事务
                DataSourceUtils.releaseAndCloseConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //根据id删除订单 管理员删除订单
    public void delOrder(String id) {
        try {
            DataSourceUtils.startTransaction();//开启事务
            odao.delOrderById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                DataSourceUtils.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally{
            try {
                DataSourceUtils.releaseAndCloseConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}