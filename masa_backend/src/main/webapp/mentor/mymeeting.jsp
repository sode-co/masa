<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="../styles.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
    <link href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css" />
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
        div#carousel_wrapper {
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
        html {
            font-family: Lato, "Helvetica Neue", Arial, Helvetica, sans-serif;
            font-size: 14px;
        }

        h5 {
            font-size: 1.28571429em;
            font-weight: 700;
            line-height: 1.2857em;
            margin: 0;
        }

        .card {
            font-size: 1em;
            overflow: hidden;
            padding: 0;
            border: none;
            border-radius: 0.28571429rem;
            box-shadow: 0 1px 3px 0 #d4d4d5, 0 0 0 1px #d4d4d5;
        }

        .card-block {
            font-size: 1em;
            position: relative;
            margin: 0;
            padding: 1em;
            border: none;
            border-top: 1px solid white;
            box-shadow: none;
        }

        .card-img-top {
            display: block;
            width: 100%;
            height: auto;
        }

        .card-title {
            font-size: 1.28571429em;
            font-weight: 700;
            line-height: 1.2857em;
        }

        .card-text {
            clear: both;
            margin-top: 0.5em;
            color: rgba(0, 0, 0, 0.68);
        }

        .card-footer {
            font-size: 1em;
            position: static;
            top: 0;
            left: 0;
            max-width: 100%;
            padding: 0.75em 1em;
            color: rgba(0, 0, 0, 0.4);
            border-top: 1px solid white !important;
            background: #fff;
        }

        .card-inverse .btn {
            border: 1px solid rgba(0, 0, 0, 0.05);
        }

        .profile {
            position: absolute;
            top: -12px;
            display: inline-block;
            overflow: hidden;
            box-sizing: border-box;
            width: 25px;
            height: 25px;
            margin: 0;
            border: 1px solid #fff;
            border-radius: 50%;
        }

        .profile-avatar {
            display: block;
            width: 100%;
            height: 100%;
            border-radius: 50%;
        }

        .profile-inline {
            position: relative;
            top: 0;
            display: inline-block;
        }

        .profile-inline ~ .card-title {
            display: inline-block;
            margin-left: 4px;
            vertical-align: top;
        }

        .text-bold {
            font-weight: 700;
        }

        .meta {
            font-size: 1em;
            color: rgba(0, 0, 0, 0.4);
        }

        .meta a {
            text-decoration: none;
            color: rgba(0, 0, 0, 0.4);
        }

        .meta a:hover {
            color: rgba(0, 0, 0, 0.87);
        }
    </style>
    <script>
        function testAnim(x) {
            $(".modal .modal-dialog").attr("class", "modal-dialog  " + x + "  animated");
        }
        $("#myModal").on("show.bs.modal", function (e) {
            var anim = $("#entrance").val();
            testAnim(anim);
        });
        $("#myModal").on("hide.bs.modal", function (e) {
            var anim = $("#exit").val();
            testAnim(anim);
        });
    </script>
