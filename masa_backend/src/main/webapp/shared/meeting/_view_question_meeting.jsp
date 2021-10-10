<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Created by
IntelliJ IDEA. User: Ngoc Thieu Date: 9/19/2021 Time: 1:11 PM To change this
template use File | Settings | File Templates. --%> <%@ page
        contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View My Meeting (mentor)</title>
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
    <style></style>
    <script>
    </script>
</head>
<body>
<section class="text-gray-600 body-font">
    <div class="container px-5 py-24 mx-auto">
        <div class="flex flex-wrap w-full mb-8">
            <div class="w-full mb-6 lg:mb-0 sm:ml-20">
                <h1
                        class="mb-2 text-5xl font-medium text-gray-900  sm:text-4xl title-font"
                >
                    Questions
                </h1>
                <div class="w-20 h-1 bg-green-500 rounded"></div>
            </div>
        </div>
        <h1 id="userId" style="display: none">${sessionScope.CURRENT_USER.getId()}</h1>
        <script>
            const urlFollow = "http://localhost:8080/masa/api/appointment-management/create";
            const urlUnfollow = "http://localhost:8080/masa/api/appointment-management/remove";
            const url ="http://localhost:8080/masa/api/meeting_question/questions/"+window.location.href.slice(window.location.href.indexOf('meeting=')).replace('meeting=','');
            console.log(url);
            let htmlElements = '';
            const postMethod = "POST";
            const contentType ="Content-Type";
            const appJson = "application/json";
            const userId = document.getElementById("userId").textContent;
            let idsession = 0;
            let i = 0;
            let urlAskPage ="http://localhost:8080/masa/member/meeting/ask_question.jsp";
            let userParam = "?user=";
            let meetingParam = "&meeting=";
            const urlThisPage = "http://localhost:8080/masa/member/meeting/followed_meeting.jsp";
            const quotationMarks = '"';
            const container = document.getElementById("container");
            $.getJSON(
                url,
                function (data) {
                    let htmlElements = "";
                    const arr = data["meetingQuestions"];
                    arr.forEach((element) => {
                        var time = new Date().getTime(); // get your number
                        var date = new Date(element.createdDate); // create Date object
                        var stringdatetime = date.toString().replace("GMT+0700 (Indochina Time)",'');
                        idsession = element.id;
                        htmlElements +=
                            '<div class="flex items-center border border-gray-400 rounded-lg shadow lg:flex sm:ml-24 sm:mr-24">' +
                            '      <div class="block h-full py-4 bg-green-600 rounded-lg shadow-inner lg:w-2/12">' +
                            '        <div class="tracking-wide text-center">' +
                            '          <div class="font-bold text-white text-7xl ">24</div>' +
                            '          <div class="text-4xl font-normal text-white">Sept</div>' +
                            "        </div>" +
                            "      </div>" +
                            '      <div class="w-full px-1 py-5 tracking-wide bg-white lg:w-11/12 xl:w-full lg:px-2 lg:py-2">' +
                            '        <div class="px-2 text-4xl font-semibold text-center text-gray-800 lg:text-left">' +
                            element.title +
                            "        </div>" +
                            "" +
                            '        <div class="px-2 pt-1 text-lg font-medium text-center text-gray-600 lg:text-left">' +
                            stringdatetime +
                            "        </div>" +
                            "      </div>" +
                            '      <div class="flex flex-row items-center justify-center w-full px-2 py-4 bg-white lg:w-1/3 lg:justify-end lg:px-0">'


                            +"       " +
                            "      </div>" +
                            "    </div>" +
                            "<hr/>" +
                            "<hr/>" +
                            "      </div>" +
                            "    </div>" +
                            "  </div>" +
                            "<br/>";

                        let container = document.getElementById("container");
                        container.innerHTML = htmlElements;
                    });
                }
            );
        </script>
        <script></script>
    </div>
</section>
<div id="target"></div>
<div id="container"></div>
</body>
</html>
