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
        <button class="inline-flex items-center px-4 py-2 font-bold text-white bg-indigo hover:bg-indigo-dark">
            <svg class="w-20 h-20" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">

                <path

                    stroke-linecap="round"

                    stroke-linejoin="round"

                    stroke-width="2"

                    d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1"

                ></path>

            </svg>
            <span class="text-4xl ml-7">SIGN OUT</span>
        </button>
    </div>


</a> </div>
</header>


    </div>

    <!-- <h1>
        You do not have permission to access this page !!
    </h1> -->
</body>
</html>
