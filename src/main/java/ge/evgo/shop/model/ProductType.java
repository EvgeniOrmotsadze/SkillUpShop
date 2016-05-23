package ge.evgo.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eormotsadze on 4/18/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name="findProductType",
                query= "FROM ProductType e " +
                        "WHERE e.name = :name"),
        @NamedQuery(name = "getAllProductType",
                query = "From ProductType e"),
        @NamedQuery(name = "getProductById",
                query = "FROM ProductType e WHERE e.id = :id"
        )
})
public class ProductType implements Serializable{


    private int id;

    private String name;

    private List<Product> product = new ArrayList<Product>();

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
