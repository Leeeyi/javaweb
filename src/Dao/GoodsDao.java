package Dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import Bean.Order;
import Bean.Goods;
import utils.DataSourceUtils;

public class GoodsDao {
    // 添加商品
    public void addProduct(Goods p) throws SQLException {
        String sql = "insert into goods(name,kind,price,num,description,picurl,idofsalesman) values(?,?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, p.getName(),p.getKind(), p.getPrice(), p.getNum(), p.getDescription(), p.getPicURL(), p.getIdofsalesman());
    }
    // 查找所有商品
    public List<Goods> listAll() throws SQLException {
        String sql = "select * from goods";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Goods>(Goods.class));
    }

    // 根据id查找商品
    public Goods findGoodsById(String id) throws SQLException {
        String sql = "select * from goods where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<Goods>(Goods.class), id);
    }

    // 生成订单时，将商品数量减少
    public void changeProductNum(Order order) throws SQLException {
        String sql = "update goods set num=num-1 where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        List<Goods> items = order.getGoods();
        for (int i = 0; i < items.size(); i++) {
            String id = items.get(i).getId();
            runner.update(sql, id);
        }
    }

    // 修改商品信息
    public void editProduct(Goods p) throws SQLException {
        //1.创建集合并将商品信息添加到集合中
        List<Object> obj = new ArrayList<Object>();
        obj.add(p.getName());
        obj.add(p.getPrice());
        obj.add(p.getNum());
        obj.add(p.getDescription());
        //2.创建sql语句，并拼接sql
        String sql  = "update goods " +
                "set  name=?,kind=?,price=?,num=?,description=?,kind=?";
        sql += " where id=?";
        obj.add(p.getId());
        //3.创建QueryRunner对象
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        //4.使用QueryRunner对象的update()方法更新数据
        runner.update(sql, p.getName(), p.getKind(), p.getPrice(), p.getNum(), p.getDescription(), p.getKind(), p.getId());
    }


    //后台系统，根据id删除商品信息
    public void deleteProduct(String id) throws SQLException {
        String sql = "DELETE FROM goods WHERE id = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, id);
    }

    public void addSellNum(Order order) throws SQLException{
        String sql = "update goods set sellnum=sellnum+1 where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        List<Goods> items = order.getGoods();
        for (int i = 0; i < items.size(); i++) {
            String id = items.get(i).getId();
            runner.update(sql, id);
        }

    }
}