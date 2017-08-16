<%--
  Created by IntelliJ IDEA.
  User: SUNIL PC
  Date: 20-07-2017
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
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
        <form action="/Controller/AddSlots" method="get">
          <div>
          <label for="slots">Enter the number of Slots</label>
          <input type="text" name="slots" id="slots"/>
          </div>
          <div>
            <input type="submit" />
          </div>
        </form>
      </section>
    </article>

    </body>
</html>
