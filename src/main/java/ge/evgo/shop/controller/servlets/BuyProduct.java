package ge.evgo.shop.controller.servlets;

import ge.evgo.shop.ejb.ProductBeanDao;
import ge.evgo.shop.ejb.UserBeanDao;
import ge.evgo.shop.model.Product;
import ge.evgo.shop.model.Users;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root_pc on 4/25/2016.
 */
@WebServlet(name = "BuyProduct")
public class BuyProduct extends HttpServlet {

    @EJB
    UserBeanDao userBeanDao;

    @EJB
    ProductBeanDao productBeanDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        Users user = (Users)request.getSession().getAttribute("user");
        if(user == null){
            response.sendRedirect("front-end/singin.jsp");
        }else{
            Product product = productBeanDao.getElementById(id);
            product.setQuantity(product.getQuantity()-1);
            productBeanDao.updateProduct(product);
            user.getProducts().add(product);
            user.setCash(user.getCash() - product.getPrice());
            userBeanDao.updateUser(user);
            request.getSession().setAttribute("user",user);
            response.sendRedirect("front-end/myaccount.jsp");
        }

    }
}
