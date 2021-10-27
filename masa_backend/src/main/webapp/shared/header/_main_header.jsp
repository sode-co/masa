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
      window.open(urlForward);
    }
  </script>
</head>
<body>
<header id="overlay">
  <nav class=" bg-white flex justify-between px-6 border-0">
    <div class="flex items-center space-x-12">
      <div class="flex items-center space-x-2 text-2xl">
        <img src="${Masa.SERVER_HOST}/shared/icon/weblogo.svg" style="width: 30%; height: 30%" />
      </div>
      <div class="hidden lg:block">
        <div class="relative">
          <div class="flex flex-col flex-1 float-left">
            <div class="">
              <div class="relative">
                <div class="flex items-center h-12 border border-gray-200 rounded w-30">
                  <input name="select" id="searchkeyword" class="w-full px-4 text-gray-800 outline-none appearance-none" checked />
                  <select
                          id="searchmethod"
                          class="h-10 text-gray-600 border-0 appearance-none hover:border-0 focus:border-0"
                          style="border: none; border-color: transparent"
                  >
                    <option>Mentor</option>
                    <option>Title</option>
                  </select>
                  <button
                          onclick="search()"
                          class="pl-5 pr-5 text-gray-300 transition-all outline-none cursor-pointer  focus:outline-none hover:text-gray-600"
                  >
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
                              d="M55.146,51.887L41.588,37.786c3.486-4.144,5.396-9.358,5.396-14.786c0-12.682-10.318-23-23-23s-23,10.318-23,23  s10.318,23,23,23c4.761,0,9.298-1.436,13.177-4.162l13.661,14.208c0.571,0.593,1.339,0.92,2.162,0.92  c0.779,0,1.518-0.297,2.079-0.837C56.255,54.982,56.293,53.08,55.146,51.887z M23.984,6c9.374,0,17,7.626,17,17s-7.626,17-17,17  s-17-7.626-17-17S14.61,6,23.984,6z"/>
                    </svg>
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
           class="py-2 font-semibold text-white bg-blue-500 rounded-full px-7 text-md hover:bg-blue-400">Become mentor</a>
       </c:if>
      <c:if test="${sessionScope.CURRENT_USER.getRole() == 'UserRole{type=MENTOR}'}">
        <a id="createdmeeting" href="${Masa.SERVER_HOST}/mentor/mycreatedmeeting.jsp?mentor=${sessionScope.CURRENT_USER.getId()}"
           class="py-2 font-semibold text-white bg-blue-500 rounded-full px-7 text-md hover:bg-blue-400">Your Meetings</a>
        <a href="${Masa.SERVER_HOST}/mentor/meeting/createnewmeeting.jsp"
           class="py-2 font-semibold text-white bg-blue-500 rounded-full px-7 text-md hover:bg-blue-400">New Meeting</a>
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
