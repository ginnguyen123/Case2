package service;

import model.Product;

import java.util.List;

public interface InterProductService {
    List<Product> findAll(); //khởi tạo 1 mảng duy nhất chứa product được đọc lên từ ghi chứa data product
    void findByProductName(String productName);
    void findByProductID(long productID);
    boolean isIDExist(long productID);
    void addProduct(Product product);
    void editProduct(Product product);
    void removeProductByProductID(long productID);
    void removeProductByProductName(String productName);
    void sortByProductNameAtoZ();
    void sortByProductNameZtoA();
    void sortByProductPricesIncrease();
    void sortByProductPricesDecrease();
}
