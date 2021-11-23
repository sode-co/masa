<!DOCTYPE html>
<html lang="en">
<%@page import="com.devlogs.masa_backend.common.Masa" %>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Question</title>
    <%@include file="/shared/gg_analytics/_analytics_script"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        if (window.location.href.includes("followed")){
            const newUrl = window.location.href.slice(0,window.location.href.indexOf("&followed=")).replace("&followed=","")+window.location.href.slice(window.location.href.indexOf("&page="));
            // console.log(newUrl);
            window.location.replace(newUrl);
        }

        const meetingId = location.search.slice(location.search.indexOf("?id="),location.search.indexOf("&page")).replace("?id=","");
        function askquestion(){
                const json = {
                    title: document.getElementById("questionContent").value,
                    userId: document.getElementById("currentSessionNewMeeting").textContent,
                    // userId: 'AD100007',
                    meetingId: location.search.slice(location.search.indexOf("?id="),location.search.indexOf("&page")).replace("?id=",""),
                };
                console.log(json);
                const options = {
                    method: "POST",
                    body: JSON.stringify(json),
                    headers: {
                        "Content-Type": "application/json",
                    },
                };
                fetch("${Masa.SERVER_HOST}/api/meeting_question/create", options)
                    .then((res) => res.json())
                    .then((res) => {
                        alert("Send question successfully!");
                        window.location.replace("${Masa.SERVER_HOST}/member/question.jsp?id="+meetingId+"&page=0");
                    })
                    .catch((err) => alert(err));
        }
        let page = 0;
        function previous(){
            if(page>0) --page;
            else page = 0;
            window.location.replace("${Masa.SERVER_HOST}/member/question.jsp?id="+meetingId+"&page="+page);
            console.log(page);
        }
        function next(){
            ++page;
            window.location.replace("${Masa.SERVER_HOST}/member/question.jsp?id="+meetingId+"&page="+page);
            console.log(page);
        }
        function search(){
            const searchMethod = document.getElementById("searchmethod").value;
            const searchKey = document.getElementById("searchkeyword").value;
            const urlForward = "${Masa.SERVER_HOST}/member/searchmeeting.jsp?method="+searchMethod+"&keyword="+searchKey;
            window.location.replace(urlForward);
        }
    </script>
