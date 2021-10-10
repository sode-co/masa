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
<%--                >Email: Slimair.co@gmail.com</a--%>
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
    <title>Create new meeting</title>
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
                const description = $("#mytextarea").html();
                const json = {
                    "title": tinyMCE.activeEditor.getContent(),
                    "userId": urlHref.slice(urlHref.indexOf('user='), urlHref.indexOf('&meeting=')).replace('user=',''),
                    "meetingId": urlHref.slice(urlHref.indexOf('meeting=')).replace('meeting=','')
                }
                console.log(json);
                const options = {
                    method: 'POST',
                    body: JSON.stringify(json),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
                fetch('http://localhost:8080/masa/api/meeting_question/create', options)
                    .then(res => res.json())
                    .then(res => console.log(res))
                    .catch(err => console.error(err));
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
<%@include  file="/shared/header/navbar.html"%>
<h1 style="display: none" id="current-user">${sessionScope.CURRENT_USER.id}</h1>
<div class="container text-center createform">
    <div class="row">
        <div class="col-sm-8" style="font-size: 20px; font-weight: bolder; color: black;">
            Dear ${sessionScope.CURRENT_USER.fullName},
        </div>
        <div class="col-sm-8" style="font-size: 15px; font-weight: bold; color: black;">
            contributing questions to the meeting will help you have a more enjoyable study session!
        </div>
        <div id="meetinginfo" style="padding-left: 10px">
            <script>
                console.log('test');
                let container = document.getElementById("meetinginfo");
                let htmlElements = '';
                let urlHref = window.location.href;
                const meetingId = urlHref.slice(urlHref.indexOf('meeting=')).replace('meeting=','');
                $.getJSON("http://localhost:8080/masa/api/meeting-management/meetings", function (data) {
                    const arr = data["meetings"];
                    const width = arr.length;
                    arr.forEach((element) => {
                        idsession = element.id;
                        if(idsession===meetingId){
                            htmlElements +=
                                '<div class="col-sm-12">Information</div>'
                                +'<div class="col-sm-11">'+element.title+'</div>'
                                +'<div class="col-sm-12">'+element.topic.title+'</div>'
                                +'<div class="col-sm-12">'+element.description+'</div>'
                        }
                    });
                    container.innerHTML = htmlElements;
                });
                container.innerHTML = htmlElements;
            </script>

        </div>
    </div>
    <br/>
    <br/>
    <div class="row">

    <br/>

    <div class="row">
        <div class="col-sm-1">
            <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
            </svg>
        </div>
        <textarea id="mytextarea">What do you think of technology now...?</textarea>

        <hr/>
        <br/>

        <%--        <div id="mytextarea" class="col-sm-7">Hello, World!</div>--%>

        <div class="text-center row">
            <div class="col-sm-9">
                <button onclick="jsonCreate()" class="btn btn-dark" style="background-color: #30a236; color: white; font-size: 20px; border-radius: 10px">Send your question now</button>
            </div>
        </div>
    </div>
</div>
<br/>
<br/>


<%@include  file="/shared/footer/footer.html"%>

</body>
</html>

