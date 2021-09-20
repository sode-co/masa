<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ page
import="com.devlogs.masa_backend.common.Masa"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

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
  </head>
  <body>
    <nav class="navbar">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">
            <img
              src="https://i.imgur.com/2zYXfd1.png"
              alt="Logo"
              width="100%"
              height="100%"
            />
          </a>
        </div>
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#">About us</a></li>
          <li><a href="#">Contact</a></li>
        </ul>
      </div>
    </nav>
    <c:set var="redirectUrl" value="http://localhost:${pageContext.request.serverPort}/masa/logingoogle"/>
    <div class="container">
      <img
        src="https://i.imgur.com/EWj8mqZ.jpg"
        alt="Welcome banner"
        width="100%"
        height="100%"
      />
      <form
        id="googlelogin"
        method="post"
        action="https://accounts.google.com/o/oauth2/auth?"
      >
        <div>
            <input type="hidden" name="response_type" value="code" />
            <input type="hidden" name="client_id" value="${Masa.CLIENT_ID}" />
            <input type="hidden" name="redirect_uri" value="${redirectUrl}" />
            <input type="hidden" name="scope" value="email profile" />
            <input type="hidden" name="approval_prompt" value="force" />
          <input type="submit" value="Login with Google" />
        </div>
      </form>
    </div>
  </body>
</html>
