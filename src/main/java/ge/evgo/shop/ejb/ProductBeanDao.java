package ge.evgo.shop.ejb;

import ge.evgo.shop.model.Product;
import ge.evgo.shop.model.ProductType;

import java.util.List;

/**
 * Created by root_pc on 4/23/2016.
 */
public interface ProductBeanDao {

    void saveProduct(Product product);

    List<Product> getAllProduct();

    void updateProduct(Product product);

    Product getElementById(String id);






}
