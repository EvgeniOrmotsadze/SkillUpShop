package ge.evgo.shop.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eormotsadze on 4/18/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name="getAllProduct",
                query= "FROM Product e"),
        @NamedQuery(name="findById",
                query= "FROM Product e " +
                        "WHERE e.id = :id")
})
@XmlRootElement(name = "product")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Product {


    private long id;


    @XmlTransient
    private ProductType productType;
/*

    private List<Users> user;
*/
    @XmlElement
    private double price;

    @XmlElement
    private String model;

    @XmlElement
    private String title;

    @XmlElement
    private int quantity;


    @XmlTransient
    private List<Image> images = new ArrayList<Image>();

    @XmlElement
    private String description;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;

    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   /* @ManyToMany
    public List<Users> getUser() {
        return user;
    }

    public void setUser(List<Users> user) {
        this.user = user;
    }*/



    @ManyToOne
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
