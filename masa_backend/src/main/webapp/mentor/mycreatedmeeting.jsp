<%@page import="com.devlogs.masa_backend.common.Masa" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Created Meeting</title>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" rel="stylesheet" />
  <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
  <link href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css" rel="stylesheet" />
  <%@include file="/shared/gg_analytics/_analytics_script"%>

  <style>
    body{
      background-color: #00B4CC;
    }
  </style>
  <script>
    function search(){
      const searchMethod = document.getElementById("searchmethod").value;
      const searchKey = document.getElementById("searchkeyword").value;
      const urlForward = "${Masa.SERVER_HOST}/member/searchmeeting.jsp?method="+searchMethod+"&keyword="+searchKey;
      window.location.replace(urlForward);
    }
  </script>
</head>
<body>
<div class="flex w-full h-screen bg-gray-800">
  <!--SideBar-->
  <aside class="relative z-20 flex-shrink-0 w-45 px-2 overflow-y-auto bg-indigo-600 sm:block" style="background-color:#414E62">
    <div class="mb-6">
      <!--User Icon-->
      <div class="flex justify-center">
        <div class="mt-2 bg-gray-300 border-2 border-white rounded-full w-14 h-14">
          <img
                  src="https://cdn.imgbin.com/2/14/6/imgbin-computer-icons-avatar-avatar-XRKxbbuivVKcP1e2BUGHYbx5V.jpg"
                  class="w-auto rounded-full"
          />
        </div>
      </div>
      <!--End of user ivon -->
      <!--NavItem -->
      <div>
        <ul class="px-4 mt-6 leading-10">
          <li  class="flex items-center justify-center p-2 mb-3 bg-indigo-400 rounded-md cursor-pointer" style="background-color: #5bcb7d">
            <a href="${Masa.SERVER_HOST}/member/home.jsp" style="text-decoration:none; ">
              &nbsp;
              <i class="text-white fa fa-home"></i>
              <span style="color: white; padding-top: 0px">Home</span>
              &nbsp;
              &nbsp;
              &nbsp;
            </a>
          </li>
          <li  class="flex items-center justify-center p-2 mb-3 bg-indigo-400 rounded-md cursor-pointer" style="background-color: #f57640">
            <a href="${Masa.SERVER_HOST}/mentor/mycreatedmeeting.jsp?mentor=${sessionScope.CURRENT_USER.getId()}" style="text-decoration:none; ">
              <i class="text-white fa fa-calendar"></i>
              <span style="color: white; padding-top: 0px">Yours</span>
            </a>
          </li>
          <li
                  class="flex items-center justify-center p-2 mb-3 bg-indigo-400 rounded-md cursor-pointer"
          >
            <a href="#footer" style="text-decoration:none; padding-right: 9px">
              &nbsp;
              <i class="text-white fa fa-info-circle"></i>
              <span style="color: white; padding-top: 2px">Contact</span>
              &nbsp;
            </a>
          </li>
          <li class="flex items-center justify-center p-2 mb-3 bg-yellow-400 rounded-md cursor-pointer">
            <a href="${Masa.SERVER_HOST}/auth-management/signout" style="text-decoration:none">
              &nbsp;
              <i class="text-white fas fa-sign-out-alt"></i>
              <span style="color: white; padding-top: 2px">Log Out</span>
              &nbsp;
            </a>
          </li>
        </ul>
      </div>
      <!--End of NavItem -->
    </div>
  </aside>
  <!-- Navigation menu opening with animation -->
  <aside
          style="display: none; width: 300px !important;"
  >
    <div class="mb-12">
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
      </div>
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
                  <div class="relative flex items-center flex-5 w-full h-full lg:w-90 group" style="margin-left: 20px">
                    <a href="${Masa.SERVER_HOST}/member/home.jsp" class="relative block">
                      <img src="https://i.ibb.co/qCg5gr8/masalogo.png" style="width: 50%;"/>
                    </a>
                  </div>
                  <div class="relative flex items-center flex-4 w-full h-full lg:w-90 group">
                    <div class="flex items-center h-12 border border-gray-700 rounded-lg w-30" style="border-color: #414E62; border-width: medium; margin-bottom: 20px">
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
                    <div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </header>
          <div style="padding-right: 30%; width: 100px">
            <iframe src="${Masa.SERVER_HOST}/mentor/mymeeting.jsp" style="width: 1200px; height: 5000px" id="createdmeeting">
            </iframe>
          </div>
          <script>
            document.getElementById("createdmeeting").src = "${Masa.SERVER_HOST}/mentor/mymeeting.jsp"+location.search;
          </script>
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

