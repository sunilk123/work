package Controller;

import Models.CarParkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by SUNIL PC on 20-07-2017.
 */
@WebServlet(urlPatterns = "/Controller/LeaveServlet",name="LeaveServlet")
public class LeaveServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        CarParkService cps=(CarParkService)session.getAttribute("carparkobject");
        cps.Leave();
        response.sendRedirect("/Views/showPark.jsp");

    }
}
