package service;

import Utils.CSVUtil;
import model.Product;

import java.util.*;
import java.lang.String;

public class ProductService implements InterProductService {
    // thiết kế mảng arraylist theo kiểu singleton
    // tạo duy nhất 1 đường dẫn đến file sủ dụng đọc, ghi cho sản phẩm (product)
    public static final String PRODUCT_FILE = "C:\\Users\\Gin\\Desktop\\ProjectM2\\Case2\\data\\products.csv";
    public static Scanner scanner = new Scanner(System.in);
    private static ProductService instance;
    public ProductService(){}
    //tạo phương thức getInstance để khởi tạo instance theo kiếu singleton, tạo ra 1 đối tượng duy nhất của lớp,
    //Sau được sử dụng...
    public static ProductService getInstance(){
        if (instance==null)
            instance = new ProductService();
        return instance;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        List<String> dataProductLines = CSVUtil.reads(PRODUCT_FILE);
        for (String dataProducLine : dataProductLines){
            productList.add(Product.parseProduct(dataProducLine));
        }
        return productList;
    }

    @Override
    public void findByProductName(String productName) {
        List<Product> list = findAll();
        for (Product p : list){
            if (p.getNameProduct().toLowerCase().equals(productName.toLowerCase())){
                System.out.println(p.getNameProduct());//in ra thông tin product
            }
        }
    }

    @Override
    public void findByProductID(long productID) {
        List<Product> list = findAll();
        for (Product p : list){
            if (p.getId() == productID){
                System.out.println(p.getId()); // in ra thông tin sản phẩm
            }
        }
    }

    @Override
    public boolean isIDExist(long productID) {
        List<Product> list = findAll();
        for (Product p : list){
            if (p.getId() == productID){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addProduct(Product product) {
        List<Product> listProduct = findAll();
        //CSVUtil.writes(PRODUCT_FILE, listProduct.add(product));
    }

    @Override
    public void editProduct(Product product) {
        List<Product> list = findAll();
        //for (Product p : list){

        //}
    }

    @Override
    public void removeProductByProductID(long productID) {
        List<Product> list = findAll();
        for (Product p : list){
            if (p.getId() == productID)
                list.remove(p);
        }
        CSVUtil.writes(PRODUCT_FILE, list);
    }

    @Override
    public void removeProductByProductName(String productName) {
        List<Product> list = findAll();
        for (Product p : list){
            if (p.getNameProduct().toLowerCase().equals(productName.toLowerCase())){
                list.remove(p);
            }
        }
        CSVUtil.writes(PRODUCT_FILE, list);
    }

    @Override
    public void sortByProductNameAtoZ() {
        List<Product> list = findAll();
        Collections.sort(list, new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getNameProduct().compareTo(o2.getNameProduct()) > 0)
                    return 1;
                else if (o1.getNameProduct().compareTo(o2.getNameProduct()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        CSVUtil.writes(PRODUCT_FILE, list);
    }

    @Override
    public void sortByProductNameZtoA() {
        List<Product> list = findAll();
        Collections.sort(list, new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getNameProduct().compareTo(o2.getNameProduct())<0)
                    return 1;
                else if (o1.getNameProduct().compareTo(o2.getNameProduct()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        CSVUtil.writes(PRODUCT_FILE, list);
    }

    @Override
    public void sortByProductPricesIncrease() {
        List<Product> list = findAll();
        Collections.sort(list, new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrices()>o2.getPrices())
                    return 1;
                else if (o1.getNameProduct().compareTo(o2.getNameProduct()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        CSVUtil.writes(PRODUCT_FILE, list);
    }

    @Override
    public void sortByProductPricesDecrease() {
        List<Product> list = findAll();
        Collections.sort(list, new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrices()<o2.getPrices())
                    return 1;
                else if (o1.getNameProduct().compareTo(o2.getNameProduct()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        CSVUtil.writes(PRODUCT_FILE, list);
    }
}
