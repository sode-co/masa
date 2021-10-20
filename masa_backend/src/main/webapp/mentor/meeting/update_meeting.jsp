<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: dangminhtien--%>
<%--  Date: 17/09/2021--%>
<%--  Time: 16:50--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page import="com.devlogs.masa_backend.common.Masa"%>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <link rel="shortcut icon" href="${Masa.ICON_URL}"/>--%>
<%--    <title>Mentor Profile</title>--%>
<%--    <style>--%>
<%--        body {--%>
<%--            background-color: black;--%>
<%--        }--%>
<%--    </style>--%>
<%--    <link--%>
<%--            rel="stylesheet"--%>
<%--            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"--%>
<%--    />--%>
<%--    <link--%>
<%--            href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css"--%>
<%--            rel="stylesheet"--%>
<%--    />--%>
<%--    <link--%>
<%--            rel="stylesheet"--%>
<%--            href="path/to/font-awesome/css/font-awesome.min.css"--%>
<%--    />--%>
<%--</head>--%>
<%--<body>--%>
<%--<!-- Navigation -->--%>
<%--<nav--%>
<%--        class="relative flex flex-wrap items-center justify-between px-2 py-3 mb-3 bg-white "--%>
<%-->--%>
<%--    <div--%>
<%--            class="container flex flex-wrap items-center justify-between px-4 mx-auto "--%>
<%--    >--%>
<%--        <div--%>
<%--                class="relative flex justify-between w-full px-4  lg:w-auto lg:static lg:block lg:justify-start"--%>
<%--        >--%>
<%--            <img--%>
<%--                    src="/masa/shared/icon/weblogo.svg"--%>
<%--                    alt="Logo"--%>
<%--                    width="30%"--%>
<%--                    height="30%"--%>
<%--            />--%>
<%--        </div>--%>
<%--        <div class="items-center flex-grow lg:flex" id="navi">--%>
<%--            <ul class="flex flex-col ml-auto list-none lg:flex-row">--%>
<%--                <li class="nav-item">--%>
<%--                    <a--%>
<%--                            class="--%>
<%--                  font-sans--%>
<%--                  text-2xl--%>
<%--                  font-semibold--%>
<%--                  text-gray-800--%>
<%--                  dark:text-gray-200 dark:hover:text-gray-200--%>
<%--                  hover:no-underline--%>
<%--                  border-b-2 border-green-800--%>
<%--                  mx-1.5--%>
<%--                  sm:mx-6--%>
<%--                  hover:text-gray-800--%>
<%--                "--%>
<%--                            href="#navi"--%>
<%--                    >--%>
<%--                        Home--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a--%>
<%--                            class="--%>
<%--                  font-sans--%>
<%--                  text-2xl--%>
<%--                  font-semibold--%>
<%--                  border-b-2 border-transparent--%>
<%--                  hover:text-gray-800--%>
<%--                  dark:hover:text-gray-200--%>
<%--                  hover:border-green-800 hover:no-underline--%>
<%--                  mx-1.5--%>
<%--                  sm:mx-6--%>
<%--                "--%>
<%--                            href="/masa/mentor/meeting/index.jsp"--%>
<%--                    >--%>
<%--                        View my meeting--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a--%>
<%--                            class="--%>
<%--                  font-sans--%>
<%--                  text-2xl--%>
<%--                  font-semibold--%>
<%--                  border-b-2 border-transparent--%>
<%--                  hover:text-gray-800--%>
<%--                  dark:hover:text-gray-200--%>
<%--                  hover:border-green-800 hover:no-underline--%>
<%--                  mx-1.5--%>
<%--                  sm:mx-6--%>
<%--                "--%>
<%--                            href="#footer"--%>
<%--                    >--%>
<%--                        Contact--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<%--<!-- End of navigation -->--%>

<%--<!-- Noti -->--%>
<%--<div--%>
<%--        class="container flex items-center mx-auto bg-green-100 rounded-md h-96"--%>
<%-->--%>
<%--    <div class="text-center sm:ml-20 text-gray-50 sm:text-left">--%>
<%--        <h1 class="mb-4 text-5xl font-bold text-green-800">--%>
<%--            Create your sharing here! <br />--%>
<%--        </h1>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<br/>--%>
<%--<!-- End of noti -->--%>
<%--<%@include file="../../shared/meeting/_layout_create_meeting.jsp"%>--%>

