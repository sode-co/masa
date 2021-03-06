<%@ page import="com.devlogs.masa_backend.common.Masa"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../styles/styles.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
    <link href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css" rel="stylesheet" />
   
    <link rel="dns-prefetch" href="//unpkg.com" />
    <link rel="dns-prefetch" href="//cdn.jsdelivr.net" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script
            defer
            src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"
            integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"
            crossorigin="anonymous"
    ></script>
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.js" defer></script>
    <style>
        div#new_meeting_carousel_wrapper {
            overflow: hidden;
            position: relative;
            width: 5000px;
            height: 400px;
        }

        ul {
            padding: 0px;
            /* margin-left: 20%; */
            /* margin-right: 20%; */
            position: absolute;
            left: 0px;
            width: 450px;
            height: 450px;
            overflow: hidden;
        }
        ul li {
            list-style: none;
            float: left;
        }
        ul li div {
            border: 1px solid white;
            width: 300px;
            height: 400px;
        }

        .modal.fade {
            opacity: 1;
        }
        .modal.fade .modal-dialog {
            -webkit-transform: translate(0);
            -moz-transform: translate(0);
            transform: translate(0);
        }
    </style>
    <script>
        function testAnim(x) {
            $(".modal .modal-dialog").attr("class", "modal-dialog  " + x + "  animated");
        }
        $("#myModalNewMeeting").on("show.bs.modal", function (e) {
            var anim = $("#entrance").val();
            testAnim(anim);
        });
        $("#myModalNewMeeting").on("hide.bs.modal", function (e) {
            var anim = $("#exit").val();
            testAnim(anim);
        });
    </script>
</head>
<body>
<div class="flex mb-7 w-full">
    <div class="ml-24 flex flex-col flex-1 float-left">
        <h1 class="mb-2 text-5xl font-medium text-gray-900 title-font" style="font-size: 20px">On-going Meetings</h1>
        <div class="w-20 h-1 bg-blue-500 rounded" style="background-color: #66ce93"></div>
    </div>
    <div class="flex flex-col flex-1 float-right">
        <a href="#" class="text-right mb-2 mr-24 text-2xl font-medium text-gray-900 sm:text-2xl title-font">See more</a>
    </div>
