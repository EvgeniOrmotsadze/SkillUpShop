package ge.evgo.shop.ejb;

import ge.evgo.shop.model.Image;
import ge.evgo.shop.model.Product;
import ge.evgo.shop.model.ProductType;
import javassist.NotFoundException;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by root_pc on 4/23/2016.
 */

@Stateless
public class ProductTypeDaoImpl implements ProductTypeBeanDao {

    @PersistenceContext(unitName = "shop")
    EntityManager entityManager;


    public ProductType saveProductType(String productType) {
        ProductType productT = null;
        try {
             productT = entityManager.createNamedQuery("findProductType", ProductType.class)
                    .setParameter("name", productType).getSingleResult();
            return productT;
        }catch (Exception ex){
            productT = new ProductType();
            productT.setName(productType);
            entityManager.persist(productT);
            System.out.println("not find product");
        }
        return  productT;
    }

    public List<ProductType> getAllProductType() {
        List<ProductType> productTypes = entityManager.createNamedQuery("getAllProductType",ProductType.class).getResultList();
        return productTypes;
    }

    public List<Product> getProductsById(String id) {
        ProductType productType = entityManager.createNamedQuery("getProductById",ProductType.class)
                                    .setParameter("id", Integer.parseInt(id)).getSingleResult();
        return productType.getProduct();
    }

    public void updateProductType(ProductType productType) {
        entityManager.merge(productType);
    }
}
