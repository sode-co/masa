<%-- Created by IntelliJ IDEA. User: dangminhtien Date: 17/09/2021 Time: 16:50 To change this template use File | Settings | File Templates. --%> <%@
page contentType="text/html;charset=UTF-8" language="java" %> <%@ page import="com.devlogs.masa_backend.common.Masa"%>
<html>
    <head>
        <link rel="shortcut icon" href="${Masa.ICON_URL}" />
        <title>Mentor Profile</title>
        <style>
            body {
                background-color: black;
            }
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
        <link href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css" />
    </head>
    <body>
        <!-- Navigation -->
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
            </div>
        </nav>
        <!-- End of navigation -->

        <!-- Noti -->

        <div
            class="container h-64 overflow-hidden bg-center bg-cover rounded-md"
            style="background-image: url('https://news.blr.com/app/uploads/sites/3/2021/09/shutterstock_1752871988.jpg')"
        >
            <div class="flex items-center h-full bg-gray-900 bg-opacity-50">
                <div class="max-w-xl px-10">
                    <h2 class="text-3xl font-semibold text-white">Hi, ${sessionScope.CURRENT_USER.fullName}, </h2>
                    <p class="mt-3 text-gray-400">Create more meeting for sharing now!</p>
                    <a
                        href="/masa/mentor/meeting/create_meeting.jsp"
                        class="flex items-center px-3 py-2 mt-4 text-sm font-medium text-white uppercase bg-blue-800 rounded  hover:bg-blue-500 focus:outline-none focus:bg-blue-500"
                    >
                        <span style="color: white; font-size: 15px">    Create a new meeting now</span>
                        <svg
                            class="w-15 h-9 mx-2"
                            fill="none"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            stroke-width="2"
                            viewBox="0 0 24 24"
                            stroke="currentColor"
                        >
                            <path d="M17 8l4 4m0 0l-4 4m4-4H3"></path>
                        </svg>
                    </a>
                </div>
            </div>
        </div>


        <!-- End of noti -->
        <%@ include file="../../shared/meeting/_mentor_view_meeting.jsp"%>
        <!-- Footer -->
        <footer class="relative pt-1 bg-white border-b-2 border-blue-700 footer" id="footer">
            <div class="container px-6 mx-auto">
                <div class="sm:flex sm:mt-8">
                    <div class="flex flex-col justify-between mt-8 sm:mt-0 sm:w-full sm:px-8 md:flex-row">
                        <div class="flex flex-col flex-1">
                            <span class="mb-2 font-bold text-center text-green-700 uppercase">A product of Sode team</span>
                            <span class="my-2"
                                ><p class="text-gray-700 text-md">
                                    We created an application that makes it easy for students to create meetings between students and mentors
                                </p></span
                            >
                        </div>
                        <div class="flex flex-col flex-1">
                            <span class="mt-4 mb-2 font-bold text-center text-green-700 uppercase md:mt-0">Contact us</span>
                            <span class="my-2 ml-48">
                                <i class="fab fa-facebook"></i>
                                <a href="#" class="text-gray-700 hover:no-underline text-md hover:text-blue-500">Facebook: Sode Team - SlimAir.Co </a>
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
                                <a href="#" class="text-gray-700 text-md hover:text-blue-500 hover:no-underline">Email: Slimair.co@gmail.com</a></span
                            >
                        </div>
                        <div class="flex flex-col flex-1 place-items-center">
                            <img class="my-2" src="/masa/shared/icon/fpt-university.png" width="50%" height="50%" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="container px-6 mx-auto">
                <div class="flex flex-col items-center mt-16 border-t-2 border-gray-300">
                    <div class="py-6 text-center sm:w-2/3">
                        <p class="mb-2 text-sm font-bold text-gray-700">©2021-Sode Team-FPTU HCM</p>
                    </div>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->
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