</head>
<body>
<div class="container">
    <div class="row" id="meetingList">
        <!-- The meeting bat dau o day -->
        <script>
            let htmlElements = "";
            let iOngoingMeeting=0;
            $.getJSON("/masa/api/meeting-management/meetings/host/ME100002", function (data) {
                const arrOngoingMeeting = data["meetings"];
                arrOngoingMeeting.forEach((element) => {
                    var startConvertOngoingMeeting = new Date(element.startTime); // create Date object
                    var startConvertOngoingMeetingTime = startConvertOngoingMeeting.toString().replace("GMT+0700 (Indochina Time)",'').replace("GMT+0800 (Indochina Time)",'');
                    iOngoingMeeting++;
                    htmlElements +=
                        '<div class="mt-4 transition duration-500 transform col-sm-6 col-md-4 col-lg-3 hover:shadow-xl hover:scale-110">'
                        + '<div class="card">'
                        + '<img'
                        + ' class="card-img-top"'
                        + ' src="https://image.freepik.com/free-vector/cloud-robotics-abstract-concept-illustration_335657-3801.jpg'
                        + '"'
                        + '/>'
                        + '<div class="card-block" style="text-align: center">'
                        + '<h1 class="text-xl font-bold text-green-600">'+element.title+'</h1>'
                        + '<h2 class="text-lg text-indigo-600">with mentor <strong class="text-indigo-600">'+element.mentor.fullName+'</strong></h2>'
                        + '<p class="text-lg text-gray-600">'+startConvertOngoingMeetingTime.slice(16,21)+' '+ startConvertOngoingMeetingTime.slice(4,10)+'</p>'
                        + '</div>'
                        + '<div class="card-footer">'
                        + '<button'
                        + ' type="button"'
                        + ' data-toggle="modal"'
                        + ' data-target="#myModal'+iOngoingMeeting+'"'
                        + ' class="float-left py-2 mt-1 mb-4 mr-2 font-semibold tracking-widest text-white transition duration-200 bg-indigo-500  px-7 rounded-xl hover:bg-indigo-400"'
                        + '>'
                        + 'See more'
                        + '</button>'
                        +'<a href="'+element.platform.url+'">'
                        + '<button'
                        + ' type="button"'
                        + ' class="float-right py-2 mt-1 mb-4 ml-2 font-semibold tracking-widest text-white transition duration-200 bg-green-500  px-7 rounded-xl hover:bg-green-400"'
                        + '>'
                        + 'Join now'
                        + '</button>'
                        +'</a>'
                        + '</div>'
                        + '</div>'
                        + '</div>'
                });
                document.getElementById("meetingList").innerHTML = htmlElements;
            });
        </script>
    </div>

    <div id="meetingDialog">
        <script>
            let htmlDialog = "";
            let i =0;
            const hostId = location.search.replace("mentor?=","");
            $.getJSON("/masa/api/meeting-management/meetings/host/"+hostId, function (data) {
                const arrOngoingMeeting = data["meetings"];
                arrOngoingMeeting.forEach((element) => {
                    var startConvertOngoingMeeting = new Date(element.startTime); // create Date object
                    var startConvertOngoingMeetingTime = startConvertOngoingMeeting.toString().replace("GMT+0700 (Indochina Time)",'').replace("GMT+0800 (Indochina Time)",'');
                    var endConvertConvertOngoingMeeting = new Date(element.endTime); // create Date object
                    const startDayOngoingMeeting = ("0"+startConvertOngoingMeeting.getDay()).slice(("0"+startConvertOngoingMeeting.getDay()).length-2, ("0"+startConvertOngoingMeeting.getDay()).length);
                    const startMonthOngoingMeeting = ("0"+startConvertOngoingMeeting.getMonth()).slice(("0"+startConvertOngoingMeeting.getMonth()).length-2, ("0"+startConvertOngoingMeeting.getMonth()).length);
                    var endConvertConvertOngoingMeetingTime = endConvertConvertOngoingMeeting.toString().replace("GMT+0700 (Indochina Time)",'').replace("GMT+0800 (Indochina Time)",'');
                    i++;
                    let idDialog = "myModal"+i;
                    if(element.platform.platform==="GOOGLE_MEET"){
                        htmlDialog +=
                            '<div class="modal fade" id=' + idDialog + ' tabindex="-1" role="dialog" aria-labelledby="myModalLabel">'
                            + '<div class="font-sans modal-dialog" role="document">'
                            + '<div class="rounded-3xl modal-content" style="width: 680px">'
                            + '<div class="modal-body">'
                            + '<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
                            + '<span aria-hidden="true">&times;</span>'
                            + '</button>'
                            + '<h4 class="text-2xl font-bold text-black mt-11 ml-14 modal-title" id="myModalLabel">Meeting Information</h4>'
                            + '<div>'
                            + '<h1 class="relative inline-block mb-1 text-5xl font-semibold text-gray-900 mt-11 ml-14 date modal-title">'
                            +element.title
                            + '</h1>'
                            + '<a href="'+element.platform.url+'" class="text-2xl font-semibold text-blue-800 ml-7">Join Google Meet</a><br />'
                            + '<span class="relative inline-block pt-2 text-2xl font-normal text-black ml-14 date modal-title"'
                            + '>with mentor <span class="text-2xl font-normal text-blue-800">'+element.mentor.fullName+'</span></span'
                            + '>'
                            + '<div class="flex ml-7 modal-body">'
                            + '<span'
                            + ' class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200  rounded-2xl date modal-title"'
                            + '>'+startConvertOngoingMeetingTime.slice(16,21)+'</span'
                            + '>'
                            + '<h1 class="relative inline-block my-auto ml-2 mr-2 text-2xl font-semibold text-gray-900 date modal-title p2">'
                            + 'to:'
                            + '</h1>'
                            + '<span'
                            + ' class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200  rounded-2xl date modal-title">'
                            +  endConvertConvertOngoingMeetingTime.slice(16,21)+'</span>'
                            + '<h1 class="relative inline-block my-auto ml-2 mr-2 text-2xl font-semibold text-gray-900 date modal-title p2">'
                            + 'date:'
                            + '</h1>'
                            + '<span'
                            + ' class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200  rounded-2xl date modal-title"'
                            + '>'+startDayOngoingMeeting+'/'+startMonthOngoingMeeting+'/'+startConvertOngoingMeeting.getFullYear()+'</span'
                            + '>'
                            + '</div>'
                            + '<div class="flex mb-4 modal-body">'
                            + '<p class="mr-5 font-normal text-gray-500 ml-9">'
                            +  element.description
                            + '</p>'
                            + '</div>'
                            + '</div>'
                            + '<div class="flex justify-center w-full space-x-16 mt-9 mb-14">'
                            +'<a href="/masa/mentor/meeting/updatemeeting.jsp?id='+element.id+'&host='+element.mentor.id+'" >'
                            + '<button'
                            + ' class="p-4 text-2xl font-semibold text-black bg-transparent border-2 border-gray-200  pl-28 pr-28 rounded-2xl hover:text-blue-500 focus:border-4 focus:border-blue-300"'
                            + '>'
                            + 'Update'
                            + '</button>'
                            + '</a>'
                            +' <a href="/masa/member/question.jsp?id='+element.id+'&page=0">'
                            + '<button'
                            + ' class="p-4 pl-20 pr-20 text-2xl font-semibold text-white bg-indigo-700 border-blue-300  rounded-2xl focus:border-4 hover:bg-indigo-900"'
                            + '>'
                            + 'View question'
                            + '</button>'
                            + '</a>'
                            + '</div>'
                            + '</div>'
                            + '</div>'
                            + '</div>'
                            + '</div>'
                    }else{

                    }
                });
                document.getElementById("meetingDialog").innerHTML = htmlDialog;
            });
       </script>
    </div>

    <!-- Dialog -->
</div>
</body>
</html>
