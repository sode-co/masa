<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.devlogs.masa_backend.common.Masa" %>

<html>
<head>
  <script src="https://unpkg.com/tailwindcss-jit-cdn"></script>
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
<header id="overlay">
  <nav class=" bg-white flex justify-between px-6 border-0">
    <div class="flex items-center space-x-12">
      <div class="flex items-center space-x-2 text-2xl">
        <img src="https://i.ibb.co/qCg5gr8/masalogo.png" style="width: 50%;"/>
      </div>
      <div class="hidden lg:block hover:border-red-300 focus:border-red-300" style="border-radius: 10px; border-color: #00B4CC">
        <div class="relative">
          <div class="flex flex-col flex-1 float-left">
            <div class="">
              <div class="relative">
                <div class="flex items-center h-12 border border-gray-700 rounded-lg w-30" style="border-color: #414E62; border-width: medium">
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
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="items-center hidden space-x-4 cursor-pointer lg:flex">

      <c:if test="${sessionScope.CURRENT_USER.getRole() == 'UserRole{type=MEMBER}'}">
      <a href="${Masa.SERVER_HOST}/member/registermentor.jsp"
           class="bg-gray-600 border-0  hover:bg-gray-900 text-white font-semibold hover:text-white py-2 px-4 border border-green-600 hover:border-transparent rounded">Become mentor</a>
      </c:if>

      <c:if test="${sessionScope.CURRENT_USER.getRole() == 'UserRole{type=MENTOR}'}">
        <a id="createdmeeting" href="${Masa.SERVER_HOST}/mentor/mycreatedmeeting.jsp?mentor=${sessionScope.CURRENT_USER.getId()}"
           class="bg-transparent hover:bg-yellow-500 text-gray font-semibold hover:text-white py-2 px-4 border border-yellow-500 hover:border-transparent rounded">Your Meetings</a>
        <a href="${Masa.SERVER_HOST}/mentor/meeting/createnewmeeting.jsp"
           class="bg-green-500 border-0 hover:bg-green-700 text-white font-semibold hover:text-white py-2 px-4 border border-green-600 hover:border-transparent rounded">New Meeting</a>
      </c:if>

      <div>
        <div
                class="w-10 h-10 rounded-full"

        />
      </div>
      </script>
    </div>
    <div class="space-y-1.5 cursor-pointer lg:hidden">
      <div class="w-8 h-1 rounded opacity-25"></div>
      <div class="w-8 h-1 rounded opacity-25"></div>
      <div class="w-8 h-1 rounded opacity-25"></div>
    </div>

  </nav>
</header>
</body>
</html>
