<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Created by
IntelliJ IDEA. User: Ngoc Thieu Date: 9/19/2021 Time: 1:11 PM To change this
template use File | Settings | File Templates. --%> <%@ page
        contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
        let urlTable = "http://localhost:8080/masa/api/user-management/all";
        if(location.search.replace('?name=','')===''){
            urlTable = "http://localhost:8080/masa/api/user-management/all";
        }else{
            urlTable = "http://localhost:8080/masa/api/user-management/get-user-by-name/"+location.search.replace('?name=','').replace('%20',' ');
        }
        function search(){
            if(document.getElementById('namesearch').value===''){
                location.replace("http://localhost:8080/masa/admin/user-management/index.jsp?name="+document.getElementById('namesearch').value);
            }
            location.replace("http://localhost:8080/masa/admin/user-management/index.jsp?name="+document.getElementById('namesearch').value);
        }
    </script>
</head>
<body>
<section class="text-gray-600 body-font">
    <div class="container px-5 py-5 mx-auto" id="divinfo">
        <div style="width: 1000px">
            <h1 class="mb-2 text-9xl font-bold text-gray-1000 sm:text-4xl title-font" style="width: 1330px !important;">
                All Meetings In Masa System
            </h1>
        </div>
    </div>
    <section class="text-gray-600 body-font">
        <div class="container px-5 py-5 mx-auto">
            <h1 id="userId" style="display: none">${sessionScope.CURRENT_USER.getId()}</h1>
            <div id="carousel_wrapper1" class="min-w-full overflow-auto md:flex md:justify-center md:space-x-8 md:px-14"></div>
        </div>
        <script>
            const urlFollow1 = "http://localhost:8080/masa/api/appointment-management/create";
            let container1 = document.getElementById("carousel_wrapper1");
            let htmlElements1 = "";
            const postMethod1 = "POST";
            const contentType1 = "Content-Type";
            const appJson1 = "application/json";
            const userId1 = document.getElementById("userId").textContent;
            let idsession1 = 0;
            let followText1 = "Follow";
            let unfollowText1 = "Unfollow";
            let followId1 = "follow";
            let i1 = 0;
            let urlAskPage1 = "http://localhost:8080/masa/member/meeting/ask_question.jsp";
            let userParam1 = "?user=";
            let meetingParam1 = "&meeting=";
            const urlThisPage1 = "http://localhost:8080/masa/member/meeting/index.jsp";
            const quotationMarks1 = '"';

            const json = {
                topicName: [ "Software engineering",
                    "Artificial Intelligence",
                    "Business management"],
            };
            console.log('json', json);
            const options = {
                method: "POST",
                body: JSON.stringify(json),
                headers: {
                    "Content-Type": "application/json",
                },
            };
            fetch("http://localhost:8080/masa/api/meeting-management/topic-name/meetings", options)
                .then((res) => res.json())
                .then((res) => {
                    console.log(res);
                    const arr = res["meetings"];
                    const width = arr.length;
                    arr.forEach((element) => {
                        var startX = new Date(element.startTime);
                        var stringstartX = startX.toString().replace("GMT+0700 (Indochina Time)",'');
                        var endX = new Date(element.endTime);
                        var stringendX = endX.toString().replace("GMT+0700 (Indochina Time)",'');

                        idsession1 = element.id;
                        htmlElements1 +=
                            '<div class="relative flex flex-col justify-between flex-1 max-w-md p-8 lg:p-6 xl:p-8 rounded-2xl mb-11">' +
                            '<div class="absolute inset-0 w-full h-full transform bg-white rounded-2xl">' +
                            '</div><div class="absolute inset-0 w-full h-full border-2 border-gray-900 rounded-2xl">' +
                            '</div><div class="relative flex pb-5 space-x-5 border-b border-gray-200 lg:space-x-3 xl:space-x-5">' +
                            '<div class="relative flex flex-col items-start items-center flex-1">' +
                            '<h3 class="relative text-3xl font-bold" style="color: #f57640">' +
                            element.title +
                            "</h3>" +
                            '<br/>'+
                            '<br/>'+
                            '<br/>'+
                            '<h6 style="color: transparent" id="meetingId">' +
                            element.id +
                            "</h6>" +
                            '<p class="tracking-tight text-gray-500"><span class="text-1xl font-bold text-green-700">' +
                            "From: "+ stringstartX.slice(0,21) +
                            '<br/>'+
                            " - " +
                            '<br/>'+
                            "To: "+stringendX.slice(0,21) +
                            "</span>" +
                            '</p></div></div><ul class="relative py-12 space-y-3">' +
                            '<li class="flex items-center space-x-2 text-lg font-medium text-gray-500">' +
                            '<svg class="w-6 h-6 text-white-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">' +
                            '<path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd">' +
                            '</path></svg><span>Mentor: _________</span></li><li class="flex items-center space-x-2 text-lg font-medium text-gray-500">' +
                            '<svg class="w-6 h-6 text-orange-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">' +
                            '<path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd">' +
                            '</path></svg><span>Platform: Zoom</span></li><li class="flex items-center space-x-2 text-lg font-medium text-gray-500">' +
                            '<svg class="w-6 h-6 text-white-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">' +
                            '<path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd"></path></svg>' +
                            "" +
                            "<span>Description:"+ element.description+"</span></li></ul>"
                            +"<br/>" +
                            "</div>";
                    });
                    container1.innerHTML = htmlElements1;
                })
                .catch((err) => console.error(err));

            container1.innerHTML = htmlElements1;
        </script>
    </section>
    <div id="target"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
        defer
        src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"
        integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"
        crossorigin="anonymous"
></script>
</section>
</body>
</html>
