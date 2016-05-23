package ge.evgo.shop.controller.ws.rest.service;

import ge.evgo.shop.ejb.ProductBeanDao;
import ge.evgo.shop.model.Product;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eormotsadze on 4/20/2016.
 */


@Path("/products")
@Stateless
public class RestService {

    @EJB
    ProductBeanDao productBeanDao;

    @GET
    @Produces("application/xml")
    public List<Product> getAllMProducts() {

        List<Product> products = productBeanDao.getAllProduct();

        if(products == null){
            products = new ArrayList<Product>();
        }
        return products;

    }



}
