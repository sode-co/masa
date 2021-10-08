<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/8/2021
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

  <style>
    @use postcss-preset-env {
      stage: 0;
    }

    /* config.css */

    :root {
      --baseColor: #606468;
    }

    /* helpers/align.css */

    .align {
      display: grid;
      place-items: center;
    }

    .grid {
      inline-size: 90%;
      margin-inline: auto;
      max-inline-size: 20rem;
    }

    /* helpers/hidden.css */

    .hidden {
      border: 0;
      clip: rect(0 0 0 0);
      height: 1px;
      margin: -1px;
      overflow: hidden;
      padding: 0;
      position: absolute;
      width: 1px;
    }

    /* helpers/icon.css */

    :root {
      --iconFill: var(--baseColor);
    }

    .icons {
      display: none;
    }

    .icon {
      block-size: 1em;
      display: inline-block;
      fill: var(--iconFill);
      inline-size: 1em;
      vertical-align: middle;
    }

    /* layout/base.css */

    :root {
      --htmlFontSize: 100%;

      --bodyBackgroundColor: #2c3338;
      --bodyColor: var(--baseColor);
      --bodyFontFamily: "Open Sans";
      --bodyFontFamilyFallback: sans-serif;
      --bodyFontSize: 0.875rem;
      --bodyFontWeight: 400;
      --bodyLineHeight: 1.5;
    }

    * {
      box-sizing: inherit;
    }

    html {
      box-sizing: border-box;
      font-size: var(--htmlFontSize);
    }

    body {
      background-color: var(--bodyBackgroundColor);
      color: var(--bodyColor);
      font-family: var(--bodyFontFamily), var(--bodyFontFamilyFallback);
      font-size: var(--bodyFontSize);
      font-weight: var(--bodyFontWeight);
      line-height: var(--bodyLineHeight);
      margin: 0;
      min-block-size: 100vh;
    }

    /* modules/anchor.css */

    :root {
      --anchorColor: #eee;
    }

    a {
      color: var(--anchorColor);
      outline: 0;
      text-decoration: none;
    }

    a:focus,
    a:hover {
      text-decoration: underline;
    }

    /* modules/form.css */

    :root {
      --formGap: 0.875rem;
    }

    input {
      background-image: none;
      border: 0;
      color: inherit;
      font: inherit;
      margin: 0;
      outline: 0;
      padding: 0;
      transition: background-color 0.3s;
    }

    input[type="submit"] {
      cursor: pointer;
    }

    .form {
      display: grid;
      gap: var(--formGap);
    }

    .form input[type="password"],
    .form input[type="text"],
    .form input[type="submit"] {
      inline-size: 100%;
    }

    .form__field {
      display: flex;
    }

    .form__input {
      flex: 1;
    }

    /* modules/login.css */

    :root {
      --loginBorderRadus: 0.25rem;
      --loginColor: #eee;

      --loginInputBackgroundColor: #3b4148;
      --loginInputHoverBackgroundColor: #434a52;

      --loginLabelBackgroundColor: #363b41;

      --loginSubmitBackgroundColor: #ea4c88;
      --loginSubmitColor: #eee;
      --loginSubmitHoverBackgroundColor: #de2f72;
    }

    .login {
      color: var(--loginColor);
    }

    .login label,
    .login input[type="text"],
    .login input[type="password"],
    .login input[type="submit"] {
      border-radius: var(--loginBorderRadus);
      padding: 1rem;
    }

    .login label {
      background-color: var(--loginLabelBackgroundColor);
      border-bottom-right-radius: 0;
      border-top-right-radius: 0;
      padding-inline: 1.25rem;
    }

    .login input[type="password"],
    .login input[type="text"] {
      background-color: var(--loginInputBackgroundColor);
      border-bottom-left-radius: 0;
      border-top-left-radius: 0;
    }

    .login input[type="password"]:focus,
    .login input[type="password"]:hover,
    .login input[type="text"]:focus,
    .login input[type="text"]:hover {
      background-color: var(--loginInputHoverBackgroundColor);
    }

    .login input[type="submit"] {
      background-color: var(--loginSubmitBackgroundColor);
      color: var(--loginSubmitColor);
      font-weight: 700;
      text-transform: uppercase;
    }

    .login input[type="submit"]:focus,
    .login input[type="submit"]:hover {
      background-color: var(--loginSubmitHoverBackgroundColor);
    }

    /* modules/text.css */

    p {
      margin-block: 1.5rem;
    }

    .text--center {
      text-align: center;
    }

  </style>


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

