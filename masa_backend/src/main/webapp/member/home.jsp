<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
    <link href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css" />
</head>
<body>
<div class="flex w-full h-screen bg-gray-800" x-data="{openMenu:1}">
    <!--SideBar-->
    <aside class="relative z-20 flex-shrink-0 w-20 px-2 overflow-y-auto bg-indigo-600 sm:block">
        <div class="mb-6">
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
                    <li class="flex items-center justify-center p-2 mb-3 bg-yellow-400 rounded-md cursor-pointer">
                        <i class="text-white fas fa-sign-out-alt fa-sm"></i>
                    </li>
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
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-laptop fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#se">Software Engineering</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-pencil-ruler fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#gd">Graphic Design</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-business-time fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#bm">Business management</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-poll fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#dm">Digital Marketing</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-mountain fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#jl">Japanese Language</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-globe-europe fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#el">English Language</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-shield-alt fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#ia">Information Assurance</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-robot fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#ai">Artificial Intelligence</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-list-alt fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#ss">Soft Skills</a>
                </div>
                <!-- End Navitem -->
                <!-- Start Navitem -->
                <div class="flex flex-col items-center justify-center p-2 bg-white rounded-md shadow-xl cursor-pointer">
                    <div class="flex flex-col items-center p-2 bg-indigo-200 rounded-full">
                        <i class="text-indigo-600 fas fa-photo-video fa-sm"></i>
                    </div>
                    <a class="mt-1 text-xs font-semibold text-center" href="#mt">Multimedia</a>
                </div>
                <!-- End Navitem -->
            </div>
            <!--End of Sidebar for open menu-->
        </div>
    </aside>
    <!-- End Navigation menu opening with animation  -->

    <!-- End Sidebar -->
    <div class="flex flex-col flex-1 w-full overflow-y-auto">
        <main class="relative z-0 flex-1 px-6 pb-8 bg-white">
            <div class="grid pb-10 mt-4">
                <div class="flex flex-col w-full pl-0 md:p-4 md:space-y-4">
                    <header class="z-40 items-center w-full h-16 bg-white shadow-lg dark:bg-gray-700 rounded-2xl">
                        <div class="relative z-20 flex flex-col justify-center h-full px-3 mx-auto flex-center">
                            <div class="relative flex items-center w-full pl-1 lg:max-w-68 sm:pr-2 sm:ml-0">
                                <div class="container relative left-0 z-50 flex w-full h-auto h-full">
                                    <div class="relative flex items-center flex-1 w-full h-full lg:w-90 group">
                                        <a href="#" class="relative block">
                                            <img src="../icon/weblogo.svg" alt="Logo" width="30%" height="30%" />
                                        </a>
                                    </div>
                                    <c:if test = "${sessionScope.CURRENT_USER.getRole() == 'UserRole{type=STUDENT}'}">
                                        <div class="relative flex items-center justify-end flex-1 w-1/4 p-1 ml-5 mr-4 sm:mr-0 sm:right-auto">
                                            <span style="margin-left: 100px; font-style: oblique">Happy learning - Happy money</span>
                                        </div>
                                    </c:if>
                                    <c:if test = "${sessionScope.CURRENT_USER.getRole() == 'UserRole{type=MEMBER}'}">
                                        <a href="/masa/member/registermentor.jsp" class="py-2 font-semibold text-white bg-blue-500 rounded-full px-7 text-md hover:bg-blue-400"
                                        >Become a mentor now</a
                                        >
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </header>
                    <div class="h-screen pt-2 pb-24 pl-2 pr-2 overflow-auto md:pt-0 md:pr-0 md:pl-0">
                        <div class="flex flex-col flex-wrap sm:flex-row">
                            <%--                            <div class="container flex flex-col-reverse items-center px-6 mx-auto sm:px-12 sm:flex-row">--%>
                            <%--                                <div class="flex flex-col items-start mt-8 sm:w-2/5 sm:mt-0">--%>
                            <%--                                    <h1 class="mb-3 lg:text-3xl sm:mb-3">Hi</h1>--%>
                            <%--                                    <h1 class="mb-4 text-3xl leading-none lg:text-3xl">--%>
                            <%--                                        <strong class="font-black">@name</strong>--%>
                            <%--                                    </h1>--%>
                            <%--                                    <a href="#" class="py-2 font-semibold text-white bg-blue-500 rounded-full px-7 text-md hover:bg-blue-400"--%>
                            <%--                                    >Become a mentor now</a--%>
                            <%--                                    >--%>
                            <%--                                </div>--%>
                            <%--                                <div class="sm:w-3/5">--%>
                            <%--                                    <img--%>
                            <%--                                            src="https://info.ehl.edu/hubfs/Blog-EHL-Insights/Blog-Header-EHL-Insights/invest%20-education.jpg"--%>
                            <%--                                            alt=""--%>
                            <%--                                    />--%>
                            <%--                                </div>--%>
                        </div>

                        <div id="new">

                            <%@include  file="/shared/layout/newside.html"%>
                        </div>

                        <div id="on-going">
                            <!-- Bỏ On-going meeting vào đây nha -->
                        </div>
                        <div id="se">
                            <!-- Bỏ Software engineer meeting vào đây nha  -->
                        </div>
                        <div id="gd">
                            <!-- Bỏ Graphic Design meeting vào đây nha -->
                        </div>
                        <div id="bm">
                            <!-- Bỏ Business Management meeting vào đây nha -->
                        </div>
                        <div id="dm">
                            <!-- Bỏ Digital Marketing meeting vào đây nha -->
                        </div>
                        <div id="jl">
                            <!-- Bỏ Japanese Language meeting vào đây nha -->
                        </div>
                        <div id="el">
                            <!-- Bỏ English Language meeting vào đây nha -->
                        </div>
                        <div id="ia">
                            <!-- Bỏ IA meeting vào đây nha -->
                        </div>
                        <div id="ai">
                            <!-- Bỏ AI meeting vào đây nha -->
                        </div>
                        <div id="ss">
                            <!-- Bỏ Soft skill meeting vào đây nha -->
                        </div>
                        <div id="mt">
                            <!-- Bỏ Multimedia meeting vào đây nha -->
                        </div>
                    </div>
                </div>
            </div>
    </main>
</div>
</div>
</body>
</html>

<!-- Search properties
<div
class="absolute z-50 flex items-center justify-center block w-auto w-1/3 h-10 p-3 pr-2 text-sm text-gray-500 uppercase cursor-pointer sm:hidden"
> -->