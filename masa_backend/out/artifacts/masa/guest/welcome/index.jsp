<%--
  Created by IntelliJ IDEA.
  User: dangminhtien
  Date: 17/09/2021
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.devlogs.masa_backend.common.Masa"%>
<html>
<head>
    <link rel="shortcut icon" href="${Masa.ICON_URL}"/>

    <title>Welcome</title>
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script>
        function becomeMentor () {
            var xhr = new XMLHttpRequest();
            const url = `http://localhost:8080/masa/api/mentor-management/become-mentor/${CURRENT_USER.getId()}`;
            console.log('url', url);
            xhr.open("POST", url);
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    console.log(xhr.status);
                    console.log(xhr.responseText);
                }};
            const json = {
                "description": document.getElementById("description").value,
                "zoomUrl": document.getElementById("zoomUrl").value,
                "googleMeetUrl": document.getElementById("googleMeetUrl").value,
            }
            console.log('json', json);
            const data = JSON.stringify(json);
            xhr.send(data);
        }
    </script>
</head>
<body>
<body>
<!-- <h1>Hello guest</h1>
Become mentor page -->
<div class="container">
    <div class="register-form">
        <div class="main-div">
            <div class="panel">
                <h2>Hello guest</h2>
                <p>Become mentor now!</p>
            </div>
            <form id="registerForm">
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" id="description" aria-describedby="description" placeholder="Why do you want to become mentor...">
                </div>
                <div class="form-group">
                    <label for="zoomUrl">Zoom Url</label>
                    <input type="link" class="form-control" id="zoomUrl" placeholder="Your Zoom url here">
                </div>
                <div class="form-group">
                    <label for="googleMeetUrl">Google Meet Url</label>
                    <input type="link" class="form-control" id="googleMeetUrl" placeholder="Your Google Meet url here"><br>
                </div>
                <button onclick="becomeMentor()" class="btn btn-primary">Become Mentor</button>
            </form>
        </div>
    </div>
</div>
<!-- <form>
    <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description" aria-describedby="description" placeholder="Why do you want to become mentor...">
    </div>
    <div class="form-group">
        <label for="zoomUrl">Zoom Url</label>
        <input type="link" class="form-control" id="zoomUrl" placeholder="Your Zoom url here">
    </div>
    <div class="form-check">
        <label for="googleMeetUrl">Google Meet Url</label>
        <input type="link" class="form-control" id="googleMeetUrl" placeholder="Your Google Meet url here">
    </div>
    <button onclick="becomeMentor()" class="btn btn-primary">Become Mentor</button>
</form> -->
</div>

</body>
</body>
</html>
