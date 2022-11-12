package model;

import Utils.DateUtil;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Product {
    private long id;
    private String nameProduct;
    private float prices;
    private int quantitys;
    private Date createAt;
    private Instant updateAt;
    private String madeIn;
    public Product(){}
    public Product(long id, String nameProduct, float prices, int quantitys, String madeIn, Date createAt, Instant updateAt){
        this.id = id;
        this.nameProduct = nameProduct;
        this.prices = prices;
        this.quantitys = quantitys;
        this.madeIn = madeIn;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public double getPrices() {
        return prices;
    }
    public void setPrices(float prices) {
        this.prices = prices;
    }
    public int getQuantitys() {
        return quantitys;
    }
    public void setQuantitys(int quantitys) {
        this.quantitys = quantitys;
    }
    public String getMadeIn() {
        return madeIn;
    }
    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }
    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    public Instant getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }
    public static Product parseProduct(String productListLine){
        //thao tác lấy 1 chuổi String đọc lên ở dạng "%f,%s,%f,%d,%s,%s,%s",
        //                            this.id,
        //                            this.nameProduct,
        //                            this.prices,
        //                            this.quantitys,
        //                            this.madeIn,
        //                            this.createAt,
        //                            this.updateAt
        //split thành mảng rồi bóc ra từn thành phần, gán vào lại khai báo product để tạo new product
        String[] productListArray = productListLine.split(",");
        long id = Long.parseLong(productListArray[0]);
        String productName = productListArray[1];
        float productPrices = Float.parseFloat(productListArray[2]);
        int productQuantitys = Integer.parseInt(productListArray[3]);
        String madeIn = productListArray[4];
        //chưa viết format từ date, intance sang String để viết methor toString;
        DateUtil dateUtil = new DateUtil();
        Date createAt = dateUtil.formatStringToDate(productListArray[5]);
        Instant updateAt = Instant.parse(productListArray[6]);
        //Product(long id, String nameProduct, double prices, int quantitys,
        //        String madeIn, Date createAt, Instant updateAt)
        Product p = new Product(id, productName,productPrices,productQuantitys,madeIn,createAt,updateAt);
        return p;
    }

    @Override
    public String toString() {
        //Product(long id, String nameProduct, double prices, int quantitys,
        // String madeIn, Date createAt, Instant updateAt)
        DateUtil dateUtil = new DateUtil();
        String stringCreatAt = dateUtil.formatDate(this.createAt);
        String stringUpdateAt = dateUtil.formatIntance(this.updateAt);
        return String.format("%f,%s,%f,%d,%s,%s,%s",
                this.id,
                this.nameProduct,
                this.prices,
                this.quantitys,
                this.madeIn,
                stringCreatAt,
                stringUpdateAt);
    }
}
