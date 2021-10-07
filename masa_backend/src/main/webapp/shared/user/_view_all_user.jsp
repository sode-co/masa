<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Created by
IntelliJ IDEA. User: Ngoc Thieu Date: 9/19/2021 Time: 1:11 PM To change this
template use File | Settings | File Templates. --%> <%@ page
        contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Mentor In System</title>
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
    <script
            defer
            src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"
            integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"
            crossorigin="anonymous"
    ></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>

        h1{
            font-size: 30px;
            color: #fff;
            text-transform: uppercase;
            font-weight: 300;
            text-align: center;
            margin-bottom: 15px;
        }
        table{
            width:100%;
            table-layout: fixed;
        }
        .tbl-header{
            background-color: rgba(255,255,255,0.3);
        }
        .tbl-content{
            height:300px;
            overflow-x:hidden;
            margin-top: 0px;
            border: 1px solid rgba(255,255,255,0.3);
        }
        th{
            padding: 20px 15px;
            text-align: left;
            font-weight: 500;
            font-size: 12px;
            color: #fff;
            text-transform: uppercase;
        }
        td{
            padding: 15px;
            text-align: left;
            vertical-align:middle;
            font-weight: 300;
            font-size: 12px;
            color: #fff;
            border-bottom: solid 1px rgba(255,255,255,0.1);
        }


        /* demo styles */

        @import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
        body{
            background: -webkit-linear-gradient(left, #25c481, #25b7c4);
            background: linear-gradient(to right, #25c481, #25b7c4);
            font-family: 'Roboto', sans-serif;
            overflow-x: hidden;

        }
        section{
            margin: 50px;
        }

    </style>
    <script>
    </script>
</head>
<body>
<section class="text-gray-600 body-font">
    <div class="container px-5 py-5 mx-auto" id="divinfo">
        <div style="width: 1000px">
            <h1 class="mb-2 text-9xl font-bold text-gray-1000 sm:text-4xl title-font" style="width: 1330px !important;">
                All LECTURERs In Masa System
            </h1>
        </div>
    </div>
    <script>
        const container = document.getElementById("container");
        let i = 0;
        const urlStatus="http://localhost:8080/masa/api/user-management/update-status/";
        const urlRole=" http://localhost:8080/masa/api/user-management/update-role/";
        let idsession = 0;
        $.getJSON(
            "http://localhost:8080/masa/api/user-management/all",
            function (data) {
                let htmlElements = "";
                const arr = data["users"];
                arr.forEach((element) => {
                    const urlHref = "http://localhost:8080/masa/api/user-management/update-role/";

                    i++;
                    idsession = element.id;
                    htmlElements +=
                        '<tr>'
                        +'<td id="index" style="font-size: 20px; color: black; text-align: center">'+i+'</td>'
                        +'<td id="id" style="font-size: 20px; color: black">'
                        +element.id
                        +'</td>'
                        +'<td id="email" style="font-size: 20px; color: black">'
                        +element.email
                        +'</td>'
                        +'<td id="fullName" style="font-size: 20px; color: black">'
                        +element.fullName
                        +'</td>'
                        +'<td id="role" style="font-size: 20px; color: black">'
                        +element.role.type
                        +'</td>'
                        +'<td id="status" style="font-size: 20px; color: black">'
                        +element.status.status
                        +'</td>'
                        +'<td>'
                        +'<div style="background-color: black; width: 90px; height: 30px; border-radius: 25px; padding-top: 7px; padding-left: 19px; font-weight: 300">'
                        +'<a href="" onClick="(function(){'
                        +'const varToString = varObj => Object.keys(varObj)[0];'
                        +'const '+idsession+'=i;'
                        +'const x = varToString({'+idsession+'});'
                        +'const url = urlStatus + x;'
                        +'$.getJSON(url, function(data) {'
                        +'console.log(data);'
                        +'});'
                        +'})();return false;">'
                        +'<button>STATUS</button>'
                        +'</a>'
                        +'</div>'
                        +'</td>'
                        +'</tr>';
                    // console.log(element);
                    let container = document.getElementById("container");
                    container.innerHTML = htmlElements;
                });
            }
        );
    </script>
    <script></script>
    </div>

</section>
<%--<div id="container"></div>--%>

<div id="target"></div>
<table class="table table-dark" id="tableinfo" style="padding: 4rem">
    <thead thead-light>
    <tr>
        <th scope="col" style="font-size: 20px; width: 170px;text-align: center">Index</th>
        <th scope="col" style="font-size: 20px; width: 220px">ID</th>
        <th scope="col" style="font-size: 20px; width: 330px">Email</th>
        <th scope="col" style="font-size: 20px; width: 330px">Full Name</th>
        <th scope="col" style="font-size: 20px">Role</th>
        <th scope="col" style="font-size: 20px">Status</th>
        <th scope="col" style="font-size: 20px">Update </th>
    </tr>
    <tbody id="container">
    <%--        <tr>--%>
    <%--            <div id="container"></div>--%>
    <%--        </tr>--%>
    </tbody>
    </thead>
</table>
<br/>
</body>
</html>
