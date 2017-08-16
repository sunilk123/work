package Controller;

import Models.CarParkException;
import Models.CarParkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.System.exit;

/**
 * Created by SUNIL PC on 20-07-2017.
 */
@WebServlet(name = "AddSlotsServlet", urlPatterns = "/Controller/AddSlots")
public class AddSlotsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int slots=0;
        try{
            slots= Integer.parseInt(request.getParameter("slots"));
            CarParkService cps=new CarParkService();
            cps.setSlots(slots);
            HttpSession session=request.getSession();
            session.setAttribute("carparkobject",cps);
            response.sendRedirect("/Views/showPark.jsp");
        }
        catch(Exception e){
            response.sendRedirect("/Views/error.jsp");
        }


    }
}
