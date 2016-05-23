package ge.evgo.shop.controller.servlets;

import ge.evgo.shop.ejb.ProductBeanDao;
import ge.evgo.shop.ejb.ProductTypeBeanDao;
import ge.evgo.shop.model.Product;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by root_pc on 4/26/2016.
 */
@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {

    @EJB
    ProductTypeBeanDao productTypeBeanDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        System.out.println("search id " + type);
        if(type != null){
            List<Product> products = productTypeBeanDao.getProductsById(type);
            request.getSession().setAttribute("products",products);
            response.sendRedirect("front-end/index.jsp");
        }
    }
}
