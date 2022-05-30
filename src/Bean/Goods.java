package Bean;

public class Goods {
    private static final long serialVersionUID = 1L;
    private String id; // 货物编号
    private String name; // 商品名称
    private String price; // 商品价格
    private int num; // 商品库存
    private String description; // 商品描述
    private int sellnum; //已售出的商品数量
    private String picURL; //商品图片地址
    private String kind; //商品种类
    private String idofsalesman; //商品所属销售员id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSellnum() {
        return sellnum;
    }

    public void setSellnum(int num) {
        this.sellnum = num;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getIdofsalesman() {
        return idofsalesman;
    }

    public void setIdofsalesman(String idofsalesman) {
        this.idofsalesman = idofsalesman;
    }
}
