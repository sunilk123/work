package Controller;

import BuisnessLayer.UserBuisnessLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by SUNIL PC on 28-07-2017.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/Controller/Login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("usrname");
        String password=request.getParameter("password");
        int userid=(new UserBuisnessLogic()).CheckCredentials(username,password);
        HttpSession session=request.getSession();
        if(userid==1) {
            session.setAttribute("message",userid);
            response.sendRedirect("/Views/index.jsp");

        }
        else{

            session.setAttribute("LOGGEDIN",userid);
            response.sendRedirect("/Views/Menu.jsp");
        }




    }
}
