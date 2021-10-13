
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="${Masa.ICON_URL}"/>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="${Masa.ICON_URL}"/>
    <title>Ask question for meeing</title>
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
                    "meetingId": urlHref.slice(urlHref.indexOf('meeting=')).replace('meeting=','').replace('Z','')
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
                    .then(res => alert("YOUR QUESTION IS SENT, THANK YOU"))
                    .catch(err => alert(err));
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
<nav class="relative flex flex-wrap items-center justify-between px-2 py-3 mb-3 bg-white">
    <div class="container flex flex-wrap items-center justify-between px-4 mx-auto">
        <div class="relative flex justify-between w-full px-4 lg:w-auto lg:static lg:block lg:justify-start">
            <img src="/masa/shared/icon/weblogo.svg" alt="Logo" width="30%" height="30%" />
        </div>
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
                            href="http://localhost:8080/masa/member/meeting/index.jsp"
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
                            href="/masa/member/meeting/followed_meeting.jsp"
                    >
                        View followed meeting
                    </a>
                </li>
                <li class="nav-item">
                    <a
                            class="
                                    text-white
                                    font-sans
                                    text-2xl
                                    font-semibold
                                    border-b-2 border-transparent
                                    hover:text-white
                                    dark:hover:text-white
                                    hover:border-transparent hover:no-underline hover:bg-green-800
                                    mx-1.5
                                    sm:mx-6
                                    bg-green-500
                                    px-5
                                    py-3
                                    rounded-full
                                "
                            href="/masa/auth-management/signout"
                    >
                        Log Out
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
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