<%--<!-- Footer -->--%>
<%--<footer--%>
<%--        class="relative pt-1 bg-white border-b-2 border-blue-700 footer"--%>
<%--        id="footer"--%>
<%-->--%>
<%--    <div class="container px-6 mx-auto">--%>
<%--        <div class="sm:flex sm:mt-8">--%>
<%--            <div--%>
<%--                    class="flex flex-col justify-between mt-8  sm:mt-0 sm:w-full sm:px-8 md:flex-row"--%>
<%--            >--%>
<%--                <div class="flex flex-col flex-1">--%>
<%--              <span class="mb-2 font-bold text-center text-green-700 uppercase"--%>
<%--              >A product of Sode team</span--%>
<%--              >--%>
<%--                    <span class="my-2"--%>
<%--                    ><p class="text-gray-700 text-md">--%>
<%--                  We created an application that makes it easy for students to--%>
<%--                  create meetings between students and mentors--%>
<%--                </p></span--%>
<%--                    >--%>
<%--                </div>--%>
<%--                <div class="flex flex-col flex-1">--%>
<%--              <span--%>
<%--                      class="mt-4 mb-2 font-bold text-center text-green-700 uppercase  md:mt-0"--%>
<%--              >Contact us</span--%>
<%--              >--%>
<%--                    <span class="my-2 ml-48">--%>
<%--                <i class="fab fa-facebook"></i>--%>
<%--                <a--%>
<%--                        href="#"--%>
<%--                        class="text-gray-700  hover:no-underline text-md hover:text-blue-500"--%>
<%--                >Facebook: Sode Team - SlimAir.Co--%>
<%--                </a>--%>
<%--              </span>--%>
<%--                    <span class="my-2 ml-48"--%>
<%--                    ><a--%>
<%--                            href="#"--%>
<%--                            class="text-gray-700  hover:no-underline text-md hover:text-blue-500 glyphicon glyphicon-earphone"--%>
<%--                            aria-hidden="true"--%>
<%--                    >Phone: 0901824848</a--%>
<%--                    ></span--%>
<%--                    >--%>
<%--                    <span class="my-2 ml-48">--%>
<%--                <i class="fa fa-envelope" aria-hidden="true"></i>--%>
<%--                <a--%>
<%--                        href="#"--%>
<%--                        class="text-gray-700  text-md hover:text-blue-500 hover:no-underline"--%>
<%--                >Email: Slimair.com@gmail.com</a--%>
<%--                ></span--%>
<%--                    >--%>
<%--                </div>--%>
<%--                <div class="flex flex-col flex-1 place-items-center">--%>
<%--                    <img--%>
<%--                            class="my-2"--%>
<%--                            src="/masa/shared/icon/fpt-university.png"--%>
<%--                            width="50%"--%>
<%--                            height="50%"--%>
<%--                    />--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="container px-6 mx-auto">--%>
<%--        <div--%>
<%--                class="flex flex-col items-center mt-16 border-t-2 border-gray-300"--%>
<%--        >--%>
<%--            <div class="py-6 text-center sm:w-2/3">--%>
<%--                <p class="mb-2 text-sm font-bold text-gray-700">--%>
<%--                    ©2021-Sode Team-FPTU HCM--%>
<%--                </p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</footer>--%>
<%--<!-- End of Footer -->--%>
<%--</body>--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>--%>
<%--<script--%>
<%--        defer--%>
<%--        src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"--%>
<%--        integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"--%>
<%--        crossorigin="anonymous"--%>
<%--></script>--%>
<%--</html>--%>






<%--&lt;%&ndash;<!DOCTYPE html>&ndash;%&gt;--%>
<%--&lt;%&ndash;<html lang="en">&ndash;%&gt;--%>
<%--&lt;%&ndash;<head>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <meta charset="utf-8">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <meta name="viewport" content="width=device-width, initial-scale=1">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>&ndash;%&gt;--%>

<%--&lt;%&ndash;    <script src="https://cdn.tiny.cloud/1/jq1a1p24pc9o6qg9ovftz51uteowbcodeq41e39ci12r0pnt/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>&ndash;%&gt;--%>

<%--&lt;%&ndash;    <script>&ndash;%&gt;--%>
<%--&lt;%&ndash;        tinymce.init({&ndash;%&gt;--%>
<%--&lt;%&ndash;            selector: '#mytextarea'&ndash;%&gt;--%>
<%--&lt;%&ndash;        });&ndash;%&gt;--%>
<%--&lt;%&ndash;        function testText(){&ndash;%&gt;--%>
<%--&lt;%&ndash;            const test = $("#mytextarea").html();&ndash;%&gt;--%>
<%--&lt;%&ndash;            console.log(tinyMCE.activeEditor.getContent());&ndash;%&gt;--%>
<%--&lt;%&ndash;            console.debug(tinyMCE.activeEditor.getContent());&ndash;%&gt;--%>

<%--&lt;%&ndash;        }&ndash;%&gt;--%>
<%--&lt;%&ndash;    </script>&ndash;%&gt;--%>

