<%@ page import="Models.CarParkService" %><%--
  Created by IntelliJ IDEA.
  User: SUNIL PC
  Date: 20-07-2017
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CarPark</title>
</head>
<body>
<article>
    <header>
        <h1>Car Parking Management</h1>
    </header>
    <section>
        <div id="show_slots">
            <label>Available Slots : </label><br/>
            <%
                CarParkService cps=(CarParkService) session.getAttribute("carparkobject");
                out.print(cps.getSlots());
            %>
        </div>
        <form action="/Controller/ParkServlet" method="get">
            <div>
                <input type="submit" value="Park"/>
            </div>
        </form>
        <form action="/Controller/LeaveServlet" method="get">
            <div>
                <input type="submit" value="Leave"/>
            </div>
        </form>
    </section>
    <header>
        <%
            if(cps.getSlots()==0)
                out.print("no parking space");
            if(cps.getLimit()==cps.getSlots())
                out.print("no car parked");
        %>
    </header>
</article>

</body>
</html>

