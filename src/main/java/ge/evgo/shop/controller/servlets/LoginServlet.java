package ge.evgo.shop.controller.servlets;

import ge.evgo.shop.ejb.UserBeanDao;
import ge.evgo.shop.model.Users;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eormotsadze on 4/18/2016.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    UserBeanDao userBeanDao;

    @Inject
    private JMSContext context;

    @Resource(mappedName = "java:/queue/LoginQueue")
    private Queue queue;

    public LoginServlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (request.getParameter("name"));
        String password = (request.getParameter("password"));

        Destination destination = queue;



        System.out.println(name);
        System.out.println(password);
        Users user = userBeanDao.findUser(name,password);
        if(user != null) {
            String msg = "login user : " + user.toString();
            context.createProducer().send(destination, msg);
            request.getSession().setAttribute("user",user);
            response.sendRedirect("front-end/index.jsp");
        }else{
            context.createProducer().send(destination, "login user : not found");
            response.sendRedirect("front-end/singin.jsp");
        }

    }
}
