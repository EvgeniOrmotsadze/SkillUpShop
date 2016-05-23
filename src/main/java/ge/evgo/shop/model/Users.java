package ge.evgo.shop.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eormotsadze on 4/18/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name="findUsers",
                query= "FROM Users e " +
                        "WHERE e.name = :name AND " +
                        "e.password = :pass")

})
public class Users {


    private long id;

    private String name;

    private String password;

    private String phone;

    private String email;

    private Double cash;

    private List<Product> products = new ArrayList<Product>();

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String lastName) {
        this.phone = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", products=" + products +
                '}';
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
