package ge.evgo.shop.ejb;

import ge.evgo.shop.model.Users;

/**
 * Created by eormotsadze on 4/22/2016.
 */


public interface UserBeanDao {


    void saveUser(Users user);

    void removeUser(Users user);

    Users findUser(String name,String password);

    void updateUser(Users user);



}
