package ge.evgo.shop.ejb;

import ge.evgo.shop.model.Product;
import ge.evgo.shop.model.ProductType;
import ge.evgo.shop.model.Users;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by root_pc on 4/23/2016.
 */

@Stateless
@Local
public class ProductBeanDaoImpl implements ProductBeanDao {

    @PersistenceContext(unitName = "shop")
    private EntityManager entityManager;

    public void saveProduct(Product product) {
        entityManager.persist(product);
    }

    public List<Product> getAllProduct() {
        List<Product> products = entityManager.createNamedQuery("getAllProduct", Product.class).getResultList();
        return products;
    }

    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    public Product getElementById(String id) {
        System.out.println("Product Id  : " + id );
        try {
            Product product = entityManager.createNamedQuery("findById", Product.class)
                    .setParameter("id", Long.parseLong(id)).getSingleResult();
            return product;
        } catch (Exception ex) {
            System.out.println("not found product");
        }
        return null;
    }




}
