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
        function unfollow() {
                //Nhowf Tien xu ly not dum tui phan Unfollow tai doan nay nha: shared/meeting/_view_all_meeting
        }
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
                    Meeting
                </h1>
                <div class="w-20 h-1 bg-green-500 rounded"></div>
            </div>
        </div>
        <h1 id="userId" style="display: none">
            ${sessionScope.CURRENT_USER.getId()}
        </h1>
        <h1>Followed Meeting</h1>
        <script>
            <%--var urlTest = "http://localhost:8080/masa/api/meeting-management/followed-meetings/${CURRENT_USER.getId()}";--%>
            <%--console.log('urlTest :'+urlTest);--%>
            <%--console.log('id current user:  ${CURRENT_USER.getId()}');--%>
            const container = document.getElementById("container");
            $.getJSON(
                'http://localhost:8080/masa/api/meeting-management/followed-meetings/SE100001',
                <%--'http://localhost:8080/masa/api/meeting-management/followed-meetings/${CURRENT_USER.getId()}',--%>
                function (data) {
                    let htmlElements = "";
                    const arr = data["meetings"];
                    arr.forEach((element) => {
                        htmlElements +=
                            '<h1 id="meetingId" style="display: none">' +
                            element.id +
                            "</h1>" +
                            '<div class="p-5 bg-light bg-secondary" style="width: 70%; margin-left: 10%; border: solid; border-radius: 10px; padding-left: 10%; padding-bottom: 20px;  padding-top: 20px" id="info">' +
                            '<p class="header" style="font-weight: bold; font-size: larger">' +
                            element.title +
                            "</p>" +
                            '<div class="center">' +
                            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">' +
                            '<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>' +
                            '<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>' +
                            "</svg>" +
                            "&nbsp;" +
                            "<span>Mentor:</span>" +
                            "&nbsp;" +
                            "<span>" +
                            element.hostId +
                            "</span>" +
                            "</div>" +
                            "&nbsp;" +
                            '<div class="description">' +
                            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-card-heading" viewBox="0 0 16 16">' +
                            '<path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>' +
                            '<path d="M3 8.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5zm0-5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5v-1z"/>' +
                            "</svg>" +
                            "&nbsp;" +
                            "<span>Description:</span>" +
                            "&nbsp;" +
                            "<span>" +
                            element.description +
                            "</span>" +
                            "</div>" +
                            "&nbsp;" +
                            "<div>" +
                            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar4-week" viewBox="0 0 16 16">' +
                            '<path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1H2zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V5z"/>' +
                            '<path d="M11 7.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-2 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>' +
                            "</svg>" +
                            "&nbsp;" +
                            "<span>Start:</span>" +
                            "&nbsp;" +
                            "<span>" +
                            element.startTime +
                            "</span>" +
                            "</div>" +
                            "&nbsp;" +
                            "<div>" +
                            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar4-week" viewBox="0 0 16 16">' +
                            '<path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1H2zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V5z"/>' +
                            '<path d="M11 7.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-2 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>' +
                            "</svg>" +
                            "&nbsp;" +
                            "<span>End:</span>" +
                            "&nbsp;" +
                            "<span>" +
                            element.endTime +
                            "</span>" +
                            "</div>" +
                            "&nbsp;" +
                            "<br/>" +
                            '    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter" style="background-color: #d1fae5; border: #d1fae5; color: black; font-weight: bold">' +
                            "        See more" +
                            "    </button>" +
                            "</div>" +
                            "<hr/>" +
                            '<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">' +
                            '<div class="modal-dialog modal-dialog-centered" role="document">' +
                            '<div class="modal-content">' +
                            '<div class="modal-header">' +
                            '<h5 class="modal-title" id="exampleModalLongTitle">' +
                            element.title +
                            "</h5>" +
                            '<button type="button" class="close" data-dismiss="modal" aria-label="Close">' +
                            '<span aria-hidden="true">&times;</span>' +
                            "</button>" +
                            "</div>" +
                            '<div class="modal-body">' +
                            '<div class="center">' +
                            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">' +
                            '<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>' +
                            '<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>' +
                            "</svg>" +
                            "&nbsp;" +
                            "<span>Mentor:</span>" +
                            "&nbsp;" +
                            "<span>" +
                            element.hostId +
                            "</span>" +
                            "</div>" +
                            '<div class="platform">' +
                            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pin-map-fill" viewBox="0 0 16 16">' +
                            '<path fill-rule="evenodd" d="M3.1 11.2a.5.5 0 0 1 .4-.2H6a.5.5 0 0 1 0 1H3.75L1.5 15h13l-2.25-3H10a.5.5 0 0 1 0-1h2.5a.5.5 0 0 1 .4.2l3 4a.5.5 0 0 1-.4.8H.5a.5.5 0 0 1-.4-.8l3-4z"/>' +
                            '<path fill-rule="evenodd" d="M4 4a4 4 0 1 1 4.5 3.969V13.5a.5.5 0 0 1-1 0V7.97A4 4 0 0 1 4 3.999z"/>' +
                            "</svg>" +
                            "&nbsp;" +
                            "<span>Platform:</span>" +
                            "&nbsp;" +
                            "<span>" +
                            element.platform.platform +
                            "</span>" +
                            "</div>" +
                            '<div class="url">' +
                            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-link-45deg" viewBox="0 0 16 16">' +
                            '<path d="M4.715 6.542 3.343 7.914a3 3 0 1 0 4.243 4.243l1.828-1.829A3 3 0 0 0 8.586 5.5L8 6.086a1.002 1.002 0 0 0-.154.199 2 2 0 0 1 .861 3.337L6.88 11.45a2 2 0 1 1-2.83-2.83l.793-.792a4.018 4.018 0 0 1-.128-1.287z"/>' +
                            '<path d="M6.586 4.672A3 3 0 0 0 7.414 9.5l.775-.776a2 2 0 0 1-.896-3.346L9.12 3.55a2 2 0 1 1 2.83 2.83l-.793.792c.112.42.155.855.128 1.287l1.372-1.372a3 3 0 1 0-4.243-4.243L6.586 4.672z"/>' +
                            "</svg>" +
                            "&nbsp;" +
                            "<span>Location:</span>" +
                            "&nbsp;" +
                            "<a href=" +
                            element.platform.url +
                            ">" +
                            element.platform.url +
                            "</a>" +
                            "</div>" +
                            "<div>" +
                            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar4-week" viewBox="0 0 16 16">' +
                            '<path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1H2zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V5z"/>' +
                            '<path d="M11 7.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-2 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>' +
                            "</svg>" +
                            "&nbsp;" +
                            "<span>Start:</span>" +
                            "&nbsp;" +
                            "<span>" +
                            element.startTime +
                            "</span>" +
                            "</div>" +
                            "<div>" +
                            '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar4-week" viewBox="0 0 16 16">' +
                            '<path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1H2zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V5z"/>' +
                            '<path d="M11 7.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-2 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>' +
                            "</svg>" +
                            "&nbsp;" +
                            "<span>End:</span>" +
                            "&nbsp;" +
                            "<span>" +
                            element.endTime +
                            "</span>" +
                            "</div>" +
                            "</div>" +
                            '<div class="modal-footer">' +
                            '<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="unfollow()" id="follow" style="background-color: #d1fae5; border: #d1fae5; color: black; font-weight: bold">Unfollow</button>' +
                            "</div>" +
                            "        </div>" +
                            "</div>" +
                            "</div>" +
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
