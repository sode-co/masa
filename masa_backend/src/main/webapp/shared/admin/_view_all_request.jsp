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
                All REQUEST IS WAITING FOR ACCEPTING
            </h1>
        </div>
    </div>
    <script>
        const container = document.getElementById("container");
        let i = 0;
        const urlStatus="http://localhost:8080/masa/api/user-management/update-status/";
        const urlRole=" http://localhost:8080/masa/api/user-management/update-role/";
        let urlAccept = "http://localhost:8080/masa/api/admin/request-management/response/";
        let accept = "?answer=accept";
        let idsession = 0;
        let htmlElements = "";
        const spec = 'ZZZ';
        const space = '';
        $.getJSON(
            "http://localhost:8080/masa/api/user-management/get_user_in_processing",
            function (data) {
                const arr = data["userEntities"];
                arr.forEach((element) => {
                    $.getJSON(
                        "http://localhost:8080/masa/api/request-management/requests",
                        function (data2) {
                            const arr2 = data2["requests"];
                            arr2.forEach((element2) => {
                                var time = new Date().getTime(); // get your number
                                var date = new Date(element2.createdDate); // create Date object
                                var stringdatetime = date.toString().replace("GMT+0700 (Indochina Time)",'');
                                if(element2.userId===element.id){

                                    i++;
                                    idsession = 'ZZZ'+element2.id;
                                    htmlElements +=
                                        '<tr>'
                                        +'<td id="index" style="font-size: 15px; color: black; text-align: center">'+i+'</td>'
                                        +'<td id="id" style="font-size: 15px; color: black">'
                                        +element.id
                                        +'</td>'
                                        +'<td id="email" style="font-size: 15px; color: black">'
                                        +element.email
                                        +'</td>'
                                        +'<td id="fullName" style="font-size: 15px; color: black">'
                                        +element.fullName
                                        +'</td>'
                                        +'<td id="role" style="font-size: 15px; color: black">'
                                        +element2.description
                                        +'</td>'
                                        +'<td id="role" style="font-size: 15px; color: black">'
                                        +stringdatetime
                                        +'</td>'
                                        +'<td id="role" style="font-size: 15px; color: black">'
                                        +element2.zoomUrl
                                        +'</td>'
                                        +'<td id="role" style="font-size: 15px; color: black">'
                                        +element2.meetUrl
                                        +'</td>'
                                        +'<td>'
                                        +'<div style="background-color: #33bd43; width: 90px; height: 30px; border-radius: 25px; padding-top: 7px; padding-left: 25px">'
                                        +'<a href="" onClick="(function(){'
                                        +'console.log(idsession);'
                                        +'const varToString = varObj => Object.keys(varObj)[0];'
                                        +"const "+idsession+"=i;"
                                        +'const x = varToString({'+idsession+'});'
                                        +'const url = (urlAccept + x +accept).replace(spec, space);'
                                        +'$.getJSON(url, function(data) {'
                                        +'console.log(data);'
                                        +'});'
                                        +'})();return false;">'
                                        +'<button>ACCEPT</button>'
                                        +'</a>'
                                        +'</div>'
                                        +'</td>'
                                        +'</tr>';
                                    let container = document.getElementById("container");
                                    container.innerHTML = htmlElements;

                                }
                            });
                        });
                });
            });
        console.log(htmlElements);
    </script>
    <script></script>
    </div>

</section>
<%--<div id="container"></div>--%>

<div id="target"></div>
<table class="table table-dark" id="tableinfo" style="padding: 4rem">
    <thead thead-light>
    <tr>
        <th scope="col" style="font-size: 15px; width: 30px;text-align: center"></th>
        <th scope="col" style="font-size: 15px; width: 100px">User ID</th>
        <th scope="col" style="font-size: 15px; width: 220px">Email</th>
        <th scope="col" style="font-size: 15px; width: 130px">Full Name</th>
        <th scope="col" style="font-size: 15px; width: 150px">Description</th>
        <th scope="col" style="font-size: 15px; width: 200px">created Date</th>
        <th scope="col" style="font-size: 15px; width: 350px">ZOOM URL</th>
        <th scope="col" style="font-size: 15px; width: 240px">MEET URL</th>
        <th scope="col" style="font-size: 15px">UPDATE </th>
    </tr>
    <tbody id="container">
    </tbody>
    </thead>
</table>
<br/>
</body>
</html>
