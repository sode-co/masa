<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Created by IntelliJ IDEA. User: Ngoc Thieu Date: 9/19/2021 Time: 1:11 PM To
change this template use File | Settings | File Templates. --%> <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>View My Meeting (mentor)</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
        <link href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css" />
        <script
            defer
            src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"
            integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"
            crossorigin="anonymous"
        ></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style></style>
        <script></script>
    </head>
    <body>
        <section class="text-gray-600 body-font">
            <div class="container px-5 py-5 mx-auto">
                <div class="flex flex-wrap w-full mb-8">
                    <div class="w-full mb-6 lg:mb-0 sm:ml-20">
                        <h1 class="mb-2 text-5xl font-medium text-gray-900 sm:text-4xl title-font">Meeting</h1>
                        <div class="w-20 h-1 bg-purple-500 rounded"></div>
                    </div>
                </div>
                <h1 id="userId" style="display: none">${sessionScope.CURRENT_USER.getId()}</h1>
                <script>
                    const container = document.getElementById("container");
                    $.getJSON("http://localhost:8080/masa/api/meeting-management/meetings", function (data) {
                        let htmlElements = "";
                        const arr = data["meetings"];
                        arr.forEach((element) => {
                            htmlElements +=
                                '<h1 id="meetingId" style="display: none">' +
                                element.id +
                                "</h1>" +
                                '<div class="relative flex flex-col justify-between flex-1 max-w-md p-8 lg:p-6 xl:p-8 rounded-2xl mb-11">' +
                                '<div class="absolute inset-0 w-full h-full transform bg-white rounded-2xl">' +
                                '</div><div class="absolute inset-0 w-full h-full border-2 border-gray-900 rounded-2xl">' +
                                '</div><div class="relative flex pb-5 space-x-5 border-b border-gray-200 lg:space-x-3 xl:space-x-5">' +
                                '<div class="relative flex flex-col items-start items-center flex-1">' +
                                '<h3 class="relative text-2xl font-bold text-red-500">' +
                                element.title +
                                "</h3>" +
                                '<h6 style="color: transparent" id="meetingId">' +
                                element.id +
                                "</h6>" +
                                '<p class="tracking-tight text-gray-500"><span class="text-3xl font-bold text-green-700">' +
                                element.startTime +
                                "-" +
                                element.endTime +
                                "</span>" +
                                '</p></div></div><ul class="relative py-12 space-y-3">' +
                                '<li class="flex items-center space-x-2 text-sm font-medium text-gray-500">' +
                                '<svg class="w-6 h-6 text-green-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">' +
                                '<path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd">' +
                                '</path></svg><span>Mentor: mentorF</span></li><li class="flex items-center space-x-2 text-sm font-medium text-gray-500">' +
                                '<svg class="w-6 h-6 text-green-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">' +
                                '<path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd">' +
                                '</path></svg><span>Platform: Zoom</span></li><li class="flex items-center space-x-2 text-sm font-medium text-gray-500">' +
                                '<svg class="w-6 h-6 text-green-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">' +
                                '<path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd"></path></svg>' +
                                "" +
                                "<span>Description</span></li></ul>" +
                                '<a href="" onClick="(function(){' +
                                "const varToString = varObj => Object.keys(varObj)[0];" +
                                "const " +
                                idsession +
                                "=i;" +
                                "const x = varToString({" +
                                idsession +
                                "});" +
                                "const url = urlAskPage+userParam+userId+meetingParam+x;" +
                                "console.log(url);" +
                                "window.open(url);" +
                                '})();return false;">' +
                                '<button href="#heheh" class="relative flex items-center justify-center w-full px-3 py-3 text-lg font-medium text-white rounded-xl group">' +
                                '<span class="absolute inset-0 w-full h-full transition-all duration-200 ease-out transform bg-purple-500 group-hover:translate-y-0 group-hover:translate-x-0 rounded-xl"></span>' +
                                '<span class="absolute inset-0 w-full h-full border-0 border-gray-900 rounded-xl">' +
                                '</span><span class="relative" id="ask">Ask</span>' +
                                '<svg class="w-5 h-5 ml-2 transition-all duration-200 ease-out transform group-hover:translate-x-1" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>' +
                                "</button>" +
                                "</a>" +
                                "<br/>" +
                                '<a href="" onClick="(function(){' +
                                "const varToString = varObj => Object.keys(varObj)[0];" +
                                "const " +
                                idsession +
                                "=i;" +
                                "const x = varToString({" +
                                idsession +
                                "});" +
                                "const url = urlFollow + x;" +
                                "const json = {" +
                                "userId: userId," +
                                "meetingId: x," +
                                "};" +
                                "console.log(json);" +
                                "const options = {" +
                                "method: postMethod," +
                                "body: JSON.stringify(json)," +
                                "headers: {" +
                                "contentType: appJson," +
                                "}," +
                                "};" +
                                "if (document.getElementById(followId).textContent === followText) {" +
                                "fetch(urlFollow, options)" +
                                ".then((res) => res.json())" +
                                ".then((res) => console.log(res))" +
                                ".catch((err) => console.error(err));" +
                                "window.location.replace(urlThisPage)" +
                                "}" +
                                '})();return false;">' +
                                '<button href="#heheh" class="relative flex items-center justify-center w-full px-3 py-3 text-lg font-medium text-white rounded-xl group">' +
                                '<span class="absolute inset-0 w-full h-full transition-all duration-200 ease-out transform bg-purple-500 group-hover:translate-y-0 group-hover:translate-x-0 rounded-xl"></span>' +
                                '<span class="absolute inset-0 w-full h-full border-0 border-gray-900 rounded-xl">' +
                                '</span><span class="relative" id="follow">Follow</span>' +
                                '<svg class="w-5 h-5 ml-2 transition-all duration-200 ease-out transform group-hover:translate-x-1" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>' +
                                "</button>" +
                                "</a>" +
                                "</div>";

                            // Meeting
                            //                   '<div class="flex items-center border border-gray-400 rounded-lg shadow lg:flex sm:ml-24 sm:mr-24">' +
                            //                   '      <div class="block h-full py-4 bg-purple-600 rounded-lg shadow-inner lg:w-2/12">' +
                            //                   '        <div class="tracking-wide text-center">' +
                            //                   '          <div class="font-bold text-white text-7xl ">24</div>' +
                            //                   '          <div class="text-4xl font-normal text-white">Sept</div>' +
                            //                   "        </div>" +
                            //                   "      </div>" +
                            //                   '      <div class="w-full px-1 py-5 tracking-wide bg-white lg:w-11/12 xl:w-full lg:px-2 lg:py-2">' +
                            //                   '        <div class="flex flex-row justify-center lg:justify-start">' +
                            //                   '          <div class="px-2 text-lg font-medium text-center text-gray-700 lg:text-left">' +
                            //                   '            <i class="far fa-clock"></i> ' +
                            //                   element.startTime +
                            //                   "-" +
                            //                   element.endTime +
                            //                   "          </div>" +
                            //                   '          <div class="px-2 text-lg font-medium text-center text-gray-700 lg:text-left">' +
                            //                   "            Mentor : " +
                            //                   element.hostId +
                            //                   "          </div>" +
                            //                   "        </div>" +
                            //                   '        <div class="px-2 text-4xl font-semibold text-center text-gray-800 lg:text-left">' +
                            //                   element.title +
                            //                   "        </div>" +
                            //                   "" +
                            //                   '        <div class="px-2 pt-1 text-lg font-medium text-center text-gray-600 lg:text-left">' +
                            //                   element.description +
                            //                   "        </div>" +
                            //                   "      </div>" +
                            //                   '      <div class="flex flex-row items-center justify-center w-full px-2 py-4 bg-white lg:w-1/3 lg:justify-end lg:px-0">' +
                            //                   '    <button type="button" class="px-4 mx-4 text-lg font-semibold leading-loose tracking-wider text-green-800 bg-purple-200 rounded" data-toggle="modal" data-target="#exampleModalCenter" style="background-color: #d1fae5; border: #d1fae5; color: black; font-weight: bold">' +
                            //                   "        See more" +
                            //                   "    </button>" +
                            //                   "       " +
                            //                   "      </div>" +
                            //                   "    </div>" +
                            //                   "<hr/>" +
                            //                   "<hr/>" +
                            // //backup

                            // '<div class="p-5 bg-light bg-secondary" style="width: 70%; margin-left: 10%; border: solid; border-radius: 10px; padding-left: 10%; padding-bottom: 20px;  padding-top: 20px" id="info">' +
                            // '<p class="header" style="font-weight: bold; font-size: larger">' +
                            // element.title +
                            // "</p>" +
                            // '<div class="center">' +
                            // '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">' +
                            // '<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>' +
                            // '<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>' +
                            // "</svg>" +
                            // "&nbsp;" +
                            // "<span>Mentor:</span>" +
                            // "&nbsp;" +
                            // "<span>" +
                            // element.hostId +
                            // "</span>" +
                            // "</div>" +
                            // "&nbsp;" +
                            // '<div class="description">' +
                            // '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-card-heading" viewBox="0 0 16 16">' +
                            // '<path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>' +
                            // '<path d="M3 8.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5zm0-5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5v-1z"/>' +
                            // "</svg>" +
                            // "&nbsp;" +
                            // "<span>Description:</span>" +
                            // "&nbsp;" +
                            // "<span>" +
                            // element.description +
                            // "</span>" +
                            // "</div>" +
                            // "&nbsp;" +
                            // "<div>" +
                            // '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar4-week" viewBox="0 0 16 16">' +
                            // '<path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1H2zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V5z"/>' +
                            // '<path d="M11 7.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-2 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>' +
                            // "</svg>" +
                            // "&nbsp;" +
                            // "<span>Start:</span>" +
                            // "&nbsp;" +
                            // "<span>" +
                            // element.startTime +
                            // "</span>" +
                            // "</div>" +
                            // "&nbsp;" +
                            // "<div>" +
                            // '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar4-week" viewBox="0 0 16 16">' +
                            // '<path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1H2zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V5z"/>' +
                            // '<path d="M11 7.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-2 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>' +
                            // "</svg>" +
                            // "&nbsp;" +
                            // "<span>End:</span>" +
                            // "&nbsp;" +
                            // "<span>" +
                            // element.endTime +
                            // "</span>" +
                            // "</div>" +
                            // "&nbsp;" +
                            // "<br/>" +
                            // '    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter" style="background-color: #d1fae5; border: #d1fae5; color: black; font-weight: bold">' +
                            // "        See more" +
                            // "    </button>" +
                            // "</div>" +

                            // '<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">' +
                            // '<div class="modal-dialog modal-dialog-centered" role="document">' +
                            // '<div class="modal-content">' +
                            // '<div class="modal-header">' +
                            // '<h5 class="modal-title" id="exampleModalLongTitle">' +
                            // element.title +
                            // "</h5>" +
                            // '<button type="button" class="close" data-dismiss="modal" aria-label="Close">' +
                            // '<span aria-hidden="true">&times;</span>' +
                            // "</button>" +
                            // "</div>" +
                            // '<div class="modal-body">' +
                            // '<div class="center">' +
                            // '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">' +
                            // '<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>' +
                            // '<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>' +
                            // "</svg>" +
                            // "&nbsp;" +
                            // "<span>Mentor:</span>" +
                            // "&nbsp;" +
                            // "<span>" +
                            // element.hostId +
                            // "</span>" +
                            // "</div>" +
                            // '<div class="platform">' +
                            // '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pin-map-fill" viewBox="0 0 16 16">' +
                            // '<path fill-rule="evenodd" d="M3.1 11.2a.5.5 0 0 1 .4-.2H6a.5.5 0 0 1 0 1H3.75L1.5 15h13l-2.25-3H10a.5.5 0 0 1 0-1h2.5a.5.5 0 0 1 .4.2l3 4a.5.5 0 0 1-.4.8H.5a.5.5 0 0 1-.4-.8l3-4z"/>' +
                            // '<path fill-rule="evenodd" d="M4 4a4 4 0 1 1 4.5 3.969V13.5a.5.5 0 0 1-1 0V7.97A4 4 0 0 1 4 3.999z"/>' +
                            // "</svg>" +
                            // "&nbsp;" +
                            // "<span>Platform:</span>" +
                            // "&nbsp;" +
                            // "<span>" +
                            // element.platform.platform +
                            // "</span>" +
                            // "</div>" +
                            // '<div class="url">' +
                            // '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-link-45deg" viewBox="0 0 16 16">' +
                            // '<path d="M4.715 6.542 3.343 7.914a3 3 0 1 0 4.243 4.243l1.828-1.829A3 3 0 0 0 8.586 5.5L8 6.086a1.002 1.002 0 0 0-.154.199 2 2 0 0 1 .861 3.337L6.88 11.45a2 2 0 1 1-2.83-2.83l.793-.792a4.018 4.018 0 0 1-.128-1.287z"/>' +
                            // '<path d="M6.586 4.672A3 3 0 0 0 7.414 9.5l.775-.776a2 2 0 0 1-.896-3.346L9.12 3.55a2 2 0 1 1 2.83 2.83l-.793.792c.112.42.155.855.128 1.287l1.372-1.372a3 3 0 1 0-4.243-4.243L6.586 4.672z"/>' +
                            // "</svg>" +
                            // "&nbsp;" +
                            // "<span>Location:</span>" +
                            // "&nbsp;" +
                            // "<a href=" +
                            // element.platform.url +
                            // ">" +
                            // element.platform.url +
                            // "</a>" +
                            // "</div>" +
                            // "<div>" +
                            // '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar4-week" viewBox="0 0 16 16">' +
                            // '<path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1H2zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V5z"/>' +
                            // '<path d="M11 7.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-2 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>' +
                            // "</svg>" +
                            // "&nbsp;" +
                            // "<span>Start:</span>" +
                            // "&nbsp;" +
                            // "<span>" +
                            // element.startTime +
                            // "</span>" +
                            // "</div>" +
                            // "<div>" +
                            // '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar4-week" viewBox="0 0 16 16">' +
                            // '<path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1H2zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V5z"/>' +
                            // '<path d="M11 7.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-2 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>' +
                            // "</svg>" +
                            // "&nbsp;" +
                            // "<span>End:</span>" +
                            // "&nbsp;" +
                            // "<span>" +
                            // element.endTime +
                            // "</span>" +
                            // "</div>" +
                            // "</div>" +
                            // '<div class="modal-footer">' +
                            // '<button type="button" class="btn btn-primary" data-dismiss="modal" style="background-color: #d1fae5; border: #d1fae5; color: black; font-weight: bold">Close</button>' +
                            // "</div>" +
                            // "        </div>" +
                            // "</div>" +
                            // "</div>" +
                            //Noti dialog
                            // '<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">' +
                            // '<div class="modal-dialog modal-dialog-centered" role="document">' +
                            // '<div class="modal-content">' +
                            // '<div class="modal-header">' +
                            // "    <div>" +
                            // '      <span class="relative inline-block font-medium tracking-widest text-gray-900 uppercase date modal-title">24 Sept</span>' +
                            // '      <div class="flex mb-2 modal-body">' +
                            // '        <div class="w-2/12">' +
                            // '          <span class="block text-xl text-gray-600">' +
                            // element.startTime +
                            // "</span>" +
                            // '          <span class="block text-xl text-gray-600">' +
                            // element.endTime +
                            // "</span>" +
                            // "        </div>" +
                            // '        <div class="w-1/12">' +
                            // '          <span class="block w-2 h-2 mt-2 bg-blue-400 rounded-full"></span>' +
                            // "        </div>" +
                            // '        <div class="w-9/12">' +
                            // '          <span class="block text-xl font-semibold">' +
                            // element.title +
                            // "</span>" +
                            // '          <span class="text-xl">' +
                            // element.hostId +
                            // "</span>" +
                            // "        </div>" +
                            // "      </div>" +
                            // '      <div class="flex mb-4 modal-body">' +
                            // '        <div class="w-2/12">' +
                            // '<span class="block text-xl text-gray-600">Platform </span>' +
                            // '          <span class="block text-xl text-gray-600">Detail </span>' +
                            // "        </div>" +
                            // '        <div class="w-1/12">' +
                            // '          <span class="block w-2 h-2 mt-2 bg-red-400 rounded-full"></span>' +
                            // "        </div>" +
                            // '        <div class="w-9/12">' +
                            // '          <span class="block text-xl font-semibold">' +
                            // element.platform.platform +
                            // "</span>" +
                            // "<a href=" +
                            // element.platform.url +
                            // '"' +
                            // 'class="text-xl">' +
                            // element.platform.url +
                            // "</a>" +
                            // "        </div>" +
                            // "      </div>" +
                            // "    </div>" +
                            // "  </div>" +
                            // '<div class="modal-footer">' +
                            // '<button type="button" class="btn btn-primary" data-dismiss="modal" style="background-color: #d1fae5; border: #d1fae5; color: black; font-weight: bold">Close</button>' +
                            // "</div>" +
                            // "      </div>" +
                            // "    </div>" +
                            // "  </div>" +
                            // "<br/>";

                            let container = document.getElementById("container");
                            container.innerHTML = htmlElements;
                        });
                    });
                </script>
                <script></script>
            </div>
        </section>
        <div id="target"></div>
        <div id="container"></div>
    </body>
</html>
