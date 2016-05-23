package ge.evgo.shop.model;

import javax.persistence.*;

/**
 * Created by eormotsadze on 4/18/2016.
 */

@Entity
public class Image {



    private long id;

    private String  imageName;

   /* private Long product_id;*/


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

   /* public Long getProductId() {
        return product_id;
    }

    public void setProductId(Long productId) {
        this.product_id = productId;
    }*/


}