<body class="align">
<div class="grid" style="width: 1000px">
  <form class="form login">

    <div class="form__field">
      <label for="description"><svg class="icon">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-card-list" viewBox="0 0 16 16">
          <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
          <path d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm-1-5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zM4 8a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zm0 2.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0z"/>
        </svg></label>
      <input id="description" type="text" name="username" class="form__input" placeholder="Why do you want become mentor...?" required>
    </div>

    <div class="form__field">
      <label for="description">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-link-45deg" viewBox="0 0 16 16">
          <path d="M4.715 6.542 3.343 7.914a3 3 0 1 0 4.243 4.243l1.828-1.829A3 3 0 0 0 8.586 5.5L8 6.086a1.002 1.002 0 0 0-.154.199 2 2 0 0 1 .861 3.337L6.88 11.45a2 2 0 1 1-2.83-2.83l.793-.792a4.018 4.018 0 0 1-.128-1.287z"/>
          <path d="M6.586 4.672A3 3 0 0 0 7.414 9.5l.775-.776a2 2 0 0 1-.896-3.346L9.12 3.55a2 2 0 1 1 2.83 2.83l-.793.792c.112.42.155.855.128 1.287l1.372-1.372a3 3 0 1 0-4.243-4.243L6.586 4.672z"/>
        </svg>
      </label>
      <input id="zoomUrl" type="text" name="username" class="form__input" placeholder="Your zoom url here..." required>
    </div>

    <div class="form__field">
      <label for="description"><svg class="icon">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-link-45deg" viewBox="0 0 16 16">
          <path d="M4.715 6.542 3.343 7.914a3 3 0 1 0 4.243 4.243l1.828-1.829A3 3 0 0 0 8.586 5.5L8 6.086a1.002 1.002 0 0 0-.154.199 2 2 0 0 1 .861 3.337L6.88 11.45a2 2 0 1 1-2.83-2.83l.793-.792a4.018 4.018 0 0 1-.128-1.287z"/>
          <path d="M6.586 4.672A3 3 0 0 0 7.414 9.5l.775-.776a2 2 0 0 1-.896-3.346L9.12 3.55a2 2 0 1 1 2.83 2.83l-.793.792c.112.42.155.855.128 1.287l1.372-1.372a3 3 0 1 0-4.243-4.243L6.586 4.672z"/>
        </svg>
      </label>
      <input autocomplete="Why do you want become mentor...?" id="googleMeetUrl" type="text" name="username" class="form__input" placeholder="Your meet url here..." required>
    </div>



    <div>
<%--      <input type="submit" value="BECOME MENTOR" onclick="becomeMentor()">--%>
      <button onclick="becomeMentor()" style="font-size: 16px; background-color: #d21155; color: white; border-color: #d21155; height: 50px; width: 400px; border-radius: 10px">BECOME MENTOR</button>
    </div>

  </form>

  <p class="text--center">Continue exploring? <a href="/masa/member/meeting/index.jsp">Home</a> <svg class="icon">
    <use xlink:href="#icon-arrow-right"></use>
  </svg></p>
  <p class="text--center">Already done? <a href="/masa/auth-management/signout">Logout</a> <svg class="icon">
    <use xlink:href="#icon-arrow-right"></use>
  </svg></p>

</div>

<svg xmlns="http://www.w3.org/2000/svg" class="icons">
  <symbol id="icon-arrow-right" viewBox="0 0 1792 1792">
    <path d="M1600 960q0 54-37 91l-651 651q-39 37-91 37-51 0-90-37l-75-75q-38-38-38-91t38-91l293-293H245q-52 0-84.5-37.5T128 1024V896q0-53 32.5-90.5T245 768h704L656 474q-38-36-38-90t38-90l75-75q38-38 90-38 53 0 91 38l651 651q37 35 37 90z" />
  </symbol>
  <symbol id="icon-lock" viewBox="0 0 1792 1792">
    <path d="M640 768h512V576q0-106-75-181t-181-75-181 75-75 181v192zm832 96v576q0 40-28 68t-68 28H416q-40 0-68-28t-28-68V864q0-40 28-68t68-28h32V576q0-184 132-316t316-132 316 132 132 316v192h32q40 0 68 28t28 68z" />
  </symbol>
  <symbol id="icon-user" viewBox="0 0 1792 1792">
    <path d="M1600 1405q0 120-73 189.5t-194 69.5H459q-121 0-194-69.5T192 1405q0-53 3.5-103.5t14-109T236 1084t43-97.5 62-81 85.5-53.5T538 832q9 0 42 21.5t74.5 48 108 48T896 971t133.5-21.5 108-48 74.5-48 42-21.5q61 0 111.5 20t85.5 53.5 62 81 43 97.5 26.5 108.5 14 109 3.5 103.5zm-320-893q0 159-112.5 271.5T896 896 624.5 783.5 512 512t112.5-271.5T896 128t271.5 112.5T1280 512z" />
  </symbol>
</svg>

</body>
</html>
