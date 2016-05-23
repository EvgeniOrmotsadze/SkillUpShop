package ge.evgo.shop.controller.servlets;

import ge.evgo.shop.ejb.ProductBeanDao;
import ge.evgo.shop.model.Product;

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
@WebServlet(name = "ProductDetail")
public class ProductDetail extends HttpServlet {

    @EJB
    ProductBeanDao productBeanDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (request.getParameter("id"));
        Product product = productBeanDao.getElementById(id);
        request.getSession().setAttribute("Product",product);
        response.sendRedirect("front-end/details.jsp");
    }
}
