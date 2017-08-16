<%--
  Created by IntelliJ IDEA.
  User: SUNIL PC
  Date: 28-07-2017
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <title>Login_Page</title>
  <link rel="stylesheet" href="css/Styles.css" type="text/css"/>
  <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
</head>
<body>
<article>
  <header>
    <h1>Car Parking Management</h1>
  </header>
  <section class="SectionLogin">
    <div class="container-fluid" >
      <div class="row align-items-center">
        <div class="col-md-1"></div>
        <div class="col-md-4">

          <form name="Login_Page" action="/Controller/Login" method="post" >
            <h3>Login</h3>
            <div class="form-group">
              <label for="usrname">User Name</label>
              <input type="text" name="usrname" id="usrname" class="form-control"/>
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input type="password" name="password" id="password" class="form-control"/>
            </div>
            <div>
              <input type="submit" value="Submit"  class="btn btn-primary button"/>
              <input type="reset" value="Reset" class="btn btn-default button"/>
            </div>
            <div>
              <%
                if(session.getAttribute("message")!=null) {
                  out.print(session.getAttribute("message").toString());
                }
              %>
            </div>
            <div class="link">
              <a href="RegisterForm.html" >New User</a>
            </div>

          </form>
        </div>
        <div class="col-md-7"></div>
      </div>
    </div>
  </section>

</article>
<footer>
</footer>

</body>
</html>