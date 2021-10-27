<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.devlogs.masa_backend.common.Masa"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <%@include file="/shared/gg_analytics/_analytics_script"%>
    <title>Login</title>
    <meta charset="utf-8" />
    <link rel="shortcut icon" href="${Masa.ICON_URL}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <link
      href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${Masa.SERVER_HOST}/shared/styles.css">
  </head>
  <body>
    <!-- Navigation -->
    <nav
      class="relative flex flex-wrap items-center justify-between px-2 py-3 mb-3 bg-white "
    >
      <div
        class="container flex flex-wrap items-center justify-between px-4 mx-auto "
      >
        <div
          class="relative flex justify-between w-full px-4 lg:w-auto lg:static lg:block lg:justify-start"
        >
          <img
            src="${Masa.SERVER_HOST}/shared/icon/weblogo.svg"
            alt="Logo"
            width="30%"
            height="30%"
          />
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
                  dark:text-gray-200
                  dark:hover:text-gray-200
                  hover:no-underline
                  border-b-2 border-green-800
                  mx-1.5
                  sm:mx-6
                  hover:text-gray-800
                "
                href="#navi"
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
                  hover:border-green-800
                  hover:no-underline
                  mx-1.5
                  sm:mx-6
                "
                href="#info"
              >
                About us
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
                  hover:border-green-800
                  hover:no-underline
                  mx-1.5
                  sm:mx-6
                "
                href="#footer"
              >
                Contact
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!--End of navigation -->
    <!--Welcome banner -->
    <div class="container">
      <h1
        class="font-sans text-6xl font-semibold tracking-widest text-center mb-11"
      >
        WELCOME TO
      </h1>
      <img
        src="${Masa.SERVER_HOST}/login/hello.jpg"
        alt="Welcome banner"
        width="95%"
        height="95%"
        class="ml-5"
      />

    </div>

    <!-- End of welcome banner -->

    <!-- Intro -->
    <section class="py-8 bg-green-100" id="info">
        <div class="max-w-full mx-auto">
            <div class="items-center md:flex md:space-x-6">
                <div class="md:w-1/2">
                    <div class="flex items-center justify-center">
                        <div class="max-w-full">
                            <img class="object-cover object-center w-full"
                            src="${Masa.SERVER_HOST}/shared/icon/logo.svg"
                            alt="MASA logo"
                          width="70%" height="70%"/>
                        </div>
                    </div>
                </div>
    
                <div class="mt-8 md:mt-0 md:w-1/2">
                    <h1 class="max-w-5xl font-sans text-6xl font-semibold tracking-widest text-center text-green-800">
                        MASA
                      </h1><br>
                      <h1 class="max-w-5xl text-3xl font-medium tracking-wide text-center text-gray-800 dark:text-white md:text-4xl">MENTOR APPOINTMENT SCHEDULING APPLICATION</h1>
                      <br>
                    <p class="max-w-5xl mt-4 text-3xl text-gray-600">
                        This is an app that allows students to easily schedule a meeting
                        with their mentor - the FPTU's lecturers - if they have any
                        questions about the subject or future plans.</p>
                    <p class="max-w-5xl mt-4 text-3xl text-gray-600"> 
                        The mentors will hold meetings to share career orientation and answer students' questions. 
                        Meetings will be hosted on the Zoom and Google Meet platforms. 
                         
                        We will also send out automatic email reminders to students before each meeting.</p>
                    <div class="block mt-8 text-indigo-700 justify-items-center">
                        <c:set
                        var="redirectUrl"
                        value="${Masa.SERVER_HOST}/logingoogle"
                      />
                
                      <form
                        id="googlelogin"
                        method="post" class="text-center"
                        action="https://accounts.google.com/o/oauth2/auth?"
                      >
                        <span class="inline-block">
                          <input type="hidden" name="response_type" value="code" />
                          <input type="hidden" name="client_id" value="${Masa.CLIENT_ID}" />
                          <input type="hidden" name="redirect_uri" value="${redirectUrl}" />
                          <input type="hidden" name="scope" value="email profile" />
                          <input type="hidden" name="approval_prompt" value="force" />
                          <input  class="block py-3 font-semibold text-center text-white transition-colors transform bg-red-500 rounded-md px-7 duration-400 md:inline hover:bg-red-400" type="submit" value="Join with FPT mail" />
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- End of Intro -->
 
    <!-- Footer -->
    <footer
      class="relative pt-1 bg-white border-b-2 border-blue-700 footer"
      id="footer"
    >
      <div class="container px-6 mx-auto">
        <div class="sm:flex sm:mt-8">
          <div
            class="flex flex-col justify-between mt-8 sm:mt-0 sm:w-full sm:px-8 md:flex-row"
          >
            <div class="flex flex-col flex-1">
              <span class="mb-2 font-bold text-center text-green-700 uppercase"
                >A product of Sode team</span
              >
              <span class="my-2"
                ><p class="text-gray-700 text-md">
                  We created an application that makes it easy for students to
                  create meetings between students and mentors
                </p></span
              >
            </div>
            <div class="flex flex-col flex-1">
              <span
                class="mt-4 mb-2 font-bold text-center text-green-700 uppercase md:mt-0"
                >Contact us</span
              >
              <span class="my-2 ml-48">
                <i class="fab fa-facebook"></i>
                <a
                  href="#"
                  class="text-gray-700 hover:no-underline text-md hover:text-blue-500"
                  >Facebook: Sode Team - SlimAir.Co
                </a>
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
                <a
                  href="#"
                  class="text-gray-700 text-md hover:text-blue-500 hover:no-underline"
                  >Email: Slimair.com@gmail.com</a
                ></span
              >
            </div>
            <div class="flex flex-col flex-1 place-items-center">
              <img
                class="my-2"
                src="${Masa.SERVER_HOST}/shared/icon/fpt-university.png"
                width="50%"
                height="50%"
              />
            </div>
          </div>
        </div>
      </div>
      <div class="container px-6 mx-auto">
        <div
          class="flex flex-col items-center mt-16 border-t-2 border-gray-300"
        >
          <div class="py-6 text-center sm:w-2/3">
            <p class="mb-2 text-sm font-bold text-gray-700">
              ©2021-Sode Team-FPTU HCM
            </p>
          </div>
        </div>
      </div>
    </footer>
    <!-- End of Footer -->
    </body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js" integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ" crossorigin="anonymous"></script>
</html>