<%--&lt;%&ndash;</head>&ndash;%&gt;--%>

<%--&lt;%&ndash;<body>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <h1>TinyMCE Quick Start Guide</h1>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div id="mytextarea">Hello, World!</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <button onclick="testText()">Test</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;</body>&ndash;%&gt;--%>
<%--&lt;%&ndash;</html>&ndash;%&gt;--%>






<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2021
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="${Masa.ICON_URL}"/>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="${Masa.ICON_URL}"/>
    <title>Update meeting</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.tiny.cloud/1/jq1a1p24pc9o6qg9ovftz51uteowbcodeq41e39ci12r0pnt/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>
        tinymce.init({
            selector: '#mytextarea',
            width: "700",
            height: "200",
        });
    </script>

    <script>
        function jsonCreate () {
            const startDate = (""+document.getElementById("start-date").value+" "+ document.getElementById("start-time").value+":00").replace(/-/g,"/")
            const start = new Date(startDate);
            const millisecondsStart = start.getTime();
            console.log("millisStart: " + millisecondsStart)
            console.log("millisStart: " + document.getElementById("start-date").value)
            // var dateString = "10/23/2015"; // Oct 23
            // var dateObject = new Date(dateString);
            const endDate = (""+document.getElementById("end-date").value+" "+ document.getElementById("end-time").value+":00").replace(/-/g,"/")
            const end = new Date(endDate);
            const millisecondsEnd = end.getTime();
            console.log("milliesEnd: " + millisecondsEnd)

            let diff = Math.round((millisecondsEnd-millisecondsStart)/1000);

            const d = Math.floor(diff/(24*60*60));
            diff = diff-(d*24*60*60);
            const h = Math.floor(diff/(60*60));
            diff = diff-(h*60*60);
            const m = Math.floor(diff/(60));
            diff = diff-(m*60);
            const s = diff;

            document.getElementById("time-elapsed").innerHTML = "Your meeting lasts: "+d+" day(s), "+h+" hour(s), "+m+" minute(s), "+s+" second(s)";

            let platformInput = document.getElementById("platform").value;
            if (platformInput.includes('G')) platformInput="GOOGLE_MEET";
            else platformInput='ZOOM';
            if(millisecondsEnd <= millisecondsStart){
                alert('End time of meeting must be bigger than start time');
            }else{
                const description = $("#mytextarea").html();
                const json = {
                    "id": window.location.href.slice(window.location.href.indexOf('?id='), window.location.href.indexOf('&host=')).replace('?id=','').replace('Z',''),
                    "title": document.getElementById("title").value,
                     //"host": "ME100001",
                    "host": "${CURRENT_USER.getId()}",
                    "platform": platformInput,
                    "topic": document.getElementById("topic").value,
                    "startTime": millisecondsStart,
                    "endTime": millisecondsEnd,
                    "description": tinyMCE.activeEditor.getContent(),
                }
                console.log(json);
                const options = {
                    method: 'POST',
                    body: JSON.stringify(json),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
                fetch('http://localhost:8080/masa/api/meeting/update', options)
                    .then(res => res.json())
                    .then(res => alert('Update your meeting SUCCESS!'))
                    .catch(err => alert(err));
            }
        }
    </script>
    <style>
        body{
            background-color: #33cc99;
        }
        .createform{
            padding-left: 300px !important;
        }
    </style>


</head>

<body>

<div class="items-center flex-grow lg:flex" id="navi">
    <ul class="flex flex-col ml-auto list-none lg:flex-row">
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
                    href="http://localhost:8080/masa/mentor/meeting/index.jsp"
            >
                Home
            </a>
        </li>
        <li class="nav-item">
            <a
                    class="
                                    font-sans
                                    text-2xl
                                    font-semibold
                                    border-b-2 border-transparent
                                    hover:text-gray-800
                                    dark:hover:text-gray-200
                                    hover:border-green-800 hover:no-underline
                                    mx-1.5
                                    sm:mx-6
                                "
                    href="/masa/mentor/meeting/create_meeting.jsp"
            >
                Create new meeting
            </a>
        </li>
        <li class="nav-item">
            <a
                    class="
                                    font-sans
                                    text-2xl
                                    font-semibold
                                    border-b-2 border-transparent
                                    hover:text-gray-800
                                    dark:hover:text-gray-200
                                    hover:border-green-800 hover:no-underline
                                    mx-1.5
                                    sm:mx-6
                                "
                    href="#footer"
            >
                Contact
            </a>
        </li>
        <li class="nav-item" style="width: 80px; padding-left: 10px; background-color: #f68859; color: white; border-radius: 10px">
            <a style="color: white; font-size: 14px; padding: 2px" href="/masa/auth-management/signout"> Log Out </a>
        </li>
    </ul>
</div>
<h1 style="display: none" id="current-user">${sessionScope.CURRENT_USER.id}</h1>
<div class="container text-center createform">
    <div class="row">
        <div class="col-sm-8" style="font-size: 25px; font-weight: bolder; color: black;">
            Dear ${sessionScope.CURRENT_USER.fullName},
        </div>
        <div class="col-sm-8" style="font-size: 20px; font-weight: bold; color: black;">
            Power is gained by sharing knowledge not hoarding it!
        </div>
    </div>
    <br/>
    <br/>
    <div class="row">
        <div class="col-sm-1">
            <svg xmlns="http://www.w3.org/2000/svg" width="29" height="29" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
                <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
            </svg>
        </div>
        <div class="col-sm-7">
            <input type="text" class="form-control" pattern="[a-zA-Z]" placeholder="Add Title" aria-label="Title" aria-describedby="basic-addon1" id="title">
        </div>
    </div>

    <br/>
    <div class="row">
        <div class="col-sm-1">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-mic" viewBox="0 0 16 16">
                <path d="M3.5 6.5A.5.5 0 0 1 4 7v1a4 4 0 0 0 8 0V7a.5.5 0 0 1 1 0v1a5 5 0 0 1-4.5 4.975V15h3a.5.5 0 0 1 0 1h-7a.5.5 0 0 1 0-1h3v-2.025A5 5 0 0 1 3 8V7a.5.5 0 0 1 .5-.5z"/>
                <path d="M10 8a2 2 0 1 1-4 0V3a2 2 0 1 1 4 0v5zM8 0a3 3 0 0 0-3 3v5a3 3 0 0 0 6 0V3a3 3 0 0 0-3-3z"/>
            </svg>
        </div>
        <div class="col-sm-7">
            <input type="text" class="form-control" placeholder="${sessionScope.CURRENT_USER.fullName}" aria-label="Host" aria-describedby="basic-addon1" id="host" value="${sessionScope.CURRENT_USER.fullName}">
        </div>
    </div>

    <br/>
    <div class="row">
        <div class="col-sm-3">
            Start Time
        </div>
    </div>

    <div class="row">
        <div class="col-sm-1">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-calendar-date" viewBox="0 0 16 16">
                <path d="M6.445 11.688V6.354h-.633A12.6 12.6 0 0 0 4.5 7.16v.695c.375-.257.969-.62 1.258-.777h.012v4.61h.675zm1.188-1.305c.047.64.594 1.406 1.703 1.406 1.258 0 2-1.066 2-2.871 0-1.934-.781-2.668-1.953-2.668-.926 0-1.797.672-1.797 1.809 0 1.16.824 1.77 1.676 1.77.746 0 1.23-.376 1.383-.79h.027c-.004 1.316-.461 2.164-1.305 2.164-.664 0-1.008-.45-1.05-.82h-.684zm2.953-2.317c0 .696-.559 1.18-1.184 1.18-.601 0-1.144-.383-1.144-1.2 0-.823.582-1.21 1.168-1.21.633 0 1.16.398 1.16 1.23z"/>
                <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
            </svg>
        </div>
        <div class="col-sm-3">
            <input type="date" id="start-date" name="trip-start" class="form-control">

        </div>
        <div class="col-sm-1">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
                <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z"/>
                <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z"/>
            </svg>
        </div>
        <div class="col-sm-3">
            <input type="time" id="start-time" class="form-control" />
        </div>
    </div>

    <br/>
    <div class="row">
        <div class="col-sm-3">
            End Time
        </div>
    </div>
    <div class="row">
        <div class="col-sm-1">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-calendar-date" viewBox="0 0 16 16">
                <path d="M6.445 11.688V6.354h-.633A12.6 12.6 0 0 0 4.5 7.16v.695c.375-.257.969-.62 1.258-.777h.012v4.61h.675zm1.188-1.305c.047.64.594 1.406 1.703 1.406 1.258 0 2-1.066 2-2.871 0-1.934-.781-2.668-1.953-2.668-.926 0-1.797.672-1.797 1.809 0 1.16.824 1.77 1.676 1.77.746 0 1.23-.376 1.383-.79h.027c-.004 1.316-.461 2.164-1.305 2.164-.664 0-1.008-.45-1.05-.82h-.684zm2.953-2.317c0 .696-.559 1.18-1.184 1.18-.601 0-1.144-.383-1.144-1.2 0-.823.582-1.21 1.168-1.21.633 0 1.16.398 1.16 1.23z"/>
                <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
            </svg>
        </div>
        <div class="col-sm-3">
            <input type="date" id="end-date"class="form-control">

        </div>
        <div class="col-sm-1">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
                <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z"/>
                <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z"/>
            </svg>
        </div>
        <div class="col-sm-3">
            <input type="time" id="end-time" class="form-control" />
        </div>
    </div>
    <p id="time-elapsed" style="font-style: italic"></p>

    <br/>

    <div class="row">
        <div class="col-sm-1">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-play-circle" viewBox="0 0 16 16">
                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                <path d="M6.271 5.055a.5.5 0 0 1 .52.038l3.5 2.5a.5.5 0 0 1 0 .814l-3.5 2.5A.5.5 0 0 1 6 10.5v-5a.5.5 0 0 1 .271-.445z"/>
            </svg>
        </div>
        <div class="col-sm-7">
            <select class="form-select form-control" id="platform">
                <option value="Zoom">Zoom</option>
                <option value="Google Meet">Google Meet</option>
            </select>

            <%--            <input type="text" class="form-control" placeholder="Platform" aria-label="Platform" aria-describedby="basic-addon1">--%>
        </div>
    </div>

    <br/>
    <div class="row">
        <div class="col-sm-1">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-play-circle" viewBox="0 0 16 16">
                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                <path d="M6.271 5.055a.5.5 0 0 1 .52.038l3.5 2.5a.5.5 0 0 1 0 .814l-3.5 2.5A.5.5 0 0 1 6 10.5v-5a.5.5 0 0 1 .271-.445z"/>
            </svg>
        </div>
        <div class="col-sm-7">
            <select class="form-select form-control" id="topic">
                <option value="Agile">Agile</option>
                <option value="Artificial Intelligence">Artificial Intelligence</option>
                <option value="Business management">Business management</option>
                <option value="Digital Maketing">Digital Maketing</option>
                <option value="English Language">English Language</option>
                <option value="Information Assurance">Information Assurance</option>
                <option value="Japanese Language">Japanese Language</option>
                <option value="Multimedia">Multimedia</option>
                <option value="Photoshop">Photoshop</option>
                <option value="Soft Skills">Soft Skills</option>
                <option value="Software Engineering">Software Engineering</option>
            </select>

            <%--            <input type="text" class="form-control" placeholder="Platform" aria-label="Platform" aria-describedby="basic-addon1">--%>
        </div>
    </div>

    <br/>

    <div class="row">
        <div class="col-sm-1">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
            </svg>
        </div>
        <textarea id="mytextarea">Hi students, I'm glad too see you at meeting...</textarea>

        <hr/>
        <br/>

        <%--        <div id="mytextarea" class="col-sm-7">Hello, World!</div>--%>

        <div class="text-center row">
            <div class="col-sm-9">
                <button onclick="jsonCreate()" class="btn btn-dark" style="background-color: #3051a2; color: white; font-size: 20px; border-radius: 10px">Update Your Meeting!</button>
            </div>
        </div>
    </div>
</div>
<br/>
<br/>


<%@include  file="/shared/footer/footer.html"%>
<script>
    const url = "http://localhost:8080/masa/api/meeting-management/meetings/host/"+window.location.href.slice(window.location.href.indexOf('&host=')).replace('&host=','');
    console.log('url', url);
    $.getJSON(url, function (data) {
        const arr = data["meetings"];
        const meetingId = window.location.href.slice(window.location.href.indexOf('?id='), window.location.href.indexOf('&host=')).replace('?id=','').replace('Z','');
        arr.forEach((element) => {
            if(element.id===meetingId){
                document.getElementById("title").value = element.title;
                if(element.platform.platform.includes("Z")){
                    document.getElementById("platform").value = "Zoom";
                }
                else{
                    document.getElementById("platform").value = "Google Meet";
                }
                document.getElementById("topic").value = element.topic.title;
                document.getElementById("mytextarea").value = element.description;
            }
        });
    });
</script>
</body>
</html>