</div>
<section class="text-gray-600 body-font">
    <div class="container px-5 mx-auto" style="margin: auto; padding-left: 0px">

        <div  id="new_meeting_carousel_wrapper" class="mx-auto space-x-4 md:flex md:justify-center md:space-x-8 md:px-8" style="width: 940px;">
            <ul id="new_meeting_carousel_wrapper_list">
                <script>
                    let i=0;
                    $.getJSON("${Masa.SERVER_HOST}/api/meeting-management/ongoing-meetings", function (data) {
                        let htmlElementsNewMeeting = "";
                        const arrNewMeeting = data["meetings"];
                        arrNewMeeting.forEach((element) => {
                            var startConvertNewMeeting = new Date(element.startTime); // create Date object
                            var startConvertNewMeetingTime = startConvertNewMeeting.toString().replace("GMT+0700 (Indochina Time)",'').replace("GMT+0800 (Indochina Time)",'');
                            var endConvertConvertNewMeeting = new Date(element.startTime); // create Date object
                            var endConvertConvertNewMeetingTime = endConvertConvertNewMeeting.toString().replace("GMT+0700 (Indochina Time)",'').replace("GMT+0800 (Indochina Time)",'');
                            i++;
                            const target = "#myModalNewMeeting"+ i;
                            if(element.topic.title==='Software Engineering'){
                                htmlElementsNewMeeting +=
                                    '<li>'
                                    +'<div>'
                                    +'<div class="px-4 mx-auto transition duration-500 transform bg-white shadow-lg bg-whit rounded-xl hover:shadow-xl hover:scale-110 md:mx-0">'
                                    +'<div class="flex flex-col items-center justify-center w-sm">'
                                    +'<div class="">'
                                    +'<img class="object-cover w-64 h-64 mx-auto"'
                                    +'src="https://image.freepik.com/free-vector/programming-concept-illustration_114360-1213.jpg"'
                                    +'alt=""'
                                    +'/>'
                                    +'</div>'
                                    +'<div class="mt-2 text-center">'
                                    +'<h1 class="mb-2 text-3xl font-bold text-green-600">'+element.title+'</h1>'
                                    +'<h2 class="text-2xl text-indigo-600"  style="color: #414e62">with mentor <strong class="py-2 text-indigo-600" style="color: coral">'+element.mentor.fullName+'</strong></h2>'
                                    +'<p class="mt-4 text-gray-600">'+startConvertNewMeetingTime.slice(16,21)+' '+ startConvertNewMeetingTime.slice(4,10)+'</p>'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 mr-2 font-semibold tracking-widest bg-blue-500 hover:bg-indigo-900 text-white font-bold py-2 px-4 border bg-indigo-800 rounded-lg"'
                                    +' onclick=parent.calldialog('+element.id+')'
                                    +'>'
                                    +'See more'
                                    +' </button> '
                                    +'<a href="'+element.platform.url+'" target="_blank">'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 ml-2 font-semibold bg-transparent hover:bg-green-500 text-green-700 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded-lg"'
                                    +'>'
                                    +'Join now'
                                    +' </button>'
                                    +'</a>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</li>'
                            }else if(element.topic.title==='Business management' || element.topic.title==='Agile'){
                                htmlElementsNewMeeting +=
                                    '<li>'
                                    +'<div>'
                                    +'<div class="px-4   mx-auto    transition duration-500 transform bg-white shadow-lg bg-whit rounded-xl hover:shadow-xl hover:scale-110 md:mx-0">'
                                    +'<div class="flex flex-col items-center justify-center w-sm">'
                                    +'<div class="">'
                                    +'<img class="object-cover w-64 h-64 mx-auto"'
                                    +'src="https://image.freepik.com/free-vector/remote-business-management-concept-with-businessman-holding-tablet-showing-analytics-graphs-connected_1284-44658.jpg"'
                                    +'alt=""'
                                    +'/>'
                                    +'</div>'
                                    +'<div class="mt-2 text-center">'
                                    +'<h1 class="mb-2 text-3xl font-bold text-green-600">'+element.title+'</h1>'
                                    +'<h2 class="text-2xl text-indigo-600"  style="color: #414e62">with mentor <strong class="py-2 text-indigo-600" style="color: coral">'+element.mentor.fullName+'</strong></h2>'
                                    +'<p class="mt-4 text-gray-600">'+startConvertNewMeetingTime.slice(16,21)+' '+ startConvertNewMeetingTime.slice(4,10)+'</p>'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 mr-2 font-semibold tracking-widest bg-blue-500 hover:bg-indigo-900 text-white font-bold py-2 px-4 border bg-indigo-800 rounded-lg"'
                                    +' onclick=parent.calldialog('+element.id+')'
                                    +'>'
                                    +'See more'
                                    +' </button> '
                                    +'<a href="'+element.platform.url+'" target="_blank">'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 ml-2 font-semibold bg-transparent hover:bg-green-500 text-green-700 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded-lg"'
                                    +'>'
                                    +'Join now'
                                    +' </button>'
                                    +'</a>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</li>'
                            }else if(element.topic.title==='Artificial Intelligence'){
                                htmlElementsNewMeeting +=
                                    '<li>'
                                    +'<div>'
                                    +'<div class="px-4   mx-auto    transition duration-500 transform bg-white shadow-lg bg-whit rounded-xl hover:shadow-xl hover:scale-110 md:mx-0">'
                                    +'<div class="flex flex-col items-center justify-center w-sm">'
                                    +'<div class="">'
                                    +'<img class="object-cover w-64 h-64 mx-auto"'
                                    +'src="https://image.freepik.com/free-vector/cloud-robotics-abstract-concept-illustration_335657-3801.jpg"'
                                    +'alt=""'
                                    +'/>'
                                    +'</div>'
                                    +'<div class="mt-2 text-center">'
                                    +'<h1 class="mb-2 text-3xl font-bold text-green-600">'+element.title+'</h1>'
                                    +'<h2 class="text-2xl text-indigo-600"  style="color: #414e62">with mentor <strong class="py-2 text-indigo-600" style="color: coral">'+element.mentor.fullName+'</strong></h2>'
                                    +'<p class="mt-4 text-gray-600">'+startConvertNewMeetingTime.slice(16,21)+' '+ startConvertNewMeetingTime.slice(4,10)+'</p>'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 mr-2 font-semibold tracking-widest bg-blue-500 hover:bg-indigo-900 text-white font-bold py-2 px-4 border bg-indigo-800 rounded-lg"'
                                    +' onclick=parent.calldialog('+'"'+element.id.toString()+'"'+')'
                                    +'>'
                                    +'See more'
                                    +' </button> '
                                    +'<a href="'+element.platform.url+'" target="_blank">'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 ml-2 font-semibold bg-transparent hover:bg-green-500 text-green-700 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded-lg"'
                                    +'>'
                                    +'Join now'
                                    +' </button>'
                                    +'</a>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</li>'
                            }else if(element.topic.title==='Digital Maketing'){
                                htmlElementsNewMeeting +=
                                    '<li>'
                                    +'<div>'
                                    +'<div class="px-4   mx-auto    transition duration-500 transform bg-white shadow-lg bg-whit rounded-xl hover:shadow-xl hover:scale-110 md:mx-0">'
                                    +'<div class="flex flex-col items-center justify-center w-sm">'
                                    +'<div class="">'
                                    +'<img class="object-cover w-64 h-64 mx-auto"'
                                    +'src="https://image.freepik.com/free-vector/hand-drawn-illustration-people-with-smartphone-marketing_52683-66658.jpg"'
                                    +'alt=""'
                                    +'/>'
                                    +'</div>'
                                    +'<div class="mt-2 text-center">'
                                    +'<h1 class="mb-2 text-3xl font-bold text-green-600">'+element.title+'</h1>'
                                    +'<h2 class="text-2xl text-indigo-600"  style="color: #414e62">with mentor <strong class="py-2 text-indigo-600" style="color: coral">'+element.mentor.fullName+'</strong></h2>'
                                    +'<p class="mt-4 text-gray-600">'+startConvertNewMeetingTime.slice(16,21)+' '+ startConvertNewMeetingTime.slice(4,10)+'</p>'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 mr-2 font-semibold tracking-widest bg-blue-500 hover:bg-indigo-900 text-white font-bold py-2 px-4 border bg-indigo-800 rounded-lg"'
                                    +' onclick=parent.calldialog('+element.id+')'
                                    +'>'
                                    +'See more'
                                    +' </button> '
                                    +'<a href="'+element.platform.url+'" target="_blank">'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 ml-2 font-semibold bg-transparent hover:bg-green-500 text-green-700 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded-lg"'
                                    +'>'
                                    +'Join now'
                                    +' </button>'
                                    +'</a>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</li>'
                            }else if(element.topic.title==='English Language'){
                                htmlElementsNewMeeting +=
                                    '<li>'
                                    +'<div>'
                                    +'<div class="px-4   mx-auto    transition duration-500 transform bg-white shadow-lg bg-whit rounded-xl hover:shadow-xl hover:scale-110 md:mx-0">'
                                    +'<div class="flex flex-col items-center justify-center w-sm">'
                                    +'<div class="">'
                                    +'<img class="object-cover w-64 h-64 mx-auto"'
                                    +'src="https://image.freepik.com/free-vector/famous-showplaces-united-kingdom_126523-12.jpg"'
                                    +'alt=""'
                                    +'/>'
                                    +'</div>'
                                    +'<div class="mt-2 text-center">'
                                    +'<h1 class="mb-2 text-3xl font-bold text-green-600">'+element.title+'</h1>'
                                    +'<h2 class="text-2xl text-indigo-600"  style="color: #414e62">with mentor <strong class="py-2 text-indigo-600" style="color: coral">'+element.mentor.fullName+'</strong></h2>'
                                    +'<p class="mt-4 text-gray-600">'+startConvertNewMeetingTime.slice(16,21)+' '+ startConvertNewMeetingTime.slice(4,10)+'</p>'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 mr-2 font-semibold tracking-widest bg-blue-500 hover:bg-indigo-900 text-white font-bold py-2 px-4 border bg-indigo-800 rounded-lg"'
                                    +' onclick=parent.calldialog('+element.id+')'
                                    +'>'
                                    +'See more'
                                    +' </button> '
                                    +'<a href="'+element.platform.url+'" target="_blank">'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 ml-2 font-semibold bg-transparent hover:bg-green-500 text-green-700 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded-lg"'
                                    +'>'
                                    +'Join now'
                                    +' </button>'
                                    +'</a>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</li>'
                            }else if(element.topic.title==='Information Assurance'){
                                htmlElementsNewMeeting +=
                                    '<li>'
                                    +'<div>'
                                    +'<div class="px-4   mx-auto    transition duration-500 transform bg-white shadow-lg bg-whit rounded-xl hover:shadow-xl hover:scale-110 md:mx-0">'
                                    +'<div class="flex flex-col items-center justify-center w-sm">'
                                    +'<div class="">'
                                    +'<img class="object-cover w-64 h-64 mx-auto"'
                                    +'src="https://image.freepik.com/free-vector/global-data-security-personal-data-security-cyber-data-security-online-concept-illustration-internet-security-information-privacy-protection_1150-37336.jpg"'
                                    +'alt=""'
                                    +'/>'
                                    +'</div>'
                                    +'<div class="mt-2 text-center">'
                                    +'<h1 class="mb-2 text-3xl font-bold text-green-600">'+element.title+'</h1>'
                                    +'<h2 class="text-2xl text-indigo-600"  style="color: #414e62">with mentor <strong class="py-2 text-indigo-600" style="color: coral">'+element.mentor.fullName+'</strong></h2>'
                                    +'<p class="mt-4 text-gray-600">'+startConvertNewMeetingTime.slice(16,21)+' '+ startConvertNewMeetingTime.slice(4,10)+'</p>'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 mr-2 font-semibold tracking-widest bg-blue-500 hover:bg-indigo-900 text-white font-bold py-2 px-4 border bg-indigo-800 rounded-lg"'
                                    +' onclick=parent.calldialog('+element.id+')'
                                    +'>'
                                    +'See more'
                                    +' </button> '
                                    +'<a href="'+element.platform.url+'" target="_blank">'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 ml-2 font-semibold bg-transparent hover:bg-green-500 text-green-700 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded-lg"'
                                    +'>'
                                    +'Join now'
                                    +' </button>'
                                    +'</a>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</li>'
                            }else if(element.topic.title==='Japanese Language'){
                                htmlElementsNewMeeting +=
                                    '<li>'
                                    +'<div>'
                                    +'<div class="px-4   mx-auto    transition duration-500 transform bg-white shadow-lg bg-whit rounded-xl hover:shadow-xl hover:scale-110 md:mx-0">'
                                    +'<div class="flex flex-col items-center justify-center w-sm">'
                                    +'<div class="">'
                                    +'<img class="object-cover w-64 h-64 mx-auto"'
                                    +'src="https://png.pngtree.com/element_our/20190531/ourlarge/pngtree-vector-cartoon-free-buckle-japan-image_1321521.jpg"'
                                    +'alt=""'
                                    +'/>'
                                    +'</div>'
                                    +'<div class="mt-2 text-center">'
                                    +'<h1 class="mb-2 text-3xl font-bold text-green-600">'+element.title+'</h1>'
                                    +'<h2 class="text-2xl text-indigo-600"  style="color: #414e62">with mentor <strong class="py-2 text-indigo-600" style="color: coral">'+element.mentor.fullName+'</strong></h2>'
                                    +'<p class="mt-4 text-gray-600">'+startConvertNewMeetingTime.slice(16,21)+' '+ startConvertNewMeetingTime.slice(4,10)+'</p>'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 mr-2 font-semibold tracking-widest bg-blue-500 hover:bg-indigo-900 text-white font-bold py-2 px-4 border bg-indigo-800 rounded-lg"'
                                    +' onclick=parent.calldialog('+element.id+')'
                                    +'>'
                                    +'See more'
                                    +' </button> '
                                    +'<a href="'+element.platform.url+'" target="_blank">'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 ml-2 font-semibold bg-transparent hover:bg-green-500 text-green-700 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded-lg"'
                                    +'>'
                                    +'Join now'
                                    +' </button>'
                                    +'</a>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</li>'
                            }else if(element.topic.title==='Multimedia' || element.topic.title==='Photoshop'){
                                htmlElementsNewMeeting +=
                                    '<li>'
                                    +'<div>'
                                    +'<div class="px-4   mx-auto    transition duration-500 transform bg-white shadow-lg bg-whit rounded-xl hover:shadow-xl hover:scale-110 md:mx-0">'
                                    +'<div class="flex flex-col items-center justify-center w-sm">'
                                    +'<div class="">'
                                    +'<img class="object-cover w-64 h-64 mx-auto"'
                                    +'src="https://image.freepik.com/free-vector/company-employees-use-web-search-find-ideas-doing-business-company_1150-43196.jpg"'
                                    +'alt=""'
                                    +'/>'
                                    +'</div>'
                                    +'<div class="mt-2 text-center">'
                                    +'<h1 class="mb-2 text-3xl font-bold text-green-600">'+element.title+'</h1>'
                                    +'<h2 class="text-2xl text-indigo-600"  style="color: #414e62">with mentor <strong class="py-2 text-indigo-600" style="color: coral">'+element.mentor.fullName+'</strong></h2>'
                                    +'<p class="mt-4 text-gray-600">'+startConvertNewMeetingTime.slice(16,21)+' '+ startConvertNewMeetingTime.slice(4,10)+'</p>'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 mr-2 font-semibold tracking-widest bg-blue-500 hover:bg-indigo-900 text-white font-bold py-2 px-4 border bg-indigo-800 rounded-lg"'
                                    +' onclick=parent.calldialog('+element.id+')'
                                    +'>'
                                    +'See more'
                                    +' </button> '
                                    +'<a href="'+element.platform.url+'" target="_blank">'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 ml-2 font-semibold bg-transparent hover:bg-green-500 text-green-700 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded-lg"'
                                    +'>'
                                    +'Join now'
                                    +' </button>'
                                    +'</a>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</li>'
                            }else if(element.topic.title==='Soft Skills'){
                                htmlElementsNewMeeting +=
                                    '<li>'
                                    +'<div>'
                                    +'<div class="px-4   mx-auto    transition duration-500 transform bg-white shadow-lg bg-whit rounded-xl hover:shadow-xl hover:scale-110 md:mx-0">'
                                    +'<div class="flex flex-col items-center justify-center w-sm">'
                                    +'<div class="">'
                                    +'<img class="object-cover w-64 h-64 mx-auto"'
                                    +'src="https://image.freepik.com/free-vector/scrum-board-concept-illustration_114360-2981.jpg"'
                                    +'alt=""'
                                    +'/>'
                                    +'</div>'
                                    +'<div class="mt-2 text-center">'
                                    +'<h1 class="mb-2 text-3xl font-bold text-green-600">'+element.title+'</h1>'
                                    +'<h2 class="text-2xl text-indigo-600"  style="color: #414e62">with mentor <strong class="py-2 text-indigo-600" style="color: coral">'+element.mentor.fullName+'</strong></h2>'
                                    +'<p class="mt-4 text-gray-600">'+startConvertNewMeetingTime.slice(16,21)+' '+ startConvertNewMeetingTime.slice(4,10)+'</p>'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 mr-2 font-semibold tracking-widest bg-blue-500 hover:bg-indigo-900 text-white font-bold py-2 px-4 border bg-indigo-800 rounded-lg"'
                                    +' onclick=parent.calldialog('+element.id+')'
                                    +'>'
                                    +'See more'
                                    +' </button> '
                                    +'<a href="'+element.platform.url+'" target="_blank">'
                                    +'<button'
                                    +' type="button"'
                                    +' class="px-8 py-2 mt-8 mb-4 ml-2 font-semibold bg-transparent hover:bg-green-500 text-green-700 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded-lg"'
                                    +'>'
                                    +'Join now'
                                    +' </button>'
                                    +'</a>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</li>'
                            }

                        });
                        let new_meeting_carousel_wrapper_list = document.getElementById("new_meeting_carousel_wrapper_list");
                        new_meeting_carousel_wrapper_list.innerHTML = htmlElementsNewMeeting;
                        document.getElementById("new_meeting_carousel_wrapper_list").style.width= 300*i+"px";
                    });
                </script>

            </ul>
            <button
                    id="leftNewMeeting"
                    class="absolute left-0 w-20 h-20 mt-32 -ml-6 text-2xl text-indigo-600 bg-white rounded-full shadow-md top-20 hover:text-indigo-400 focus:text-indigo-400 focus:outline-none focus:shadow-outline"
            >
                <span class="block" style="transform: scale(-1); color: #414E62">&#x279c;</span>
            </button>
            <button
                    id="rightNewMeeting"
                    class="absolute right-0 w-20 h-20 mt-32 -mr-6 text-2xl text-indigo-600 bg-white rounded-full shadow-md top-20 hover:text-indigo-400 focus:text-indigo-400 focus:outline-none focus:shadow-outline"
            >
                <span class="block" style="transform: scale(1)x; color: #414E62">&#x279c;</span>
            </button>

        </div>
        <!-- Dialog Start -->
        <h1 id="currentSessionNewMeeting" style="display: none">${sessionScope.CURRENT_USER.id}</h1>

    </div>
    </div>
    </div>
</section>
<script>
    var container = $("#new_meeting_carousel_wrapper");

    var runner = container.find("ul");
    var liWidth = runner.find("li:first").outerWidth();
    var itemsPerPage = 3;
    var noofitems = runner.find("li").length;

    runner.width(noofitems * liWidth);
    container.width(itemsPerPage * liWidth);

    $("#rightNewMeeting").click(function () {
        $(runner).animate({ left: "-=310px" }, "slow");
    });

    $("#leftNewMeeting").click(function () {
        $(runner).animate({ left: "+=310px" }, "slow");
    });
</script>
</body>
</html>