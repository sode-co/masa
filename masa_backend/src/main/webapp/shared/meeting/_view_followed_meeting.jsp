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
          if (document.getElementById("unfollow").textContent === "Unfollow") {
              const json = {
                  userId: document.getElementById("userId").textContent,
                  meetingId: document.getElementById("meetingId").textContent,
              };
              console.log(json);
              const options = {
                  method: "POST",
                  body: JSON.stringify(json),
                  headers: {
                      "Content-Type": "application/json",
                  },
              };
              fetch("../../api/appointment-management/remove", options)
                  .then((res) => res.json())
                  .then((res) => console.log(res))
                  .catch((err) => console.error(err));
              document.getElementById("unfollow").textContent = "Follow";
          }
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
        <h1 id="userId" style="display: none">${sessionScope.CURRENT_USER.getId()}</h1>
        <script>
          const urlFollow = "http://localhost:8080/masa/api/appointment-management/create";
          const urlUnfollow = "http://localhost:8080/masa/api/appointment-management/remove";
          const url =
                  "http://localhost:8080/masa/api/meeting-management/followed-meetings/" +
                  "${sessionScope.CURRENT_USER.getId()}";
          console.log(url);
          let htmlElements = '';
          const postMethod = "POST";
          const contentType ="Content-Type";
          const appJson = "application/json";
          const userId = document.getElementById("userId").textContent;
          let idsession = 0;
          let followText = "Follow";
          let unfollowText = "Unfollow";
          let followId = "follow";
          let i = 0;
          let urlAskPage ="http://localhost:8080/masa/member/meeting/ask_question.jsp";
          let userParam = "?user=";
          let meetingParam = "&meeting=";
          const urlThisPage = "http://localhost:8080/masa/member/meeting/followed_meeting.jsp";
          const quotationMarks = '"';
          const container = document.getElementById("container");
          $.getJSON(
              url,
              function (data) {
                  let htmlElements = "";
                  const arr = data["meetings"];
                  arr.forEach((element) => {
                      idsession = element.id;
                      htmlElements +=
                 '<div class="flex items-center border border-gray-400 rounded-lg shadow lg:flex sm:ml-24 sm:mr-24">' +
                '      <div class="block h-full py-4 bg-green-600 rounded-lg shadow-inner lg:w-2/12">' +
                '        <div class="tracking-wide text-center">' +
                '          <div class="font-bold text-white text-7xl ">24</div>' +
                '          <div class="text-4xl font-normal text-white">Sept</div>' +
                "        </div>" +
                "      </div>" +
                '      <div class="w-full px-1 py-5 tracking-wide bg-white lg:w-11/12 xl:w-full lg:px-2 lg:py-2">' +
                '        <div class="flex flex-row justify-center lg:justify-start">' +
                '          <div class="px-2 text-lg font-medium text-center text-gray-700 lg:text-left">' +
                '            <i class="far fa-clock"></i> ' +
                element.startTime +
                "-" +
                element.endTime +
                "          </div>" +
                '          <div class="px-2 text-lg font-medium text-center text-gray-700 lg:text-left">' +
                "            Mentor : " +
                element.hostId +
                "          </div>" +
                "        </div>" +
                '        <div class="px-2 text-4xl font-semibold text-center text-gray-800 lg:text-left">' +
                element.title +
                "        </div>" +
                "" +
                '        <div class="px-2 pt-1 text-lg font-medium text-center text-gray-600 lg:text-left">' +
                element.description +
                "        </div>" +
                "      </div>" +
                '      <div class="flex flex-row items-center justify-center w-full px-2 py-4 bg-white lg:w-1/3 lg:justify-end lg:px-0">'




                              +'<a href="" onClick="(function(){'
                              +'const varToString = varObj => Object.keys(varObj)[0];'
                              +'const '+idsession+'=i;'
                              +'const x = varToString({'+idsession+'});'
                              +'const url = urlAskPage+userParam+userId+meetingParam+x;'
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
                              +'const '+idsession+'=i;'
                              +'const x = varToString({'+idsession+'});'
                              +'const url = urlUnfollow + x;'
                              +'const json = {'
                              +'userId: userId,'
                              +'meetingId: x,'
                              +'};'
                              +'console.log(json);'
                              +'const options = {'
                              +'method: postMethod,'
                              +'body: JSON.stringify(json),'
                              +'headers: {'
                              +'contentType: appJson,'
                              +'},'
                              +'};'
                              +'if (document.getElementById(followId).textContent === unfollowText) {'
                              +'fetch(urlUnfollow, options)'
                              +'.then((res) => res.json())'
                              +'.then((res) => console.log(res))'
                              +'.catch((err) => console.error(err));'
                              +'window.location.replace(urlThisPage)'
                              +'}'
                              +'})();return false;">'
                              +'<button href="#heheh" class="relative flex items-center justify-center w-full px-3 py-3 text-lg font-medium text-white rounded-xl group">'+
                              '<span class="absolute inset-0 w-full h-full transition-all duration-200 ease-out transform bg-green-500 group-hover:translate-y-0 group-hover:translate-x-0 rounded-xl"></span>'+
                              '<span class="absolute inset-0 w-full h-full border-0 border-gray-900 rounded-xl">'
                              +'</span><span class="relative" id="follow">Unfollow</span>'
                              +'<svg class="w-5 h-5 ml-2 transition-all duration-200 ease-out transform group-hover:translate-x-1" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>'+
                              '</button>'
                              +'</a>'


                +"       " +
                "      </div>" +
                "    </div>" +
                "<hr/>" +
                "<hr/>" +
                "      </div>" +
                "    </div>" +
                "  </div>" +
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
