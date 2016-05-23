package ge.evgo.shop.controller.servlets;

import ge.evgo.shop.ejb.ProductBeanDao;
import ge.evgo.shop.ejb.ProductTypeBeanDao;
import ge.evgo.shop.model.Product;
import ge.evgo.shop.model.ProductType;
import ge.evgo.shop.model.utils.Utils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by eormotsadze on 4/22/2016.
 */
@WebServlet(name = "DispatcherServlet")
public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    ProductBeanDao productBeanDao;

    @EJB
    ProductTypeBeanDao productTypeBeanDao;

    public DispatcherServlet(){
        super();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        System.out.println(page);

        List<Product> products =  productBeanDao.getAllProduct();
        List<ProductType> productTypes = productTypeBeanDao.getAllProductType();
        System.out.println(products.size());
        if(page == null){
            response.sendRedirect("front-end/error.jsp");
        }
        if(page.equals(Utils.HOME) || page.equals(Utils.PRODUCT)){
            request.getSession().setAttribute("products",products);
            request.getSession().setAttribute("productTypes",productTypes);
            response.sendRedirect("front-end/index.jsp");
        }else if(page.equals(Utils.MY_ACCOUNT)){
            response.sendRedirect("front-end/myaccount.jsp");
        }else if(page.equals(Utils.SING_UP)) {
            response.sendRedirect("front-end/singup.jsp");
        } else if(page.equals(Utils.SING_IN)){
            response.sendRedirect("front-end/singin.jsp");
        }else if(page.equals(Utils.CONTACT)){
            response.sendRedirect("front-end/contact.jsp");
        }else {
            response.sendRedirect("error.jsp");
        }


    }
}
