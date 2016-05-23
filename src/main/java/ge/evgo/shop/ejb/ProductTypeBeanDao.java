package ge.evgo.shop.ejb;

import ge.evgo.shop.model.Image;
import ge.evgo.shop.model.Product;
import ge.evgo.shop.model.ProductType;

import java.util.List;

/**
 * Created by root_pc on 4/23/2016.
 */
public interface ProductTypeBeanDao {

    ProductType saveProductType(String productType);

    List<ProductType> getAllProductType();

    List<Product> getProductsById(String id);

    void updateProductType(ProductType productType);

}
