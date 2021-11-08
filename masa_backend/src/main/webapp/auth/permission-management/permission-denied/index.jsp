<%--
  Created by IntelliJ IDEA.
  User: dangminhtien
  Date: 22/09/2021
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.devlogs.masa_backend.common.Masa" %>

<html>
<head>
    <title>Title</title>
    <link href="${Masa.SERVER_HOST}/shared/styles/auth/permission-denied/style.css" rel="stylesheet" type="text/css"/>
    <%@include file="../../../shared/gg_analytics/_analytics_script"%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        #signoutbtn{
            background-color: transparent; height: 50px; width: 100px; font-size: 15px; border-radius: 10px; border-color: black;
        }
        a :hover{
            background-color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>
    
    <div id="clouds">
        <div class="cloud x1"></div>
        <div class="cloud x1_5"></div>
        <div class="cloud x2"></div>
        <div class="cloud x3"></div>
        <div class="cloud x4"></div>
        <div class="cloud x5"></div>
    </div>
<header id="header">
<div class="main_nav">
<div class="container">
  <div class="mobile-toggle"> <span></span> <span></span> <span></span> </div>
</div>
</div>
<div class="title">
<h1 class="heading">SORRY</h1>
<h2 class="heading">You do not have permission to access this page!</h2>
    <div class="smallsep heading"></div>


    <div class="relative w-full mx-auto mt-4 mb-4 overflow-hidden">
        <a href="${Masa.SERVER_HOST}/auth-management/signout" style="text-decoration: none;">
        <button id="signoutbtn" class="inline-flex items-center px-4 py-2 font-bold text-white bg-indigo hover:bg-indigo-dark" style=" ">
            Sign out <i class="fa fa-sign-out" aria-hidden="true"></i>
        </button>
        </a>

    </div>


</a> </div>
</header>


    </div>
</body>
</html>
