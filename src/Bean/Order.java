package Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static final long serialVersionUID = 1L;
    private String id; // 订单编号
    private User user; // 所属用户
    private String name; // 收货人姓名
    private String address; // 收货人地址
    private String phone; // 收货人电话
    private Date time; // 下单时间
    private List<Goods> goods;
    private String GoodsName;
    private String salesmanidofgoods; //订单中商品所属的销售员id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String GoodsName) {
        this.GoodsName = GoodsName;
    }

    public String getSalesmanidofgoods() {
        return salesmanidofgoods;
    }

    public void setSalesmanidofgoods(String salesmanidofgoods) {
        this.salesmanidofgoods = salesmanidofgoods;
    }
}
