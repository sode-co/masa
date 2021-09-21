<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ page
import="com.devlogs.masa_backend.common.Masa"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Login</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link
      href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css"
      rel="stylesheet"
    />
  </head>
  <body>
    <nav class="navbar">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">
            <img
              src="../shared/icon/weblogo.svg"
              alt="Logo"
              width="100%"
              height="100%"
            />
          </a>
        </div>
        <ul class="nav navbar-nav navbar-right">
          <li class="active"><a href="#">Home</a></li>
          <li class="no-underline hover:underline ...">
            <a href="#">About us</a>
          </li>
          <li class="no-underline hover:underline ...">
            <a href="#">Contact</a>
          </li>
        </ul>
      </div>
    </nav>

    <div class="container">
      <img src="./hello.jpg" alt="Welcome banner" width="100%" height="100%" />
    </div>
  </body>
</html>
