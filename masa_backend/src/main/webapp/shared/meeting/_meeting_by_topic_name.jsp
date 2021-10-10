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
    <style>
    </style>
    <script>
    </script>
</head>
<body>
<%--<script>--%>
<%--    const json = {--%>
<%--        "topicName": [--%>
<%--            "Software engineering",--%>
<%--            "Artificial Intelligence",--%>
<%--            "Business management"--%>
<%--        ]--%>
<%--    }--%>
<%--    console.log(json);--%>
<%--    const options = {--%>
<%--        method: 'POST',--%>
<%--        body: JSON.stringify(json),--%>
<%--        headers: {--%>
<%--            'Content-Type': 'application/json'--%>
<%--        }--%>
<%--    }--%>
<%--    fetch('http://localhost:8080/masa/api/meeting-management/topic-name/meetings', options)--%>
<%--        .then(res => res.json())--%>
<%--        .then(res => console.log('success fetch json',res))--%>
<%--        .catch(err => console.error(err));--%>
<%--</script>--%>
<section class="text-gray-600 body-font">
    <div class="container px-5 py-5 mx-auto">
        <div class="flex flex-wrap w-full mb-8">
            <div class="w-full mb-6 lg:mb-0 sm:ml-20">
                <h1
                        class="mb-2 text-5xl font-medium text-gray-900 sm:text-4xl title-font"
                id="notiTopicMeetings">
                    All Meetings About <span id="topicName"></span>
                </h1>
                <div class="w-20 h-1 bg-green-500 rounded"></div>
            </div>
        </div>
        <h1 id="userId" style="display: none">${sessionScope.CURRENT_USER.getId()}</h1>
        <div id="carousel_wrapper1" class="max-w-full overflow-auto md:flex md:justify-center md:space-x-8 md:px-14">
        </div>
    </div>
    <script>
        const keySearch = window.location.search.replace('?&search=','').replace('%20',' ');
        document.getElementById("topicName").innerHTML= keySearch;
        const urlFollow1 = "http://localhost:8080/masa/api/appointment-management/create";
        let container1 = document.getElementById("carousel_wrapper1");
        const url1 =
            "http://localhost:8080/masa/api/meeting-management/not-followed-meetings/" +
            "${sessionScope.CURRENT_USER.getId()}";
        console.log(url1);
        let htmlElements1 = '';
        const postMethod1 = "POST";
        const contentType1 ="Content-Type";
        const appJson1 = "application/json";
        const userId1 = document.getElementById("userId").textContent;
        let idsession1 = 0;
        let followText1 = "Follow";
        let unfollowText1 = "Unfollow";
        let followId1 = "follow";
        let i1 = 0;
        let urlAskPage1 ="http://localhost:8080/masa/member/meeting/ask_question.jsp";
        let userParam1 = "?user=";
        let meetingParam1 = "&meeting=";
        const urlThisPage1 = "http://localhost:8080/masa/member/meeting/index.jsp";
        const quotationMarks1 = '"';
        const successMsg = "Follow Success";
        const json = {
            "topicName": [
                keySearch
            ]
        }
        console.log(json);
        const options = {
            method: 'POST',
            body: JSON.stringify(json),
            headers: {
                'Content-Type': 'application/json'
            }
        }
        fetch('http://localhost:8080/masa/api/meeting-management/topic-name/meetings', options)
            .then(res => res.json())
            .then(res => {
                const arr = res["meetings"];
                const width = arr.length;
                if(width===0){
                    document.getElementById("notiTopicMeetings").innerHTML= "There is no topic about "+keySearch+". Sorry, you can search another topic.";
                }
                arr.forEach((element) => {
                    idsession1 = element.id;
                    htmlElements1 +=
                        '<div class="relative flex flex-col justify-between p-8 lg:p-6 xl:p-8 rounded-2xl mb-11">' +
                        '<div class="absolute inset-0 w-full h-full transform bg-green-50 rounded-2xl">' +
                        '</div><div class="absolute inset-0 w-full h-full border-2 border-gray-900 rounded-2xl">' +
                        '</div><div class="relative flex pb-5 space-x-5 border-b border-gray-200 lg:space-x-3 xl:space-x-5">' +
                        '<div class="relative flex flex-col items-start items-center flex-1">' +
                        '<h3 class="relative text-2xl font-bold text-red-500">' +
                        element.title +
                        '</h3>' +
                        '<h6 style="color: transparent" id="meetingId">' +
                        element.id +
                        '</h6>' +
                        '<p class="tracking-tight text-gray-500"><span class="text-3xl font-bold text-green-700">' +
                        element.startTime +
                        '-' +
                        element.endTime +
                        '</span>' +
                        '</p></div></div><ul class="relative py-12 space-y-3">' +
                        '<li class="flex items-center space-x-2 text-sm font-medium text-gray-500">' +
                        '<svg class="w-6 h-6 text-green-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">' +
                        '<path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd">' +
                        '</path></svg><span>Mentor: mentorF</span></li><li class="flex items-center space-x-2 text-sm font-medium text-gray-500">' +
                        '<svg class="w-6 h-6 text-green-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">' +
                        '<path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd">' +
                        '</path></svg><span>Platform: Zoom</span></li><li class="flex items-center space-x-2 text-sm font-medium text-gray-500">' +
                        '<svg class="w-6 h-6 text-green-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">' +
                        '<path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd"></path></svg>'+'' +
                        '<span>Description</span></li></ul>'


                        +'<a href="" onClick="(function(){'
                        +'const varToString = varObj => Object.keys(varObj)[0];'
                        +'const '+idsession1+'=i1;'
                        +'const x = varToString({'+idsession1+'});'
                        +'const url = urlAskPage1+userParam1+userId1+meetingParam1+x;'
                        +'console.log(url);'
                        +'window.open(url);'
                        +'})();return false;">'
                        +'<button href="#heheh" class="relative flex items-center justify-center w-full px-3 py-3 text-lg font-medium text-white rounded-xl group">'+
                        '<span class="absolute inset-0 w-full h-full transition-all duration-200 ease-out transform bg-green-500 group-hover:translate-y-0 group-hover:translate-x-0 rounded-xl"></span>'+
                        '<span class="absolute inset-0 w-full h-full border-0 border-gray-900 rounded-xl">'
                        +'</span><span class="relative" id="ask">Ask</span>'
                        +'<svg class="w-5 h-5 ml-2 transition-all duration-200 ease-out transform group-hover:translate-x-1" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>'+
                        '</button>'
                        +'</a>'
                        +'<br/>'





                        +'<a href="" onClick="(function(){'
                        +'const varToString = varObj => Object.keys(varObj)[0];'
                        +'const '+idsession1+'=i1;'
                        +'const x = varToString({'+idsession1+'});'
                        +'const url = urlFollow1 + x;'
                        +'const json = {'
                        +'userId: userId1,'
                        +'meetingId: x,'
                        +'};'
                        +'console.log(json);'
                        +'const options = {'
                        +'method: postMethod1,'
                        +'body: JSON.stringify(json),'
                        +'headers: {'
                        +'contentType1: appJson1,'
                        +'},'
                        +'};'
                        +'if (document.getElementById(followId1).textContent === followText1) {'
                        +'fetch(urlFollow1, options)'
                        +'.then((res) => res.json())'
                        +'.then((res) => console.log(res))'
                        +'.catch((err) => console.error(err));'
                        +'alert(successMsg);'
                        +'}'
                        +'})();return false;">'
                        +'<button href="#heheh" class="relative flex items-center justify-center w-full px-3 py-3 text-lg font-medium text-white rounded-xl group">'+
                        '<span class="absolute inset-0 w-full h-full transition-all duration-200 ease-out transform bg-green-500 group-hover:translate-y-0 group-hover:translate-x-0 rounded-xl"></span>'+
                        '<span class="absolute inset-0 w-full h-full border-0 border-gray-900 rounded-xl">'
                        +'</span><span class="relative" id="follow">Follow</span>'
                        +'<svg class="w-5 h-5 ml-2 transition-all duration-200 ease-out transform group-hover:translate-x-1" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>'+
                        '</button>'
                        +'</a>'
                        +'</div>'
                });
                container1.innerHTML = htmlElements1;
            })
            .catch(err => console.error(err));

        container1.innerHTML = htmlElements1;
    </script>
</section>
<div id="target"></div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
        defer
        src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"
        integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"
        crossorigin="anonymous"
></script>
</html>