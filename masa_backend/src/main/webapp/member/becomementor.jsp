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
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <link
            href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css"
            rel="stylesheet"
    />
    <link
            rel="stylesheet"
            href="path/to/font-awesome/css/font-awesome.min.css"
    />

    <title>Welcome</title>
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <style>
        body{
            background-color: #565555;
            background-size: cover;
            height: 100vh;
            padding:0;
            margin:0;
        }
        .buttonbecome{
            background-color: pink;
        }
        .buttonbecome:hover{
            background-color: white;
        }
    </style>
    <script>
        function becomeMentor () {
            var xhr = new XMLHttpRequest();
            const url = `/masa/api/mentor-management/become-mentor/${CURRENT_USER.getId()}`;
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
                <li class="nav-item">
                    <a
                            class="
                  font-sans
                  text-2xl
                  font-semibold
                  text-gray-800
                  dark:text-gray-200 dark:hover:text-gray-200
                  hover:no-underline
                  border-b-2 border-green-800
                  mx-1.5
                  sm:mx-6
                  hover:text-gray-800
                "
                            href="#navi"
                    >
                        Home
                    </a>
                </li>
                <li class="nav-item" style="width: 80px;padding-left: 10px; background-color: #f68859; color: white; border-radius: 10px">
                    <a style="color: white; font-size: 14px; padding: 2px" href="/masa/auth-management/signout">
                        Log Out
                    </a>
                </li>



<!-- <h1>Hello guest</h1>
Become mentor page -->
<div class="container" style="margin-top: 100px">
    <div class="register-form">
        <div class="main-div">
            <div class="panel" style="background-color: #565555; color: white">
                <h1>Dear ${sessionScope.CURRENT_USER.fullName},</h1>
                <h4 style="margin-left: 200px; font-style: italic">Power is gained by sharing knowledge not hoarding it!</h4>
            </div>
            <form id="registerForm">
                <div class="form-group">
                    <label for="description" style="font-size: 14px; color: white">Description <span style="color: red">*</span></label>
                    <input type="text" class="form-control" id="description" aria-describedby="description" placeholder="Why do you want to become mentor..." style="font-size: 14px">
                </div>
                <div class="form-group">
                    <label for="zoomUrl" style="font-size: 14px; color: white">Zoom Url <span style="color: red">*</span></label>
                    <input type="link" class="form-control" id="zoomUrl" placeholder="Your Zoom url here" style="font-size: 14px">
                </div>
                <div class="form-group">
                    <label for="googleMeetUrl" style="font-size: 14px; color: white">Google Meet Url <span style="color: red">*</span></label>
                    <input type="link" class="form-control" id="googleMeetUrl" placeholder="Your Google Meet url here" style="font-size: 14px"><br>
                </div>
                <button onclick="becomeMentor()" class="btn buttonbecome">Become Mentor</button>
            </form>
        </div>
    </div>
</div>
<br/>
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
