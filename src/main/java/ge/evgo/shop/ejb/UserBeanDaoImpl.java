package ge.evgo.shop.ejb;

import ge.evgo.shop.model.Users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by eormotsadze on 4/22/2016.
 */



@Stateless
public class UserBeanDaoImpl implements UserBeanDao {


    @PersistenceContext(unitName = "shop")
    private EntityManager entityManager;

    public void saveUser(Users user) {
        user.setCash(500.0);
        entityManager.persist(user);
    }

    public void removeUser(Users user) {
        entityManager.remove(user);
    }

    public Users findUser(String name, String password) {
        try {
            Users user = entityManager.createNamedQuery("findUsers", Users.class)
                    .setParameter("name", name)
                    .setParameter("pass", password)
                    .getSingleResult();

            return user;
        }catch (Exception ex){
           // System.out.println("Not Found user");
            return null;
        }
    }

    public void updateUser(Users user) {
        entityManager.merge(user);
    }
}
