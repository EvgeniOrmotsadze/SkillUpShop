package ge.evgo.shop.controller.servlets;

import ge.evgo.shop.ejb.UserBeanDao;
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

/**
 * Created by eormotsadze on 4/22/2016.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @EJB
    UserBeanDao userBeanDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (request.getParameter("name"));
        String password = (request.getParameter("password"));
        String email = (request.getParameter("email"));
        String phone = (request.getParameter("phone"));
        JSONObject json = new JSONObject();
        try {
            Users u = new Users();
            u.setName(name);
            u.setPassword(password);
            u.setEmail(email);
            u.setPhone(phone);
            userBeanDao.saveUser(u);
            json.put("finish", "success");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        response.setContentType("application/json");
        response.getWriter().write(json.toString());
    }
}