</head>
<link href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css" rel="stylesheet" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet" />
<body>
<h1 id="currentSessionNewMeeting" style="display: none">${sessionScope.CURRENT_USER.id}</h1>
<div class="overflow-x-hidden bg-gray-100">
    <nav class="relative flex flex-wrap items-center justify-between px-2 py-2 mb-2 bg-white">
        <div class="container flex flex-wrap items-center justify-between px-4 mx-auto">
            <div class="relative flex justify-between w-full px-4 lg:w-auto lg:static lg:block lg:justify-start">
                    <img src="https://i.ibb.co/qCg5gr8/masalogo.png" style="width: 40%;"/>
            </div>
            <div class="relative flex justify-between w-full px-1 lg:w-auto lg:static lg:block lg:justify-start">
                <div class="flex items-center h-12 border border-gray-700 rounded-lg w-30" style="border-color: #414E62; border-width: medium; margin-bottom: 5px; margin-left: -190px;">
                    <input placeholder="Search meeting by..." name="select" id="searchkeyword" class="w-full px-4 text-gray-800 outline-none appearance-none" checked />
                    <span style="font-weight: lighter; font-size: 40px; color: #414e62; margin-bottom: 10px">|</span>
                    <select
                            id="searchmethod"
                            class="h-10 text-gray-600  appearance-none  "
                            style="border-color: transparent"
                    >
                        <option>Mentor</option>
                        <option>Title</option>
                    </select>
                    <span style="font-weight: lighter; font-size: 40px; color: #414e62; margin-bottom: 10px">|</span>
                    <button
                            onclick="search()"
                            class="pl-5 pr-5 text-gray-900 transition-all outline-none cursor-pointer  focus:outline-none hover:text-gray-600 bg-gradient-dark "
                    >
                        <img src="https://img.icons8.com/ios-filled/50/000000/search--v4.png"/>
                    </button>
                </div>
            </div>
            <div class="items-center flex-grow lg:flex" id="navi">
                <ul class="flex flex-col ml-auto list-none lg:flex-row">
                    <li class="nav-item">
                        <a
                                class="
                                        font-sans
                                        font-semibold
                                        border-b-2 border-transparent
                                        hover:text-gray-800
                                        dark:hover:text-gray-200
                                        hover:border-green-800 hover:no-underline
                                        mx-1.5
                                        sm:mx-6
                                    "
                                href="${Masa.SERVER_HOST}/member/home.jsp"
                                style="font-size: 18px; font-weight: 600; color: #414E62"
                        >
                            Meeting
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
                                        mx-1.5
                                        sm:mx-6
                                    "
                                style="font-size: 18px; color: #9b9a9a"

                        >
                            |
                        </a>
                    </li>
                    <li class="nav-item">
                        <a
                                class="
                                        font-sans
                                        text-2xl
                                        font-semibold
                                        text-gray-800
                                        dark:text-gray-200 dark:hover:text-gray-200
                                        hover:no-underline
                                        border-b-2 border-green-600
                                        mx-1.5
                                        sm:mx-6
                                    "
                                href="#"
                                style="font-size: 18px; font-weight: 600; color: #414E62"
                        >
                            Question Page
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
                                        mx-1.5
                                        sm:mx-6
                                    "
                                style="font-size: 18px; color: #9b9a9a"

                        >
                            |
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
                                style="font-size: 18px; font-weight: 600; color: #414E62"
                        >
                            About us
                        </a>
                    </li>&nbsp;&nbsp;
                    <li class="nav-item">
                        <a
                                href="${Masa.SERVER_HOST}/auth-management/signout"
                        >
                            <button class="bg-transparent  hover:bg-gray-500 border border-gray-500 text-white-800 font-semibold py-2 px-4 rounded inline-flex items-center hover:border-transparent hover:text-white"
                                style="border-radius: 5px; margin-bottom: 10px"
                            >
                                <span style="font-size: 17px">Log out</span> &nbsp; &nbsp;
                                <svg style="margin-top: 7px; font-weight: bold" class="fill-current w-4 h-4 mr-2" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                                    <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                                    <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                                </svg>
                            </button>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="px-10 py-8">
        <div class="container flex justify-between mx-auto">
            <div class="max-w-4xl lg:w-8/12">
                <div class="flex items-center justify-between">
                    <h2 class="text-xl font-bold" style="color: #414E62; font-size: 25px">Question</h2>
                </div>
                <div class="mt-6">
                    <div class="max-w-4xl px-10 py-6 mx-auto bg-white rounded-lg shadow-md">
                        <div class="p-5 bg-white">
                                    <textarea
                                            class="w-full p-2 bg-gray-200 border rounded-lg shadow"
                                            rows="5"
                                            placeholder="Ask about the meeting"
                                            id="questionContent"
                                            style="padding-left: 20px"
                                    ></textarea>

                            <div class="flex flex-row flex-wrap w-full mx-auto mt-3">
                                <div class="w-full mx-auto">
                                    <button
                                            onclick="askquestion()"
                                            type="button"
                                            class="float-right p-2 font-semibold text-white bg-indigo-800 rounded-md hover:bg-indigo-600"
                                    >
                                        Leave question
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="questionList">
                    <script>
                        let currentPage;
                        if(window.location.href.indexOf("page")>0){
                            currentPage = window.location.href.slice(window.location.href.indexOf("page=")).replaceAll("page=",'');
                        }else{
                            currentPage = 0;
                        }
                        const url = "${Masa.SERVER_HOST}/api/meeting-management/meeting/"+location.search.slice(location.search.indexOf("?id="),location.search.indexOf("&page")).replace("?id=","");
                        $.getJSON(url, function (element) {
                            document.getElementById("descriptionContent").innerHTML = element.description;
                            document.getElementById("meetingTitle").innerHTML = element.title;
                            document.getElementById("meetingMentor").innerHTML = element.mentor.fullName;
                            const start = new Date(element.startTime);
                            const end = new Date(element.endTime);
                            document.getElementById("meetingTime").innerHTML = start.getHours()+":"+start.getMinutes()+" - "+end.getHours()+":"+end.getMinutes();
                            document.getElementById("meetingDate").innerHTML = start.getDay()+"/"+start.getMonth()+"/"+start.getFullYear();
                            document.getElementById("meetingUrl").href = element.platform.url;
                        })
                            let htmlElements = "";
                        let i =0;
                        // const meetingId =location.search.slice(location.search.indexOf("?id="),location.search.indexOf("&page")).replace("?id=","");
                        $.getJSON("${Masa.SERVER_HOST}/api/meeting_question/questions/"+meetingId, function (data) {
                            const arr = data["meetingQuestions"];
                            arr.slice(4*currentPage, 4*currentPage+4).forEach((element) => {
                                const date = new Date(element.createdDate);
                                console.log(("0"+18).slice(0,2));
                                const hour = date.getHours() < 10 ? ("0"+date.getHours()).slice(0,2) : date.getHours();
                                const minute = date.getMinutes() < 10 ? ("0"+date.getMinutes()).slice(0,2) : date.getMinutes();
                                const day = date.getDate() < 10 ? ("0"+date.getDate()).slice(0,2) : date.getDate();
                                const month = date.getMonth() < 10 ? ("0"+date.getMonth()).slice(0,2) : date.getMonth();
                                const date_create = hour+":"+minute+" "+day+"/"+month+"/"+date.getFullYear();
                                //const date_create = ("0"+date.getHours()).slice(0,2)+":"+("0"+date.getMinutes()).slice(0,2)+" "+date.getDate()+"/"+date.getMonth()+"/"+date.getFullYear();
                                htmlElements+=
                                    '<div class="mt-6">'
                                    +'<div class="max-w-4xl px-10 py-6 mx-auto bg-white rounded-lg shadow-md">'
                                    +'<div class="flex items-center justify-between">'
                                    +'<a href="#" class="flex items-center"'
                                    +'><img'
                                    +' src="https://cdn-icons-png.flaticon.com/512/236/236831.png"'
                                    +'alt="avatar"'
                                    +'class="hidden object-cover w-10 h-10 mx-4 rounded-full sm:block"'
                                    +'/>'
                                    +'<h1 class="font-bold text-gray-700 hover:underline">'+element.user.fullName+'</h1>'
                                    +'</a>'
                                    +'<span class="font-light text-gray-600">'+date_create+'</span>'
                                    +'</div>'
                                    +'<div class="mt-2">'
                                    +'<a href="#" class="text-2xl font-bold text-gray-700 hover:underline"> </a>'
                                    +'<p class="mt-2 ml-3 text-gray-600">'
                                    + element.title
                                    +'</p>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                            })
                            document.getElementById("questionList").innerHTML = htmlElements;
                        })
                    </script>
                </div>

                <div class="mt-8">
                    <div class="flex">
                        <button onclick="previous()" class="bg-gray-300 hover:bg-gray-400 text-gray-800 font-bold py-2 px-4 rounded-l">
                            Prev
                        </button>
                        &nbsp;
                        <button onclick="next()" class="bg-gray-300 hover:bg-gray-400 text-gray-800 font-bold py-2 px-4 rounded-r">
                            Next
                        </button>
                    </div>
                </div>
            </div>
            <div class="hidden w-4/12 -mx-8 lg:block">
                <div class="max-w-lg px-8">
                    <h1 class="mb-4 text-xl font-bold text-gray-700">Meeting</h1>
                    <div class="flex flex-col max-w-lg px-6 py-4 mx-auto bg-white rounded-lg shadow-md">
                        <section class="relative pt-12">
                            <div class="flex flex-wrap items-center">
                                <div class="w-full px-4 mb-10 ml-5">
                                    <div class="md:pr-12">
                                        <h3 class="text-4xl font-semibold" id="meetingTitle">Data Analysis</h3>
                                        <p class="mt-4 text-lg leading-relaxed text-blueGray-500"></p>
                                        <ul class="mt-6 list-none">
                                            <li class="py-2">
                                                <div class="flex items-center" >
                                                    <div>
                                                                <span style="background-color: #414E62"
                                                                        class="inline-block px-2 py-1 mr-3 text-xl font-semibold text-white uppercase bg-blue-200 rounded-full "
                                                                ><i class="fas fa-user"></i
                                                                ></span>
                                                    </div>
                                                    <div>
                                                        <h4 class="text-blueGray-500">Mentor: <span class="text-semibold" id="meetingMentor">Tam Nhu</span></h4>
                                                    </div>
                                                </div>
                                            </li>
                                            <li class="py-2">
                                                <div class="flex items-center">
                                                    <div>
                                                                <span style="background-color: #414E62"
                                                                      class="inline-block px-2 py-1 mr-3 text-xl font-semibold text-white uppercase bg-blue-200 rounded-full "
                                                                ><i class="fas fa-clock"></i
                                                                ></span>
                                                    </div>
                                                    <div>
                                                        <h4 class="text-blueGray-500" id="meetingTime">10:00 - 12:00</h4>
                                                    </div>
                                                </div>
                                            </li>
                                            <li class="py-2">
                                                <div class="flex items-center">
                                                    <div>
                                                                <span style="background-color: #414E62"
                                                                      class="inline-block px-2 py-1 mr-3 text-xl font-semibold text-white uppercase bg-blue-200 rounded-full "
                                                                ><i class="far fa-calendar-alt"></i
                                                                ></span>
                                                    </div>
                                                    <div>
                                                        <h4 class="text-blueGray-500" id="meetingDate">Thu, Oct 22th, 2021</h4>
                                                    </div>
                                                </div>
                                            </li>
                                            <br/>
                                            <li class="py-2">
                                                <div class="flex w-full mx-auto">
                                                    <a id="meetingUrl">
                                                        <button
                                                                type="button"
                                                                class="bg-transparent hover:bg-green-500 text-green-500 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded"
                                                        >
                                                            Join now
                                                        </button>
                                                    </a>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
                <div class="max-w-lg px-8 mt-10">
                    <h1 class="mb-4 text-xl font-bold text-gray-700">Description</h1>
                    <div class="flex flex-col max-w-lg px-4 py-6 mx-auto bg-white rounded-lg shadow-md">
                        <p class="mt-4 text-lg leading-relaxed text-blueGray-500" id="descriptionContent">
                            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Tempora expedita dicta totam aspernatur doloremque.
                            Excepturi iste iusto eos enim reprehenderit nisi, accusamus delectus nihil quis facere in modi ratione libero!
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="relative pt-1 bg-white border-b-2 border-blue-700 footer" id="footer">
        <div class="container px-6 mx-auto">
            <div class="sm:flex sm:mt-8">
                <div class="flex flex-col justify-between mt-8 sm:mt-0 sm:w-full sm:px-8 md:flex-row">
                    <div class="flex flex-col flex-1">
                        <span class="mb-2 font-bold text-center text-info-700 uppercase" style="color: #414E62">A product of Sode team</span>
                        <span class="my-2"
                        ><p class="text-gray-700 text-md">
                                        We created an application that makes it easy for students to create meetings between students and mentors
                                    </p></span
                        >
                    </div>
                    <div class="flex flex-col flex-1">
                        <span class="mt-4 mb-2 font-bold text-center text-green-700 uppercase md:mt-0" style="color: #414E62">Contact us</span>
                        <span class="my-2 ml-48">
                                    <i class="fab fa-facebook"></i>
                                    <a href="#" class="text-gray-700 hover:no-underline text-md hover:text-blue-500"
                                    >Facebook: Sode Team - SlimAir.Co
                                    </a>
                                </span>
                        <span class="my-2 ml-48"
                        ><a
                                href="#"
                                class="text-gray-700 hover:no-underline text-md hover:text-blue-500 glyphicon glyphicon-earphone"
                                aria-hidden="true"
                        >Phone: 0901824848</a
                        ></span
                        >
                        <span class="my-2 ml-48">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                    <a href="#" class="text-gray-700 text-md hover:text-blue-500 hover:no-underline"
                                    >Email: Slimair.co@gmail.com</a
                                    ></span
                        >
                    </div>
                    <div class="flex flex-col flex-1 place-items-center">
                        <img class="my-2" src="${Masa.SERVER_HOST}/shared/icon/fpt-university.png" width="50%" height="50%" />
                    </div>
                </div>
            </div>
        </div>
        <div class="container px-6 mx-auto">
            <div class="flex flex-col items-center mt-16 border-t-2 border-gray-300">
                <div class="py-6 text-center sm:w-2/3">
                    <p class="mb-2 text-sm font-bold text-gray-700"> © 2021-Sode Team-FPTU HCM</p>
                </div>
            </div>
        </div>
    </footer>
</div>
</body>
</html>
