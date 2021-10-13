<%-- Created by IntelliJ IDEA. User: dangminhtien Date: 17/09/2021 Time: 14:28 To change this template use File | Settings | File Templates. --%> <%@
page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head>
        <title>Student Meeting</title>
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
        <!-- End of navigation -->
        <!-- Noti -->
        <!-- <div
      class="container flex items-center mx-auto bg-green-100 rounded-md h-96"
    >
      <div class="text-center sm:ml-20 text-gray-50 sm:text-left">
        <h1 class="mb-4 text-5xl font-bold text-green-800">
          Hi ${sessionScope.CURRENT_USER.fullName}! <br />
        </h1>
        <c:if test = "${sessionScope.CURRENT_USER.getRole() == 'UserRole{type=MEMBER}'}">
          <a
                  class="font-sans text-4xl font-semibold "
                  href="/masa/member/registermentor.jsp"
                  style="background-color: #ff3206; color: white; border-radius: 10px"
          ><button style="width: 300px; height: 40px; ">Register become mentor</button></a>
          <hr/>
        </c:if>
        <p class="inline-block text-3xl text-gray-600 sm:block">
          Many interesting meetings are coming up....
        </p>
      </div>
    </div> -->
        <!-- End of noti -->

        <!-- Notification -->
        <div class="container relative flex flex-col items-center px-8 py-5 mx-auto lg:py-5 lg:flex-row">
            <div class="flex flex-col items-start mt-8 ml-20 sm:w-2/4 sm:mt-0">
                <h1 class="mb-10 text-3xl font-light leading-tight text-center text-blue-700 lg:text-left sm:text-5xl">
                    Hi
                    <strong class="block text-5xl font-black sm:text-4xl">${sessionScope.CURRENT_USER.fullName}!</strong>
                </h1>
                <p class="text-3xl leading-relaxed text-center text-gray-500 lg:text-left sm:text-md lg:pr-40">
                    Many interesting meetings are comming up...
                </p>
                <c:if test="${sessionScope.CURRENT_USER.getRole() == 'UserRole{type=MEMBER}'}">
                    <a
                        href="/masa/member/registermentor.jsp"
                        class="px-8 py-3 mt-8 text-lg font-bold tracking-widest text-white uppercase bg-blue-400 rounded-full hover:bg-blue-500"
                        >Register to become a mentor</a
                    >
                </c:if>
            </div>
            <div class="sm:w-2/4">
                <img class="w-full" src="https://i.pinimg.com/originals/ae/5a/e1/ae5ae16a1f8bdad663c96a699d91e646.jpg" alt="Welcome Student" />
            </div>
        </div>
        <!-- End of notification -->

        <br />
        <div class="relative flex flex-col items-center px-8 py-5 mx-auto bg-white rounded-md lg:py-5 lg:flex-row w-96">
            <h1 class="text-3xl font-bold text-gray-500">Search new meetings by topic</h1>
            <%@ include file="../../shared/topic/_auto_search_topic_name.jsp"%>
        </div>
        <div><%@ include file="../../shared/meeting/_view_new_meeting.jsp"%></div>
        <br />
        <div><%@ include file="../../shared/meeting/_technology_meeting.jsp"%></div>
        <div><%-- <%@ include file="../../shared/meeting/_technology_meeting.jsp"%>--%></div>
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
