package ge.evgo.shop.controller.servlets;

import ge.evgo.shop.ejb.ProductBeanDao;
import ge.evgo.shop.model.Product;
import ge.evgo.shop.model.Users;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by root_pc on 4/23/2016.
 */
@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {

    @EJB
    ProductBeanDao productBeanDao;

    public ProductServlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        JSONObject json = new JSONObject();
        try {
            List<Product> products = productBeanDao.getAllProduct();
            for(int i = 0; i < products.size(); i ++) {

                json.put("finish", "success");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        response.setContentType("application/json");
        response.getWriter().write(json.toString());
    }
}
