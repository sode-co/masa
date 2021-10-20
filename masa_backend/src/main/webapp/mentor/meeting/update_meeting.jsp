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
<h1 style="display: none" id="current-user">${sessionScope.CURRENT_USER.id}</h1>
<div class="container createform">
    <br/>
    <br/>
    <div class="row">
        <div class="col-sm-2" style="margin-left: 3px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> Title<span style="color: red">*</span> :</span>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-8" style="width: 730px">
            <input type="text" class="form-control" pattern="[a-zA-Z]" placeholder="Add Title" aria-label="Title" aria-describedby="basic-addon1" id="title" required>
        </div>
    </div>

    <br/>
    <div class="row">
        <div class="col-sm-2" style="margin-left: 3px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> From<span style="color: red">*</span> :</span>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-3" style="width: 365px">
            <input type="date" id="start-date" name="trip-start" class="form-control">

        </div>
        <script>
            document.getElementById("start-date").valueAsDate = new Date();
        </script>
        <div class="col-sm-3" style="width: 365px">
            <input type="time" id="start-time" value='now' class="form-control" />
        </div>
    </div>

    <br/>
    <div class="row">
        <div class="col-sm-2" style="margin-left: 3px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> To<span style="color: red">*</span> :</span>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3" style="width: 365px">
            <input type="date" id="end-date"class="form-control">

        </div>
        <script>
            document.getElementById("end-date").valueAsDate = new Date();
        </script>
        <div class="col-sm-3" style="width: 365px">
            <input type="time" id="end-time" value='now' class="form-control" />
        </div>
    </div>
    <script>
        $(function(){
            var d = new Date(),
                h = d.getHours(),
                m = d.getMinutes();
            if(h < 10) h = '0' + h;
            if(m < 10) m = '0' + m;
            $('input[type="time"][value="now"]').each(function(){
                $(this).attr({'value': h + ':' + m});
            });
        });
    </script>
    <p id="time-elapsed" style="font-style: italic; margin-left: 200px"></p>

    <br/>
    <div class="row">
        <div class="col-sm-3" style="margin-left: 3px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> Platform<span style="color: red">*</span> :</span>
        </div>
        <div class="col-sm-3" style="margin-left: 63px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> Topic<span style="color: red">*</span> :</span>
        </div>
    </div>
    <div class="row" style="padding-right:10px">
        <div class="col-sm-3" style="width: 365px">
            <select class="form-select form-control" id="platform">
                <option value="Zoom">Zoom</option>
                <option value="Google Meet">Google Meet</option>
            </select>
        </div>
        <div class="col-sm-3" style="width: 365px">
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
        </div>
    </div>

    <br/>

    <div class="row">
    </div>
    <div class="row">
    </div>

    <br/>

    <div class="row">
        <div class="col-sm-2" style="margin-left: 3px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> Description<span style="color: red">*</span> :</span>
        </div>
    </div>

    <div class="row" style="padding-left:2px">
        <div class="col-sm-1" style="width: 100px !important;">
            <textarea id="mytextarea" style="width: 100px !important;">Hi students, I'm glad too see you at meeting...</textarea>
            <div>

                <hr/>
                <br/>

                <%--        <div id="mytextarea" class="col-sm-7">Hello, World!</div>--%>

                <div class="text-center row">
                    <div class="col-sm-9">
                        <button onclick="jsonCreate()" class="btn btn-dark" style="background-color: #4c44e4; color: white; font-size: 20px; border-radius: 10px; margin-left: 10%">Update Meeting!</button>
                    </div>
                </div>
            </div>
        </div>

    </div>


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
