<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/5/2021
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vertical Menu</title>
    <link href='https://fonts.googleapis.com/css?family=Quicksand:400,700' rel='stylesheet' type='text/css' />
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.0.0.min.js" /></script>

    <link href="https://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.min.css" rel="stylesheet" />
    <!--[if IE 7]>
    <link href="https://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome-ie7.min.css" rel="stylesheet" />
    <![endif]-->
    <style>
        body {
            background:url(http://www.ourtuts.com/tutorials/vertical-menu/bg.jpg) scroll center center;
            margin:0;
            padding:0;
            font-family:Quicksand;
            font-weight:700;
        }

        ul.form {
            position:relative;
            background:#fff;
            width:250px;
            margin:auto;
            padding:0;
            list-style: none;
            overflow:hidden;

            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;

            -webkit-box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.1);
            -moz-box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.1);
            box-shadow:  1px 1px 10px rgba(0, 0, 0, 0.1);
        }

        .form li a {
            width:225px;
            padding-left:20px;
            height:50px;
            line-height:50px;
            display:block;
            overflow:hidden;
            position:relative;
            text-decoration:none;
            text-transform:uppercase;
            font-size:14px;
            color:#686868;

            -webkit-transition:all 0.2s linear;
            -moz-transition:all 0.2s linear;
            -o-transition:all 0.2s linear;
            transition:all 0.2s linear;
        }

        .form li a:hover {
            background:#efefef;
        }

        .form li a.profile {
            border-left:5px solid #008747;
        }
        .form li a.all {
            border-left:5px solid #f57640;
        }

        .form li a.messages {
            border-left:5px solid #fecf54;
        }

        .form li a.settings {
            border-left:5px solid #cf2130;
        }
        .form li a.calendar {
            border-left:5px solid #5dc0ff;
        }
        .form li a.logout {
            border-left:5px solid #dde2d5;
        }

        .form li:first-child a:hover, .form li:first-child a {
            -webkit-border-radius: 5px 5px 0 0;
            -moz-border-radius: 5px 5px 0 0;
            border-radius: 5px 5px 0 0;
        }

        .form li:last-child a:hover, .form li:last-child a {
            -webkit-border-radius: 0 0 5px 5px;
            -moz-border-radius: 0 0 5px 5px;
            border-radius: 0 0 5px 5px;
        }

        .form li a:hover i {
            color:#ea4f35;
        }

        .form i {
            margin-right:15px;

            -webkit-transition:all 0.2s linear;
            -moz-transition:all 0.2s linear;
            -o-transition:all 0.2s linear;
            transition:all 0.2s linear;
        }

        .form em {
            font-size: 10px;
            background: #ea4f35;
            padding: 3px 5px;
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            border-radius: 10px;
            font-style: normal;
            color: #fff;
            margin-top: 17px;
            margin-right: 15px;
            line-height: 10px;
            height: 10px;
            float:right;
        }


        h1 {
            color:#fff;
            margin:0 auto;
            margin-top:60px;
            margin-bottom:40px;
            font-size:30px;
            width:300px;
            text-align:center;
        }

        p {
            text-align:center;
            position:absolute;
            width:100%;
            bottom:0;
            font-size:12px;
            font-family:Arial, Helvetica;
            color:#fff;
            text-transform:uppercase;
        }
        p a {
            color:#fff;
            text-decoration:none;
        }
    </style>
</head>

<body>
<ul class="form">
    <li><a class="all" href="/masa/admin/request-management/index.jsp"><i class="icon-user"></i>MANAGE REQUESTS</a></li>
    <li><a class="profile" href="/masa/admin/user-management/manage_mentor.jsp"><i class="icon-user"></i>MANAGE MENTOR</a></li>
    <li class="selected"><a class="messages" href="/masa/admin/user-management/manage_guest.jsp"><i class="icon-bell"></i>MANAGE LECTURE<em>new</em></a></li>
    <li><a class="settings" href="/masa/admin/user-management/manage_student.jsp"><i class="icon-cog"></i>MANAGE STUDENT</a></li>
<%--    <li><a class="calendar" href="/masa/admin/meeting/view_all.jsp"><i class="icon-calendar"></i>MANAGE MEETING</a></li>--%>
<%--    <li><a class="logout" href="#"><i class="icon-signout"></i>LOGOUT</a></li>--%>
</ul>

</body>
</html>
