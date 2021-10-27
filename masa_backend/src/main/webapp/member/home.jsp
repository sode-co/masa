<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.devlogs.masa_backend.common.Masa" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        #overlay {
            position: absolute;
            display: block;
            width: 100%;
            height: 60px;
            top: 0;
            right: 0;
            bottom: 0;
            background-color: white;
            z-index: 2;
            cursor: pointer;
        }
    </style>

    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Home</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
    <link href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>

    <!-- jQuery Modal -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css"/>
    <style>
        .ui-button.ui-corner-all.ui-widget.ui-button-icon-only.ui-dialog-titlebar-close {
            display: none;
        }
    </style>
</head>
<body>

<div class="flex w-full h-screen bg-gray-800" x-data="{openMenu:1}">
    <!--SideBar-->
    <aside class="relative z-20 flex-shrink-0 w-20 px-2 overflow-y-auto bg-indigo-600 sm:block">
        <div class="">
            <!--User Icon-->
            <div class="flex justify-center">
                <div class="mt-2 bg-gray-300 border-2 border-white rounded-full w-14 h-14">
                    <img
                            src="https://cdn-icons.flaticon.com/png/512/3736/premium/3736531.png?token=exp=1634232550~hmac=141946b09c018b139aba2b150055ece6"
                            class="w-auto rounded-full"
                    />
                </div>
            </div>
            <!--End of user ivon -->
            <!--NavItem -->
            <div>
                <ul class="px-4 mt-6 leading-10">
                    <li
                            class="flex items-center justify-center p-2 mb-3 bg-blue-400 rounded-md cursor-pointer"
                            @click="openMenu !== 1 ? openMenu = 1 : openMenu = null"
                    >
                        <i class="text-white fas fa-align-justify fa-sm"></i>
                    </li>
                    <li class="flex items-center justify-center p-2 mb-3 bg-indigo-400 rounded-md cursor-pointer">
                        <i class="text-white fas fa-eye-slash fa-sm"></i>
                    </li>
                    <a href="${Masa.SERVER_HOST}/auth-management/signout">
                        <li class="flex items-center justify-center p-2 mb-3 bg-yellow-400 rounded-md cursor-pointer">
                            <i class="text-white fas fa-sign-out-alt fa-sm"></i>
                        </li>
                    </a>
                </ul>
            </div>
            <!--End of NavItem -->
        </div>
    </aside>

    <!-- Navigation menu opening with animation -->
    <aside
            class="relative z-0 flex-shrink-0 hidden px-4 overflow-hidden bg-gray-100 animate__animated animate__fadeInLeft w-52 sm:block"
            x-show="openMenu ==  1"
            @click.away="openMenu = null"
            style="display: none"
    >
        <div class="mb-6">
            <!--Start Sidebar for open menu -->
            <div class="grid grid-cols-1 grid-cols-2 gap-4 mt-6">
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer"
                     style="background-color: transparent; color: transparent; border-color: transparent; box-shadow: 0 0 transparent">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full"
                         style="background-color: transparent; color: transparent; border-color: transparent; box-shadow: transparent">
                        <i class="text-indigo-600 fas fa-calendar-alt fa-sm"
                           style="background-color: transparent; color: transparent; border-color: transparent; box-shadow: transparent"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#on-going" style="display: none"></a>
                </div>
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer"
                     style="background-color: transparent; color: transparent; border-color: transparent; box-shadow: 0 0 transparent">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full"
                         style="background-color: transparent; color: transparent; border-color: transparent; box-shadow: transparent">
                        <i class="text-indigo-600 fas fa-calendar-alt fa-sm"
                           style="background-color: transparent; color: transparent; border-color: transparent; box-shadow: transparent"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#on-going" style="display: none"></a>
                </div>
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-bell fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#new">New meetings</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-calendar-alt fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#on-going">On-going meetings</a>
                </div>
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-calendar-alt fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#followed">Followed meetings</a>
                </div>
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer"
                     style="background-color: transparent; color: transparent; border-color: transparent; box-shadow: 0 0 transparent">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full"
                         style="background-color: transparent; color: transparent; border-color: transparent; box-shadow: transparent">
                        <i class="text-indigo-600 fas fa-calendar-alt fa-sm"
                           style="background-color: transparent; color: transparent; border-color: transparent; box-shadow: transparent"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#on-going" style="display: none"></a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-laptop fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#scroll-target"
                       onclick="onTopicSelected(1)">Software Engineering</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-pencil-ruler fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#scroll-target"
                       onclick="onTopicSelected(10)">Graphic Design</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-business-time fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#scroll-target"
                       onclick="onTopicSelected(7)">Business management</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-poll fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#scroll-target"
                       onclick="onTopicSelected(2)">Digital Marketing</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-mountain fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#scroll-target"
                       onclick="onTopicSelected(6)">Japanese Language</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-globe-europe fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#meetingbytopic"
                       onclick="onTopicSelected(5)">English Language</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-shield-alt fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#meetingbytopic"
                       onclick="onTopicSelected(3)">Information Assurance</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-robot fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#meetingbytopic"
                       onclick="onTopicSelected(4)">Artificial Intelligence</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-list-alt fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#meetingbytopic"
                       onclick="onTopicSelected(9)">Soft Skills</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-photo-video fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#meetingbytopic"
                       onclick="onTopicSelected(8)">Multimedia</a>
                </div>
                <!-- End Navitem -->
            </div>
            <!--End of Sidebar for open menu-->
        </div>
    </aside>
    <!-- End Navigation menu opening with animation  -->
    <!-- End Sidebar -->
    <div class="flex flex-col flex-1 w-full overflow-y-auto duration-500" style="smooth-scroll:true">
        <main class="relative z-0 flex-1 bg-white">
            <%-- Header            --%>
            <div id="overlay">
                <div class="flex justify-center">
                    <div class="mt-2 bg-gray-100">
                        <%--Search box--%>
                        <div class="mx-auto">
                            <div class="relative">
                                <div class="flex items-center h-10 bg-white border border-gray-200 rounded">
                                    <input name="select" id="select"
                                           class="w-full px-4 text-gray-800 outline-none appearance-none" checked/>

                                    <button class="text-gray-300 transition-all outline-none cursor-pointer focus:outline-none hover:text-gray-600">
                                        <svg
                                                class="w-4 h-4 text-gray-600 fill-current"
                                                xmlns="http://www.w3.org/2000/svg"
                                                xmlns:xlink="http://www.w3.org/1999/xlink"
                                                version="1.1"
                                                id="Capa_1"
                                                x="0px"
                                                y="0px"
                                                viewBox="0 0 56.966 56.966"
                                                xml:space="preserve"
                                                width="512px"
                                                height="60px"
                                        >
                                <path
                                        d="M55.146,51.887L41.588,37.786c3.486-4.144,5.396-9.358,5.396-14.786c0-12.682-10.318-23-23-23s-23,10.318-23,23  s10.318,23,23,23c4.761,0,9.298-1.436,13.177-4.162l13.661,14.208c0.571,0.593,1.339,0.92,2.162,0.92  c0.779,0,1.518-0.297,2.079-0.837C56.255,54.982,56.293,53.08,55.146,51.887z M23.984,6c9.374,0,17,7.626,17,17s-7.626,17-17,17  s-17-7.626-17-17S14.61,6,23.984,6z"
                                />
                            </svg>
                                    </button>
                                    <select id="drop"
                                            class="h-10 pl-5 pr-10 text-gray-600 bg-white border-0 appearance-none hover:border-0 focus:border-0">
                                        <option>Mentor</option>
                                        <option>Meeting</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:if test="${sessionScope.CURRENT_USER.getRole() == 'UserRole{type=MEMBER}'}">
                        <a href="${Masa.SERVER_HOST}/member/registermentor.jsp"
                           class="py-2 font-semibold text-white bg-blue-500 rounded-full px-7 text-md hover:bg-blue-400">Become a mentor now</a>
                    </c:if>
                    <c:if test="${sessionScope.CURRENT_USER.getRole() == 'UserRole{type=MENTOR}'}">
                        <a id="createdmeeting" href="${Masa.SERVER_HOST}/mentor/mycreatedmeeting.jsp"
                           class="py-2 font-semibold text-white bg-blue-500 rounded-full px-7 text-md hover:bg-blue-400">Your Created Meeting</a>
                    </c:if>
                    <c:if test="${sessionScope.CURRENT_USER.getRole() == 'UserRole{type=MENTOR}'}">
                        <a href="${Masa.SERVER_HOST}/mentor/meeting/createnewmeeting.jsp"
                           class="py-2 font-semibold text-white bg-blue-500 rounded-full px-7 text-md hover:bg-blue-400">Create New Meeting</a>
                    </c:if>
                    <h1 id="currentUser" style="display: none">${sessionScope.CURRENT_USER.id}</h1>

                    <script>
                        if (document.getElementById("createdmeeting")) {
                            document.getElementById("createdmeeting").href = "/masa/mentor/mycreatedmeeting.jsp?mentor=" + document.getElementById("currentUser").innerText;
                        }
                    </script>
                </div>
            </div>
    <div class="grid">
        <div class="flex flex-col w-full pl-0">
            <div class="h-screen pt-2 pb-24 pl-2 pr-2 overflow-auto md:pt-0 md:pr-0 md:pl-0">
                <div class="flex flex-col flex-wrap sm:flex-row">
                </div>

                <div style="height: 80px; overflow-y: hidden; overflow-x: auto;">

                </div>

                <div id="new" style="height: 450px; overflow-y: hidden; overflow-x: auto;">
                    <iframe src="${Masa.SERVER_HOST}/shared/meeting/_new_meeting_v2.jsp"
                            id="framenew"
                            style="width: 100%; height: 450px; overflow: hidden; margin-left: 0px; margin-right: 100px; scrollbar-width:none"
                    >
                    </iframe>
                </div>

                <div id="on-going" style="height: 450px; overflow: hidden; overflow-x: auto;">
                    <iframe src="${Masa.SERVER_HOST}/shared/meeting/_on_going_meeting.jsp"
                            style="width: 100%; height: 100%; overflow: hidden; margin-left: 0px; margin-right: 100px; scrollbar-width:none"
                    >
                    </iframe>
                </div>

                <div id="followed" style="height: 450px; overflow: hidden; overflow-x: auto;">
                    <iframe id="iframefollowed" src="${Masa.SERVER_HOST}/shared/meeting/_followed_meeting.jsp"
                            style="width: 100%; height: 100%; overflow: hidden; margin-left: 0px; margin-right: 100px; scrollbar-width:none"
                    >
                    </iframe>
                </div>
                <div id="scroll-target" style="height: 80px; overflow-y: hidden; overflow-x: auto;">

                </div>
                <div id="meetingbytopic" style="height: 1000px; overflow: hidden; overflow-x: auto;">
                    <iframe id="meetingiframe" class="flex flex-col mx-auto"
                            src="${Masa.SERVER_HOST}/shared/meeting/SE_meeting.jsp?topicId=1"
                            style="
                                        width: 100%; height: 100%; overflow: hidden; margin-left: 0px; margin-right: 100px; scrollbar-width:none"
                            scrolling="no"
                    >
                    </iframe>
                </div>
                <div id="ia" style="height: 1500px; overflow: hidden; overflow-x: auto;">
                </div>
                <div id="dialogiframe" class="modal"
                     style="background-color: transparent; border-color: transparent; align-items: center; margin-right: 280px; box-shadow:none; width: 1800px; padding-bottom:10px ">
                    <iframe id="dialogiframeelement" src="${Masa.SERVER_HOST}/shared/layout/dialog.jsp"
                            frameborder="0" style="overflow:hidden; width: 700px; height: 486px; border-radius: 20px;" height="100%" width="120%">

                    </iframe>
                    <%--                            <iframe id="dialogiframeelement" src="http://localhost:8080${Masa.SERVER_HOST}/shared/layout/dialog.jsp"--%>
                    <%--                                    style="background-color: transparent; width: 780px; height: 400px; border-radius: 10px;"> </iframe>--%>
                </div>

                <!-- Link to open the modal -->
                <p><a href="#dialogiframe" rel="modal:close" id="close-modal" style="display: none">close Modal</a></p>
                <p><a href="#dialogiframe" rel="modal:open" id="openiframemodal" style="display: none">Open Modal</a>
                </p>
                <script>
                    function onFollowedMeetingChanged() {
                        console.log("onFollowedMeetingChanged");
                        let followedIframe = document.getElementById('iframefollowed');
                        followedIframe.contentDocument.location.reload(true);
                        followedIframe.src = "${Masa.SERVER_HOST}/shared/meeting/_followed_meeting.jsp";
                    }

                    function onTopicSelected(topicId) {
                        document.getElementById('meetingiframe').src = "${Masa.SERVER_HOST}/shared/meeting/SE_meeting.jsp?topicId=" + topicId;
                    }

                    function calldialog(param, param01) {
                        if (param01) {
                            document.getElementById('dialogiframeelement').src = "${Masa.SERVER_HOST}/shared/layout/dialog.jsp?id=" + param + "&followed=" + param01;
                        } else {
                            document.getElementById('dialogiframeelement').src = "${Masa.SERVER_HOST}/shared/layout/dialog.jsp?id=" + param;
                        }
                        $(document).ready(function () {
                            $('#openiframemodal').click();
                        });
                    }

                    function autoclick() {
                        $(document).ready(function () {
                            $('#close-modal').click();
                        });
                    }
                </script>
            </div>
        </div>
    </div>
    </main>
</div>
</div>
</body>
</html>
